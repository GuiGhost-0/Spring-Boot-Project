package com.guighost.swagger.controller;

import com.guighost.swagger.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GuiGhost
 * @date 2021/03/29
 * @className HelloController()
 * 描述：
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }


    //只要我们的接口中，返回值中存在实体类，他就会被扫描到Swagger中
    @PostMapping("/user")
    public User user(){
        return new User();
    }

    @ApiOperation("Hello 控制类")//给接口（controller）中的方法加注释,不是在类上
    @GetMapping("/hello2")
    //@ApiParam("用户名"):
    public String hello2(@ApiParam("用户名") String username){
        return "hello" + username;
    }
}
