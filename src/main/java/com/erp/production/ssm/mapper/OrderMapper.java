package com.erp.production.ssm.mapper;

import com.erp.production.ssm.bean.plan.Order;
import com.erp.production.ssm.bean.plan.OrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {

    //自己扩展的方法
    List<Order> find();

    List<Order> searchOrderByOrderId(@Param("orderId") String orderId);

    List<Order> searchOrderByCustomName(@Param("customName") String customName);

    List<Order> searchOrderByProductName(@Param("productName") String productName);

    //逆向工程生产的方法
    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);


    int deleteBatch(@Param("ids") String[] ids);
}