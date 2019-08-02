package com.forewei.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @Date: Create By on 2019/8/2
 * @Author: forewei
 * @Email: forewei2015@gmail.com
 */
@Data
@Accessors(chain = true)
public class User {
    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户密码 MD5(MD5(pass明文+固定salt)+salt
     */
    private String password;

    /**
     * 混淆值
     */
    private String salt;

    /**
     * 头像链接
     */
    private String headImgUrl;

    /**
     * 注册时间
     */
    private Date registerDate;

    /**
     * 最后登录时间
     */
    private Date lastLoginDate;

    /**
     * 登录次数
     */
    private Integer loginCount;
}
