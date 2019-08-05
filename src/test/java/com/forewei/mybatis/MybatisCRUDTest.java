package com.forewei.mybatis;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.forewei.entity.Goods;
import com.forewei.mapper.GoodsMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Date: Create By on 2019/8/5
 * @Author: forewei
 * @Email: forewei2015@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.forewei.mapper")
public class MybatisCRUDTest {

    @Autowired
    GoodsMapper goodsMapper;

    @Test
    public void ListTest() {
        System.out.println(goodsMapper.selectList(new QueryWrapper<Goods>()));
    }
}
