package co.edu.uniquindio.forautos.model.services;

import co.edu.uniquindio.forautos.exceptions.ClienteException;
import co.edu.uniquindio.forautos.exceptions.EmpleadoException;
import co.edu.uniquindio.forautos.model.Cliente;
import co.edu.uniquindio.forautos.model.Empleado;

import java.util.ArrayList;

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
}
