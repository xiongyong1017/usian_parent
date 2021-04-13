package com.usian.service.impl;

import com.usian.mapper.TbItemParamMapper;
import com.usian.pojo.TbItem;
import com.usian.pojo.TbItemParam;
import com.usian.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
