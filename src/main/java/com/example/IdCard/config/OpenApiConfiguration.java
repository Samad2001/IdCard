package com.example.IdCard.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {



    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("learningSpringService")
                        .description(" for learning Spring framework"))
                        .externalDocs(new ExternalDocumentation()
                                .description("no documentation for Spring Framework")
                                .url("if you want doc, please connect with vs academy"));



    }
}
