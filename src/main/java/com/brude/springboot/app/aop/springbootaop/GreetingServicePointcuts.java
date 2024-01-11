package com.brude.springboot.app.aop.springbootaop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePointcuts {

    @Pointcut("execution(String com.brude.springboot.app.aop.springbootaop.services.IGreetingService.*(..))")
    public void greetingLoggerPointCut(){

    }

    @Pointcut("execution(* com.brude.springboot.app.aop.springbootaop.services.IGreetingService.*(..))")
    public void greetingFooAspectPointCut(){}



}
