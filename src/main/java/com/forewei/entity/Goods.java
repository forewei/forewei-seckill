package com.forewei.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 商品实体类
 *
 * @Date: Create By on 2019/8/2
 * @Author: forewei
 * @Email: forewei2015@gmail.com
 */
@Data
@TableName("t_goods")
public class Goods {
    /**
     * 主键
     */
    @TableId("id")
    private Long id;

    /**
     * 商品名称
     */
    @TableField("goods_name")
    private String goodsName;

    /**
     * 商品标题
     */
    @TableField("goods_title")
    private String goodsTitle;

    /**
     * 商品图片
     */
    @TableField("goods_img")
    private String goodsImg;

    /**
     * 商品详情
     */
    @TableField("goods_detail")
    private String goodsDetail;

    /**
     * 商品价格
     */
    @TableField("goods_price")
    private Double goodsPrice;

    /**
     * 商品库存
     */
    @TableField("goods_stock")
    private Integer goodsStock;
}
