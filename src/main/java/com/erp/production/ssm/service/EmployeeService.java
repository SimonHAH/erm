package com.erp.production.ssm.service;

import com.erp.production.ssm.bean.Employee;
import com.erp.production.ssm.bean.EmployeeExample;
import com.erp.production.ssm.bean.VO.EmployeeVO;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.PageResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Turtle
 * @title: EmployeeService
 * @projectName production_ms
 * @description: TODO
 * @date 2019/5/17 14:46
 */
public interface EmployeeService {
    List<Employee> find() throws Exception;

    PageResult getList(int page, int rows, EmployeeVO employee) throws Exception;

    EmployeeVO get(String string) throws Exception;

    CustomResult delete(String string) throws Exception;

    CustomResult deleteBatch(String[] ids) throws Exception;

    CustomResult insert(Employee employee) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(Employee employee) throws Exception;

    CustomResult update(Employee employee) throws Exception;

    List<Employee> searchEmployeeByEmployeeName(String employeeName) throws Exception;

    List<Employee> searchEmployeeByEmployeeId(String employeeId) throws Exception;

    //根据员工id查找员工信息
    PageResult searchEmployeeByEmployeeId(Integer page, Integer rows,
                                          String employeeId) throws Exception;

    //根据员工姓名查找员工信息
    PageResult searchEmployeeByEmployeeName(Integer page, Integer rows,
                                                  String employeeName) throws Exception;

    //根据部门名称查找员工信息
    PageResult searchEmployeeByDepartmentName(Integer page, Integer rows,
                                                    String departmentName) throws Exception;
}
