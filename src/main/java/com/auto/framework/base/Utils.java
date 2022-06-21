package com.auto.framework.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Utils {
	/*
	 * Read a property from the config.properties file and return the value
     * If value not exist return a 'Value not set or empty' exception
	 */
	public static String readProperty(String property) {
		Properties prop;
		String value = null;
		try {
			prop = new Properties();
			prop.load(new FileInputStream(new File("config.properties")));
			
			value = prop.getProperty(property);
			
			if (value == null || value.isEmpty()) {
				throw new Exception("Value not set or empty");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}

}
