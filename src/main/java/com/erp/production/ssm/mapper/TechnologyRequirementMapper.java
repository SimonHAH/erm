package com.erp.production.ssm.mapper;

import com.erp.production.ssm.bean.VO.TechnologyRequirementVO;
import com.erp.production.ssm.bean.technology.TechnologyRequirement;
import com.erp.production.ssm.bean.technology.TechnologyRequirementExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyRequirementMapper {
    long countByExample(TechnologyRequirementExample example);

    int deleteByExample(TechnologyRequirementExample example);

    int deleteByPrimaryKey(String technologyRequirementId);

    int insert(TechnologyRequirement record);

    int insertSelective(TechnologyRequirement record);

    List<TechnologyRequirement> selectByExample(TechnologyRequirementExample example);

    TechnologyRequirementVO selectByPrimaryKey(String technologyRequirementId);

    int updateByExampleSelective(@Param("record") TechnologyRequirement record, @Param("example") TechnologyRequirementExample example);

    int updateByExample(@Param("record") TechnologyRequirement record, @Param("example") TechnologyRequirementExample example);

    int updateByPrimaryKeySelective(TechnologyRequirement record);

    int updateByPrimaryKey(TechnologyRequirement record);

    List<TechnologyRequirementVO> find();

    TechnologyRequirementVO searchItemById(@Param("id") String searchValue);

    List<TechnologyRequirementVO> searchItemByName(@Param("technologyName") String searchValue);
}