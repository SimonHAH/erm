package com.erp.production.ssm.controller.material;

import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.service.MaterialReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
