package com.erp.production.ssm.mapper;

import com.erp.production.ssm.bean.technology.Process;
import com.erp.production.ssm.bean.technology.ProcessExample;
import com.erp.production.ssm.bean.technology.TechnologyPlan;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessMapper {
    long countByExample(ProcessExample example);

    int deleteByExample(ProcessExample example);

    int deleteByPrimaryKey(String processId);

    int insert(Process record);

    int insertSelective(Process record);

    List<Process> selectByExample(ProcessExample example);

    Process selectByPrimaryKey(String processId);

    int updateByExampleSelective(@Param("record") Process record, @Param("example") ProcessExample example);

    int updateByExample(@Param("record") Process record, @Param("example") ProcessExample example);

    int updateByPrimaryKeySelective(Process record);

    int updateByPrimaryKey(Process record);

    List<Process> searchItemByPlanId(@Param("planId") String searchValue);
}