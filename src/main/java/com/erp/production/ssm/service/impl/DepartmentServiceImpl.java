package com.erp.production.ssm.service.impl;

import com.erp.production.ssm.bean.Department;
import com.erp.production.ssm.bean.DepartmentExample;
import com.erp.production.ssm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.PrinterURI;
import java.util.List;

/**
 * @author Turtle
 * @title: DepartmentServiceImpl
 * @projectName production_ms
 * @description: TODO
 * @date 2019/5/17 16:36
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentService departmentService;

    @Override
    public long countByExample(DepartmentExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(DepartmentExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(String departmentId) {
        return 0;
    }

    @Override
    public int insert(Department record) {
        return 0;
    }

    @Override
    public int insertSelective(Department record) {
        return 0;
    }

    @Override
    public List<Department> selectByExample(DepartmentExample example) {
        return departmentService.selectByExample(example);
    }

    @Override
    public Department selectByPrimaryKey(String departmentId) {
        return departmentService.selectByPrimaryKey(departmentId);
    }

    @Override
    public int updateByExampleSelective(Department record, DepartmentExample example) {
        int i = departmentService.updateByExampleSelective(record, example);
        if (i>0) {
            return i;
        } else {
            return 0;
        }
    }

    @Override
    public int updateByExample(Department record, DepartmentExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Department record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Department record) {
        return 0;
    }
}
