package com.erp.production.ssm.controller.technology;

import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.bean.technology.Process;
import com.erp.production.ssm.service.technology.ProcessService;
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
@RequestMapping("/process")
public class ProcessController {

    @Autowired
    private ProcessService processService;

    @RequestMapping("/find")
    public String find() {
        return "process_list";
    }


    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(Integer page, Integer rows) {
        return processService.getList(page, rows);
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<Process> getData() {
        List<Process> list = processService.find();

        return list;
    }
}