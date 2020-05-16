package com.lls.dao;

import com.lls.bean.Department;
import com.lls.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lls
 * @date 2020/4/6 -3:18 PM
 */
@Repository
public class EmployeeDao {

    private  static Map<Integer,Employee> employees = null;
    @Autowired
    private DepartmentDao departmentDao;

    static{
        employees = new HashMap<Integer, Employee>();

        employees.put(101,new Employee(1001,"AA","A1506@qq.com",0,new Department(101,"数学部")));
        employees.put(102,new Employee(1002,"BB","B1506@qq.com",1,new Department(102,"市场部")));
        employees.put(103,new Employee(1003,"CC","C1506@qq.com",0,new Department(103,"调研部")));
        employees.put(104,new Employee(1004,"DD","D1506@qq.com",1,new Department(104,"运营部")));
        employees.put(105,new Employee(1005,"EE","E1506@qq.com",0,new Department(105,"后勤部")));

    }
    private  static Integer initId =1006;
    public void save(Employee employee){
        if (employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(),employee);
    }

    public Collection<Employee> getAll(){
        return  employees.values();
    }

    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }
    public void delet(Integer id){
        employees.remove(id);
    }
}
