/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.PrestamoLibros.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
@Table(name = "Cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clienteID;
    private String nombre;
    private String apellido;
    @ManyToOne
    @JoinColumn(name = "tipoClienteID")
    private TipoCliente tipoCliente;
    @ManyToOne
    @JoinColumn(name = "estadoID")
    private Estado estado;
    @Temporal(TemporalType.DATE)
    private Date creacion;
    @Temporal(TemporalType.DATE)
    private Date edito;
}
