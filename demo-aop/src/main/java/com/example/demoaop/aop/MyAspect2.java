package com.example.demoaop.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/11/28 23:06
 */
@Component
@Slf4j
@Aspect
public class MyAspect2 {

    @Pointcut("execution(* com.example.demoaop.controller.*(..))")
    public void pt(){};

    @Before("pt()")
    public void before() {
        log.info("前置通知执行...2");
    }

    @After("pt()")
    public void after() {
        log.info("后置通知执行...2");
    }

    @Around("pt()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("环绕通知之前......");

        // 1. 获取目标对象的类名
        String className = joinPoint.getTarget().getClass().getName();
        // 2. 获取目标方法的方法名
        String methodName = joinPoint.getSignature().getName();
        // 3. 获取目标方法运行时传入的参数
        Object[] args = joinPoint.getArgs();
        // 4. 放行目标方法执行
        // 5. 获取目标方法运行的返回值
        Object res = joinPoint.proceed();

        log.info("环绕通知之后......");
        return res;
    }

}
