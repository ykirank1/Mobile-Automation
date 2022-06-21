package com.cnhi.pageObjects;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.KeyInput;
import org.openqa.selenium.interactions.Sequence;

import com.auto.framework.base.BaseTest;
import com.auto.framework.base.Log;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class GenericPage {

	// public AppiumDriver<?> driver;
	private final int IMPLICIT_WAIT = 90;

	public GenericPage() {
	}


	// Click To Element
	public void clickElement(MobileElement ele, String logMessage) {
		ele.click();
		Log.info(logMessage);

	}

	// Clear The Text Box
	public void clearTextBox(MobileElement ele, String logMessage) {

		ele.clear();
		Log.info(logMessage);

	}

	// Send Text To Text Box
	public void sendKeysOnTextBox(MobileElement ele, String text, String logMessage) {
		ele.sendKeys(text);
		Log.info(logMessage);

	}
	
	// Send Text To Text Box
	public void sendKeysOnTextBox(MobileElement ele, String text, String logMessage,AppiumDriver<?> driver) {
		//ele.sendKeys(text);
		new Actions(driver).sendKeys(text).perform();
		Log.info(logMessage);

	}

	// Verify Element Visibility Without Handling Wait
	public boolean isElementDisplay(MobileElement ele, String logMessage) {
		try {
			boolean b = ele.isDisplayed();
			Log.info(logMessage);
			return b;
		} catch (Exception e) {
			return false;
		}
	}

	// Wait For The Element Visibility
	public void waitForVisibility(MobileElement e, AppiumDriver<?> driver) {
		WebDriverWait wait = new WebDriverWait(driver, IMPLICIT_WAIT);
		wait.until(ExpectedConditions.visibilityOf(e));
	}

	// Tap by coordinates
	public void tapByCoordinates(int x, int y, AppiumDriver<?> driver) {

		TouchAction action = new TouchAction(driver);
		action.tap(PointOption.point(x, y)).perform();
	}

	// Swipe To Element according To Direction
	public MobileElement swipeToElement(MobileElement element, String direction, AppiumDriver<?> driver)
			throws Exception {
		Dimension size = driver.manage().window().getSize();
		int startX = (int) (size.width * 0.5);
		int endX = (int) (size.width * 0.5);
		int startY = 0;
		int endY = 0;
		boolean isFound = false;

		switch (direction) {
		case "up":
			endY = (int) (size.height * 0.4);
			startY = (int) (size.height * 0.6);
			break;

		case "down":
			endY = (int) (size.height * 0.6);
			startY = (int) (size.height * 0.4);
			break;
		}

		for (int i = 0; i < 10; i++) {
			if (isElementVisibleWithinGivenTime(element, 1, driver)) {
				isFound = true;
				break;
			} else {
				swipe(startX, startY, endX, endY, 1000, driver);
			}
		}
		if (!isFound) {
			throw new Exception("Element not found");
		}
		return element;
	}

	// Swipe To Element according To Direction
	public void swipeUpDown(String direction, AppiumDriver<?> driver) throws Exception {
		Dimension size = driver.manage().window().getSize();
		System.out.println("Size: "+size);
		int startX = (int) (size.width * 0.5);
		int endX = (int) (size.width * 0.5);
		int startY = 0;
		int endY = 0;

		switch (direction) {
		case "up":
			endY = (int) (size.height * 0.4);
			startY = (int) (size.height * 0.6);
			break;

		case "down":
			endY = (int) (size.height * 0.6);
			startY = (int) (size.height * 0.4);
			break;
		}

		swipe(startX, startY, endX, endY, 1000, driver);

	}

	// Swipe Using Directions
	public void swipe(int startX, int startY, int endX, int endY, int millis, AppiumDriver<?> driver)
			throws InterruptedException {
		TouchAction t = new TouchAction(driver);
		WaitOptions waitOptions = new WaitOptions();
		waitOptions.withDuration(Duration.ofMillis(millis));
		t.press(PointOption.point(startX, startY)).waitAction(waitOptions).moveTo(PointOption.point(endX, endY)).release().perform();
	}

	public void swiping(MobileElement element, int endX, int endY, int millis, AppiumDriver<?> driver)
			throws InterruptedException {

		new TouchAction(driver)
				.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(element))
						.withDuration(Duration.ofMillis(millis)))
				.moveTo(PointOption.point(endX, endY)).release().perform();
	}

	// Verify Element Visibility With Handling Wait And With The Time We Provide
	public boolean isElementVisibleWithinGivenTime(MobileElement element, int timeout, AppiumDriver<?> driver) {
		boolean b = false;
		try {

			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOf(element));
			b = element.isDisplayed();
			if (b) {
				return b;
			} else {
				return b;
			}
		} catch (Exception e) {
			return false;
		}
	}

	// Get Current Date And Time
	public String getCurrentDate(String dateFormat) {
		SimpleDateFormat SDFormat = new SimpleDateFormat(dateFormat);
		Date date = new Date();
		String str_Date = SDFormat.format(date);
		return str_Date;
	}

	// Get Element Attribute Value
	public String getElementText(MobileElement element, String Attribute, String logMessage) {
		Log.info(logMessage);
		return element.getAttribute(Attribute);
	}

	// Scroll Down
	public void scrollDown(AppiumDriver<?> driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "down");
		js.executeScript("mobile: scroll", scrollObject);
	}
	

	// Scroll Up
	public void scrollUp(AppiumDriver<?> driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "up");
		js.executeScript("mobile: scroll", scrollObject);
	}

	// Scroll Down To Element
	public void scrollDownWithElement(MobileElement element, String direction, AppiumDriver<?> driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", direction);
		scrollObject.put("element", element.getId());
		js.executeScript("mobile: scroll", scrollObject);
	}

	// Scroll To Element Handle With Exception
	public void scrollToElemet(MobileElement element, AppiumDriver<?> driver) throws Exception {
		boolean isFound = false;
		Log.info("Scrolling to Element");
		for (int i = 0; i < 10; i++) {
			if (isElementVisibleWithinGivenTime(element, 1, driver)) {
				isFound = true;
				break;
			} else {
				scrollDown(driver);
			}
		}
		if (!isFound) {
			throw new Exception("Element not found");
		}

	}

	public void ClickByScrollToElementWithXpath(String xPath, AppiumDriver<?> driver) throws Exception {
		for (int i = 0; i < 20; i++) {
			try {
				Log.info("Waiting for the Viaibility of Element: " + i);
				MobileElement ele = (MobileElement) driver.findElement(By.xpath(xPath));
				if (isElementVisibleWithinGivenTime(ele, 1, driver)) {
					clickElement(ele, "Element Found Performing Click");
					break;
				} else {
					scrollDown(driver);
				}
			} catch (Exception e) {
				scrollDown(driver);
				Log.info(e.getMessage());
				Log.info("Element Not Visible");
				if (i >= 19) {
					e.printStackTrace();
					throw new Exception();

				}
			}
		}
	}

	public void scrollToElementWithXpath(String xPath,String device, AppiumDriver<?> driver) throws Exception {
		for (int i = 0; i < 20; i++) {
			try {
				Log.info("Waiting for the Viaibility of Element: " + i);
				MobileElement ele = (MobileElement) driver.findElement(By.xpath(xPath));
				if (isElementVisibleWithinGivenTime(ele, 3, driver)) {
					break;
				} else {
					MoveDownScreenAccordingToDevice(device,driver);
				}
			} catch (Exception e) {
				MoveDownScreenAccordingToDevice(device,driver);
				Log.info(e.getMessage());
				Log.info("Element Not Visible");
				if (i >= 19) {
					e.printStackTrace();
					throw new Exception();

				}
			}
		}
	}

	// Swipe by elements
	public void swipeByElements(MobileElement startElement, MobileElement endElement, AppiumDriver<?> driver)
			throws InterruptedException {
		int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
		int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);
		int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
		int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);
		swipe(startX, startY, endX, endY, 1000, driver);

	}

	// Waiting For The Element To Visible Using Thread Waiting And Handling
	// Exception
	public boolean WaitingAndReturningElementVisibility(MobileElement startElement) {
		boolean b = false;
		for (int i = 0; i <= 30; i++) {
			try {
				Thread.sleep(2000);
				b = startElement.isDisplayed();
				if (b) {
					break;
				}
			} catch (Exception e) {
				Log.info("Waited For " + i + " Elemnt Not Visible");
				Log.info(e.getMessage());
				return false;
			}

		}
		return b;

	}

	// Waiting For The Element To Visible Using Thread Waiting And Handling
	// Exception
	public boolean WaitingAndReturningElementVisibilityUsingXpath(String Xpath, AppiumDriver<?> driver) {
		boolean b = false;
		for (int i = 0; i <= 30; i++) {
			try {
				Thread.sleep(2000);
				b = driver.findElement(By.xpath(Xpath)).isDisplayed();
				if (b) {
					break;
				}
			} catch (Exception e) {
				Log.info("Waited For " + i + " Elemnt Not Visible");
				Log.info(e.getMessage());
				return false;
			}

		}
		return b;

	}

	public void scrollToView(AppiumDriver<?> driver) {
		Dimension dimension = driver.manage().window().getSize();

		Double scrollHeightStart = dimension.getHeight() * 0.5;
		int scrollStart = scrollHeightStart.intValue();

		Double scrollHeightEnd = dimension.getHeight() * 0.2;
		int scrollEnd = scrollHeightEnd.intValue();

		new TouchAction((PerformsTouchActions) driver).press(PointOption.point(0, scrollStart))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(0, scrollEnd))
				.release().perform();

	}

	public void swipeOneElementToAnotherElement(MobileElement startElement, MobileElement endElement,
			AppiumDriver<?> driver) {
		TouchAction action = new TouchAction(driver);
		action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(endElement)))
				.moveTo(PointOption.point(10, 10)).release().perform();
	}
	
	public void sendtext(AppiumDriver<?> driver) {
		KeyInput keyboard = new KeyInput("keyboard");
		Sequence sendKeys = new Sequence(keyboard, 0);
		sendKeys.addAction(keyboard.createKeyUp("1".codePointAt(0)));
		sendKeys.addAction(keyboard.createKeyUp("2".codePointAt(0)));
		driver.perform(Arrays.asList(sendKeys));
	}
	
	// Swipe To Element according To Direction
		public void swipeToWebElement(WebElement element, AppiumDriver<?> driver)
				throws Exception {
			JavascriptExecutor js= (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);",element);
			

		}
	
