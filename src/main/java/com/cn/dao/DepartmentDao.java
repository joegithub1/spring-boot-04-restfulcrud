package com.cn.dao;

import com.cn.entitys.Department;

import java.util.Collection;
import java.util.List;


public interface DepartmentDao {
    public Collection<Department> findAll();
    public Department getDepartment(Integer id);
}
