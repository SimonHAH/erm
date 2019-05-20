package com.erp.production.ssm.service.device;

import com.erp.production.ssm.bean.DeviceFault;
import com.erp.production.ssm.bean.VO.DeviceFaultVO;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.ResponseVo;
import com.erp.production.ssm.mapper.device.DeviceFaultMapper;
import com.erp.production.ssm.service.device.DeviceFaultService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by HorseXInsect
 * 2019/5/19 14:45
 */
@Service
public class DeviceFaultServiceImpl implements DeviceFaultService {

    @Autowired
    DeviceFaultMapper deviceFaultMapper;

    @Override
    public ResponseVo getList(int page, int rows, DeviceFault deviceFault) {
        PageHelper.startPage(page, rows);
        List<DeviceFaultVO> list = deviceFaultMapper.find(deviceFault);
        ResponseVo responseVo = new ResponseVo();
        responseVo.setRows(list);
        PageInfo<DeviceFaultVO> pageInfo = new PageInfo<>(list);
        responseVo.setTotal(pageInfo.getTotal());
        return responseVo;
    }

    @Override
    public DeviceFault get(String deviceFaultId) {
        return deviceFaultMapper.selectByPrimaryKey(deviceFaultId);
    }

    @Override
    public CustomResult insert(DeviceFault deviceFault) {
        int i = deviceFaultMapper.insert(deviceFault);
        if(i>=0){
            return CustomResult.ok();
        }else{
            return CustomResult.build(101, "新增设备故障失败");
        }
    }

    @Override
    public CustomResult deleteBatch(String[] deviceFaultId) {
        int i = deviceFaultMapper.deleteBatch(deviceFaultId);
        if(i>=0){
            return CustomResult.ok();
        }else{
            return null;
        }
    }

    @Override
    public CustomResult update(DeviceFault deviceFault) {
        int i = deviceFaultMapper.updateByPrimaryKeySelective(deviceFault);
        if(i>=0){
            return CustomResult.ok();
        }else{
            return CustomResult.build(101, "修改设备故障信息失败");
        }
    }
}
