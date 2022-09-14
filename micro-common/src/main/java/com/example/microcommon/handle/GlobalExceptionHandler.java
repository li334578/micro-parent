package com.example.microcommon.handle;

import com.example.microcommon.bean.Result;
import com.example.microcommon.bean.ResultMsgEnum;
import com.example.microcommon.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Date 14/9/2022 0014 上午 10:58
 * @Description 全局异常处理
 * @Version 1.0.0
 * @Author liwenbo
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public Result handleServiceException(ServiceException e) {
        return Result.error(ResultMsgEnum.FAIL.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        log.info(e.getMessage());
        return Result.error(ResultMsgEnum.FAIL.getCode(), "服务器内部错误");
    }
}
