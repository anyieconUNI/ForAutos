package co.edu.uniquindio.forautos.controller;

import co.edu.uniquindio.forautos.controller.service.IModelFactoryService;
import co.edu.uniquindio.forautos.controller.service.IRegistroControllerService;
import co.edu.uniquindio.forautos.exceptions.RegistroException;
import co.edu.uniquindio.forautos.mapping.dto.RegistroDto;
import co.edu.uniquindio.forautos.model.Admin;

public class RegistroController implements IRegistroControllerService {
    IModelFactoryService modelFactoryService;

    public RegistroController(){
        modelFactoryService =ModelFactoryController.getInstance();
    }
    @Override
    public boolean agregarRegistro(RegistroDto registroDto){
        return modelFactoryService.agregarRegistroAdmin(registroDto);
    }

}
