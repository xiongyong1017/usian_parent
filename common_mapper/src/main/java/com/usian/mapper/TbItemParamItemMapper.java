package com.usian.mapper;

import com.usian.pojo.TbItemParamItem;

import java.util.List;

public interface TbItemParamItemMapper {

    Integer insertParam(TbItemParamItem tbItemParamItem);

    List<TbItemParamItem> queryByItemId(Long itemId);

    Integer updateParam(TbItemParamItem tbItemParamItem);
}