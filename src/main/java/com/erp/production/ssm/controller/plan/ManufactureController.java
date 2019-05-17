package com.erp.production.ssm.controller.plan;

import com.erp.production.ssm.service.plan.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
