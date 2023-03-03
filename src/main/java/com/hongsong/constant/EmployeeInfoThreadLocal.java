package com.hongsong.constant;

import com.hongsong.pojo.po.Employee;

/**
 * 使用ThreadLocal存储用户信息，方便全局获取
 *
 * @Author: author
 * @Date: 2023/03/03 17:04
 */
public class EmployeeInfoThreadLocal {

    private EmployeeInfoThreadLocal() {
    }

    public static final ThreadLocal<Employee> EMPLOYEE_THREAD_LOCAL = new ThreadLocal<>();

    public static void setEmployee(Employee employee) {
        EMPLOYEE_THREAD_LOCAL.set(employee);
    }

    public static Employee getEmployee() {
        return EMPLOYEE_THREAD_LOCAL.get();
    }

    public static  void clear() {
        EMPLOYEE_THREAD_LOCAL.remove();
    }

}


