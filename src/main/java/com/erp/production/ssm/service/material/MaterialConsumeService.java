package com.erp.production.ssm.service.material;

import com.erp.production.ssm.bean.MaterialConsume;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.bean.material.MaterialConsumeVO;

import java.util.List;


public interface MaterialConsumeService {
    
	List<MaterialConsume> find() throws Exception;

	PageResult getList(int page, int rows, MaterialConsumeVO materialConsume)
			throws Exception;

	PageResult searchMaterialConsumeByConsumeId(Integer page, Integer rows, String searchValue);

	PageResult searchMaterialConsumeByMaterialId(Integer page, Integer rows, String searchValue);

	PageResult searchMaterialConsumeByWorkId(Integer page, Integer rows, String searchValue);

	CustomResult updateNote(MaterialConsume materialConsume);

	MaterialConsume get(String consumeId);

	CustomResult insert(MaterialConsume materialConsume);

	CustomResult updateAll(MaterialConsume materialConsume);

	CustomResult deleteBatch(String[] ids);
}
