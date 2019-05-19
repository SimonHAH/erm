package com.erp.production.ssm.controller.plan;

import com.erp.production.ssm.bean.common.CommonResult;
import com.erp.production.ssm.bean.plan.Order;
import com.erp.production.ssm.service.plan.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/find")
    public String find(){
        return "order_list";
    }

    @RequestMapping("/add")
    private String add(){
        return "order_add";
    }

    @RequestMapping("/edit")
    private String edit(){
        return "order_edit";
    }

    @RequestMapping("/list")
    @ResponseBody
    private CommonResult showList(Integer page,Integer rows){
        CommonResult result = orderService.getList(page, rows);
        return result;
    }

    @RequestMapping("/get/{orderId}")
    @ResponseBody
    public Order getItemById(@PathVariable String orderId){
        Order order = orderService.get(orderId);
        return order;
    }

    //根据订单id查找
    @RequestMapping("/search_order_by_orderId")
    @ResponseBody
    public CommonResult searchOrderByOrderId(Integer page, Integer rows, String searchValue){
        CommonResult result = orderService.searchOrderByOrderId(page, rows, searchValue);
        return result;
    }

    //根据客户名称查找
    @RequestMapping("/search_order_by_orderCustom")
    @ResponseBody
    public CommonResult searchOrderByOrderCustom(Integer page, Integer rows, String searchValue){
        CommonResult result = orderService.searchOrderByCustomName(page, rows, searchValue);
        return result;
    }

    //根据产品名称查找
    @RequestMapping("/search_order_by_orderProduct")
    @ResponseBody
    public CommonResult searchOrderByProductName(Integer page, Integer rows, String searchValue){
        CommonResult result = orderService.searchOrderByProductName(page, rows, searchValue);
        return result;
    }

}
