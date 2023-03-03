package com.hongsong.pojo.dto;

import com.hongsong.exception.BaseException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.util.ObjectUtils;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 异常信息类
 * @Author: agreenHan
 * @Date: 2023/2/28 18:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(value = "异常信息对象", description = "异常信息对象")
public class ErrorResponse {
    @ApiModelProperty(value = "唯一标示异常的code")
    private Integer code;
    @ApiModelProperty(value = "HTTP状态码")
    private Integer status;
    @ApiModelProperty(value = "错误描述")
    private String message;
    @ApiModelProperty(value = "错误路径")
    private String path;
    @ApiModelProperty(value = "发生错误的时间戳")
    private Instant timestamp;
    @ApiModelProperty(value = "错误的具体信息")
    private HashMap<String, Object> data = new HashMap<>();

    public ErrorResponse(BaseException ex, String path) {
        this(ex.getError().getCode(), ex.getError().getStatus().getCode(), ex.getError().getMessage(), path, ex.getData());
    }

    public ErrorResponse(Integer code, Integer status, String message, String path, Map<String, Object> data) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.path = path;
        this.timestamp = Instant.now();
        if (!ObjectUtils.isEmpty(data)) {
            this.data.putAll(data);
        }
    }
}
