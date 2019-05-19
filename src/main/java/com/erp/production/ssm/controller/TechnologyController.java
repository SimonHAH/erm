package com.erp.production.ssm.controller;

import com.erp.production.ssm.bean.customize.ResponseVo;
import com.erp.production.ssm.bean.technology.Technology;
import com.erp.production.ssm.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Nemo
 * @version 1.0
 * @date 2019/5/17
 */
@Controller
@RequestMapping("/technology")
public class TechnologyController {

    @Autowired
    private TechnologyService technologyService;

    @RequestMapping("/find")
    public String find() {

        return "technology_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public ResponseVo list(Integer page, Integer rows, Technology technology) {

        ResponseVo result = technologyService.getList(page, rows, technology);

        return result;
    }
}
