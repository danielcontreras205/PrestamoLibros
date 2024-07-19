/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.PrestamoLibros.persistence;

import com.libreria.PrestamoLibros.domain.dto.LibrosDTO;
import com.libreria.PrestamoLibros.domain.repository.LibrosDTORepository;
import com.libreria.PrestamoLibros.persistence.crud.LibrosCrudRepository;
import com.libreria.PrestamoLibros.persistence.entity.Libros;
import com.libreria.PrestamoLibros.persistence.mapper.LibrosMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AsRock
 */
@Repository
public class LibrosRepository implements LibrosDTORepository{
    @Autowired
    private LibrosCrudRepository librosCrudRepository;
    
    @Autowired
    private LibrosMapper mapper;

    @Override
    public List<LibrosDTO> getAll() {
        List<Libros> libros = (List)this.librosCrudRepository.findAll();
        return this.mapper.toDTOs(libros);
    }

    @Override
    public LibrosDTO save(LibrosDTO librosDTO) {
        Libros libros = mapper.toEntity(librosDTO);
        return mapper.toDTO(librosCrudRepository.save(libros));
    }

    @Override
    public LibrosDTO update(LibrosDTO librosDTO) {
        Libros libros = mapper.toEntity(librosDTO);
        return mapper.toDTO(librosCrudRepository.save(libros));
    }

    @Override
    public Boolean deleteLibro(int clienteID) {
        if (librosCrudRepository.existsById(clienteID)) {
            librosCrudRepository.deleteById(clienteID);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Optional<LibrosDTO> getLibro(int Id) {
        return librosCrudRepository.findById(Id).map(libro -> mapper.toDTO(libro));
    }

    
}
