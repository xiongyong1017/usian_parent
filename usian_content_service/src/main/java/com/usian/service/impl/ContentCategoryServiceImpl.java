package com.usian.service.impl;

import com.usian.mapper.TbContentCategoryMapper;
import com.usian.pojo.TbContentCategory;
import com.usian.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 内容分类业务层
 *
 * @author : xy1201
 * @version 1.0
 * @date : 2021/4/18 18:54
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
    @Autowired
    private TbContentCategoryMapper tbContentCategoryMapper;

    /**
     * @return : java.util.List<com.usian.pojo.TbContentCategory>
     * @Description : 根据parentID查询（tb_content_category表）
     * @Param : [parentId]
     * @Author : xy
     * @Date : 2021/4/18 19:11
     */
    @Override
    public List<TbContentCategory> selectContentCategoryByParentId(Long parentId) {
        return this.tbContentCategoryMapper.selectContentCategoryByParentId(parentId);
    }

    @Override
    public Integer insertContentCategory(TbContentCategory tbContentCategory) {
        /**
         * @Date: 2021/4/18 20:37
         * Step 1: 添加内容分类对象
         */
        tbContentCategory.setCreated(new Date());
        tbContentCategory.setUpdated(new Date());
        tbContentCategory.setIsParent(false);
        tbContentCategory.setSortOrder(1);
        tbContentCategory.setStatus(1);
        Integer tbContentCategoryNum = this.tbContentCategoryMapper.insertContentCategory(tbContentCategory);
        /**
         * @Date: 2021/4/18 20:45
         * Step 2: 查询当前新节点的父节点
         */
        TbContentCategory contentCategory = this.tbContentCategoryMapper.selectById(tbContentCategory.getParentId());
        /**
         * @Date: 2021/4/18 20:48
         * Step 3: 判断当前父节点是否是子节点()
         */
        if (!contentCategory.getIsParent()) {
            contentCategory.setIsParent(true);
            contentCategory.setUpdated(new Date());
            this.tbContentCategoryMapper.updateById(contentCategory);
        }
        return tbContentCategoryNum;
    }

    /**
     * @return : java.lang.Integer
     * @Description : 删除商品分类
     * @Param : [categoryId]
     * @Author : xy
     * @Date : 2021/4/18 21:31
     */
    @Override
    public Integer deleteContentCategoryById(Long categoryId) {
        /**
         * @Date: 2021/4/18 21:31
         * Step 1: 查询当前节点,判断是否是父节点（不允许删除）
         */
        TbContentCategory tbContentCategory = this.tbContentCategoryMapper.selectById(categoryId);
        if (tbContentCategory.getIsParent() == true) {
            return 0;
        }
        /**
         * @Date: 2021/4/18 21:33
         * Step 2: 不是父节点，可以删除；
         */
        tbContentCategoryMapper.deleteById(categoryId);
        /**
         * @Date: 2021/4/18 21:47
         * Step 3: 继续向下判断，是否还有兄弟节点
         */
        List<TbContentCategory> tbContentCategories = this.tbContentCategoryMapper.selectContentCategoryByParentId(tbContentCategory.getParentId());
        //如果父节点不再拥有子节点，责修改isParent属性为false
        if (tbContentCategories.size() == 0) {
            TbContentCategory parent = new TbContentCategory();
            parent.setId(tbContentCategory.getId());
            parent.setIsParent(false);
            parent.setUpdated(new Date());
            this.tbContentCategoryMapper.updateById(parent);
        }
        return 200;
    }
}
