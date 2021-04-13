package com.guighost.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author GuiGhost
 * @date 2021/03/28
 * @className MyController()
 * 描述：
 */
@Controller
public class MyController {

    @RequestMapping({"/","/index","/index.html"})
    public String toIndex(Model model){
        model.addAttribute("msg","Hello Shiro!!");
        return "index";
    }

    @RequestMapping("/user/add")
    public String add(){
        return "user/add";
    }

    @RequestMapping("/user/update")
    public String update(){
        return "user/update";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(String username,String password,boolean rememberMe,Model model){
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();

        //封装用户的登录数据——>令牌
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //设置记住我
        token.setRememberMe(rememberMe);

        //登录令牌
        try{
            subject.login(token);//执行登录的方法，如果没有异常，就说明已经OK了
            return "index";
        }catch (UnknownAccountException e){ //用户名不存在
            model.addAttribute("msg","用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e){ //密码不存在
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }

    //跳转到未授权页面
    @RequestMapping("/noauth")
    @ResponseBody
    public String unauthorized(){
        return "未经授权，无法访问此页面";
    }


    //注销
    @RequestMapping("/logout")
    public String logout(){
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }
}
