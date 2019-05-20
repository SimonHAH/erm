package com.erp.production.ssm.bean.VO;

import com.erp.production.ssm.bean.ProcessCountCheck;
import com.erp.production.ssm.bean.ProcessMeasureCheck;

/**
 * @author Turtle
 * @title: ProcessCountCheckVO
 * @projectName production_ms
 * @description: TODO
 * @date 2019/5/20 11:57
 */
public class ProcessMeasureCheckVO extends ProcessMeasureCheck {
    private String empName;

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}
