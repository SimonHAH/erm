package com.erp.production.ssm.mapper;

import com.erp.production.ssm.bean.Department;
import com.erp.production.ssm.bean.DepartmentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper {
    //扩展的mapper接口方法
    int deleteBatch(String[] ids);

    int updateNote(Department record);

    List<Department> searchDepartmentByDepartmentId(String departmentId);

    List<Department> searchDepartmentByDepartmentName(String departmentName);


    //逆向工程生成的mapper接口
    int countByExample(DepartmentExample example);

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