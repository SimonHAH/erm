package com.erp.production.ssm.bean.VO;

import com.erp.production.ssm.bean.Device;

/**
 * Created by HorseXInsect
 * 2019/5/18 16:41
 */
public class DeviceVO extends Device {
    private String deviceIdd;

    private String deviceTypeName;

    private String deviceKeeper;

    @Override
    public String toString() {
        return "DeviceVO{" +
                "deviceIdd='" + deviceIdd + '\'' +
                ", deviceTypeName='" + deviceTypeName + '\'' +
                ", deviceKeeper='" + deviceKeeper + '\'' +
                '}';
    }

    public String getDeviceIdd() {
        return deviceIdd;
    }

    public void setDeviceIdd(String deviceIdd) {
        this.deviceIdd = deviceIdd;
    }

    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    public String getDeviceKeeper() {
        return deviceKeeper;
    }

    public void setDeviceKeeper(String deviceKeeper) {
        this.deviceKeeper = deviceKeeper;
    }
}
