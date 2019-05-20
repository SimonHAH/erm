package com.erp.production.ssm.mapper;

import com.erp.production.ssm.bean.ProcessMeasureCheck;
import com.erp.production.ssm.bean.ProcessMeasureCheckExample;
import com.erp.production.ssm.bean.VO.ProcessMeasureCheckVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessMeasureCheckMapper {
    //扩展的mapper接口方法
    int updateNote(ProcessMeasureCheck processMeasureCheck);

    int deleteBatch(String[] ids);

    List<ProcessMeasureCheckVO> searchPMeasureCheckByPMeasureCheckId(String processMeasureCheckId);

    List<ProcessMeasureCheckVO> find(ProcessMeasureCheck processMeasureCheck);

    //逆向工程生成的mapper接口
    int countByExample(ProcessMeasureCheckExample example);

    int deleteByExample(ProcessMeasureCheckExample example);

    int deleteByPrimaryKey(String pMeasureCheckId);

    int insert(ProcessMeasureCheck record);

    int insertSelective(ProcessMeasureCheck record);

    List<ProcessMeasureCheck> selectByExample(ProcessMeasureCheckExample example);

    ProcessMeasureCheck selectByPrimaryKey(String pMeasureCheckId);

    int updateByExampleSelective(@Param("record") ProcessMeasureCheck record, @Param("example") ProcessMeasureCheckExample example);

    int updateByExample(@Param("record") ProcessMeasureCheck record, @Param("example") ProcessMeasureCheckExample example);

    int updateByPrimaryKeySelective(ProcessMeasureCheck record);

    int updateByPrimaryKey(ProcessMeasureCheck record);
}