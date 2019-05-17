package com.erp.production.ssm.service.plan;

import com.erp.production.ssm.bean.plan.Manufacture;
import com.erp.production.ssm.mapper.ManufactureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManufactureServiceImpl implements ManufactureService {
    @Autowired
    ManufactureMapper manufactureMapper;

    @Override
    public Manufacture queryManufactureById(String id) {
        Manufacture manufacture = manufactureMapper.selectByPrimaryKey(id);
        return manufacture;
    }
}
