package com.forewei.interceptors;

import com.forewei.consts.CacheKeyConst;
import com.forewei.entity.User;
import com.forewei.enums.ErrorCode;
import com.forewei.exception.MessageException;
import com.forewei.service.UserService;
import com.forewei.util.RedisCacheUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 系统用户登录拦截器
 *
 * @Author forewei
 * @date 2019-8-19 17:28
 */
@Component
public class SysUserLoginInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 放开option请求
        if (request.getMethod().equals(RequestMethod.OPTIONS.name())) {
            return true;
        }
        Cookie cookie = WebUtils.getCookie(request, "token");
        if (cookie == null || StringUtils.isEmpty(cookie.getValue())) {
            throw new MessageException(ErrorCode.USER_LOGIN_ERROR);
        }
        //从缓存验证并更新
        User user = userService.getByToken(response, cookie.getValue());
        if (StringUtils.isEmpty(user)) {
            throw new MessageException(ErrorCode.USER_LOGIN_ERROR);
        }
        return true;
    }

}
