package com.guighost.config;


import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author GuiGhost
 * @date 2021/03/28
 * @className ShiroConfig()
 * 描述：Shiro配置类
 */
@Configuration  //JavaConfig方式
public class ShiroConfig {

    /**
     * ShiroFilterFactoryBean
     * DefaultWebSecurityManager
     * Realm对象，需要自定义（继承AuthorizingRealm类）
     *
     * 代码写法：
     * 1. Realm对象，需要自定义（继承AuthorizingRealm类）
     * 2. DefaultWebSecurityManager
     * 3. ShiroFilterFactoryBean
     * 注意：写完之后，将这三个对象注入到spring容器中，使用@Bean注解
     * */

    /**
     * cookie管理对象
     * @return
     */
    @Bean
    public CookieRememberMeManager rememberMeManager(@Qualifier("rememberMeCookie") SimpleCookie rememberMeCookie){
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie);
        //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
        cookieRememberMeManager.setCipherKey(Base64.decode("zyueODNWdSy+3MnnsYpvsA=="));
        return cookieRememberMeManager;
    }

    @Bean
    public SimpleCookie rememberMeCookie(){
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //setcookie的httponly属性如果设为true的话，会增加对xss防护的安全系数。它有以下特点：
        //setcookie()的第七个参数
        //设为true后，只能通过http访问，javascript无法访问
        //防止xss读取cookie
        simpleCookie.setHttpOnly(true);
        simpleCookie.setPath("/");
        //记住我cookie生效时间 ,单位秒
        simpleCookie.setMaxAge(30);
        return simpleCookie;
    }



    //ShiroFilterFactoryBean    3
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置SecurityManager：安全管理器
        bean.setSecurityManager(securityManager);
        //添加shiro的内置过滤器
        /**
         * anon：无需认证，即可访问
         * authc：必须认证了才能访问
         * user：必须拥有记住我 功能才能用
         * perms：拥有对某个资源的权限才能访问
         * roles：拥有某个角色权限才能访问
         * */

        /**
         * HashMap：k的值没有顺序，常用来做统计
         * LinkedHashMap：它内部有一个链表，保持Key插入的顺序。迭代的时候，也是按照插入顺序迭代，而且迭代比HashMap快
         * LinkedHashMap拥有 HashMap 的所有特性，它比 HashMap 多维护了一个双向链表
         * */
        Map<String, String> filterMap = new LinkedHashMap<String, String>();
        //授权：正常情况，没有授权会跳转到未授权页面
        //：给/user/add请求路径设置一个权限：——> 一个user用户的add权限
        filterMap.put("/user/add","perms[user:add]");
        filterMap.put("/user/update","perms[user:update]");
        //注销：（记住我状态下，可清除记住我的cookie）
        filterMap.put("/logout","logout");


        /**设置拦截的请求：
         * 这里拦截的是：user下的所有请求
         */
        filterMap.put("/user/*","authc");
        bean.setFilterChainDefinitionMap(filterMap);

        //设置登录的请求
        bean.setLoginUrl("/toLogin");
        //设置未授权页面
        bean.setUnauthorizedUrl("/noauth");
        return bean;
    }
    //DefaultWebSecurityManager 2
    /**
     * @Qualifier("userRealm") UserRealm userRealm
     * @Qualifier 注解指定了参数的类型，就是注解当中的值，值为的方法名，
     * 也可以通过@Bean(name="xxx")注解的name属性指定
     * */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm,
                                                               @Qualifier("rememberMeManager") CookieRememberMeManager rememberMeManager){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);
        //设置记住我管理
        securityManager.setRememberMeManager(rememberMeManager);
        return securityManager;
    }
    //创建realm对象，需要自定义   1
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }


    //整合ShiroDialect：用来整合shiro thymeleaf
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }
}
