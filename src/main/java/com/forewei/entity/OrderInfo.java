package com.forewei.entity;

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
public class OrderInfo {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 商品id
     */
    private Long goodsId;

    /**
     * 收货地址id
     */
    private Long deliveryAddrId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品数量
     */
    private Integer goodsCount;

    /**
     * 商品价格
     */
    private Double goodsPrice;

    /**
     * 订单聚到 1-web 2-android 3-ios
     */
    private Integer orderChannel;

    /**
     * 订单状态 0-未支付，1-已支付，2-已发货，3-已收货，4-已退款，5-已完成
     */
    private Integer status;

    /**
     * 订单创建时间
     */
    private Date createDate;

    /**
     * 支付时间
     */
    private Date payDate;

}
