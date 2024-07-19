/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.PrestamoLibros.persistence;

import com.libreria.PrestamoLibros.domain.dto.ClienteDTO;
import com.libreria.PrestamoLibros.domain.repository.ClienteDTORepository;
import com.libreria.PrestamoLibros.persistence.crud.ClienteCrudRepository;
import com.libreria.PrestamoLibros.persistence.entity.Cliente;
import com.libreria.PrestamoLibros.persistence.mapper.ClienteMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AsRock
 */
@Repository
public class ClienteRepository implements ClienteDTORepository{

    @Autowired
    private ClienteCrudRepository clienteCrudRepository;
    
    @Autowired
    private ClienteMapper mapper;
    
    @Override
    public List<ClienteDTO> getAll() {
        List<Cliente> cliente = (List)this.clienteCrudRepository.findAll();
        return this.mapper.toDTOs(cliente);
    }

    @Override
    public ClienteDTO save(ClienteDTO clienteDTO) {
        Cliente cliente = mapper.toEntity(clienteDTO);
        return mapper.toDTO(clienteCrudRepository.save(cliente));
    }

    @Override
    public ClienteDTO update(ClienteDTO clienteDTO) {
        Cliente cliente = mapper.toEntity(clienteDTO);
        return mapper.toDTO(clienteCrudRepository.save(cliente));
    }

    @Override
    public Boolean deleteCliente(int clienteID) {
        if (clienteCrudRepository.existsById(clienteID)) {
            clienteCrudRepository.deleteById(clienteID);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Optional<ClienteDTO> getCustomer(int Id) {
        return clienteCrudRepository.findById(Id).map(cliente -> mapper.toDTO(cliente));
    }
    
}
