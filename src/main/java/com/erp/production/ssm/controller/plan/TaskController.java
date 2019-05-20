package com.erp.production.ssm.controller.plan;

import com.erp.production.ssm.bean.common.CommonResult;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.plan.Task;
import com.erp.production.ssm.service.plan.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

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

    @RequestMapping("/add_judge")
    private String addJudge(){
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

    @RequestMapping("/get_data")
    @ResponseBody
    public List<Task> getData() {
        return taskService.find();
    }

    @RequestMapping(value="/insert", method= RequestMethod.POST)
    @ResponseBody
    private CustomResult insert(@Valid Task task, BindingResult bindingResult) throws Exception{
        CustomResult result;
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        if(taskService.get(task.getTaskId()) != null){
            result = new CustomResult(0, "该生产派工编号已经存在，请更换生产派工编号！", null);
        }else{
            result = taskService.insert(task);
        }
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
