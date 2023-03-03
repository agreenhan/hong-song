package com.hongsong.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * @Description: 自定义 Swagger 接口文档的配置
 * @Author: agreenHan
 * @Date: 2023/2/26 14:51
 */
@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hongsong.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * @Description: knife4j  UI界面相关信息
     * @Author: agreenHan
     * @Date: 2023/2/26 15:06
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("hong-song")
                .description("洪松接口文档")
                .termsOfServiceUrl("www.baidu.com")
                .contact(new Contact("author","www.baidu.com","xxxxxxxxx@qq.com"))
                .version("1.0")
                .build();
    }
}
