package com.erp.production.ssm.service.plan;

import com.erp.production.ssm.bean.common.CommonResult;
import com.erp.production.ssm.bean.plan.Product;

import java.util.List;


public interface ProductService {

    CommonResult getList(int page, int rows);

    Product get(String productId);

    CommonResult searchProductByProductId(Integer page, Integer rows, String productId);

    CommonResult searchProductByProductName(Integer page, Integer rows, String productName);

    CommonResult searchProductByProductType(Integer page, Integer rows, String productType);

    List<Product> find();

}
