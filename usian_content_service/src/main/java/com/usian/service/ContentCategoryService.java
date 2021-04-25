package com.usian.service;

import com.usian.pojo.TbContentCategory;

import java.util.List;

/**
 * 内容分类接口
 *
 * @author : xy1201
 * @version 1.0
 * @date : 2021/4/18 18:47
 */
public interface ContentCategoryService {
    List<TbContentCategory> selectContentCategoryByParentId(Long parentId);

    Integer insertContentCategory(TbContentCategory tbContentCategory);

    Integer deleteContentCategoryById(Long categoryId);

    Integer updateContentCategory(TbContentCategory tbContentCategory);
}
