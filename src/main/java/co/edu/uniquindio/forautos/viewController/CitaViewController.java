package co.edu.uniquindio.forautos.viewController;

import co.edu.uniquindio.forautos.controller.CitaController;
import co.edu.uniquindio.forautos.controller.ClienteController;
import co.edu.uniquindio.forautos.controller.EmpleadoController;
import co.edu.uniquindio.forautos.mapping.dto.CitaDto;
import co.edu.uniquindio.forautos.mapping.dto.ClienteDto;
import co.edu.uniquindio.forautos.model.Cita;
import co.edu.uniquindio.forautos.model.Ciudad;
import co.edu.uniquindio.forautos.model.Servicio;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import co.edu.uniquindio.forautos.mapping.dto.EmpleadoDto;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class CitaViewController {
    private EmpleadoController empleadoController = new EmpleadoController();
    ClienteController clienteController = new ClienteController();
    ObservableList<CitaDto> listaCitaDto = FXCollections.observableArrayList();
    CitaController citaController = new CitaController();
    CitaDto citaDtoSeleccionado;
    @FXML
    public ComboBox<Servicio> cbServicio;
    @FXML
    public ComboBox<String> cbTecnicos;
    @FXML
    public ComboBox<Ciudad> cbCiudad;

    private static CitaViewController instance;
    public ComboBox<String> cbClientes;
    @FXML
    public TableView<CitaDto> tablaCita;
    @FXML
    public TableColumn<CitaDto, String> tbHora;
    @FXML
    public TableColumn<CitaDto, String> tbCliente;
    @FXML
    public TableColumn<CitaDto, String> tbFecha;
    @FXML
    public TableColumn<CitaDto, String> tbCiudad;
    @FXML
    public TableColumn<CitaDto, String> tbTecnico;
    @FXML
    public TableColumn<CitaDto, String> tbTipo;
    @FXML
    public DatePicker Fecha;
    @FXML
    public TextField hora;


    public CitaViewController() {
        if (instance == null) {
            instance = this;
        }
    }

    public static CitaViewController getInstance() {
        return instance;
    }


    @FXML
    private void initialize() {
        actualizarComboBoxTecnicos();
        actualizarClientes();
        llenarServicios();
        llenarCiudades();
        initDataBinding();
        obtenerCitas();
        tablaCita.setItems(listaCitaDto);
        listenerSelection();
    }


    public void actualizarComboBoxTecnicos() {
        List<EmpleadoDto> empleados = empleadoController.obtenerEmpleados();
        ObservableList<String> nombresTecnicos = FXCollections.observableArrayList(
                empleados.stream().map(EmpleadoDto::getNombreCompleto).collect(Collectors.toList())
        );
        cbTecnicos.setItems(nombresTecnicos);
    }

    public void actualizarClientes() {
        List<ClienteDto> clientes = clienteController.obtenerClientes();
        ObservableList<String> nombresClientes = FXCollections.observableArrayList(
                clientes.stream().map(ClienteDto::getNombreCompleto).collect(Collectors.toList())
        );
        cbClientes.setItems(nombresClientes);
    }

    public void llenarServicios() {
        if (cbServicio != null) {
            cbServicio.getItems().addAll(Servicio.values());
            cbServicio.setConverter(new StringConverter<Servicio>() {
                @Override
                public String toString(Servicio servicio) {
                    if (servicio != null) {
                        return servicio.getNombre() + " - $" + servicio.getPrecio();
                    } else {
                        return "";
                    }
                }

                @Override
                public Servicio fromString(String string) {
                    return null;
                }
            });
        }
    }

    public void llenarCiudades() {
        if (cbCiudad != null) {
            cbCiudad.getItems().addAll(Ciudad.values());
            cbCiudad.setConverter(new StringConverter<Ciudad>() {
                @Override
                public String toString(Ciudad ciudad) {
                    return ciudad != null ? ciudad.name() : "";
                }

                @Override
                public Ciudad fromString(String string) {
                    return null;
                }
            });
        }
    }
    @FXML
    private void agregarCitas(ActionEvent actionEvent) {
        agregarCita();
    }

    private void agregarCita() {
        if (validarCampos()) {
            CitaDto citaDto = buildCitaDto();
            if (citaController.agregarCita(citaDto)) {
                mostrarMensaje("Éxito", "Cita agregada correctamente.", Alert.AlertType.INFORMATION);
                listaCitaDto.clear();
                obtenerCitas();
                limpiar();
            } else {
                mostrarMensaje("Error", "No se pudo agregar la cita.", Alert.AlertType.ERROR);
            }
        }
    }

    private boolean validarCampos() {
        if (cbClientes.getValue() == null || cbServicio.getValue() == null ||
                Fecha.getValue() == null || hora.getText().isEmpty() ||
                cbCiudad.getValue() == null || cbTecnicos.getValue() == null) {
            mostrarMensaje("Validación", "Todos los campos deben estar llenos.", Alert.AlertType.WARNING);
            return false;
        }
        return true;
    }

    private CitaDto buildCitaDto() {
        String id = (citaDtoSeleccionado != null) ? citaDtoSeleccionado.id() : null;
        return new CitaDto(
                id,
                cbClientes.getValue(),
                cbServicio.getValue().toString(),
                Fecha.getValue().toString(),
                hora.getText(),
                cbCiudad.getValue().toString(),
                cbTecnicos.getValue()
        );
    }
    public void actualizarCita(){
        if (citaDtoSeleccionado != null && validarCampos()) {
            CitaDto citaDtoActualizada = buildCitaDto();
            System.out.println("ID de la cita a actualizar: " + citaDtoActualizada.id());
            if (citaController.actualizarCita(citaDtoActualizada)) {
                mostrarMensaje("Éxito", "Cita actualizada correctamente.", Alert.AlertType.INFORMATION);
                listaCitaDto.clear();
                obtenerCitas();
                tablaCita.refresh();
                limpiar();
            } else {
                mostrarMensaje("Error", "No se pudo actualizar la cita.", Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje("Error", "Debe seleccionar una cita para actualizar.", Alert.AlertType.WARNING);
        }
    }

    private void initDataBinding() {
        tbHora.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().hora()));
        tbCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().clientes()));
        tbFecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().fecha()));
        tbCiudad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().ciudad()));
        tbTecnico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().empleados()));
        tbTipo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().servicio()));
    }

    private void obtenerCitas() {
        List<CitaDto> citas = citaController.cargarCitas();
        System.out.println("Citas cargadas: " + citas.size()); // Agrega esta línea para depuración
        listaCitaDto.addAll(citas);
    }

    private void listenerSelection() {
        tablaCita.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            citaDtoSeleccionado = newSelection;
            mostrarInformacionCita(citaDtoSeleccionado);
        });
    }
    private void mostrarInformacionCita(CitaDto citaDtoSelecci) {
        if (citaDtoSelecci != null) {
            cbClientes.setValue(citaDtoSelecci.clientes());
            cbCiudad.setValue(Ciudad.valueOf(citaDtoSelecci.ciudad().toUpperCase()));
            cbServicio.setValue(Servicio.valueOf(citaDtoSelecci.servicio()));
            cbTecnicos.setValue(citaDtoSelecci.empleados());

            Fecha.setValue(LocalDate.parse(citaDtoSelecci.fecha()));
            hora.setText(citaDtoSelecci.hora());

            Tooltip fechaTooltip = new Tooltip(citaDtoSelecci.fecha());
            Fecha.setTooltip(fechaTooltip);
        }
    }

    public void actualizarCitas(ActionEvent actionEvent) {
        actualizarCita();
    }
    public void eliminarClienteAction(ActionEvent actionEvent) {
        eliminarCita();
    }
    private void eliminarCita() {
        if (citaDtoSeleccionado != null) {
            boolean eliminado = citaController.eliminarCita(citaDtoSeleccionado.id());
            if (eliminado) {
                mostrarMensaje("Éxito", "Cita eliminada correctamente.", Alert.AlertType.INFORMATION);
                listaCitaDto.clear();
                obtenerCitas();
                limpiar();
            } else {
                mostrarMensaje("Error", "No se pudo eliminar la cita.", Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje("Error", "Debe seleccionar una cita para eliminar.", Alert.AlertType.WARNING);
        }
    }
    public void limpiar() {
        cbClientes.setValue(null);
        cbServicio.setValue(null);
        cbCiudad.setValue(null);
        cbTecnicos.setValue(null);
        Fecha.setValue(null);
        hora.setText("");
    }

    private void mostrarMensaje(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }



}
