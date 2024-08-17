package co.edu.uniquindio.forautos.model;
import lombok.Getter;
@Getter

public enum Servicio {

    TECNICOMECANICA("Tecnicomecanica", 600000),
    LAVADO("Lavado", 20000), BALANCEO("Balanceo", 250000),
    REPARACION("Reparacion", 300000);

    private final String nombre;
    private final float precio;

    Servicio(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

}