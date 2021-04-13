package com.guighost.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

/**
 * @author GuiGhost
 * @date 2021/03/19
 * @className IndexController()
 * 描述：
 */
//templates目录下的所有页面，只能通过controller来跳转（需要模板引擎的支持）
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("msg","<h1>Hello，Thymeleaf</h1>");
        model.addAttribute("users", Arrays.asList("gui","guigui"));
        return "index";
    }
}
