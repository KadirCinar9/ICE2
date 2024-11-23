package ca.gbc.inventoryservice.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Value("${inventory-service-version}")
    private String version;
    @Bean
    public OpenAPI inventoryServiceApi(){

        return new OpenAPI().info(new Info().title("Product Service API")
                .description("This is a REST API for Product Service")
                .version(version)
                        .license(new License()
                                .name("Apache 2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("Inventory Service Wiki Documentation")
                .url("https://mycompany.ca/product-service/docs"));
    }
}
