package com.erp.production.ssm.controller.device;

import com.erp.production.ssm.bean.Device;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.service.DeviceService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public PageResult getList(int page, int rows, Device device) {
        PageResult result = deviceService.getList(page, rows, device);
        return result;
    }

    @RequestMapping("/add")
    public String add() {
        return "deviceList_add";
    }


}
