package com.erp.production.ssm.service;

import com.erp.production.ssm.bean.Material;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.bean.customize.ResponseVo;

import java.util.List;

public interface MaterialService {

    List<Material> find() throws Exception;

    ResponseVo getList(Integer page, Integer rows, Material material);

    PageResult searchMaterialByMaterialId(Integer page, Integer rows, String materialId);

    PageResult searchMaterialByMaterialType(Integer page, Integer rows, String materialType);

    CustomResult updateNote(Material material);
}
