package com.erp.production.ssm.service.impl;

import com.erp.production.ssm.bean.VO.FinalMeasuretCheckVO;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.bean.quality.FinalMeasuretCheck;
import com.erp.production.ssm.mapper.FinalMeasuretCheckMapper;
import com.erp.production.ssm.service.quality.FinalMeasuretCheckService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinalMeasuretCheckServiceImpl implements FinalMeasuretCheckService {

    @Autowired
    FinalMeasuretCheckMapper finalMeasuretCheckMapper;

    @Override
    public PageResult getList(Integer page, Integer rows, FinalMeasuretCheck finalMeasuretCheck) throws Exception {
        PageHelper.startPage(page, rows);
        List<FinalMeasuretCheckVO> list = finalMeasuretCheckMapper.find(finalMeasuretCheck);
        //创建一个返回值对象
        PageResult result = new PageResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<FinalMeasuretCheckVO> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public FinalMeasuretCheck get(String string) throws Exception {
        return finalMeasuretCheckMapper.selectByPrimaryKey(string);
    }

    @Override
    public CustomResult deleteBatch(String[] ids) throws Exception {
        int i = finalMeasuretCheckMapper.deleteBatch(ids);
        if(i>0){
            return CustomResult.ok();
        }else{
            return null;
        }
    }

    @Override
    public CustomResult insert(FinalMeasuretCheck finalMeasuretCheck) throws Exception {
        int i = finalMeasuretCheckMapper.insert(finalMeasuretCheck);
        if(i>0){
            return CustomResult.ok();
        }else{
            return CustomResult.build(101, "新增成品计量质检信息失败");
        }
    }

    @Override
    public CustomResult updateAll(FinalMeasuretCheck finalMeasuretCheck) throws Exception {
        int i = finalMeasuretCheckMapper.updateByPrimaryKey(finalMeasuretCheck);
        if(i>0){
            return CustomResult.ok();
        }else{
            return CustomResult.build(101, "修改成品计量质检信息失败");
        }
    }

    @Override
    public CustomResult updateNote(FinalMeasuretCheck finalMeasuretCheck) throws Exception {
        int i = finalMeasuretCheckMapper.updateNote(finalMeasuretCheck);
        if(i>0){
            return CustomResult.ok();
        }else{
            return CustomResult.build(101, "修改成品计量质检备注失败");
        }
    }

    @Override
    public PageResult searchFMeasureCheckByFMeasureCheckId(int page, int rows, String fMeasureCheckId) throws Exception {
        //分页处理
        PageHelper.startPage(page, rows);
        List<FinalMeasuretCheckVO> list = finalMeasuretCheckMapper.searchFMeasureCheckByFMeasureCheckId(fMeasureCheckId);
        //创建一个返回值对象
        PageResult result = new PageResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<FinalMeasuretCheckVO> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public PageResult searchFMeasureCheckByOrderId(Integer page, Integer rows, String orderId) throws Exception {
        //分页处理
        PageHelper.startPage(page, rows);
        List<FinalMeasuretCheckVO> list = finalMeasuretCheckMapper.searchFMeasureCheckByOrderId(orderId);
        //创建一个返回值对象
        PageResult result = new PageResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<FinalMeasuretCheckVO> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}
