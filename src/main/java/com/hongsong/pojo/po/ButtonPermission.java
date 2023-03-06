package com.hongsong.pojo.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 职位按钮权限关联表
 * </p>
 *
 * @author author
 * @since 2023-03-06 08:39:37
 */
@Getter
@Setter
@TableName("t_button_permission")
@ApiModel(value = "ButtonPermission对象", description = "职位按钮权限关联表")
public class ButtonPermission implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("职位编号")
    @TableField("role_id")
    private Integer roleId;

    @ApiModelProperty("按钮编号")
    @TableField("button_id")
    private Integer buttonId;

    @ApiModelProperty("创建时间")
    @TableField(value = "created_time", fill = FieldFill.INSERT)
    private Date createdTime;

    @ApiModelProperty("修改时间")
    @TableField(value = "modified_time", fill = FieldFill.INSERT_UPDATE)
    private Date modifiedTime;


}
