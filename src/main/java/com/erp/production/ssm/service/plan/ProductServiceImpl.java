package com.erp.production.ssm.service.plan;

import com.erp.production.ssm.bean.common.CommonResult;
import com.erp.production.ssm.bean.plan.Product;
import com.erp.production.ssm.bean.plan.ProductExample;
import com.erp.production.ssm.mapper.ProductMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public CommonResult getList(int page, int rows) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<Product> products = productMapper.find();
        //创建一个返回值对象
        CommonResult<Product> result = new CommonResult<>();
        result.setRows(products);
        //取记录总条数
        //PageInfo<Task> pageInfo = new PageInfo<>(tasks);
        result.setTotal(products.size());

        return result;
    }

    @Override
    public Product get(String productId) {
        Product product = productMapper.selectByPrimaryKey(productId);
        return product;
    }

    @Override
    public List<Product> find() {
        ProductExample productExample = new ProductExample();
        return productMapper.selectByExample(productExample);
    }

    @Override
    public CommonResult searchProductByProductId(Integer page, Integer rows, String productId) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<Product> products = productMapper.searchProductByProductId(productId);
        //创建一个返回值对象
        CommonResult<Product> result = new CommonResult<>();
        result.setRows(products);
        //取记录总条数
        //PageInfo<Task> pageInfo = new PageInfo<>(tasks);
        result.setTotal(products.size());

        return result;
    }

    @Override
    public CommonResult searchProductByProductName(Integer page, Integer rows, String productName) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<Product> products = productMapper.searchProductByProductName(productName);
        //创建一个返回值对象
        CommonResult<Product> result = new CommonResult<>();
        result.setRows(products);
        //取记录总条数
        //PageInfo<Task> pageInfo = new PageInfo<>(tasks);
        result.setTotal(products.size());

        return result;
    }

    @Override
    public CommonResult searchProductByProductType(Integer page, Integer rows, String productType) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<Product> products = productMapper.searchProductByProductType(productType);
        //创建一个返回值对象
        CommonResult<Product> result = new CommonResult<>();
        result.setRows(products);
        //取记录总条数
        //PageInfo<Task> pageInfo = new PageInfo<>(tasks);
        result.setTotal(products.size());

        return result;
    }


}