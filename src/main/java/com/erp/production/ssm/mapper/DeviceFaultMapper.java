package com.erp.production.ssm.mapper;

import com.erp.production.ssm.bean.DeviceFault;
import com.erp.production.ssm.bean.DeviceFaultExample;
import com.erp.production.ssm.bean.VO.DeviceFaultVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceFaultMapper {
    long countByExample(DeviceFaultExample example);

    int deleteByExample(DeviceFaultExample example);

    int deleteByPrimaryKey(String deviceFaultId);

    int insert(DeviceFault record);

    int insertSelective(DeviceFault record);

    List<DeviceFault> selectByExample(DeviceFaultExample example);

    DeviceFault selectByPrimaryKey(String deviceFaultId);

    int updateByExampleSelective(@Param("record") DeviceFault record, @Param("example") DeviceFaultExample example);

    int updateByExample(@Param("record") DeviceFault record, @Param("example") DeviceFaultExample example);

    int updateByPrimaryKeySelective(DeviceFault record);

    int updateByPrimaryKey(DeviceFault record);

    // 自定义接口
    List<DeviceFaultVO> find(DeviceFault deviceFault);

    int deleteBatch(String[] deviceFaultId);
}