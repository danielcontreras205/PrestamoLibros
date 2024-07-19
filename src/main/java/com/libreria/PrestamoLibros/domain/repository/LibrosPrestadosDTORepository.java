/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.libreria.PrestamoLibros.domain.repository;

import com.libreria.PrestamoLibros.domain.dto.LibrosPrestadosDTO;
import java.util.List;

/**
 *
 * @author AsRock
 */
public interface LibrosPrestadosDTORepository {
    List<LibrosPrestadosDTO> getAll();
    String save(LibrosPrestadosDTO librosPrestadosDTO);
    LibrosPrestadosDTO update(LibrosPrestadosDTO librosPrestadosDTO);
    Boolean delete(int librosPrestadoID);
}
