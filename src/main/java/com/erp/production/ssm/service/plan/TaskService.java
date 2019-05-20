package com.erp.production.ssm.service.plan;

import com.erp.production.ssm.bean.common.CommonResult;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.plan.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TaskService {

    Task get(String id);

    CommonResult getList(int page, int rows);

    CommonResult searchTaskByTaskId(Integer page, Integer rows, String taskId);

    CommonResult searchTaskByTaskWorkId(Integer page, Integer rows, String workId);

    CommonResult searchTaskByTaskManufactureSn(Integer page, Integer rows, String manufactureSn);

    CustomResult insert(Task task);

    List<Task> find();

    CustomResult updateAll(Task task);

    CustomResult deleteBatch(String[] ids);
}
