/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.PrestamoLibros.domain.repository;

import com.libreria.PrestamoLibros.domain.dto.EstadoDTO;
import java.util.List;

/**
 *
 * @author AsRock
 */
public interface EstadoDTORepository {
    List<EstadoDTO> getAll();
    EstadoDTO save(EstadoDTO estadoDTO);
    EstadoDTO update(EstadoDTO buyProduct);
    Boolean deleteEstado(int estadoID);
}
