package com.erp.production.ssm.bean.VO;

import com.erp.production.ssm.bean.DeviceCheck;

/**
 * Created by HorseXInsect
 * 2019/5/18 22:14
 */
public class DeviceCheckVO extends DeviceCheck {

    String deviceName;

    String deviceCheckEmp;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceCheckEmp() {
        return deviceCheckEmp;
    }

    public void setDeviceCheckEmp(String deviceCheckEmp) {
        this.deviceCheckEmp = deviceCheckEmp;
    }
}
