package com.fsoft.roomreservation.core.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class LoggerAspectService extends AspectService{
    
    @Before("logEveryMethod()")
    public void starterLog(JoinPoint jp) {
        starttime = System.nanoTime();
        LOGGER.info("Start : {}",jp.getSignature().getName());        
    }
    
    @After("logEveryMethod()")
    public void endLogger(JoinPoint jp) {
        endtime = System.nanoTime();
        elapsedtime = (endtime - starttime) / 1000000000.0;
        LOGGER.info("Execution time : {} second(s)",elapsedtime);
        LOGGER.info("End : {}",jp.getSignature().getName());     
    }
    
    @Pointcut("execution(* com.fsoft.roomreservation.core.repository.*.*(..))")
    public void logEveryMethod(){}
    
    @Before("logSendEmail()")
    public void StartSendEmailLogger(JoinPoint jp) {
    	starterLog(jp);
    }
    
    @After("logSendEmail()")
    public void endSendEmailLogger(JoinPoint jp) {
    	endLogger(jp);
    }
    
    @Pointcut("execution(* com.fsoft.roomreservation.core.service.email.EmailService.sendEmail(..))")
    public void logSendEmail(){}
    
    
}