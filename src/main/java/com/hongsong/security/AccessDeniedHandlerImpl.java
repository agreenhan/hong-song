package com.hongsong.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hongsong.common.ResponseResult;
import com.hongsong.constant.HttpStatus;
import com.hongsong.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义处理在SpringSecurity授权过程中出现的异常
 *
 * @Author: author
 * @Date: 2023/03/04 16:10
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * @Description: 返回授权失败结果
     * @param request 请求
     * @param response 响应
     * @param accessDeniedException 认证异常
     * @Author: agreenHan
     * @Date: 2023/3/4 22:48
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ResponseResult<Object> result = ResponseResult.success().code(HttpStatus.ILLEGAL_TOKEN);
        String json = objectMapper.writeValueAsString(result);
        WebUtil.renderString(response, json);
    }
}
