package com.erp.production.ssm.service.device;

import com.erp.production.ssm.bean.DeviceMaintain;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.ResponseVo;
import com.erp.production.ssm.mapper.device.DeviceMaintainMapper;
import com.erp.production.ssm.service.device.DeviceMaintainService;
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

    @Override
    public DeviceMaintain get(String deviceMaintainId) {
        return deviceMaintainMapper.selectByPrimaryKey(deviceMaintainId);
    }

    @Override
    public CustomResult insert(DeviceMaintain deviceMaintain) {
        int i = deviceMaintainMapper.insert(deviceMaintain);
        if(i>=0){
            return CustomResult.ok();
        }else{
            return CustomResult.build(101, "新增设备维修信息失败");
        }
    }

    @Override
    public CustomResult deleteBatch(String[] deviceMaintainIds) {
        int i = deviceMaintainMapper.deleteBatch(deviceMaintainIds);
        if(i>=0){
            return CustomResult.ok();
        }else{
            return null;
        }
    }

    @Override
    public CustomResult update(DeviceMaintain deviceMaintain) {
        int i = deviceMaintainMapper.updateByPrimaryKeySelective(deviceMaintain);
        if (i >= 0) {
            return CustomResult.ok();
        } else {
            return CustomResult.build(101, "修改设备维修信息失败");
        }
    }
}
