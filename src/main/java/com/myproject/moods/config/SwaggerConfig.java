package com.myproject.moods.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 孟祥迎
 * @version 1.0
 * @Date 2021-04-16
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * Swagger使用的配置文件
     */
        @Bean
        public Docket createRestApi(){
            return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo())
                    .select()
                    .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                    .paths(PathSelectors.any())
                    .build();
        }

        //基本信息的配置，信息会在api文档上显示
        private ApiInfo apiInfo(){
            return new ApiInfoBuilder()
                    .title("漂流瓶接口文档")
                    .description("用户漂流瓶项目的相关接口的文档")
//                    .termsOfServiceUrl("http://localhost:8080/hello")
                    .version("1.0")
                    .build();
        }
    }

