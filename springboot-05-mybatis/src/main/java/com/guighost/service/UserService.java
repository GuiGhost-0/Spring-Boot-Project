package com.guighost.service;

import com.guighost.entity.User;


import java.util.List;

/**
 * @author GuiGhost
 * @date 2021/03/24
 * @interfaceName UserService()
 * 描述：用户业务接口
 */
public interface UserService {
    List<User> getUsers();
    User getUserById(Integer id);
    Integer addUser(User user);
    Integer updUser(User user);
    Integer delUser(Integer id);
}
