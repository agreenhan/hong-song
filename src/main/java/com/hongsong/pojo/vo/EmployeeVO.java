package com.hongsong.pojo.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 员工视图
 *
 * @Author: author
 * @Date: 2023/03/03 16:29
 */
@Data
@ApiModel(value = "Employee传输对象", description = "")
public class EmployeeVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("员工编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("员工姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty("员工职位编号")
    @TableField("role_id")
    private Integer roleId;


    @ApiModelProperty("员工所属部门名称")
    @TableField("dept_id")
    private Integer deptId;

    @ApiModelProperty("员工手机号（同时也是账号）")
    @TableField("phone_number")
    private String phoneNumber;


}
