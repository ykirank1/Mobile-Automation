package com.auto.framework.base;

import org.apache.log4j.Logger;

public class Log {
	
    private static Logger Log = Logger.getLogger(Log.class.getName());
	
    public static void info (String object) {
        Log.info(object);
    }

    public static void error (String message) {
        Log.error(message);
    }
 
    public static void debug (String message) {
        Log.debug(message);
    }


}
