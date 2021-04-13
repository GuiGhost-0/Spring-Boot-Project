package com.guighost.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author GuiGhost
 * @date 2021/03/20
 * @className Employee()
 * 描述：员工信息表
 */
@Data
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String empName;
    private String email;
    private Integer gender;//0：女    1：男
    private Department department;
    private Date birth;

    public Employee(Integer id, String empName, String email, Integer gender, Department department) {
        this.id = id;
        this.empName = empName;
        this.email = email;
        this.gender = gender;
        this.department = department;
        //默认创建日期
        this.birth = new Date();
    }
}
