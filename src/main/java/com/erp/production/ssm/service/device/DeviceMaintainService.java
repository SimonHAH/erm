package com.erp.production.ssm.service.device;

import com.erp.production.ssm.bean.DeviceMaintain;
import com.erp.production.ssm.bean.customize.ResponseVo;

/**
 * Created by HorseXInsect
 * 2019/5/19 15:29
 */
public interface DeviceMaintainService {

    ResponseVo getList(int page, int rows, DeviceMaintain deviceMaintain);


}
