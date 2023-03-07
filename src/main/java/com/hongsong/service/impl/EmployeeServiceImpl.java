package com.hongsong.service.impl;

import com.hongsong.common.ResponseResult;
import com.hongsong.constant.ErrorCode;
import com.hongsong.constant.HttpStatus;
import com.hongsong.constant.RedisKey;
import com.hongsong.constant.log.EmployeeLogEnum;
import com.hongsong.exception.ValidException;
import com.hongsong.pojo.dto.EmployeeDTO;
import com.hongsong.pojo.po.Employee;
import com.hongsong.dao.EmployeeMapper;
import com.hongsong.pojo.po.Log;
import com.hongsong.pojo.po.LoginEmployee;
import com.hongsong.pojo.vo.EmployeeVO;
import com.hongsong.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hongsong.service.LogService;
import com.hongsong.util.EmployeeUtil;
import com.hongsong.util.JwtUtil;
import com.hongsong.util.RedisUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;
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
    @Autowired
    private LogService logService;


    @Override
    public ResponseResult<?> login(Employee employee) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(employee.getPhoneNumber(), employee.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if (Objects.isNull(authenticate)) {
            throw new ValidException(ErrorCode.LOGIN_FAILED, null);
        }
        // 使用员工编号生成token
        LoginEmployee loginEmployee = (LoginEmployee) authenticate.getPrincipal();
        String empId = loginEmployee.getEmployee().getId().toString();
        String jwt = JwtUtil.createJWT(empId);
        // 存入redis
        redisUtil.setCacheObject(RedisKey.IDENTITY + RedisKey.LOGIN + empId, loginEmployee);
        // token响应给前端
        Map<String, String> map = new HashMap<>();
        map.put("token", jwt);
        // 保存登录日志
        Log log = new Log();
        log.setOperater(Integer.valueOf(empId));
        log.setOperateData(null);
        log.setOperateContent(EmployeeLogEnum.Employee_LOGIN.getOperationName());
        log.setOperateModule(EmployeeLogEnum.Employee_LOGIN.getModuleName());
        logService.save(log);
        return ResponseResult.success().data(map).message("登陆成功");
    }

    @Override
    public ResponseResult<?> logout() {
        Employee employee = EmployeeUtil.getEmployee();
        Integer empId = employee.getId();
        redisUtil.deleteObject(RedisKey.IDENTITY + RedisKey.LOGIN + empId);
        return ResponseResult.success().message("退出成功");
    }

    @Override
    public ResponseResult<?> info() {
        Employee employee = EmployeeUtil.getEmployee();
        EmployeeVO employeeVO = new EmployeeVO();
        BeanUtils.copyProperties(employee, employeeVO);
        return ResponseResult.success().data(employeeVO);
    }
}
