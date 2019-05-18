package com.erp.production.ssm.controller.material;

import com.erp.production.ssm.bean.MaterialReceive;
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
        PageResult result = materialReceiveService.getList(page, rows);
        return result;
    }
}
