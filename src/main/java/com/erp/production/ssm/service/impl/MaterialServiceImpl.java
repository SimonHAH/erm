package com.erp.production.ssm.service.impl;
import com.erp.production.ssm.bean.Material;
import com.erp.production.ssm.bean.MaterialExample;
import com.erp.production.ssm.bean.customize.ResponseVo;
import com.erp.production.ssm.mapper.MaterialMapper;
import com.erp.production.ssm.service.MaterialService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    MaterialMapper materialMapper;

    public List<Material> find() throws Exception{
        MaterialExample example = new MaterialExample();
        return materialMapper.selectByExample(example);
    }

    @Override
    public ResponseVo getList(Integer page, Integer rows, Material material) {
        //查询列表
        MaterialExample example = new MaterialExample();
        //分页处理
        PageHelper.startPage(page, rows);
        List<Material> list = materialMapper.selectByExample(example);
        //创建一个返回值对象
        ResponseVo result = new ResponseVo();
        result.setRows(list);
        //取记录总条数
        PageInfo<Material> pageInfo = new PageInfo<>(list);

        result.setTotal(list.size());

        return result;
    }

}
