package com.usian.service.impl;

import com.usian.config.RedisConfig;
import com.usian.mapper.TbItemCatMapper;
import com.usian.pojo.TbItemCat;
import com.usian.service.ItemCategoryService;
import com.usian.utils.CatNode;
import com.usian.utils.CatResult;
import com.usian.redis.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : xy1201
 * @version 1.0
 * @date : 2021/4/8 21:04
 */
@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {
    /**
     * @Date: 2021/4/8 21:05
     * 注入TbItemCatMapper
     */
    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    @Value("${PROTAL_CATRESULT_KEY}")
    private String PROTAL_CATRESULT_KEY;

    @Autowired
    private RedisClient redisClient;

    /**
     * @return : java.util.List<com.usian.pojo.TbItemCat>
     * @Description : 根据分类ID查询子节点
     * @Param : [id]
     * @Author : xy
     * @Date : 2021/4/8 21:11
     */
    @Override
    public List<TbItemCat> selectItemCategoryByParentId(Long id) {
        return tbItemCatMapper.selectItemCategoryByParentId(id);
    }

    /**
     * @return : com.usian.utils.CatResult
     * @Description : 查询首页商品分类
     * @Param : []
     * @Author : xy
     * @Date : 2021/4/19 19:43
     */
    @Override
    public CatResult selectItemCategoryAll() {
         //查询缓存
         CatResult catResultRedis = (CatResult) redisClient.get(PROTAL_CATRESULT_KEY);
        if (catResultRedis != null) {
            return catResultRedis;
        }
        CatResult catResult = new CatResult();
        System.out.println("hahaha");
        //查询商品分类
        catResult.setData(getCatList(0L));
        // //添加到缓存
        redisClient.set(PROTAL_CATRESULT_KEY, catResult);
        return catResult;
    }

    /**
     * 私有方法，查询商品分类
     */
    private List<?> getCatList(Long parentId) {
        /**
         * @Date: 2021/4/19 19:54
         * Step 1: 根据分类ID查询子节点
         */
        List<TbItemCat> list = this.tbItemCatMapper.selectItemCategoryByParentId(parentId);
        /**
         * @Date: 2021/4/19 19:55
         * Step 2: 创建局部变量
         */
        List resultList = new ArrayList();
        int count = 0;
        /**
         * @Date: 2021/4/19 19:55
         * Step 3: 遍历集合
         */
        for (TbItemCat tbItemCat : list) {
            //判断是否是父节点
            if (tbItemCat.getIsParent()) {
                CatNode catNode = new CatNode();
                catNode.setName(tbItemCat.getName());
                catNode.setItem(getCatList(tbItemCat.getId()));
                resultList.add(catNode);
                count++;
                //只取商品分类中的 18 条数据
                if (count == 18) {
                    //跳出循环
                    break;
                }
            } else {
                resultList.add(tbItemCat.getName());
            }
        }
        return resultList;
    }
}
