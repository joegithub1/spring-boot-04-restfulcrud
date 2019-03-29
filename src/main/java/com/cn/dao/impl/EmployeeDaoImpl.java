package com.cn.dao.impl;

import com.cn.dao.DepartmentDao;
import com.cn.dao.EmployeeDao;
import com.cn.entitys.Department;
import com.cn.entitys.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service(value = "employeeDao")
public class EmployeeDaoImpl implements EmployeeDao{
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private DepartmentDao departmentDao;
    //public static List<Employee> emps = new ArrayList<>();
    public static Integer empMaxId=0;
    public static Integer deptMaxId=0;
    public static List<Department> deptList = new ArrayList<>();
    private static Map<Integer,Employee> empsList = null;
    static{
        empMaxId = 1003;
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        deptList.add(new Department(1,"D-AA"));
        deptList.add(new Department(2,"D-BB"));
        deptList.add(new Department(3,"D-CC"));
        empsList = new HashMap<>();
        try {
            empsList.put(1001,new Employee(1001,"E-AA","aa@126.com",1,sdf.parse("1994-01-01"),
                    deptList.get(0) ));
            empsList.put(1002,new Employee(1002,"E-BB","aa@126.com",0,sdf.parse("1994-01-02"),
                    deptList.get(1)));
            empsList.put(1003,new Employee(1003,"E-CC","aa@126.com",1,sdf.parse("1994-01-03"),
                    deptList.get(2)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Collection<Employee> findAll() {


        return empsList.values();
    }
    @Override
    public Integer save(Employee employee) {
        if(null == employee.getId()){
              employee.setId(++empMaxId);
        }

        Department tempDept = departmentDao.getDepartment(employee.getDepartment().getId());
        employee.setDepartment(tempDept);
        empsList.put(employee.getId(),employee);
        return 1;
    }

    @Override
    public Employee getEmployeeById(Integer id) {

        return empsList.get(id);
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        empsList.remove(id);
    }


}
