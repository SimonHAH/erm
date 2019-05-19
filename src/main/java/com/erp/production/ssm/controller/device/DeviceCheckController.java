package com.erp.production.ssm.controller.device;

import com.erp.production.ssm.bean.DeviceCheck;
import com.erp.production.ssm.bean.customize.ResponseVo;
import com.erp.production.ssm.service.DeviceCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
