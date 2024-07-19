/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.libreria.PrestamoLibros.persistence.mapper;

import com.libreria.PrestamoLibros.domain.dto.LibrosPrestadosDTO;
import com.libreria.PrestamoLibros.persistence.entity.LibrosPrestados;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 *
 * @author AsRock
 */
@Mapper(componentModel = "spring", uses = {ClienteMapper.class})
public interface LibrosPrestadosMapper {
    @Mappings({
        @Mapping(source = "librosPrestadoID", target = "librosPrestadoID"),
        @Mapping(source = "libro.libroID", target = "libroID"), // Mapea la relación Libros
        @Mapping(source = "cliente.clienteID", target = "clienteID"), // Mapea la relación Cliente
        @Mapping(source = "fechaPrestamo", target = "fechaPrestamo"),
        @Mapping(source = "fechaDevolucion", target = "fechaDevolucion")
    })
    LibrosPrestadosDTO toDTO(LibrosPrestados librosPrestados);
    List<LibrosPrestadosDTO> toDTOs(List<LibrosPrestados> librosPrestados);

    @Mappings({
        @Mapping(source = "librosPrestadoID", target = "librosPrestadoID"),
        @Mapping(source = "libroID", target = "libro.libroID"), // Mapea la relación Libros
        @Mapping(source = "clienteID", target = "cliente.clienteID"), // Mapea la relación Cliente
        @Mapping(source = "fechaPrestamo", target = "fechaPrestamo"),
        @Mapping(source = "fechaDevolucion", target = "fechaDevolucion")
    })
    LibrosPrestados toEntity(LibrosPrestadosDTO librosPrestadosDTO);
}
