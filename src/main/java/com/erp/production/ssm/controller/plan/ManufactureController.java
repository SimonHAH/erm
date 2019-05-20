package com.erp.production.ssm.controller.plan;

import com.erp.production.ssm.bean.common.CommonResult;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.plan.Manufacture;
import com.erp.production.ssm.service.plan.ManufactureService;
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
@RequestMapping("/manufacture")
public class ManufactureController {

    @Autowired
    ManufactureService manufactureService;

    @RequestMapping("/find")
    public String find(){
        return "manufacture_list";
    }

    @RequestMapping("/add")
    private String add(){
        return "manufacture_add";
    }

    @RequestMapping("/add_judge")
    private String add_judge(){
        return "manufacture_add";
    }

    @RequestMapping("/edit")
    private String edit(){
        return "manufacture_edit";
    }

    @RequestMapping("/edit_judge")
    @ResponseBody
    private String editJudge(){
        return null;
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    private String deleteJudge(){
        return null;
    }

    @RequestMapping("/list")
    @ResponseBody
    private CommonResult showList(Integer page, Integer rows){
        CommonResult result = manufactureService.getList(page, rows);
        return result;
    }

    @RequestMapping("/get/{manufactureSn}")
    @ResponseBody
    public Manufacture getItemById(@PathVariable String manufactureSn){
        Manufacture manufacture = manufactureService.get(manufactureSn);
        return manufacture;
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<Manufacture> getData() {
        return manufactureService.find();
    }

    @RequestMapping(value="/insert", method= RequestMethod.POST)
    @ResponseBody
    private CustomResult insert(@Valid Manufacture manufacture, BindingResult bindingResult) throws Exception {
        CustomResult result;
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        if(manufactureService.get(manufacture.getManufactureSn()) != null){
            result = new CustomResult(0, "该生产批号已经存在，请更换生产批号！", null);
        }else{
            result = manufactureService.insert(manufacture);
        }
        return result;
    }

    @RequestMapping(value="/update_all")
    @ResponseBody
    private CustomResult updateAll(@Valid Manufacture manufacture, BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        return manufactureService.updateAll(manufacture);
    }


    @RequestMapping(value="/delete_batch")
    @ResponseBody
    private CustomResult deleteBatch(String[] ids) throws Exception {
        CustomResult result = manufactureService.deleteBatch(ids);
        return result;
    }


    //根据生产批号查找
    @RequestMapping("/search_manufacture_by_manufactureSn")
    @ResponseBody
    public CommonResult searchManufactureByManufactureSn(Integer page, Integer rows, String searchValue) {
        CommonResult result = manufactureService.searchManufactureByManufactureSn(page, rows, searchValue);
        return result;
    }

    //根据订单id查找
    @RequestMapping("/search_manufacture_by_manufactureOrderId")
    @ResponseBody
    public CommonResult searchManufactureByManufactureOrderId(Integer page, Integer rows, String searchValue) {
        CommonResult result = manufactureService.searchManufactureByManufactureOrderId(page, rows, searchValue);
        return result;
    }

    //根据工艺名称查找
    @RequestMapping("/search_manufacture_by_manufactureTechnologyName")
    @ResponseBody
    public CommonResult searchManufactureByManufactureTechnologyName(Integer page, Integer rows, String searchValue) {
        CommonResult result = manufactureService.searchManufactureByManufactureTechnologyName(page, rows, searchValue);
        return result;
    }

}
