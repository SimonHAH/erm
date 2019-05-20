package com.erp.production.ssm.controller.material;

import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.bean.material.MaterialConsumeVO;
import com.erp.production.ssm.service.MaterialConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/materialConsume")
public class MaterialConsumeController {

    @Autowired
    private MaterialConsumeService materialConsumeService;

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
}
