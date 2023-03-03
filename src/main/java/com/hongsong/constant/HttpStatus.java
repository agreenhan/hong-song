package com.hongsong.constant;

/**
 * @Description: Http状态码及信息
 * @Author: agreenHan
 * @Date: 2023/2/28 10:50
 */
public enum HttpStatus {
    SUCCESS(20000, "请求成功"),
    FAILURE(4000, "请求失败"),
    NOT_FOUND(404, "未找到该资源"),
    BAD_REQUEST(400, "错误请求");

    private Integer code;
    private String message;

    HttpStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
