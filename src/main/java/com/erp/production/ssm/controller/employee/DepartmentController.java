package com.erp.production.ssm.controller.employee;

import com.erp.production.ssm.bean.Department;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Turtle
 * @title: DepartmentController
 * @projectName production_ms
 * @description: TODO
 * @date 2019/5/20 10:26
 */
@Controller
@RequestMapping(value = "/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/get/{departmentId}")
    @ResponseBody
    public Department getItemById(@PathVariable String departmentId) throws Exception{
        Department department = departmentService.get(departmentId);
        return department;
    }

    @RequestMapping("/find")
    public String find() throws Exception{
        return "department_list";
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<Department> getData() throws Exception{
        return departmentService.find();
    }

    @RequestMapping("/add")
    public String add() throws Exception{
        return "department_add";
    }

    @RequestMapping("/edit")
    public String edit() throws Exception{
        return "department_edit";
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageResult getItemList(Integer page, Integer rows, Department department) throws Exception{
        PageResult result = departmentService.getList(page, rows, department);
        return result;
    }

    @RequestMapping(value="/insert", method= RequestMethod.POST)
    @ResponseBody
    private CustomResult insert(@Valid Department department, BindingResult bindingResult) throws Exception {
        CustomResult result;
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        if(departmentService.get(department.getDepartmentId()) != null){
            result = new CustomResult(0, "该部门编号已经存在，请更换部门编号！", null);
        }else{
            result = departmentService.insert(department);
        }
        return result;
    }

    @RequestMapping(value="/update")
    @ResponseBody
    private CustomResult update(@Valid Department department, BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        return departmentService.update(department);
    }

    @RequestMapping(value="/update_all")
    @ResponseBody
    private CustomResult updateAll(@Valid Department department, BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        return departmentService.updateAll(department);
    }

    @RequestMapping(value="/update_note")
    @ResponseBody
    private CustomResult updateNote(@Valid Department department, BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        return departmentService.updateNote(department);
    }

    @RequestMapping(value="/delete")
    @ResponseBody
    private CustomResult delete(String id) throws Exception {
        CustomResult result = departmentService.delete(id);
        return result;
    }

    @RequestMapping(value="/delete_batch")
    @ResponseBody
    private CustomResult deleteBatch(String[] ids) throws Exception {
        CustomResult result = departmentService.deleteBatch(ids);
        return result;
    }

    //根据部门id查找
    @RequestMapping("/search_department_by_departmentId")
    @ResponseBody
    public PageResult searchDepartmentByDepartmentId(Integer page, Integer rows, String searchValue)
            throws Exception{
        PageResult result = departmentService.searchDepartmentByDepartmentId(page, rows, searchValue);
        return result;
    }

    //根据部门名称查找
    @RequestMapping("/search_department_by_departmentName")
    @ResponseBody
    public PageResult searchDepartmentByDepartmentName(Integer page, Integer rows, String searchValue)
            throws Exception{
        PageResult result = departmentService.searchDepartmentByDepartmentName(page, rows, searchValue);
        return result;
    }
}
