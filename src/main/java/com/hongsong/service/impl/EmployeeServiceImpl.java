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
    public ResponseResult<?> login(EmployeeDTO employeeDTO) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(employeeDTO.getPhoneNumber(), employeeDTO.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if (Objects.isNull(authenticate)) {
            throw new ValidException(ErrorCode.LOGIN_FAILED, null);
        }
        // 使用手机号生成token
        LoginEmployee loginEmployee = (LoginEmployee) authenticate.getPrincipal();
        String phoneNumber = loginEmployee.getEmployee().getPhoneNumber();
        String jwt = JwtUtil.createJWT(phoneNumber);
        // 存入redis
        redisUtil.setCacheObject("login:" + phoneNumber, loginEmployee);
        // token响应给前端
        return ResponseResult.success().data(jwt).message("登陆成功");
    }
}
