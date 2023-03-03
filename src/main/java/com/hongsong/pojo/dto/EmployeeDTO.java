package com.hongsong.pojo.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工传输对象
 *
 * @Author: author
 * @Date: 2023/03/03 16:29
 */
@Data
@ApiModel(value = "Employee传输对象", description = "")
public class EmployeeDTO implements Serializable {
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

    @ApiModelProperty("员工职位名称")
    @TableField("role_id")
    private Integer roleName;

    @ApiModelProperty("员工所属部门名称")
    @TableField("dept_id")
    private Integer deptName;

    @ApiModelProperty("员工身份证号")
    @TableField("id_number")
    private String idNumber;

    @ApiModelProperty("员工手机号（同时也是账号）")
    @TableField("phone_number")
    private String phoneNumber;

    @ApiModelProperty("员工密码")
    @TableField("password")
    private String password;

}
