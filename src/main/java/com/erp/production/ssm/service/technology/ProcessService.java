package com.erp.production.ssm.service.technology;

import com.erp.production.ssm.bean.customize.PageResult;
import org.springframework.stereotype.Service;

/**
 * @author Nemo
 * @version 1.0
 * @date 2019/5/18
 */

public interface ProcessService {
    PageResult getList(Integer page, Integer rows);
}
