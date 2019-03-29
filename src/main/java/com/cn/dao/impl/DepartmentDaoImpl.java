package com.cn.dao.impl;

import com.cn.dao.DepartmentDao;
import com.cn.entitys.Department;
import org.springframework.stereotype.Service;

import java.util.*;

@Service(value = "departmentDao")
public class DepartmentDaoImpl implements DepartmentDao{
    private static Map<Integer,Department> deptList = null;
    static{
        deptList = new HashMap<>();
        deptList.put(1,new Department(1,"D-AA"));
        deptList.put(2,new Department(2,"D-BB"));
        deptList.put(3,new Department(3,"D-CC"));
    }
    @Override
    public Collection<Department> findAll() {
       return deptList.values();
    }

    @Override
    public Department getDepartment(Integer id) {
        return deptList.get(id);
    }
}
