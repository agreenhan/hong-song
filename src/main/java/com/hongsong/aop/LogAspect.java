package com.hongsong.aop;

import com.hongsong.annotation.LogAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @Description: 日志切面
 * @Author: agreenHan
 * @Date: 2023/2/26 17:23
 */
@Component
@Aspect
@Slf4j
public class LogAspect {


    /**
     * @Description: 切入点为@LogAnnotation修饰的方法
     * @Author: agreenHan
     * @Date: 2023/2/28 17:04
     */
    @Pointcut("@annotation(com.hongsong.annotation.LogAnnotation)")
    public void logAnnotationCut() {
    }

    /**
     * @Description: 将日志信息存入数据库
     * @param joinPoint 连接点
     * @Author: agreenHan
     * @Date: 2023/2/26 18:34
     */
    @Around("logAnnotationCut()")
    public void logAspect(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        LogAnnotation annotation = method.getAnnotation(LogAnnotation.class);
        if (Objects.isNull(annotation)) {
            // 将操作日志存入数据库 TODO

        }
    }
}
