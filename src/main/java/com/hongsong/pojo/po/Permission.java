package com.hongsong.pojo.po;

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
 * 
 * </p>
 *
 * @author author
 * @since 2023-03-03 03:57:04
 */
@Getter
@Setter
@TableName("t_permission")
@ApiModel(value = "Permission对象", description = "")
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("权限编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("职位编号")
    @TableField("role_id")
    private Integer roleId;

    @ApiModelProperty("模块编号")
    @TableField("module_id")
    private Integer moduleId;

    @ApiModelProperty("创建时间")
    @TableField("created_time")
    private Date createdTime;

    @ApiModelProperty("修改时间")
    @TableField("modified_time")
    private Date modifiedTime;

    @ApiModelProperty("逻辑删除：0-没删 1-删了")
    @TableField("is_deleted")
    @TableLogic
    private Boolean isDeleted;


}
