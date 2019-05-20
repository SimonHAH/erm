package com.erp.production.ssm.mapper;

import com.erp.production.ssm.bean.plan.Custom;
import com.erp.production.ssm.bean.plan.CustomExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomMapper {

    //自己扩展的方法
    List<Custom> find();

    List<Custom> searchCustomByCustomId(@Param("customId") String customId);

    List<Custom> searchCustomByCustomName(@Param("customName") String customName);

    //逆向工程生产的方法
    long countByExample(CustomExample example);

    int deleteByExample(CustomExample example);

    int deleteByPrimaryKey(String customId);

    int insert(Custom record);

    int insertSelective(Custom record);

    List<Custom> selectByExample(CustomExample example);

    Custom selectByPrimaryKey(String customId);

    int updateByExampleSelective(@Param("record") Custom record, @Param("example") CustomExample example);

    int updateByExample(@Param("record") Custom record, @Param("example") CustomExample example);

    int updateByPrimaryKeySelective(Custom record);

    int updateByPrimaryKey(Custom record);

    int deleteBatch(@Param("ids") String[] ids);

}