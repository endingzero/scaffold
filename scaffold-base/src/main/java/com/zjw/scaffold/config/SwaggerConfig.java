package com.zjw.scaffold.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program scaffold
 * @description:swagger配置
 * @author: zhuangjiewei
 * @create: 2019/03/28 15:10
 */
@Configuration
@EnableSwagger2
@Profile("dev")
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.apiInfo());
                //.securitySchemes(Lists.newArrayList(this.apiKey(), this.storeKey()));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("脚手架API")
                .description("脚手架的后台接口")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .termsOfServiceUrl("")
                .version("1.0")
                .contact(new Contact("ending","", ""))
                .build();
    }
}
