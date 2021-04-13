package com.guighost.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author GuiGhost
 * @date 2021/03/20
 * @className Department()
 * 描述：部门实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Integer id;
    private String depName;
}
