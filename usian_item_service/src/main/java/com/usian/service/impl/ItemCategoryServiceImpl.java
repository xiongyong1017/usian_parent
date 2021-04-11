package com.usian.service.impl;

import com.usian.mapper.TbItemCatMapper;
import com.usian.pojo.TbItemCat;
import com.usian.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : xy1201
 * @version 1.0
 * @date : 2021/4/8 21:04
 */
@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {
    /**
     * @Date: 2021/4/8 21:05
     * 注入TbItemCatMapper
     */
    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    /**
     * @return : java.util.List<com.usian.pojo.TbItemCat>
     * @Description : 根据分类ID查询子节点
     * @Param : [id]
     * @Author : xy
     * @Date : 2021/4/8 21:11
     */
    @Override
    public List<TbItemCat> selectItemCategoryByParentId(Long id) {
        return tbItemCatMapper.selectItemCategoryByParentId(id);
    }
}
