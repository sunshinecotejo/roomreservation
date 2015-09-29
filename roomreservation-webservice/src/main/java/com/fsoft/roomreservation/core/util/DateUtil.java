package com.fsoft.roomreservation.core.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil{
	
	final static SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
	
	public static Date getDateIncDays(Date date, int days){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); 
        return cal.getTime();
    }
	
	public static Date getIncDate(Date date, int duration, int field){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(field, duration); 
        return cal.getTime();
    }
	
	public static Long getTime(){
		return new Date().getTime();
	}
	
	public static Date toDate( String date ){
		return toDate( date, sdf );
	}
	
	public static Date toDate( String date, SimpleDateFormat sdf ){
		try{
			return sdf.parse(date);
		}catch( Exception ex ){
			ex.printStackTrace();
		}
		return null;
	}
	
	public static String getDate( Date date ){
		return getDate(date, sdf);
	}
	
	public static String getDate( Date date, SimpleDateFormat sdf ){
		try{ return sdf.format(date); }catch( Exception ex ){ }
		return null;
	}
	
//	public static void main( String[] args ){
//		SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
//		System.out.println("--------> " + getDate(new Date(), df));
//	}
	
}
