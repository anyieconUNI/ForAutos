package co.edu.uniquindio.forautos.viewController;

import co.edu.uniquindio.forautos.controller.ClienteController;
import co.edu.uniquindio.forautos.controller.EmpleadoController;
import co.edu.uniquindio.forautos.mapping.dto.ClienteDto;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import co.edu.uniquindio.forautos.mapping.dto.EmpleadoDto;

import java.util.List;
import java.util.stream.Collectors;

public class CitaViewController {
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
}
