package com.forewei.result;

import com.forewei.enums.ErrorCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 统一http返回值封装
 *
 * @Date: Create By on 2019/8/7
 * @Author: forewei
 * @Email: forewei2015@gmail.com
 */
@Getter
@Setter
public class HttpResult<T> {
    private int code;
    private String msg;
    private T result;

    /**
     * 成功时候的调用
     */
    public static <T> HttpResult<T> success(T t) {
        return new HttpResult<T>(t);
    }

    /**
     * 失败时候的调用
     */
    public static <T> HttpResult<T> error(ErrorCode errorCode) {
        return new HttpResult<T>(errorCode);
    }

    public HttpResult() {

    }

    private HttpResult(T t) {
        this.code = 200;
        this.msg = "success";
        this.result = t;
    }

    private HttpResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private HttpResult(ErrorCode errorCode) {
        if (errorCode != null) {
            this.code = errorCode.getErrorCode();
            this.msg = errorCode.getErrorDesc();
        }
    }
}
