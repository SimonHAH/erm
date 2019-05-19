package com.erp.production.ssm.service.impl;

import com.erp.production.ssm.bean.DeviceMaintain;
import com.erp.production.ssm.bean.customize.ResponseVo;
import com.erp.production.ssm.mapper.DeviceMaintainMapper;
import com.erp.production.ssm.service.DeviceMaintainService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by HorseXInsect
 * 2019/5/19 15:30
 */
@Service
public class DeviceMaintainServiceImpl implements DeviceMaintainService {

    @Autowired
    DeviceMaintainMapper deviceMaintainMapper;

    @Override
    public ResponseVo getList(int page, int rows, DeviceMaintain deviceMaintain) {
        PageHelper.startPage(page, rows);
        List<DeviceMaintain> list = deviceMaintainMapper.find(deviceMaintain);
        ResponseVo responseVo = new ResponseVo();
        responseVo.setRows(list);
        PageInfo<DeviceMaintain> pageInfo = new PageInfo<>(list);
        responseVo.setTotal(pageInfo.getTotal());
        return responseVo;
    }
}
