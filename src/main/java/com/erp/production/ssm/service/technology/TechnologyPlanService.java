package com.erp.production.ssm.service.technology;

import com.erp.production.ssm.bean.customize.PageResult;

/**
 * @author Nemo
 * @version 1.0
 * @date 2019/5/20
 */
public interface TechnologyPlanService {
    PageResult getList(Integer page, Integer rows);
}
