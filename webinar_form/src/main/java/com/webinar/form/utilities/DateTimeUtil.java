package com.webinar.form.utilities;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
	
	public static String getSysDateTime(){
		
		/*DateFormat	dateFormat = new SimpleDateFormat("dd-MM-yyy hh:mm:ss a");
		Date date  = new Date();
		String	sysDate    = dateFormat.format(date);*/
		
		LocalDateTime localDate = LocalDateTime.now(ZoneId.of("GMT+05:30"));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyy hh:mm:ss a");
        String formatDateTime = localDate.format(formatter);
		
		return formatDateTime;
	}
     
}