package co.edu.uniquindio.forautos.utils;

import co.edu.uniquindio.forautos.model.Cliente;
import co.edu.uniquindio.forautos.model.Forautos;

public class ForautoUtils {
    public static Forautos inicializarDatos(){
        Forautos forautos = new Forautos();

        Cliente cliente = new Cliente();
        cliente.setNombre("Anye");
        cliente.setApellido("Condiza");
        cliente.setCedula("1003");
        cliente.setTelefono("310731");

        forautos.getListaClientes().add(cliente);
        System.out.println("Información creada");
        return forautos;
    }
}
