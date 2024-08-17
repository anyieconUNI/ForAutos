package co.edu.uniquindio.forautos.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.*;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.util.Objects;

public class HomeViewsController {

//    @FXML
//    public void iniciarSesi(ActionEvent actionEvent) {
//        navegarVentana("Login.fxml", "INICIO");
//    }
//
//    @FXML
//    public void registrarse(ActionEvent actionEvent) {
//        navegarVentana("Registro.fxml", "REGISTRAR");
//    }
//
//    public FXMLLoader navegarVentana(String nombreArchivoFxml, String tituloVentana) {
//        try {
//            // Cargar la vista
//            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource(nombreArchivoFxml)));
//            Parent root = loader.load();
//
//            // Crear la escena
//            Scene scene = new Scene(root);
//
//            // Crear un nuevo escenario (ventana)
//            Stage stage = new Stage();
//            stage.setScene(scene);
//            stage.setResizable(false);
//            stage.setTitle(tituloVentana);
//
//            // Mostrar la nueva ventana
//            stage.show();
//            return loader;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            mostrarMensajeDeError("Error al cargar la ventana", "No se pudo cargar " + nombreArchivoFxml);
//        }
//        return null;
//    }
//
//    private void mostrarMensajeDeError(String titulo, String mensaje) {
//        Alert alert = new Alert(AlertType.ERROR);
//        alert.setTitle(titulo);
//        alert.setContentText(mensaje);
//        alert.showAndWait();
//    }
}
