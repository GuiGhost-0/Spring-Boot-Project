package com.guighost.service.impl;

import com.guighost.dao.EmployeeDao;
import com.guighost.entity.Employee;
import com.guighost.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author GuiGhost
 * @date 2021/03/22
 * @className EmployeeServiceImpl()
 * 描述：
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Collection<Employee> getEmployees() {
        return employeeDao.getEmployees();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeDao.getEmployee(id);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeDao.delEmployee(id);
    }
}
