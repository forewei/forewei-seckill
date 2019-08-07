package com.forewei.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableId("id")
    private Long id;

    /**
     * 用户昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 用户密码 MD5(MD5(pass明文+固定salt)+salt
     */
    @TableField("password")
    private String password;

    /**
     * 混淆值
     */
    @TableField("salt")
    private String salt;

    /**
     * 头像链接
     */
    @TableField("head_img_url")
    private String headImgUrl;

    /**
     * 注册时间
     */
    @TableField("register_date")
    private Date registerDate;

    /**
     * 最后登录时间
     */
    @TableField("last_login_date")
    private Date lastLoginDate;

    /**
     * 登录次数
     */
    @TableField("login_count")
    private Integer loginCount;
}
