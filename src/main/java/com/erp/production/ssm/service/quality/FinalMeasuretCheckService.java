package com.erp.production.ssm.service.quality;

import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.bean.quality.FinalMeasuretCheck;

public interface FinalMeasuretCheckService {

    PageResult getList(Integer page, Integer rows, FinalMeasuretCheck finalMeasuretCheck) throws Exception;

    FinalMeasuretCheck get(String string) throws Exception;

    CustomResult deleteBatch(String[] ids) throws Exception;

    CustomResult insert(FinalMeasuretCheck finalMeasuretCheck) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(FinalMeasuretCheck finalMeasuretCheck) throws Exception;

    CustomResult updateNote(FinalMeasuretCheck finalMeasuretCheck) throws Exception;

    PageResult searchFMeasureCheckByFMeasureCheckId(int page, int rows, String fMeasureCheckId) throws Exception;

    PageResult searchFMeasureCheckByOrderId(Integer page, Integer rows, String orderId) throws Exception;
}
