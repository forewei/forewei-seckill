package com.forewei.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 订单信息实体
 *
 * @Date: Create By on 2019/8/2
 * @Author: forewei
 * @Email: forewei2015@gmail.com
 */
@Data
@TableName("t_order_info")
public class OrderInfo {
    /**
     * 主键id
     */
    @TableId("id")
    private Long id;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 商品id
     */
    @TableField("goods_id")
    private Long goodsId;

    /**
     * 收货地址id
     */
    @TableField("delivery_addr_id")
    private Long deliveryAddrId;

    /**
     * 商品名称
     */
    @TableField("goods_name")
    private String goodsName;

    /**
     * 商品数量
     */
    @TableField("goods_count")
    private Integer goodsCount;

    /**
     * 商品价格
     */
    @TableField("goods_price")
    private Double goodsPrice;

    /**
     * 订单聚到 1-web 2-android 3-ios
     */
    @TableField("order_channel")
    private Integer orderChannel;

    /**
     * 订单状态 0-未支付，1-已支付，2-已发货，3-已收货，4-已退款，5-已完成
     */
    @TableField("status")
    private Integer status;

    /**
     * 订单创建时间
     */
    @TableField("create_date")
    private Date createDate;

    /**
     * 支付时间
     */
    @TableField("pay_date")
    private Date payDate;

}
