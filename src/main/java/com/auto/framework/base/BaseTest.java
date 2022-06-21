package com.auto.framework.base;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BaseTest {
	public  AppiumDriver<?> driver;
	
	public AppiumDriver<?> getDriver() {
		return driver;
	}
	
	//Method for adding logs passed from test cases
	 public void consoleLog(String message) {    
	    Log.info("Message: " + message);
	    Reporter.log(message);
	} 
	 
}
