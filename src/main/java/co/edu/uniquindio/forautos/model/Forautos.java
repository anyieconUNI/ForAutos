package co.edu.uniquindio.forautos.model;

import co.edu.uniquindio.forautos.exceptions.CitaException;
import co.edu.uniquindio.forautos.exceptions.ClienteException;
import co.edu.uniquindio.forautos.exceptions.EmpleadoException;
import co.edu.uniquindio.forautos.exceptions.RegistroException;
import co.edu.uniquindio.forautos.model.services.IForautosService;

import java.util.ArrayList;
import java.util.List;

public class Forautos implements IForautosService {

    ArrayList<Cliente> listaClientes = new ArrayList<>();
    ArrayList<Empleado> listaEmpleados = new ArrayList<>();
    ArrayList<Admin> listaAdmins = new ArrayList<>();
    ArrayList<Cita> listaCitas = new ArrayList<>();
    public Forautos(){

    }

    public ArrayList<Cliente> getListaClientes(){
        return listaClientes;
    }
    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }
    public ArrayList<Cita> getListaCita(){
        return listaCitas;
    }
    public ArrayList<Admin> getListaAdmins() {
        return listaAdmins;
    }
    public void agregarCliente(Cliente nuevoCliente) throws ClienteException{
        getListaClientes().add(nuevoCliente);
    }
    @Override
    public boolean verificarClienteExistente(String cedula) throws ClienteException {
        if(clienteExiste(cedula)){
            throw new ClienteException("El empleado con cedula: "+cedula+" ya existe");
        }else{
            return false;
        }
    }
    public boolean clienteExiste(String cedula) {
        boolean clienteEncontrado = false;
        for (Cliente cliente : getListaClientes()) {
            if(cliente.getCedula().equalsIgnoreCase(cedula)){
                clienteEncontrado = true;
                break;
            }
        }
        return clienteEncontrado;
    }
    @Override
    public Boolean eliminarCliente(String cedula) throws ClienteException {
        Cliente cliente = null;
        boolean flagExiste = false;
        cliente = obtenerCliente(cedula);
        if(cliente == null)
            throw new ClienteException("El empleado a eliminar no existe");
        else{
            getListaClientes().remove(cliente);
            flagExiste = true;
        }
        return flagExiste;
    }
    @Override
    public Cliente obtenerCliente(String cedula) {
        Cliente clienteEncontrado = null;
        for (Cliente cliente : getListaClientes()) {
            if(cliente.getCedula().equalsIgnoreCase(cedula)){
                clienteEncontrado = cliente;
                break;
            }
        }
        return clienteEncontrado;
    }
    @Override
    public void actualizarCliente(String cedulaActual, Cliente cliente) throws ClienteException {
        Cliente clienteActual = obtenerCliente(cedulaActual);
        if(clienteActual == null)
            throw new ClienteException("El empleado a actualizar no existe");
        else{
            clienteActual.setNombre(cliente.getNombre());
            clienteActual.setApellido(cliente.getApellido());
            clienteActual.setCedula(cliente.getCedula());
            clienteActual.setTelefono(cliente.getTelefono());
        }
    }

    /*SE INICIAN LOS EMPLEADOS*/
    @Override
    public Empleado crearEmpleado(String nombre, String apellido, String cedula, String fechaNacimiento) throws EmpleadoException{
        Empleado nuevoEmpleado = null;
        boolean empleadoExiste = verificarEmpleadoExistente(cedula);
        if(empleadoExiste){
            throw new EmpleadoException("El empleado con cedula: "+cedula+" ya existe");
        }else{
            nuevoEmpleado = new Empleado();
            nuevoEmpleado.setNombre(nombre);
            nuevoEmpleado.setApellido(apellido);
            nuevoEmpleado.setCedula(cedula);
            getListaEmpleados().add(nuevoEmpleado);
        }
        return nuevoEmpleado;
    }

    public void agregarEmpleado(Empleado nuevoEmpleado) throws EmpleadoException{
        getListaEmpleados().add(nuevoEmpleado);
    }

    @Override
    public boolean actualizarEmpleado(String cedulaActual, Empleado empleado) throws EmpleadoException {
        Empleado empleadoActual = obtenerEmpleado(cedulaActual);
        if(empleadoActual == null)
            throw new EmpleadoException("El empleado a actualizar no existe");
        else{
            empleadoActual.setNombre(empleado.getNombre());
            empleadoActual.setApellido(empleado.getApellido());
            empleadoActual.setCedula(empleado.getCedula());
            empleadoActual.setTelefono(empleado.getTelefono());
            return true;
        }
    }

    @Override
    public Boolean eliminarEmpleado(String cedula) throws EmpleadoException {
        Empleado empleado = null;
        boolean flagExiste = false;
        empleado = obtenerEmpleado(cedula);
        if(empleado == null)
            throw new EmpleadoException("El empleado a eliminar no existe");
        else{
            getListaEmpleados().remove(empleado);
            flagExiste = true;
        }
        return flagExiste;
    }

    @Override
    public boolean verificarEmpleadoExistente(String cedula) throws EmpleadoException {
        if(empleadoExiste(cedula)){
            throw new EmpleadoException("El empleado con cedula: "+cedula+" ya existe");
        }else{
            return false;
        }
    }


    @Override
    public Empleado obtenerEmpleado(String cedula) {
        Empleado empleadoEncontrado = null;
        for (Empleado empleado : getListaEmpleados()) {
            if(empleado.getCedula().equalsIgnoreCase(cedula)){
                empleadoEncontrado = empleado;
                break;
            }
        }
        return empleadoEncontrado;
    }

    @Override
    public ArrayList<Empleado> obtenerEmpleados() {
        return getListaEmpleados();
    }

    public boolean empleadoExiste(String cedula) {
        boolean empleadoEncontrado = false;
        for (Empleado empleado : getListaEmpleados()) {
            if(empleado.getCedula().equalsIgnoreCase(cedula)){
                empleadoEncontrado = true;
                break;
            }
        }
        return empleadoEncontrado;
    }
    /*Se inicia Registro de Admins*/
    public void agregarRegistrosAdmin(Admin nuevoAdmin) throws RegistroException{
        getListaAdmins().add(nuevoAdmin);
    }
    @Override
    public boolean verificarRegistroExistente(String cedula) throws RegistroException {
        if(registroExiste(cedula)){
            throw new RegistroException("El empleado con cedula: "+cedula+" ya existe");
        }else{
            return false;
        }
    }

    public boolean registroExiste(String cedula) {
        boolean registroEncontrado = false;
        for (Admin admin : getListaAdmins()) {
            if(admin.getCedula().equalsIgnoreCase(cedula)){
                registroEncontrado = true;
                break;
            }
        }
        return registroEncontrado;
    }

    public Admin buscarAdminEmail(String email) {
        for (Admin admin : getListaAdmins()) {
            if (admin.getEmail().equalsIgnoreCase(email)) {
                return admin;
            }
        }
        return null;
    }

    /*Se inicia la cita*/
    public ArrayList<Cita> getListaCitas() {
        return listaCitas;
    }

    public boolean agregarCita(Cita nuevoCita) throws CitaException {
        getListaCita().add(nuevoCita);
        System.out.println("ID de la cita agregada : " + nuevoCita.getId());
        return false;
    }
    @Override
    public Cita crearCita(List<Cliente> clientes, Servicio servicio, String fecha, String hora, Ciudad ciudad, List<Empleado> empleados) throws CitaException{
        Cita nuevaCita = null;
        nuevaCita = new Cita();
        nuevaCita.setId(nuevaCita.generarId());
        nuevaCita.setClientes((Cliente) clientes);
        nuevaCita.setServicio(servicio);
        nuevaCita.setFecha(fecha);
        nuevaCita.setHora(hora);
        nuevaCita.setCiudad(ciudad);
        nuevaCita.setEmpleados((Empleado) empleados);
        getListaCita().add(nuevaCita);
        return nuevaCita;
    }
    @Override
    public boolean actualizarCita(Cita citaActualizada) throws CitaException {
        Cita citaExistente = obtenerCitaPorId(citaActualizada.getId());
        System.out.println("ID de la cita a actualizar: " + citaActualizada.getId());
        if (citaExistente != null) {
            citaExistente.setClientes(citaActualizada.getClientes());
            citaExistente.setServicio(citaActualizada.getServicio());
            citaExistente.setFecha(citaActualizada.getFecha());
            citaExistente.setHora(citaActualizada.getHora());
            citaExistente.setCiudad(citaActualizada.getCiudad());
            citaExistente.setEmpleados(citaActualizada.getEmpleados());
            return true;
        } else {
            System.out.println("NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
            return false;
        }
    }


    public Cita obtenerCitaPorId(String id) {
        for (Cita cita : getListaCitas()) {
            // Verifica que el ID no sea nulo antes de compararlo
            if (cita.getId() != null && cita.getId().equals(id)) {
                System.out.println("Cita encontrada: " + cita);
                return cita;
            }
        }
        System.out.println("No se encontró ninguna cita con el ID dado.");
        return null;
    }

    @Override
    public boolean eliminarCita(String id) throws CitaException {
        Cita citaExistente = obtenerCitaPorId(id);
        if (citaExistente != null) {
            getListaCitas().remove(citaExistente);
            System.out.println("Cita con ID " + id + " eliminada.");
            return true;
        } else {
            System.out.println("No se pudo encontrar la cita con ID " + id + " para eliminar.");
            return false;
        }
    }
}
