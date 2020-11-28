package br.com.softfocus.gateway.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.CorsRegistry
import org.springframework.web.reactive.config.EnableWebFlux

@Configuration
@EnableWebFlux
class CorsGlobalConfiguration {
    fun addCorsMappings(corsRegistry: CorsRegistry) {
        corsRegistry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "PUT", "GET", "OPTIONS", "DELETE", "PATCH")
                .allowedHeaders("Origin", "Authorization", "Content-Type", "Accept", "X-CSRF-TOKEN")
                .allowCredentials(true)
                .maxAge(3600)
    }
}