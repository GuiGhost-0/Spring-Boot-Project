package com.guighost.controller;

import com.guighost.entity.User;
import com.guighost.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author GuiGhost
 * @date 2021/03/24
 * @className UserController()
 * 描述：
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/addUser")
    public Integer addUser(){
        return userService.addUser(new User(9,"小屋","xiaowu"));
    }
    @GetMapping("/updUser")
    public Integer updUser(){
        return userService.updUser(new User(9,"小五","xiaowu"));
    }
    @GetMapping("/delUser/{id}")
    public Integer delUser(@PathVariable("id") Integer id){
        return userService.delUser(id);
    }

}
