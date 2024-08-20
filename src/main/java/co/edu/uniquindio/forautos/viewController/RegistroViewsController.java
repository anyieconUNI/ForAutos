package co.edu.uniquindio.forautos.viewController;

import co.edu.uniquindio.forautos.controller.RegistroController;
import co.edu.uniquindio.forautos.mapping.dto.RegistroDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;

public class RegistroViewsController {
    RegistroController registroController;
    RegistroDto registroDto;
    @FXML
    public TextField txtIdentificacion;
    @FXML
    public TextField txtNombre;
    @FXML
    public TextField txtCorreo;
    @FXML
    public TextField txtTelefono;
    @FXML
    public PasswordField txtPassword;
    @FXML
    void initialize() {
        registroController = new RegistroController();
    }
    public void registrarAdmin(ActionEvent actionEvent) {
        crearRegistro();
    }
    private void crearRegistro() {
        RegistroDto registroDto1 = contruirRegistroAdmin();
        if(datosValidos(registroDto1)){
            if(registroController.agregarRegistro(registroDto1)){
                registroController.mostrarMensaje("El empleado se ha creado con éxito", "Notificación empleado", AlertType.INFORMATION);
                limpiarCamposEmpleado();
            }else{
                registroController.mostrarMensaje( "El empleado no se ha creado con éxito", "Notificación empleado", AlertType.ERROR);
            }
        }else{
            registroController.mostrarMensaje("Los datos ingresados son invalidos", "Empleado no creado", AlertType.ERROR);
        }
    }

    public void limpiarCamposEmpleado(){
        txtIdentificacion.setText("");
        txtNombre.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
        txtPassword.setText("");
    }
    private RegistroDto contruirRegistroAdmin(){
        return new RegistroDto(
                txtIdentificacion.getText(),
                txtNombre.getText(),
                txtTelefono.getText(),
                txtCorreo.getText(),
                txtPassword.getText()
        );
    }
    private boolean datosValidos(RegistroDto registroDto) {
        String mensaje = "";
        if(registroDto.nombre() == null || registroDto.nombre().equals(""))
            mensaje += "El nombre es invalido \n" ;
        if(registroDto.cedula() == null || registroDto.cedula().equals(""))
            mensaje += "El documento es invalido \n" ;
        if(mensaje.equals("")){
            return true;
        }else{
            registroController.mostrarMensaje("Notificación cliente", mensaje, AlertType.WARNING);
            return false;
        }
    }

}
