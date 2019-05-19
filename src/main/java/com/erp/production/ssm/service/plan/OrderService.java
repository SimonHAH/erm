package com.erp.production.ssm.service.plan;

import com.erp.production.ssm.bean.common.CommonResult;
import com.erp.production.ssm.bean.plan.Order;

import java.util.List;


public interface OrderService {

    CommonResult getList(int page, int rows);
    Order get(String orderId);

    CommonResult searchOrderByOrderId(Integer page, Integer rows, String orderId);

    CommonResult searchOrderByCustomName(Integer page, Integer rows, String customName);

    CommonResult searchOrderByProductName(Integer page, Integer rows, String productName);

    List<Order> find();
}
