package com.usian.controller;

import com.usian.pojo.TbItem;
import com.usian.service.ItemService;
import com.usian.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * ItemController
 *
 * @author : xy1201
 * @version 1.0
 * @date : 2021/4/7 21:27
 */
@RestController
@RequestMapping("/service/item")
public class ItemController {
    /**
     * @Date: 2021/4/7 21:28
     * 注入service
     */
    @Autowired
    private ItemService itemService;

    /**
     * @return : com.usian.pojo.TbItem
     * @Description :根据商品ID查询商品信息
     * @Param : [itemId]
     * @Author : xy
     * @Date : 2021/4/7 21:31
     */
    @RequestMapping("/selectItemInfo")
    public TbItem selectItemInfo(Long itemId) {
        return this.itemService.selectItemInfo(itemId);
    }

    /**
     * @return : com.usian.utils.PageResult
     * @Description : 分页查询商品信息
     * @Param : [page, rows]
     * @Author : xy
     * @Date : 2021/4/8 21:06
     */
    @RequestMapping("/selectTbItemAllByPage")
    public PageResult selectTbItemAllByPage(Integer page, Integer rows) {
        return this.itemService.selectTbItemAllByPage(page, rows);
    }

    /**
     * @return : java.lang.Integer
     * @Description :添加商品信息
     * @Param : [tbItem, desc, itemParams]
     * @Author : xy
     * @Date : 2021/4/12 11:54
     */
    @RequestMapping("/insertTbItem")
    public Integer insertTbItem(@RequestBody TbItem tbItem, String desc, String itemParams) {
        return this.itemService.insertTbItem(tbItem, desc, itemParams);
    }

    /**
     * @return : java.util.Map<java.lang.String,java.lang.Object>
     * @Description :根据商品ID查询商品，商品描述，商品分类，规格参数
     * @Param : [itemId]
     * @Author : xy
     * @Date : 2021/4/12 15:19
     */
    @RequestMapping("/preUpdateItem")
    public Map<String, Object> preUpdateItem(Long itemId) {
        Map<String, Object> map = this.itemService.preUpdateItem(itemId);
        return this.itemService.preUpdateItem(itemId);
    }

    /**
     * @return : java.lang.Integer
     * @Description :  修改商品信息
     * @Param : [tbItem, desc, itemParams]
     * @Author : xy
     * @Date : 2021/4/13 8:55
     */
    @RequestMapping("/updateTbItem")
    public Integer updateTbItem(@RequestBody TbItem tbItem, String desc, String itemParams) {
        return this.itemService.updateTbItem(tbItem, desc, itemParams);
    }

    /**
     * @return : java.lang.Integer
     * @Description :  根据ID删除的方法
     * @Param : [itemId]
     * @Author : xy
     * @Date : 2021/4/13 14:15
     */
    @RequestMapping("/deleteItemById")
    public Integer deleteItemById(Long itemId) {
        return this.itemService.deleteItemById(itemId);
    }
}
