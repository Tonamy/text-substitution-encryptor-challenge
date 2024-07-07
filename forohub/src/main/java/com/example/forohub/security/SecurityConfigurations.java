package com.example.forohub.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// Anotación para indicar que esta clase es una configuración de seguridad
@Configuration
// Habilitar la configuración de seguridad web
@EnableWebSecurity
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

    // Método para configurar la seguridad HTTP
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Configurar la autorización de solicitudes HTTP
        http.authorizeRequests()
                // Todas las solicitudes a '/topics/**' deben estar autenticadas
                .antMatchers("/topics/**").authenticated()
                // Permitir el acceso a todas las demás rutas sin autenticación
                .anyRequest().permitAll()
                .and()
                // Habilitar el formulario de inicio de sesión
                .formLogin();
    }
}
