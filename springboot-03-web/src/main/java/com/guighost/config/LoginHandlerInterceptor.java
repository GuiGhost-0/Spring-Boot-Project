package com.guighost.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author GuiGhost
 * @date 2021/03/21
 * @className LoginHandlerInterceptor()
 * 描述：登录拦截器
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录成功之后，应该放行，因为有用户的session
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser==null){//没有登录
            request.setAttribute("msg","无法访问，未登录");
            //这里html不是页面，而是我们自定义跳转的视图的路径（注意：只能跳转到controller或者视图解析器配置的路径）
            request.getRequestDispatcher("/login.html").forward(request,response);
            return false;
        }else {
            return true;
        }
    }
}
