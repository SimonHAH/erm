package com.erp.production.ssm.service.plan;

import com.erp.production.ssm.bean.common.CommonResult;
import com.erp.production.ssm.bean.plan.Custom;

import java.util.List;


public interface CustomService {

    CommonResult getList(int page, int rows);

    CommonResult searchCustomByCustomId(Integer page, Integer rows, String customId);

    CommonResult searchCustomByCustomName(Integer page, Integer rows, String customName);

    List<Custom> find();
}
