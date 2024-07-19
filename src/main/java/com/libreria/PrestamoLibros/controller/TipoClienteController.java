/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.PrestamoLibros.controller;

import com.libreria.PrestamoLibros.domain.dto.TipoClienteDTO;
import com.libreria.PrestamoLibros.domain.service.TipoClienteService;
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
@RequestMapping("/TipoCliente")
public class TipoClienteController {
    @Autowired
    private TipoClienteService tipoClienteService;
    @PostMapping("/creaTipoCliente")
    public ResponseEntity<TipoClienteDTO> save(@RequestBody TipoClienteDTO tipoClienteDTO) {
        return new ResponseEntity<>(tipoClienteService.save(tipoClienteDTO), HttpStatus.CREATED);
    }
    @GetMapping("/listarTipoCliente")
    public ResponseEntity<List<TipoClienteDTO>> getAll() {
        return new ResponseEntity<>(tipoClienteService.getAll(), HttpStatus.OK);
    }
    
//    @GetMapping("/GetCostumerId/{id}")
//    public ResponseEntity<Optional<ClienteDTO>> getCustumer(@PathVariable("id") int custumerId){
//        return new ResponseEntity<>(tipoClienteService.getCustomer(custumerId), HttpStatus.OK);
//    }
    
    @DeleteMapping("/eliminarTipoCliente/{id}")
    public ResponseEntity<Boolean> deleteCustumer(@PathVariable("id") int tipoClienteId){
        ResponseEntity<Boolean> ObjetoRespuesta = new ResponseEntity<>(tipoClienteService.delete(tipoClienteId), HttpStatus.CREATED);
        return  ObjetoRespuesta;
    }
    
//    @PutMapping("/UpdateCustumer/{id}")
//    public ResponseEntity<ClienteDTO> UpdateCustumer(@PathVariable("id") int custumerId, @RequestBody ClienteDTO customer){
//        customer.setCustomerId(custumerId);
//        return new ResponseEntity<>(tipoClienteService.updateCustumer(customer), HttpStatus.CREATED);
//    }
}
