/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.PrestamoLibros.domain.service;

import com.libreria.PrestamoLibros.domain.dto.TipoClienteDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.libreria.PrestamoLibros.domain.repository.TipoClienteDTORepository;

/**
 *
 * @author AsRock
 */
@Service
public class TipoClienteService {
    @Autowired
    private TipoClienteDTORepository tipoClienteRepository;
    
    public List<TipoClienteDTO> getAll() {
        return tipoClienteRepository.getAll();
    }
    public TipoClienteDTO save(TipoClienteDTO tipoClienteDTO){
        return tipoClienteRepository.save(tipoClienteDTO);
    }
    public boolean delete(int id){
        return tipoClienteRepository.delete(id);
    }
    public  TipoClienteDTO update (TipoClienteDTO tipoClienteDTO){
        return tipoClienteRepository.save(tipoClienteDTO);
    }
}
