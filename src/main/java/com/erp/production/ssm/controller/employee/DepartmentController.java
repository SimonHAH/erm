package com.erp.production.ssm.controller.employee;

import com.erp.production.ssm.bean.Department;
import com.erp.production.ssm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Turtle
 * @title: DepartmentController
 * @projectName production_ms
 * @description: TODO
 * @date 2019/5/17 16:32
 */
@RestController
@RequestMapping(value = "/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * 根据部门编号ID查询部门
     * @param departmentId
     * @return
     */
    @RequestMapping(value = "/get/{departmentId}")
    public Department getDepartmentId(@PathVariable String departmentId) {
        return departmentService.selectByPrimaryKey(departmentId);
    }

    @RequestMapping(value = "/find")
    public String find() {
        return "department_list";
    }
}
