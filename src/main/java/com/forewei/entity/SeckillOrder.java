package com.forewei.entity;

import lombok.Data;

/**
 * 秒杀订单信息
 *
 * @Date: Create By on 2019/8/2
 * @Author: forewei
 * @Email: forewei2015@gmail.com
 */
@Data
public class SeckillOrder {
    /**
     * 秒杀订单id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 商品id
     */
    private Long goodsId;
}
