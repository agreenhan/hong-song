package com.hongsong.controller;


import com.hongsong.annotation.LogAnnotation;
import com.hongsong.common.ResponseResult;
import com.hongsong.constant.log.EmployeeLogEnum;
import com.hongsong.pojo.dto.EmployeeDTO;
import com.hongsong.pojo.po.Employee;
import com.hongsong.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2023-03-03 03:57:04
 */
@RestController
@RequestMapping("/employee")
@Api(value = "员工管理")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登录")
    @LogAnnotation(EmployeeLogEnum.Employee_LOGIN)
    public ResponseResult<?> login(Employee employee) {
        return employeeService.login(employee);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('test')")
    @ApiOperation(value = "退出")
    @LogAnnotation(EmployeeLogEnum.Employee_EXIT)
    public ResponseResult<?> logout() {
        return employeeService.logout();
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('test')")
    @ApiOperation(value = "获取用户当前信息")
    public ResponseResult<?> info() {
        return employeeService.info();
    }
}
