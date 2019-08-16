package com.forewei.controller;

import com.forewei.result.HttpResult;
import com.forewei.service.UserService;
import com.forewei.vo.LoginVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @Date: Create By on 2019/8/7
 * @Author: forewei
 * @Email: forewei2015@gmail.com
 */
@Api(tags = "用户相关")
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    @ApiOperation(value = "登录")
    public HttpResult<String> login(HttpServletResponse response, @Valid @RequestBody LoginVo vo) {
        return HttpResult.success(userService.login(response, vo));
    }
}
