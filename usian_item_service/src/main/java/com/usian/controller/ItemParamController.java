package com.usian.controller;

import com.usian.pojo.TbItemParam;
import com.usian.service.ItemParamService;
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

}
