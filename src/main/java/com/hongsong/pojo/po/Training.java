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
@TableName("t_training")
@ApiModel(value = "Training对象", description = "")
public class Training implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("培训编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("员工编号")
    @TableField("emp_id")
    private Integer empId;

    @ApiModelProperty("培训日期")
    @TableField("training_date")
    private Date trainingDate;

    @ApiModelProperty("培训名称")
    @TableField("training_name")
    private String trainingName;

    @ApiModelProperty("培训内容")
    @TableField("training_content")
    private String trainingContent;

    @ApiModelProperty("开始时间")
    @TableField("start_date")
    private Date startDate;

    @ApiModelProperty("结束时间")
    @TableField("end_date")
    private Date endDate;

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
