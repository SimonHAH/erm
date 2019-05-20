package com.erp.production.ssm.mapper.device;

import com.erp.production.ssm.bean.DeviceType;
import com.erp.production.ssm.bean.DeviceTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceTypeMapper {
    // 逆向接口
    long countByExample(DeviceTypeExample example);

    int deleteByExample(DeviceTypeExample example);

    int deleteByPrimaryKey(String deviceTypeId);

    int insert(DeviceType record);

    int insertSelective(DeviceType record);

    List<DeviceType> selectByExample(DeviceTypeExample example);

    DeviceType selectByPrimaryKey(String deviceTypeId);

    int updateByExampleSelective(@Param("record") DeviceType record, @Param("example") DeviceTypeExample example);

    int updateByExample(@Param("record") DeviceType record, @Param("example") DeviceTypeExample example);

    int updateByPrimaryKeySelective(DeviceType record);

    int updateByPrimaryKey(DeviceType record);


    // 自定义的接口
    List<DeviceType> find(DeviceType deviceType);

    List<DeviceType> listType();

    List<DeviceType> searchDeviceTypeByDeviceTypeId(@Param("deviceTypeId") String deviceTypeId);

    List<DeviceType> searchDeviceByDeviceTypeName(@Param("deviceTypeName") String deviceTypeName);

    int deleteBatch(String[] ids);
}