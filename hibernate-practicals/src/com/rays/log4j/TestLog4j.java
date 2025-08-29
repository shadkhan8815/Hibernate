package com.rays.log4j;

import org.apache.log4j.Logger;

public class TestLog4j {

	public static void main(String[] args) {

		Logger log = Logger.getLogger(TestLog4j.class);

		log.debug("DEBUG LEVEL....!!");
		log.info("INFO LEVEL.....!!");
		log.warn("WARN LEVEL......!!");
		log.error("ERROR LEVEL.....!!");
		log.fatal("FATAL LEVEL......!!");

		try {
			int a = 0;
			int b = 5/a ;
			
			System.out.println("Division :" + b);
			
		} catch (Exception e) {
			log.info("Arithmetic Exception");
		}
	}

}
