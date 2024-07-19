/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.libreria.PrestamoLibros.domain.repository;

import com.libreria.PrestamoLibros.domain.dto.LibrosDTO;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author AsRock
 */
public interface LibrosDTORepository {
    List<LibrosDTO> getAll();
    LibrosDTO save(LibrosDTO librosDTO);
    LibrosDTO update(LibrosDTO librosDTO);
    Boolean deleteLibro(int clienteID);
    Optional<LibrosDTO> getLibro(int Id);
}
