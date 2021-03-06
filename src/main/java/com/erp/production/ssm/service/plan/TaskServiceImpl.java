package com.erp.production.ssm.service.plan;

import com.erp.production.ssm.bean.common.CommonResult;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.plan.Task;
import com.erp.production.ssm.bean.plan.TaskExample;
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
    public Task get(String id) {
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
        PageInfo<Task> pageInfo = new PageInfo<>(tasks);
        result.setTotal(pageInfo.getTotal());

        return result;
    }

    @Override
    public List<Task> find() {
        TaskExample taskExample = new TaskExample();
        return taskMapper.selectByExample(taskExample);
    }

    @Override
    public CustomResult updateAll(Task task) {
        int update = taskMapper.updateByPrimaryKey(task);
        if(update>0){
            return CustomResult.ok();
        }else{
            return CustomResult.build(101, "修改生产派工信息失败");
        }
    }

    @Override
    public CustomResult deleteBatch(String[] ids) {
        int delete = taskMapper.deleteBatch(ids);
        if(delete>0){
            return CustomResult.ok();
        }else{
            return null;
        }
    }

    @Override
    public CommonResult searchTaskByTaskId(Integer page, Integer rows, String taskId) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<Task> tasks = taskMapper.searchTaskByTaskId(taskId);
        //创建一个返回值对象
        CommonResult<Task> result = new CommonResult<>();
        result.setRows(tasks);
        //取记录总条数
        //PageInfo<Task> pageInfo = new PageInfo<>(tasks);
        result.setTotal(tasks.size());

        return result;
    }

    @Override
    public CommonResult searchTaskByTaskWorkId(Integer page, Integer rows, String workId) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<Task> tasks = taskMapper.searchTaskByTaskWorkId(workId);
        //创建一个返回值对象
        CommonResult<Task> result = new CommonResult<>();
        result.setRows(tasks);
        //取记录总条数
        //PageInfo<Task> pageInfo = new PageInfo<>(tasks);
        result.setTotal(tasks.size());

        return result;
    }

    @Override
    public CommonResult searchTaskByTaskManufactureSn(Integer page, Integer rows, String manufactureSn) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<Task> tasks = taskMapper.searchTaskByTaskManufactureSn(manufactureSn);
        //创建一个返回值对象
        CommonResult<Task> result = new CommonResult<>();
        result.setRows(tasks);
        //取记录总条数
        //PageInfo<Task> pageInfo = new PageInfo<>(tasks);
        result.setTotal(tasks.size());

        return result;
    }

    @Override
    public CustomResult insert(Task task) {
        int i = taskMapper.insert(task);
        if(i>0){
            return CustomResult.ok();
        }else{
            return CustomResult.build(101, "新增生产派工信息失败");
        }
    }


}
