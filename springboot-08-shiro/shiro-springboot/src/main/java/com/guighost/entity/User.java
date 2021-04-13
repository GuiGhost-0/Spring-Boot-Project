package com.guighost.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author GuiGhost
 * @date 2021/03/28
 * @className User()
 * 描述：用户实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{
    private Integer id;
    private String name;
    private String pwd;
    private String perms;
}
