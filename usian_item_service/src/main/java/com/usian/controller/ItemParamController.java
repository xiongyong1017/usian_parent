package com.usian.controller;

import com.usian.pojo.TbItemParam;
import com.usian.service.ItemParamService;
import com.usian.utils.CatResult;
import com.usian.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : xy1201
 * @version 1.0
 * @date : 2021/4/13 10:50
 */
@RestController
@RequestMapping("/service/itemParam")
public class ItemParamController {
    /**
     * @Date: 2021/4/13 10:51
     * 注入service
     */
    @Autowired
    private ItemParamService itemParamService;

    /**
     * @return : com.usian.pojo.TbItemParam
     * @Description : 根据商品分类 ID 查询规格参数模板
     * @Param : [itemCatId]
     * @Author : xy
     * @Date : 2021/4/13 10:53
     */
    @RequestMapping("/selectItemParamByItemCatId")
    public TbItemParam selectItemParamByItemCatId(Long itemCatId) {
        return this.itemParamService.selectItemParamByItemCatId(itemCatId);
    }

    /**
     * @return : com.usian.utils.PageResult
     * @Description : 查询所有商品规格信息
     * @Param : [page, rows]
     * @Author : xy
     * @Date : 2021/4/16 7:57
     */
    @RequestMapping("/selectItemParamAll")
    public PageResult selectItemParamAll(Integer page, Integer rows) {
        return this.itemParamService.selectItemParamAll(page, rows);
    }

    /**
     * @return : java.lang.Integer
     * @Description : 添加模板信息
     * @Param : [itemCatId, paramData]
     * @Author : xy
     * @Date : 2021/4/16 15:29
     */
    @RequestMapping("/insertItemParam")
    public Integer insertItemParam(Long itemCatId, String paramData) {
        return this.itemParamService.insertItemParam(itemCatId, paramData);
    }

    /**
     * @return : java.lang.Integer
     * @Description : 删除商品模板信息
     * @Param : [itemCatId]
     * @Author : xy
     * @Date : 2021/4/16 16:05
     */
    @RequestMapping("/deleteItemParamById")
    public Integer deleteItemParamById(Long itemCatId) {
        return this.itemParamService.deleteItemParamById(itemCatId);
    }


}
