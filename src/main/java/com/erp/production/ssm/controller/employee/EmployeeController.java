package com.erp.production.ssm.controller.employee;

import com.erp.production.ssm.bean.DepartmentExample;
import com.erp.production.ssm.bean.Employee;
import com.erp.production.ssm.bean.EmployeeExample;
import com.erp.production.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Turtle
 * @title: EmployeeController
 * @projectName production_ms
 * @description: TODO
 * @date 2019/5/17 14:47
 */
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //根据员工编号ID查询员工列表
    @RequestMapping(value = "/get/{empId}")
    public Employee getEmployeeId(@PathVariable String empId) {
        return employeeService.selectByPrimaryKey(empId);
    }



    @RequestMapping(value = "/find")
    public String findEmployee() {
        return  "employee_list";
    }

    @RequestMapping(value = "/get_date")
    public List<Employee> getData(DepartmentExample example) {
        return employeeService.selectByExample(example);
    }





}
