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
public class ParametrosLibrosDTO {
    private int parametroID;
    private int tipoClienteID; // Puede ser utilizado para representar la relación con TipoCliente
    private int diasPrestamo;
    private Date creacion;
    private Date edito;
}
