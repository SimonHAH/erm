package com.erp.production.ssm.controller.plan;

import com.erp.production.ssm.bean.common.CommonResult;
import com.erp.production.ssm.bean.plan.Product;
import com.erp.production.ssm.service.plan.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/find")
    public String find(){
        return "product_list";
    }

    @RequestMapping("/add")
    private String add(){
        return "product_add";
    }

    @RequestMapping("/edit")
    private String edit(){
        return "product_edit";
    }

    @RequestMapping("/list")
    @ResponseBody
    private CommonResult showList(Integer page,Integer rows){
        CommonResult result = productService.getList(page, rows);
        return result;
    }

    @RequestMapping("/get/{productId}")
    @ResponseBody
    public Product getItemById(@PathVariable String productId){
        Product product = productService.get(productId);
        return product;
    }


    //根据产品id查找
    @RequestMapping("/search_product_by_productId")
    @ResponseBody
    public CommonResult searchProductByProductId(Integer page, Integer rows, String searchValue) {
        CommonResult result = productService.searchProductByProductId(page, rows, searchValue);
        return result;
    }

    //根据产品名称查找
    @RequestMapping("/search_product_by_productName")
    @ResponseBody
    public CommonResult searchProductByProductName(Integer page, Integer rows, String searchValue) {
        CommonResult result = productService.searchProductByProductName(page, rows, searchValue);
        return result;
    }

    //根据产品类型查找
    @RequestMapping("/search_product_by_productType")
    @ResponseBody
    public CommonResult searchProductByProductType(Integer page, Integer rows, String searchValue) {
        CommonResult result = productService.searchProductByProductType(page, rows, searchValue);
        return result;
    }
}
