package co.edu.uniquindio.forautos.controller.service;

import co.edu.uniquindio.forautos.exceptions.LoginException;
import co.edu.uniquindio.forautos.mapping.dto.LoginDto;
import co.edu.uniquindio.forautos.model.Admin;

public interface ILoginControllerService {
    Admin incioAdmin(LoginDto loginDto) throws LoginException;
}
