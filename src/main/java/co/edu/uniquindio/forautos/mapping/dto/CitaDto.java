package co.edu.uniquindio.forautos.mapping.dto;

import co.edu.uniquindio.forautos.model.Ciudad;
import co.edu.uniquindio.forautos.model.Cliente;
import co.edu.uniquindio.forautos.model.Empleado;
import co.edu.uniquindio.forautos.model.Servicio;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import lombok.Builder;

import java.util.Date;
import java.util.List;
@Builder
public record CitaDto(
        String id,
        String clientes,
        String servicio,
        String fecha,
        String hora,
        String ciudad,
        String empleados
) {
}
