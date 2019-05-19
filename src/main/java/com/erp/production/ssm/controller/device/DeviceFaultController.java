package com.erp.production.ssm.controller.device;

import com.erp.production.ssm.bean.DeviceFault;
import com.erp.production.ssm.bean.customize.ResponseVo;
import com.erp.production.ssm.service.DeviceFaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by HorseXInsect
 * 2019/5/19 14:37
 */
@Controller
@RequestMapping("/deviceFault")
public class DeviceFaultController {

    @Autowired
    DeviceFaultService deviceFaultService;

    @RequestMapping("/list")
    @ResponseBody
    public ResponseVo getListType(int page, int rows, DeviceFault deviceFault) {
        ResponseVo responseVo = deviceFaultService.getList(page, rows, deviceFault);
        return responseVo;
    }

}
