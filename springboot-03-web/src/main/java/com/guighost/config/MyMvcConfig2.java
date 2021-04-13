package com.guighost.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

/**
 * @author GuiGhost
 * @date 2021/03/20
 * @className MyMvcConfig()
 * 描述：扩展SpringMVC
 * 如果我们要扩展SpringMVC，官方建议我们使用这种方式
 */
@Configuration
//@EnableWebMvc
/**
 * //这个注解就是导入一个类：DelegatingWebMvcConfiguration
 * 作用：从容器中获取所有的webmvcconfig
 * */
public class MyMvcConfig2 implements WebMvcConfigurer {
//    //视图跳转
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/guiTest").setViewName("test");
//        registry.addViewController("/").setViewName("index");
//    }
}
