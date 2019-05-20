package com.erp.production.ssm.controller.quality;

import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.bean.quality.UnqualifyApply;
import com.erp.production.ssm.service.quality.UnqualifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping("/unqualify")
public class UnqualifyApplyController {

    @Autowired
    private UnqualifyService unqualifyService;

    @RequestMapping("/find")
    public String find(){
        return "unqualify_list";
    }

    @RequestMapping("/add")
    public String add(){
        return "unqualify_add";
    }

    @RequestMapping("/add_judge")
    public String add_judge(){
        return "unqualify_add";
    }

    @RequestMapping("/edit")
    public String edit() {
        return "unqualify_edit";
    }

    @RequestMapping("/edit_judge")
    public String edit_judge() {
        return "unqualify_edit";
    }


    @RequestMapping("/list")
    @ResponseBody
    public PageResult getItemList(Integer page, Integer rows, UnqualifyApply unqualifyApply) throws Exception {
        PageResult result = unqualifyService.getList(page, rows, unqualifyApply);
        return result;
    }

    @RequestMapping("/serch_unqualify_by_unqualifyId")
    @ResponseBody
    public PageResult searchUnqualifyByUnqualifyId(Integer page, Integer rows, String unqualifyId)throws Exception{
        PageResult result = unqualifyService.searchUnqualifyByUnqualifyId(page, rows, unqualifyId);
        return result;
    }

    @RequestMapping("/serch_unqualify_by_productName")
    @ResponseBody
    public PageResult searchUnqualifyByProductName(Integer page, Integer rows, String productName)throws Exception{
        PageResult result = unqualifyService.searchUnqualifyByProductName(page, rows, productName);
        return result;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public CustomResult insert(@Valid UnqualifyApply unqualifyApply, BindingResult bindingResult) throws Exception{
        CustomResult result;
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        if(unqualifyService.get(unqualifyApply.getUnqualifyApplyId()) != null){
            result = new CustomResult(0, "该不合格品申请编号已经存在，请更换！", null);
        }else{
            result = unqualifyService.insert(unqualifyApply);
        }
        return result;
    }

    @RequestMapping(value="/update_all")
    @ResponseBody
    private CustomResult updateAll(@Valid UnqualifyApply unqualifyApply, BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        return unqualifyService.updateAll(unqualifyApply);
    }

    @RequestMapping(value="/update_note")
    @ResponseBody
    private CustomResult updateNote(@Valid UnqualifyApply unqualifyApply, BindingResult bindingResult)
            throws Exception {
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        return unqualifyService.updateNote(unqualifyApply);
    }

    @RequestMapping(value="/delete")
    @ResponseBody
    private CustomResult delete(String id) throws Exception {
        CustomResult result = unqualifyService.delete(id);
        return result;
    }

    @RequestMapping(value="/delete_judge")
    @ResponseBody
    private CustomResult delete_judge(String id) throws Exception {
        CustomResult result = unqualifyService.delete(id);
        return result;
    }

    @RequestMapping(value="/delete_batch")
    @ResponseBody
    private CustomResult deleteBatch(String[] ids) throws Exception {
        CustomResult result = unqualifyService.deleteBatch(ids);
        return result;
    }

}
