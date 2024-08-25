package co.edu.uniquindio.forautos.mapping.mappers;

import co.edu.uniquindio.forautos.mapping.dto.CitaDto;
import co.edu.uniquindio.forautos.mapping.dto.ClienteDto;
import co.edu.uniquindio.forautos.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.forautos.mapping.dto.RegistroDto;
import co.edu.uniquindio.forautos.model.Admin;
import co.edu.uniquindio.forautos.model.Cita;
import co.edu.uniquindio.forautos.model.Cliente;
import co.edu.uniquindio.forautos.model.Empleado;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ForautoMapper {
    ForautoMapper INSTANCE = Mappers.getMapper(ForautoMapper.class);

    // Métodos personalizados para mapear entre Cliente y String
    default String map(Cliente cliente) {
        return cliente != null ? cliente.getNombre() : null;
    }

    default Cliente stringToCliente(String value) {
        Cliente cliente = new Cliente();
        cliente.setNombre(value);
        return cliente;
    }

    // Métodos personalizados para mapear entre Empleado y String
    default String map(Empleado empleado) {
        return empleado != null ? empleado.getNombre() : null;
    }

    default Empleado stringToEmpleado(String value) {
        Empleado empleado = new Empleado();
        empleado.setNombre(value);
        return empleado;
    }

    // Mapea de Cliente a ClienteDto
    ClienteDto clienteToClienteDto(Cliente cliente);

    // Mapea de ClienteDto a Cliente
    Cliente clienteDtoToCliente(ClienteDto clienteDto);

    // Mapeo de una lista de Cliente a una lista de ClienteDto
    List<ClienteDto> getClientesDto(List<Cliente> listaClientes);

    // Métodos para Empleado
    @Named("empleadoToEmpleadoDto")
    EmpleadoDto empleadoToEmpleadoDto(Empleado empleado);

    Empleado empleadoDtoToEmpleado(EmpleadoDto empleadoDto);

    @IterableMapping(qualifiedByName = "empleadoToEmpleadoDto")
    List<EmpleadoDto> getEmpleadosDto(List<Empleado> listaEmpleados);

    // Métodos para Registro
    @Named("RegistroToRegistroDto")
    RegistroDto RegistroToRegistroDto(Admin admin);

    Admin RegistroDtoToAdmin(RegistroDto registroDto);

    @IterableMapping(qualifiedByName = "RegistroToRegistroDto")
    List<RegistroDto> getRegistrosDto(List<Admin> listaRegistros);

    // Métodos para Cita
    @Named("citaToCitaDto")
    CitaDto citaToCitaDto(Cita cita);

    Cita citaDtoToCita(CitaDto citaDto);

    @IterableMapping(qualifiedByName = "citaToCitaDto")
    List<CitaDto> getCitaDto(List<Cita> listaCita);
}
