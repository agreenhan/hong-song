package com.hongsong.service;

import com.hongsong.common.ResponseResult;
import com.hongsong.pojo.dto.EmployeeDTO;
import com.hongsong.pojo.po.Employee;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2023-03-03 03:57:04
 */
public interface EmployeeService extends IService<Employee> {


    ResponseResult<?> login(Employee employee);

    ResponseResult<?> logout();

    ResponseResult<?> info();
}
