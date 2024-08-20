package co.edu.uniquindio.forautos.controller;

import co.edu.uniquindio.forautos.controller.service.IModelFactoryService;
import co.edu.uniquindio.forautos.controller.service.IRegistroControllerService;
import co.edu.uniquindio.forautos.exceptions.RegistroException;
import co.edu.uniquindio.forautos.mapping.dto.RegistroDto;
import co.edu.uniquindio.forautos.model.Admin;
import javafx.scene.control.Alert;

public class RegistroController implements IRegistroControllerService {
    IModelFactoryService modelFactoryService;

    public RegistroController(){
        modelFactoryService =ModelFactoryController.getInstance();
    }
    @Override
    public boolean agregarRegistro(RegistroDto registroDto){
        return modelFactoryService.agregarRegistroAdmin(registroDto);
    }

    @Override
    public void mostrarMensaje(String mensaje, String titulo, Alert.AlertType tipo) {
        modelFactoryService.mostrarMensaje(mensaje, titulo, tipo);
    }

}
