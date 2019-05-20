package com.erp.production.ssm.service.impl;

import com.erp.production.ssm.bean.DeviceCheck;
import com.erp.production.ssm.bean.customize.ResponseVo;
import com.erp.production.ssm.mapper.DeviceCheckMapper;
import com.erp.production.ssm.service.device.DeviceCheckService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by HorseXInsect
 * 2019/5/18 21:48
 */
@Service
public class DeviceCheckServiceImpl implements DeviceCheckService {

    @Autowired
    DeviceCheckMapper deviceCheckMapper;

    @Override
    public ResponseVo getList(int page, int rows, DeviceCheck deviceCheck) {
        // 分页
        PageHelper.startPage(page, rows);
        List<DeviceCheck> list = deviceCheckMapper.find(deviceCheck);
        // 创建返回值对象
        ResponseVo responseVo = new ResponseVo();
        responseVo.setRows(list);
        // 记录总条数
        PageInfo<DeviceCheck> pageInfo = new PageInfo<>(list);
        responseVo.setTotal(pageInfo.getTotal());
        return responseVo;
    }
}
