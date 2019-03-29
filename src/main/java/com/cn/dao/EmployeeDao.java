package com.cn.dao;

import com.cn.entitys.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


public interface EmployeeDao {
    public Collection<Employee> findAll();
    public Integer save(Employee employee);
    public Employee getEmployeeById(Integer id);
    public void deleteEmployeeById(Integer id);
}
