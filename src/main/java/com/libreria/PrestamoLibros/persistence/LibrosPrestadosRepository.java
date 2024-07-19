/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.PrestamoLibros.persistence;

import com.libreria.PrestamoLibros.domain.dto.ClienteDTO;
import com.libreria.PrestamoLibros.domain.dto.LibrosDTO;
import com.libreria.PrestamoLibros.domain.dto.LibrosPrestadosDTO;
import com.libreria.PrestamoLibros.domain.repository.LibrosPrestadosDTORepository;
import com.libreria.PrestamoLibros.persistence.crud.LibrosPrestadosCrudRepository;
import com.libreria.PrestamoLibros.persistence.entity.Libros;
import com.libreria.PrestamoLibros.persistence.entity.LibrosPrestados;
import com.libreria.PrestamoLibros.persistence.mapper.LibrosMapper;
import com.libreria.PrestamoLibros.persistence.mapper.LibrosPrestadosMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AsRock
 */
@Repository
public class LibrosPrestadosRepository implements LibrosPrestadosDTORepository{
    @Autowired
    private LibrosPrestadosCrudRepository librosPrestadosCrudRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ParametrosLibrosRepository parametrosLibrosRepository;
    
    @Autowired
    private LibrosPrestadosMapper mapper;
    @Autowired
    private LibrosMapper mapperLibros;

    @Override
    public List<LibrosPrestadosDTO> getAll() {
        List<LibrosPrestados> librosPrestados = (List)this.librosPrestadosCrudRepository.findAll();
        return this.mapper.toDTOs(librosPrestados);
    }

    @Override
    public String save(LibrosPrestadosDTO librosDTO) {
        LibrosPrestados librosPrestados = mapper.toEntity(librosDTO);
        if(librosPrestados != null){
            Optional<ClienteDTO>  clienteDTO = clienteRepository.getCustomer(librosPrestados.getCliente().getClienteID());
            return validaSiPrestaLibro(clienteDTO,librosPrestados);
        }else{
            return "La clase librosPrestados es NULL";
        }
        
    }

    @Override
    public LibrosPrestadosDTO update(LibrosPrestadosDTO librosDTO) {
        LibrosPrestados librosPrestados = mapper.toEntity(librosDTO);
        return mapper.toDTO(librosPrestadosCrudRepository.save(librosPrestados));
    }

    @Override
    public Boolean delete(int libroID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public String validaSiPrestaLibro (Optional<ClienteDTO>  clienteDTO,LibrosPrestados librosPrestados){
        LibrosPrestadosDTO librosPrestadosDTO = null;
        StringBuilder successMessage = new StringBuilder();
        
        switch (clienteDTO.get().getTipoClienteID()) {
                case 3:
                    if(ValidarSiTieneLibros(clienteDTO)){
                        librosPrestadosDTO = mapper.toDTO(librosPrestadosCrudRepository.save(librosPrestados));
                        if (librosPrestadosDTO != null && librosPrestadosDTO.getClienteID() != 0) {
                            successMessage.append("El préstamo se ha creado exitosamente con el libro con el ID: ")
                                            .append(librosPrestadosDTO.getLibroID())
                                            .append("\n")
                                            .append("con fecha de devolución el día: ")
                                            .append(parametrosLibrosRepository.fechaDevolucion(librosPrestadosDTO.getClienteID(),librosPrestadosDTO.getLibrosPrestadoID()));
                        }
                    }else{
                        parametrosLibrosRepository.prestaLibro(clienteDTO.get().getClienteID());
                        successMessage.append("No puede solicitar más prestamos ya tiene activo uno ")
                                            .append("\n")
                                            .append(parametrosLibrosRepository.prestaLibro(clienteDTO.get().getClienteID()));
                    }
                break;
                case 2:
                    librosPrestadosDTO = mapper.toDTO(librosPrestadosCrudRepository.save(librosPrestados));
                    if (librosPrestadosDTO != null && librosPrestadosDTO.getClienteID() != 0) {
                        successMessage.append("El préstamo se ha creado exitosamente con el libro con el ID: ")
                                        .append(librosPrestadosDTO.getLibroID())
                                        .append("\n")
                                        .append("con fecha de devolución el día: ")
                                        .append(parametrosLibrosRepository.fechaDevolucion(librosPrestadosDTO.getClienteID(),librosPrestadosDTO.getLibrosPrestadoID()));
                    }
                break;
                case 1:
                    librosPrestadosDTO = mapper.toDTO(librosPrestadosCrudRepository.save(librosPrestados));
                    if (librosPrestadosDTO != null && librosPrestadosDTO.getClienteID() != 0) {
                        successMessage.append("El préstamo se ha creado exitosamente con el libro con el ID: ")
                                        .append(librosPrestadosDTO.getLibroID())
                                        .append("\n")
                                        .append("con fecha de devolución el día: ")
                                        .append(parametrosLibrosRepository.fechaDevolucion(librosPrestadosDTO.getClienteID(),librosPrestadosDTO.getLibrosPrestadoID()));
                    }
                break;
                default:
                    successMessage.append("Error al crear el préstamo");
            }
        return successMessage.toString();
    }
    public Boolean ValidarSiTieneLibros(Optional<ClienteDTO>  clienteDTO){
        boolean presta = true;
        if(parametrosLibrosRepository.prestaLibro(clienteDTO.get().getClienteID()) != null){
            presta = false;
        }
        return presta;
    }
}
