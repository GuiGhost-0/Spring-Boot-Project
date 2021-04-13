package com.guighost.service.impl;

import com.guighost.dao.DepartmentDao;
import com.guighost.entity.Department;
import com.guighost.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author GuiGhost
 * @date 2021/03/22
 * @className DepartmentServiceImpl()
 * 描述：
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public Collection<Department> getDepartments() {
        return departmentDao.getDepartments();
    }

    @Override
    public Department getDepartmentById(Integer id) {
        return departmentDao.getDepartment(id);
    }
}
