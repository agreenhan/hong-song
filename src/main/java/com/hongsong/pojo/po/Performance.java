package com.hongsong.pojo.po;

import com.baomidou.mybatisplus.annotation.*;

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
@TableName("t_performance")
@ApiModel(value = "Performance对象", description = "")
public class Performance implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("绩效考核id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("员工id")
    @TableField("emp_id")
    private Integer empId;

    @ApiModelProperty("绩效日期")
    @TableField("performance_date")
    private Date performanceDate;

    @ApiModelProperty("绩效评分：0-100")
    @TableField("performance_score")
    private Integer performanceScore;

    @ApiModelProperty("绩效评价")
    @TableField("performance_evaluation")
    private String performanceEvaluation;

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


}
