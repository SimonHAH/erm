package com.erp.production.ssm.bean.VO;

import com.erp.production.ssm.bean.DeviceFault;

/**
 * Created by HorseXInsect
 * 2019/5/19 14:47
 */
public class DeviceFaultVO extends DeviceFault {

    String deviceName;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
}
