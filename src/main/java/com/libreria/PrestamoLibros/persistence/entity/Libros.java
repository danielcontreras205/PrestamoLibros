/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.PrestamoLibros.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author AsRock
 */
//------------------------------lombok------------------------------------------
@Data // JPA - crea los get y set 
@AllArgsConstructor // constructor con todos los argumentos
@NoArgsConstructor // constructor sin argumentos 
//-------------------------------------------------------------------------
@Entity
@Table(name = "Libros")
public class Libros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "libroID")
    private int libroID;
    @NotBlank(message = "El título no puede estar vacío")
    @Column(name = "titulo")
    private String titulo;
    @NotBlank(message = "El autor no puede estar vacío")
    @Column(name = "autor")
    private String autor;
    private String anoPublicacion;
    private String isbn;
    @Temporal(TemporalType.DATE)
    private Date creacion;
    @Temporal(TemporalType.DATE)
    private Date edito;
}
