/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.libreria.PrestamoLibros.domain.repository;

import com.libreria.PrestamoLibros.domain.dto.TipoClienteDTO;
import java.util.List;

/**
 *
 * @author AsRock
 */
public interface TipoClienteDTORepository {
    List<TipoClienteDTO> getAll();
    TipoClienteDTO save(TipoClienteDTO tipoClienteDTO);
    TipoClienteDTO update(TipoClienteDTO tipoClienteDTO);
    Boolean delete(int tipoClienteID);
}
