package com.erp.production.ssm.controller;

import com.erp.production.ssm.bean.ProcessCountCheck;
import com.erp.production.ssm.bean.VO.CustomOrderVO;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.service.ProcessCountCheckService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * @author Turtle
 * @title: ProcessCountCheckController
 * @projectName production_ms
 * @description: TODO
 * @date 2019/5/20 15:01
 */
@Controller
@RequestMapping(value = "/p_count_check")
public class ProcessCountCheckController {
    @Autowired
    private ProcessCountCheckService processCountCheckService;


    @RequestMapping("/get/{orderId}")
    @ResponseBody
    public CustomOrderVO getItemById(@PathVariable String orderId) throws Exception{
        return null;
    }

    @RequestMapping("/find")
    public String find() throws Exception{
        return "p_count_check_list";
    }

    @RequestMapping("/add")
    public String add() throws Exception{
        return "p_count_check_add";
    }

    @RequestMapping("/add_judge")
    public String add_judge() throws Exception{
        return "p_count_check_add";
    }

    @RequestMapping("/edit")
    public String edit() throws Exception{
        return "p_count_check_edit";
    }

    @RequestMapping("/edit_judge")
    public String edit_judge() throws Exception{
        return "p_count_check_edit";
    }



    @RequestMapping("/list")
    @ResponseBody
    public PageResult getList(Integer page, Integer rows, ProcessCountCheck processCountCheck)
            throws Exception{

        PageResult result = processCountCheckService.getList(page, rows, processCountCheck);
        return result;
    }

    @RequestMapping(value="/insert", method= RequestMethod.POST)
    @ResponseBody
    private CustomResult insert(@Valid ProcessCountCheck processCountCheck, BindingResult bindingResult)
            throws Exception {
        CustomResult result;
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        result = processCountCheckService.insert(processCountCheck);
        return result;
    }

    @RequestMapping(value="/update")
    @ResponseBody
    private CustomResult update(@Valid ProcessCountCheck processCountCheck, BindingResult bindingResult)
            throws Exception {
        return null;
    }

    @RequestMapping(value="/update_all")
    @ResponseBody
    private CustomResult updateAll(@Valid ProcessCountCheck processCountCheck, BindingResult bindingResult)
            throws Exception {
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        return processCountCheckService.updateAll(processCountCheck);
    }

    @RequestMapping(value="/update_note")
    @ResponseBody
    private CustomResult updateNote(@Valid ProcessCountCheck processCountCheck, BindingResult bindingResult)
            throws Exception {
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        return processCountCheckService.updateNote(processCountCheck);
    }

    @RequestMapping(value="/delete")
    @ResponseBody
    private CustomResult delete(String id) throws Exception {
        return null;
    }

    @RequestMapping(value="/delete_judge")
    @ResponseBody
    private CustomResult delete_judge(String id) throws Exception {
        return null;
    }

    @RequestMapping(value="/delete_batch")
    @ResponseBody
    private CustomResult deleteBatch(String[] ids) throws Exception {
        System.out.println(ids);
        CustomResult result = processCountCheckService.deleteBatch(ids);
        return result;
    }

    @RequestMapping(value="/change_status")
    @ResponseBody
    public CustomResult changeStatus(String[] ids) throws Exception{
        return null;
    }

    //根据工序计数质检id查找
    @RequestMapping("/search_pCountCheck_by_pCountCheckId")
    @ResponseBody
    public PageResult searchpCountCheckBypCountCheckId(Integer page, Integer rows, String searchValue)
            throws Exception{
        PageResult result = processCountCheckService.searchPCountCheckByPCountCheckId(page, rows, searchValue);
        return result;
    }
}
