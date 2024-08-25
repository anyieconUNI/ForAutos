package co.edu.uniquindio.forautos.model;

import java.util.UUID;

import lombok.Builder;



@Builder
public class Cita {
    private String id;
    private Cliente clientes;
    private Servicio servicio;
    private String fecha;
    private String hora;
    private Ciudad ciudad;
    private Empleado empleados;
    public Cita() {

    }

    public void setClientes(Cliente clientes) {
        this.clientes = clientes;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public void setEmpleados(Empleado empleados) {
        this.empleados = empleados;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Cliente getClientes() {
        return clientes;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public Empleado getEmpleados() {
        return empleados;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String generarId() {
        this.id = UUID.randomUUID().toString();
        System.out.println("ID GENERADOOOOOOOOOOOOOOOO"+ this.id);
        return null;
    }
}
