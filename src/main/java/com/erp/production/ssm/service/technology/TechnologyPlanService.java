package com.erp.production.ssm.service.technology;

import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.bean.technology.TechnologyPlan;

/**
 * @author Nemo
 * @version 1.0
 * @date 2019/5/20
 */
public interface TechnologyPlanService {
    PageResult getList(Integer page, Integer rows);

    PageResult searchItemById(String searchValue, Integer page, Integer rows);

    PageResult searchItemByName(String searchValue, Integer page, Integer rows);

    TechnologyPlan getPlanById(String planId);
}
