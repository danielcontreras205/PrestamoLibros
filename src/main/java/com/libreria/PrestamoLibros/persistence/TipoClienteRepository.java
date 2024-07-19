/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.PrestamoLibros.persistence;

import com.libreria.PrestamoLibros.domain.dto.TipoClienteDTO;
import com.libreria.PrestamoLibros.domain.repository.TipoClienteDTORepository;
import com.libreria.PrestamoLibros.persistence.crud.TipoClienteCrudRepository;
import com.libreria.PrestamoLibros.persistence.entity.TipoCliente;
import com.libreria.PrestamoLibros.persistence.mapper.TipoClienteMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AsRock
 */
@Repository
public class TipoClienteRepository implements TipoClienteDTORepository{
    @Autowired
    private TipoClienteCrudRepository tipoClienteCrudRepository;
    
    @Autowired
    private TipoClienteMapper mapper;

    @Override
    public List<TipoClienteDTO> getAll() {
        List<TipoCliente> tipoCliente = (List)this.tipoClienteCrudRepository.findAll();
        return this.mapper.toDTOs(tipoCliente);
    }

    @Override
    public TipoClienteDTO save(TipoClienteDTO tipoClienteDTO) {
        TipoCliente tipoCliente = mapper.toEntity(tipoClienteDTO);
        return mapper.toDTO(tipoClienteCrudRepository.save(tipoCliente));
    }

    @Override
    public TipoClienteDTO update(TipoClienteDTO tipoClienteDTO) {
        TipoCliente tipoCliente = mapper.toEntity(tipoClienteDTO);
        return mapper.toDTO(tipoClienteCrudRepository.save(tipoCliente));
    }

    @Override
    public Boolean delete(int tipoClienteID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
