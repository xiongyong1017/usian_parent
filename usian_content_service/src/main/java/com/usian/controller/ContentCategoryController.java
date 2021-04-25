package com.usian.controller;

import com.usian.pojo.TbContentCategory;
import com.usian.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品分类控制层
 *
 * @author : xy1201
 * @version 1.0
 * @date : 2021/4/18 18:55
 */
@RestController
@RequestMapping("/service/contentCategory")
public class ContentCategoryController {
    @Autowired
    private ContentCategoryService contentCategoryService;

    /**
     * @return : java.util.List<com.usian.pojo.TbContentCategory>
     * @Description : 根据父节点Id查询子节点
     * @Param : [parentId]
     * @Author : xy
     * @Date : 2021/4/18 18:58
     */
    @RequestMapping("/selectContentCategoryByParentId")
    public List<TbContentCategory> selectContentCategoryByParentId(@RequestParam Long parentId) {
        return this.contentCategoryService.selectContentCategoryByParentId(parentId);
    }

    /**
     * @return : java.lang.Integer
     * @Description : 添加内容分类
     * @Param : [tbContentCategory]
     * @Author : xy
     * @Date : 2021/4/18 20:34
     */
    @RequestMapping("/insertContentCategory")
    public Integer insertContentCategory(@RequestBody TbContentCategory tbContentCategory) {
        return this.contentCategoryService.insertContentCategory(tbContentCategory);
    }

    /**
     * @return : java.lang.Integer
     * @Description : 删除分类内容
     * @Param : [categoryId]
     * @Author : xy
     * @Date : 2021/4/18 21:19
     */
    @RequestMapping("/deleteContentCategoryById")
    public Integer deleteContentCategoryById(Long categoryId) {
        return this.contentCategoryService.deleteContentCategoryById(categoryId);
    }

    /**
     * @return : java.lang.Integer
     * @Description : 修改分类信息
     * @Param : [tbContentCategory]
     * @Author : xy
     * @Date : 2021/4/19 9:38
     */
    @RequestMapping("/updateContentCategory")
    public Integer updateContentCategory(@RequestBody TbContentCategory tbContentCategory) {
        return this.contentCategoryService.updateContentCategory(tbContentCategory);
    }
}
