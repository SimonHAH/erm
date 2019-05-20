package com.erp.production.ssm.mapper;

import com.erp.production.ssm.bean.VO.UnqualifyApplyVO;
import com.erp.production.ssm.bean.quality.UnqualifyApply;
import com.erp.production.ssm.bean.quality.UnqualifyApplyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UnqualifyApplyMapper {

    List<UnqualifyApplyVO> find(UnqualifyApply unqualifyApply);

    int updateNote(UnqualifyApply unqualifyApply);

    int deleteBatch(String[] ids);

    List<UnqualifyApplyVO> searchUnqualifyByUnqualifyId(String orderId);

    List<UnqualifyApplyVO> searchUnqualifyByProductName(String productName);


    //逆向工程生成
    long countByExample(UnqualifyApplyExample example);

    int deleteByExample(UnqualifyApplyExample example);

    int deleteByPrimaryKey(String unqualifyApplyId);

    int insert(UnqualifyApply record);

    int insertSelective(UnqualifyApply record);

    List<UnqualifyApply> selectByExample(UnqualifyApplyExample example);

    UnqualifyApply selectByPrimaryKey(String unqualifyApplyId);

    int updateByExampleSelective(@Param("record") UnqualifyApply record, @Param("example") UnqualifyApplyExample example);

    int updateByExample(@Param("record") UnqualifyApply record, @Param("example") UnqualifyApplyExample example);

    int updateByPrimaryKeySelective(UnqualifyApply record);

    int updateByPrimaryKey(UnqualifyApply record);
}