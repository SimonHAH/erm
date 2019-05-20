package com.erp.production.ssm.service.plan;

import com.erp.production.ssm.bean.common.CommonResult;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.plan.Custom;

import java.util.List;


public interface CustomService {

    Custom get(String customId);

    CommonResult getList(int page, int rows);

    CommonResult searchCustomByCustomId(Integer page, Integer rows, String customId);

    CommonResult searchCustomByCustomName(Integer page, Integer rows, String customName);

    List<Custom> find();

    CustomResult insert(Custom custom);

    CustomResult updateAll(Custom custom);

    CustomResult deleteBatch(String[] ids);
}
