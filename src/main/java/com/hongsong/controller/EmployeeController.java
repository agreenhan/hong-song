package com.hongsong.controller;


import com.hongsong.common.ResponseResult;
import com.hongsong.pojo.dto.EmployeeDTO;
import com.hongsong.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseResult<?> login(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.login(employeeDTO);
    }
}
