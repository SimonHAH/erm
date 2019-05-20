package com.erp.production.ssm.bean.VO;

import com.erp.production.ssm.bean.ProcessCountCheck;

/**
 * @author Turtle
 * @title: ProcessCountCheckVO
 * @projectName production_ms
 * @description: TODO
 * @date 2019/5/20 14:54
 */
public class ProcessCountCheckVO extends ProcessCountCheck {
    private String empName;

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}
