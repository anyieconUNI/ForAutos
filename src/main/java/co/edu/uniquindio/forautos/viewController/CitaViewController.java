package co.edu.uniquindio.forautos.viewController;

import co.edu.uniquindio.forautos.controller.ClienteController;
import co.edu.uniquindio.forautos.controller.EmpleadoController;
import co.edu.uniquindio.forautos.mapping.dto.ClienteDto;
import co.edu.uniquindio.forautos.model.Servicio;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import co.edu.uniquindio.forautos.mapping.dto.EmpleadoDto;
import javafx.util.StringConverter;

import java.util.List;
import java.util.stream.Collectors;

public class CitaViewController {
    @FXML
    public ComboBox<Servicio> cbServicio;
    @FXML
    public ComboBox<String> cbTecnicos;

    private static CitaViewController instance;
    public ComboBox<String> cbClientes;

    private EmpleadoController empleadoController = new EmpleadoController();
    ClienteController clienteController = new ClienteController();

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
    }

    public void actualizarComboBoxTecnicos() {
        List<EmpleadoDto> empleados = empleadoController.obtenerEmpleados();
        ObservableList<String> nombresTecnicos = FXCollections.observableArrayList(
                empleados.stream().map(EmpleadoDto::getNombreCompleto).collect(Collectors.toList())
        );
        cbTecnicos.setItems(nombresTecnicos);
    }

    public void actualizarClientes(){
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
}
