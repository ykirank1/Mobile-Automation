package com.auto.framework.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.appium.java_client.AppiumDriver;

public class TestListener extends BaseTest implements ITestListener {

	// Extent Report Declarations
	private static ExtentReports extent = ExtentManager.createInstance();
	ExtentManager em = new ExtentManager();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	private static Platform platform;
	public ExtentTest logger;

	@Override
	public synchronized void onStart(ITestContext context) {
		Log.info("=========== Test Suite started :- " + context.getName() + "===============");
		// System.out.println("Extent Reports Version 3 Test Suite started!");
	}

	@Override
	public synchronized void onFinish(ITestContext context) {
		Log.info("=========== Test Suite is ending :-  " + context.getName() + "===============");
		// System.out.println(("Extent Reports Version 3 Test Suite is
		// ending!"));
		extent.flush();
	}

	@Override
	public synchronized void onTestStart(ITestResult result) {
		Log.info(result.getMethod().getMethodName() + " Started");
		Log.info(result.getMethod().getDescription());
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),
				result.getMethod().getDescription());
		test.set(extentTest);

	}

	@Override
	public synchronized void onTestSuccess(ITestResult result) {
		// create new entry in result report
		// logger=extent.createTest(result.getName()); 
		 // send the passed information to the report with GREEN color highlighted		 
		 // logger.log(Status.PASS,MarkupHelper.createLabel(result.getName(),ExtentColor.GREEN)); 
		  test.get().log(Status.PASS,MarkupHelper.createLabel(result.getTestClass().getName()+"."+result.getName(),ExtentColor.GREEN)); 
		  
	   	Log.info("Testing Success "+result.getMethod().getMethodName() + " Passed");
		// test.get().pass("Test passed");
		//test.get().log(Status.PASS, result.getTestClass().getName() + "." + result.getName() + " - PASS");
	}

	@Override
	public synchronized void onTestFailure(ITestResult result) {
		
		// create new entry in result report
		// logger=extent.createTest(result.getName()); 
		 // send the failed information to the report with RED color highlighted		 
		test.get().log(Status.FAIL,MarkupHelper.createLabel(result.getTestClass().getName()+"."+result.getName(),ExtentColor.RED)); 
		   Log.info("Testing Failure "+result.getMethod().getMethodName() + " Failed!");
		// System.out.println((result.getMethod().getMethodName() + "
		// failed!"));
		Log.info("Failed because of - " + result.getMethod().getMethodName() + ":- "
				+ getStackTrace(result.getThrowable()));
		// test.get().fail(result.getThrowable());
		// ITestContext context = result.getTestContext();

		Class<?> clazz = result.getTestClass().getRealClass();
		Field field = null;
		AppiumDriver<?> driver = null;
		try {
			field = clazz.getField("driver");

			field.setAccessible(true);
			driver = (AppiumDriver<?>) field.get(result.getInstance());
	} catch (NoSuchFieldException e1) {
		// TODO Auto-generated catch block	
			e1.printStackTrace();
		} 
		catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String targetLocation = null;
		String testClassName = result.getTestClass().getName().trim();

		String testMethodName = result.getName().toString().trim();
		String screenShotName = testMethodName + java.time.LocalDateTime.now() + ".png";
		String fileSeperator = System.getProperty("file.separator");
		platform = ExtentManager.getCurrentPlatform();
		System.out.println("222" +platform);
		String reportsPath = ExtentManager.getReportLocation(platform) + fileSeperator + "screenshots";
		Log.info("Screen shots reports path - " + reportsPath);
		try {
			File file = new File(reportsPath + fileSeperator + testClassName);// Set
																				// screenshots
			if (!file.exists()) {
				if (file.mkdirs()) {
					Log.info("Directory: " + file.getAbsolutePath() + " is created!");
				} else {
					Log.info("Failed to create directory: " + file.getAbsolutePath());
				}

			}
			//File screenshotFile = driver.getScreenshotAs(OutputType.FILE);
			 File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			targetLocation = reportsPath + fileSeperator + testClassName + fileSeperator + screenShotName;// define
																											// location
			File targetFile = new File(targetLocation);
			Log.info("Screen shot file location - " + screenshotFile.getAbsolutePath());
			Log.info("Target File location - " + targetFile.getAbsolutePath());
			// FileHandler.copy(screenshotFile, targetFile);
			FileUtils.copyFile(screenshotFile, targetFile);
			//FileUtils.copyFile(SrcFile, new File(path));

		} catch (FileNotFoundException e) {
			Log.info("File not found exception occurred while taking screenshot " + e.getMessage());
		} catch (Exception e) {
			Log.info("An exception occurred while taking screenshot " + e.getCause());
		}

		// attach screenshots to report
		try {
			test.get().fail("Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(targetLocation).build());
		} catch (IOException e) {
			Log.info("An exception occured while taking screenshot " + e.getCause());
		}
		test.get().log(Status.FAIL, result.getTestClass().getName() + "." + result.getName()
				+ " Failed with exception : " + getStackTrace(result.getThrowable()));

	}
	
//	@Override
//	public void onTestFailure(ITestResult result) {
//		// TODO Auto-generated method stub
//		String methodName = result.getMethod().getMethodName();
//		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
//
//		test.get().fail("<details><summary><b><font color=red>" + "Exception Occured, click to see details:"
//				+ "</font></b></summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details> \n");
//
//		String path = takeScreenshot(methodName);
//
//		try {
//			test.get().fail("<b><font color=red>" + "Screenshot of failure" + "</font></b>",
//					MediaEntityBuilder.createScreenCaptureFromPath(path).build());
//		} catch (Exception e) {
//			test.get().fail("Test Failed, cannot attach screenshot");
//		}
//
//		String logText = "<b>Test Method " + methodName + " Failed</b>";
//		Markup markup = MarkupHelper.createLabel(logText, ExtentColor.RED);
//		test.get().log(Status.FAIL, markup);
//
//	}
//	
	public String takeScreenshot(String methodName) {
		String filename = getScreenshotName(methodName);
		String directory = System.getProperty("user.dir") + "/screenshots/";
		new File(directory).mkdirs();
		String path = directory + filename;

		try {
			TakesScreenshot screenshot = ((TakesScreenshot) driver);
			File SrcFile=screenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(SrcFile, new File(path));
			System.out.println("***************************************");
			System.out.println("Screenshot stored at: " + path);
			System.out.println("***************************************");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return path;
	}

	public static String getScreenshotName(String methodName) {
		Date date = new Date();
		String fileName = methodName + "_" + date.toString().replace(":", "_").replace(" ", "_") + ".png";
		return fileName;
	}

	@Override
	public synchronized void onTestSkipped(ITestResult result) {
		
		// create new entry in result report
		 logger=extent.createTest(result.getName()); 
		 // send the skipped information to the report with ORANGE color highlighted		 
		  logger.log(Status.PASS,MarkupHelper.createLabel(result.getName(),ExtentColor.ORANGE)); 
		Log.info(result.getMethod().getMethodName() + " Skipped!");
		// System.out.println((result.getMethod().getMethodName() + "
		// skipped!"));
		test.get().log(Status.SKIP, result.getTestClass().getName() + "." + result.getName() + " Skip with exception : "
				+ getStackTrace(result.getThrowable()));
		
		 logger=extent.createTest(result.getName()); // create new entry in th report

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		// create new entry in result report
		 logger=extent.createTest(result.getName()); 
		 // send the Failed But With in Success Percentage information to the report with YELLOW color highlighted		 
		  logger.log(Status.PASS,MarkupHelper.createLabel(result.getName(),ExtentColor.YELLOW)); 
		Log.info("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName() + " --> "
				+ result.getThrowable());
		test.get().log(Status.FAIL, result.getTestClass().getName() + "." + result.getName()
				+ " Failed with exception : " + getStackTrace(result.getThrowable()));
		// System.out.println(("onTestFailedButWithinSuccessPercentage for " +
		// result.getMethod().getMethodName()));
	}

	protected String getStackTrace(Throwable t) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		t.printStackTrace(pw);
		return sw.toString();
	}

}