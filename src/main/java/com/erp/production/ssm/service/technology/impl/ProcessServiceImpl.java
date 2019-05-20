package com.erp.production.ssm.service.technology.impl;

import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.bean.technology.Process;
import com.erp.production.ssm.bean.technology.ProcessExample;
import com.erp.production.ssm.bean.technology.Technology;
import com.erp.production.ssm.mapper.ProcessMapper;
import com.erp.production.ssm.service.technology.ProcessService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Nemo
 * @version 1.0
 * @date 2019/5/18
 */
@Service("Process")
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    private ProcessMapper processMapper;

    @Override
    public List<Process> find(){
        ProcessExample example = new ProcessExample();
        List<Process> processes = processMapper.selectByExample(example);
        return processes;
    }

    @Override
    public PageResult getList(Integer page, Integer rows) {
        ProcessExample example = new ProcessExample();

        PageHelper.startPage(page, rows);
        List<Process> list = processMapper.selectByExample(example);

        PageResult result = new PageResult();
        result.setRows(list);
        result.setTotal(list.size());

        return result;
    }

    @Override
    public List<Process> find() {
        ProcessExample example = new ProcessExample();
        List<Process> list = processMapper.selectByExample(example);
        return list;
    }
}
