/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.PrestamoLibros.domain.service;

import com.libreria.PrestamoLibros.domain.dto.ClienteDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.libreria.PrestamoLibros.domain.repository.ClienteDTORepository;
import java.util.Optional;

/**
 *
 * @author AsRock
 */
@Service
public class ClienteService {
    @Autowired
    private ClienteDTORepository clienteRepository;
    
    public List<ClienteDTO> getAll() {
        return clienteRepository.getAll();
    }
    public ClienteDTO save(ClienteDTO clienteDTO){
        return clienteRepository.save(clienteDTO);
    }
    public Optional<ClienteDTO> getCliente(int Id){
        return clienteRepository.getCustomer(Id);
    }
    public boolean deleteCliente(int id){
        return clienteRepository.deleteCliente(id);
    }
    public  ClienteDTO update (ClienteDTO clienteDTO){
        return clienteRepository.save(clienteDTO);
    }
}
