package com.erp.production.ssm.service.technology;

import com.erp.production.ssm.bean.VO.TechnologyRequirementVO;
import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.bean.technology.TechnologyRequirement;

import java.util.List;

/**
 * @author Nemo
 * @version 1.0
 * @date 2019/5/20
 */
public interface TechnologyRequirementService {


    PageResult getList(Integer page, Integer rows);


    PageResult searchItemById(String searchValue, Integer page, Integer rows);

    PageResult searchItemByName(String searchValue, Integer page, Integer rows);
}