//	public WebElement swipeToWebElement(WebElement element, AppiumDriver<?> driver)
//			throws Exception {
//		JavascriptExecutor js= (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView();",element);
//		return element;
//		
//
//	}
		
		// Swipe To Element according To Direction
		public void swipeToMobileElement(MobileElement element,AppiumDriver<?> driver)
				throws Exception {
			JavascriptExecutor js= (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);",element);
			

		}
		
		
		public void turnOnWiFi(String WiFiStatus) throws IOException {
			
			if (WiFiStatus=="disable") {
			Runtime.getRuntime().exec("adb shell am broadcast -a io.appium.settings.wifi --es setstatus disable"); }
			else {
			Runtime.getRuntime().exec("adb shell am broadcast -a io.appium.settings.wifi --es setstatus enable"); }
			Log.info("WiFi Mode " + WiFiStatus + " on the Emulator");
			
		}
		
		
		
		
		private void runCommand(String adbCommand) {
			// TODO Auto-generated method stub
			
		}


		// Verify Element Visibility With Handling Wait And With The Time We Provide
		public boolean isWebElementVisibleWithinGivenTime(WebElement element, int timeout, AppiumDriver<?> driver) {
			boolean b = false;
			try {

				WebDriverWait wait = new WebDriverWait(driver, timeout);
				wait.until(ExpectedConditions.visibilityOf(element));
				b = element.isDisplayed();
				if (b) {
					return b;
				} else {
					return b;
				}
			} catch (Exception e) {
				return false;
			}
		}
		
		 public void MoveDownScreenAccordingToDevice(String device, AppiumDriver<?> driver) throws Exception {

		        if (device.equalsIgnoreCase("Android")) {

		            swipeUpDown("up", driver);

		        } else {

		            scrollDown(driver);

		        }

		    }
		 
		 public boolean isWebElementVisibleWithXpath(String xPath, WebDriver driver) {
			 try {
				 WebElement ele = driver.findElement(By.xpath(xPath));
				return ele.isDisplayed();
			 }
			 catch(Exception e) {
				 return false;
				
			 }
		 }
			public void MoveDownScreenWithElementAccordingToDevice(MobileElement element, String device, AppiumDriver<?> driver)
					throws Exception {
				if (device.equalsIgnoreCase("Android")) {
					swipeToElement(element, "up", driver);
				} else {
					scrollToElemet(element, driver);
				}
			}

			
			
			
			
}
