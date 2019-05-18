package com.erp.production.ssm.service;

import com.erp.production.ssm.bean.Material;
import com.erp.production.ssm.bean.customize.PageResult;

import java.util.List;

public interface MaterialService {

    List<Material> find() throws Exception;

    PageResult getList(Integer page, Integer rows, Material material);
}
