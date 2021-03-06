package com.erp.production.ssm.service.device;

import com.erp.production.ssm.bean.DeviceType;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.ResponseVo;
import com.erp.production.ssm.mapper.device.DeviceTypeMapper;
import com.erp.production.ssm.service.device.DeviceTypeService;
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

    @Override
    public ResponseVo searchDeviceTypeByDeviceTypeId(int page, int rows, String DeviceTypeId) {
        // 分页
        PageHelper.startPage(page, rows);
        List<DeviceType> list = deviceTypeMapper.searchDeviceTypeByDeviceTypeId(DeviceTypeId);
        ResponseVo responseVo = new ResponseVo();
        responseVo.setRows(list);
        PageInfo<DeviceType> pageInfo = new PageInfo<>(list);
        responseVo.setTotal(pageInfo.getTotal());
        return responseVo;
    }

    @Override
    public ResponseVo searchDeviceByDeviceTypeName(int page, int rows, String DeviceTypeName) {
        PageHelper.startPage(page, rows);
        List<DeviceType> list = deviceTypeMapper.searchDeviceByDeviceTypeName(DeviceTypeName);
        ResponseVo responseVo = new ResponseVo();
        responseVo.setRows(list);
        PageInfo<DeviceType> pageInfo = new PageInfo<>(list);
        responseVo.setTotal(pageInfo.getTotal());
        return responseVo;

    }

    @Override
    public CustomResult insert(DeviceType deviceType) {
        int i = deviceTypeMapper.insert(deviceType);
        if(i>=0){
            return CustomResult.ok();
        }else{
            return CustomResult.build(101, "新增设备信息失败");
        }
    }

    @Override
    public DeviceType get(String deviceId) {
        return deviceTypeMapper.selectByPrimaryKey(deviceId);
    }

    @Override
    public CustomResult deleteBatch(String[] ids) {
        int i = deviceTypeMapper.deleteBatch(ids);
        if(i>=0){
            return CustomResult.ok();
        }else{
            return null;
        }
    }

    @Override
    public CustomResult update(DeviceType deviceType) {
        int i = deviceTypeMapper.updateByPrimaryKeySelective(deviceType);
        if(i>=0){
            return CustomResult.ok();
        }else{
            return CustomResult.build(101, "修改设备信息失败");
        }
    }


}
