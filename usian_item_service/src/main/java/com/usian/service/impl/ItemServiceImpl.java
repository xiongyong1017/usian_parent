package com.usian.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.usian.mapper.TbItemMapper;
import com.usian.pojo.TbItem;
import com.usian.service.ItemService;
import com.usian.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * service接口实现类
 *
 * @author : xy1201
 * @version 1.0
 * @date : 2021/4/7 21:16
 */
@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    /**
     * @Date: 2021/4/7 21:32
     * 注入mapper
     */
    @Autowired
    private TbItemMapper tbItemMapper;

    @Override
    public TbItem selectItemInfo(Long itemId) {
        return tbItemMapper.selectItemInfo(itemId);
    }

    /**
     * 查询所有商品，并分页。
     *
     * @param page
     * @param rows
     * @return
     */
    @Override
    public PageResult selectTbItemAllByPage(Integer page, Integer rows) {
        /**
         * @Date: 2021/4/8 20:40
         * Step 1: 开启分页
         */
        PageHelper.startPage(page, rows);
        /**
         * @Date: 2021/4/8 20:40
         * Step 2: 查询数据库
         */
        List<TbItem> tbItemList = this.tbItemMapper.selectTbItemAllByPage();
        /**
         * @Date: 2021/4/8 20:42
         * Step 3: 将查询结果封装成pageinfo
         */
        PageInfo<TbItem> pageInfo = new PageInfo<>(tbItemList);
        /**
         * @Date: 2021/4/8 20:43
         * Step 4: 封装pageresult并返回
         */
        return new PageResult(pageInfo.getPageNum(), Long.valueOf(pageInfo.getTotal()), pageInfo.getList());
    }
}
