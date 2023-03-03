package com.hongsong.common;

import com.hongsong.constant.HttpStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: 通用结果返回类（链式调用）
 * @Author: agreenHan
 * @Date: 2023/2/28 11:08
 */
@Data
@NoArgsConstructor
@ApiModel(value = "通用返回结果", description = "通用结果返回对象")
public class ResponseResult<T> implements Serializable {
    @ApiModelProperty(value = "状态码")
    private Integer code;
    @ApiModelProperty(value = "返回信息")
    private String message;
    @ApiModelProperty(value = "返回数据")
    private T data;

    /**
     * @Description: 修改返回结果状态码
     * @param code 状态码
     * @return ResponseResult<T>
     * @Author: agreenHan
     * @Date: 2023/2/28 13:14
     */
    public ResponseResult<T> code(Integer code) {
        this.code = code;
        return this;
    }

    /**
     * @Description: 修改返回结果信息
     * @param message 提示信息
     * @return ResponseResult<T>
     * @Author: agreenHan
     * @Date: 2023/2/28 13:15
     */
    public ResponseResult<T> message(String message) {
        this.message = message;
        return this;
    }

    /**
     * @Description: 修改返回结果数据
     * @param data 数据
     * @return ResponseResult<T>
     * @Author: agreenHan
     * @Date: 2023/2/28 13:15
     */
    public ResponseResult<T> data(T data) {
        this.data = data;
        return this;
    }

    /**
     * @Description: 创建成功返回结果实例
     * @return ResponseResult<T>
     * @Author: agreenHan
     * @Date: 2023/2/28 12:04
     */
    public static <T> ResponseResult<T> success() {
        return new ResponseResult<T>();
    }

    /**
     * @Description: 创建失败返回结果实例
     * @return ResponseResult
     * @Author: agreenHan
     * @Date: 2023/2/28 12:30
     */
    public static <T> ResponseResult<T> failure() {
        return new ResponseResult<T>().code(HttpStatus.FAILURE.getCode());
    }

    /**
     * @Description: 允许传入枚举类型，同时修改状态码和提示信息
     * @param httpStatus 枚举类型
     * @return ResponseResult<T>
     * @Author: agreenHan
     * @Date: 2023/2/28 13:14
     */
    public ResponseResult<T> code(HttpStatus httpStatus) {
        this.setCode(httpStatus.getCode());
        this.setMessage(httpStatus.getMessage());
        return this;
    }
}
