package com.erp.production.ssm.mapper.device;

import com.erp.production.ssm.bean.DeviceCheck;
import com.erp.production.ssm.bean.DeviceCheckExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceCheckMapper {
    long countByExample(DeviceCheckExample example);

    int deleteByExample(DeviceCheckExample example);

    int deleteByPrimaryKey(String deviceCheckId);

    int insert(DeviceCheck record);

    int insertSelective(DeviceCheck record);

    List<DeviceCheck> selectByExample(DeviceCheckExample example);

    DeviceCheck selectByPrimaryKey(String deviceCheckId);

    int updateByExampleSelective(@Param("record") DeviceCheck record, @Param("example") DeviceCheckExample example);

    int updateByExample(@Param("record") DeviceCheck record, @Param("example") DeviceCheckExample example);

    int updateByPrimaryKeySelective(DeviceCheck record);

    int updateByPrimaryKey(DeviceCheck record);


    // 自定义接口
    List<DeviceCheck> find(DeviceCheck deviceCheck);

    int deleteBatch(String[] deviceCheckIds);

    int update(DeviceCheck deviceCheck);

    List<DeviceCheck> searchDeviceCheckByDeviceCheckId(String deviceCheckId);

}