package com.guighost.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author GuiGhost
 * @date 2021/03/26
 * @className SecurityConfig()
 * 描述：
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //链式编程

    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页任何人都可以访问，但功能页只有对应有权限的人才可以访问
        //以下是请求授权的规则
        http.authorizeRequests().antMatchers("/").permitAll()//所有人都可以访问
                .antMatchers("/level1/**").hasRole("vip1")//vip1可以访问
                .antMatchers("/level2/**").hasRole("vip2")//vip2可以访问
                .antMatchers("/level3/**").hasRole("vip3");//vip3可以访问


        //没有权限，默认跳到登录页,需要开启登录的页面
        //  /login
        http.formLogin()
                .usernameParameter("user")//登录传过来验证的参数名
                .passwordParameter("pwd")//登录传过来验证的参数名
                .loginPage("/login.html")//跳转到自定义的登录页
                .loginProcessingUrl("/login");//自定义页面实际提交的action地址

        //注销,开启了注销功能，注销后，返回登录页
//        http.csrf().disable();//关闭csrf功能:跨站请求伪造,默认只能通过post方式提交logout请求
        http.logout().logoutSuccessUrl("/");

        //开启Remember Me（记住我）功能：默认保存两周
        http.rememberMe().rememberMeParameter("remme");//remme为前端checkbox的name的属性值
    }


    //认证    springboot 2.1.x时，可以直接使用
    //新版本则会报一个错误：PasswordEncoder：密码编码 需要添加密码编码auth.PasswordEncoder
    //在Spring Security 5.0+ 新增了很多的加密方式
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //用户的数据正常应该从数据库中读取
        //在内存中定义，也可以在jdbc中去拿....
        //Spring security 5.0中新增了多种加密方式，也改变了密码的格式。
        //要想我们的项目还能够正常登陆，需要修改一下configure中的代码。我们要将前端传过来的密码进行某种方式加密
        //spring security 官方推荐的是使用bcrypt加密方式。

        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                //用户一
                .withUser("Ghost").password(new BCryptPasswordEncoder().encode("8888")).roles("vip1","vip3")
                //通过add()方法追加用户
                .and()
                //用户二
                .withUser("Old").password(new BCryptPasswordEncoder().encode("9999")).roles("vip2")
                .and()
                //用户三
                .withUser("ROOT").password(new BCryptPasswordEncoder().encode("ROOT")).roles("vip1","vip2","vip3");
    }
}
