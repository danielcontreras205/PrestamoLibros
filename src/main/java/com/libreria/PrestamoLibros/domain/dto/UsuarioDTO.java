package com.libreria.PrestamoLibros.domain.dto;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class UsuarioDTO {
    private int usuarioId;
    private String usuarioNombre;
    private String usuarioContraseña;
    private String usuarioCorreo;
    private Boolean usuarioActivo;
    private  Boolean usuarioBloqueado;
    private Date usuarioCreacion;
    private Date usuarioEdito;
    private int tipoClienteID;

}
