package com.cnhi.pageObjects;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomePage  {

	public AppiumDriver<?> driver;
	GenericPage gMob;

	public HomePage(AppiumDriver<?> driver, GenericPage ttMob) {
		this.driver= driver;
		this.gMob=ttMob;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='jobcard']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='JobCard']")
	private MobileElement jobCardOption;

	public void clickOnJobCardOption() {
		gMob.waitForVisibility(jobCardOption, driver);
		gMob.clickElement(jobCardOption, "Click On Job Card Option");
	}


}
