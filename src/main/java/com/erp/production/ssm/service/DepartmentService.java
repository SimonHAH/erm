package com.erp.production.ssm.service;

import com.erp.production.ssm.bean.Department;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.PageResult;

import java.util.List;

/**
 * @author Turtle
 * @title: DepartmentService
 * @projectName production_ms
 * @description: TODO
 * @date 2019/5/20 10:22
 */
public interface DepartmentService {
    List<Department> find() throws Exception;

    PageResult getList(int page, int rows, Department department) throws Exception;

    Department get(String string) throws Exception;

    CustomResult delete(String string) throws Exception;

    CustomResult deleteBatch(String[] ids) throws Exception;

    CustomResult insert(Department department) throws Exception;

    //更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(Department department) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(Department department) throws Exception;

    //更新备注
    CustomResult updateNote(Department department) throws Exception;

    List<Department> searchDepartmentByDepartmentId(String departmentId) throws Exception;

    PageResult searchDepartmentByDepartmentId(Integer page, Integer rows,
                                                    String departmentId) throws Exception;

    PageResult searchDepartmentByDepartmentName(Integer page,
                                                      Integer rows, String departmentName) throws Exception;
}
