package com.usian.controller;

import com.usian.pojo.TbItem;
import com.usian.service.ItemService;
import com.usian.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
