package com.guighost.controller;

import com.guighost.entity.Employee;
import com.guighost.service.DepartmentService;
import com.guighost.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;

/**
 * @author GuiGhost
 * @date 2021/03/22
 * @className EmployeeController()
 * 描述：
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeService.getEmployees();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
        model.addAttribute("depts",departmentService.getDepartments());
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toUpdatePage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("emp",employee);
        model.addAttribute("depts",departmentService.getDepartments());
        return "emp/update";
    }

    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/emps";
    }
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeService.deleteEmployee(id);
        return "redirect:/emps";
    }

}
