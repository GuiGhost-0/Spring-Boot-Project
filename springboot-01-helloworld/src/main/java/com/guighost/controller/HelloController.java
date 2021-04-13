package com.guighost.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author GuiGhost
 * @date 2021/03/15
 * @className HelloController()
 * 描述：
 */
//SpringBoot可以热部署
@Controller
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }
}
