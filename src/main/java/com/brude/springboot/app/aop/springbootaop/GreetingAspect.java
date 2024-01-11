package com.brude.springboot.app.aop.springbootaop;
import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component
public class GreetingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

 


    @Before("GreetingServicePointcuts.greetingLoggerPointCut()")
    //@Before("execution(String com.brude.springboot.app.aop.springbootaop.services.IGreetingService.sayHello(..))")
    public void loggerBefore(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Antes: " + method + " , CON LOS ARGUMENTOS:" + args);
    }

     @After("GreetingServicePointcuts.greetingLoggerPointCut()")
    //@Before("execution(String com.brude.springboot.app.aop.springbootaop.services.IGreetingService.sayHello(..))")
    public void loggerAfter(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues: " + method + " , CON LOS ARGUMENTOS:" + args);
    }


     @AfterReturning("GreetingServicePointcuts.greetingLoggerPointCut()")
    //@Before("execution(String com.brude.springboot.app.aop.springbootaop.services.IGreetingService.sayHello(..))")
    public void loggerAfterReturning(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues de retornar: " + method + " , CON LOS ARGUMENTOS:" + args);
    }

     @AfterThrowing("GreetingServicePointcuts.greetingLoggerPointCut()")
    //@Before("execution(String com.brude.springboot.app.aop.springbootaop.services.IGreetingService.sayHello(..))")
    public void loggerAfterThrowing(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues de lanzar la excepcion: " + method + " , CON LOS ARGUMENTOS:" + args);
    }

    @Around("GreetingServicePointcuts.greetingLoggerPointCut()")
    public Object loggerAround(ProceedingJoinPoint  joinPoint) throws Throwable {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        Object result = null;

        
        try{
           logger.info("El metodo   " + method + "() con los parametros " + args);
           //aca envolvemos
           result = joinPoint.proceed();   
           logger.info("El metodo   " + method + "() retrna el resultado " + result);  
           return result;
        }catch (Throwable e) {
            logger.error("error en la llamada del metodo " + method );
            throw e;
        }   
        
    }

}
