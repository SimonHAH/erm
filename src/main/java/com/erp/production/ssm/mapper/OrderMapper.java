package com.erp.production.ssm.mapper;

import com.erp.production.ssm.bean.plan.Order;

import java.util.List;

public interface OrderMapper {

    //自己扩展的方法
    List<Order> find();

    //逆向工程生产的方法
    int deleteByPrimaryKey(String orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);


}