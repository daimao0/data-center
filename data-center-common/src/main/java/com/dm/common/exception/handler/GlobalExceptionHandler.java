package com.dm.common.exception.handler;

import com.dm.common.api.Response;
import com.dm.common.api.ResponseCode;
import com.dm.common.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;


/**
 * 全局异常处理
 *
 * @author daimao
 * @date 2022/8/5 23:12
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 默认异常处理
     *
     * @param e 异常
     * @return 异常处理
     */
    @ExceptionHandler(BaseException.class)
    public Response<String> defaultExceptionHandler(BaseException e) {
        log.error("Catch base exception", e);
        return Response.failed(e.getResponseCode(), e.getMessage());
    }

    /**
     * validation 下的参数检验异常 BindException
     */
    @ExceptionHandler(BindException.class)
    public Response<String> bindExceptionHandler(BindException e) {
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        StringBuilder message = new StringBuilder();
        allErrors.forEach(error -> message.append(error.getDefaultMessage()).append(";"));
        return Response.failed(ResponseCode.VALIDATE_FAILED, message.toString());
    }

}
