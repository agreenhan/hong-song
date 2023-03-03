package com.hongsong.exception;

import com.hongsong.constant.ErrorCode;

import java.util.Map;

/**
 * TODO
 *
 * @Author: jht
 * @Date: 2023/03/03 16:38
 */
public class ValidException extends BaseException{

    public ValidException(ErrorCode error, Map<String, Object> data) {
        super(error, data);
    }
}
