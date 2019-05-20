package com.erp.production.ssm.mapper;

import com.erp.production.ssm.bean.plan.Manufacture;
import com.erp.production.ssm.bean.plan.ManufactureExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManufactureMapper {

    //自己拓展的方法
    List<Manufacture> find();

    List<Manufacture> searchManufactureByManufactureSn(@Param("manufactureSn") String manufactureSn);

    List<Manufacture> searchManufactureByManufactureOrderId(@Param("orderId") String orderId);

    List<Manufacture> searchManufactureByManufactureTechnologyName(@Param("technologyName") String technologyName);

    //逆向工程生产的方法
    long countByExample(ManufactureExample example);

    int deleteByExample(ManufactureExample example);

    int deleteByPrimaryKey(String manufactureSn);

    int insert(Manufacture record);

    int insertSelective(Manufacture record);

    List<Manufacture> selectByExample(ManufactureExample example);

    Manufacture selectByPrimaryKey(String manufactureSn);

    int updateByExampleSelective(@Param("record") Manufacture record, @Param("example") ManufactureExample example);

    int updateByExample(@Param("record") Manufacture record, @Param("example") ManufactureExample example);

    int updateByPrimaryKeySelective(Manufacture record);

    int updateByPrimaryKey(Manufacture record);

    int deleteBatch(@Param("ids") String[] ids);
}