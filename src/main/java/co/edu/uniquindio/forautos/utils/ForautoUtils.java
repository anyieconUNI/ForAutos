package co.edu.uniquindio.forautos.utils;

import co.edu.uniquindio.forautos.model.*;

public class ForautoUtils {
    public static Forautos inicializarDatos(){
        Forautos forautos = new Forautos();

        Cliente cliente = new Cliente();
        cliente.setNombre("Anye");
        cliente.setApellido("Condiza");
        cliente.setCedula("1003");
        cliente.setTelefono("310731");

        Admin admin = new Admin();
        admin.setNombre("1");
        admin.setCedula("1");
        admin.setEmail("1");
        admin.setTelefono("1");
        admin.setContrasena("1");

        Empleado empleado = new Empleado();
        empleado.setNombre("HOLA");
        empleado.setApellido("JOOO");
        empleado.setCedula("1111");
        empleado.setTelefono("111111");

        Cita cita = new Cita();
        cita.setId(cita.generarId());
        cita.setClientes(cliente);
        cita.setEmpleados(empleado);
        cita.setCiudad(Ciudad.BOGOTA);
        cita.setServicio(Servicio.LAVADO);
        cita.setHora("1");
        cita.setFecha("2024-10-02");

        forautos.getListaClientes().add(cliente);
        forautos.getListaAdmins().add(admin);
        forautos.getListaEmpleados().add(empleado);
        forautos.getListaCita().add(cita);
        System.out.println("Información creada");
        return forautos;

    }
}
