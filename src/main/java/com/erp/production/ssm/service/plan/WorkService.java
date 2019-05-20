package com.erp.production.ssm.service.plan;

import com.erp.production.ssm.bean.common.CommonResult;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.plan.Work;

import java.util.List;


public interface WorkService {

    CommonResult getList(int page, int rows);

    Work get(String workId);

    CommonResult searchWorkByWorkId(Integer page, Integer rows, String workId);

    CommonResult searchWorkByWorkProductName(Integer page, Integer rows, String productName);


    CommonResult searchWorkByWorkDeviceId(Integer page, Integer rows, String deviceId);

    CommonResult searchWorkByWorkProcessId(Integer page, Integer rows, String processId);

    List<Work> find();

    CustomResult insert(Work work);

    CustomResult updateAll(Work work);

    CustomResult deleteBatch(String[] ids);
}
