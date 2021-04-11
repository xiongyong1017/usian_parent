package com.usian.mapper;

import com.usian.pojo.TbItem;

import java.util.List;

public interface TbItemMapper {

    TbItem selectItemInfo(Long itemId);

    List<TbItem> selectTbItemAllByPage();


}