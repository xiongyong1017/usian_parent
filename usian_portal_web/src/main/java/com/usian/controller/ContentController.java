package com.usian.controller;

import com.usian.feign.ContentServiceFeign;
import com.usian.utils.AdNode;
import com.usian.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : xy1201
 * @version 1.0
 * @date : 2021/4/20 14:26
 */

@RestController
@RequestMapping("/frontend/content")
public class ContentController {
    @Autowired
    private ContentServiceFeign contentServiceFeign;

    /**
     * 查询首页大广告位
     */
    @RequestMapping("/selectFrontendContentByAD")
    public Result selectFrontendContentByAD() {
        List<AdNode> list = contentServiceFeign.selectFrontendContentByAD();
        if (list != null && list.size() > 0) {
            return Result.ok(list);
        }
        return Result.error("查无结果");
    }
}
