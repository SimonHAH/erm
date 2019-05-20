package com.erp.production.ssm.controller.material;

import com.erp.production.ssm.bean.MaterialReceive;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.service.material.MaterialReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping("/materialReceive")
public class MaterialReceiveController {

    @Autowired
    private MaterialReceiveService materialReceiveService;

    @RequestMapping("/find")
    public String find() throws Exception{
        System.out.println("/materialReceive/find");
        return "materialReceive_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageResult getList(Integer page, Integer rows) throws Exception{
        PageResult pageResult = materialReceiveService.getList(page, rows);
        return pageResult;
    }

    //根据物料接收id查找
    @RequestMapping("/search_materialReceive_by_receiveId")
    @ResponseBody
    public PageResult searchMaterialReceiveByReceiveId(Integer page, Integer rows, String searchValue)
            throws Exception{
        PageResult pageResult = materialReceiveService.searchMaterialReceiveByReceiveId(page, rows, searchValue);
        return pageResult;
    }

    @RequestMapping("/search_materialReceive_by_materialId")
    @ResponseBody
    public PageResult searchMaterialReceiveByMaterialId(Integer page,Integer rows,String searchValue)
            throws Exception {
        //searchValue=SJ&page=1&rows=10
        PageResult pageResult = materialReceiveService.searchMaterialReceiveByMaterialId(page, rows, searchValue);
        return pageResult;
    }

    @RequestMapping("/edit_judge")
    @ResponseBody
    public void editJudge(){
        return;
    }

    @RequestMapping("/update_note")
    @ResponseBody
    public CustomResult updateNote(@Valid MaterialReceive materialReceive, BindingResult bindingResult)
            throws Exception {
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        return materialReceiveService.updateNote(materialReceive);
    }
    @RequestMapping("/add_judge")
    @ResponseBody
    public void addJudge(){
        return;
    }

    @RequestMapping("/edit")
    public String edit() throws Exception{
        return "materialReceive_edit";
    }

    @RequestMapping("/add")
    public String add() throws Exception{
        return "materialReceive_add";
    }
    @RequestMapping("/insert")
    @ResponseBody
    public CustomResult insert(@Valid MaterialReceive materialReceive, BindingResult bindingResult)
            throws Exception {
        CustomResult result;
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        if(materialReceiveService.get(materialReceive.getReceiveId()) != null){
            result = new CustomResult(0, "该产品编号已经存在，请更换产品编号！", null);
        }else{
            result = materialReceiveService.insert(materialReceive);
        }
        return result;
    }
    @RequestMapping("/update_all")
    @ResponseBody
    public CustomResult updateAll(@Valid MaterialReceive materialReceive, BindingResult bindingResult)
            throws Exception {
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        return materialReceiveService.updateAll(materialReceive);
    }
    @RequestMapping("/delete_judge")
    @ResponseBody
    public void delete_judge(){
        return;
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public CustomResult deleteBatch(String[] ids) throws Exception {
        CustomResult result = materialReceiveService.deleteBatch(ids);
        return result;
    }
}
