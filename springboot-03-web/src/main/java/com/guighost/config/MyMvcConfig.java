package com.guighost.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author GuiGhost
 * @date 2021/03/20
 * @className MyMvcConfig()
 * 描述：
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    //视图跳转：用于静态资源页面（如首页）
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
        registry.addViewController("/index.html").setViewName("dashboard");
    }


    //将自定义的国际化组件注入容器中，就生效了
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).
                addPathPatterns("/**").//拦截的请求
                excludePathPatterns("/login.html","/","/user/login","/brand/**","/dist/**");//放行的请求
    }
}
