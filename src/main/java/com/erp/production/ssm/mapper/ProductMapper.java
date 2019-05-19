package com.erp.production.ssm.mapper;

import com.erp.production.ssm.bean.plan.Product;
import com.erp.production.ssm.bean.plan.ProductExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {

    //自己扩展的方法
    List<Product> find();

    List<Product> searchProductByProductId(@Param("productId") String productId);

    List<Product> searchProductByProductName(@Param("productName") String productName);

    List<Product> searchProductByProductType(@Param("productType") String productType);

    //逆向工程的方法
    long countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(String productId);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(String productId);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);


}