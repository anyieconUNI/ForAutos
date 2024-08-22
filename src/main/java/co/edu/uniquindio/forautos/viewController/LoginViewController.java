package co.edu.uniquindio.forautos.viewController;

import co.edu.uniquindio.forautos.controller.LoginController;
import co.edu.uniquindio.forautos.controller.ModelFactoryController;
import co.edu.uniquindio.forautos.controller.service.ILoginControllerService;
import co.edu.uniquindio.forautos.exceptions.LoginException;
import co.edu.uniquindio.forautos.mapping.dto.LoginDto;
import co.edu.uniquindio.forautos.model.Admin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.*;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginViewController implements ILoginControllerService {

    private final ModelFactoryController modelFactoryController;
    public LoginViewController(){
        this.modelFactoryController = ModelFactoryController.getInstance();
    }
    LoginController loginController;
    @FXML
    public TextField txtCorreo;
    @FXML
    public PasswordField txtPassword;
    @FXML
    public void initialize() {
        loginController = new LoginController();
    }
    public void iniciarSesionAdmin(ActionEvent actionEvent) {
        iniciarSesion();
    }
    public void iniciarSesion(){
        String correo = txtCorreo.getText();
        String contrasena = txtPassword.getText();

        if (datosValidos(correo, contrasena)) {
            LoginDto loginDto = new LoginDto(correo, contrasena);
            try {
                Admin admin = loginController.incioAdmin(loginDto);
                mostrarMensaje("Inicio de sesión", "Inicio de sesión exitoso", "Bienvenido, " + admin.getNombre(), AlertType.INFORMATION);
                if (admin != null) {
                    ModelFactoryController.getInstance().navegarVentana("ForautosView.fxml","ForAutos");
                }
            } catch (LoginException e) {
                mostrarMensaje("Inicio de sesión", "Error de inicio de sesión", e.getMessage(), Alert.AlertType.ERROR);
            }
        }
    }

    private boolean datosValidos(String correo, String contrasena) {
        String mensaje = "";
        if (correo == null || correo.isEmpty()) {
            mensaje += "El correo es inválido \n";
        }
        if (contrasena == null || contrasena.isEmpty()) {
            mensaje += "La contraseña es inválida \n";
        }
        if (mensaje.isEmpty()) {
            return true;
        } else {
            mostrarMensaje("Notificación", "Datos inválidos", mensaje, AlertType.WARNING);
            return false;
        }
    }

    private void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    @Override
    public Admin incioAdmin(LoginDto loginDto) throws LoginException {
        return null;
    }
}
