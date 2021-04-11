package com.usian.mapper;

import com.usian.pojo.TbItemCat;

import java.util.List;

public interface TbItemCatMapper {

    List<TbItemCat> selectItemCategoryByParentId(Long id);
}