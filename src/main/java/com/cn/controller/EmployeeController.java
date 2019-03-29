package com.cn.controller;

import com.cn.dao.DepartmentDao;
import com.cn.dao.EmployeeDao;
import com.cn.entitys.Department;
import com.cn.entitys.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
public class EmployeeController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;
    ///@RequestMapping(value = "/emps/list",method = RequestMethod.GET)
    @GetMapping(value = "/emps")
    public String empList(Model model){
        Collection<Employee> list = employeeDao.findAll();
        model.addAttribute("emps",list);
        return "emp/list";
    }

    /**
     * 来到员工添加页面
     * @return
     */
    @GetMapping(value = "/emp")
    public String toAddPage(Model model){
        Collection<Department> depts = departmentDao.findAll();
        model.addAttribute("depts",depts);
        Employee e = new Employee();
        e.setDepartment(new Department());
        model.addAttribute("emp",e);
        return "emp/add";
    }

    /**
     * 保存员工添加
     * @return
     */
    @PostMapping(value = "/emp")
    public String add(Employee employee){
        logger.info("员工："+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    @GetMapping(value = "/emp/{id}")
    public String toEditPage(Model model,@PathVariable("id") Integer id){
        Collection<Department> depts = departmentDao.findAll();
        Employee emp = employeeDao.getEmployeeById(id);
        logger.info("查询的员工："+emp);
        model.addAttribute("depts",depts);
        model.addAttribute("emp",emp);
        return "emp/add";
    }
    @PutMapping(value = "/emp")
    public String update(Employee employee){
        logger.info("修改员工");
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //删除
    @DeleteMapping(value="/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        logger.info("删除员工："+id);
        employeeDao.deleteEmployeeById(id);
        return "redirect:/emps";
    }

}
