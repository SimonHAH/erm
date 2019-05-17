package com.erp.production.ssm.service.impl;

import com.erp.production.ssm.bean.Device;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.mapper.DeviceMapper;
import com.erp.production.ssm.service.DeviceService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by HorseXInsect
 * 2019/5/17 22:13
 */
@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceMapper deviceMapper;

    @Override
    public PageResult getList(int page, int rows, Device device) {
        //分页处理，获取第1页，10条内容，默认查询总数count
        PageHelper.startPage(page, rows);


        return null;
    }

    @Override
    public CustomResult insert(Device device) {
        return null;
    }

    @Override
    public CustomResult deleteBatch(String[] device) {
        return null;
    }

    @Override
    public CustomResult update(Device device) {
        return null;
    }

    @Override
    public CustomResult updateNote(Device device) {
        return null;
    }
}
