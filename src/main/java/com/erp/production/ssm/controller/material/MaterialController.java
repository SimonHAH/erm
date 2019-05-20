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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

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
    private CustomResult updateNote(@Valid Material material, BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        return materialService.updateNote(material);
    }

}
