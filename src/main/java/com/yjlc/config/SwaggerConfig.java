package com.yjlc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by dashang001 on 2018/7/25.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig{

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("demo")
                .apiInfo(apiInfo("1.0"))
                .select()
                .paths(PathSelectors.ant("/Seckil/**"))
                .build();
    }

    private ApiInfo apiInfo(String version) {
        return new ApiInfoBuilder()
                .title("Demo Product API")
                .description("This is the API for demo")
                .license("13722690614@163.com")
                .version(version)
                .build();
    }

}