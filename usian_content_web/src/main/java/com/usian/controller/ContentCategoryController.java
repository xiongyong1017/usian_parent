package com.usian.controller;

import com.usian.feign.ContentServiceFeign;
import com.usian.pojo.TbContentCategory;
import com.usian.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : xy1201
 * @version 1.0
 * @date : 2021/4/18 19:15
 */

@RestController
@RequestMapping("/content")
public class ContentCategoryController {
    @Autowired
    private ContentServiceFeign contentServiceFeign;

    /**
     * @return : com.usian.utils.Result
     * @Description : 根据父节点查询子节点
     * @Param : [id]
     * @Author : xy
     * @Date : 2021/4/18 19:17
     */
    @RequestMapping("/selectContentCategoryByParentId")
    public Result selectContentCategoryByParentId(@RequestParam(defaultValue = "0") Long id) {
        List<TbContentCategory> list = contentServiceFeign.selectContentCategoryByParentId(id);
        if (list != null && list.size() > 0) {
            return Result.ok(list);
        }
        return Result.error("查无结果");
    }

    /**
     * @return : com.usian.utils.Result
     * @Description : 添加内容分类
     * @Param : [tbContentCategory]
     * @Author : xy
     * @Date : 2021/4/18 21:09
     */
    @RequestMapping("/insertContentCategory")
    public Result insertContentCategory(TbContentCategory tbContentCategory) {
        Integer contentCategoryNum =
                contentServiceFeign.insertContentCategory(tbContentCategory);
        if (contentCategoryNum == 1) {
            return Result.ok();
        }
        return Result.error("添加失败");
    }

    /**
     * @return : com.usian.utils.Result
     * @Description : 删除分类内容
     * @Param : [categoryId]
     * @Author : xy
     * @Date : 2021/4/18 21:20
     */
    @RequestMapping("/deleteContentCategoryById")
    public Result deleteContentCategoryById(Long categoryId) {
        Integer status = contentServiceFeign.deleteContentCategoryById(categoryId);
        if (status == 200) {
            return Result.ok();
        }
        return Result.error("删除失败");
    }

    /**
     * @return : com.usian.utils.Result
     * @Description : 修改商品分类
     * @Param : [tbContentCategory]
     * @Author : xy
     * @Date : 2021/4/19 9:36
     */
    @RequestMapping("/updateContentCategory")
    public Result updateContentCategory(TbContentCategory tbContentCategory) {
        Integer updateNum = this.contentServiceFeign.updateContentCategory(tbContentCategory);
        if (updateNum == 1) {
            return Result.ok();
        }
        return Result.error("修改失败");
    }


}
