package com.fsoft.roomreservation.core.service.aop;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AspectService {
	
	protected static final Logger LOGGER = LoggerFactory.getLogger(LoggerAspectService.class);
	
    protected Date start;
	protected long starttime;
    protected long endtime;
    protected double elapsedtime;
	
	protected long getExecutionTime(Date startDate) {
        return ((System.currentTimeMillis() - startDate.getTime()) / 1000);
    }
}
