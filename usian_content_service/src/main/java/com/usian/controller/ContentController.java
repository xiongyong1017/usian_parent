package com.usian.controller;

import com.usian.pojo.TbContent;
import com.usian.service.ContentService;
import com.usian.utils.AdNode;
import com.usian.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 内容信息控制层
 *
 * @author : xy1201
 * @version 1.0
 * @date : 2021/4/19 10:40
 */
@RestController
@RequestMapping("/service/content")
public class ContentController {
    @Autowired
    private ContentService contentService;

    @RequestMapping("selectTbContentAllByCategoryId")
    /**
     * @Description : 根据分类ID查询内容信息
     * @Param : [page, rows, categoryId]
     * @return : com.usian.utils.PageResult
     * @Author : xy
     * @Date : 2021/4/19 10:47
     */
    public PageResult selectTbContentAllByCategoryId(@RequestParam Integer page,
                                                     @RequestParam Integer rows,
                                                     @RequestParam Long categoryId) {
        return this.contentService.selectTbContentAllByCategoryId(page, rows, categoryId);
    }

    /**
     * @return : java.lang.Integer
     * @Description : 添加内容信息
     * @Param : [tbContent]
     * @Author : xy
     * @Date : 2021/4/19 16:54
     */
    @RequestMapping("insertTbContent")
    public Integer insertTbContent(@RequestBody TbContent tbContent) {
        return this.contentService.insertTbContent(tbContent);
    }

    /**
     * @return : java.lang.Integer
     * @Description : 删除分类下的内容
     * @Param : [id]
     * @Author : xy
     * @Date : 2021/4/19 17:20
     */
    @RequestMapping("/deleteContentByIds")
    public Integer deleteContentByIds(@RequestParam Long id) {
        return this.contentService.deleteContentByIds(id);
    }

    /**
     * @return : List<AdNode>
     * @Description : 查询首页大广告位
     * @Param : []
     * @Author : xy
     * @Date : 2021/4/20 14:27
     */
    @RequestMapping("/selectFrontendContentByAD")
    public List<AdNode> selectFrontendContentByAD() {
        return this.contentService.selectFrontendContentByAD();
    }
}
