package co.edu.uniquindio.forautos.model.services;

import co.edu.uniquindio.forautos.exceptions.CitaException;
import co.edu.uniquindio.forautos.exceptions.ClienteException;
import co.edu.uniquindio.forautos.exceptions.EmpleadoException;
import co.edu.uniquindio.forautos.exceptions.RegistroException;
import co.edu.uniquindio.forautos.mapping.dto.CitaDto;
import co.edu.uniquindio.forautos.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface IForautosService {
    boolean verificarClienteExistente(String cedula) throws  ClienteException;

    Boolean eliminarCliente(String cedula) throws ClienteException;

    Cliente obtenerCliente(String cedula);

    void actualizarCliente(String cedulaActual, Cliente cliente) throws ClienteException;

    /*SE INICIAN LOS EMPLEADOS*/
    Empleado crearEmpleado(String nombre, String apellido, String cedula, String fechaNacimiento) throws EmpleadoException;

    boolean actualizarEmpleado(String cedulaActual, Empleado empleado) throws EmpleadoException;

    Boolean eliminarEmpleado(String cedula) throws EmpleadoException;

    boolean verificarEmpleadoExistente(String cedula) throws EmpleadoException;

    Empleado obtenerEmpleado(String cedula);

    ArrayList<Empleado> obtenerEmpleados();

    boolean verificarRegistroExistente(String cedula) throws RegistroException;

    Cita crearCita(List<Cliente> clientes, Servicio servicio, String fecha, String hora, Ciudad ciudad, List<Empleado> empleados) throws CitaException;

    boolean actualizarCita(Cita citaActualizada)throws CitaException ;

    boolean eliminarCita(String id) throws CitaException;
}
