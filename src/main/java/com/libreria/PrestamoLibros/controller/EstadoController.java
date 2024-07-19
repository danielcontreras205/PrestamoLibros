/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.PrestamoLibros.controller;

import com.libreria.PrestamoLibros.domain.dto.EstadoDTO;
import com.libreria.PrestamoLibros.domain.service.EstadoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author AsRock
 */
@RestController
@RequestMapping("/estado")
public class EstadoController {
    @Autowired
    private EstadoService estadoService;
    @PostMapping("/creaEstado")
    public ResponseEntity<EstadoDTO> save(@RequestBody EstadoDTO estadoDTO) {
        return new ResponseEntity<>(estadoService.save(estadoDTO), HttpStatus.CREATED);
    }
    @GetMapping("/listarEstados")
    public ResponseEntity<List<EstadoDTO>> getAll() {
        return new ResponseEntity<>(estadoService.getAll(), HttpStatus.OK);
    }
    @DeleteMapping("/eliminarEstado/{id}")
    public ResponseEntity<Boolean> deleteEstado(@PathVariable("id") int estadoId) {
        boolean isDeleted = estadoService.deleteEstado(estadoId);
        return new ResponseEntity<>(isDeleted, HttpStatus.OK);
    }
    
//    @GetMapping("/GetCostumerId/{id}")
//    public ResponseEntity<Optional<ClienteDTO>> getCustumer(@PathVariable("id") int custumerId){
//        return new ResponseEntity<>(tipoClienteService.getCustomer(custumerId), HttpStatus.OK);
//    }
    
//    @PutMapping("/UpdateCustumer/{id}")
//    public ResponseEntity<ClienteDTO> UpdateCustumer(@PathVariable("id") int custumerId, @RequestBody ClienteDTO customer){
//        customer.setCustomerId(custumerId);
//        return new ResponseEntity<>(tipoClienteService.updateCustumer(customer), HttpStatus.CREATED);
//    }
}
