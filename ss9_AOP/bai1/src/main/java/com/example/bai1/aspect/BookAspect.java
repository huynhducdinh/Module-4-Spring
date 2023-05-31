package com.example.bai1.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookAspect {
    @After("execution(* *..com.example.bai1.controlle.BookLoanAppController.*(..))")
    public void  log(JoinPoint joinPoint){
        System.out.printf(joinPoint.getSignature().getName());
    }
}
