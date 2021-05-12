package com.usian.mapper;

import com.usian.pojo.TbItemDesc;

import java.util.List;

/**
 * @Date: 2021/4/12 14:23
 * TbItemDesc的mapper接口
 */
public interface TbItemDescMapper {

    Integer insertDesc(TbItemDesc tbItemDesc);

    TbItemDesc queryByItemId(Long itemId);

    Integer updateDesc(TbItemDesc tbItemDesc);


    List<TbItemDesc> selectItemDescByItemId(Long itemId);
}