package com.usian.controller;

import com.usian.pojo.SearchItem;
import com.usian.service.SearchItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @author : xy1201
 * @version 1.0
 * @date : 2021/4/26 14:12
 */

@RestController
@RequestMapping("/service/searchItem")
public class SearchItemController {

    @Autowired
    private SearchItemService searchItemService;

    /**
     * @return : boolean
     * @Description : 导入到信息库
     * @Param : []
     * @Author : xy
     * @Date : 2021/4/26 14:14
     */
    @RequestMapping("/importAll")
    public Boolean importAll() {
        return searchItemService.importAll();
    }

    @RequestMapping("/list")
    /**
     * @Description : 搜索商品
     * @Param : [q, page, pageSize]
     * @return : List<SearchItem>
     * @Author : xy
     * @Date : 2021/4/26 14:27
     */
    public List<SearchItem> selectByq(String q, Long page, Integer pageSize)
            throws IOException {
        return searchItemService.selectByQ(q, page, pageSize);
    }
}