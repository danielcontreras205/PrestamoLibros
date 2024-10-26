package com.libreria.PrestamoLibros.domain.service;

import com.libreria.PrestamoLibros.persistence.crud.UsuarioRepository;
import com.libreria.PrestamoLibros.persistence.entity.Usuario;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

        System.out.println(usuario.toString());

        // se crea un arreglo, esto es por si un usuario tiene varios roles, pero en esta api la logica es que un usuario solo tiene un rol
        String[] roles = new String[] { usuario.getTipoCliente().getNombreTipo() };
        return User.builder()
                .username(usuario.getUsuarioNombre())
                .password(usuario.getUsuarioContraseña())
                //.roles(roles) //se aplica por rol
                .authorities(this.grantedAuthorities(roles)) // permisos por roles
                .accountLocked(usuario.getUsuarioBloqueado())
                .disabled(usuario.getUsuarioActivo())
                .build();
    }
    private String[] getAuthorities(String role){
        if("Invitado".equals(role)){
            return new String[] {"libro_books"};
        }
        return new String[]{};
    }
    /**
     *Este metodo es el hace internamente Spring Boot para los roles ctrl + click en .roles
     *
     * @param roles
     * @return retorna ROLE_(roles del usuario)
     */
    private List<GrantedAuthority> grantedAuthorities(String[] roles){
        List<GrantedAuthority> authority = new ArrayList<>(roles.length);
        for (String iteraRoles : roles ){
            authority.add(new SimpleGrantedAuthority("ROLE_" + iteraRoles));
            for(String iteraPermisos : this.getAuthorities(iteraRoles)){
                authority.add(new SimpleGrantedAuthority(iteraPermisos));
            }
        }

        return authority;
    }
}
