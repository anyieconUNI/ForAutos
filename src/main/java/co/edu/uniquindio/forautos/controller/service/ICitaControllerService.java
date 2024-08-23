package co.edu.uniquindio.forautos.controller.service;

import co.edu.uniquindio.forautos.mapping.dto.ClienteDto;
import co.edu.uniquindio.forautos.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.forautos.model.Servicio;

import java.util.List;

public interface ICitaControllerService {
    List<EmpleadoDto> obtenerEmpleados();

    List<ClienteDto> obtenerClientes();
    void llenarServicios();
    void llenarCiudades();
}
