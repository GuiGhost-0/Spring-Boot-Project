package com.guighost.mapper;

import com.guighost.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author GuiGhost
 * @date 2021/03/24
 * @interfaceName UserMapper()
 * 描述：用户mapper接口
 */
@Mapper //该注解表示此类为mybatis的mapper类
@Repository
public interface UserMapper {
    List<User> getUsers();
    User getUserById(@Param("id") Integer id);
    Integer addUser(User user);
    Integer updUser(User user);
    Integer delUser(@Param("id") Integer id);
}
