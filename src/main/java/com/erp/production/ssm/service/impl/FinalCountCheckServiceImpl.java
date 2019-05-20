package com.erp.production.ssm.service.impl;

import com.erp.production.ssm.bean.VO.FinalCountCheckVO;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.bean.quality.FinalCountCheck;
import com.erp.production.ssm.mapper.FinalCountCheckMapper;
import com.erp.production.ssm.service.quality.FinalCountCheckService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FinalCountCheckServiceImpl implements FinalCountCheckService {

    @Autowired
    FinalCountCheckMapper finalCountCheckMapper;

    @Override
    public PageResult getList(Integer page, Integer rows, FinalCountCheck finalCountCheck) throws Exception {
        PageHelper.startPage(page, rows);
        List<FinalCountCheckVO> list = finalCountCheckMapper.find(finalCountCheck);
        PageResult result = new PageResult();
        result.setRows(list);
        PageInfo<FinalCountCheckVO> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public FinalCountCheck get(String string) throws Exception {
        return finalCountCheckMapper.selectByPrimaryKey(string);
    }

    @Override
    public CustomResult deleteBatch(String[] ids) throws Exception {
        int i = finalCountCheckMapper.deleteBatch(ids);
        if (i > 0){
            return CustomResult.ok();
        }else {
            return null;
        }
    }

    @Override
    public CustomResult insert(FinalCountCheck finalCountCheck) throws Exception {
        int  i = finalCountCheckMapper.insert(finalCountCheck);
        if (i > 0){
            return CustomResult.ok();
        }else {
            return CustomResult.build(101, "新增成品计数质检信息失败");
        }
    }

    @Override
    public CustomResult updateAll(FinalCountCheck finalCountCheck) throws Exception {
        int i = finalCountCheckMapper.updateByPrimaryKey(finalCountCheck);
        if (i > 0){
            return CustomResult.ok();
        }else {
            return CustomResult.build(101, "修改成品计数质检信息失败");
        }
    }

    @Override
    public CustomResult updateNote(FinalCountCheck finalCountCheck) throws Exception {
        int i = finalCountCheckMapper.updateNote(finalCountCheck);
        if (i > 0){
            return CustomResult.ok();
        }else {
            return CustomResult.build(101, "修改成品计数质检备注失败");
        }
    }

    @Override
    public PageResult searchFCountCheckByOrderId(Integer page, Integer rows, String orderId) throws Exception {
        PageHelper.startPage(page, rows);
        List<FinalCountCheckVO> list = finalCountCheckMapper.searchFCountCheckByOrderId(orderId);
        PageResult result = new PageResult();
        result.setRows(list);
        PageInfo<FinalCountCheckVO> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public PageResult searchFCountCheckByFCountCheckId(int page, int rows, String fCountCheckId) throws Exception {
        PageHelper.startPage(page, rows);
        List<FinalCountCheckVO> list = finalCountCheckMapper.searchFCountCheckByFCountCheckId(fCountCheckId);
        PageResult result = new PageResult();
        result.setRows(list);
        PageInfo<FinalCountCheckVO> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}
