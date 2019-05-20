package com.erp.production.ssm.service.plan;

import com.erp.production.ssm.bean.common.CommonResult;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.plan.Order;
import com.erp.production.ssm.bean.plan.OrderExample;
import com.erp.production.ssm.mapper.OrderMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<Order> find() {
        OrderExample orderExample = new OrderExample();
        return orderMapper.selectByExample(orderExample);
    }

    @Override
    public CustomResult insert(Order order) {
        int insert = orderMapper.insert(order);
        if(insert>0){
            return CustomResult.ok();
        }else{
            return CustomResult.build(101, "新增订单信息失败");
        }
    }

    @Override
    public CustomResult updateAll(Order order) {
        int update = orderMapper.updateByPrimaryKey(order);
        if(update>0){
            return CustomResult.ok();
        }else{
            return CustomResult.build(101, "修改订单信息失败");
        }
    }

    @Override
    public CustomResult deleteBatch(String[] ids) {
        int delete = orderMapper.deleteBatch(ids);
        if(delete>0){
            return CustomResult.ok();
        }else{
            return null;
        }
    }

    @Override
    public CommonResult getList(int page, int rows) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<Order> orders = orderMapper.find();
        //创建一个返回值对象
        CommonResult<Order> result = new CommonResult<>();
        result.setRows(orders);
        //取记录总条数
        PageInfo<Order> pageInfo = new PageInfo<>(orders);
        result.setTotal(pageInfo.getTotal());

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
