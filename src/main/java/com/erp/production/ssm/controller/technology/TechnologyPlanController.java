package com.erp.production.ssm.controller.technology;

import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.bean.technology.TechnologyPlan;
import com.erp.production.ssm.service.technology.TechnologyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Nemo
 * @version 1.0
 * @date 2019/5/20
 */
@Controller
@RequestMapping("/technologyPlan")
public class TechnologyPlanController {

    @Autowired
    TechnologyPlanService technologyPlanService;

    @RequestMapping("/find")
    public String find() {
        return "technologyPlan_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageResult getList(Integer page, Integer rows){
        PageResult result = technologyPlanService.getList(page, rows);
        return result;
    }

    @RequestMapping("/get/{planId}")
    @ResponseBody
    public TechnologyPlan getPlanById(@PathVariable String planId) {
        return technologyPlanService.getPlanById(planId);
    }

    @RequestMapping("/search_technologyPlan_by_technologyPlanId")
    @ResponseBody
    public PageResult searchItemById(String searchValue, Integer page, Integer rows) {
        return technologyPlanService.searchItemById(searchValue, page, rows);
    }

    @RequestMapping("/search_technologyPlan_by_technologyName")
    @ResponseBody
    public PageResult searchItemByName(String searchValue, Integer page, Integer rows) {
        return technologyPlanService.searchItemByName(searchValue, page, rows);
    }

}
