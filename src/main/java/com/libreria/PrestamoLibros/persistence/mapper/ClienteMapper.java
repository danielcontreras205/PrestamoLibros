/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.libreria.PrestamoLibros.persistence.mapper;

import com.libreria.PrestamoLibros.domain.dto.ClienteDTO;
import com.libreria.PrestamoLibros.persistence.entity.Cliente;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 *
 * @author AsRock
 */
@Mapper(componentModel = "spring", uses = {EstadoMapper.class})
public interface ClienteMapper {
    @Mappings({
        @Mapping(source = "clienteID", target = "clienteID"),
        @Mapping(source = "nombre", target = "nombre"),
        @Mapping(source = "apellido", target = "apellido"),
        @Mapping(source = "tipoCliente.tipoClienteID", target = "tipoClienteID"),
        @Mapping(source = "estado.estadoID", target = "estadoID"), 
        @Mapping(source = "creacion", target = "creacion"),
        @Mapping(source = "edito", target = "edito"),
        @Mapping(source = "usuario.usuarioId", target = "usuarioId")
    })
    ClienteDTO toDTO(Cliente cliente);
    List<ClienteDTO>  toDTOs(List<Cliente> cliente);

    @Mappings({
        @Mapping(source = "clienteID", target = "clienteID"),
        @Mapping(source = "nombre", target = "nombre"),
        @Mapping(source = "apellido", target = "apellido"),
        @Mapping(source = "tipoClienteID", target = "tipoCliente.tipoClienteID"), 
        @Mapping(source = "estadoID", target = "estado.estadoID"), 
        @Mapping(source = "creacion", target = "creacion"),
        @Mapping(source = "edito", target = "edito"),
        @Mapping(source = "usuarioId", target = "usuario.usuarioId")
    })
    Cliente toEntity(ClienteDTO clienteDTO);
}
