package co.edu.uniquindio.forautos.controller;

import co.edu.uniquindio.forautos.controller.service.IForautoControllerService;

public class ForautoController implements IForautoControllerService {
    ModelFactoryController modelFactoryController;

    public ForautoController(){
        System.out.println("Llamando al singleton desde BancoServiceController");
        modelFactoryController = ModelFactoryController.getInstance();
    }
}
