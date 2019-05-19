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

    /*@RequestMapping("/get_data")
    @ResponseBody
    public List<DeviceType> getData() {
        List<DeviceType> list = deviceTypeService.find();
        return list;
    }*/

}
