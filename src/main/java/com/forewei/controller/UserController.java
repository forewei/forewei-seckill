package com.forewei.controller;

import com.forewei.result.HttpResult;
import com.forewei.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: Create By on 2019/8/7
 * @Author: forewei
 * @Email: forewei2015@gmail.com
 */
@Api(tags = "用户相关")
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    @ApiOperation(value = "测试接口", httpMethod = "GET")
    public HttpResult<String> test() {
        userService.test();
        return HttpResult.success("dasda");
    }
}
