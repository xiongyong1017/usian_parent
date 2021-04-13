package com.usian.controller;

import com.usian.feign.ItemServiceFeign;
import com.usian.pojo.TbItem;
import com.usian.utils.PageResult;
import com.usian.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author : xy1201
 * @version 1.0
 * @date : 2021/4/7 21:39
 */
@RestController
@RequestMapping("/backend/item")
public class ItemController {
    @Autowired
    private ItemServiceFeign itemServiceFeign;

    /**
     * 查询商品基本信息
     */
    @RequestMapping("/selectItemInfo")
    public Result selectItemInfo(Long itemId) {
        TbItem tbItem = itemServiceFeign.selectItemInfo(itemId);
        System.err.println(tbItem);
        if (tbItem != null) {
            return Result.ok(tbItem);
        }
        return Result.error("查无结果");
    }

    /**
     * 查询商品并分页处理
     *
     * @return com.usian.pojo.result
     */
    @RequestMapping("/selectTbItemAllByPage")
    public Result selectTbItemAllByPage(@RequestParam(defaultValue = "1")
                                                Integer page, @RequestParam(defaultValue = "2") Integer rows) {
        PageResult pageResult = itemServiceFeign.selectTbItemAllByPage(page, rows);
        if (pageResult.getResult() != null &&
                pageResult.getResult().size() > 0) {
            return Result.ok(pageResult);
        }
        return Result.error("查无结果");
    }

    /**
     * 添加商品信息
     *
     * @return Integer
     * 通过对返回值得判断，从而判断
     */
    @RequestMapping("/insertTbItem")
    public Result insertTbItem(TbItem tbItem, String desc, String itemParams) {
        Integer insertTbItemNum = itemServiceFeign.insertTbItem(tbItem, desc, itemParams);
        if (insertTbItemNum == 3) {
            return Result.ok();
        }
        return Result.error("添加失败");
    }

    /**
     * 根据itemId回显商品信息
     *
     * @param itemId
     * @return result
     */
    @RequestMapping("/preUpdateItem")
    public Result preUpdateItem(Long itemId) {
        Map<String, Object> map = itemServiceFeign.preUpdateItem(itemId);
        if (map.size() > 0) {
            return Result.ok(map);
        }
        return Result.error("查无结果");
    }

    /**
     * @Date: 2021/4/13 9:35
     * 修改商品信息
     */
    @RequestMapping("/updateTbItem")
    public Result updateTbItem(TbItem tbItem, String desc, String itemParams) {
        Integer insertTbItemNum = itemServiceFeign.updateTbItem(tbItem, desc, itemParams);
        if (insertTbItemNum == 3) {
            return Result.ok();
        }
        return Result.error("修改失败");
    }

    /**
     * 根据itemId删除商品信息
     *
     * @param itemId
     * @return result
     */
    @RequestMapping("/deleteItemById")
    public Result deleteItemById(Long itemId) {
        Integer deleteNum = itemServiceFeign.deleteItemById(itemId);
        if (deleteNum == 1) {
            return Result.ok();
        }
        return Result.error("删除失败");
    }
}
