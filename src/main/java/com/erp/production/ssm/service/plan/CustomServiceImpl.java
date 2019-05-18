package com.erp.production.ssm.service.plan;

import com.erp.production.ssm.bean.common.CommonResult;
import com.erp.production.ssm.bean.plan.Custom;
import com.erp.production.ssm.mapper.CustomMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomServiceImpl implements CustomService {
    @Autowired
    CustomMapper customMapper;

    @Override
    public CommonResult getList(int page, int rows) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<Custom> customs = customMapper.find();
        //创建一个返回值对象
        CommonResult<Custom> result = new CommonResult<>();
        result.setRows(customs);
        //取记录总条数
        //PageInfo<Task> pageInfo = new PageInfo<>(tasks);
        result.setTotal(customs.size());

        return result;
    }
}
