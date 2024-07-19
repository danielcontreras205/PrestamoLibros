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
public class LibrosPrestadosDTO {
    private int librosPrestadoID;
    private int libroID; // Puede ser utilizado para representar la relación con Libros
    private int clienteID; // Puede ser utilizado para representar la relación con Cliente
    private Date fechaPrestamo;
    private Date fechaDevolucion;
}
