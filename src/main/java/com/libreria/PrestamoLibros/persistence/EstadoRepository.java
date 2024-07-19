/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.PrestamoLibros.persistence;

import com.libreria.PrestamoLibros.domain.dto.EstadoDTO;
import com.libreria.PrestamoLibros.domain.repository.EstadoDTORepository;
import com.libreria.PrestamoLibros.persistence.crud.EstadoCrudRepository;
import com.libreria.PrestamoLibros.persistence.entity.Estado;
import com.libreria.PrestamoLibros.persistence.entity.Estado;
import com.libreria.PrestamoLibros.persistence.mapper.EstadoMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AsRock
 */
@Repository
public class EstadoRepository implements EstadoDTORepository{
    @Autowired
    private EstadoCrudRepository estadoCrudRepository;
    
    @Autowired
    private EstadoMapper mapper;
    
    @Override
    public List<EstadoDTO> getAll() {
        List<Estado> estado = (List)this.estadoCrudRepository.findAll();
        return this.mapper.toDTOs(estado);
    }

    @Override
    public EstadoDTO save(EstadoDTO estadoDTO) {
        Estado estado = mapper.toEntity(estadoDTO);
        return mapper.toDTO(estadoCrudRepository.save(estado));
    }

    @Override
    public EstadoDTO update(EstadoDTO estadoDTO) {
        Estado estado = mapper.toEntity(estadoDTO);
        return mapper.toDTO(estadoCrudRepository.save(estado));
    }

    @Override
    public Boolean deleteEstado(int estadoID) {
        if (estadoCrudRepository.existsById(estadoID)) {
            estadoCrudRepository.deleteById(estadoID);
            return true;
        } else {
            return false;
        }
    }

    

    
    
}
