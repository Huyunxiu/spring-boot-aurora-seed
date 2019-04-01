package com.github.huyunxiu.seed.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.ServletContext;

/**
 * @author huyunxiu01@gmail.com
 * @since 2019-03-29
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Value("${project.swagger.enabled}")
    Boolean swaggerEnabled;

    @Value("${spring.application.name}")
    String applicationName;

    @Bean
    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title(applicationName)
            .description("")
            .build();
    }

    @Bean
    public Docket createApiDoc(ServletContext servletContext) {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .enable(swaggerEnabled)
			.select()
            .apis(RequestHandlerSelectors.basePackage("com.github.huyunxiu.seed.controller"))
            .paths(PathSelectors.any())
            .build()
			.host("")
            .pathMapping("/");
    }
}
