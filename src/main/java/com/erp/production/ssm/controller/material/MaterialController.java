package com.erp.production.ssm.controller.material;

import com.erp.production.ssm.bean.Material;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.bean.customize.ResponseVo;
import com.erp.production.ssm.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @RequestMapping("/find")
    public String find(){
        System.out.println("这是/material/find");
        return "material_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public ResponseVo getItemList(Integer page, Integer rows, Material material) throws Exception{
        ResponseVo result = materialService.getList(page, rows, material);
        return result;
    }

    @RequestMapping("/search_material_by_materialId")
    @ResponseBody
    public PageResult searchMaterialByMaterialId(Integer page, Integer rows, String searchValue){
        //searchValue=30&page=1&rows=10
        System.out.println("searchById");
        PageResult pageResult = materialService.searchMaterialByMaterialId(page,rows,searchValue);
        return pageResult;
    }

    @RequestMapping("/search_material_by_materialType")
    @ResponseBody
    public PageResult searchMaterialByMaterialType(Integer page,Integer rows,String searchValue){
        PageResult pageResult = materialService.searchMaterialByMaterialType(page,rows,searchValue);
        return pageResult;
    }

    @RequestMapping(value="/update_note")
    @ResponseBody
    public CustomResult updateNote(@Valid Material material, BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        return materialService.updateNote(material);
    }
    @RequestMapping("/edit_judge")
    @ResponseBody
    public void editJudge(){
        return;
    }

    @RequestMapping("/edit")
    public String  edit(){
        return "material_edit";
    }

    @RequestMapping("/update_all")
    @ResponseBody
    public CustomResult updateAll(@Valid Material material,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        return materialService.updateAll(material);
    }
    @RequestMapping("/add_judge")
    @ResponseBody
    public void addJudge(){
        return;
    }

    @RequestMapping("/add")
    public String add(){
        return "material_add";
    }

    @RequestMapping(value="/insert", method= RequestMethod.POST)
    @ResponseBody
    public CustomResult insert(@Valid Material material, BindingResult bindingResult) throws Exception {
        CustomResult result;
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        if(materialService.get(material.getMaterialId()) != null){
            result = new CustomResult(0, "该物料编号已经存在，请更换物料编号！", null);
        }else{
            result = materialService.insert(material);
        }
        return result;
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    public void deleteJudge(){
        return;
    }
    @RequestMapping("/delete_batch")
    @ResponseBody
    public CustomResult deleteBatch(String[] ids){
        CustomResult result = materialService.deleteBatch(ids);
        return result;
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<Material> getData() throws Exception{
        List<Material> list = materialService.find();
        return list;
    }

    @RequestMapping("/get/{materialId}")
    @ResponseBody
    public Material getItemById(@PathVariable String materialId) throws Exception{
        Material material = materialService.get(materialId);
        return material;
    }
}
