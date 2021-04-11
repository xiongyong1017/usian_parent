package com.usian.service;

import com.usian.pojo.TbItem;
import com.usian.utils.PageResult;

/**
 * service接口
 * @author : xy1201
 * @version 1.0
 * @date : 2021/4/7 21:16
 */
public interface ItemService {
    TbItem selectItemInfo(Long itemId);

    PageResult selectTbItemAllByPage(Integer page, Integer rows);
}
