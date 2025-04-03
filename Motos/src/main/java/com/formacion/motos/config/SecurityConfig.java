package com.formacion.motos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
	        .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF si no lo necesitas
	        .authorizeHttpRequests(request -> request
	            .requestMatchers("/login", "/registro").permitAll()  // Permitir acceso a las páginas de login y registro
	            .requestMatchers("/principal").authenticated()      // Asegurarse de que "/principal" requiere autenticación
	            .anyRequest().permitAll()
	        )
	        .logout(logout -> logout
	            .logoutUrl("/logout") // URL para hacer logout
	            .logoutSuccessUrl("/") // Redirige a la página de login después del logout
	            .invalidateHttpSession(true) // Invalidar la sesión del usuario
	            .clearAuthentication(true)   // Limpiar la autenticación del usuario
	        );

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

