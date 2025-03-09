package in.aditya.springboot.assignment3restfulwebservices.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "User API", version = "1.0", description = "User management API"))
public class SwaggerConfig {}