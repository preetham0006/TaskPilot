package com.preetham.taskpilot.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI taskPilotOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("TaskPilot REST API")
                        .version("1.0")
                        .description("RESTful Task Management Backend built using Spring Boot")
                        .contact(new Contact()
                                .name("Preetham Gowda")
                                .email("preethampreethu1613@gmail.com")
                        ));
    }
}