package br.com.mct.gws.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Permitir todas as origens para o endpoint /api/empresas
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:9000", "http://localhost:9001") // URL do seu front-end
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*");
    }
}
