package co.edu.uniquindio.forautos.controller;

import co.edu.uniquindio.forautos.controller.service.IHomeController;

public class HomeController implements IHomeController {

    private final ModelFactoryController modelFactoryController;

    public HomeController(){
        this.modelFactoryController = ModelFactoryController.getInstance();
    }

    @Override
    public void iniciarSesion() {
        modelFactoryController.navegarVentana("Login.fxml", "Login");
    }

    @Override
    public void registrarse() {
        modelFactoryController.navegarVentana("Registro.fxml", "Registro");
    }
}
