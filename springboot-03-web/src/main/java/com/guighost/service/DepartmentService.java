package com.guighost.service;

import com.guighost.entity.Department;

import java.util.Collection;

/**
 * @author GuiGhost
 * @date 2021/03/22
 * @interfaceName DepartmentService()
 * 描述：
 */
public interface DepartmentService {
    //查询所有部门
    Collection<Department> getDepartments();
    //根据部门id查询
    Department getDepartmentById(Integer id);
}
