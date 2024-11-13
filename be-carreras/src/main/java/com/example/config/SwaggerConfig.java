package com.example.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Carreras API")
                        .description("API para la gestión de carreras")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Federico Simaro Bonastia")
                                .email("fsimarobonastia@alumnos.exa.unicen.edu.ar"))
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentación de referencia")
                        .url("https://github.com/fsimaro/microservicios/be-carreras"));
    }

}
