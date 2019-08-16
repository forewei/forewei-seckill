package com.forewei.service;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.forewei.SeckillApplication;
import com.forewei.component.RedisComponent;
import com.forewei.consts.CacheKeyConst;
import com.forewei.entity.User;
import com.forewei.enums.ErrorCode;
import com.forewei.exception.MessageException;
import com.forewei.mapper.UserMapper;
import com.forewei.util.MD5Util;
import com.forewei.util.UUIDUtil;
import com.forewei.vo.LoginVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Date: Create By on 2019/8/7
 * @Author: forewei
 * @Email: forewei2015@gmail.com
 */
@Service
public class UserService {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private RedisComponent redisComponent;

    @Autowired
    private UserMapper userMapper;

    public static final String TOKEN = "token";

    public static final int TOKEN_EXPIRE = 3600 * 24 * 2;//默认两天

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
        String calcPass = MD5Util.inputPassToDbPass(formPass, saltDB);
        if (!calcPass.equals(dbPass)) {
            throw new MessageException(ErrorCode.PASSWORD_ERROR);
        }
        //生成唯一id作为token
        String token = UUIDUtil.uuid();
        updateLoginInfo(user);
        addCookie(response, token, user);
        return token;
    }

    /**
     * 登录信息更新
     *
     * @param user
     */
    private void updateLoginInfo(User user) {
        LOGGER.info("用户：%s登录成功", user.getId());
        user.setLoginCount(user.getLoginCount() + 1);
        user.setLastLoginDate(new Date());
        userMapper.updateById(user);
    }

    /**
     * 根据id 获取用户
     *
     * @param id
     * @return
     */
    public User getById(long id) {
        //对象缓存
        User user = (User)redisComponent.get(CacheKeyConst.T_USER_CACHE + id);
        if (user != null) {
            return user;
        }
        //取数据库
        user = userMapper.selectById(id);
        //再存入缓存
        if (user != null) {
            redisComponent.set(CacheKeyConst.T_USER_CACHE + id, user);
        }
        return user;
    }

    public Object getByToken(HttpServletResponse response, String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        User user = redisComponent.get(CacheKeyConst.TOKEN + token);
        //延长有效期，有效期等于最后一次操作+有效期
        if (user != null) {
            addCookie(response, token, user);
        }
        return user;
    }

    /**
     * 将toke作为key, User作为value存入redis 模拟session
     *
     * @param response
     * @param token
     * @param user
     */
    private void addCookie(HttpServletResponse response, String token, User user) {
        redisComponent.setExpire(CacheKeyConst.TOKEN + token, user, TOKEN_EXPIRE, TimeUnit.SECONDS);
        Cookie cookie = new Cookie(TOKEN, token);
        cookie.setMaxAge(TOKEN_EXPIRE);
        cookie.setPath("/");//设置为网站根目录
        response.addCookie(cookie);
    }
}

