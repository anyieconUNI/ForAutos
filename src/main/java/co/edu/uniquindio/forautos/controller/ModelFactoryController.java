package co.edu.uniquindio.forautos.controller;

import co.edu.uniquindio.forautos.ForautoApp;
import co.edu.uniquindio.forautos.controller.service.IModelFactoryService;
import co.edu.uniquindio.forautos.exceptions.ClienteException;
import co.edu.uniquindio.forautos.exceptions.EmpleadoException;
import co.edu.uniquindio.forautos.exceptions.LoginException;
import co.edu.uniquindio.forautos.exceptions.RegistroException;
import co.edu.uniquindio.forautos.mapping.dto.ClienteDto;
import co.edu.uniquindio.forautos.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.forautos.mapping.dto.LoginDto;
import co.edu.uniquindio.forautos.mapping.dto.RegistroDto;
import co.edu.uniquindio.forautos.mapping.mappers.ForautoMapper;
import co.edu.uniquindio.forautos.model.Admin;
import co.edu.uniquindio.forautos.model.Cliente;
import co.edu.uniquindio.forautos.model.Empleado;
import co.edu.uniquindio.forautos.model.Forautos;
import co.edu.uniquindio.forautos.utils.ForautoUtils;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

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
    
    /*SE INICIA LA SECCIÓN DE LOS EMPLEADOS*/
    public List<EmpleadoDto> obtenerEmpleados() {
        return  mapper.getEmpleadosDto(forautos.getListaEmpleados());
    }

    @Override
    public boolean agregarEmpleado(EmpleadoDto empleadoDto) {
        try{
            if(!forautos.verificarEmpleadoExistente(empleadoDto.cedula())) {
                Empleado empleado = mapper.empleadoDtoToEmpleado(empleadoDto);
                getForautos().agregarEmpleado(empleado);
            }
            return true;
        }catch (EmpleadoException e){
            e.getMessage();
            return false;
        }
    }

    @Override
    public boolean eliminarEmpleado(String cedula) {
        boolean flagExiste = false;
        try {
            flagExiste = getForautos().eliminarEmpleado(cedula);
        } catch (EmpleadoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flagExiste;
    }

    @Override
    public boolean actualizarEmpleado(String cedulaActual, EmpleadoDto empleadoDto) {
        try {
            Empleado empleado = mapper.empleadoDtoToEmpleado(empleadoDto);
            getForautos().actualizarEmpleado(cedulaActual, empleado);
            return true;
        } catch (EmpleadoException e) {
            e.printStackTrace();
            return false;
        }
    }
    /*SE INICIA EL PRECESO DE ADMIN*/
    @Override
    public boolean agregarRegistroAdmin(RegistroDto registroDto) {
        try {
            if (!forautos.verificarRegistroExistente(registroDto.cedula())) {
                Admin admin = mapper.RegistroDtoToAdmin(registroDto);
                getForautos().agregarRegistrosAdmin(admin);
            }
            return true;
        } catch (RegistroException e) {
            e.getMessage();
            return false;
        }
    }
    @Override
    public Admin iniciarSesion(LoginDto loginDto) throws LoginException {
        Admin admin = getForautos().buscarAdminEmail(loginDto.email());
        if (admin != null && admin.getContrasena().equals(loginDto.contrasena())) {
            return admin;
        } else {
            throw new LoginException("Email o contraseña incorrecta");
        }
    }

    public FXMLLoader navegarVentana(String nombreArchivoFxml, String tituloVentana) {
        try {

            // Cargar la vista
            FXMLLoader loader = new FXMLLoader( ForautoApp.class.getResource(nombreArchivoFxml));
            Parent root = loader.load();

            // Crear la escena
            Scene scene = new Scene(root);

            // Crear un nuevo escenario (ventana)
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle(tituloVentana);

            // Mostrar la nueva ventana
            stage.show();
            return loader;

        } catch (Exception e) {
            e.printStackTrace();
            mostrarMensaje("Error al cargar la ventana", "No se pudo cargar " + nombreArchivoFxml, Alert.AlertType.ERROR);
        }
        return null;
    }

    @Override
    public void mostrarMensaje(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
