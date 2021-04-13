package com.guighost.dao;

import com.guighost.entity.Department;
import com.guighost.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author GuiGhost
 * @date 2021/03/20
 * @interfaceName EmployeeDao()
 * 描述：员工Dao
 */
@Repository
public class EmployeeDao {

    //模拟数据库数据
    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;


    static {
        employees = new HashMap<Integer, Employee>();
        employees.put(1001,new Employee(1001,"AA","AA@163.com",1,new Department(101,"财务部")));
        employees.put(1002,new Employee(1002,"BB","BB@163.com",0,new Department(102,"运营部")));
        employees.put(1003,new Employee(1003,"CC","CC@163.com",0,new Department(103,"教研部")));
        employees.put(1004,new Employee(1004,"DD","DD@163.com",1,new Department(104,"市场部")));
        employees.put(1005,new Employee(1005,"EE","EE@163.com",0,new Department(105,"保安部")));
    }

    //主键自增
    private static Integer initID = 1006;
    //增加一个员工
    public void addEmployee(Employee employee){
        if (employee.getId() == null){
            employee.setId(initID++);
        }
        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }

    //查询全部员工信息
    public Collection<Employee> getEmployees(){
        return employees.values();
    }

    //通过Id查询员工
    public Employee getEmployee(Integer id){
        return employees.get(id);
    }

    //删除员工
    public void delEmployee(Integer id){
        employees.remove(id);
    }
}
