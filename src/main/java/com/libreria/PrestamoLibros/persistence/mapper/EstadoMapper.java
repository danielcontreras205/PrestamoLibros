/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.libreria.PrestamoLibros.persistence.mapper;

import com.libreria.PrestamoLibros.domain.dto.EstadoDTO;
import com.libreria.PrestamoLibros.persistence.entity.Estado;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 *
 * @author AsRock
 */
@Mapper(componentModel = "spring")
public interface EstadoMapper {
    @Mappings({
        @Mapping(source = "estadoID", target = "estadoID"),
        @Mapping(source = "nombreEstado", target = "nombreEstado"),
        @Mapping(source = "creacion", target = "creacion"),
        @Mapping(source = "edito", target = "edito")
    })
    EstadoDTO toDTO(Estado estado);
    List<EstadoDTO>  toDTOs(List<Estado> estado);

    @Mappings({
        @Mapping(source = "estadoID", target = "estadoID"),
        @Mapping(source = "nombreEstado", target = "nombreEstado"),
        @Mapping(source = "creacion", target = "creacion"),
        @Mapping(source = "edito", target = "edito")
    })
    Estado toEntity(EstadoDTO estadoDTO);
}
