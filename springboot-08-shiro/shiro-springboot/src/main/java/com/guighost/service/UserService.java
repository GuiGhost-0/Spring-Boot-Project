package com.guighost.service;

import com.guighost.entity.User;

/**
 * @author GuiGhost
 * @date 2021/03/28
 * @interfaceName UserService()
 * 描述：用户业务接口
 */
public interface UserService {
    public User queryUserByName(String name);
}
