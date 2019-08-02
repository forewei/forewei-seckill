package com.forewei.entity;

import lombok.Data;

/**
 * 商品实体类
 *
 * @Date: Create By on 2019/8/2
 * @Author: forewei
 * @Email: forewei2015@gmail.com
 */
@Data
public class Goods {
    /**
     * 主键
     */
    private Long id;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品标题
     */
    private String goodsTitle;

    /**
     * 商品图片
     */
    private String goodsImg;

    /**
     * 商品详情
     */
    private String goodsDetail;

    /**
     * 商品价格
     */
    private Double goodsPrice;

    /**
     * 商品库存
     */
    private Integer goodsStock;
}
