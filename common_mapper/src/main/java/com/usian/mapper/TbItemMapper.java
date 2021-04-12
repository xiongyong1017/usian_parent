package com.usian.mapper;

import com.usian.pojo.TbItem;

import java.util.List;

/**
 * @Description TbItem的mapper接口
 */
public interface TbItemMapper {

    TbItem selectItemInfo(Long itemId);

    List<TbItem> selectTbItemAllByPage();

    Integer insertTbItem(TbItem tbItem);

    TbItem queryByItemId(Long itemId);
}