package com.erp.production.ssm.service;

import com.erp.production.ssm.bean.MaterialConsume;
import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.bean.material.MaterialConsumeVO;

import java.util.List;


public interface MaterialConsumeService {
    
	List<MaterialConsume> find() throws Exception;

	PageResult getList(int page, int rows, MaterialConsumeVO materialConsume)
			throws Exception;
}
