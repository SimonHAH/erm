package com.erp.production.ssm.controller.device;

import com.erp.production.ssm.bean.DeviceFault;
import com.erp.production.ssm.bean.DeviceMaintain;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.ResponseVo;
import com.erp.production.ssm.service.device.DeviceMaintainService;
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
 * 2019/5/19 15:28
 */
@Controller
@RequestMapping("/deviceMaintain")
public class DeviceMaintainController {

    @Autowired
    DeviceMaintainService deviceMaintainService;

    @RequestMapping("/list")
    @ResponseBody
    public ResponseVo getListType(int page, int rows, DeviceMaintain deviceMaintain) {
        ResponseVo responseVo = deviceMaintainService.getList(page, rows, deviceMaintain);
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
        return "deviceMaintain_add";
    }

    // 新增
    @RequestMapping(value="/insert", method= RequestMethod.POST)
    @ResponseBody
    private CustomResult insert(@Valid DeviceMaintain deviceMaintain, BindingResult bindingResult) {
        CustomResult result;
        /*if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(123, fieldError.getDefaultMessage());
        }*/
        if(deviceMaintainService.get(deviceMaintain.getDeviceMaintainId()) != null){
            result = new CustomResult(0, "该设备编号已经存在，请更换设备编号！", null);
        }else{
            result = deviceMaintainService.insert(deviceMaintain);
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
        CustomResult result = deviceMaintainService.deleteBatch(ids);
        return result;
    }

    @RequestMapping("/edit_judge")
    @ResponseBody
    private CustomResult editJudge() {
        return null;
    }

    @RequestMapping("/edit")
    private String edit() {
        return "deviceMaintain_edit";
    }

    // 更新
    @RequestMapping(value="/update")
    @ResponseBody
    private CustomResult update(@Valid DeviceMaintain deviceMaintain, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(123, fieldError.getDefaultMessage());
        }
        return deviceMaintainService.update(deviceMaintain);
    }
}
