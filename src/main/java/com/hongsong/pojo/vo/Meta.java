package com.hongsong.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @Description: 前端路由属性之一
 * @Author: agreenHan
 * @Date: 2023/3/6 23:23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("路由meta属性")
public class Meta {
    @ApiModelProperty("标题")
    private String title;
    @ApiModelProperty("图标")
    private String icon;
}
