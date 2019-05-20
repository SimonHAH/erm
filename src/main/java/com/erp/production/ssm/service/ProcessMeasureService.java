package com.erp.production.ssm.service;

import com.erp.production.ssm.bean.ProcessMeasureCheck;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.PageResult;

/**
 * @author Turtle
 * @title: ProcessMeasureService
 * @projectName production_ms
 * @description: TODO
 * @date 2019/5/20 12:00
 */
public interface ProcessMeasureService {
    PageResult searchPMeasureCheckByPMeasureCheckId(int page, int rows,String pMeasureCheckId) throws Exception;

    PageResult getList(int page, int rows, ProcessMeasureCheck processMeasureCheck) throws Exception;

    CustomResult deleteBatch(String[] ids) throws Exception;

    CustomResult insert(ProcessMeasureCheck processMeasureCheck) throws Exception;

    CustomResult updateAll(ProcessMeasureCheck processMeasureCheck) throws Exception;

    CustomResult updateNote(ProcessMeasureCheck processMeasureCheck) throws Exception;
}

