package com.erp.production.ssm.controller.plan;

import com.erp.production.ssm.bean.common.CommonResult;
import com.erp.production.ssm.bean.plan.Manufacture;
import com.erp.production.ssm.service.plan.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/manufacture")
public class ManufactureController {

    @Autowired
    ManufactureService manufactureService;

    @RequestMapping("/find")
    public String find(){
        return "manufacture_list";
    }

    @RequestMapping("/add")
    private String add(){
        return "manufacture_list_add";
    }

    @RequestMapping("/edit")
    private String edit(){
        return "manufacture_list_edit";
    }

    @RequestMapping("/list")
    @ResponseBody
    private CommonResult showList(Integer page, Integer rows){
        CommonResult result = manufactureService.getList(page, rows);
        return result;
    }

    @RequestMapping("/get/{manufactureSn}")
    @ResponseBody
    public Manufacture getItemById(@PathVariable String manufactureSn){
        Manufacture manufacture = manufactureService.get(manufactureSn);
        return manufacture;
    }

}
