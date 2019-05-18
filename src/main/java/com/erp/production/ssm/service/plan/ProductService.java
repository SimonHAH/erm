package com.erp.production.ssm.service.plan;

import com.erp.production.ssm.bean.common.CommonResult;


public interface ProductService {

    CommonResult getList(int page, int rows);
}
