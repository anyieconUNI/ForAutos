package co.edu.uniquindio.forautos.controller.service;

import co.edu.uniquindio.forautos.mapping.dto.RegistroDto;
import javafx.scene.control.Alert;

public interface IRegistroControllerService {
    boolean agregarRegistro(RegistroDto registroDto);
    void mostrarMensaje(String mensaje, String titulo, Alert.AlertType tipo);
}
