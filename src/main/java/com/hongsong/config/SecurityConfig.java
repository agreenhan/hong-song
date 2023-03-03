package com.hongsong.config;

import com.hongsong.filter.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * SpringSecurity相关配置
 *
 * @Author: jht
 * @Date: 2023/03/03 16:01
 */
@Configuration
public class SecurityConfig {
    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    @Resource
    JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Bean
    public AuthenticationManager authenticationManager() throws Exception{
        AuthenticationManager authenticationManager = authenticationConfiguration.getAuthenticationManager();
        return authenticationManager;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                //关闭csrf
                .csrf().disable()
                //不通过Session获取SecurityContext
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // 对于登录接口和swagger 允许匿名访问
                .antMatchers("/employee/login", "/doc.html").anonymous()
                // 除上面外的所有请求全部需要鉴权认证
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
