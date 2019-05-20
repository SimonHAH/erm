package com.erp.production.ssm.service.technology;

import com.erp.production.ssm.bean.customize.PageResult;
import java.util.List;

/**
 * @author Nemo
 * @version 1.0
 * @date 2019/5/20
 */
public interface TechnologyRequirementService {


    PageResult getList(Integer page, Integer rows);
}
