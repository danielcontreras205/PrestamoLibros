/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.libreria.PrestamoLibros.domain.repository;

import com.libreria.PrestamoLibros.domain.dto.ParametrosLibrosDTO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author AsRock
 */
public interface ParametrosLibrosDTORepository {
    List<ParametrosLibrosDTO> getAll();
    ParametrosLibrosDTO save(ParametrosLibrosDTO parametrosLibrosDTO);
    ParametrosLibrosDTO update(ParametrosLibrosDTO parametrosLibrosDTO);
    Boolean delete(int parametroID);
    Date fechaDevolucion(int clienteId,int librosPrestadoId);
    String prestaLibro(int clienteId);
}
