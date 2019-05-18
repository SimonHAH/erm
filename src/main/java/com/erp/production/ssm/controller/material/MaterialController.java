package com.erp.production.ssm.controller.material;

import com.erp.production.ssm.bean.Material;
import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public PageResult getItemList(Integer page, Integer rows, Material material) throws Exception{
        PageResult result = materialService.getList(page, rows, material);
        return result;
    }

}
