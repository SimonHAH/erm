package com.erp.production.ssm.controller.employee;

import com.erp.production.ssm.bean.ProcessMeasureCheck;
import com.erp.production.ssm.bean.VO.CustomOrderVO;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.service.ProcessMeasureService;
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
 * @title: ProcessMeasureCheckController
 * @projectName production_ms
 * @description: TODO
 * @date 2019/5/20 12:03
 */
@Controller
@RequestMapping(value = "/p_measure_check")
public class ProcessMeasureCheckController {
    @Autowired
    private ProcessMeasureService processMeasureService;


    @RequestMapping("/get/{orderId}")
    @ResponseBody
    public CustomOrderVO getItemById(@PathVariable String orderId) throws Exception{
        return null;
    }

    @RequestMapping("/find")
    public String find() throws Exception{
        return "p_measure_check_list";
    }

    @RequestMapping("/add")
    public String add() throws Exception{
        return "p_measure_check_add";
    }

    @RequestMapping("/edit")
    public String edit() throws Exception{
        return "p_measure_check_edit";
    }

    @RequestMapping("/add_judge")
    public String add_judge() throws Exception{
        return "p_measure_check_add";
    }

    @RequestMapping("/edit_judge")
    public String edit_judge() throws Exception{
        return "p_measure_check_edit";
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageResult getList(Integer page, Integer rows, ProcessMeasureCheck processMeasureCheck)
            throws Exception{
        PageResult result = processMeasureService.getList(page, rows, processMeasureCheck);
        return result;
    }

    /*
     *此处的method可以取两个值，
     *一个是RequestMethod.GET，一个是RequestMethod.POST，
     *就是请求该方法使用的模式，是get还是post，即参数提交的方法
     *ajax或者form表单提交数据有两种方法，即get和post。
     */
    @RequestMapping(value="/insert", method= RequestMethod.POST)
    @ResponseBody
    private CustomResult insert(@Valid ProcessMeasureCheck processMeasureCheck, BindingResult bindingResult)
            throws Exception {
        CustomResult result;
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        result = processMeasureService.insert(processMeasureCheck);
        return result;
    }

    @RequestMapping(value="/update_all")
    @ResponseBody
    private CustomResult updateAll(@Valid ProcessMeasureCheck processMeasureCheck, BindingResult bindingResult)
            throws Exception {
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        return processMeasureService.updateAll(processMeasureCheck);
    }

    @RequestMapping(value="/update_note")
    @ResponseBody
    private CustomResult updateNote(@Valid ProcessMeasureCheck processMeasureCheck, BindingResult bindingResult)
            throws Exception {
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        return processMeasureService.updateNote(processMeasureCheck);
    }

    @RequestMapping(value="/delete_batch")
    @ResponseBody
    private CustomResult deleteBatch(String[] ids) throws Exception {
        System.out.println(ids);
        CustomResult result = processMeasureService.deleteBatch(ids);
        return result;
    }


    @RequestMapping(value="/delete_judge")
    @ResponseBody
    private CustomResult delete_judge(String[] ids) throws Exception {
        System.out.println(ids);
        CustomResult result = processMeasureService.deleteBatch(ids);
        return result;
    }

    //根据工序计量质检id查找
    @RequestMapping("/search_pMeasureCheck_by_pMeasureCheckId")
    @ResponseBody
    public PageResult searchOrderByOrderId(Integer page, Integer rows, String searchValue) throws Exception{
        PageResult result = processMeasureService
                .searchPMeasureCheckByPMeasureCheckId(page, rows, searchValue);
        return result;
    }
}
