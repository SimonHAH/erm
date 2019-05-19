package com.erp.production.ssm.service.plan;

import com.erp.production.ssm.bean.common.CommonResult;
import com.erp.production.ssm.bean.plan.Order;
import com.erp.production.ssm.mapper.OrderMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public CommonResult getList(int page, int rows) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<Order> orders = orderMapper.find();
        //创建一个返回值对象
        CommonResult<Order> result = new CommonResult<>();
        result.setRows(orders);
        //取记录总条数
        //PageInfo<Task> pageInfo = new PageInfo<>(tasks);
        result.setTotal(orders.size());

        return result;
    }

    @Override
    public Order get(String orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        return order;
    }

    @Override
    public CommonResult searchOrderByOrderId(Integer page, Integer rows, String orderId) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<Order> orders = orderMapper.searchOrderByOrderId(orderId);
        //创建一个返回值对象
        CommonResult<Order> result = new CommonResult<>();
        result.setRows(orders);
        //取记录总条数
        //PageInfo<Task> pageInfo = new PageInfo<>(tasks);
        result.setTotal(orders.size());

        return result;
    }

    @Override
    public CommonResult searchOrderByCustomName(Integer page, Integer rows, String customName) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<Order> orders = orderMapper.searchOrderByCustomName(customName);
        //创建一个返回值对象
        CommonResult<Order> result = new CommonResult<>();
        result.setRows(orders);
        //取记录总条数
        //PageInfo<Task> pageInfo = new PageInfo<>(tasks);
        result.setTotal(orders.size());

        return result;
    }

    @Override
    public CommonResult searchOrderByProductName(Integer page, Integer rows, String productName) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<Order> orders = orderMapper.searchOrderByProductName(productName);
        //创建一个返回值对象
        CommonResult<Order> result = new CommonResult<>();
        result.setRows(orders);
        //取记录总条数
        //PageInfo<Task> pageInfo = new PageInfo<>(tasks);
        result.setTotal(orders.size());

        return result;
    }
}
