package com.erp.production.ssm.service.technology;

import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.bean.technology.TechnologyRequirement;
import com.erp.production.ssm.bean.technology.TechnologyRequirementExample;
import com.erp.production.ssm.mapper.TechnologyRequirementMapper;
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
public class TechnologyRequirementServiceImpl implements TechnologyRequirementService {

    @Autowired
    TechnologyRequirementMapper technologyRequirementMapper;

    @Override
    public PageResult getList(Integer page, Integer rows) {
        TechnologyRequirementExample example = new TechnologyRequirementExample();

        PageHelper.startPage(page, rows);
        List<TechnologyRequirement> list = technologyRequirementMapper.selectByExample(example);

        PageResult result = new PageResult();
        result.setRows(list);
        result.setTotal(list.size());

        return result;
    }
}
