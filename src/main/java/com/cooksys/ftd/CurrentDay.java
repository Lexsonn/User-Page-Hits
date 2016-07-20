package com.cooksys.ftd;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDay {
	private static SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
	private static String createdOn = "18072016";
	
	public static Long getCurrentDay(Date currentDate) throws ParseException {
		Date createdDate = sdf.parse(createdOn);
		return daysBetween(createdDate,currentDate);
	}
	
	private static long daysBetween(Date d1, Date d2){
	    return (long)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}

}
