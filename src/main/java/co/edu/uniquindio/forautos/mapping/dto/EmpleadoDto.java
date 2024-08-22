package co.edu.uniquindio.forautos.mapping.dto;

public record EmpleadoDto(
        String nombre,
        String apellido,
        String cedula,
        String telefono) {

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
}