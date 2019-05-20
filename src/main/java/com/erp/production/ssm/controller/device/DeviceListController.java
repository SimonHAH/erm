package com.erp.production.ssm.controller.device;

import com.erp.production.ssm.bean.Device;
import com.erp.production.ssm.bean.customize.ResponseVo;
import com.erp.production.ssm.service.device.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by HorseXInsect
 * 2019/5/17 17:16
 */
@Controller
@RequestMapping("/deviceList")
public class DeviceListController{

    @Autowired
    DeviceService deviceService;


    @RequestMapping("/list")
    @ResponseBody
    public ResponseVo getList(int page, int rows, Device device) {
        ResponseVo responseVo = deviceService.getList(page, rows, device);

        return responseVo;

    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<Device> getData() {
        return deviceService.find();
    }

    // 迷之add_judge
    @RequestMapping("/add_judge")
    public String add() {
        return "deviceList_add";
    }

    // 玄幻add
    @RequestMapping("/add")
    public String add1() {
        return "deviceList_add";
    }

    //根据设备种类编号查找
    @RequestMapping("/search_device_by_deviceId")
    @ResponseBody
    public ResponseVo searchDeviceByDeviceId(int page, int rows, String searchValue) {
        ResponseVo responseVo = deviceService.searchDeviceByDeviceId(page, rows, searchValue);
        return responseVo;
    }

    // 根据设备名称查找
    @RequestMapping("/search_device_by_deviceName")
    @ResponseBody
    public ResponseVo searchDeviceByDeviceName(int page, int rows, String searchValue) {
        ResponseVo responseVo = deviceService.searchDeviceByDeviceName(page, rows, searchValue);
        return responseVo;
    }

    // 根据设备名称查找
    @RequestMapping("/search_device_by_deviceTypeName")
    @ResponseBody
    public ResponseVo searchDeviceByDeviceTypeName(int page, int rows, String searchValue) {
        ResponseVo responseVo = deviceService.searchDeviceByDeviceTypeName(page, rows, searchValue);
        return responseVo;
    }


}
