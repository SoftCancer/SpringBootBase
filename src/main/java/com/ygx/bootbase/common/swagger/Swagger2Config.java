package com.ygx.bootbase.common.swagger;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description: Swagger 配置类
 * @author: YaoGuangXun
 * @date: 2021/1/7 22:51
 * @Version: 1.0
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    /**
     * 创建该API的基本信息（这些基本信息会展现在文档页面中）
     * 访问地址：http://项目实际地址/swagger-ui.html
     * @return
     */
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                // 指定构建 api 文档的详细信息的方法：apiInfo()
                .apiInfo(apiInfo())
                .select()
        // 指定要生成 api 接口的包路径，这里把 controller 作为包路径，生成 controller 中的所有接口
                .apis(RequestHandlerSelectors.basePackage("com.ygx.bootbase.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 创建该API的基本信息（这些基本信息会展现在文档页面中）
     * 访问地址：http://项目实际地址/swagger-ui.html
     * @return
     */
    private ApiInfo apiInfo(){
       Contact contact = new Contact("Swagger2","http://localhost:8081/swagger-ui.html","xxx.163.com");
        return new ApiInfoBuilder()
                .title("SpringBoot 集成Swagger2 Api接口")
                .description("Springboot 基础框架搭建 Swagger2 在线接口文档")
                .contact(contact).version("v1.0.0").build();
    }

}
