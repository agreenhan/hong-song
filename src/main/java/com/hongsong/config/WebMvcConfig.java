package com.hongsong.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMvc配置类
 *
 * @Author: jht
 * @Date: 2023/03/04 16:45
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * @Description: 跨域设置
     * @param registry registry
     * @Author: agreenHan
     * @Date: 2023/3/4 23:22
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 设置允许跨域的路径
        registry.addMapping("/**")
                // 设置允许跨域请求的域名
                .allowedOriginPatterns("*")
                // 是否允许cookie
                .allowCredentials(true)
                // 设置允许的请求方式
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                // 设置允许的header属性
                .allowedHeaders("*")
                // 跨域允许时间(秒)
                .maxAge(3600);
    }

    /**
     * @Description: TODO 拦截器设置（用于获取当前操作员工信息）
     * @param registry registry
     * @Author: agreenHan
     * @Date: 2023/3/4 23:27
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
