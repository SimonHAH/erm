package com.erp.production.ssm.mapper;

import com.erp.production.ssm.bean.VO.FinalMeasuretCheckVO;
import com.erp.production.ssm.bean.quality.FinalMeasuretCheck;
import com.erp.production.ssm.bean.quality.FinalMeasuretCheckExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FinalMeasuretCheckMapper {

    List<FinalMeasuretCheckVO> find(FinalMeasuretCheck finalMeasuretCheck);

    int updateNote(FinalMeasuretCheck finalMeasuretCheck);

    int deleteBatch(String[] ids);

    List<FinalMeasuretCheckVO> searchFMeasureCheckByOrderId(String orderId);

    List<FinalMeasuretCheckVO> searchFMeasureCheckByFMeasureCheckId(String finalMeasuretCheckId);



    long countByExample(FinalMeasuretCheckExample example);

    int deleteByExample(FinalMeasuretCheckExample example);

    int deleteByPrimaryKey(String fMeasureCheckId);

    int insert(FinalMeasuretCheck record);

    int insertSelective(FinalMeasuretCheck record);

    List<FinalMeasuretCheck> selectByExample(FinalMeasuretCheckExample example);

    FinalMeasuretCheck selectByPrimaryKey(String fMeasureCheckId);

    int updateByExampleSelective(@Param("record") FinalMeasuretCheck record, @Param("example") FinalMeasuretCheckExample example);

    int updateByExample(@Param("record") FinalMeasuretCheck record, @Param("example") FinalMeasuretCheckExample example);

    int updateByPrimaryKeySelective(FinalMeasuretCheck record);

    int updateByPrimaryKey(FinalMeasuretCheck record);
}