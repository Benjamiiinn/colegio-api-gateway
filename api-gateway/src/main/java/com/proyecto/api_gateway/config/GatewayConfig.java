package com.proyecto.api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Defines gateway routes programmatically in Java instead of YAML.
 * This guarantees the routes are loaded regardless of any YAML parsing issues.
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service-auth", r -> r
                        .path("/api/v1/auth/**")
                        .uri("lb://USER-SERVICE"))

                .route("user-service-usuarios", r -> r
                        .path("/api/v1/usuarios/**")
                        .uri("lb://USER-SERVICE"))

                .route("academy-service", r -> r
                        .path("/api/v1/cursos/**", "/api/v1/asignaturas/**",
                              "/api/v1/matriculas/**", "/api/v1/calificaciones/**")
                        .uri("lb://ACADEMY-SERVICE"))

                .route("records-service", r -> r
                        .path("/api/v1/asistencias/**", "/api/v1/anotaciones/**")
                        .uri("lb://RECORDS-SERVICE"))

                .build();
    }
}
