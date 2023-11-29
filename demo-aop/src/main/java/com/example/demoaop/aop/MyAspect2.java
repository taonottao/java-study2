package com.example.demoaop.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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

}
