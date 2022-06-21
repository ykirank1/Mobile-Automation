package com.cnhi.pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class DamagesPage {

	public AppiumDriver<?> driver;
	GenericPage gMob;

	public DamagesPage(AppiumDriver<?> driver, GenericPage ttMob) {
		this.driver = driver;
		this.gMob = ttMob;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.view.View[@text='Vehicle front']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Vehicle front']")
	private MobileElement vehicleFrontLabel;

	@AndroidFindBy(xpath = "//android.view.View[@text='Vehicle back']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Vehicle back']")
	private MobileElement vehicleBackLabel;

	@AndroidFindBy(xpath = "//android.view.View[@text='Vehicle right side']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Vehicle right side']")
	private MobileElement vehicleRightSideLabel;

	@AndroidFindBy(xpath = "//android.view.View[@text='Vehicle left side']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Vehicle left side']")
	private MobileElement vehicleLeftSideLabel;

	@AndroidFindBy(xpath = "//android.view.View[@text='Vehicle front']/parent::android.view.View/following-sibling::android.view.View[1]/android.view.View/android.view.View[@text='Add damage']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Vehicle front']/following:: XCUIElementTypeImage)[1]")
	private MobileElement addDamageVehicleFrontIcon;

	@AndroidFindBy(xpath = "//android.view.View[@text='Vehicle back']/parent::android.view.View/following-sibling::android.view.View[1]/android.view.View/android.view.View[@text='Add damage']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Vehicle back']/following:: XCUIElementTypeImage)[1]")
	private MobileElement addDamageVehicleBackIcon;

	@AndroidFindBy(xpath = "//android.view.View[@text='Vehicle right side']/parent::android.view.View/following-sibling::android.view.View[1]/android.view.View/android.view.View[@text='Add damage']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Vehicle right side']/following:: XCUIElementTypeImage)[1]")
	private MobileElement addDamageVehicleRightSideIcon;

	@AndroidFindBy(xpath = "//android.view.View[@text='Vehicle left side']/parent::android.view.View/following-sibling::android.view.View[1]/android.view.View/android.view.View[@text='Add damage']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Vehicle left side']/following:: XCUIElementTypeImage)[1]")
	private MobileElement addDamageVehicleLeftSideIcon;

	@AndroidFindBy(xpath = "//android.view.View/android.widget.Image")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Vehicle front']/following-sibling:: XCUIElementTypeImage[@name='#']")
	private MobileElement photoVehicleFrontImage;

	@AndroidFindBy(xpath = "//android.view.View[@text='Vehicle back']/parent::android.view.View/android.view.View/following::android.view.View[2]/android.widget.Image[@text='#']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Vehicle front']/following-sibling:: XCUIElementTypeImage[@name='#']")
	private MobileElement photoVehicleBackImage;
	
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Vehicle right side']/parent::android.view.View/following-sibling::android.view.View[1]/android.view.View[1]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Vehicle right side']/following-sibling:: XCUIElementTypeImage[@name='#']")
	private MobileElement photoVehicleRightSideImage;

	@AndroidFindBy(xpath = "//android.widget.CheckBox[starts-with(@resource-id,'ion-tg')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch")
	private MobileElement cardAndTruckViewToggle;

	@AndroidFindBy(xpath = "//android.view.View[@text='Click on truck to add information']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Click on truck to add information']")
	private MobileElement clickOnTruckToAddInFormationLabel;

	@AndroidFindBy(xpath = "//android.widget.Spinner/android.view.View[@text='Daily']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Click on truck to add information']/following:: XCUIElementTypeOther)[1]")
	private MobileElement truckScreenDropdown;

	@AndroidFindBy(xpath = "//android.widget.Image[@text='img']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='img']")
	private List<MobileElement> truckImages;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='OK']")
	private MobileElement okBtn;
	
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='gallery']/android.widget.Button")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Service App']//XCUIElementTypeButton)[last()-1]")
	private MobileElement addImageIcon;
	
	@AndroidFindBy(xpath = "//android.widget.Image[@text='img']/following-sibling::android.view.View/android.view.View[15]/android.view.View/android.view.View/android.widget.Button")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name=\"img\"]/following-sibling:: XCUIElementTypeOther/XCUIElementTypeButton)[1]")
	private MobileElement addedMediaIcon;
	
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='photocamera']/android.widget.Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='You confirm that you had read and accepted the Terms and Conditions']")
	private MobileElement photoCamera;
	
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='videocamera']/android.widget.Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement videoCamera;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='SUBMIT']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Submit']")
	private MobileElement submitBtn;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='CANCEL']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement cancelBtn;
	
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='comment']/android.widget.Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement noteIcon;
	
	@AndroidFindBy(xpath = "(//android.widget.Image[@text='img']/following-sibling::android.view.View/android.view.View[15]/android.view.View/android.view.View/android.widget.Button)[2]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name=\"img\"]/following-sibling:: XCUIElementTypeOther/XCUIElementTypeButton)[1]")
	private MobileElement addedMediaSecondTruckIcon;

	@AndroidFindBy(xpath = "(//android.widget.Image[@text='img']/following-sibling::android.view.View/android.view.View)[39]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name=\"img\"]/following-sibling:: XCUIElementTypeOther/XCUIElementTypeButton)[1]")
	private MobileElement addedSecondMediaTruckIcon;
	
	

	public boolean isVehicleFrontLabelVisible() throws Exception {
		gMob.swipeToElement(vehicleFrontLabel, "up", driver);
		return gMob.isElementDisplay(vehicleFrontLabel, "Vehicle Front label Visible Successfully");
	}

	public boolean isVehicleBackLabelVisible() throws Exception {
		gMob.swipeToElement(vehicleBackLabel, "up", driver);
		return gMob.isElementDisplay(vehicleBackLabel, "Vehicle Back label Visible Successfully");
	}

	public boolean isVehicleRightSideLabelVisible() throws Exception {
		gMob.swipeToElement(vehicleRightSideLabel, "up", driver);
		return gMob.isElementDisplay(vehicleRightSideLabel, "Vehicle Right Side label Visible Successfully");
	}

	public boolean isVehicleLeftSideLabelVisible() throws Exception {
		gMob.swipeToElement(vehicleLeftSideLabel, "up", driver);
		return gMob.isElementDisplay(vehicleLeftSideLabel, "Vehicle Left Side label Visible Successfully");
	}

	public void swipeUpTheScreen() throws Exception {
		gMob.swipeToElement(vehicleFrontLabel, "down", driver);
	}

	public void clickOnAddDamageVehicleFrontIcon() throws Exception {
		gMob.swipeToElement(addDamageVehicleFrontIcon, "up", driver);
		gMob.clickElement(addDamageVehicleFrontIcon, "Click On Add Damage Vehicle Front Icon");
	}

	public void clickOnAddDamageVehicleBackIcon() throws Exception {
		gMob.swipeToElement(addDamageVehicleBackIcon, "up", driver);
		gMob.clickElement(addDamageVehicleBackIcon, "Click On Add Damage Vehicle Back Icon");
	}

	public void clickOnAddDamageVehicleRightSideIcon() throws Exception {
		gMob.swipeToElement(addDamageVehicleRightSideIcon, "up", driver);
		gMob.clickElement(addDamageVehicleRightSideIcon, "Click On Add Damage Vehicle Right Side Icon");
	}

	public void clickOnAddDamageVehicleLeftSideIcon() throws Exception {
		gMob.swipeToElement(addDamageVehicleLeftSideIcon, "up", driver);
		gMob.clickElement(addDamageVehicleLeftSideIcon, "Click On Add Damage Vehicle Left Side Icon");
	}

	public boolean isPhotoVehicleFrontImageVisible() throws Exception {
		gMob.swipeToElement(photoVehicleFrontImage, "up", driver);
		return gMob.isElementDisplay(photoVehicleFrontImage, "Image Successfully Added For Vehicle Front ");
	}

	public void clickOnAddedImageFromVehicleFront() throws Exception {
		gMob.swipeToElement(photoVehicleFrontImage, "up", driver);
		gMob.clickElement(photoVehicleFrontImage, "Click The Added Image From Vehicle Front Section");
	}

	public boolean isPhotoVehicleRightSideImageVisible() throws Exception {
		for (int i = 0; i <= 2; i++) {
			gMob.swipeUpDown("up", driver);
		}
		gMob.swipeToElement(photoVehicleRightSideImage, "up", driver);
		return gMob.isElementDisplay(photoVehicleRightSideImage, "Image Successfully Added For Vehicle Right Side ");
	}

	public void clickOnSwitchToggleButton() throws Exception {
		for (int i = 0; i <= 3; i++) {
			gMob.swipeUpDown("down", driver);
		}
		gMob.swipeToElement(cardAndTruckViewToggle, "down", driver);
		gMob.clickElement(cardAndTruckViewToggle, "Click In Switch Toggle Button ");
	}

	public boolean isClickOnTruckToAddInFormationLabelVisible() throws Exception {
		gMob.swipeToElement(clickOnTruckToAddInFormationLabel, "up", driver);
		return gMob.isElementDisplay(clickOnTruckToAddInFormationLabel,
				"Click On Truck To Add Information Label Is Visible");
	}

	public String gettruckScreenDropdownDefaultValue() throws Exception {
		gMob.swipeToElement(truckScreenDropdown, "up", driver);
		return gMob.getElementText(truckScreenDropdown, "name", gettruckScreenDropdownDefaultValue());
	}

	public int getTruckImagesCount() {
		return truckImages.size();
	}
	
	public void selectValueFromTruckScreenDropDown(String option, String device)
			throws Exception {
		String xPath = null;
		if (device.equalsIgnoreCase("Android")) {
			xPath = "//android.widget.RadioButton[@text='" + option + "']";
		} else {
			xPath = "(//XCUIElementTypeOther[@name='" + option + "'])[1]";
		}
		gMob.swipeToElement(truckScreenDropdown, "up", driver);
		gMob.clickElement(truckScreenDropdown, "Click On Added Activity Drop up");
		gMob.WaitingAndReturningElementVisibilityUsingXpath(xPath, driver);
		gMob.clickElement((MobileElement) driver.findElement(By.xpath(xPath)), "Done Option Selected");
		clickOnOkButton();
	}
	
	public void clickOnOkButton() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println(gMob.WaitingAndReturningElementVisibility(okBtn));
		gMob.clickElement(okBtn, "Click On OK Button");

	}
	
	public void clickOnFirstTruckImage() {
		truckImages.get(0).click();
	}
	
	public void clickOnSecondTruckImage() {
		truckImages.get(1).click();
	}
	public void clickOnAddImageIconFromTruckScreen() {
		gMob.waitForVisibility(addImageIcon, driver);
		gMob.clickElement(addImageIcon, "Click On Image Icon Option");
	}
	
	public void clickOnAddedMediaIconFromTruckScreen() {
		gMob.waitForVisibility(addedMediaIcon, driver);
		gMob.clickElement(addedMediaIcon, "Click On Added Media Icon");
	}
	
	
	public void clickOnaddedMediaSecondTruckIconFromTruckScreen() {
		gMob.waitForVisibility(addedMediaSecondTruckIcon, driver);
		gMob.clickElement(addedMediaSecondTruckIcon, "Click On Added Media Icon Second Truck Drawing");
	}
	
	public void clickOnaddedSecondMediaSecondTruckIconFromTruckScreen() {
		gMob.waitForVisibility(addedSecondMediaTruckIcon, driver);
		gMob.clickElement(addedSecondMediaTruckIcon, "Click On Added second Media Icon Second Truck Drawing");
	}
	
	
	
	public boolean isPhotoCameraIconVisible() throws Exception {
		gMob.swipeToElement(photoCamera, "up", driver);
		return gMob.isElementDisplay(photoCamera, "PhotoCamera Icon Visible Successfully");
	}

	public boolean isVideoCameraIconVisible() throws Exception {
		gMob.swipeToElement(videoCamera, "up", driver);
		return gMob.isElementDisplay(videoCamera, "Video Camera Icon Visible Successfully");
	}
	public boolean isGalleryIconVisible() throws Exception {
		gMob.swipeToElement(addImageIcon, "up", driver);
		return gMob.isElementDisplay(addImageIcon, "Picture Icon Visible Successfully");
	}

	public boolean isSUBMITButtonVisible(String device) {
		gMob.waitForVisibility(submitBtn, driver);
		return gMob.isElementDisplay(submitBtn, "Cancel Button Is Visible");
      }
	
	public boolean isCANCELButtonVisible(String device) {
		gMob.waitForVisibility(cancelBtn, driver);
		return gMob.isElementDisplay(cancelBtn, "Cancel Button Is Visible");
      }
	
public void clickOnCANCELButton(String device) {
		gMob.waitForVisibility(cancelBtn, driver);
		 gMob.clickElement(cancelBtn, "Click on CANCEL Button");
   }

	public void clickOnSUBMITButton(String device) {
		gMob.waitForVisibility(submitBtn, driver);
		 gMob.clickElement(submitBtn, "Click on SUBMIT Button");
	}
	public boolean isNoteIconVisible() throws Exception {
		gMob.swipeToElement(noteIcon, "up", driver);
		return gMob.isElementDisplay(noteIcon, "Note Icon Visible Successfully");
	}
	
	public void clickOnCommentButton(String device) {
		gMob.waitForVisibility(noteIcon, driver);
		 gMob.clickElement(noteIcon, "Click on Comment Button");
	}
	
	public boolean isPhotoVehicleBackImageVisible() throws Exception {
		gMob.swipeToElement(photoVehicleBackImage, "up", driver);
		return gMob.isElementDisplay(photoVehicleBackImage, "Image Successfully Added For Vehicle Back ");
	}
	

}