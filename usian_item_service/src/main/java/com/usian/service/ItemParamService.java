package com.usian.service;

import com.usian.pojo.TbItemParam;
import com.usian.utils.PageResult;

/**
 * 商品规格接口
 * @author : xy1201
 * @version 1.0
 * @date : 2021/4/13 10:49
 */
public interface ItemParamService {
    TbItemParam selectItemParamByItemCatId(Long itemCatId);

    PageResult selectItemParamAll(Integer page, Integer rows);

    Integer insertItemParam(Long itemCatId, String paramData);

    Integer deleteItemParamById(Long itemCatId);
}
