package com.libreria.PrestamoLibros.persistence.crud;

import com.libreria.PrestamoLibros.persistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario,String> {
    Optional<Usuario> findByUsuarioNombre(String username);

}
