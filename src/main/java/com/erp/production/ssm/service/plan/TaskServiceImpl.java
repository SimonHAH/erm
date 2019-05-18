package com.erp.production.ssm.service.plan;

import com.erp.production.ssm.bean.common.CommonResult;
import com.erp.production.ssm.bean.plan.Task;
import com.erp.production.ssm.mapper.TaskMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskMapper taskMapper;

    @Override
    public Task queryTaskById(String id) {
        Task task = taskMapper.selectByPrimaryKey(id);
        return task;
    }

    @Override
    public CommonResult getList(int page, int rows) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<Task> tasks = taskMapper.find();
        //创建一个返回值对象
        CommonResult<Task> result = new CommonResult<>();
        result.setRows(tasks);
        //取记录总条数
        //PageInfo<Task> pageInfo = new PageInfo<>(tasks);
        result.setTotal(tasks.size());

        return result;
    }
}
