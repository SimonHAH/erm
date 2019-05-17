package com.erp.production.ssm.service.impl;

import com.erp.production.ssm.bean.Employee;
import com.erp.production.ssm.bean.EmployeeExample;
import com.erp.production.ssm.mapper.EmployeeMapper;
import com.erp.production.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Turtle
 * @title: EmployeeServiceImpl
 * @projectName production_ms
 * @description: TODO
 * @date 2019/5/17 14:43
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public long countByExample(EmployeeExample example) {
        return employeeMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(EmployeeExample example) {
        return employeeMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String empId) {
        return employeeMapper.deleteByPrimaryKey(empId);
    }

    @Override
    public int insert(Employee record) {
        return employeeMapper.insert(record);
    }

    @Override
    public int insertSelective(Employee record) {
        return employeeMapper.insertSelective(record);
    }

    @Override
    public List<Employee> selectByExample(EmployeeExample example) {
        return employeeMapper.selectByExample(example);
    }

    @Override
    public Employee selectByPrimaryKey(String empId) {
        return employeeMapper.selectByPrimaryKey(empId);
    }

    @Override
    public int updateByExampleSelective(Employee record, EmployeeExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Employee record, EmployeeExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Employee record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Employee record) {
        return 0;
    }
}
