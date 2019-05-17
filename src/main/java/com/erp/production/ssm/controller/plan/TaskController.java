package com.erp.production.ssm.controller.plan;

import com.erp.production.ssm.service.plan.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

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


}
