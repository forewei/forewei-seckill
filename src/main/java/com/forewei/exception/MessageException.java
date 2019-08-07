package com.forewei.exception;


import com.forewei.enums.ErrorCode;
import lombok.Getter;

/**
 * 全局异常消息处理
 *
 * @Date: Create By on 2019/8/7
 * @Author: forewei
 * @Email: forewei2015@gmail.com
 */
@Getter
public class MessageException extends RuntimeException {

    private static final long servialVersionUID = 1L;
    private ErrorCode errorCode;




    public MessageException(ErrorCode errorCode) {
        super(errorCode.getErrorDesc());
        this.errorCode = errorCode;
    }

    public ErrorCode getCodeMsg() {
        return errorCode;
    }


}
