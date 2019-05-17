package com.erp.production.ssm.controller.device;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by HorseXInsect
 * 2019/5/17 20:49
 */
@Controller
@RequestMapping("/device")
public class DeviceController {

    @RequestMapping("/deviceList")
    public String deviceList() {
        return "deviceList";
    }

    @RequestMapping("/deviceType")
    public String deviceType() {
        return "deviceType";
    }

    @RequestMapping("deviceCheck")
    public String deviceCheck() {
        return "deviceCheck";
    }

    @RequestMapping("deviceFault")
    public String deviceFault() {
        return "deviceFault";
    }

    @RequestMapping("deviceMaintain")
    public String deviceMaintain() {
        return "deviceMaintain";
    }
}
