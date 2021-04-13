package com.guighost.dao;

import com.guighost.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GuiGhost
 * @date 2021/03/20
 * @interfaceName DepartmentDao()
 * 描述：部门Dao
 */
@Repository
public class DepartmentDao {
    //模拟数据库中的数据
    private static Map<Integer, Department> departments = null;

    static {
        //创建一个部门表
        departments = new HashMap<Integer, Department>();
        departments.put(101,new Department(101,"财务部"));
        departments.put(102,new Department(102,"运营部"));
        departments.put(103,new Department(103,"教研部"));
        departments.put(104,new Department(104,"市场部"));
        departments.put(105,new Department(105,"保安部"));
    }

    //获得所有部门信息
    public Collection<Department> getDepartments(){
        return departments.values();
    }

    //通过id得到部门
    public Department getDepartment(Integer id){
        return departments.get(id);
    }
}
