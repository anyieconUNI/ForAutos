package co.edu.uniquindio.forautos.controller;

import co.edu.uniquindio.forautos.controller.service.IClienteControllerService;
import co.edu.uniquindio.forautos.mapping.dto.ClienteDto;

import java.util.List;

public class ClienteController implements IClienteControllerService {
    ModelFactoryController modelFactoryController;

    public ClienteController(){
        modelFactoryController = ModelFactoryController.getInstance();
    }

    public List<ClienteDto> obtenerClientes(){
        return modelFactoryController.obtenerClientes();
    }

    @Override
    public boolean agregarCliente(ClienteDto clienteDto) {
        return modelFactoryController.agregarCliente(clienteDto);
    }

    @Override
    public boolean eliminarCliente(String cedula) {
        return modelFactoryController.eliminarCliente(cedula);
    }

    @Override
    public boolean actualizarCliente(String cedulaActual, ClienteDto clienteDto) {
        return modelFactoryController.actualizarCliente(cedulaActual, clienteDto);
    }

}
