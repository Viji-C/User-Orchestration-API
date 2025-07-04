package com.task.users.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI userManagementOpenAPI() {
        return new OpenAPI()
            .info(new Info().title("User Management API")
                .description("API for managing user data from dummyjson.com")
                .version("v1.0")
                .contact(new Contact()
                    .name("API Support")
                    .email("vijichinnaraj2001@gmail.com"))
                .license(new License()
                    .name("Apache 2.0")
                    .url("https://springdoc.org")));
    }
}