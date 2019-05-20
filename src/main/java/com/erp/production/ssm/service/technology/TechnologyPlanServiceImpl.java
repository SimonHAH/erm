package com.erp.production.ssm.service.technology;

import com.erp.production.ssm.bean.VO.TechnologyPlanVO;
import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.bean.technology.TechnologyPlan;
import com.erp.production.ssm.mapper.TechnologyPlanMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nemo
 * @version 1.0
 * @date 2019/5/20
 */
@Service
public class TechnologyPlanServiceImpl implements TechnologyPlanService {

    @Autowired
    TechnologyPlanMapper technologyPlanMapper;

    @Override
    public PageResult getList(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);

        List<TechnologyPlanVO> list = technologyPlanMapper.find();

        PageResult result = new PageResult();
        result.setRows(list);
        result.setTotal(list.size());

        return result;
    }

    @Override
    public PageResult searchItemById(String searchValue, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);

        TechnologyPlanVO technologyPlanVO = technologyPlanMapper.searchItemById(searchValue);
        List<TechnologyPlanVO> list = new ArrayList<>();
        list.add(technologyPlanVO);

        PageResult result = new PageResult();
        result.setTotal(list.size());
        result.setRows(list);

        return result;
    }

    @Override
    public PageResult searchItemByName(String searchValue, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);

        List<TechnologyPlanVO> list = technologyPlanMapper.searchItemByName(searchValue);

        PageResult result = new PageResult();
        result.setRows(list);
        result.setTotal(list.size());

        return result;
    }

    @Override
    public TechnologyPlan getPlanById(String planId) {
        return technologyPlanMapper.selectByPrimaryKey(planId);
    }
}
