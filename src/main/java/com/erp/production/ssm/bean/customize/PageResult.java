package com.erp.production.ssm.bean.customize;

import java.util.List;

/**
 * Created by HorseXInsect
 * 2019/5/17 20:01
 */
public class PageResult {
    private long total;
    private List<?> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
