/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.PrestamoLibros.controller;

import com.libreria.PrestamoLibros.domain.dto.ParametrosLibrosDTO;
import com.libreria.PrestamoLibros.domain.service.ParametrosLibrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author AsRock
 */
@RestController
@RequestMapping("/ParametrosLibros")
public class ParametrosLibros {
    @Autowired
    private ParametrosLibrosService parametrosLibrosService;
    @PostMapping("/crearParametrosLibros")
    public ResponseEntity<ParametrosLibrosDTO> save(@RequestBody ParametrosLibrosDTO parametrosLibrosDTO) {
        return new ResponseEntity<>(parametrosLibrosService.save(parametrosLibrosDTO), HttpStatus.CREATED);
    }
}
