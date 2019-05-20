package com.erp.production.ssm.service.technology;

import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.bean.customize.ResponseVo;
import com.erp.production.ssm.bean.technology.Technology;
import com.github.pagehelper.PageHelper;

import java.util.List;

/**
 * @author Nemo
 * @version 1.0
 * @date 2019/5/17
 */
public interface TechnologyService {

    PageResult getList(Integer page, Integer rows);

    List<Technology> find();

    Technology getItemById(String technologyId);

    PageResult searchItemById(String searchValue, Integer page, Integer rows);

    PageResult searchItemByName(String searchValue, Integer page, Integer rows);
}
