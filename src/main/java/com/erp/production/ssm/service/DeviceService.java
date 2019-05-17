package com.erp.production.ssm.service;

import com.erp.production.ssm.bean.Device;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.PageResult;

/**
 * Created by HorseXInsect
 * 2019/5/17 18:06
 */
public interface DeviceService {

    PageResult getList(int page, int rows, Device device);

    CustomResult insert(Device device);
    CustomResult deleteBatch(String[] device);
    CustomResult update(Device device);
    CustomResult updateNote(Device device);



}
