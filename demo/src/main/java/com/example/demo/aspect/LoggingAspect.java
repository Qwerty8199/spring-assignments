package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Before("execution(* com.example.demo.service.*.*(..))")
    public void logBeforeExec(JoinPoint jp){
        logger.info("Entering method: {} with args {}", jp.getSignature().toShortString(), jp.getArgs());
    }

    @After("execution(* com.example.demo.service.*.*(..))")
    public void logAfterExec(JoinPoint jp){
        logger.info("Exiting method: {}",jp.getSignature().toShortString());
    }

    @AfterReturning(pointcut = "execution(* com.example.demo.service.*.*(..))", returning =  "res")
    public void logAfterReturning(JoinPoint jp, Object res){
        logger.info("Method {} returned value {}", jp.getSignature().toShortString(), res);
    }

}
