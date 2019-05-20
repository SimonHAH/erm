package com.erp.production.ssm.service.quality;

import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.bean.quality.FinalCountCheck;

public interface FinalCountCheckService {

    PageResult getList(Integer page, Integer rows, FinalCountCheck finalCountCheck)
            throws Exception;

    FinalCountCheck get(String string) throws Exception;

    CustomResult deleteBatch(String[] ids) throws Exception;

    CustomResult insert(FinalCountCheck finalCountCheck) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(FinalCountCheck finalCountCheck) throws Exception;

    CustomResult updateNote(FinalCountCheck finalCountCheck) throws Exception;

    PageResult searchFCountCheckByOrderId(Integer page, Integer rows,
                                                String orderId) throws Exception;

    PageResult searchFCountCheckByFCountCheckId(int page, int rows, String fCountCheckId)
            throws Exception;
}
