package com.usian.mapper;

import com.usian.pojo.TbContentCategory;

import java.util.List;

public interface TbContentCategoryMapper {

    List<TbContentCategory> selectContentCategoryByParentId(Long parentId);

    Integer insertContentCategory(TbContentCategory tbContentCategory);

    TbContentCategory selectById(Long id);

    void updateById(TbContentCategory contentCategory);

    void deleteById(Long categoryId);
}