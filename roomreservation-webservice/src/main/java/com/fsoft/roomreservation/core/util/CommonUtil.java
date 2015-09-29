package com.fsoft.roomreservation.core.util;

import org.hibernate.Session;

public class CommonUtil {
	public static void closeQuitely( AutoCloseable resource ){
		if( null != resource ){
			try{ resource.close();}catch( Exception ex ){;}
		}
	}
	
	public static void closeQuitely( Session session ){
		if( null != session ){
			try{ session.close();}catch( Exception ex ){;}
		}
	}
	
	public static boolean isNull( Object... object ){
		for(Object obj : object ){
			return (null == obj);
		}
		
		return true;
	}
}
