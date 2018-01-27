package com.wangwei.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by wangwei on 2018/1/27.
 */
@Aspect
@Component
public class LogAspect {

    @Before(value = "execution(* com.wangwei.aop..*.*(..))")
    public void log(JoinPoint joinPoint){
        System.out.println("======log run======="+joinPoint.getTarget().getClass()+"/"+ Arrays.asList(joinPoint.getArgs())
            +"/"+joinPoint.getSignature().getName());
        System.out.println("======"+ AopContext.currentProxy().getClass());
    }
}
