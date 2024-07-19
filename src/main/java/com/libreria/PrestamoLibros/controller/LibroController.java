/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.PrestamoLibros.controller;

import com.libreria.PrestamoLibros.domain.dto.LibrosDTO;
import com.libreria.PrestamoLibros.domain.service.LibrosService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author AsRock
 */
@RestController
@RequestMapping("/libro")
public class LibroController {
    @Autowired
    private LibrosService librosService;
    
    @PostMapping("/books")
    public ResponseEntity<LibrosDTO> save(@RequestBody LibrosDTO librosDTO) {
        return new ResponseEntity<>(librosService.save(librosDTO), HttpStatus.CREATED);
    }
    @GetMapping("/books")
    public ResponseEntity<List<LibrosDTO>> getAll() {
        return new ResponseEntity<>(librosService.getAll(), HttpStatus.OK);
    }
    
    @GetMapping("/books/{id}")
    public ResponseEntity<Optional<LibrosDTO>> getLibro(@PathVariable("id") int custumerId){
        return new ResponseEntity<>(librosService.getLibro(custumerId), HttpStatus.OK);
    }
    
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Boolean> deleteLibro(@PathVariable("id") int custumerId){
        boolean isDeleted = librosService.deleteLibro(custumerId);
        return new ResponseEntity<>(isDeleted, HttpStatus.OK);
    }
    
    @PutMapping("/books/{id}")
    public ResponseEntity<LibrosDTO> UpdateLibro(@PathVariable("id") int custumerId, @RequestBody LibrosDTO LibrosDTO){
        LibrosDTO.setLibroID(custumerId);
        return new ResponseEntity<>(librosService.update(LibrosDTO), HttpStatus.CREATED);
    }
}
