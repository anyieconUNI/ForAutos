package co.edu.uniquindio.forautos.viewController;

import co.edu.uniquindio.forautos.controller.ForautoController;
import co.edu.uniquindio.forautos.controller.service.IForautoControllerService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ForautoViewController {
    @FXML
    private Label welcomeText;

    IForautoControllerService forautoControllerService;

    @FXML
    void initialize() {
        forautoControllerService = new ForautoController();
    }



//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }
}