package com.hongsong.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hongsong.dao.EmployeeMapper;
import com.hongsong.pojo.po.Employee;
import com.hongsong.pojo.po.LoginEmployee;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 自定义UserDetailsService，用于权限验证
 *
 * @Author: author
 * @Date: 2023/03/03 15:36
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Resource
    private EmployeeMapper employeeMapper;

    /**
     * @Describe:
     * @Author: jht
     * @param username 用户名
     * @Date: 2023/3/4 14:03
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据手机号查询用户信息
        LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Employee::getPhoneNumber, username);
        Employee employee = employeeMapper.selectOne(wrapper);
        // 查询不到数据抛出异常
        if (Objects.isNull(employee)) {
            throw new UsernameNotFoundException("用户不存在");
        }
        // TODO 根据用户查询权限信息 添加到LoginEmployee中
        List<String> list = new ArrayList<>(Arrays.asList("test"));
        return new LoginEmployee(employee, list);
    }
}
