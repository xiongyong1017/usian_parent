package com.usian.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.usian.mapper.TbContentMapper;
import com.usian.pojo.TbContent;
import com.usian.redis.RedisClient;
import com.usian.service.ContentService;
import com.usian.utils.AdNode;
import com.usian.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : xy1201
 * @version 1.0
 * @date : 2021/4/19 10:42
 */
@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private TbContentMapper tbContentMapper;

    @Value("${AD_CATEGORY_ID}")
    private Long AD_CATEGORY_ID;

    @Value("${AD_HEIGHT}")
    private Integer AD_HEIGHT;

    @Value("${AD_WIDTH}")
    private Integer AD_WIDTH;

    @Value("${AD_HEIGHTB}")
    private Integer AD_HEIGHTB;

    @Value("${AD_WIDTHB}")
    private Integer AD_WIDTHB;

    @Value("${PORTAL_AD_KEY}")
    private String PORTAL_AD_KEY;

    @Autowired
    private RedisClient redisClient;


    /**
     * @return : com.usian.utils.PageResult
     * @Description : 根据分类ID分页查询分类信息
     * @Param : [page, rows, categoryId]
     * @Author : xy
     * @Date : 2021/4/19 10:46
     */
    @Override
    public PageResult selectTbContentAllByCategoryId(Integer page, Integer rows, Long categoryId) {
        /**
         * @Date: 2021/4/19 10:48
         * Step 1: 开启分页
         */
        PageHelper.startPage(page, rows);
        /**
         * @Date: 2021/4/19 10:48
         * Step 2: 根据分类ID查询结果，保存到list中
         */
        List<TbContent> list = this.tbContentMapper.selectTbContentAllByCategoryId(categoryId);
        /**
         * @Date: 2021/4/19 10:49
         * Step 3: 将结果封装在pageinfo中
         */
        PageInfo<TbContent> pageInfo = new PageInfo<>(list);
        /**
         * @Date: 2021/4/19 10:50
         * Step 4: 将结果封装在pageresult中并返回
         */
        return new PageResult(pageInfo.getPageNum(), pageInfo.getTotal(), pageInfo.getList());
    }

    /**
     * @return : java.lang.Integer
     * @Description : 添加当前分类信息
     * @Param : [tbContent]
     * @Author : xy
     * @Date : 2021/4/19 17:13
     */
    @Override
    public Integer insertTbContent(TbContent tbContent) {
        Integer num = this.tbContentMapper.insertTbContent(tbContent);
        //缓存同步
        redisClient.hdel(PORTAL_AD_KEY, AD_CATEGORY_ID.toString());
        return num;
    }

    /**
     * @return : java.lang.Integer
     * @Description : 删除分类的内容
     * @Param : [id]
     * @Author : xy
     * @Date : 2021/4/19 17:22
     */
    @Override
    public Integer deleteContentByIds(Long id) {
        Integer num = this.tbContentMapper.deleteContentByIds(id);
        //缓存同步
        redisClient.hdel(PORTAL_AD_KEY, AD_CATEGORY_ID.toString());
        return num;
    }

    /**
     * @return : java.util.List<com.usian.utils.AdNode>
     * @Description : 查询首页大广告
     * @Param : []
     * @Author : xy
     * @Date : 2021/4/20 14:30
     */
    @Override
    public List<AdNode> selectFrontendContentByAD() {
        //查询缓存
        List<AdNode> adNodeListRedis = (List<AdNode>) redisClient.hget(PORTAL_AD_KEY, AD_CATEGORY_ID.toString());
        if (adNodeListRedis != null) {
            return adNodeListRedis;
        }
        // 查询TbContent(数据库)
        List<TbContent> tbContentList = tbContentMapper.selectFrontendContentByAD(AD_CATEGORY_ID);
        List<AdNode> adNodeList = new ArrayList<AdNode>();
        for (TbContent tbContent : tbContentList) {
            AdNode adNode = new AdNode();
            adNode.setSrc(tbContent.getPic());
            adNode.setSrcB(tbContent.getPic2());
            adNode.setHref(tbContent.getUrl());
            adNode.setHeight(AD_HEIGHT);
            adNode.setWidth(AD_WIDTH);
            adNode.setHeightB(AD_HEIGHTB);
            adNode.setWidthB(AD_WIDTHB);
            adNodeList.add(adNode);
        }
        //添加到缓存
        redisClient.hset(PORTAL_AD_KEY, AD_CATEGORY_ID.toString(), adNodeList);
        return adNodeList;
    }
}
