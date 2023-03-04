package com.hongsong.service.impl;

import com.hongsong.common.ResponseResult;
import com.hongsong.constant.ErrorCode;
import com.hongsong.exception.ValidException;
import com.hongsong.pojo.dto.EmployeeDTO;
import com.hongsong.pojo.po.Employee;
import com.hongsong.dao.EmployeeMapper;
import com.hongsong.pojo.po.LoginEmployee;
import com.hongsong.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hongsong.util.JwtUtil;
import com.hongsong.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * <p>
 *  员工管理实现类
 * </p>
 *
 * @author author
 * @since 2023-03-03 03:57:04
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisUtil redisUtil;


    @Override
    public ResponseResult<?> login(Employee employee) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(employee.getPhoneNumber(), employee.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if (Objects.isNull(authenticate)) {
            throw new ValidException(ErrorCode.LOGIN_FAILED, null);
        }
        // 使用手机号生成token
        LoginEmployee loginEmployee = (LoginEmployee) authenticate.getPrincipal();
        String empId = loginEmployee.getEmployee().getId().toString();
        String jwt = JwtUtil.createJWT(empId);
        // 存入redis
        redisUtil.setCacheObject("login:" + empId, loginEmployee);
        // token响应给前端
        return ResponseResult.success().data(jwt).message("登陆成功").code(200);
    }

    @Override
    public ResponseResult<?> logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginEmployee loginEmployee = (LoginEmployee) authentication.getPrincipal();
        Integer empId = loginEmployee.getEmployee().getId();
        redisUtil.deleteObject("login:" + empId);
        return ResponseResult.success().message("退出成功").code(200);
    }
}
