package com.hongsong.exception;

import com.hongsong.common.ResponseResult;
import com.hongsong.constant.HttpStatus;
import com.hongsong.pojo.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 统一异常处理
 * @Author: agreenHan
 * @Date: 2023/2/28 17:14
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionsHandler {

    /**
     * @Description: 用于处理BaseException及其子类异常
     * @param exception 异常对象
     * @param request 请求对象
     * @return ResponseResult<?>
     * @Author: agreenHan
     * @Date: 2023/2/28 19:58
     */
    @ExceptionHandler(BaseException.class)
    public ResponseResult<?> handleException(BaseException exception, HttpServletRequest request) {
        log.error("[发生：{} 异常，调用地址: {}]", exception.getError().getMessage(), request.getRequestURI());
        ErrorResponse errorResponse = new ErrorResponse(exception, request.getRequestURI());
        return ResponseResult.failure().code(HttpStatus.BAD_REQUEST).data(errorResponse);
    }

}
