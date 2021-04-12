package com.usian.mapper;

import com.usian.pojo.TbItemParam;
import com.usian.pojo.TbItemParamItem;

import java.util.List;

/**
 * @Date: 2021/4/12 14:24
 * TbItemParam的mapper接口
 */
public interface TbItemParamMapper {

    Integer insertParam(TbItemParam tbItemParam);

    List<TbItemParamItem> queryByItemId(Long itemId);
}