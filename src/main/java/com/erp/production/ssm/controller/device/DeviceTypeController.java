package com.erp.production.ssm.controller.device;

import com.erp.production.ssm.bean.Device;
import com.erp.production.ssm.bean.DeviceType;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.ResponseVo;
import com.erp.production.ssm.service.device.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by HorseXInsect
 * 2019/5/18 17:49
 */
@Controller
@RequestMapping("/deviceType")
public class DeviceTypeController {

    @Autowired
    DeviceTypeService deviceTypeService;

    @RequestMapping("/list")
    @ResponseBody
    public ResponseVo getListType(int page, int rows, DeviceType deviceType) {
        ResponseVo responseVo = deviceTypeService.getList(page, rows, deviceType);
        return responseVo;
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<DeviceType> getData() {
        List<DeviceType> list = deviceTypeService.find();
        return list;
    }

    //根据设备种类编号查找
    @RequestMapping("/search_deviceType_by_deviceTypeId")
    @ResponseBody
    public ResponseVo searchDeviceByDeviceId(int page, int rows, String searchValue) {
        ResponseVo responseVo = deviceTypeService.searchDeviceTypeByDeviceTypeId(page, rows, searchValue);
        return responseVo;
    }

    // 根据设备种类名称
    @RequestMapping("search_deviceType_by_deviceTypeName")
    @ResponseBody
    public ResponseVo searchDeviceByDeviceTypeName(int page, int rows, String searchValue) {
        ResponseVo responseVo = deviceTypeService.searchDeviceByDeviceTypeName(page, rows, searchValue);
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
        return "deviceType_add";
    }

    // 新增
    @RequestMapping(value="/insert", method= RequestMethod.POST)
    @ResponseBody
    private CustomResult insert(@Valid DeviceType deviceType, BindingResult bindingResult) {
        CustomResult result;
        /*if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(123, fieldError.getDefaultMessage());
        }*/
        if(deviceTypeService.get(deviceType.getDeviceTypeId()) != null){
            result = new CustomResult(0, "该设备编号已经存在，请更换设备编号！", null);
        }else{
            result = deviceTypeService.insert(deviceType);
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
        CustomResult result = deviceTypeService.deleteBatch(ids);
        return result;
    }

    @RequestMapping("/edit_judge")
    @ResponseBody
    private CustomResult editJudge() {
        return null;
    }

    @RequestMapping("/edit")
    private String edit() {
        return "deviceType_edit";
    }

    @RequestMapping(value="/update")
    @ResponseBody
    private CustomResult update(@Valid DeviceType deviceType, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        return deviceTypeService.update(deviceType);
    }


}
