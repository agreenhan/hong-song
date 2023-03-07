package com.hongsong.pojo.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 模块视图（用于实现动态路由）
 * @Author: agreenHan
 * @Date: 2023/3/6 21:52
 */
@Data
@ApiModel("模块视图对象")
public class ModuleVO {
    @JsonIgnore
    @ApiModelProperty("父功能模块id")
    private Integer id;
    @ApiModelProperty("路径")
    private String path;
    @ApiModelProperty("组件位置")
    private String component;
    @ApiModelProperty("重定向地址")
    private String redirect;
    @ApiModelProperty("路由名字")
    private String name;
    @ApiModelProperty("路由meta信息")
    private Meta meta;
    @ApiModelProperty("子路由")
    private List<ModuleVO> children = new ArrayList<>();
}
