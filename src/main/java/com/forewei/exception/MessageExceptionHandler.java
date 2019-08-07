package com.forewei.exception;

import com.forewei.enums.ErrorCode;
import com.forewei.result.HttpResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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

    @ExceptionHandler(value = Exception.class)//拦截所有异常
    public HttpResult<String> exceptionHandler(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        if (e instanceof MessageException) {
            MessageException ex = (MessageException) e;
            return HttpResult.error(ex.getErrorCode());
        }else {
            return HttpResult.error(ErrorCode.SERVER_ERROR);
        }

    }
}
