package com.erp.production.ssm.service.impl;

import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.bean.technology.Technology;
import com.erp.production.ssm.service.TechnologyService;
import org.springframework.stereotype.Service;

/**
 * @author Nemo
 * @version 1.0
 * @date 2019/5/17
 */
@Service
public class TechnologyServiceImpl implements TechnologyService {
    @Override
    public PageResult getList(Integer page, Integer rows, Technology technology) {
        return null;
    }
}
