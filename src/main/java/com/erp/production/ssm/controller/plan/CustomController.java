package com.erp.production.ssm.controller.plan;

import com.erp.production.ssm.bean.common.CommonResult;
import com.erp.production.ssm.bean.plan.Custom;
import com.erp.production.ssm.service.plan.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/custom")
public class CustomController {
    @Autowired
    private CustomService customService;

    @RequestMapping("/find")
    public String find(){
        return "custom_list";
    }

    @RequestMapping("/add")
    private String add(){
        return "custom_add";
    }

    @RequestMapping("/edit")
    private String edit(){
        return "custom_edit";
    }

    @RequestMapping("/list")
    @ResponseBody
    private CommonResult showList(Integer page,Integer rows){
        CommonResult result = customService.getList(page, rows);
        return result;
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<Custom> getData() {
        return customService.find();
    }

    //根据客户id查找
    @RequestMapping("/search_custom_by_customId")
    @ResponseBody
    public CommonResult searchCustomByCustomId(Integer page, Integer rows, String searchValue) {
        CommonResult result = customService.searchCustomByCustomId(page, rows, searchValue);
        return result;
    }

    //根据客户名查找
    @RequestMapping("/search_custom_by_customName")
    @ResponseBody
    public CommonResult searchCustomByCustomName(Integer page, Integer rows, String searchValue) {
        CommonResult result = customService.searchCustomByCustomName(page, rows, searchValue);
        return result;
    }

}
