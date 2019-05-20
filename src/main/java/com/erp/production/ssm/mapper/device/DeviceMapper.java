package com.erp.production.ssm.mapper.device;

import com.erp.production.ssm.bean.Device;
import com.erp.production.ssm.bean.DeviceExample;
import com.erp.production.ssm.bean.DeviceType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceMapper {

    List<Device> find(Device device);

    List<Device> getData();

    int deleteBatch(@Param("array") String[] deviceIds);

    //根据设备id查找设备信息
    List<Device> searchDeviceByDeviceId(@Param("deviceId") String deviceId);

    // 根据设备名称查找
    List<Device> searchDeviceByDeviceName(@Param("deviceName") String deviceName);

    // 根据设备种类名查找
    List<Device> searchDeviceByDeviceTypeName(@Param("deviceTypeName") String deviceTypeName);



    // 逆向工程生成的mapper接口
    long countByExample(DeviceExample example);

    int deleteByExample(DeviceExample example);

    int deleteByPrimaryKey(String deviceId);

    int insert(Device record);

    int insertSelective(Device record);

    List<Device> selectByExample(DeviceExample example);

    Device selectByPrimaryKey(String deviceId);

    int updateByExampleSelective(@Param("record") Device record, @Param("example") DeviceExample example);

    int updateByExample(@Param("record") Device record, @Param("example") DeviceExample example);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);


}