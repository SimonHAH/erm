package com.erp.production.ssm.service.impl;

import com.erp.production.ssm.bean.VO.UnqualifyApplyVO;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.bean.quality.UnqualifyApply;
import com.erp.production.ssm.mapper.UnqualifyApplyMapper;
import com.erp.production.ssm.service.quality.UnqualifyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnqualifyServiceImpl implements UnqualifyService {


    @Autowired
    private UnqualifyApplyMapper unqualifyApplyMapper;

    @Override
    public PageResult getList(Integer page, Integer rows, UnqualifyApply unqualifyApply) throws Exception {

        PageHelper.startPage(page, rows);
        List<UnqualifyApplyVO> list = unqualifyApplyMapper.find(unqualifyApply);
        PageResult result = new PageResult();
        result.setRows(list);

        PageInfo<UnqualifyApplyVO> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public PageResult searchUnqualifyByUnqualifyId(int page, int rows, String unqualifyId) throws Exception {
        //分页处理
        PageHelper.startPage(page, rows);
        List<UnqualifyApplyVO> list = unqualifyApplyMapper.searchUnqualifyByUnqualifyId(unqualifyId);
        //创建一个返回值对象
        PageResult result = new PageResult();
        result.setRows(list);
        //记录总条数
        PageInfo<UnqualifyApplyVO> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public PageResult searchUnqualifyByProductName(Integer page, Integer rows, String productName) throws Exception {
        //分页处理
        PageHelper.startPage(page, rows);
        List<UnqualifyApplyVO> list = unqualifyApplyMapper.searchUnqualifyByProductName(productName);
        //创建一个返回值对象
        PageResult result = new PageResult();
        result.setRows(list);
        //记录总条数
        PageInfo<UnqualifyApplyVO> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public UnqualifyApply get(String string) throws Exception {
        return unqualifyApplyMapper.selectByPrimaryKey(string);
    }

    @Override
    public CustomResult delete(String string) throws Exception {
        int i = unqualifyApplyMapper.deleteByPrimaryKey(string);
        if (i > 0){
            return CustomResult.ok();
        }else {
            return null;
        }
    }

    @Override
    public CustomResult deleteBatch(String[] ids) throws Exception {
        int i = unqualifyApplyMapper.deleteBatch(ids);
        if (i > 0){
            return CustomResult.ok();
        }else {
            return null;
        }
    }

    @Override
    public CustomResult insert(UnqualifyApply unqualify) throws Exception {
        int i = unqualifyApplyMapper.insert(unqualify);
        if (i > 0){
            return CustomResult.ok();
        }else {
            return CustomResult.build(101, "新增不合格品申请信息失败");
        }
    }

    @Override
    public CustomResult update(UnqualifyApply unqualify) throws Exception {
        int i = unqualifyApplyMapper.updateByPrimaryKeySelective(unqualify);
        if (i > 0){
            return CustomResult.ok();
        }else {
            return CustomResult.build(101, "修改不合格品申请信息失败");
        }
    }

    @Override
    public CustomResult updateAll(UnqualifyApply unqualify) throws Exception {
        int i = unqualifyApplyMapper.updateByPrimaryKey(unqualify);
        if (i > 0){
            return CustomResult.ok();
        }else {
            return CustomResult.build(101, "修改不合格品申请信息失败");
        }
    }

    @Override
    public CustomResult updateNote(UnqualifyApply unqualify) throws Exception {
        int i = unqualifyApplyMapper.updateNote(unqualify);
        if (i > 0){
            return CustomResult.ok();
        }else {
            return CustomResult.build(101, "修改不合格品申请备注失败");
        }
    }

}


