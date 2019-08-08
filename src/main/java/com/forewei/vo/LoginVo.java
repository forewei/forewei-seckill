package com.forewei.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @Date: Create By on 2019/8/7
 * @Author: forewei
 * @Email: forewei2015@gmail.com
 */
@Data
@Accessors(chain = true)
public class LoginVo {

    @NotNull
    @Pattern(regexp = "^1[3|4|5|7|8][0-9]\\d{8}$", message = "手机号格式不正确")
    @ApiModelProperty("手机号")
    private String mobile;

    @NotNull
    @ApiModelProperty("密码")
    private String password;
}
