package com.forewei.enums;

/**
 * “错误码”的枚举值。
 *
 * @Date: Create By on 2019/8/7
 * @Author: forewei
 * @Email: forewei2015@gmail.com
 */
public enum ErrorCode {

    USER_LOGIN_ERROR(403,"登录失效"),
    SERVER_ERROR(500, "服务端异常"),
    PARAMETER_ERROR(10001, "请求参数异常"),
    USER_NOT_EXIST(50001, "账号不存在"),
    PASSWORD_ERROR(50002, "密码错误");



    private int errorCode;

    private String errorDesc;

    private String[] args;

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    ErrorCode(int errorCode, String errorDesc) {
        this(errorCode, errorDesc, null);
    }

    ErrorCode(int errorCode, String errorDesc, String[] args) {
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
        this.args = args;
    }

}
