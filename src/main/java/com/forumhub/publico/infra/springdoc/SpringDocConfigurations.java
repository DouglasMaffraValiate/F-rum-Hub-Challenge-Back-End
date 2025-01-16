package com.forumhub.publico.infra.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI(){
        final String securitySchemeName = "bearer-Key";

        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-Key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                .info(new Info()
                        .title("forum.hub API")
                        .description("API Rest genérica Fórum Hub Challenge Back End")
                        .contact(new Contact()
                                .name("Douglas Maffra")
                                .email("maffradouglasopo@gmail.com")));
    }

}
