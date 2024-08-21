package com.dm.start.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-08-19 18:46
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI swaggerOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("数据中心")
                        .description("数据中心")
                        .version("v1.0.0")
                ).externalDocs(new ExternalDocumentation()
                        .description("设计文档")
                        .url(""));
    }
}
