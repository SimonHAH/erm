package com.erp.production.ssm.service;

import com.erp.production.ssm.bean.DeviceType;
import com.erp.production.ssm.bean.customize.ResponseVo;

import java.util.List;

/**
 * Created by HorseXInsect
 * 2019/5/18 17:53
 */
public interface DeviceTypeService {
    ResponseVo getList(int page, int rows, DeviceType deviceType);

    List<DeviceType> find();
}
