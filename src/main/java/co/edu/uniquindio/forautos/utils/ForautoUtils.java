package co.edu.uniquindio.forautos.utils;

import co.edu.uniquindio.forautos.model.Admin;
import co.edu.uniquindio.forautos.model.Cliente;
import co.edu.uniquindio.forautos.model.Empleado;
import co.edu.uniquindio.forautos.model.Forautos;

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

        forautos.getListaClientes().add(cliente);
        forautos.getListaAdmins().add(admin);
        forautos.getListaEmpleados().add(empleado);
        System.out.println("Información creada");
        return forautos;

    }
}
