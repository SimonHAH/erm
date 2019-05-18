package com.erp.production.ssm.service.plan;

import com.erp.production.ssm.bean.common.CommonResult;
import com.erp.production.ssm.bean.plan.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface TaskService {

    Task queryTaskById(String id);

    CommonResult getList(int page, int rows);
}
