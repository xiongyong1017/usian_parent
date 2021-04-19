package com.usian.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.usian.mapper.TbItemParamMapper;
import com.usian.pojo.TbItem;
import com.usian.pojo.TbItemParam;
import com.usian.service.ItemParamService;
import com.usian.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author : xy1201
 * @version 1.0
 * @date : 2021/4/13 10:49
 */
@Service
public class ItemParamServiceImpl implements ItemParamService {
    @Autowired
    private TbItemParamMapper tbItemParamMapper;

    @Override
    public TbItemParam selectItemParamByItemCatId(Long itemCatId) {
        /**
         * @Date: 2021/4/13 10:57
         * Step 1: 查询模板集合
         */
        List<TbItemParam> list = tbItemParamMapper.selectItemParamByItemCatId(itemCatId);
        /**
         * @Date: 2021/4/13 10:58
         * Step 2: 取集合中的0号元素
         */
        if (list.size() > 0 && list != null) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public PageResult selectItemParamAll(Integer page, Integer rows) {
        /**
         * @Date: 2021/4/16 7:59
         * Step 1: 开启分页插件
         */
        PageHelper.startPage(page, rows);
        /**
         * @Date: 2021/4/16 7:59
         * Step 2: 查询结果，保存到集合中
         */
        List<TbItemParam> list = tbItemParamMapper.selectItemParamAll();
        /**
         * @Date: 2021/4/16 8:01
         * Step 3: 将list保存到pageinfo中
         */
        PageInfo<TbItemParam> pageInfo = new PageInfo<>(list);
        /**
         * @Date: 2021/4/16 8:02
         * Step 4: 封装到pageresult中返回分页查询的结果
         */
        return new PageResult(pageInfo.getPageNum(), pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    /**
     * @Description : 添加商品规格模板业务层
     * @Param : [itemCatId, paramData]
     * @return : java.lang.Integer
     * @Author : xy
     * @Date : 2021/4/16 15:40
     */
    public Integer insertItemParam(Long itemCatId, String paramData) {
        /**
         * @Date: 2021/4/16 15:44
         * Step 1: 判断该类别是否有规格模板
         */
        List<TbItemParam> tbItemParamList = tbItemParamMapper.selectItemParamByItemCatId(itemCatId);
        if (!tbItemParamList.isEmpty()) {
            //直接跳出方法，返回结果0，表示当前的类别已经存在模板
            return 0;
        }
        /**
         * @Date: 2021/4/16 15:47
         * Step 2: 保存规格模板
         */
        TbItemParam tbItemParam = new TbItemParam(null, itemCatId, new Date(), new Date(), paramData);
        return tbItemParamMapper.insertItemParam(tbItemParam);
    }

    @Override
    /**
     * @Description : 删除模板信息业务层
     * @Param : [itemCatId]
     * @return : java.lang.Integer
     * @Author : xy
     * @Date : 2021/4/16 16:06
     */
    public Integer deleteItemParamById(Long itemCatId) {
        return this.tbItemParamMapper.deleteItemParamById(itemCatId);
    }
}
