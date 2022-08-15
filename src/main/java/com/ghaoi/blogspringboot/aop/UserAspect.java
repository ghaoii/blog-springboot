package com.ghaoi.blogspringboot.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


/**
 * UserController AOP 实现示例
 */
//@Aspect// 1.声明为一个切面
//@Component
//public class UserAspect {
//    // 2.切点(配置拦截规则)
//    @Pointcut("execution(* com.ghaoi.blogspringboot.controller.UserController.*(..))")
//    public void pointcut() {
//    }
//
//    // 3.前置通知
//    @Before("pointcut()")
//    public void doBefore() {
//        // 具体的业务代码..
//        System.out.println("执行了前置通知");
//    }
//
//    @After("pointcut()")
//    public void doAfter() {
//        System.out.println("执行了后置通知");
//    }
//
//    @Around("pointcut()")
//    public Object doAround(ProceedingJoinPoint joinPoint) {
//        Long start = System.nanoTime();
//        Object ret = null;
//        // 执行前置业务代码
//        System.out.println("执行环绕通知的前置方法");
//        try {
//            ret = joinPoint.proceed();
//        } catch (Throwable e) {
//            throw new RuntimeException(e);
//        }
//        // 执行后置业务处理
//        System.out.println("执行环绕通知的后置方法");
//        Long end = System.nanoTime();
//        System.out.println("getAll方法执行总时长: " + (end - start) * 1.0 / 100_0000 + "ms");
//        return ret;
//    }
//}
