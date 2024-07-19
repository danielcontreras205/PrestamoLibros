/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.PrestamoLibros.domain.service;

import com.libreria.PrestamoLibros.domain.dto.EstadoDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.libreria.PrestamoLibros.domain.repository.EstadoDTORepository;

/**
 *
 * @author AsRock
 */
@Service
public class EstadoService {
    @Autowired
    private EstadoDTORepository estadoRepository;
    
    public List<EstadoDTO> getAll() {
        return estadoRepository.getAll();
    }
    public EstadoDTO save(EstadoDTO estadoDTO){
        return estadoRepository.save(estadoDTO);
    }
    public boolean deleteEstado(int id) {
        return estadoRepository.deleteEstado(id);
    }
    public  EstadoDTO update (EstadoDTO estadoDTO){
        return estadoRepository.save(estadoDTO);
    }
}
