package com.forewei.service;

import com.alibaba.druid.util.StringUtils;
import com.forewei.component.RedisComponent;
import com.forewei.entity.User;
import com.forewei.enums.ErrorCode;
import com.forewei.exception.MessageException;
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

    public static final String TOKEN = "token";

    public static final int TOKEN_EXPIRE = 3600 * 24 * 2;//默认两天

    public void test() {

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

