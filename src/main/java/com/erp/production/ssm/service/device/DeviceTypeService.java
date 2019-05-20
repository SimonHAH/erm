package com.erp.production.ssm.service.device;

import com.erp.production.ssm.bean.DeviceType;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.ResponseVo;

import java.util.List;

/**
 * Created by HorseXInsect
 * 2019/5/18 17:53
 */
public interface DeviceTypeService {
    ResponseVo getList(int page, int rows, DeviceType deviceType);

    List<DeviceType> find();

    ResponseVo searchDeviceTypeByDeviceTypeId(int page, int rows, String DeviceTypeId);

    ResponseVo searchDeviceByDeviceTypeName(int page, int rows, String DeviceTypeName);

    CustomResult insert(DeviceType deviceType);

    DeviceType get(String deviceId);

    CustomResult deleteBatch(String[] ids);

    CustomResult update(DeviceType deviceType);
}
