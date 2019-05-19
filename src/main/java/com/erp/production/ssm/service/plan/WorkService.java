package com.erp.production.ssm.service.plan;

import com.erp.production.ssm.bean.common.CommonResult;
import com.erp.production.ssm.bean.plan.Work;


public interface WorkService {

    CommonResult getList(int page, int rows);

    Work get(String workId);

    CommonResult searchWorkByWorkId(Integer page, Integer rows, String workId);

    CommonResult searchWorkByWorkProductName(Integer page, Integer rows, String productName);


    CommonResult searchWorkByWorkDeviceId(Integer page, Integer rows, String deviceId);

    CommonResult searchWorkByWorkProcessId(Integer page, Integer rows, String processId);
}
