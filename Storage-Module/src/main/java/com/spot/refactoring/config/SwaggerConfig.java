package com.spot.refactoring.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityScheme.Type;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
            .title("Ittple API Docs")
            .description("잇플 API 명세서")
            .version("v1.0.0");

        Components components = new Components()
            .addSecuritySchemes("access-token", new SecurityScheme()
                .type(Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT"));
        
        return new OpenAPI()
            .info(info)
            .components(components)
            .addSecurityItem(new SecurityRequirement().addList("access-token"));
    }
}