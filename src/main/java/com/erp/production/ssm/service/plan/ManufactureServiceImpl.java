package com.erp.production.ssm.service.plan;

import com.erp.production.ssm.bean.common.CommonResult;
import com.erp.production.ssm.bean.plan.Manufacture;
import com.erp.production.ssm.mapper.ManufactureMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufactureServiceImpl implements ManufactureService {
    @Autowired
    ManufactureMapper manufactureMapper;

    @Override
    public Manufacture queryManufactureById(String id) {
        Manufacture manufacture = manufactureMapper.selectByPrimaryKey(id);
        return manufacture;
    }

    @Override
    public CommonResult getList(int page, int rows) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<Manufacture> manufactures = manufactureMapper.find();
        //创建一个返回值对象
        CommonResult<Manufacture> result = new CommonResult<>();
        result.setRows(manufactures);
        //取记录总条数
        //PageInfo<Task> pageInfo = new PageInfo<>(tasks);
        result.setTotal(manufactures.size());

        return result;
    }
}
