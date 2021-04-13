package com.guighost.service;

import com.guighost.entity.Employee;

import java.util.Collection;

/**
 * @author GuiGhost
 * @date 2021/03/22
 * @interfaceName EmployeeService()
 * 描述：
 */
public interface EmployeeService {
    //获取所有员工信息
    Collection<Employee> getEmployees();
    //根据员工id查询
    Employee getEmployeeById(Integer id);
    //添加一个员工
    void addEmployee(Employee employee);
    //删除一个员工
    void deleteEmployee(Integer id);
}
