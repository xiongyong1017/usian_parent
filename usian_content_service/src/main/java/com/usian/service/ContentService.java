package com.usian.service;

import com.usian.pojo.TbContent;
import com.usian.utils.AdNode;
import com.usian.utils.PageResult;

import java.util.List;

/**
 * @author : xy1201
 * @version 1.0
 * @date : 2021/4/19 10:42
 */
public interface ContentService {
    PageResult selectTbContentAllByCategoryId(Integer page, Integer rows, Long categoryId);

    Integer insertTbContent(TbContent tbContent);

    Integer deleteContentByIds(Long id);

    List<AdNode> selectFrontendContentByAD();

}
