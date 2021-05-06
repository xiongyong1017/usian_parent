package com.usian.feign;

import com.usian.pojo.SearchItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 搜索的feign接口
 *
 * @author : xy1201
 * @version 1.0
 * @date : 2021/4/26 14:09
 */
@FeignClient("usian-search-service")
public interface SearchItemFeign {
    @RequestMapping("/service/searchItem/importAll")
    Boolean importAll();

    @RequestMapping("/service/searchItem/list")
    List<SearchItem> selectByq(@RequestParam String q, @RequestParam Long page,
                               @RequestParam Integer pageSize);
}
