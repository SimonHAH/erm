package com.erp.production.ssm.controller.quality;

import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.bean.quality.FinalMeasuretCheck;
import com.erp.production.ssm.service.quality.FinalMeasuretCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping("/measure")
public class FinalMeasuretCheckController {

    @Autowired
    private FinalMeasuretCheckService finalMeasuretCheckService;


    @RequestMapping("/get/{finalMeasuretCheckId}")
    @ResponseBody
    public FinalMeasuretCheck getItemById(@PathVariable String finalMeasuretCheckId) throws Exception{
        FinalMeasuretCheck finalMeasuretCheck = finalMeasuretCheckService.get(finalMeasuretCheckId);
        return finalMeasuretCheck;
    }

    @RequestMapping("/find")
    public String find() throws Exception{
        return "measurement_list";
    }

    @RequestMapping("/add")
    public String add() throws Exception{
        return "measurement_add";
    }

    @RequestMapping("/add_judge")
    public String add_judge() throws Exception{
        return "measurement_add";
    }

    @RequestMapping("/edit")
    public String edit() throws Exception{
        return "measurement_edit";
    }

    @RequestMapping("/edit_judge")
    public String edit_judge() throws Exception{
        return "measurement_edit";
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageResult getList(Integer page, Integer rows, FinalMeasuretCheck finalMeasuretCheck)
            throws Exception{
        PageResult result = finalMeasuretCheckService.getList(page, rows, finalMeasuretCheck);
        return result;
    }

    @RequestMapping(value="/insert", method= RequestMethod.POST)
    @ResponseBody
    private CustomResult insert(@Valid FinalMeasuretCheck finalMeasuretCheck, BindingResult bindingResult)
            throws Exception {
        CustomResult result;
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        if(finalMeasuretCheckService.get(finalMeasuretCheck.getfMeasureCheckId()) != null){
            result = new CustomResult(0, "该成品计量质检编号已经存在，请更换！", null);
        }else{
            result = finalMeasuretCheckService.insert(finalMeasuretCheck);
        }
        return result;
    }

    @RequestMapping(value="/update_all")
    @ResponseBody
    private CustomResult updateAll(@Valid FinalMeasuretCheck finalMeasuretCheck, BindingResult bindingResult)
            throws Exception {
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        return finalMeasuretCheckService.updateAll(finalMeasuretCheck);
    }

    @RequestMapping(value="/update_note")
    @ResponseBody
    private CustomResult updateNote(@Valid FinalMeasuretCheck finalMeasuretCheck, BindingResult bindingResult)
            throws Exception {
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        return finalMeasuretCheckService.updateNote(finalMeasuretCheck);
    }

    @RequestMapping(value="/delete_batch")
    @ResponseBody
    private CustomResult deleteBatch(String[] ids) throws Exception {
        CustomResult result = finalMeasuretCheckService.deleteBatch(ids);
        return result;
    }

    //根据成品计量质检id查找
    @RequestMapping("/search_fMeasureCheck_by_fMeasureCheckId")
    @ResponseBody
    public PageResult searchFMeasureCheckByFMeasureCheckId(Integer page, Integer rows, String searchValue)
            throws Exception{
        PageResult result = finalMeasuretCheckService.searchFMeasureCheckByFMeasureCheckId(page, rows, searchValue);
        return result;
    }

    //根据订单id查找
    @RequestMapping("/search_fMeasureCheck_by_orderId")
    @ResponseBody
    public PageResult searchFMeasureCheckByOrderId(Integer page, Integer rows, String searchValue)
            throws Exception{
        PageResult result = finalMeasuretCheckService.searchFMeasureCheckByOrderId(page, rows, searchValue);
        return result;
    }
}
