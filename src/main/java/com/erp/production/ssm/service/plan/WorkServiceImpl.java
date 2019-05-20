package com.erp.production.ssm.service.plan;

import com.erp.production.ssm.bean.common.CommonResult;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.plan.Work;
import com.erp.production.ssm.bean.plan.WorkExample;
import com.erp.production.ssm.mapper.WorkMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService{
    @Autowired
    WorkMapper workMapper;

    @Override
    public CommonResult getList(int page, int rows) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<Work> works = workMapper.find();
        //创建一个返回值对象
        CommonResult<Work> result = new CommonResult<>();
        result.setRows(works);
        //取记录总条数
        PageInfo<Work> pageInfo = new PageInfo<>(works);
        result.setTotal(pageInfo.getTotal());

        return result;
    }

    @Override
    public Work get(String workId) {
        Work work = workMapper.selectByPrimaryKey(workId);
        return work;
    }

    @Override
    public List<Work> find() {
        WorkExample workExample = new WorkExample();
        return workMapper.selectByExample(workExample);
    }

    @Override
    public CustomResult insert(Work work) {
        int insert = workMapper.insert(work);
        if(insert>0){
            return CustomResult.ok();
        }else{
            return CustomResult.build(101, "新增生成作业信息失败");
        }
    }

    @Override
    public CustomResult updateAll(Work work) {
        int update = workMapper.updateByPrimaryKey(work);
        if(update>0){
            return CustomResult.ok();
        }else{
            return CustomResult.build(101, "修改作业信息失败");
        }
    }

    @Override
    public CustomResult deleteBatch(String[] ids) {
        int delete = workMapper.deleteBatch(ids);
        if(delete>0){
            return CustomResult.ok();
        }else{
            return null;
        }
    }


    @Override
    public CommonResult searchWorkByWorkId(Integer page, Integer rows, String workId) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<Work> works = workMapper.searchWorkByWorkId(workId);
        //创建一个返回值对象
        CommonResult<Work> result = new CommonResult<>();
        result.setRows(works);
        //取记录总条数
        //PageInfo<Task> pageInfo = new PageInfo<>(tasks);
        result.setTotal(works.size());

        return result;
    }

    @Override
    public CommonResult searchWorkByWorkProductName(Integer page, Integer rows, String productName) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<Work> works = workMapper.searchWorkByWorkProductName(productName);
        //创建一个返回值对象
        CommonResult<Work> result = new CommonResult<>();
        result.setRows(works);
        //取记录总条数
        //PageInfo<Task> pageInfo = new PageInfo<>(tasks);
        result.setTotal(works.size());

        return result;
    }

    @Override
    public CommonResult searchWorkByWorkDeviceId(Integer page, Integer rows, String deviceId) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<Work> works = workMapper.searchWorkByWorkDeviceId(deviceId);
        //创建一个返回值对象
        CommonResult<Work> result = new CommonResult<>();
        result.setRows(works);
        //取记录总条数
        //PageInfo<Task> pageInfo = new PageInfo<>(tasks);
        result.setTotal(works.size());

        return result;
    }

    @Override
    public CommonResult searchWorkByWorkProcessId(Integer page, Integer rows, String processId) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<Work> works = workMapper.searchWorkByWorkProcessId(processId);
        //创建一个返回值对象
        CommonResult<Work> result = new CommonResult<>();
        result.setRows(works);
        //取记录总条数
        //PageInfo<Task> pageInfo = new PageInfo<>(tasks);
        result.setTotal(works.size());

        return result;
    }


}
