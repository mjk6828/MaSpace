package com.maspace.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "MaSpace Title",
        description = "MaSpace API",
        version = "0.9")
)
@Configuration
public class SwaggerConfig {

}