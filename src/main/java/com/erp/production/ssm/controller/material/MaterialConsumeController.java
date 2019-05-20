package com.erp.production.ssm.controller.material;

import com.erp.production.ssm.bean.MaterialConsume;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.bean.material.MaterialConsumeVO;
import com.erp.production.ssm.service.material.MaterialConsumeService;
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
@RequestMapping("/materialConsume")
public class MaterialConsumeController {

    @Autowired
    private MaterialConsumeService materialConsumeService;

    @RequestMapping("/get/{consumeId}")
    @ResponseBody
    public MaterialConsume getItemById(@PathVariable String orderId) throws Exception{
        MaterialConsume materialConsume = materialConsumeService.get(orderId);
        return materialConsume;
    }
    @RequestMapping("/find")
    public String find(){
        System.out.println("/materialConsume/find");
        return "materialConsume_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageResult getList(Integer page, Integer rows, MaterialConsumeVO materialConsume) throws Exception{
        PageResult result = materialConsumeService.getList(page, rows, materialConsume);
        return result;
    }
    @RequestMapping("/search_materialConsume_by_consumeId")
    @ResponseBody
    public PageResult searchMaterialConsumeByConsumeId(Integer page,Integer rows,String searchValue){
        return materialConsumeService.searchMaterialConsumeByConsumeId(page,rows,searchValue);
    }
    @RequestMapping("/search_materialConsume_by_materialId")
    @ResponseBody
    public PageResult searchMaterialConsumeByMaterialId(Integer page,Integer rows,String searchValue){
        return materialConsumeService.searchMaterialConsumeByMaterialId(page,rows,searchValue);
    }
    @RequestMapping("/search_materialConsume_by_workId")
    @ResponseBody
    public PageResult searchMaterialConsumeByWorkId(Integer page,Integer rows,String searchValue){
        return materialConsumeService.searchMaterialConsumeByWorkId(page,rows,searchValue);
    }
    @RequestMapping("/edit_judge")
    @ResponseBody
    public void editJudge(){
        return;
    }
    @RequestMapping(value="/update_note")
    @ResponseBody
    public CustomResult updateNote(@Valid MaterialConsume materialConsume, BindingResult bindingResult)
            throws Exception {
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        return materialConsumeService.updateNote(materialConsume);
    }
    @RequestMapping("/add_judge")
    @ResponseBody
    public void addJudge(){
        return;
    }

    @RequestMapping("/add")
    public String add() throws Exception{
        return "materialConsume_add";
    }

    @RequestMapping(value="/insert", method= RequestMethod.POST)
    @ResponseBody
    private CustomResult insert(@Valid MaterialConsume materialConsume, BindingResult bindingResult)
            throws Exception {
        CustomResult result;
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        if(materialConsumeService.get(materialConsume.getConsumeId()) != null){
            result = new CustomResult(0, "该订单编号已经存在，请更换订单编号！", null);
        }else{
            result = materialConsumeService.insert(materialConsume);
        }
        return result;
    }

    @RequestMapping("/edit")
    public String edit(){
        return "materialConsume_edit";
    }
    @RequestMapping(value="/update_all")
    @ResponseBody
    public CustomResult updateAll(@Valid MaterialConsume materialConsume, BindingResult bindingResult)
            throws Exception {
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        return materialConsumeService.updateAll(materialConsume);
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    public void deleteJudge(){
        return;
    }

    @RequestMapping(value="/delete_batch")
    @ResponseBody
    public CustomResult deleteBatch(String[] ids) {
        System.out.println(ids);
        CustomResult result = materialConsumeService.deleteBatch(ids);
        return result;
    }
}
