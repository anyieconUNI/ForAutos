package co.edu.uniquindio.forautos.viewController;

import co.edu.uniquindio.forautos.controller.CitaController;
import co.edu.uniquindio.forautos.controller.ClienteController;
import co.edu.uniquindio.forautos.mapping.dto.ClienteDto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Optional;

public class ClienteViews {
    ClienteController clienteController;
    ObservableList<ClienteDto> listaClientesDto = FXCollections.observableArrayList();
    CitaController citaController = new CitaController();

    ClienteDto clienteDtoSeleccionado;
    @FXML
    public TextField txtNombre;
    @FXML
    public TextField txtApellido;
    @FXML
    public TextField txtCedula;
    @FXML
    public TextField txtTelefono;
    @FXML
    public Button btnActualizar;
    @FXML
    public Button btnNuevo;
    @FXML
    public Button btnAgregar;
    @FXML
    public TableView<ClienteDto> tableClients;
    @FXML
    public TableColumn<ClienteDto, String> tcNombre;
    @FXML
    public TableColumn<ClienteDto, String>  tcApellido;
    @FXML
    public TableColumn<ClienteDto, String>  tcCedula;
    @FXML
    public TableColumn<ClienteDto, String>  tcTelefono;

    @FXML
    void initialize() {
        clienteController = new ClienteController();
        intiView();
    }

    private void intiView(){
        initDataBinding();
        obtenerClientes();
        tableClients.getItems().clear();
        tableClients.setItems(listaClientesDto);
        listenerSelection();
    }
    private void initDataBinding() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        tcApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().apellido()));
        tcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cedula()));
        tcTelefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().telefono()));
    }
        private void obtenerClientes() {
        listaClientesDto.addAll(clienteController.obtenerClientes());
    }
    private void listenerSelection() {
        tableClients.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            clienteDtoSeleccionado = newSelection;
            mostrarInformacionCliente(clienteDtoSeleccionado);
        });
    }
    private void mostrarInformacionCliente(ClienteDto clienteSeleccionado) {
        if(clienteSeleccionado != null){
            txtNombre.setText(clienteSeleccionado.nombre());
            txtApellido.setText(clienteSeleccionado.apellido());
            txtCedula.setText(clienteSeleccionado.cedula());
            txtTelefono.setText(clienteSeleccionado.telefono());
        }
    }
    public void agregarClienteAction(ActionEvent actionEvent) {
        crearCliente();
    }
    private void crearCliente() {
        //1. Capturar los datos
        ClienteDto clienteDto = construirClienteDto();
        //2. Validar la información
        if(datosValidos(clienteDto)){
            if(clienteController.agregarCliente(clienteDto)){
                listaClientesDto.add(clienteDto);
                mostrarMensaje("Notificación Cliente", "Cliente creado", "El Cliente se ha creado con éxito", Alert.AlertType.INFORMATION);
                limpiarCamposCliente();
                citaController.obtenerClientes();
            }else{
                mostrarMensaje("Notificación Cliente", "Cliente no creado", "El Cliente no se ha creado con éxito", Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje("Notificación Cliente", "Cliente no creado", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
        }

    }
    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }
    private void limpiarCamposCliente() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtCedula.setText("");
        txtTelefono.setText("");
    }

    private ClienteDto construirClienteDto(){
        return new ClienteDto(
                txtNombre.getText(),
                txtApellido.getText(),
                txtCedula.getText(),
                txtTelefono.getText()
        );
    }
    private boolean datosValidos(ClienteDto clienteDto) {
        String mensaje = "";
        if(clienteDto.nombre() == null || clienteDto.nombre().equals(""))
            mensaje += "El nombre es invalido \n" ;
        if(clienteDto.apellido() == null || clienteDto.apellido() .equals(""))
            mensaje += "El apellido es invalido \n" ;
        if(clienteDto.cedula() == null || clienteDto.cedula().equals(""))
            mensaje += "El documento es invalido \n" ;
        if(mensaje.equals("")){
            return true;
        }else{
            mostrarMensaje("Notificación cliente","Datos invalidos",mensaje, Alert.AlertType.WARNING);
            return false;
        }
    }

    public void actualizarClienteAction(ActionEvent actionEvent) {
        actualizarCliente();
    }
    private void actualizarCliente() {
        boolean clienteActualizado = false;
        String cedulaActual = clienteDtoSeleccionado.cedula();
        ClienteDto clienteDto = construirClienteDto();
        if(clienteDto != null){
            if(datosValidos(clienteDto)){
                clienteActualizado = clienteController.actualizarCliente(cedulaActual,clienteDto);
                if(clienteActualizado){
                    listaClientesDto.remove(clienteDtoSeleccionado);
                    listaClientesDto.add(clienteDto);
                    tableClients.refresh();
                    mostrarMensaje("Notificación Cliente", "Cliente actualizado", "El Cliente se ha actualizado con éxito", Alert.AlertType.INFORMATION);
                    limpiarCamposCliente();
                    citaController.obtenerClientes();
                }else{
                    mostrarMensaje("Notificación Cliente", "Cliente no actualizado", "El Cliente no se ha actualizado con éxito", Alert.AlertType.INFORMATION);
                }
            }else{
                mostrarMensaje("Notificación Cliente", "Cliente no creado", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
            }

        }
    }
    public void limpiarClienteAction(ActionEvent actionEvent) {
        limpiarCamposCliente();
    }

    public void eliminarClienteAction(ActionEvent actionEvent) {
        eliminarCliente();
    }
    private void eliminarCliente() {
        boolean clienteEliminado = false;
        if(clienteDtoSeleccionado != null){
            if(mostrarMensajeConfirmacion("¿Estas seguro de elmininar al Cliente?")){
                clienteEliminado = clienteController.eliminarCliente(clienteDtoSeleccionado.cedula());
                if(clienteEliminado == true){
                    listaClientesDto.remove(clienteDtoSeleccionado);
                    clienteDtoSeleccionado = null;
                    tableClients.getSelectionModel().clearSelection();
                    limpiarCamposCliente();
                    citaController.obtenerClientes();
                    mostrarMensaje("Notificación Cliente", "Cliente eliminado", "El Cliente se ha eliminado con éxito", Alert.AlertType.INFORMATION);
                }else{
                    mostrarMensaje("Notificación Cliente", "Cliente no eliminado", "El Cliente no se puede eliminar", Alert.AlertType.ERROR);
                }
            }
        }else{
            mostrarMensaje("Notificación Cliente", "Cliente no seleccionado", "Seleccionado un Cliente de la lista", Alert.AlertType.WARNING);
        }
    }
    private boolean mostrarMensajeConfirmacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText(mensaje);
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }
}
