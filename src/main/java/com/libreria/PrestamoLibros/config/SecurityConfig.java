package com.libreria.PrestamoLibros.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        /*httpSecurity.authorizeHttpRequests()// para autorizar las peticiones HTTP
                    .anyRequest() // cualquier peticion que llegue
                    .permitAll(); // la permita*/

        httpSecurity
                .csrf().disable() // permite seguridad pero al colocar JWT precenta inconvenientes en la aplicacion
                .cors().and() // permite la comunicacion de 2 origenes diferentes EJEMPLO: localHost:8080 y front 42000
                .authorizeHttpRequests()// para autorizar las peticiones HTTP
                .requestMatchers(HttpMethod.GET, "/libro/**").permitAll() //permite consumir sin autorizacion pero solo los GET
                .requestMatchers(HttpMethod.PUT).denyAll() // denega todos los metodos put
                .anyRequest() // cualquier peticion que llegue
                .authenticated()// debe estar auntenticado
                .and() // y
                .httpBasic(); // debe estar en la metologia Basic
        return httpSecurity.build();
    }
}
