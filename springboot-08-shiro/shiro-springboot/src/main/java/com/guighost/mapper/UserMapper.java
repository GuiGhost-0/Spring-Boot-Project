package com.guighost.mapper;

import com.guighost.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author GuiGhost
 * @date 2021/03/28
 * @interfaceName UserMapper()
 * 描述：用户mapper接口
 */
@Mapper
@Repository
public interface UserMapper {
    public User queryUserByName(@Param("name") String name);
}
