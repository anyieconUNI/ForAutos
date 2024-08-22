package co.edu.uniquindio.forautos.viewController;

import co.edu.uniquindio.forautos.controller.CitaController;
import co.edu.uniquindio.forautos.controller.EmpleadoController;
import co.edu.uniquindio.forautos.controller.ModelFactoryController;
import co.edu.uniquindio.forautos.mapping.dto.EmpleadoDto;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class CitaViewController {
    @FXML
    public ComboBox<String> cbTecnicos;

    private CitaController citaController = new CitaController();
    EmpleadoController empleadoController = new EmpleadoController();

    @FXML
    private void initialize() {
        cbTecnicos.setItems(FXCollections.observableArrayList("Técnico 1", "Técnico 2"));
        initTecnicosComboBox();
    }

    public void initTecnicosComboBox() {
//        ObservableList<String> nombresTecnicos = FXCollections.observableArrayList(
//                obtenerEmpleados().stream()
//                        .map(t -> t.getNombreCompleto())
//                        .toList()
//        );
//        cbTecnicos.setItems(nombresTecnicos);
        obtenerEmpleados();
    }



    public void obtenerEmpleados() {
        try {

            List<EmpleadoDto> empleados = empleadoController.obtenerEmpleados();
            System.out.println("Técnicos recuperados: " + empleados);
                ObservableList<String> nombresTecnicos = empleados.stream()
                        .map(EmpleadoDto::getNombreCompleto)
                        .collect(Collectors.toCollection(FXCollections::observableArrayList));
                cbTecnicos.setItems(nombresTecnicos);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
