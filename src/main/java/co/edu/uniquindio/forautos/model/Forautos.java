package co.edu.uniquindio.forautos.model;

import co.edu.uniquindio.forautos.exceptions.ClienteException;
import co.edu.uniquindio.forautos.model.services.IForautosService;

import java.util.ArrayList;

public class Forautos implements IForautosService {
    private static final long serialVersionUID = 1L;
    ArrayList<Cliente> listaClientes = new ArrayList<>();

    public Forautos(){

    }

    public ArrayList<Cliente> getListaClientes(){
        return listaClientes;
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
}
