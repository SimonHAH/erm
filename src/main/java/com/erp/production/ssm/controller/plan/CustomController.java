package com.erp.production.ssm.controller.plan;

import com.erp.production.ssm.bean.common.CommonResult;
import com.erp.production.ssm.service.plan.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/custom")
public class CustomController {
    @Autowired
    private CustomService customService;

    @RequestMapping("/find")
    public String find(){
        return "task_list";
    }

    @RequestMapping("/add")
    private String add(){
        return "task_add";
    }

    @RequestMapping("/edit")
    private String edit(){
        return "task_edit";
    }

    @RequestMapping("/list")
    @ResponseBody
    private CommonResult showList(Integer page,Integer rows){
        CommonResult result = customService.getList(page, rows);
        return result;
    }

}
