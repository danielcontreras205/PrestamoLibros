/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.PrestamoLibros.domain.service;

import com.libreria.PrestamoLibros.domain.dto.ParametrosLibrosDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.libreria.PrestamoLibros.domain.repository.ParametrosLibrosDTORepository;

/**
 *
 * @author AsRock
 */
@Service
public class ParametrosLibrosService {
    @Autowired
    private ParametrosLibrosDTORepository parametrosLibrosRepository;
    
    public List<ParametrosLibrosDTO> getAll() {
        return parametrosLibrosRepository.getAll();
    }
    public ParametrosLibrosDTO save(ParametrosLibrosDTO parametrosLibrosDTO){
        return parametrosLibrosRepository.save(parametrosLibrosDTO);
    }
    public boolean delete(int id){
        return parametrosLibrosRepository.delete(id);
    }
    public  ParametrosLibrosDTO update (ParametrosLibrosDTO parametrosLibrosDTO){
        return parametrosLibrosRepository.save(parametrosLibrosDTO);
    }
}
