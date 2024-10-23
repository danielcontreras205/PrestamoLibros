package com.libreria.PrestamoLibros.persistence.mapper;

import com.libreria.PrestamoLibros.domain.dto.UsuarioDTO;
import com.libreria.PrestamoLibros.persistence.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EstadoMapper.class})
public interface UsuarioMapper {
    @Mappings({
            @Mapping(source = "usuarioId", target = "usuarioId"),
            @Mapping(source = "usuarioNombre", target = "usuarioNombre"),
            @Mapping(source = "usuarioContraseña", target = "usuarioContraseña"),
            @Mapping(source = "usuarioCorreo", target = "usuarioCorreo"),
            @Mapping(source = "usuarioActivo", target = "usuarioActivo"),
            @Mapping(source = "usuarioBloqueado", target = "usuarioBloqueado"),
            @Mapping(source = "usuarioCreacion", target = "usuarioCreacion"),
            @Mapping(source = "usuarioEdito", target = "usuarioEdito"),
            @Mapping(source = "tipoCliente.tipoClienteID", target = "tipoClienteID")
    })
    UsuarioDTO toDTO(Usuario usuario);
    List<UsuarioDTO> toDTOs(List<Usuario> usuario);
    @Mappings({
            @Mapping(source = "usuarioId", target = "usuarioId"),
            @Mapping(source = "usuarioNombre", target = "usuarioNombre"),
            @Mapping(source = "usuarioContraseña", target = "usuarioContraseña"),
            @Mapping(source = "usuarioCorreo", target = "usuarioCorreo"),
            @Mapping(source = "usuarioActivo", target = "usuarioActivo"),
            @Mapping(source = "usuarioBloqueado", target = "usuarioBloqueado"),
            @Mapping(source = "usuarioCreacion", target = "usuarioCreacion"),
            @Mapping(source = "usuarioEdito", target = "usuarioEdito"),
            @Mapping(source = "tipoClienteID", target = "tipoCliente.tipoClienteID")
    })
    Usuario toEntity(UsuarioDTO usuarioDTO);
}
