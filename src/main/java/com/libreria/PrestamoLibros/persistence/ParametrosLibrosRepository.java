/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.PrestamoLibros.persistence;

import com.libreria.PrestamoLibros.domain.dto.ParametrosLibrosDTO;
import com.libreria.PrestamoLibros.domain.repository.ParametrosLibrosDTORepository;
import com.libreria.PrestamoLibros.persistence.crud.ParametrosLibrosCrudRepository;
import com.libreria.PrestamoLibros.persistence.entity.Libros;
import com.libreria.PrestamoLibros.persistence.entity.ParametrosLibros;
import com.libreria.PrestamoLibros.persistence.mapper.ParametrosLibrosMapper;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AsRock
 */
@Repository
public class ParametrosLibrosRepository implements ParametrosLibrosDTORepository{
    @Autowired
    private ParametrosLibrosCrudRepository parametrosLibrosCrudRepository;
    
    @Autowired
    private ParametrosLibrosMapper mapper;
    
    @Override
    public List<ParametrosLibrosDTO> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ParametrosLibrosDTO save(ParametrosLibrosDTO parametrosLibrosDTO) {
        ParametrosLibros parametrosLibros = mapper.toEntity(parametrosLibrosDTO);
        return mapper.toDTO(parametrosLibrosCrudRepository.save(parametrosLibros));
    }

    @Override
    public ParametrosLibrosDTO update(ParametrosLibrosDTO parametrosLibrosDTO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean delete(int parametroID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Date fechaDevolucion(int clienteId,int librosPrestadoId) {
        return parametrosLibrosCrudRepository.fechaDevolucion(clienteId,librosPrestadoId);
    }

    @Override
    public String prestaLibro(int clienteId) {
        return parametrosLibrosCrudRepository.prestaLibro(clienteId);
    }
    
}
