package com.erp.production.ssm.service.device;

import com.erp.production.ssm.bean.Device;
import com.erp.production.ssm.bean.DeviceFault;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.ResponseVo;

/**
 * Created by HorseXInsect
 * 2019/5/19 14:38
 */
public interface DeviceFaultService {

    ResponseVo getList(int page, int rows, DeviceFault deviceFault);


    DeviceFault get(String deviceFaultId);

    CustomResult insert(DeviceFault deviceFault);

    CustomResult deleteBatch(String[] deviceFaultId);


    CustomResult update(DeviceFault deviceFault);
}
