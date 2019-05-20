package com.erp.production.ssm.service.technology;

import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.bean.technology.Technology;
import com.erp.production.ssm.bean.technology.TechnologyExample;
import com.erp.production.ssm.mapper.TechnologyMapper;
import com.erp.production.ssm.service.technology.TechnologyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Nemo
 * @version 1.0
 * @date 2019/5/17
 */
@Service
public class TechnologyServiceImpl implements TechnologyService {

    @Autowired
    TechnologyMapper technologyMapper;

    @Override
    public PageResult getList(Integer page, Integer rows) {
        TechnologyExample example = new TechnologyExample();
        // 分页
        PageHelper.startPage(page, rows);
        List<Technology> list = technologyMapper.selectByExample(example);
        // 取记录总条数
        // PageInfo<Technology> pageInfo = new PageInfo<>(list);

        // 保存分页查询结果
        PageResult result = new PageResult();
        result.setRows(list);
        // result.setTotal(pageInfo.getTotal());
        result.setTotal(list.size());

        return result;
    }

    @Override
    public List<Technology> find() {
        TechnologyExample example = new TechnologyExample();
        return technologyMapper.selectByExample(example);
    }

    @Override
    public Technology getItemById(String technologyId) {
        return technologyMapper.selectByPrimaryKey(technologyId);
    }
}
