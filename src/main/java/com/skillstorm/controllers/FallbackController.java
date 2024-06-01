package com.skillstorm.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cache")
public class FallbackController {

    // User service fallback:
    @RequestMapping("/users")
    public Mono<ResponseEntity<String>> usersFallback() {
        return Mono.just(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("User service is currently unavailable. Please try again later."));
    }

    // Form service fallback:
    @RequestMapping("/forms")
    public Mono<ResponseEntity<String>> formsFallback() {
        return Mono.just(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("Form service is currently unavailable. Please try again later."));
    }
}
