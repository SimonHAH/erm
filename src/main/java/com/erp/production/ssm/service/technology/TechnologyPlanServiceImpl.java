package com.erp.production.ssm.service.technology;

import com.erp.production.ssm.bean.VO.TechnologyPlanVO;
import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.mapper.TechnologyPlanMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
