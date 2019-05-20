package com.erp.production.ssm.service.device;

import com.erp.production.ssm.bean.Device;
import com.erp.production.ssm.bean.DeviceCheck;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.ResponseVo;
import org.springframework.stereotype.Service;

/**
 * Created by HorseXInsect
 * 2019/5/18 21:44
 */

public interface DeviceCheckService {
    ResponseVo getList(int page, int rows, DeviceCheck deviceCheck);

    DeviceCheck get(String deviceId);

    CustomResult insert(DeviceCheck deviceCheck);

    CustomResult deleteBatch(String[] ids);

    CustomResult update(DeviceCheck deviceCheck);

    ResponseVo searchDeviceCheckByDeviceCheckId(int page, int rows, String searchValue);
}
