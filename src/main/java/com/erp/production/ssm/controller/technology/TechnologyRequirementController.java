package com.erp.production.ssm.controller.technology;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Nemo
 * @version 1.0
 * @date 2019/5/18
 */
@Controller
@RequestMapping("/technologyRequirement")
public class TechnologyRequirementController {


    @RequestMapping("/find")
    public String find() {

        return "technologyRequirement_list";
    }

}
