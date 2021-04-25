package com.usian.service;

import com.usian.pojo.TbItemCat;
import com.usian.utils.CatResult;

import java.util.List;

/**
 * @author : xy1201
 * @version 1.0
 * @date : 2021/4/8 21:03
 */
public interface ItemCategoryService {
    List<TbItemCat> selectItemCategoryByParentId(Long id);

    CatResult selectItemCategoryAll();

}
