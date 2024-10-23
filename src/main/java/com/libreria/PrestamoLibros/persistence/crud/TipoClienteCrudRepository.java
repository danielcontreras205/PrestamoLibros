/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.libreria.PrestamoLibros.persistence.crud;

import com.libreria.PrestamoLibros.persistence.entity.TipoCliente;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author AsRock
 */
public interface TipoClienteCrudRepository extends CrudRepository<TipoCliente, Integer> {

    @Query(value = """
            select
            	ticl.tipo_clienteid,
            	ticl.creacion,
            	ticl.edito,
            	ticl.nombre_tipo,
            	ticl.estadoid
            from
            	cliente clie
            	inner join usuario usua on clie.usuario_id = usua.usuario_id
            	inner join tipo_cliente ticl on usua.tipo_clienteid = ticl.tipo_clienteid
            where
                usua.usuario_id = ?1
            """,nativeQuery = true)
    TipoCliente tipoCliente(int usuarioId);
    
}
