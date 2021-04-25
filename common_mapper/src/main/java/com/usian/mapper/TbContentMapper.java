package com.usian.mapper;

import com.usian.pojo.TbContent;

import java.util.List;

public interface TbContentMapper {

    List<TbContent> selectTbContentAllByCategoryId(Long categoryId);

    Integer insertTbContent(TbContent tbContent);

    Integer deleteContentByIds(Long id);

    List<TbContent> selectFrontendContentByAD(Long ad_category_id);

}