/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.PrestamoLibros.domain.service;

import com.libreria.PrestamoLibros.domain.dto.LibrosDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import com.libreria.PrestamoLibros.domain.repository.LibrosDTORepository;
import java.util.Optional;

/**
 *
 * @author AsRock
 */
@Service
public class LibrosService {
    @Autowired
    private LibrosDTORepository librosRepository;
    
    public List<LibrosDTO> getAll() {
        return librosRepository.getAll();
    }
    @Secured("ROLE_Afiliado")
    public LibrosDTO save(LibrosDTO librosDTO){
        return librosRepository.save(librosDTO);
    }
    public Optional<LibrosDTO> getLibro(int Id){
        return librosRepository.getLibro(Id);
    }
    public boolean deleteLibro(int id){
        return librosRepository.deleteLibro(id);
    }
    public  LibrosDTO update (LibrosDTO librosDTO){
        return librosRepository.save(librosDTO);
    }
}
