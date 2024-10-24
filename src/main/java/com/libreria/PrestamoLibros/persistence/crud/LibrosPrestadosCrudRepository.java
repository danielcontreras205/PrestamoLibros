/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.libreria.PrestamoLibros.persistence.crud;

import com.libreria.PrestamoLibros.persistence.entity.LibrosPrestados;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author AsRock
 */
public interface LibrosPrestadosCrudRepository extends CrudRepository<LibrosPrestados, Integer> {
}
