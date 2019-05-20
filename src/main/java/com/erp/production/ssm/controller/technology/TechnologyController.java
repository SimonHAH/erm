package com.erp.production.ssm.controller.technology;

import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.bean.technology.Technology;
import com.erp.production.ssm.service.technology.ProcessService;
import com.erp.production.ssm.service.technology.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    @Autowired
    private ProcessService processService;

    @RequestMapping("/find")
    public String find() {

        return "technology_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(Integer page, Integer rows) {

        return technologyService.getList(page, rows);
    }

    @RequestMapping("get_data")
    @ResponseBody
    public List<Technology> getData() {
        List<Technology> list = technologyService.find();
        return list;
    }

    @RequestMapping("/add_judge")
    public String add_judge() {
        return null;
    }

    @RequestMapping("/add")
    public String add() {
        return "technology_add";
    }

    @RequestMapping("/insert")
    public void insert() {

    }

    @RequestMapping("/get/{technologyId}")
    @ResponseBody
    public Technology getItemById(@PathVariable String technologyId) {
        Technology technology = technologyService.getItemById(technologyId);
        return technology;
    }


}
