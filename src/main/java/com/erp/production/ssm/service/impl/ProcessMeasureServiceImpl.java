package com.erp.production.ssm.service.impl;

import com.erp.production.ssm.bean.ProcessMeasureCheck;
import com.erp.production.ssm.bean.VO.ProcessMeasureCheckVO;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.mapper.ProcessMeasureCheckMapper;
import com.erp.production.ssm.service.ProcessMeasureService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Turtle
 * @title: ProcessMeasureServiceImpl
 * @projectName production_ms
 * @description: TODO
 * @date 2019/5/20 12:01
 */
@Service
public class ProcessMeasureServiceImpl implements ProcessMeasureService {
    @Autowired
    ProcessMeasureCheckMapper processMeasureCheckMapper;

    @Override
    public PageResult getList(int page, int rows, ProcessMeasureCheck processMeasureCheck) throws Exception{

        //分页处理
        PageHelper.startPage(page, rows);
        List<ProcessMeasureCheckVO> list = processMeasureCheckMapper.find(processMeasureCheck);

        //创建一个返回值对象
        PageResult result = new PageResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<ProcessMeasureCheckVO> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public CustomResult deleteBatch(String[] ids) throws Exception{
        int i = processMeasureCheckMapper.deleteBatch(ids);
        if(i>0){
            return CustomResult.ok();
        }else{
            return null;
        }
    }

    @Override
    public CustomResult insert(ProcessMeasureCheck processMeasureCheck) throws Exception{
        int i = processMeasureCheckMapper.insert(processMeasureCheck);
        if(i>0){
            return CustomResult.ok();
        }else{
            return CustomResult.build(101, "新增工序计量质检信息失败");
        }
    }

    @Override
    public CustomResult updateAll(ProcessMeasureCheck processMeasureCheck) throws Exception{
        int i = processMeasureCheckMapper.updateByPrimaryKey(processMeasureCheck);
        if(i>0){
            return CustomResult.ok();
        }else{
            return CustomResult.build(101, "修改工序计量质检信息失败");
        }
    }

    @Override
    public CustomResult updateNote(ProcessMeasureCheck processMeasureCheck) throws Exception{

        int i = processMeasureCheckMapper.updateNote(processMeasureCheck);
        if(i>0){
            return CustomResult.ok();
        }else{
            return CustomResult.build(101, "修改工序计量质检备注失败");
        }
    }

    @Override
    public PageResult searchPMeasureCheckByPMeasureCheckId(int page,int rows, String pMeasureCheckId) throws Exception{
        //分页处理
        PageHelper.startPage(page, rows);
        List<ProcessMeasureCheckVO> list = processMeasureCheckMapper.searchPMeasureCheckByPMeasureCheckId(pMeasureCheckId);
        //创建一个返回值对象
        PageResult result = new PageResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<ProcessMeasureCheckVO> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}
