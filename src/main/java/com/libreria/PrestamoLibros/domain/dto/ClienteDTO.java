/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.PrestamoLibros.domain.dto;

import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author AsRock
 */
@Data
@Getter
@Setter
public class ClienteDTO {
    
    private int clienteID;
    private String nombre;
    private String apellido;
    private int tipoClienteID;
    private int estadoID; 
    private Date creacion;
    private Date edito;
    
}
