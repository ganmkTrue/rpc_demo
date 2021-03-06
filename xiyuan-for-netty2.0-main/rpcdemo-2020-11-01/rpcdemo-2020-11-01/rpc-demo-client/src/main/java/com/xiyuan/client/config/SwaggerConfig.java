package com.xiyuan.client.config;

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
 * swagger配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 这里配置swagger扫描的包
     *
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.xiyuan"))
                .paths(PathSelectors.any()).build();
    }

    /**
     * 这里配置swagger对外提供服务的端口
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("发布模拟boos接口")
                .description("简单优雅的发布模拟boos接口restful风格接口")
                // .termsOfServiceUrl("http://localhost:8080/swagger-ui.html")
                .version("1.0").build();
    }

}
