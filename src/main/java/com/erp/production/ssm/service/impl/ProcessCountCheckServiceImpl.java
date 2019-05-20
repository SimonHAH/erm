package com.erp.production.ssm.service.impl;

import com.erp.production.ssm.bean.ProcessCountCheck;
import com.erp.production.ssm.bean.VO.ProcessCountCheckVO;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.mapper.ProcessCountCheckMapper;
import com.erp.production.ssm.service.ProcessCountCheckService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Turtle
 * @title: ProcessCountCheckServiceImpl
 * @projectName production_ms
 * @description: TODO
 * @date 2019/5/20 15:00
 */
@Service
public class ProcessCountCheckServiceImpl implements ProcessCountCheckService {
    @Autowired
    ProcessCountCheckMapper processCountCheckMapper;

    @Override
    public PageResult getList(int page, int rows, ProcessCountCheck processCountCheck) throws Exception{
        //分页处理
        PageHelper.startPage(page, rows);
        List<ProcessCountCheckVO> list = processCountCheckMapper.find(processCountCheck);
        //创建一个返回值对象
        PageResult result = new PageResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<ProcessCountCheckVO> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public CustomResult deleteBatch(String[] ids) throws Exception{
        int i = processCountCheckMapper.deleteBatch(ids);
        if(i>0){
            return CustomResult.ok();
        }else{
            return null;
        }
    }

    @Override
    public CustomResult insert(ProcessCountCheck processCountCheck) throws Exception{
        int i = processCountCheckMapper.insert(processCountCheck);
        if(i>0){
            return CustomResult.ok();
        }else{
            return CustomResult.build(101, "新增工序计数质检信息失败");
        }
    }

    @Override
    public CustomResult updateAll(ProcessCountCheck processCountCheck) throws Exception{
        int i = processCountCheckMapper.updateByPrimaryKey(processCountCheck);
        if(i>0){
            return CustomResult.ok();
        }else{
            return CustomResult.build(101, "修改工序计数质检信息失败");
        }
    }

    @Override
    public CustomResult updateNote(ProcessCountCheck processCountCheck) throws Exception{

        int i = processCountCheckMapper.updateNote(processCountCheck);
        if(i>0){
            return CustomResult.ok();
        }else{
            return CustomResult.build(101, "修改工序计数质检备注失败");
        }
    }

    @Override
    public PageResult searchPCountCheckByPCountCheckId(int page,
                                                             int rows, String pCountCheckId) throws Exception{
        //分页处理
        PageHelper.startPage(page, rows);
        List<ProcessCountCheckVO> list = processCountCheckMapper.searchPCountCheckByPCountCheckId(pCountCheckId);
        //创建一个返回值对象
        PageResult result = new PageResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<ProcessCountCheckVO> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}
