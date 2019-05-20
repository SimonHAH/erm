package com.erp.production.ssm.mapper;

import com.erp.production.ssm.bean.Material;
import com.erp.production.ssm.bean.MaterialExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialMapper {
    //扩展接口

    List<Material> searchMaterialByMaterialId(String materialId);

    List<Material> searchMaterialByMaterialType(String materialType);

    long countByExample(MaterialExample example);

    int deleteByExample(MaterialExample example);

    int deleteByPrimaryKey(String materialId);

    int insert(Material record);

    int insertSelective(Material record);

    List<Material> selectByExample(MaterialExample example);

    Material selectByPrimaryKey(String materialId);

    int updateByExampleSelective(@Param("record") Material record, @Param("example") MaterialExample example);

    int updateByExample(@Param("record") Material record, @Param("example") MaterialExample example);

    int updateByPrimaryKeySelective(Material record);

    int updateByPrimaryKey(Material record);
}