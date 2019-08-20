package com.forewei.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.forewei.entity.Goods;
import com.forewei.entity.SeckillGoods;
import com.forewei.mapper.GoodsMapper;
import com.forewei.mapper.SeckillGoodsMapper;
import com.forewei.util.BeanObjectUtils;
import com.forewei.vo.GoodsVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author forewei
 * @date 2019-8-19 12:51
 */
@Service
public class SeckillGoodsService {

    @Autowired
    private SeckillGoodsMapper seckillGoodsMapper;

    @Autowired
    private GoodsMapper goodsMapper;


    /**
     * 查询秒杀商品列表
     *
     * @return
     */
    public List<GoodsVo> listGoodsVo() {
        List<GoodsVo> result = new ArrayList<>();
        List<SeckillGoods> seckillGoods = seckillGoodsMapper.selectList(new QueryWrapper<>());
        if (seckillGoods != null && seckillGoods.size() > 0) {
            Map<Long, SeckillGoods> seckillGoodsMap = seckillGoods.stream().collect(Collectors.toMap(SeckillGoods::getGoodsId, f -> f));
            List<Goods> goods = goodsMapper.selectBatchIds(seckillGoodsMap.keySet());
            goods.forEach(f -> {
                SeckillGoods sgoods = seckillGoodsMap.get(f.getId());
                if (sgoods != null) {
                    GoodsVo goodsVo = new GoodsVo();
                    goodsVo = BeanObjectUtils.copyTo(f, GoodsVo.class);
                    BeanUtils.copyProperties(sgoods, goodsVo);
                    result.add(goodsVo);
                }
            });
        }
        return result;
    }
}
