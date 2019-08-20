package com.forewei.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 秒杀商品信息
 *
 * @Date: Create By on 2019/8/2
 * @Author: forewei
 * @Email: forewei2015@gmail.com
 */
@Data
@TableName("t_seckill_goods")
public class SeckillGoods {
    /**
     * 秒杀商品id
     */
    @TableId("id")
    private Long id;

    /**
     * 商品id
     */
    @TableField("goods_id")
    private Long goodsId;


    /**
     * 秒杀金额
     */
    @TableField("seckill_price")
    private Double seckillPrice;

    /**
     * 库存数量
     */
    @TableField("stock_count")
    private Integer stockCount;

    /**
     * 开始时间
     */
    @TableField("start_date")
    private Date startDate;

    /**
     * 结束时间
     */
    @TableField("end_date")
    private Date endDate;

    /**
     * 版本号
     */
    @TableField("version")
    private int version;
}
