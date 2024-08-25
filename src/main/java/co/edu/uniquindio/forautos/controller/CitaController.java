package co.edu.uniquindio.forautos.controller;

import co.edu.uniquindio.forautos.controller.service.ICitaControllerService;
import co.edu.uniquindio.forautos.mapping.dto.CitaDto;
import co.edu.uniquindio.forautos.mapping.dto.ClienteDto;
import co.edu.uniquindio.forautos.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.forautos.viewController.CitaViewController;

import java.util.List;


public class CitaController implements ICitaControllerService {
    EmpleadoController empleadoController = new EmpleadoController();
    ClienteController clienteController = new ClienteController();
    ModelFactoryController modelFactoryController;
    public CitaController(){
        modelFactoryController = ModelFactoryController.getInstance();
    }

    @Override
    public List<EmpleadoDto> obtenerEmpleados() {
        List<EmpleadoDto> empleados = empleadoController.obtenerEmpleados();
        CitaViewController.getInstance().actualizarComboBoxTecnicos();
//        System.out.println("Técnicos : " + empleados);
        return empleados;
    }
    @Override
    public List<ClienteDto> obtenerClientes(){
        List<ClienteDto> clienteDtos = clienteController.obtenerClientes();
        System.out.println("Clientes : " + clienteDtos);
        CitaViewController.getInstance().actualizarClientes();
        return clienteDtos;
    }

    @Override
    public void llenarServicios() {
        CitaViewController.getInstance().llenarServicios();
    }
    @Override
    public void llenarCiudades(){
        CitaViewController.getInstance().llenarCiudades();
    }

    public List<CitaDto> cargarCitas() {
        return modelFactoryController.cargarCitas();
    }
    @Override
    public boolean agregarCita(CitaDto citaDto) {
        return modelFactoryController.agregarCitas(citaDto);
    }

    @Override
    public boolean actualizarCita(CitaDto citaDto) {
        return modelFactoryController.actualizarCita(citaDto);
    }
    @Override
    public boolean eliminarCita(String id){
        return modelFactoryController.eliminarCita(id);
    }
}
