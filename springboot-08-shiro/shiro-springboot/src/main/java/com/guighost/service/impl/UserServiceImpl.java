package com.guighost.service.impl;

import com.guighost.entity.User;
import com.guighost.mapper.UserMapper;
import com.guighost.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author GuiGhost
 * @date 2021/03/28
 * @className UserServiceImpl()
 * 描述：用户业务实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }
}
