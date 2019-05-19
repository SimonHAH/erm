package com.erp.production.ssm.service.plan;

import com.erp.production.ssm.bean.common.CommonResult;
import com.erp.production.ssm.bean.plan.Order;


public interface OrderService {

    CommonResult getList(int page, int rows);
    Order get(String orderId);
}
