package com.erp.production.ssm.controller.quality;

import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.bean.quality.FinalCountCheck;
import com.erp.production.ssm.service.quality.FinalCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/f_count_check")
public class FinalCountCheckController {

    @Autowired
    private FinalCountCheckService finalCountCheckService;

    @InitBinder
    public void InitBinder(HttpServletRequest request, ServletRequestDataBinder binder)throws Exception{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, null, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("/get/{finalCountCheckId}")
    @ResponseBody
    public FinalCountCheck getItemById(@PathVariable String finalCountCheckId)throws Exception{
        FinalCountCheck finalCountCheck = finalCountCheckService.get(finalCountCheckId);
        return finalCountCheck;
    }

    @RequestMapping("/find")
    public String find() throws Exception{
        return "f_count_check_list";
    }

    @RequestMapping("/add")
    public String add() throws Exception{
        return "f_count_check_add";
    }

    @RequestMapping("/add_judge")
    public String add_judge() throws Exception{
        return "f_count_check_add";
    }

    @RequestMapping("/edit")
    public String edit() throws Exception{
        return "f_count_check_edit";
    }

    @RequestMapping("/edit_judge")
    public String edit_judge() throws Exception{
        return "f_count_check_edit";
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageResult getItemList(Integer page, Integer rows, FinalCountCheck finalCountCheck)throws Exception{
        PageResult result = finalCountCheckService.getList(page, rows, finalCountCheck);
        return result;
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @ResponseBody
    private CustomResult insert(@Valid FinalCountCheck finalCountCheck, BindingResult bindingResult)throws Exception{
        CustomResult result;
        if (bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        if (finalCountCheckService.get(finalCountCheck.getfCountCheckId()) != null){
            result = new CustomResult(0, "该成品计数质检编号已经存在，请更换！", null);
        }else {
            return finalCountCheckService.insert(finalCountCheck);
        }
        return result;
    }

    @RequestMapping(value = "update_all")
    @ResponseBody
    private CustomResult updateAll(@Valid FinalCountCheck finalCountCheck, BindingResult bindingResult)throws Exception{
        if (bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        return finalCountCheckService.updateAll(finalCountCheck);
    }

    @RequestMapping(value = "update_note")
    @ResponseBody
    private CustomResult updateNote(@Valid FinalCountCheck finalCountCheck, BindingResult bindingResult)throws Exception{
        if (bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        return finalCountCheckService.updateNote(finalCountCheck);
    }

    @RequestMapping(value = "delete_batch")
    @ResponseBody
    private CustomResult deleteBatch(String[] ids)throws Exception{
        CustomResult result = finalCountCheckService.deleteBatch(ids);
        return result;
    }

    @RequestMapping("/search_fCountCheck_By_fCountCheckId")
    @ResponseBody
    public PageResult searchFCountCheckByFCountCheckId(Integer page, Integer rows, String searchValue)throws Exception{
        PageResult result = finalCountCheckService.searchFCountCheckByFCountCheckId(page, rows, searchValue);
        return result;
    }

    @RequestMapping("/search_fCountCheck_By_orderId")
    public PageResult searchFCountCheckByOrderId(Integer page, Integer rows, String searchValue)throws Exception{
        PageResult result = finalCountCheckService.searchFCountCheckByOrderId(page, rows, searchValue);
        return result;
    }

}
