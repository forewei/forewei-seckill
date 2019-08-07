package com.forewei.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 秒杀订单信息
 *
 * @Date: Create By on 2019/8/2
 * @Author: forewei
 * @Email: forewei2015@gmail.com
 */
@Data
@TableName(value = "t_seckill_order")
public class SeckillOrder {
    /**
     * 秒杀订单id
     */
    @TableId("id")
    private Long id;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 订单id
     */
    @TableField("order_id")
    private Long orderId;

    /**
     * 商品id
     */
    @TableField("goods_id")
    private Long goodsId;
}
