package com.hongsong.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hongsong.annotation.LogAnnotation;
import com.hongsong.pojo.po.Employee;
import com.hongsong.pojo.po.Log;
import com.hongsong.service.LogService;
import com.hongsong.util.EmployeeUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
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
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private LogService logService;


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
    public void logAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        LogAnnotation annotation = method.getAnnotation(LogAnnotation.class);
        if (Objects.nonNull(annotation)) {
            // 方法执行
            joinPoint.proceed();
            // 将操作日志存入数据库
            Employee employee = EmployeeUtil.getEmployee();
            Log log = new Log();
            log.setOperater(employee == null ? null : employee.getId());
            Parameter[] parameters = method.getParameters();
            String logStr = objectMapper.writeValueAsString(parameters);
            log.setOperateData(logStr);
            log.setOperateContent(annotation.value().getOperationName());
            log.setOperateModule(annotation.value().getModuleName());
            logService.save(log);
        }
    }
}
