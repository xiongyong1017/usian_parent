package com.usian.controller;

import com.usian.feign.ContentServiceFeign;
import com.usian.pojo.TbContent;
import com.usian.utils.PageResult;
import com.usian.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 分类内容
 *
 * @author : xy1201
 * @version 1.0
 * @date : 2021/4/19 10:33
 */
@RestController
@RequestMapping("/content")
public class ContentController {
    @Autowired
    private ContentServiceFeign contentServiceFeign;

    /**
     * @return : com.usian.utils.Result
     * @Description : 根据分类ID查询分类信息
     * @Param : [page, rows, categoryId]
     * @Author : xy
     * @Date : 2021/4/19 10:38
     */
    @RequestMapping("selectTbContentAllByCategoryId")
    public Result selectTbContentAllByCategoryId(@RequestParam(defaultValue = "1") Integer page,
                                                 @RequestParam(defaultValue = "30") Integer rows,
                                                 Long categoryId) {
        PageResult pageResult = this.contentServiceFeign.selectTbContentAllByCategoryId(page, rows, categoryId);
        if (pageResult != null && pageResult.getResult().size() > 0) {
            return Result.ok(pageResult);
        }
        return Result.error("查无结果");
    }

    @RequestMapping("/insertTbContent")
    /**
     * @Description : 根据分类添加内容
     * @Param : [tbContent]
     * @return : com.usian.utils.Result
     * @Author : xy
     * @Date : 2021/4/19 16:50
     */
    public Result insertTbContent(TbContent tbContent) {
        Integer num = this.contentServiceFeign.insertTbContent(tbContent);
        if (num != null) {
            return Result.ok();
        }
        return Result.error("添加失败");
    }

    /**
     * 删除分类的内容
     */
    @RequestMapping("/deleteContentByIds")
    public Result deleteContentByIds(Long ids) {
        Integer num = contentServiceFeign.deleteContentByIds(ids);
        if (num != null) {
            return Result.ok();
        }
        return Result.error("删除失败");
    }
}
