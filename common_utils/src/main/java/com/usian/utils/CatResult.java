package com.usian.utils;

import java.io.Serializable;
import java.util.List;

/**
 * @author : xy1201
 * @version 1.0
 * @date : 2021/4/19 19:34
 */
public class CatResult implements Serializable {
    private List<?> data;

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
