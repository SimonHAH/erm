package com.erp.production.ssm.service.device;

import com.erp.production.ssm.bean.Device;
import com.erp.production.ssm.bean.DeviceType;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.ResponseVo;

import java.util.List;

/**
 * Created by HorseXInsect
 * 2019/5/17 18:06
 */
public interface DeviceService {

    ResponseVo getList(int page, int rows, Device device);

    List<Device> find();

    // 根据id查找
    ResponseVo searchDeviceByDeviceId(int page, int rows, String deviceId);

    // 根据名称查找
    ResponseVo searchDeviceByDeviceName(int page, int rows, String deviceName);

    // 根据设备各类查找
    ResponseVo searchDeviceByDeviceTypeName(int page, int rows, String deviceTypeName);

    Device get(String deviceId);


    CustomResult insert(Device device);
    CustomResult deleteBatch(String[] deviceIds);
    CustomResult update(Device device);
    CustomResult updateNote(Device device);


}
