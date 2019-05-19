package com.erp.production.ssm.service;

import com.erp.production.ssm.bean.customize.PageResult;

public interface MaterialReceiveService {
		
	PageResult getList(int page, int rows) throws Exception;
}
