package co.edu.uniquindio.forautos.mapping.mappers;

import co.edu.uniquindio.forautos.mapping.dto.ClienteDto;
import co.edu.uniquindio.forautos.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ForautoMapper {
    ForautoMapper INSTANCE = Mappers.getMapper(ForautoMapper.class);

    // Mapea de Cliente a ClienteDto
    @Mapping(target = "nombre", source = "nombre")  // Mapear las propiedades con el mismo nombre no es necesario, pero se muestra como ejemplo
    ClienteDto clienteToClienteDto(Cliente cliente);

    // Mapea de ClienteDto a Cliente
    Cliente clienteDtoToCliente(ClienteDto clienteDto);

    // Mapeo de una lista de Cliente a una lista de ClienteDto
    List<ClienteDto> getClientesDto(List<Cliente> listaClientes);
}
