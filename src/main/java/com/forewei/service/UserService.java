package com.forewei.service;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.forewei.component.RedisComponent;
import com.forewei.entity.User;
import com.forewei.enums.ErrorCode;
import com.forewei.exception.MessageException;
import com.forewei.mapper.UserMapper;
import com.forewei.util.MD5Util;
import com.forewei.util.UUIDUtil;
import com.forewei.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @Date: Create By on 2019/8/7
 * @Author: forewei
 * @Email: forewei2015@gmail.com
 */
@Service
public class UserService {

    @Autowired
    private RedisComponent redisComponent;

    @Autowired
    private UserMapper userMapper;

    public static final String TOKEN = "token";

    public static final int TOKEN_EXPIRE = 3600 * 24 * 2;//默认两天

    public void test() {

    }

    /**
     * 用户登陆
     *
     * @param response
     * @param loginVo
     * @return
     */
    public String login(HttpServletResponse response, LoginVo loginVo) {
        if (loginVo == null) {
            throw new MessageException(ErrorCode.PARAMETER_ERROR);
        }
        String mobile = loginVo.getMobile();
        String formPass = loginVo.getPassword();
        //判断用户是否存在
        User user = getById(Long.parseLong(mobile));
        if (user == null) {
            throw new MessageException(ErrorCode.USER_NOT_EXIST);
        }
        //验证密码
        String dbPass = user.getPassword();
        String saltDB = user.getSalt();
        String calcPass = MD5Util.formPassToDBPass(formPass, saltDB);
        if (!calcPass.equals(dbPass)) {
            throw new MessageException(ErrorCode.PASSWORD_ERROR);
        }
        //生成唯一id作为token
        String token = UUIDUtil.uuid();
        addCookie(response, token, user);
        return token;
    }

    private User getById(long mobile) {
        return userMapper.selectById(mobile);
    }

    public Object getByToken(HttpServletResponse response, String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        User user = redisComponent.get(token);
        //延长有效期，有效期等于最后一次操作+有效期
        if (user != null) {
            addCookie(response, token, user);
        }
        return user;
    }

    private void addCookie(HttpServletResponse response, String token, User user) {
        redisComponent.set(token, user);
        Cookie cookie = new Cookie(TOKEN, token);
        cookie.setMaxAge(TOKEN_EXPIRE);
        cookie.setPath("/");//设置为网站根目录
        response.addCookie(cookie);
    }
}

