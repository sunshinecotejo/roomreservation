package com.fsoft.roomreservation.core.service.aop;

import java.net.SocketException;

import javax.mail.MessagingException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fsoft.roomreservation.core.model.Reservation;
import com.fsoft.roomreservation.core.service.email.EmailService;


@Aspect
@Service
public class EmailAspectService extends AspectService{
	
    @Autowired
    @Qualifier("emailService")
    EmailService emailSvc;
    
    @AfterReturning(pointcut="execution(* com.fsoft.roomreservation.core.service.ReservationService.create(..))",returning="obj")
    public void sendNotification(JoinPoint jp, Object obj){
    	if( obj instanceof Reservation ){
    		Reservation reservation = (Reservation)obj;
    		if( null != reservation ){
    			emailSvc.sendEmail(reservation);
    		}
    	}
    }
    
    @AfterReturning(pointcut="execution(* com.fsoft.roomreservation.core.service.ReservationService.update(..))",returning="obj")
    public void sendUpdateNotification(JoinPoint jp, Object obj){
    	if( obj instanceof Reservation ){
    		Reservation reservation = (Reservation)obj;
    		if( null != reservation ){
    			emailSvc.sendEmail(reservation);
    		}
    	}
    }
    
    @AfterThrowing(pointcut="execution(* com.fsoft.roomreservation.core.service.ReservationService.create(..))",throwing="ex")
    public void doRecoveryActions(MessagingException ex) {
    	Exception next = ex.getNextException();
    	if( next instanceof SocketException ){
    		LOGGER.info("Re-sending email.");
    	}else{
    		LOGGER.info("Un-able to send email.");
    	}
    }
    
    
    
    
}