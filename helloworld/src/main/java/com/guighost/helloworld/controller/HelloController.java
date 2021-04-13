package com.guighost.helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GuiGhost
 * @date 2021/03/15
 * @className HelloController()
 * 描述：
 */
@RestController
public class HelloController {

    // 接口：http://localhost:8080/hello
    @RequestMapping("/hello")
    public String hello(){
        //调用业务，接收前端参数
        return "hello,world!——hello SpringBoot!";
    }
}
