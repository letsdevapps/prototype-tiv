package com.prototype;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.apachecommons.CommonsLog;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@CommonsLog
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
    	log.info("----- Swagger Configuration | Docket -----");
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.prototype.api"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
    	log.info("----- Swagger Configuration | Api info -----");
        return new ApiInfoBuilder()
                .title("API Documentation")
                .description("API documentation para o prototipo da Tivia")
                .version("1.0.0")
                .build();
    }
}