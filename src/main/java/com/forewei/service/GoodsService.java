package com.forewei.service;

import com.alibaba.druid.pool.DruidDataSource;
import com.forewei.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Date: Create By on 2019/8/5
 * @Author: forewei
 * @Email: forewei2015@gmail.com
 */
@Service
public class GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    DruidDataSource druidDataSource;

//    @PostConstruct
//    public void test() {
//        druidDataSource.
//        List<Goods> goods = goodsMapper.selectList(new QueryWrapper<Goods>());
//        for (Goods g : goods) {
//            System.out.println(g.getGoodsName());
//        }
//    }
}
