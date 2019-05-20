package com.erp.production.ssm.service.quality;

import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.bean.quality.UnqualifyApply;

public interface UnqualifyService {

    PageResult getList(Integer page, Integer rows, UnqualifyApply unqualifyApply) throws Exception;

    PageResult searchUnqualifyByUnqualifyId(int page, int rows, String unqualifyId) throws Exception;

    PageResult searchUnqualifyByProductName(Integer page, Integer rows, String productName) throws Exception;

    UnqualifyApply get(String string) throws Exception;

    CustomResult delete(String string) throws Exception;

    CustomResult deleteBatch(String[] ids) throws Exception;

    CustomResult insert(UnqualifyApply unqualify) throws Exception;

    CustomResult update(UnqualifyApply unqualify) throws Exception;

    CustomResult updateAll(UnqualifyApply unqualify) throws Exception;

    CustomResult updateNote(UnqualifyApply unqualify) throws Exception;
}
