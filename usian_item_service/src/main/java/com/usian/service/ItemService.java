package com.usian.service;

import com.usian.pojo.TbItem;
import com.usian.pojo.TbItemDesc;
import com.usian.utils.PageResult;

import java.util.Map;

/**
 * service接口
 * @author : xy1201
 * @version 1.0
 * @date : 2021/4/7 21:16
 */
public interface ItemService {
    TbItem selectItemInfo(Long itemId);

    TbItemDesc selectItemDescByItemId(Long itemId);

    PageResult selectTbItemAllByPage(Integer page, Integer rows);

    Integer insertTbItem(TbItem tbItem, String desc, String itemParams);

    Map<String, Object> preUpdateItem(Long itemId);

    Integer updateTbItem(TbItem tbItem, String desc, String itemParams);

    Integer deleteItemById(Long itemId);
}
