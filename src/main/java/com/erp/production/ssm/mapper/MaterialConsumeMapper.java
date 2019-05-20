package com.erp.production.ssm.mapper;

import com.erp.production.ssm.bean.MaterialConsume;
import com.erp.production.ssm.bean.MaterialConsumeExample;
import com.erp.production.ssm.bean.material.MaterialConsumeVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialConsumeMapper {
    //扩展的接口
    List<MaterialConsumeVO> find(MaterialConsumeVO materialConsume);

    long countByExample(MaterialConsumeExample example);

    int deleteByExample(MaterialConsumeExample example);

    int deleteByPrimaryKey(String consumeId);

    int insert(MaterialConsume record);

    int insertSelective(MaterialConsume record);

    List<MaterialConsume> selectByExample(MaterialConsumeExample example);

    MaterialConsume selectByPrimaryKey(String consumeId);

    int updateByExampleSelective(@Param("record") MaterialConsume record, @Param("example") MaterialConsumeExample example);

    int updateByExample(@Param("record") MaterialConsume record, @Param("example") MaterialConsumeExample example);

    int updateByPrimaryKeySelective(MaterialConsume record);

    int updateByPrimaryKey(MaterialConsume record);

    List<MaterialConsumeVO> searchMaterialConsumeByMaterialId(String searchValue);

    List<MaterialConsumeVO> searchMaterialConsumeByConsumeId(String searchValue);

    List<MaterialConsumeVO> searchMaterialConsumeByWorkId(String searchValue);

    int updateNote(MaterialConsume materialConsume);

    int deleteBatch(String[] ids);
}