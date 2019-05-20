package com.erp.production.ssm.service;

import com.erp.production.ssm.bean.ProcessCountCheck;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.PageResult;

/**
 * @author Turtle
 * @title: ProcessCountCheckService
 * @projectName production_ms
 * @description: TODO
 * @date 2019/5/20 14:59
 */
public interface ProcessCountCheckService {
    PageResult getList(int page, int rows, ProcessCountCheck processCountCheck) throws Exception;

    CustomResult deleteBatch(String[] ids) throws Exception;

    CustomResult insert(ProcessCountCheck processCountCheck) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(ProcessCountCheck processCountCheck) throws Exception;

    CustomResult updateNote(ProcessCountCheck processCountCheck) throws Exception;

    PageResult searchPCountCheckByPCountCheckId(int page, int rows,
                                                      String pCountCheckId) throws Exception;
}
