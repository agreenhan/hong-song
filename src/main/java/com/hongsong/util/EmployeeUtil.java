package com.hongsong.util;

import com.hongsong.pojo.po.Employee;
import com.hongsong.pojo.po.LoginEmployee;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @Description: 员工工具类
 * @Author: agreenHan
 * @Date: 2023/3/5 21:05
 */
public class EmployeeUtil {
    private EmployeeUtil() {
    }

    /**
     * @Description: 获取当前员工
     * @return Employee 员工
     * @Author: agreenHan
     * @Date: 2023/3/5 21:06
     */
    public static Employee getEmployee() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginEmployee loginEmployee = (LoginEmployee) authentication.getPrincipal();
        return loginEmployee.getEmployee();
    }
}
