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
public class LibrosDTO {
    private int libroID;
    private String titulo;
    private String autor;
    private String anoPublicacion;
    private String isbn;
    private Date creacion;
    private Date edito;
}
