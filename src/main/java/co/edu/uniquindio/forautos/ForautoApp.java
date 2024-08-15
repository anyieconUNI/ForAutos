package co.edu.uniquindio.forautos;

import co.edu.uniquindio.forautos.viewController.ClienteViews;  // Asegúrate de importar el controlador correcto
import co.edu.uniquindio.forautos.viewController.ForautoViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ForautoApp extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;
        this.primaryStage.setTitle("Banco UQ");
        mostrarVentanaPrincipal();
    }

    public void mostrarVentanaPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ForautoApp.class.getResource("ForautosView.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            ForautoViewController clienteViewController = loader.getController();  // Usa el controlador correcto
            // clienteViewController.setAplicacion(this);  // Si necesitas pasar la aplicación al controlador

            // Mostrar la escena que contiene el layout principal.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
