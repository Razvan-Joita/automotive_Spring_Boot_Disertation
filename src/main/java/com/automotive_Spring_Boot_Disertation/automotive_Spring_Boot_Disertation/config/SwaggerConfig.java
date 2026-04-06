package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Automotive API")
                        .version("1.0")
                        .description("Automotive Management System"));
    }
}