package com.libreria.PrestamoLibros.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtil {
    private static String secretKey = "BooksChinauta2024";
    private static Algorithm algorithm = Algorithm.HMAC256(secretKey);
    public String create(String username){
        return JWT.create()
                .withSubject(username) //el asunto es el usuario
                .withIssuer("BooksChinauta") // creador del tocken
                .withIssuedAt(new Date()) // fecha de creacion
                .withExpiresAt(new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(15))) // fecha de expiracion
                .sign(algorithm);
    }
}
