package com.luv2code.aop.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    @Pointcut("execution(* com.luv2code.aop.demo.dao.*.*(..))")
    private void forDaoPackage(){}

    //create pointcut for getter methods
    @Pointcut("execution(* com.luv2code.aop.demo.dao.*.get*(..))")
    private void getter(){}

    //create pointcut for setter methods
    @Pointcut("execution(* com.luv2code.aop.demo.dao.*.set*(..))")
    private void setter(){}

    //create pointcut: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter(){}

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n====>>>> Executing @Before advice on method");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("\n===>>> Performing API analytics");
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
