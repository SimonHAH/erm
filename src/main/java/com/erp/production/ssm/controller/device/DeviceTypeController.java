package com.erp.production.ssm.controller.device;

import com.erp.production.ssm.bean.DeviceType;
import com.erp.production.ssm.bean.customize.ResponseVo;
import com.erp.production.ssm.service.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by HorseXInsect
 * 2019/5/18 17:49
 */
@Controller
@RequestMapping("deviceType")
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

}
