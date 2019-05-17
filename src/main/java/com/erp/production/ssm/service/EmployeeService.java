package com.erp.production.ssm.service;

import com.erp.production.ssm.bean.Employee;
import com.erp.production.ssm.bean.EmployeeExample;
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
    long countByExample(EmployeeExample example);

    int deleteByExample(EmployeeExample example);

    int deleteByPrimaryKey(String empId);

    int insert(Employee record);

    int insertSelective(Employee record);

    List<Employee> selectByExample(EmployeeExample example);

    Employee selectByPrimaryKey(String empId);

    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}
