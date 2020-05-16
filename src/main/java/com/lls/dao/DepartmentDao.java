package com.lls.dao;

import com.lls.bean.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lls
 * @date 2020/4/6 -3:07 PM
 */

@Repository
public class DepartmentDao {
   //模拟数据库的数据
    private  static Map<Integer,Department> departments = null;


    static{
        departments = new HashMap<Integer, Department>();

        departments.put(101,new Department(101,"数学部"));
        departments.put(102,new Department(102,"市场部"));
        departments.put(103,new Department(103,"调研部"));
        departments.put(104,new Department(104,"运营部"));
        departments.put(105,new Department(105,"后勤部"));

    }
    //获得所有部门信息
    public Collection<Department> getDepartments(){
        return  departments.values();
    }

    public  Department getDepartmentById(Integer id){
        return  departments.get(id);
    }
}
