package com.erp.production.ssm.service.impl;

import com.erp.production.ssm.bean.DeviceFault;
import com.erp.production.ssm.bean.VO.DeviceFaultVO;
import com.erp.production.ssm.bean.customize.ResponseVo;
import com.erp.production.ssm.mapper.DeviceFaultMapper;
import com.erp.production.ssm.service.DeviceFaultService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by HorseXInsect
 * 2019/5/19 14:45
 */
@Service
public class DeviceFaultServiceImpl implements DeviceFaultService {

    @Autowired
    DeviceFaultMapper deviceFaultMapper;

    @Override
    public ResponseVo getList(int page, int rows, DeviceFault deviceFault) {
        PageHelper.startPage(page, rows);
        List<DeviceFaultVO> list = deviceFaultMapper.find(deviceFault);
        ResponseVo responseVo = new ResponseVo();
        responseVo.setRows(list);
        PageInfo<DeviceFaultVO> pageInfo = new PageInfo<>(list);
        responseVo.setTotal(pageInfo.getTotal());
        return responseVo;
    }
}
