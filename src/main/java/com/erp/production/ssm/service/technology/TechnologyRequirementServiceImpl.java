package com.erp.production.ssm.service.technology;

import com.erp.production.ssm.bean.VO.TechnologyRequirementVO;
import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.bean.technology.TechnologyRequirement;
import com.erp.production.ssm.bean.technology.TechnologyRequirementExample;
import com.erp.production.ssm.mapper.TechnologyRequirementMapper;
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
public class TechnologyRequirementServiceImpl implements TechnologyRequirementService {

    @Autowired
    TechnologyRequirementMapper technologyRequirementMapper;

    @Override
    public PageResult getList(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<TechnologyRequirementVO> list = technologyRequirementMapper.find();

        PageResult result = new PageResult();
        result.setRows(list);
        result.setTotal(list.size());

        return result;
    }

    @Override
    public PageResult searchItemById(String searchValue, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);

        TechnologyRequirementVO technologyRequirementVO = technologyRequirementMapper.searchItemById(searchValue);
        List<TechnologyRequirementVO> list = new ArrayList<>();
        list.add(technologyRequirementVO);

        PageResult result = new PageResult();
        result.setRows(list);
        result.setTotal(list.size());

        return result;
    }

    @Override
    public PageResult searchItemByName(String searchValue, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);

        List<TechnologyRequirementVO> list = technologyRequirementMapper.searchItemByName(searchValue);

        PageResult result = new PageResult();
        result.setRows(list);
        result.setTotal(list.size());

        return result;
    }
}
