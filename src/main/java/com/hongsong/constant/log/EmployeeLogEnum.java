package com.hongsong.constant.log;

import lombok.Getter;

/**
 * @Description: 员工账号日志枚举
 * @Author: agreenHan
 * @Date: 2023/2/28 22:05
 */
@Getter
public enum EmployeeLogEnum {
    Employee_LOGIN(Module.EMPLOYEE, "登陆账号"),
    Employee_EXIT(Module.EMPLOYEE, "退出账号"),
    Employee_MODIFY(Module.EMPLOYEE, "修改个人信息"),
    Employee_LOGOUT(Module.EMPLOYEE, "注销账号");
    /**
     *  操作模块
     */
    private String moduleName;
    /**
     *  操作内容
     */
    private String operationName;

    EmployeeLogEnum(String moduleName, String operationName) {
        this.moduleName = moduleName;
        this.operationName = operationName;
    }
}
