package com.usian.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.usian.mapper.TbItemCatMapper;
import com.usian.mapper.TbItemDescMapper;
import com.usian.mapper.TbItemMapper;
import com.usian.mapper.TbItemParamMapper;
import com.usian.pojo.*;
import com.usian.service.ItemService;
import com.usian.utils.IDUtils;
import com.usian.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private TbItemDescMapper tbItemDescMapper;

    @Autowired
    private TbItemParamMapper tbItemParamMapper;

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

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
        PageHelper.startPage(page, 10);
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

    /**
     * @return : java.lang.Integer
     * @Description :添加商品业务层(除添加商品表，还需补全商品描述)
     * @Param : [tbItem, desc, itemParams]
     * @Author : xy
     * @Date : 2021/4/12 11:56
     */
    @Override
    public Integer insertTbItem(TbItem tbItem, String desc, String itemParams) {
        /**
         * @Date: 2021/4/12 14:20
         * Step 0: 定义时间的全局变量。表示当前时间
         */
        Date date = new Date();
        /**
         * @Date: 2021/4/12 14:03
         * Step 1: 添加商品表信息，并返回主键ID(tb_item表)
         */
        Long itemId = IDUtils.genItemId();
        tbItem.setId(itemId);
        Integer tbItemNum = tbItemMapper.insertTbItem(tbItem);
        //TODO 商品描述未添加，param未添加，只添加了item表的参数信息(后两布也写了，没测==测了好使)
        /**
         * @Date: 2021/4/12 14:04
         * Step 2: 添加商品描述(tb_item_desc表)
         */
        Integer tbItemDescNum = tbItemDescMapper.insertDesc(new TbItemDesc(itemId, date, date, desc));
        /**
         * @Date: 2021/4/12 14:15
         * Step 3: 添加商品规格信息(tb_item_param_item表)
         */
        Integer tbItemParamItemNum = tbItemParamMapper.insertParam(new TbItemParam(null, itemId, date, date, itemParams));
        return tbItemNum + tbItemDescNum + tbItemParamItemNum;
    }

    @Override
    public Map<String, Object> preUpdateItem(Long itemId) {
        /**
         * @Date: 2021/4/12 15:21
         * Step 0: 新建一个hashmap，用于存放查询到的数据
         */
        HashMap<String, Object> map = new HashMap<>();
        /**
         * @Date: 2021/4/12 15:22
         * Step 1: 根据商品ID查询商品,将结果放到map中
         */
        TbItem item = this.tbItemMapper.queryByItemId(itemId);
        map.put("item", item);
        /**
         * @Date: 2021/4/12 15:23
         * Step 2: 根据商品ID查询商品描述,将结果放到map中
         */
        TbItemDesc desc = this.tbItemDescMapper.queryByItemId(itemId);
        map.put("itemDesc", desc.getItemDesc());
        /**
         * @Date: 2021/4/12 15:24
         * Step 3: 根据商品ID查询商品类目,将结果放到map中
         */
        TbItemCat cat = this.tbItemCatMapper.queryByItemId(item.getCid());
        map.put("itemCat", cat.getName());
        /**
         * @Date: 2021/4/12 15:27
         * Step 4: 根据商品ID查询商品规格信息,判空之后，将结果放到map中
         */
        List<TbItemParamItem> paramItems = this.tbItemParamMapper.queryByItemId(itemId);
        if (paramItems != null && paramItems.size() > 0) {
            map.put("itemParamItem", paramItems.get(0).getParamData());
        }
        /**
         * @Date: 2021/4/12 15:33
         * Step 5: 返回结果
         */
        return map;
    }
}
