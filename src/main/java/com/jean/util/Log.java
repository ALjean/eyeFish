package com.jean.util;

import org.apache.log4j.Logger;

public class Log {

	private static Logger log = Logger.getLogger(Log.class);

	public static void startDaoLog(String methodName, String params) {
		log.info("Statrting DAO method: " + methodName + ". With parameters: " + params);
	}

	public static void endDaoLog(String methodName, String status) {
		log.info("Statrting DAO method: " + methodName + ". With status: " + status);
	}
	
	public static void daoException(String methodName, String message){
		log.error("Fail DAO method: " + methodName + ". Error message: " + message );
	}

}
