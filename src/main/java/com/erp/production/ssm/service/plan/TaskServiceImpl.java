package com.erp.production.ssm.service.plan;

import com.erp.production.ssm.bean.plan.Task;
import com.erp.production.ssm.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskMapper taskMapper;

    @Override
    public Task queryTaskById(String id) {
        Task task = taskMapper.selectByPrimaryKey(id);
        return task;
    }
}
