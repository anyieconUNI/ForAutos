package co.edu.uniquindio.forautos.controller;

import co.edu.uniquindio.forautos.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.forautos.viewController.CitaViewController;

import java.util.List;


public class CitaController {
    EmpleadoController empleadoController = new EmpleadoController();

    public List<EmpleadoDto> obtenerEmpleados() {
        List<EmpleadoDto> empleados = empleadoController.obtenerEmpleados();
        System.out.println("Técnicos : " + empleados);
        return empleados;


    }
}
