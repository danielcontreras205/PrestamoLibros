package com.libreria.PrestamoLibros.domain.service;

import com.libreria.PrestamoLibros.persistence.crud.UsuarioRepository;
import com.libreria.PrestamoLibros.persistence.entity.Usuario;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UserSecurityService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = this.usuarioRepository.findByUsuarioNombre(username)
                .orElseThrow(() -> new UsernameNotFoundException("usuario: " + username + "no encontrado."));
        return User.builder()
                .username(usuario.getUsuarioNombre())
                .password(usuario.getUsuarioContraseña())
                .roles("Afiliado")
                .accountLocked(usuario.getUsuarioBloqueado())
                .disabled(usuario.getUsuarioActivo())
                .build();
    }
}
