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
 * @since 2023-03-03 03:57:03
 */
@Getter
@Setter
@TableName("t_attendance")
@ApiModel(value = "Attendance对象", description = "")
public class Attendance implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("考勤编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("员工编号")
    @TableField("emp_id")
    private Integer empId;

    @ApiModelProperty("考勤日期")
    @TableField("word_date")
    private Date wordDate;

    @ApiModelProperty("上班时间")
    @TableField("in_time")
    private Date inTime;

    @ApiModelProperty("下班时间")
    @TableField("out_time")
    private Date outTime;

    @ApiModelProperty("逻辑删除：0-没删 1-删了")
    @TableField("is_deleted")
    @TableLogic
    private Boolean isDeleted;

    @ApiModelProperty("创建时间")
    @TableField("created_time")
    private Date createdTime;

    @ApiModelProperty("修改时间")
    @TableField("modified_time")
    private Date modifiedTime;


}
