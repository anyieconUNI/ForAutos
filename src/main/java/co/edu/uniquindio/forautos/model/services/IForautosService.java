package co.edu.uniquindio.forautos.model.services;

import co.edu.uniquindio.forautos.exceptions.ClienteException;
import co.edu.uniquindio.forautos.model.Cliente;

public interface IForautosService {
    boolean verificarClienteExistente(String cedula) throws  ClienteException;

    Boolean eliminarCliente(String cedula) throws ClienteException;

    Cliente obtenerCliente(String cedula);

    void actualizarCliente(String cedulaActual, Cliente cliente) throws ClienteException;
}
