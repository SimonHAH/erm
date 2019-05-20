package com.erp.production.ssm.bean.VO;

import com.erp.production.ssm.bean.technology.TechnologyRequirement;

/**
 * @author Nemo
 * @version 1.0
 * @date 2019/5/20
 */
public class TechnologyRequirementVO extends TechnologyRequirement {
    private String technologyName;

    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName;
    }
}
