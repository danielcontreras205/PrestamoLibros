package com.libreria.PrestamoLibros.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.PasswordManagementDsl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
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
                .requestMatchers(HttpMethod.GET, "/estado/**").permitAll() //permite consumir sin autorizacion pero solo los GET
                .requestMatchers(HttpMethod.POST, "/cliente/**").hasRole("Afiliado") // solo los admins pueden hacer post en libros
                //.requestMatchers(HttpMethod.POST,"/libro/books").hasAuthority("libro_books","ROLE_Afiliado") // el que tenga el permiso puede hacer cunsumo de este endPoint
                .requestMatchers(HttpMethod.POST,"/libro/books").hasAnyAuthority("libro_books","ROLE_Afiliado")
                .requestMatchers("/libro/**").hasAnyRole("Afiliado", "Empleado")  // los que tenga roles pueden hacer get en clientes
                .requestMatchers(HttpMethod.PUT).denyAll() // denega todos los metodos put
                .requestMatchers(HttpMethod.DELETE).denyAll() // denega todos los metodos Delete
                .anyRequest() // cualquier peticion que llegue
                .authenticated()// debe estar auntenticado
                .and() // y
                .httpBasic(); // debe estar en la metologia Basic
        return httpSecurity.build();
    }
    /*@Bean
    public UserDetailsService memoryUser(){ //Crear usuario en memoria
        UserDetails admin = User.builder()
                .username("admin") //usuario
                .password(passwordEncoder().encode("admin")) // contraseña encriptada
                .roles("ADMINISTRADOR")
                .build();

        UserDetails custumer = User.builder()
                .username("custumer") //usuario
                .password(passwordEncoder().encode("custumer123")) // contraseña encriptada
                .roles("CUSTOMER")
                .build();

        return new InMemoryUserDetailsManager(admin,custumer); // retorna el usuario
    }*/
    @Bean
    public PasswordEncoder passwordEncoder(){ // metodo para encriptar la contraseña
        return new BCryptPasswordEncoder();
    }
}
