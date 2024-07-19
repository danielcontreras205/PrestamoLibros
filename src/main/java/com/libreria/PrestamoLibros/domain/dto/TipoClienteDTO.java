/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.PrestamoLibros.domain.dto;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author AsRock
 */
@Data
public class TipoClienteDTO {
    private int tipoClienteID;
    private String nombreTipo;
    private int estadoID; 
    private Date creacion;
    private Date edito;
}
