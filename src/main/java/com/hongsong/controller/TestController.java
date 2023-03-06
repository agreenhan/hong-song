package com.hongsong.controller;

import com.hongsong.pojo.po.LoginEmployee;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 * @Author: jht
 * @Date: 2023/03/04 15:03
 */
@RestController
public class TestController {

    @RequestMapping("/hello")
    @PreAuthorize("hasAuthority('test')")
    public String hello() {
        // 可以获取到当前操作员工
        LoginEmployee principal = (LoginEmployee) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(principal.getEmployee());
        return "hello";
    }
}
