package co.edu.uniquindio.forautos.controller;

import co.edu.uniquindio.forautos.controller.service.ILoginControllerService;
import co.edu.uniquindio.forautos.controller.service.IModelFactoryService;
import co.edu.uniquindio.forautos.exceptions.LoginException;
import co.edu.uniquindio.forautos.mapping.dto.LoginDto;
import co.edu.uniquindio.forautos.model.Admin;

public class LoginController implements ILoginControllerService {
    IModelFactoryService modelFactoryService;

    public LoginController() {
        modelFactoryService = ModelFactoryController.getInstance();
    }

    @Override
    public Admin incioAdmin(LoginDto loginDto) throws LoginException {
        return modelFactoryService.iniciarSesion(loginDto);
    }
}
