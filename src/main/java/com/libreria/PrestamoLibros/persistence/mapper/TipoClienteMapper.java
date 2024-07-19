/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.libreria.PrestamoLibros.persistence.mapper;

import com.libreria.PrestamoLibros.domain.dto.TipoClienteDTO;
import com.libreria.PrestamoLibros.persistence.entity.TipoCliente;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 *
 * @author AsRock
 */
@Mapper(componentModel = "spring")
public interface TipoClienteMapper {
    @Mappings({
        @Mapping(source = "tipoClienteID", target = "tipoClienteID"),
        @Mapping(source = "nombreTipo", target = "nombreTipo"),
        @Mapping(source = "estado.estadoID", target = "estadoID"), // Mapea la relación Estado
        @Mapping(source = "creacion", target = "creacion"),
        @Mapping(source = "edito", target = "edito")
    })
    TipoClienteDTO toDTO(TipoCliente tipoCliente);
    List<TipoClienteDTO> toDTOs(List<TipoCliente> tipoCliente);

    @Mappings({
        @Mapping(source = "tipoClienteID", target = "tipoClienteID"),
        @Mapping(source = "nombreTipo", target = "nombreTipo"),
        @Mapping(source = "estadoID", target = "estado.estadoID"), // Mapea la relación Estado
        @Mapping(source = "creacion", target = "creacion"),
        @Mapping(source = "edito", target = "edito")
    })
    TipoCliente toEntity(TipoClienteDTO tipoClienteDTO);
}
