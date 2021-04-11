package com.usian.utils;

import java.io.Serializable;
import java.util.List;

/**
 * 分页模型
 *
 * @author : xy1201
 * @version 1.0
 * @date : 2021/4/8 20:12
 */

public class PageResult implements Serializable {
    private Integer pageIndex;//当前页
    private Long total;//总页数
    private List result;//结果集

    public java.lang.Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(java.lang.Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public java.lang.Long getTotal() {
        return total;
    }

    public void setTotal(java.lang.Long total) {
        this.total = total;
    }

    public List getResult() {
        return result;
    }

    public void setResult(List result) {
        this.result = result;
    }

    public PageResult(java.lang.Integer pageIndex, java.lang.Long total, List result) {
        this.pageIndex = pageIndex;
        this.total = total;
        this.result = result;
    }

    public PageResult() {
    }
}
