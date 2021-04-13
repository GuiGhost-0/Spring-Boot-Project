package com.guighost.service.impl;

import com.guighost.entity.User;
import com.guighost.mapper.UserMapper;
import com.guighost.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GuiGhost
 * @date 2021/03/24
 * @className UserServiceImpl()
 * 描述：
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public List<User> getUsers() {
        return mapper.getUsers();
    }

    @Override
    public User getUserById(Integer id) {
        return mapper.getUserById(id);
    }

    @Override
    public Integer addUser(User user) {
        return mapper.addUser(user);
    }

    @Override
    public Integer updUser(User user) {
        return mapper.updUser(user);
    }

    @Override
    public Integer delUser(Integer id) {
        return mapper.delUser(id);
    }
}
