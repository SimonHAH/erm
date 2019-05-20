package com.erp.production.ssm.controller.plan;

import com.erp.production.ssm.bean.common.CommonResult;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.plan.Work;
import com.erp.production.ssm.service.plan.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/work")
public class WorkController {
    @Autowired
    private WorkService workService;

    @RequestMapping("/find")
    public String find(){
        return "work_list";
    }

    @RequestMapping("/add")
    private String add(){
        return "work_add";
    }

    @RequestMapping("/add_judge")
    private String add_judge(){
        return "work_add";
    }

    @RequestMapping("/edit")
    private String edit(){
        return "work_edit";
    }

    @RequestMapping("/list")
    @ResponseBody
    private CommonResult showList(Integer page,Integer rows){
        CommonResult result = workService.getList(page, rows);
        return result;
    }

    @RequestMapping("/get/{workId}")
    @ResponseBody
    public Work getItemById(@PathVariable String workId){
        Work work = workService.get(workId);
        return work;
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<Work> getData() {
        return workService.find();
    }

    @RequestMapping(value="/insert", method= RequestMethod.POST)
    @ResponseBody
    private CustomResult insert(@Valid Work work, BindingResult bindingResult) throws Exception {
        CustomResult result;
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        if(workService.get(work.getWorkId()) != null){
            result = new CustomResult(0, "该作业编号已经存在，请更换作业编号！", null);
        }else{
            result = workService.insert(work);
        }
        return result;
    }

    //根据作业id查找
    @RequestMapping("/search_work_by_workId")
    @ResponseBody
    public CommonResult searchWorkByWorkId(Integer page, Integer rows, String searchValue) {
        CommonResult result = workService.searchWorkByWorkId(page, rows, searchValue);
        return result;
    }

    //根据产品名称查找
    @RequestMapping("/search_work_by_workProduct")
    @ResponseBody
    public CommonResult searchWorkByWorkProduct(Integer page, Integer rows, String searchValue) {
        CommonResult result = workService.searchWorkByWorkProductName(page, rows, searchValue);
        return result;
    }

    //根据设备id查找
    @RequestMapping("/search_work_by_workDevice")
    @ResponseBody
    public CommonResult searchWorkByWorkDevice(Integer page, Integer rows, String searchValue){
        CommonResult result = workService.searchWorkByWorkDeviceId(page, rows, searchValue);
        return result;
    }

    //根据工序id查找
    @RequestMapping("/search_work_by_workProcess")
    @ResponseBody
    public CommonResult searchWorkByWorkProcess(Integer page, Integer rows, String searchValue) {
        CommonResult result = workService.searchWorkByWorkProcessId(page, rows, searchValue);
        return result;
    }

}
