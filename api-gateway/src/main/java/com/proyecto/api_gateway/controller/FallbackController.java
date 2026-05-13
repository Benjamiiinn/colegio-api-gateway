package com.proyecto.api_gateway.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/userServiceFallback")
    public Mono<ResponseEntity<Map<String, String>>> userServiceFallback() {
        Map<String, String> response = new HashMap<>();
        response.put("mensaje", "El servicio de usuarios no esta disponible en este momento.");
        response.put("status", "503");
        return Mono.just(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response));
    }

    @GetMapping("/academyServiceFallback")
    public Mono<ResponseEntity<Map<String, String>>> academyServiceFallback() {
        Map<String, String> response = new HashMap<>();
        response.put("mensaje", "El servicio académico no responde. Por favor, intente más tarde.");
        response.put("status", "503");
        return Mono.just(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response));
    }

    @PostMapping("/userServiceFallback")
    public Mono<ResponseEntity<Map<String, String>>> userServiceFallbackPost() {
        Map<String, String> response = new HashMap<>();
        response.put("mensaje", "El servicio de usuarios no esta disponible en este momento.");
        response.put("status", "503");
        return Mono.just(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response));
    }

    @PostMapping("/academyServiceFallback")
    public Mono<ResponseEntity<Map<String, String>>> academyServiceFallbackPost() {
        Map<String, String> response = new HashMap<>();
        response.put("mensaje", "El servicio académico no responde. Por favor, intente más tarde.");
        response.put("status", "503");
        return Mono.just(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response));
    }

    @GetMapping("/recordServiceFallback")
    public Mono<ResponseEntity<Map<String, String>>> recordServiceFallback() {
        Map<String, String> response = new HashMap<>();
        response.put("mensaje", "El servicio académico no responde. Por favor, intente más tarde.");
        response.put("status", "503");
        return Mono.just(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response));
    }

    @PostMapping("/recordServiceFallback")
    public Mono<ResponseEntity<Map<String, String>>> recordServiceFallbackPost() {
        Map<String, String> response = new HashMap<>();
        response.put("mensaje", "El servicio de asistencias no responde. Por favor, intente más tarde.");
        response.put("status", "503");
        return Mono.just(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response));
    }

}
