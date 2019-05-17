package com.erp.production.ssm.mapper;

import com.erp.production.ssm.bean.BeanTest;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MapperTest {

    @Select("select *from test_t")
    List<BeanTest> findAll();
}
