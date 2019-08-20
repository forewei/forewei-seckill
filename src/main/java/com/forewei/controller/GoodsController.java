package com.forewei.controller;

import com.forewei.result.HttpResult;
import com.forewei.service.SeckillGoodsService;
import com.forewei.vo.GoodsVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author forewei
 * @date 2019-8-19 13:09
 */
@Api(tags = "商品相关")
@RestController
@RequestMapping(value = "/goods")
public class GoodsController {
    @Autowired
    private SeckillGoodsService seckillGoodsService;

    @ApiOperation("查询秒杀商品列表")
    @GetMapping("/seckill")
    public HttpResult<List<GoodsVo>> getSeckillGoods(HttpServletRequest httpRequest, HttpServletRequest httpResponse) {
        return HttpResult.success(seckillGoodsService.listGoodsVo());
    }
}
