package co.edu.uniquindio.forautos.controller;

import co.edu.uniquindio.forautos.controller.service.ICitaControllerService;
import co.edu.uniquindio.forautos.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.forautos.viewController.CitaViewController;

import java.util.List;


public class CitaController implements ICitaControllerService {
    EmpleadoController empleadoController = new EmpleadoController();
    @Override
    public List<EmpleadoDto> obtenerEmpleados() {
        List<EmpleadoDto> empleados = empleadoController.obtenerEmpleados();
        CitaViewController.getInstance().actualizarComboBoxTecnicos();
        System.out.println("Técnicos : " + empleados);
        return empleados;


    }
}
