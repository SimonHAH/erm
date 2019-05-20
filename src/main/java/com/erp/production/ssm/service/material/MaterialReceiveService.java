package com.erp.production.ssm.service.material;

import com.erp.production.ssm.bean.MaterialReceive;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.PageResult;
import com.github.pagehelper.PageHelper;

public interface MaterialReceiveService {
	PageResult getList(int page, int rows) throws Exception;

	MaterialReceive get(String string) throws Exception;

	CustomResult delete(String string) throws Exception;

	CustomResult deleteBatch(String[] ids) throws Exception;

	CustomResult insert(MaterialReceive materialReceive) throws Exception;

	//更新部分字段，用的是updateSelective判断非空的字段进行更新
	CustomResult update(MaterialReceive materialReceive) throws Exception;

	//更新全部字段，不判断非空，直接进行更新
	CustomResult updateAll(MaterialReceive materialReceive) throws Exception;

	//更新备注
	CustomResult updateNote(MaterialReceive materialReceive) throws Exception;

	PageResult searchMaterialReceiveByReceiveId(int page, int rows, String receiveId) throws Exception;

	PageResult searchMaterialReceiveByMaterialId(int page, int rows,
													   String materialId) throws Exception;}
