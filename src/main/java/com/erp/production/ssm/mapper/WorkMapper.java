package com.erp.production.ssm.mapper;

import com.erp.production.ssm.bean.plan.Work;
import com.erp.production.ssm.bean.plan.WorkExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkMapper {

    //自己扩展的方法
    List<Work> find();

    List<Work> searchWorkByWorkId(@Param("workId") String workId);

    List<Work> searchWorkByWorkProductName(@Param("productName") String productName);

    List<Work> searchWorkByWorkDeviceId(@Param("deviceId") String deviceId);

    List<Work> searchWorkByWorkProcessId(@Param("processId") String processId);

    //逆向工程生产的方法
    long countByExample(WorkExample example);

    int deleteByExample(WorkExample example);

    int deleteByPrimaryKey(String workId);

    int insert(Work record);

    int insertSelective(Work record);

    List<Work> selectByExample(WorkExample example);

    Work selectByPrimaryKey(String workId);

    int updateByExampleSelective(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByExample(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);


}