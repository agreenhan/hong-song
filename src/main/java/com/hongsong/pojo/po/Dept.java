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
@TableName("t_dept")
@ApiModel(value = "Dept对象", description = "")
public class Dept implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("部门编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("部门名称")
    @TableField("dept_name")
    private String deptName;

    @ApiModelProperty("上级部门名称：0-没有上级")
    @TableField("parent_id")
    private Integer parentId;

    @ApiModelProperty("部门描述")
    @TableField("description")
    private String description;

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
