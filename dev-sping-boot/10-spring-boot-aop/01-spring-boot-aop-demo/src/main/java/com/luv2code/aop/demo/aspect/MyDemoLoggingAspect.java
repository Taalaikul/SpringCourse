package com.luv2code.aop.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    //let's start with an @Before advice

    //@Before("execution(public void com.luv2code.aop.demo.dao.AccountDAOImpl.addAccount())")
    //@Before("execution(public void add*())")
    //@Before("execution(* add*(..))")
    @Before("execution(* com.luv2code.aop.demo.dao.*.*(..))")
    public void beforeAddAccountAdvice(){

        System.out.println("\n====>>>> Executing @Before advice on method");
    }

}
/*

Pointcut Expression examples
1) Match on method parameters
    Match addAccount methods that have Account param
    @Before("execution(* addAccount(com.luv2code.app.demo.Account))")
2) Match on Package
    @Before("execution(* addAccount(com.luv2code.app.demo.dao.*.*(..))")

Parameter Pattern Wildcards
 - () ====>>> matches a method with no arguments
 - (*) ====>>> matches a method with one argument of any type
 - (..) ====>>> matches a method with 0 or more argument of any type
 */
