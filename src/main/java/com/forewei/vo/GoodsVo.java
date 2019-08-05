package com.forewei.vo;

import com.forewei.entity.Goods;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @Date: Create By on 2019/8/5
 * @Author: forewei
 * @Email: forewei2015@gmail.com
 */
@Data
@Accessors(chain = true)
public class GoodsVo extends Goods {
    private Double seckillPrice;
    private Integer stockCount;
    private Date startDate;
    private Date endDate;
    private Integer version;
}
