/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.libreria.PrestamoLibros.persistence.mapper;

import com.libreria.PrestamoLibros.domain.dto.ParametrosLibrosDTO;
import com.libreria.PrestamoLibros.persistence.entity.ParametrosLibros;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 *
 * @author AsRock
 */
@Mapper(componentModel = "spring", uses = {TipoClienteMapper.class})
public interface ParametrosLibrosMapper {
    @Mappings({
        @Mapping(source = "parametroID", target = "parametroID"),
        @Mapping(source = "tipoCliente.tipoClienteID", target = "tipoClienteID"), 
        @Mapping(source = "diasPrestamo", target = "diasPrestamo"),
        @Mapping(source = "creacion", target = "creacion"),
        @Mapping(source = "edito", target = "edito")
    })
    ParametrosLibrosDTO toDTO(ParametrosLibros parametrosLibros);

    @Mappings({
        @Mapping(source = "parametroID", target = "parametroID"),
        @Mapping(source = "tipoClienteID", target = "tipoCliente.tipoClienteID"),
        @Mapping(source = "diasPrestamo", target = "diasPrestamo"),
        @Mapping(source = "creacion", target = "creacion"),
        @Mapping(source = "edito", target = "edito")
    })
    ParametrosLibros toEntity(ParametrosLibrosDTO parametrosLibrosDTO);
}
