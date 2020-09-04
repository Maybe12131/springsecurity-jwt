package com.cc.security.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
//prefix+name通过application.yml文件配置是否启动swagger在线生成文档
@ConditionalOnProperty(prefix = "swagger", name = "open", havingValue = "true")
public class SwaggerConfig {
    /**
     * 创建获取api应用
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //这里采用包含注解的方式来确定要显示的接口(建议使用这种)
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }
    /**
     * 配置swagger文档显示的相关内容标识(信息会显示到swagger页面)
     * @return
     */
    private ApiInfo apiInfo() {
        Contact contact = new Contact("cloud","","666666666@qq.com");
        return new ApiInfo(
                "test",
                "test开放的接口",
                "v1.0",
                "",
                contact,
                "",
                "",
                new ArrayList<>()
        );
    }
}