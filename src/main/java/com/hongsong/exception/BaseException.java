package com.hongsong.exception;

import com.hongsong.constant.ErrorCode;
import lombok.Getter;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 基础异常类，其他所有自定义类都继承这个类
 * @Author: agreenHan
 * @Date: 2023/2/28 17:26
 */
@Getter
public class BaseException extends RuntimeException{
    private final ErrorCode error;
    private final HashMap<String, Object> data = new HashMap<>();

    public BaseException(ErrorCode error, Map<String, Object> data) {
        super(error.getMessage());
        this.error = error;
        if (!ObjectUtils.isEmpty(data)) {
            this.data.putAll(data);
        }
    }

    protected BaseException(ErrorCode error, Map<String, Object> data, Throwable cause) {
        super(error.getMessage(), cause);
        this.error = error;
        if (!ObjectUtils.isEmpty(data)) {
            this.data.putAll(data);
        }
    }
}
