package com.hongsong.annotation;

import com.hongsong.constant.log.EmployeeLogEnum;

import java.lang.annotation.*;

/**
 * @Description: 自定义AOP日志注解，注解式记录操作日志
 * @Author: agreenHan
 * @Date: 2023/2/26 17:36
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {

    EmployeeLogEnum value();
}
