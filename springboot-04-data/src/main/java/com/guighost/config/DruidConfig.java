package com.guighost.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author GuiGhost
 * @date 2021/03/24
 * @className DruidConfig()
 * 描述：
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")//绑定application.yaml中的spring.datasource
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }


    //后台监控：相当于web.xml，ServletRegistrationBean
    //SpringBoot中内置了servlet容器，所以没有web.xml文件，替代方法：ServletRegistrationBean
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");

        //后台需要有人登录，账号密码配置
        Map<String,String> initParameters = new HashMap<String, String>();
        //增加配置
        initParameters.put("loginUsername","admin");//登录的key是固定的    loginUsername loginPassword
        initParameters.put("loginPassword","123456");

        //允许谁可以访问 key：allow，value：为空的话，所有人都可以访问
        initParameters.put("allow","localhost");
        //禁止谁能访问：initParameters.put("guighost","192.168.1.3");这个ip地址不能访问


        bean.setInitParameters(initParameters);
        return bean;
    }

    //Filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());
        //可以过滤哪些请求呢
        Map<String,String> initParameters = new HashMap<>();
        //这些东西，不进行统计
        initParameters.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(initParameters);
        return bean;
    }
}
