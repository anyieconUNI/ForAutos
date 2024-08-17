package co.edu.uniquindio.forautos.controller.service;

import co.edu.uniquindio.forautos.exceptions.LoginException;
import co.edu.uniquindio.forautos.exceptions.RegistroException;
import co.edu.uniquindio.forautos.mapping.dto.ClienteDto;
import co.edu.uniquindio.forautos.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.forautos.mapping.dto.LoginDto;
import co.edu.uniquindio.forautos.mapping.dto.RegistroDto;
import co.edu.uniquindio.forautos.model.Admin;

import java.util.List;

public interface IModelFactoryService {
    List<ClienteDto> obtenerClientes();

    boolean agregarCliente(ClienteDto clienteDto);

    boolean eliminarCliente(String cedula);

    boolean actualizarCliente(String cedulaActual, ClienteDto clienteDto);

    boolean agregarEmpleado(EmpleadoDto empleadoDto);

    boolean eliminarEmpleado(String cedula);

    boolean actualizarEmpleado(String cedulaActual, EmpleadoDto empleadoDto);

    /*SE INICIA EL PRECESO DE ADMIN*/
    boolean agregarRegistroAdmin(RegistroDto registroDto);

    Admin iniciarSesion(LoginDto loginDto) throws LoginException;
}
