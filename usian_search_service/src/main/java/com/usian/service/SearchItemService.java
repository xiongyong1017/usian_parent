package com.usian.service;

import com.usian.pojo.SearchItem;

import java.io.IOException;
import java.util.List;

/**
 * @author : xy1201
 * @version 1.0
 * @date : 2021/4/26 14:13
 */
public interface SearchItemService {
    Boolean importAll();

    List<SearchItem> selectByQ(String q, Long page, Integer pageSize);

    int insertDocument(String itemId) throws IOException;
}
