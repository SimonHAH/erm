package com.erp.production.ssm.service.technology;

import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.bean.technology.Process;
import com.erp.production.ssm.bean.technology.ProcessExample;
import com.erp.production.ssm.mapper.ProcessMapper;
import com.erp.production.ssm.service.technology.ProcessService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public Process getItemById(String processId) {
        return processMapper.selectByPrimaryKey(processId);
    }

    @Override
    public PageResult searchItemById(String searchValue, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);

        Process process = processMapper.selectByPrimaryKey(searchValue);
        List<Process> list = new ArrayList<>();
        list.add(process);

        PageResult result = new PageResult();
        result.setRows(list);
        result.setTotal(list.size());

        return result;
    }

    @Override
    public PageResult searchItemByPlanId(String searchValue, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);

        List<Process> list = processMapper.searchItemByPlanId(searchValue);

        PageResult result = new PageResult();
        result.setTotal(list.size());
        result.setRows(list);

        return result;
    }
}