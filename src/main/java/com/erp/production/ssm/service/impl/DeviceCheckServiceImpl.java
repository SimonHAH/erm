package com.erp.production.ssm.service.impl;

import com.erp.production.ssm.bean.DeviceCheck;
import com.erp.production.ssm.bean.customize.CustomResult;
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

    @Override
    public DeviceCheck get(String id) {
        return deviceCheckMapper.selectByPrimaryKey(id);
    }

    @Override
    public CustomResult insert(DeviceCheck deviceCheck) {
        int i = deviceCheckMapper.insert(deviceCheck);
        if(i>=0){
            return CustomResult.ok();
        }else{
            return CustomResult.build(101, "新增设备例检失败");
        }
    }

    @Override
    public CustomResult deleteBatch(String[] deviceCheckIds) {
        int i = deviceCheckMapper.deleteBatch(deviceCheckIds);
        if(i>=0){
            return CustomResult.ok();
        }else{
            return null;
        }
    }

    @Override
    public CustomResult update(DeviceCheck deviceCheck) {
        int i = deviceCheckMapper.updateByPrimaryKeySelective(deviceCheck);
        if(i>=0){
            return CustomResult.ok();
        }else{
            return CustomResult.build(101, "修改设备例检失败");
        }
    }
}
