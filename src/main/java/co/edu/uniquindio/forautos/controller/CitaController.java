package co.edu.uniquindio.forautos.controller;

import co.edu.uniquindio.forautos.controller.service.ICitaControllerService;
import co.edu.uniquindio.forautos.mapping.dto.ClienteDto;
import co.edu.uniquindio.forautos.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.forautos.model.Servicio;
import co.edu.uniquindio.forautos.viewController.CitaViewController;

import java.util.List;


public class CitaController implements ICitaControllerService {
    EmpleadoController empleadoController = new EmpleadoController();
    ClienteController clienteController = new ClienteController();

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

}
