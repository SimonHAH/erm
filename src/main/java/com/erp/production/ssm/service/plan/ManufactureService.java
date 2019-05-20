package com.erp.production.ssm.service.plan;

import com.erp.production.ssm.bean.common.CommonResult;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.plan.Manufacture;

import java.util.List;

public interface ManufactureService {

    Manufacture queryManufactureById(String id);
    CommonResult getList(int page, int rows);

    Manufacture get(String manufactureSn);

    CommonResult searchManufactureByManufactureSn(Integer page, Integer rows, String ManufactureSn);

    CommonResult searchManufactureByManufactureOrderId(Integer page, Integer rows, String orderId);

    CommonResult searchManufactureByManufactureTechnologyName(Integer page, Integer rows, String technologyName);

    List<Manufacture> find();

    CustomResult insert(Manufacture manufacture);
}
