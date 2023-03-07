package com.hongsong.pojo.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 模块表
 * </p>
 *
 * @author author
 * @since 2023-03-06 09:57:52
 */
@Getter
@Setter
@TableName("t_module")
@ApiModel(value = "Module对象", description = "模块表")
public class Module implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("模块编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("模块名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("路由地址")
    @TableField("path")
    private String path;

    @ApiModelProperty("组件路径")
    @TableField("component")
    private String component;

    @ApiModelProperty("模块标题")
    @TableField("title")
    private String title;

    @ApiModelProperty("父模块id")
    @TableField("parent_id")
    private Integer parentId;

    @ApiModelProperty("菜单图表")
    @TableField("icon")
    private String icon;

    @ApiModelProperty("创建时间")
    @TableField(value = "created_time", fill = FieldFill.INSERT)
    private Date createdTime;

    @ApiModelProperty("修改时间")
    @TableField(value = "modified_time", fill = FieldFill.INSERT_UPDATE)
    private Date modifiedTime;

    @ApiModelProperty("逻辑删除：0-没删 1-删了")
    @TableField("is_deleted")
    @TableLogic
    private Boolean isDeleted;

    @ApiModelProperty("备注")
    @TableField("remark")
    private String remark;

    @ApiModelProperty("是否隐藏（0显示 1隐藏）")
    @TableField("hidden")
    private Boolean hidden;

    @ApiModelProperty("重定向地址")
    @TableField("redirect")
    private String redirect;


}
