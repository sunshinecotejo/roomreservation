package com.fsoft.roomreservation.core.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import com.fsoft.roomreservation.core.model.ClientResponseEntity;


@Aspect
@Service
public class RepositoryAspectService {
	
//    @AfterReturning(pointcut="execution(* com.fsoft.roomreservation.core.service.*.*(..))",returning="obj")
    public void finalizedRepository(JoinPoint jp, Object obj){
    	System.out.println(String.format("repository:after returning value : %s ",obj.getClass()));
    }
    
//    @AfterThrowing(pointcut="execution(* com.fsoft.roomreservation.core.repository.*.*(..))",throwing="ex")
    public String finalizedExceptions(Exception ex) {
    	System.out.println(String.format("repository:after throwing exception : %s ",ex.getMessage()));
    	return ex.getMessage();
    }
    
//    @AfterReturning(pointcut="execution(* com.fsoft.roomreservation.core.service.*.*(..))",returning="obj")
    public void afterfinalizedExceptions(){
    	
    }
    
//    @AfterReturning(pointcut="execution(* com.fsoft.roomreservation.core.service.*.*(..))",returning="obj")
    public void finalized(ProceedingJoinPoint jp, Object obj){
    	if( obj instanceof ClientResponseEntity ){
//    		((ClientResponseEntity)obj).setMessage(message);
    	}
    }
    
}