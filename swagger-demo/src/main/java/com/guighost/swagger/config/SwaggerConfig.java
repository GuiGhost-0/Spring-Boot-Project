package com.guighost.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


import java.util.ArrayList;

/**
 * @author GuiGhost
 * @date 2021/03/29
 * @className SwaggerConfig()
 * 描述：Swagger配置类
 */
@Configuration
@EnableOpenApi    //开启Swagger2
public class SwaggerConfig {

    //配置了Swagger的Docket的bean实例
    @Bean
    public Docket docket(Environment environment){

        //获取项目的环境：
        //设置要显示的Swagger环境
        Profiles profiles = Profiles.of("dev","test");//是dev或者test的环境，就打开Swagger，否则就关闭
        //通过environment.acceptsProfiles判断是否处在自己设定的环境当中
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())//关联apiInfo
                .enable(flag)//关闭Swagger
                .groupName("OAS_30 Group")
                .select()// 通过.select()方法，去配置扫描接口,RequestHandlerSelectors配置如何扫描接口
                /**
                 * RequestHandlerSelectors：配置要扫描接口的方式：
                 * basePackage("")：指定要扫描的包
                 * any()：扫描全部
                 * none()：都不扫描
                 * withClassAnnotation()：扫描类上的注解——参数为注解的反射对象（如:GetMapping.class）
                 * withMethodAnnotation()：扫描方法上的注解
                */
                .apis(RequestHandlerSelectors.basePackage("com.guighost.swagger.controller"))
                /**
                 * path()：过滤什么路径(只能扫描到/guighost/路径下的所有请求，由于还配置了apis，所以限定范围更窄了)
                 * 这里只扫描com.guighost.swagger.controller包下的并且只能是/guighost/下的所有请求
                 * */
//                .paths(PathSelectors.ant("/guighost/**"))
                .build();
    }

    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.OAS_30).groupName("Group1");
    }

    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.OAS_30).groupName("Group2");
    }

    //配置Swagger信息
    public ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("GuiGhost", "", "ZGH_0621@163.com");
        return new ApiInfo(
                "GuiGhost's SwaggerAPI Document",
                "不断进步，就是最大的收获",
                "v1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList()
        );
    }
}
