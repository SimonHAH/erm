package com.erp.production.ssm.service;

import com.erp.production.ssm.bean.DeviceCheck;
import com.erp.production.ssm.bean.customize.ResponseVo;
import org.springframework.stereotype.Service;

/**
 * Created by HorseXInsect
 * 2019/5/18 21:44
 */

public interface DeviceCheckService {
    ResponseVo getList(int page, int rows, DeviceCheck deviceCheck);
}
