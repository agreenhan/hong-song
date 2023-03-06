package com.hongsong.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hongsong.common.ResponseResult;
import com.hongsong.constant.HttpStatus;
import com.hongsong.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义处理在SpringSecurity授权过程中出现的异常
 *
 * @Author: author
 * @Date: 2023/03/04 16:39
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * @Description: 返回认证失败结果
     * @param request 请求
     * @param response 响应
     * @param authException authException
     * @Author: agreenHan
     * @Date: 2023/3/4 22:46
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ResponseResult<Object> result = ResponseResult.success().code(HttpStatus.UNAUTHORIZED);
        String json = objectMapper.writeValueAsString(result);
        WebUtil.renderString(response, json);
    }
}
