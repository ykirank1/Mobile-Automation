package com.cnhi.pageObjects;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;

import com.auto.framework.base.Log;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.offset.PointOption;

public class LoginPage  {

	public AppiumDriver<?> driver;
	GenericPage gMob;
	JobCardPage jobCardPage;
	MileageTachoPage mileageTachoPage;

	public LoginPage(AppiumDriver<?> driver, GenericPage ttMob) {
		this.driver= driver;
		this.gMob=ttMob;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='username']/android.widget.EditText")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Username']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTextField")
	private MobileElement usernameTxtBox;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='password']/android.widget.EditText")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Password']/parent::XCUIElementTypeOther/following-sibling:: XCUIElementTypeSecureTextField")
	private MobileElement passwordTxtBox;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='loginButton']/android.widget.Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Sign in']")
	private MobileElement signInBtn;
	
	public void enterUsername(String UserName) {
		gMob.waitForVisibility(usernameTxtBox, driver);
		gMob.clickElement(usernameTxtBox, "Click On Username Textbox");
		gMob.sendKeysOnTextBox(usernameTxtBox, UserName, UserName+": Username Entered Successfully");
	}

	public void enterPassword(String Password) {
		gMob.clickElement(passwordTxtBox, "Click On Password Textbox");
		gMob.sendKeysOnTextBox(passwordTxtBox, Password, Password+": Password Entered Successfully");
	}

	public void clickOnSignInBtn() throws InterruptedException {
		Thread.sleep(3000);
		gMob.clickElement(signInBtn, "Click On Sign In Button");
	}

	public boolean isSignInBtnVisible() {
		return gMob.isElementDisplay(signInBtn, "Sign In Button Visible");
	}
	
	
	public void tapOnLoginScreen() throws InterruptedException {
		Thread.sleep(20000);
	    System.out.println("Tap on screen");
		new TouchAction(driver).tap(PointOption.point(787, 1580)).perform();
		Thread.sleep(15000);		
	}
	
	public void loginToApplication(String UserName, String Password) throws InterruptedException {
		Thread.sleep(20000);
		tapOnLoginScreen();
		enterUsername(UserName);
		enterPassword(Password);
		clickOnSignInBtn();
		
	}

}
