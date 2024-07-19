/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.libreria.PrestamoLibros.domain.repository;

import com.libreria.PrestamoLibros.domain.dto.ClienteDTO;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author AsRock
 */
public interface ClienteDTORepository {
    List<ClienteDTO> getAll();
    ClienteDTO save(ClienteDTO clienteDTO);
    ClienteDTO update(ClienteDTO clienteDTO);
    Boolean deleteCliente(int clienteID);
    Optional<ClienteDTO> getCustomer(int Id);
}
