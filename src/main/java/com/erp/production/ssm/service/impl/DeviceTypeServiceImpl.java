package com.erp.production.ssm.service.impl;

import com.erp.production.ssm.bean.Device;
import com.erp.production.ssm.bean.DeviceType;
import com.erp.production.ssm.bean.customize.ResponseVo;
import com.erp.production.ssm.mapper.DeviceTypeMapper;
import com.erp.production.ssm.service.DeviceTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by HorseXInsect
 * 2019/5/18 17:54
 */
@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {

    @Autowired
    DeviceTypeMapper deviceTypeMapper;

    @Override
    public ResponseVo getList(int page, int rows, DeviceType deviceType) {
        // 分页处理
        PageHelper.startPage(page, rows);
        List<DeviceType> list = deviceTypeMapper.find(deviceType);
        //创建一个返回值对象
        ResponseVo responseVo = new ResponseVo();
        responseVo.setRows(list);
        //取记录总条数
        PageInfo<DeviceType> pageInfo = new PageInfo<>(list);
        responseVo.setTotal(pageInfo.getTotal());

        return responseVo;
    }

    @Override
    public List<DeviceType> find() {
        List<DeviceType> list = deviceTypeMapper.listType();
        return list;
    }
}
