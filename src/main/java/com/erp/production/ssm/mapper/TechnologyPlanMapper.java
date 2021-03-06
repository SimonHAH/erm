package com.erp.production.ssm.mapper;

import com.erp.production.ssm.bean.VO.TechnologyPlanVO;
import com.erp.production.ssm.bean.technology.TechnologyPlan;
import com.erp.production.ssm.bean.technology.TechnologyPlanExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyPlanMapper {
    long countByExample(TechnologyPlanExample example);

    int deleteByExample(TechnologyPlanExample example);

    int deleteByPrimaryKey(String technologyPlanId);

    int insert(TechnologyPlan record);

    int insertSelective(TechnologyPlan record);

    List<TechnologyPlan> selectByExample(TechnologyPlanExample example);

    TechnologyPlan selectByPrimaryKey(String technologyPlanId);

    int updateByExampleSelective(@Param("record") TechnologyPlan record, @Param("example") TechnologyPlanExample example);

    int updateByExample(@Param("record") TechnologyPlan record, @Param("example") TechnologyPlanExample example);

    int updateByPrimaryKeySelective(TechnologyPlan record);

    int updateByPrimaryKey(TechnologyPlan record);

    List<TechnologyPlanVO> find();

    TechnologyPlanVO searchItemById(@Param("id") String searchValue);

    List<TechnologyPlanVO> searchItemByName(@Param("name") String searchValue);

    TechnologyPlan getPlanById(String planId);
}