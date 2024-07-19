/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.libreria.PrestamoLibros.persistence.mapper;

import com.libreria.PrestamoLibros.domain.dto.LibrosDTO;
import com.libreria.PrestamoLibros.persistence.entity.Libros;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 *
 * @author AsRock
 */
@Mapper(componentModel = "spring")
public interface LibrosMapper {
    @Mappings({
        @Mapping(source = "libroID", target = "libroID"),
        @Mapping(source = "titulo", target = "titulo"),
        @Mapping(source = "autor", target = "autor"),
        @Mapping(source = "anoPublicacion", target = "anoPublicacion"),
        @Mapping(source = "isbn", target = "isbn"),
        @Mapping(source = "creacion", target = "creacion"),
        @Mapping(source = "edito", target = "edito")
    })
    LibrosDTO toDTO(Libros libros);
    List<LibrosDTO> toDTOs(List<Libros> libros);

    @Mappings({
        @Mapping(source = "libroID", target = "libroID"),
        @Mapping(source = "titulo", target = "titulo"),
        @Mapping(source = "autor", target = "autor"),
        @Mapping(source = "anoPublicacion", target = "anoPublicacion"),
        @Mapping(source = "isbn", target = "isbn"),
        @Mapping(source = "creacion", target = "creacion"),
        @Mapping(source = "edito", target = "edito")
    })
    Libros toEntity(LibrosDTO librosDTO);
}
