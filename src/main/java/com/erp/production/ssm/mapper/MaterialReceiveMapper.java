package com.erp.production.ssm.mapper;

import com.erp.production.ssm.bean.MaterialReceive;
import com.erp.production.ssm.bean.MaterialReceiveExample;
import com.erp.production.ssm.bean.material.MaterialReceiveVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialReceiveMapper {

    //扩展的mapper接口方法
    List<MaterialReceiveVO> find();

    long countByExample(MaterialReceiveExample example);

    int deleteByExample(MaterialReceiveExample example);

    int deleteByPrimaryKey(String receiveId);

    int insert(MaterialReceive record);

    int insertSelective(MaterialReceive record);

    List<MaterialReceive> selectByExample(MaterialReceiveExample example);

    MaterialReceive selectByPrimaryKey(String receiveId);

    int updateByExampleSelective(@Param("record") MaterialReceive record, @Param("example") MaterialReceiveExample example);

    int updateByExample(@Param("record") MaterialReceive record, @Param("example") MaterialReceiveExample example);

    int updateByPrimaryKeySelective(MaterialReceive record);

    int updateByPrimaryKey(MaterialReceive record);
}