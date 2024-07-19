/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.PrestamoLibros.controller;

import com.libreria.PrestamoLibros.domain.dto.ClienteDTO;
import com.libreria.PrestamoLibros.domain.service.ClienteService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;
    
    @PostMapping("/crearCliente")
    public ResponseEntity<ClienteDTO> save(@RequestBody ClienteDTO customer) {
        return new ResponseEntity<>(clienteService.save(customer), HttpStatus.CREATED);
    }
    @GetMapping("/listarCliente")
    public ResponseEntity<List<ClienteDTO>> getAll() {
        return new ResponseEntity<>(clienteService.getAll(), HttpStatus.OK);
    }
    
    @GetMapping("/GetCliente/{id}")
    public ResponseEntity<Optional<ClienteDTO>> getCustumer(@PathVariable("id") int custumerId){
        return new ResponseEntity<>(clienteService.getCliente(custumerId), HttpStatus.OK);
    }
    
    @DeleteMapping("/eliminarCliente/{id}")
    public ResponseEntity<Boolean> deleteCliente(@PathVariable("id") int custumerId){
        boolean isDeleted = clienteService.deleteCliente(custumerId);
        return new ResponseEntity<>(isDeleted, HttpStatus.OK);
    }
    
    @PutMapping("/UpdateCliente/{id}")
    public ResponseEntity<ClienteDTO> UpdateCustumer(@PathVariable("id") int custumerId, @RequestBody ClienteDTO clienteDTO){
        clienteDTO.setClienteID(custumerId);
        return new ResponseEntity<>(clienteService.update(clienteDTO), HttpStatus.CREATED);
    }
}
