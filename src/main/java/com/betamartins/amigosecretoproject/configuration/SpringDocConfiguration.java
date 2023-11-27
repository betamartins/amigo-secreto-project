package com.betamartins.amigosecretoproject.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("Projeto - Amigo secreto")
                        .description("Projeto para sorteio de amigo secreto e envio por e-mail do nome tirado.")
                        .contact(new Contact()
                                .name("Anderson Martins")
                                .email("anderson@betamartins.com")
                        )
                        .version("v0.0.1")
                        .license(new License()
                                .name("Betamartins")
                                .url("https://www.betamartins.com")
                        )
                );
    }

}
