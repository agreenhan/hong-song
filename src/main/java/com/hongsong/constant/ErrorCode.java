package com.hongsong.constant;

import lombok.Getter;

/**
 * @Description: 异常枚举类
 * @Author: agreenHan
 * @Date: 2023/2/28 18:19
 */
@Getter
public enum ErrorCode {
    RESOURCE_NOT_FOUND(1001, HttpStatus.NOT_FOUND, "未找到该资源!"),
    LOGIN_FAILED(1002, HttpStatus.FAILURE, "身份校验失败!"),
    LOGIN_STATE_VALID(1003, HttpStatus.TOKEN_EXPIRATION, "网络错误，请重新登陆！"),
    PARSE_FAILED(1004, HttpStatus.SERVER_ERROR, "解析失败");
    private final Integer code;
    private final HttpStatus status;
    private final String message;

    ErrorCode(Integer code, HttpStatus status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }
}
