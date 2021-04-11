package com.usian.controller;

import com.usian.pojo.TbItemCat;
import com.usian.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ItemCategoryController
 *
 * @author : xy1201
 * @version 1.0
 * @date : 2021/4/8 21:06
 */

@RestController
@RequestMapping("/service/itemCategory")
public class ItemCategoryController {
    /**
     * @Date: 2021/4/8 21:07
     * 注入 ItemCategoryService
     */
    @Autowired
    private ItemCategoryService itemCategoryService;

    /**
     * @return : java.util.List<com.usian.pojo.TbItemCat>
     * @Description : 根据父节点查询子节点
     * @Param : [id]
     * @Author : xy
     * @Date : 2021/4/8 21:09
     */
    @RequestMapping("/selectItemCategoryByParentId")
    public List<TbItemCat> selectItemCategoryByParentId(@RequestParam Long id) {
        List<TbItemCat> tbItemCats = itemCategoryService.selectItemCategoryByParentId(id);
        return tbItemCats;
    }

}
