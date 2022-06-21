package com.cnhi.pageObjects;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import com.auto.framework.base.Log;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class TravelPage {

	public AppiumDriver<?> driver;
	GenericPage gMob;

	public TravelPage(AppiumDriver<?> driver, GenericPage ttMob) {
		this.driver = driver;
		this.gMob = ttMob;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='Travel']/android.widget.Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='menu']")
	private MobileElement travelMenuoption;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='New Travel']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='menu']")
	private MobileElement newTravelButton;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Add a travel']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='menu']")
	private MobileElement addTravelLabel;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Name']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='menu']")
	private MobileElement addTravelNameLabel;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='CANCEL']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='menu']")
	private MobileElement addTravelCANCELBtn;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='CONTINUE']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='menu']")
	private MobileElement addTravelCONTINUEBtn;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='jobcard-travel-name']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='menu']")
	private MobileElement addTravelNameTxt;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Travel Description']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='menu']")
	private MobileElement travelDescriptionLabel;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='W90041D']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='menu']")
	private MobileElement travelUserLabel;
	
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Travel 01']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='menu']")
	private MobileElement travelNameLabel;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='00:00:00']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='menu']")
	private MobileElement travelTimeFieldDuration;
	
	@AndroidFindBy(xpath = "(//android.view.View/android.widget.Button)[5]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='menu']")
	private MobileElement travelRunIconButton;
	
	@AndroidFindBy(xpath = "(//android.view.View/android.widget.Button)[6]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='menu']")
	private MobileElement travelDeleteButton;
	
	@AndroidFindBy(xpath = "(//android.view.View/android.widget.EditText)[3]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='menu']")
	private MobileElement travelTimeDuration;
	
	
	@AndroidFindBy(xpath = "(//android.view.View/android.widget.EditText)[2]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='menu']")
	private MobileElement enterTravelDistance;
	
	
	
	public boolean GetTravelTimeDuration(String recordedTime) throws Exception {
		gMob.waitForVisibility(travelTimeDuration, driver);
		return gMob.getElementText(travelTimeDuration, "text", "Travel time duration").equals(recordedTime);
		
	}
	
	
	public void clickOnTravelMenuButton() {
		gMob.waitForVisibility(travelMenuoption, driver);
		gMob.clickElement(travelMenuoption, "Click On Travel Menu Button");
	}
	
	public void clickOnNewTravelButton() {
		gMob.waitForVisibility(newTravelButton, driver);
		gMob.clickElement(newTravelButton, "Click On New Travel Button");
	}
	

	public boolean isAddTravelLabelVisible() throws Exception {
		gMob.waitForVisibility(addTravelLabel, driver);
		return gMob.isElementDisplay(addTravelLabel, "Add Travel Label Is Visible");
	}
	
	public boolean isAddTravelNameVisible() throws Exception {
		gMob.waitForVisibility(addTravelNameLabel, driver);
		return gMob.isElementDisplay(addTravelNameLabel, "Add Travel Name Is Visible");
	}
	
	public boolean isAddTravelCANCELBtnVisible() throws Exception {
		gMob.waitForVisibility(addTravelCANCELBtn, driver);
		return gMob.isElementDisplay(addTravelCANCELBtn, "Add Travel CANCEL Button Is Visible");
	}
	
	
	public boolean isAddTravelCONTINUEBtnVisible() throws Exception {
		gMob.waitForVisibility(addTravelCONTINUEBtn, driver);
		return gMob.isElementDisplay(addTravelCONTINUEBtn, "Add Travel CONTINUE Button Is Visible");
	}
	
	public void enterTravelNameTextBox(String Traveltext) {
		gMob.waitForVisibility(addTravelNameTxt, driver);
		gMob.clickElement(addTravelNameTxt, "Click On Travel Name Text Box");
		gMob.clearTextBox(addTravelNameTxt, "Clear Travel Name Text Box");
		gMob.sendKeysOnTextBox(addTravelNameTxt, Traveltext, "Entering Travel Name");
		gMob.tapByCoordinates(addTravelNameTxt.getLocation().x, addTravelNameTxt.getLocation().y, driver);

	}
	
	
	
	public void enterTravelDistanceTextBox(String Traveltext) {
		gMob.waitForVisibility(enterTravelDistance, driver);
		gMob.clickElement(enterTravelDistance, "Click On Travel Distance Text Box");
		gMob.clearTextBox(enterTravelDistance, "Clear Distance Text Box");
		gMob.sendKeysOnTextBox(enterTravelDistance, Traveltext, "Entering Travel Distance");
		gMob.tapByCoordinates(enterTravelDistance.getLocation().x, enterTravelDistance.getLocation().y, driver);

	}
	
	
	public void clickOnCONTINUEWButton() {
		gMob.waitForVisibility(addTravelCONTINUEBtn, driver);
		gMob.clickElement(addTravelCONTINUEBtn, "Click On New Travel CONTINUE Button");
	}
	
	public boolean isTravelDescriptionLabelVisible() throws Exception {
		gMob.waitForVisibility(travelDescriptionLabel, driver);
		return gMob.isElementDisplay(travelDescriptionLabel, "Travel Description Label Is Visible");
	}
	
	public boolean istravelUserLabelVisible() throws Exception {
		gMob.waitForVisibility(travelUserLabel, driver);
		return gMob.isElementDisplay(travelUserLabel, "Travel User Label Is Visible");
	}
	
	public boolean istravelNameLabelVisible() throws Exception {
		gMob.waitForVisibility(travelNameLabel, driver);
		return gMob.isElementDisplay(travelNameLabel, "Travel Name Label Is Visible");
	}
	
	public boolean istravelTimeFieldDurationVisible() throws Exception {
		gMob.waitForVisibility(travelTimeFieldDuration, driver);
		return gMob.isElementDisplay(travelTimeFieldDuration, "Travel Time Field Duration Text Box Is Visible");
	}
	
	public boolean istravelRunIconButtonVisible() throws Exception {
		gMob.waitForVisibility(travelRunIconButton, driver);
		return gMob.isElementDisplay(travelRunIconButton, "Travel Run Button Is Visible");
	}
	
	public boolean istravelDeleteButtonVisible() throws Exception {
		gMob.waitForVisibility(travelDeleteButton, driver);
		return gMob.isElementDisplay(travelDeleteButton, "Travel Delete Button Is Visible");
	}
	
	public void clickOnRunIconOnTravelDescriptionPage() {
		gMob.waitForVisibility(travelRunIconButton, driver);
		gMob.clickElement(travelRunIconButton, "Click On Run Icon On Travel DescriptionPage");
	}
	
	public void clickOnStopIconOnTravelDescriptionPage() {
		gMob.waitForVisibility(travelRunIconButton, driver);
		gMob.clickElement(travelRunIconButton, "Click On Stop Icon On Travel DescriptionPage");
	}
	public void clickOnTravelDeleteButton() {
		gMob.waitForVisibility(travelDeleteButton, driver);
		gMob.clickElement(travelDeleteButton, "Click On Delete Icon On Travel DescriptionPage");
	}
	
	@AndroidFindBy(xpath = "(//android.view.View[@text='W90041D']/parent::android.view.View/android.view.View)[3]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Add another item'])[2]")
	private MobileElement travelNameTxtBox;
	
	@AndroidFindBy(xpath = "(//android.view.View[@text='W90041D']/parent::android.view.View/android.view.View)[4]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Add another item'])[2]")
	private MobileElement travelDistanceTxtBox;
	
	public String getTravelNameFromTravelDescriptionPage(String device) throws Exception {
		gMob.swipeToElement(travelNameTxtBox, "up", driver);
		gMob.waitForVisibility(travelNameTxtBox, driver);
		String desc = null;
		if (device.equalsIgnoreCase("Android")) {
			desc = gMob.getElementText(travelDistanceTxtBox, "text", "Getting Travel Name from Travel Description Page");
		} else {
			desc = gMob.getElementText(travelDistanceTxtBox, "value", "Getting Travel Name from Travel Description Page");
		}
		Log.info(desc);
		return desc;
	}
	public String getTravelDistanceFromTravelDescriptionPage(String device) throws Exception {
		gMob.swipeToElement(travelNameTxtBox, "up", driver);
		gMob.waitForVisibility(travelNameTxtBox, driver);
		String desc = null;
		if (device.equalsIgnoreCase("Android")) {
			desc = gMob.getElementText(travelNameTxtBox, "text", "Getting Travel Distance from Travel Description Page");
		} else {
			desc = gMob.getElementText(travelNameTxtBox, "value", "Getting Travel Distance from Travel Description Page");
		}
		Log.info(desc);
		return desc;
	}
	
	
	
}