package com.lls.controller;


import com.lls.bean.Department;
import com.lls.bean.Employee;
import com.lls.dao.DepartmentDao;
import com.lls.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;

/**
 * @author lls
 * @date 2020/4/7 -11:32 AM
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }
    @GetMapping("/emp")
    public  String toAddpage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);

        return  "emp/add";
    }

    @PostMapping("/emp")
    public  String addEmp(Employee employee){
        employeeDao.save(employee);

        return  "redirect:/emps";
    }
    @GetMapping("/emp/{id}")
    public  String toUpdateEmp(@PathVariable("id")Integer id,Model model){
        Employee employee = employeeDao.getEmployeeById(id);

        model.addAttribute("emp",employee);

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);


        return "emp/update";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";

    }


    @GetMapping("/delemp/{id}")
    public String deltEmp(@PathVariable("id") Integer id){
        employeeDao.delet(id);

        return  "redirect:/emps";
    }
}
