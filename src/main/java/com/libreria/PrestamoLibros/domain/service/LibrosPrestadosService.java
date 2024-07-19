/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.PrestamoLibros.domain.service;

import com.libreria.PrestamoLibros.domain.dto.LibrosPrestadosDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.libreria.PrestamoLibros.domain.repository.LibrosPrestadosDTORepository;

/**
 *
 * @author AsRock
 */
@Service
public class LibrosPrestadosService {
    @Autowired
    private LibrosPrestadosDTORepository librosPrestadosRepository;
    
    public List<LibrosPrestadosDTO> getAll() {
        return librosPrestadosRepository.getAll();
    }
    public String save(LibrosPrestadosDTO librosPrestadosDTO){
        return librosPrestadosRepository.save(librosPrestadosDTO);
    }
    public boolean delete(int id){
        return librosPrestadosRepository.delete(id);
    }
    public  LibrosPrestadosDTO update (LibrosPrestadosDTO librosPrestadosDTO){
        return librosPrestadosRepository.update(librosPrestadosDTO);
    }
}
