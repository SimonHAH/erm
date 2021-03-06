package com.erp.production.ssm.mapper;

import com.erp.production.ssm.bean.VO.FinalCountCheckVO;
import com.erp.production.ssm.bean.quality.FinalCountCheck;
import com.erp.production.ssm.bean.quality.FinalCountCheckExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FinalCountCheckMapper {

    List<FinalCountCheckVO> find(FinalCountCheck finalCountCheck);

    int updateNote(FinalCountCheck finalCountCheck);

    int deleteBatch(String[] ids);

    List<FinalCountCheckVO> searchFCountCheckByFCountCheckId(String fCountCheckId);

    List<FinalCountCheckVO> searchFCountCheckByOrderId(String orderId);



    long countByExample(FinalCountCheckExample example);

    int deleteByExample(FinalCountCheckExample example);

    int deleteByPrimaryKey(String fCountCheckId);

    int insert(FinalCountCheck record);

    int insertSelective(FinalCountCheck record);

    List<FinalCountCheck> selectByExample(FinalCountCheckExample example);

    FinalCountCheck selectByPrimaryKey(String fCountCheckId);

    int updateByExampleSelective(@Param("record") FinalCountCheck record, @Param("example") FinalCountCheckExample example);

    int updateByExample(@Param("record") FinalCountCheck record, @Param("example") FinalCountCheckExample example);

    int updateByPrimaryKeySelective(FinalCountCheck record);

    int updateByPrimaryKey(FinalCountCheck record);
}