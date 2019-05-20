package com.erp.production.ssm.service.technology;

import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.bean.technology.Process;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Nemo
 * @version 1.0
 * @date 2019/5/18
 */

public interface ProcessService {
    PageResult getList(Integer page, Integer rows);

    List<Process> find();

    Process getItemById(String processId);

    PageResult searchItemById(String searchValue, Integer page, Integer rows);

    PageResult searchItemByPlanId(String searchValue, Integer page, Integer rows);
}
