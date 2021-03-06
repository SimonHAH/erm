package com.erp.production.ssm.controller.plan;

import com.erp.production.ssm.bean.common.CommonResult;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.plan.Product;
import com.erp.production.ssm.service.plan.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

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

    @RequestMapping("/add_judge")
    private String add_judge(){
        return "product_add";
    }

    @RequestMapping("/edit")
    private String edit(){
        return "product_edit";
    }

    @RequestMapping("/edit_judge")
    @ResponseBody
    private String editJudge(){
        return null;
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    private String deleteJudge(){
        return null;
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

    @RequestMapping("/get_data")
    @ResponseBody
    public List<Product> getData() {
        return productService.find();
    }

    @RequestMapping(value="/insert", method= RequestMethod.POST)
    @ResponseBody
    private CustomResult insert(@Valid Product product, BindingResult bindingResult) throws Exception {
        CustomResult result;
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        if(productService.get(product.getProductId()) != null){
            result = new CustomResult(0, "该产品编号已经存在，请更换产品编号！", null);
        }else{
            result = productService.insert(product);
        }
        return result;
    }

    @RequestMapping(value="/update_all")
    @ResponseBody
    private CustomResult updateAll(@Valid Product product, BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        return productService.updateAll(product);
    }


    @RequestMapping(value="/delete_batch")
    @ResponseBody
    private CustomResult deleteBatch(String[] ids) throws Exception {
        CustomResult result = productService.deleteBatch(ids);
        return result;
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
