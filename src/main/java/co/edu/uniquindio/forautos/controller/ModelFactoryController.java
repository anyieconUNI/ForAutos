package co.edu.uniquindio.forautos.controller;

import co.edu.uniquindio.forautos.controller.service.IModelFactoryService;
import co.edu.uniquindio.forautos.exceptions.ClienteException;
import co.edu.uniquindio.forautos.mapping.dto.ClienteDto;
import co.edu.uniquindio.forautos.mapping.mappers.ForautoMapper;
import co.edu.uniquindio.forautos.model.Cliente;
import co.edu.uniquindio.forautos.model.Forautos;
import co.edu.uniquindio.forautos.utils.ForautoUtils;

import java.util.List;

public class ModelFactoryController implements IModelFactoryService {
    Forautos forautos;
    ForautoMapper mapper = ForautoMapper.INSTANCE;
    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }
    public ModelFactoryController() {
        System.out.println("invocación clase singleton");
        cargarDatosBase();
    }
    private void cargarDatosBase() {
        forautos = ForautoUtils.inicializarDatos();
    }
    public Forautos getForautos(){
        return forautos;
    }
    @Override
    public List<ClienteDto> obtenerClientes() {
        return  mapper.getClientesDto(forautos.getListaClientes());
    }

    @Override
    public boolean agregarCliente(ClienteDto clienteDto) {
        try{
            if(!forautos.verificarClienteExistente(clienteDto.cedula())) {
                Cliente cliente = mapper.clienteDtoToCliente(clienteDto);
                getForautos().agregarCliente(cliente);
            }
            return true;
        }catch (ClienteException e){
            e.getMessage();
            return false;
        }
    }

    @Override
    public boolean eliminarCliente(String cedula) {
        boolean flagExiste = false;
        try {
            flagExiste = getForautos().eliminarCliente(cedula);
        } catch (ClienteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flagExiste;
    }

    @Override
    public boolean actualizarCliente(String cedulaActual, ClienteDto clienteDto) {
        try {
            Cliente cliente = mapper.clienteDtoToCliente(clienteDto);
            getForautos().actualizarCliente(cedulaActual, cliente);
            return true;
        } catch (ClienteException e) {
            e.printStackTrace();
            return false;
        }
    }
}
