package com.example.bai1.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectBook {
    @After(value = "execution(* com.example.bai1.controller.BorrowController.*(..))")
    public void logBorrow (JoinPoint joinPoint){
        System.out.println(joinPoint);
    }
}
