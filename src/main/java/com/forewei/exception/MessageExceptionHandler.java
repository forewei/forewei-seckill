package com.forewei.exception;

import com.forewei.result.HttpResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 自定义全局异常拦截器
 *
 * @Date: Create By on 2019/8/7
 * @Author: forewei
 * @Email: forewei2015@gmail.com
 */
@ControllerAdvice
@ResponseBody
public class MessageExceptionHandler {

    @ExceptionHandler(value = MessageException.class)//拦截自定义异常
    public HttpResult<String> exceptionHandler(Exception e) {
        e.printStackTrace();
        MessageException ex = (MessageException) e;
        return HttpResult.error(ex.getErrorCode());
    }
}
