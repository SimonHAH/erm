package com.erp.production.ssm.mapper;

import com.erp.production.ssm.bean.plan.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {

    //自己扩展的方法
    List<Order> find();

    List<Order> searchOrderByOrderId(@Param("orderId") String orderId);

    List<Order> searchOrderByCustomName(@Param("customName") String customName);

    List<Order> searchOrderByProductName(@Param("productName") String productName);

    //逆向工程生产的方法
    int deleteByPrimaryKey(String orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);



}