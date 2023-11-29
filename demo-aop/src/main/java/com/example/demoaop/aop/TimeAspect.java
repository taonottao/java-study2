package com.example.demoaop.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/11/27 23:16
 */
@Configuration
//@Aspect
@Slf4j
public class TimeAspect implements WebMvcConfigurer {

    @Around("execution(* com.example.demoaop.service.*.*(..))")// 切入点表达式
    public Object recordTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 1. 记录开始时间
        long begin = System.currentTimeMillis();
        // 2. 调用原始方法运行
        Object result = proceedingJoinPoint.proceed();
        // 3. 记录结束时间
        long end = System.currentTimeMillis();

        log.info(proceedingJoinPoint.getSignature() + "方法执行耗时：{}ms", end-begin);

        return result;
    }

}
