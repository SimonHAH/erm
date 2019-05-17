package com.erp.production.ssm.service;

import com.erp.production.ssm.bean.Department;
import com.erp.production.ssm.bean.DepartmentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Turtle
 * @title: Department
 * @projectName production_ms
 * @description: TODO
 * @date 2019/5/17 16:35
 */
public interface DepartmentService {
    long countByExample(DepartmentExample example);

    int deleteByExample(DepartmentExample example);

    int deleteByPrimaryKey(String departmentId);

    int insert(Department record);

    int insertSelective(Department record);

    List<Department> selectByExample(DepartmentExample example);

    Department selectByPrimaryKey(String departmentId);

    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}
