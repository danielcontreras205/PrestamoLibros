/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.libreria.PrestamoLibros.persistence.crud;

import com.libreria.PrestamoLibros.persistence.entity.Libros;
import com.libreria.PrestamoLibros.persistence.entity.ParametrosLibros;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author AsRock
 */
public interface ParametrosLibrosCrudRepository extends CrudRepository<ParametrosLibros, Integer> {
    @Query(value = """
            SELECT
                DATE(lipr.fecha_prestamo + INTERVAL '1 day' * pali.dias_prestamo) AS fecha_devolucion
            FROM
                cliente clie
                INNER JOIN tipo_cliente ticl ON clie.tipo_clienteid = ticl.tipo_clienteid
                INNER JOIN parametros_libros pali ON ticl.tipo_clienteid = pali.tipo_clienteid
                INNER JOIN libros_prestados lipr ON clie.clienteid = lipr.clienteid
                INNER JOIN libros libr ON lipr.libroid = libr.libroid
            WHERE
                clie.clienteid = :customerId
                and lipr.libros_prestadoid = :librosPrestadoId
            """, nativeQuery = true)
    Date fechaDevolucion(@Param("customerId") int customerId, @Param("librosPrestadoId") int librosPrestadoId);
    @Query(value = """
            SELECT
            	'ID del Libro: ' ||libr.libroid || ' Titulo del libro:' || libr.titulo AS texto
            FROM
            	cliente clie
            	inner join tipo_cliente ticl ON  clie.tipo_clienteid = ticl.tipo_clienteid
            	inner join parametros_libros pali ON ticl.tipo_clienteid = pali.tipo_clienteid
            	inner join libros_prestados lipr ON clie.clienteid = lipr.clienteid
            	inner join libros libr on lipr.libroid = libr.libroid
            WHERE
            	clie.clienteid = :customerId
            """, nativeQuery = true)
    String prestaLibro(@Param("customerId") int customerId);
}