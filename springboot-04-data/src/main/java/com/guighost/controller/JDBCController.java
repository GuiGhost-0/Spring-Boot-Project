package com.guighost.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author GuiGhost
 * @date 2021/03/23
 * @className JDBCController()
 * 描述：
 */
@RestController
public class JDBCController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/getAll")
    public List<Map<String,Object>> getAll(){
        return jdbcTemplate.queryForList("select * from mybatis.user");
    }

    @RequestMapping("/addUser")
    public Integer addUser(){
        return jdbcTemplate.update("insert into mybatis.user(id, name, pwd) VALUES (6,'小gao','xioag345')");
    }

    @RequestMapping("/updUser/{id}/{name}/{pwd}")
    public Integer update(@PathVariable("id") Integer id,@PathVariable("name") String name,@PathVariable("pwd") String pwd){
        return jdbcTemplate.update("update mybatis.user set name=?,pwd=? where id=?",new Object[]{name,pwd,id});
    }

    @RequestMapping("/delUser/{id}")
    public Integer del(@PathVariable("id") Integer id){
        return jdbcTemplate.update("delete from mybatis.user where id=?",id);
    }
}
