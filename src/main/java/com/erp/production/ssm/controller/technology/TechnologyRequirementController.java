package com.erp.production.ssm.controller.technology;

import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.bean.technology.TechnologyRequirement;
import com.erp.production.ssm.service.technology.TechnologyRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Nemo
 * @version 1.0
 * @date 2019/5/18
 */
@Controller
@RequestMapping("/technologyRequirement")
public class TechnologyRequirementController {

    @Autowired
    TechnologyRequirementService technologyRequirementService;

    @RequestMapping("/find")
    public String find() {

        return "technologyRequirement_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageResult getList(Integer page, Integer rows) {
        PageResult result = technologyRequirementService.getList(page, rows);

        return result;
    }

    @RequestMapping("search_technologyRequirement_by_technologyRequirementId")
    @ResponseBody
    public PageResult searchItemById(String searchValue, Integer page, Integer rows) {
        return technologyRequirementService.searchItemById(searchValue, page, rows);
    }

    @RequestMapping("search_technologyRequirement_by_technologyName")
    @ResponseBody
    public PageResult searchItemByName(String searchValue, Integer page, Integer rows) {
        return technologyRequirementService.searchItemByName(searchValue, page, rows);
    }

}
