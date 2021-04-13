package com.guighost.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author GuiGhost
 * @date 2021/03/26
 * @className RouterController()
 * 描述：路由控制器
 */
@Controller
public class RouterController {
    @RequestMapping({"/", "/index"})
    public String index(){
        return "index";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/level1/{id}")
    public String toLevel1(@PathVariable("id") Integer id){
        return "level1/" + id;
    }

    @RequestMapping("/level2/{id}")
    public String toLevel2(@PathVariable("id") Integer id){
        return "level2/" + id;
    }

    @RequestMapping("/level3/{id}")
    public String toLevel3(@PathVariable("id") Integer id){
        return "level3/" + id;
    }
}
