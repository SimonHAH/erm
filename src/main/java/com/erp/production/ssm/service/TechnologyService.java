package com.erp.production.ssm.service;

import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.bean.technology.Technology;

/**
 * @author Nemo
 * @version 1.0
 * @date 2019/5/17
 */
public interface TechnologyService {
    PageResult getList(Integer page, Integer rows, Technology technology);
}
