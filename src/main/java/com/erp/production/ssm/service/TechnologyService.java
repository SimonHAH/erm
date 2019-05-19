package com.erp.production.ssm.service;

import com.erp.production.ssm.bean.customize.ResponseVo;
import com.erp.production.ssm.bean.technology.Technology;

/**
 * @author Nemo
 * @version 1.0
 * @date 2019/5/17
 */
public interface TechnologyService {
    ResponseVo getList(Integer page, Integer rows, Technology technology);
}
