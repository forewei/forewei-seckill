package com.forewei.enums;

/**
 * “错误码”的枚举值。
 *
 * @Date: Create By on 2019/8/7
 * @Author: forewei
 * @Email: forewei2015@gmail.com
 */
public enum ErrorCode {

    SERVER_ERROR(500, "服务端异常");


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
