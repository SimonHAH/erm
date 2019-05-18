package com.erp.production.ssm.service.plan;

import com.erp.production.ssm.bean.common.CommonResult;
import com.erp.production.ssm.bean.plan.Work;


public interface WorkService {

    CommonResult getList(int page, int rows);

    Work get(String workId);
}
