package com.erp.production.ssm.controller.device;

import com.erp.production.ssm.bean.Device;
import com.erp.production.ssm.bean.DeviceCheck;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.ResponseVo;
import com.erp.production.ssm.service.device.DeviceCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Created by HorseXInsect
 * 2019/5/18 21:42
 */
@Controller
@RequestMapping("/deviceCheck")
public class DeviceCheckController {

    @Autowired
    DeviceCheckService deviceCheckService;

    @RequestMapping("/list")
    @ResponseBody
    public ResponseVo getListCheck(int page, int rows, DeviceCheck deviceCheck) {
        ResponseVo responseVo = deviceCheckService.getList(page, rows, deviceCheck);
        return responseVo;
    }

    // 必须要返回点什么才能通过add_judge访问到add，贼jb蠢
    @RequestMapping("/add_judge")
    @ResponseBody
    public String add() {
        return null;
    }


    @RequestMapping("/add")
    public String add1() {
        return "deviceCheck_add";
    }

    // 新增
    @RequestMapping(value="/insert", method= RequestMethod.POST)
    @ResponseBody
    private CustomResult insert(@Valid DeviceCheck deviceCheck, BindingResult bindingResult) {
        CustomResult result;
        /*if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(123, fieldError.getDefaultMessage());
        }*/
        if(deviceCheckService.get(deviceCheck.getDeviceCheckId()) != null){
            result = new CustomResult(0, "该设备编号已经存在，请更换设备编号！", null);
        }else{
            result = deviceCheckService.insert(deviceCheck);
        }
        return result;
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    private CustomResult deleteJudge() {
        return null;
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    private CustomResult deleteBatch(String[] ids) {
        CustomResult result = deviceCheckService.deleteBatch(ids);
        return result;
    }

    @RequestMapping("/edit_judge")
    @ResponseBody
    private CustomResult editJudge() {
        return null;
    }

    @RequestMapping("/edit")
    private String edit() {
        return "deviceCheck_edit";
    }

    @RequestMapping(value="/update")
    @ResponseBody
    private CustomResult update(@Valid DeviceCheck deviceCheck, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(123, fieldError.getDefaultMessage());
        }
        return deviceCheckService.update(deviceCheck);
    }
}
