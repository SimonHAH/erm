package com.erp.production.ssm.service.employee.impl;

import com.erp.production.ssm.bean.Department;
import com.erp.production.ssm.bean.DepartmentExample;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.mapper.DepartmentMapper;
import com.erp.production.ssm.service.employee.DepartmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Turtle
 * @title: DepartmentServiceImpl
 * @projectName production_ms
 * @description: TODO
 * @date 2019/5/20 10:23
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public PageResult getList(int page, int rows, Department department) throws Exception{
        //查询部门列表
        DepartmentExample example = new DepartmentExample();
        //分页处理
        PageHelper.startPage(page, rows);
        List<Department> list = departmentMapper.selectByExample(example);
        //创建一个返回值对象
        PageResult result = new PageResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<Department> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public Department get(String string) throws Exception{

        return departmentMapper.selectByPrimaryKey(string);
    }

    @Override
    public CustomResult delete(String string) throws Exception{
        int i = departmentMapper.deleteByPrimaryKey(string);
        if(i>0){
            return CustomResult.ok();
        }else{
            return null;
        }
    }

    @Override
    public CustomResult deleteBatch(String[] ids) throws Exception{
        int i = departmentMapper.deleteBatch(ids);
        if(i>0){
            return CustomResult.ok();
        }else{
            return null;
        }
    }

    @Override
    public CustomResult insert(Department department) throws Exception{
        int i = departmentMapper.insert(department);
        if(i>0){
            return CustomResult.ok();
        }else{
            return CustomResult.build(101, "新增部门失败");
        }
    }

    @Override
    public CustomResult update(Department department) throws Exception{
        int i = departmentMapper.updateByPrimaryKeySelective(department);
        if(i>0){
            return CustomResult.ok();
        }else{
            return CustomResult.build(101, "修改部门信息失败");
        }
    }

    @Override
    public CustomResult updateAll(Department department) throws Exception{
        int i = departmentMapper.updateByPrimaryKey(department);
        if(i>0){
            return CustomResult.ok();
        }else{
            return CustomResult.build(101, "修改部门信息失败");
        }
    }

    @Override
    public CustomResult updateNote(Department department) throws Exception{
        int i = departmentMapper.updateNote(department);
        if(i>0){
            return CustomResult.ok();
        }else{
            return CustomResult.build(101, "修改部门职责失败");
        }
    }

    @Override
    public List<Department> find() throws Exception{
        DepartmentExample example = new DepartmentExample();
        return departmentMapper.selectByExample(example);
    }

    @Override
    public List<Department> searchDepartmentByDepartmentId(String departmentId) throws Exception{
        DepartmentExample example = new DepartmentExample();
        DepartmentExample.Criteria criteria = example.createCriteria();
        criteria.andDepartmentIdLike(departmentId);
        return departmentMapper.selectByExample(example);
    }

    @Override
    public PageResult searchDepartmentByDepartmentId(Integer page,
                                                           Integer rows, String departmentId) throws Exception{
        //分页处理
        PageHelper.startPage(page, rows);
        List<Department> list = departmentMapper.searchDepartmentByDepartmentId(departmentId);
        //创建一个返回值对象
        PageResult result = new PageResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<Department> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public PageResult searchDepartmentByDepartmentName(Integer page,
                                                             Integer rows, String departmentName) throws Exception{
        //分页处理
        PageHelper.startPage(page, rows);
        List<Department> list = departmentMapper.searchDepartmentByDepartmentName(departmentName);
        //创建一个返回值对象
        PageResult result = new PageResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<Department> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}
