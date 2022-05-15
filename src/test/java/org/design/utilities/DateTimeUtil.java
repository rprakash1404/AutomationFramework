package org.design.utilities;

import java.util.Date;

import com.google.inject.Singleton;

@Singleton
public class DateTimeUtil {

	public String getCurrDateTimeStr() {
		Date d = new Date();
		return d.toString().replace(":", "_").replace(" ", "_");
	}
	
	public String getCurrTimeStr() {
		Date d = new Date();
		return d.toString().replace(":", "_").replace(" ", "_");
	}
	
}
