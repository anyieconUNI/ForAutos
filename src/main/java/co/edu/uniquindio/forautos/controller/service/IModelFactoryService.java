package co.edu.uniquindio.forautos.controller.service;

import co.edu.uniquindio.forautos.exceptions.LoginException;
import co.edu.uniquindio.forautos.exceptions.RegistroException;
import co.edu.uniquindio.forautos.mapping.dto.*;
import co.edu.uniquindio.forautos.model.Admin;
import javafx.scene.control.Alert;

import java.util.List;

public interface IModelFactoryService {
    List<ClienteDto> obtenerClientes();

    boolean agregarCliente(ClienteDto clienteDto);

    boolean eliminarCliente(String cedula);

    boolean actualizarCliente(String cedulaActual, ClienteDto clienteDto);

    boolean agregarEmpleado(EmpleadoDto empleadoDto);

    boolean eliminarEmpleado(String cedula);

    boolean actualizarEmpleado(String cedulaActual, EmpleadoDto empleadoDto);

    /*SE INICIA EL PROCESO DE ADMIN*/
    boolean agregarRegistroAdmin(RegistroDto registroDto);

    Admin iniciarSesion(LoginDto loginDto) throws LoginException;

    void mostrarMensaje(String titulo, String mensaje, Alert.AlertType tipo);


    /*Se inicia la cita*/
    List<CitaDto> cargarCitas();

    boolean agregarCitas(CitaDto citaDto);

    boolean actualizarCita(CitaDto citaDto);

    boolean eliminarCita(String id);
}
