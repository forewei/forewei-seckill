package com.forewei.mybatis;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.forewei.entity.Goods;
import com.forewei.mapper.GoodsMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Date: Create By on 2019/8/5
 * @Author: forewei
 * @Email: forewei2015@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisCRUDTest {

    @Autowired
    GoodsMapper goodsMapper;

    @Test
    public void ListTest() {
        System.out.println(("----- selectAll method test ------"));
        List<Goods> goods = goodsMapper.selectList(new QueryWrapper<Goods>());
        goods.forEach(System.out::println);

    }
}
