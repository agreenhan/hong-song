package com.hongsong.filter;


import com.hongsong.constant.ErrorCode;
import com.hongsong.exception.ValidException;
import com.hongsong.pojo.po.LoginEmployee;
import com.hongsong.util.JwtUtil;
import com.hongsong.util.RedisUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * 拦截器，主要作用是判断请求头中是否有token
 *
 * @Author: author
 * @Date: 2023/03/03 16:52
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    private RedisUtil redisUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 获取token
        String token = request.getHeader("token");
        if (!StringUtils.hasText(token)) {
            // 放行
            filterChain.doFilter(request, response);
            return;
        }
        // 解析token
        String phoneNumber;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            phoneNumber = claims.getSubject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ValidException(ErrorCode.LOGIN_FAILED, null);
        }
        // 从redis中获取信息
        LoginEmployee loginEmployee = redisUtil.getCacheObject("login:" + phoneNumber);
        if (Objects.isNull(loginEmployee)) {
            throw new ValidException(ErrorCode.LOGIN_FAILED, null);
        }
        // 存入SecurityContextHolder中
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginEmployee, null, null);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        // 放行
        filterChain.doFilter(request, response);
    }
}
