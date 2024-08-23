package co.edu.uniquindio.forautos.mapping.dto;

public record ClienteDto(
        String nombre,
        String apellido,
        String cedula,
        String telefono
) {
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
}
