package com.OrangeHRM_Log4j;

import org.apache.log4j.Logger;

public class Log {
	
	private static Logger log=Logger.getLogger(Log.class.getName());
	
	public static void info(String message)
	{
		log.info(message);
	}
	

}
