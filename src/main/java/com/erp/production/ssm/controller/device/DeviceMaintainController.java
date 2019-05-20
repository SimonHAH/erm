package com.erp.production.ssm.controller.device;

import com.erp.production.ssm.bean.DeviceMaintain;
import com.erp.production.ssm.bean.customize.ResponseVo;
import com.erp.production.ssm.service.device.DeviceMaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
