package com.roshi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Roshi AI - API")
                        .version("0.0.1")
                        .description("""
        Roshi AI is an intelligent agent for Dragon Ball FighterZ players,\s
        designed to assist with combo translations, explain game concepts,\s
        and provide valuable insights on team composition. Welcome, Fighter
   \s"""));
    }
}
