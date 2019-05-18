package com.erp.production.ssm.service.plan;

import com.erp.production.ssm.bean.common.CommonResult;
import com.erp.production.ssm.bean.plan.Product;


public interface ProductService {

    CommonResult getList(int page, int rows);

    Product get(String productId);
}
