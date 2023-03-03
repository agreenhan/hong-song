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
@TableName("t_employee")
@ApiModel(value = "Employee对象", description = "")
public class Employee implements Serializable {

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

    @ApiModelProperty("员工所属部门编号")
    @TableField("dept_id")
    private Integer deptId;

    @ApiModelProperty("员工身份证号")
    @TableField("id_number")
    private String idNumber;

    @ApiModelProperty("员工手机号（同时也是账号）")
    @TableField("phone_number")
    private String phoneNumber;

    @ApiModelProperty("员工密码")
    @TableField("password")
    private String password;

    @ApiModelProperty("盐")
    @TableField("salt")
    private String salt;

    @ApiModelProperty("入职日期")
    @TableField("created_time")
    private Date createdTime;

    @ApiModelProperty("修改日期")
    @TableField("modified_time")
    private Date modifiedTime;

    @ApiModelProperty("逻辑删除：0-没删 1-删了")
    @TableField("is_deleted")
    @TableLogic
    private Boolean isDeleted;

    @ApiModelProperty("在职状态：0-在职 1-离职")
    @TableField("is_valid")
    private Boolean isValid;


}
