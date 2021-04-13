package com.guighost.config;

import org.apache.tomcat.jni.Local;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author GuiGhost
 * @date 2021/03/21
 * @className MyLocaleResolver()
 * 描述：国际化解析器
 */
public class MyLocaleResolver implements LocaleResolver {
    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        //获取请求中的语言参数
        String language = httpServletRequest.getParameter("l");
        Locale locale = Locale.getDefault();//如果没有就用默认的
        //如果请求的链接携带了国际化参数
        if (!StringUtils.isEmpty(language)){
            String[] split = language.split("_");//分割zh_CN
            locale = new Locale(split[0], split[1]);//国家，地区
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
