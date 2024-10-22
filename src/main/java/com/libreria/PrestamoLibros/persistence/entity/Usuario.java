package com.libreria.PrestamoLibros.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//------------------------------lombok------------------------------------------
@Data // JPA - crea los get y set
@AllArgsConstructor // constructor con todos los argumentos
@NoArgsConstructor // constructor sin argumentos
//-------------------------------------------------------------------------
@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usuarioId;
    private String usuarioNombre;
    private String usuarioContraseña;
    private String usuarioCorreo;
    private Boolean usuarioActivo;
    private  Boolean usuarioBloqueado;
    @Temporal(TemporalType.DATE)
    private Date usuarioCreacion;
    @Temporal(TemporalType.DATE)
    private Date usuarioEdito;

}

