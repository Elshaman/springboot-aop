package com.brude.springboot.app.aop.springbootaop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
@Aspect
public class GreetingFooAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

  
    @Before("GreetingServicePointcuts.greetingFooAspectPointCut()")
    public void loggerBefore(JoinPoint  joinPoint){
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Antes num 2: " + method + " , CON LOS ARGUMENTOS:" + args);
    }

       @After("GreetingServicePointcuts.greetingFooAspectPointCut()")
    //@Before("execution(String com.brude.springboot.app.aop.springbootaop.services.IGreetingService.sayHello(..))")
    public void loggerAfter(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues nmum 2: " + method + " , CON LOS ARGUMENTOS:" + args);
    }



}
