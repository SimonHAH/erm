package com.erp.production.ssm.controller.plan;

import com.erp.production.ssm.bean.common.CommonResult;
import com.erp.production.ssm.bean.plan.Task;
import com.erp.production.ssm.service.plan.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/list")
    @ResponseBody
    private CommonResult showList(Integer page,Integer rows){
        CommonResult result = taskService.getList(page, rows);
        return result;
    }

    //根据生产派工id查找
    @RequestMapping("/search_task_by_taskId")
    @ResponseBody
    public CommonResult searchTaskByTaskId(Integer page, Integer rows, String searchValue) {
        CommonResult result = taskService.searchTaskByTaskId(page, rows, searchValue);
        return result;
    }

    //根据作业id查找
    @RequestMapping("/search_task_by_taskWorkId")
    @ResponseBody
    public CommonResult searchTaskByTaskWorkId(Integer page, Integer rows, String searchValue) {
        CommonResult result = taskService.searchTaskByTaskWorkId(page, rows, searchValue);
        return result;
    }

    //根据生产计划id查找
    @RequestMapping("/search_task_by_taskManufactureSn")
    @ResponseBody
    public CommonResult searchTaskByTaskManufactureSn(Integer page, Integer rows, String searchValue) {
        CommonResult result = taskService.searchTaskByTaskManufactureSn(page, rows, searchValue);
        return result;
    }

}
