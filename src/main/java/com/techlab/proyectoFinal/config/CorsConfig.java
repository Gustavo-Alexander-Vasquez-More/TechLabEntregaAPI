package com.techlab.proyectoFinal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")  // Aplica a todos los endpoints
                        .allowedOrigins("*")  // Permite todos los orígenes
                        .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")  // Todos los métodos HTTP
                        .allowedHeaders("*")  // Permite todos los headers
                        .maxAge(3600);  // Cache de preflight por 1 hora
            }
        };
    }
}

