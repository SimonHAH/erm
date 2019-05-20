package com.erp.production.ssm.controller.employee;

import com.erp.production.ssm.bean.Employee;
import com.erp.production.ssm.bean.VO.EmployeeVO;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Turtle
 * @title: EmployeeController
 * @projectName production_ms
 * @description: TODO
 * @date 2019/5/17 14:47
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/get/{empId}")
    @ResponseBody
    public EmployeeVO getItemById(@PathVariable String empId) throws Exception{
        EmployeeVO employee = employeeService.get(empId);
        return employee;
    }

    @RequestMapping("/find")
    public String find() throws Exception{
        return "employee_list";
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<Employee> getData() throws Exception{
        return employeeService.find();
    }

    @RequestMapping("/add_judge")
    public String add_judge() throws Exception{
        return "employee_add";
    }

    @RequestMapping("/add")
    public String add() throws Exception{
        return "employee_add";
    }

    @RequestMapping("/edit")
    public String edit() throws Exception{
        return "employee_edit";
    }

    @RequestMapping("/edit_judge")
    public String edit_judge() throws Exception{
        return "employee_edit";
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageResult getItemList(Integer page, Integer rows, EmployeeVO employee) throws Exception{
        PageResult result = employeeService.getList(page, rows, employee);
        return result;
    }

    @RequestMapping(value="/insert", method=RequestMethod.POST)
    @ResponseBody
    private CustomResult insert(@Valid Employee employee, BindingResult bindingResult) throws Exception {
        CustomResult result;
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        if(employeeService.get(employee.getEmpId()) != null){
            result = new CustomResult(0, "该员工编号已经存在，请更换员工编号！", null);
        }else{
            result = employeeService.insert(employee);
        }
        return result;
    }

    @RequestMapping(value="/update")
    @ResponseBody
    private CustomResult update(@Valid Employee employee, BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        return employeeService.update(employee);
    }

    @RequestMapping(value="/update_all")
    @ResponseBody
    private CustomResult updateAll(@Valid Employee employee, BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        return employeeService.updateAll(employee);
    }

    @RequestMapping(value="/delete")
    @ResponseBody
    private CustomResult delete(String id) throws Exception {
        CustomResult result = employeeService.delete(id);
        return result;
    }

    @RequestMapping(value="/delete_judge")
    @ResponseBody
    private CustomResult delete_judge(String id) throws Exception {
        CustomResult result = employeeService.delete(id);
        return result;
    }

    @RequestMapping(value="/delete_batch")
    @ResponseBody
    private CustomResult deleteBatch(String[] ids) throws Exception {
        CustomResult result = employeeService.deleteBatch(ids);
        return result;
    }

    //根据员工id查找
    @RequestMapping("/search_employee_by_employeeId")
    @ResponseBody
    public PageResult searchEmployeeByEmployeeId(Integer page, Integer rows, String searchValue)
            throws Exception{
        PageResult result = employeeService.searchEmployeeByEmployeeId(page, rows, searchValue);
        return result;
    }

    //根据员工姓名查找
    @RequestMapping("/search_employee_by_employeeName")
    @ResponseBody
    public PageResult searchEmployeeByEmployeeName(Integer page, Integer rows, String searchValue)
            throws Exception{
        PageResult result = employeeService.searchEmployeeByEmployeeName(page, rows, searchValue);
        return result;
    }

    //根据部门名称查找
    @RequestMapping("/search_employee_by_departmentName")
    @ResponseBody
    public PageResult searchEmployeeByDepartmentName(Integer page, Integer rows, String searchValue)
            throws Exception{
        PageResult result = employeeService.searchEmployeeByDepartmentName(page, rows, searchValue);
        return result;
    }
}

