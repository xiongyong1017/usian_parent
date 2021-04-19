package com.usian.controller;

import com.usian.feign.ItemServiceFeign;
import com.usian.pojo.TbItemParam;
import com.usian.utils.PageResult;
import com.usian.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : xy1201
 * @version 1.0
 * @date : 2021/4/13 11:17
 */
@RestController
@RequestMapping("/backend/itemParam")
public class ItemParamController {
    @Autowired
    private ItemServiceFeign itemServiceFeign;

    /**
     * 根据商品分类 ID 查询规格参数模板
     */
    @RequestMapping("/selectItemParamByItemCatId/{itemCatId}")
    public Result selectItemParamByItemCatId(@PathVariable("itemCatId") Long itemCatId) {
        TbItemParam tbItemParam =
                this.itemServiceFeign.selectItemParamByItemCatId(itemCatId);
        if (tbItemParam != null) {
            return Result.ok(tbItemParam);
        }
        return Result.error("查无结果");
    }

    /**
     * 查询所有商品规格
     */
    @RequestMapping("/selectItemParamAll")
    public Result selectItemParamAll(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer rows) {
        PageResult pageResult = this.itemServiceFeign.selectItemParamAll(page, rows);
        if (pageResult.getResult().size() > 0) {
            return Result.ok(pageResult);
        }
        return Result.error("查无结果");
    }

    /**
     * @return : com.usian.utils.Result
     * @Description : 添加模板信息
     * @Param : [itemCatId, paramData]
     * @Author : xy
     * @Date : 2021/4/16 15:04
     */
    @RequestMapping("/insertItemParam")
    public Result insertItemParam(Long itemCatId, String paramData) {
        Integer num = itemServiceFeign.insertItemParam(itemCatId, paramData);
        if (num == 1) {
            return Result.ok();
        }
        return Result.error("添加失败，改类目已有规格模板");
    }

    /**
     * @return : com.usian.utils.Result
     * @Description : 根据itemID删除商品模板信息
     * @Param : [itemCatId]
     * @Author : xy
     * @Date : 2021/4/16 16:04
     */
    @RequestMapping("/deleteItemParamById")
    public Result deleteItemParamById(Long itemCatId) {
        Integer num = itemServiceFeign.deleteItemParamById(itemCatId);
        if (num == 1) {
            return Result.ok();
        }
        return Result.error("删除失败");
    }


}
