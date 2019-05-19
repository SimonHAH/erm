package com.erp.production.ssm.service.impl;

import com.erp.production.ssm.bean.Device;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.ResponseVo;
import com.erp.production.ssm.mapper.DeviceMapper;
import com.erp.production.ssm.service.DeviceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by HorseXInsect
 * 2019/5/17 22:13
 */
@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceMapper deviceMapper;

    @Override
    public ResponseVo getList(int page, int rows, Device device) {
        //分页处理，获取第1页，10条内容，默认查询总数count
        PageHelper.startPage(page, rows);
        List<Device> list = deviceMapper.find(device);
        //创建一个返回值对象
        ResponseVo result = new ResponseVo();
        result.setRows(list);
        //取记录总条数
        PageInfo<Device> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;

    }

    @Override
    public List<Device> find() {
        List<Device> deviceList = deviceMapper.getData();
        return deviceList;
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
