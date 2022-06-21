package com.cnhi.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.auto.framework.base.Assertion;
import com.auto.framework.base.BaseTest;
import com.auto.framework.base.Log;
import com.auto.framework.utils.AppDeviceFactory;
import com.auto.framework.utils.DeviceConfiguration;
import com.cnhi.pageObjects.GenericPage;
import com.cnhi.pageObjects.HomePage;
import com.cnhi.pageObjects.JobCardPage;
import com.cnhi.pageObjects.LoginPage;
import com.cnhi.pageObjects.VehicleDetailPage;
import com.cnhi.pageObjects.MileageTachoPage;

public class TC07_BreakdownVehicleReceptionClientsignature extends BaseTest {
	GenericPage genericPage;
	AppDeviceFactory getDevice;
	DeviceConfiguration deviceConfiguration;
	LoginPage loginPage;
	HomePage homePage;
	JobCardPage jobCardPage;
	Assertion aMob;
	String device;

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() throws IOException {
		getDevice = new AppDeviceFactory(driver);
		deviceConfiguration = new DeviceConfiguration();

		System.out.println(deviceConfiguration.getInstance());

		device = deviceConfiguration.getDevicePlatform().toString();

		driver = getDevice.createDriver(deviceConfiguration);
		genericPage = new GenericPage();
		loginPage = new LoginPage(driver, genericPage);
		homePage = new HomePage(driver, genericPage);
		jobCardPage = new JobCardPage(driver, genericPage);
		//mileageTachoPage = new MileageTachoPage(driver, genericPage);
		aMob = new Assertion();
		// driver.launchApp();

	}

	public class Demotest extends BaseTest {
		GenericPage genericPage;
		AppDeviceFactory getDevice;
		DeviceConfiguration deviceConfiguration;
		LoginPage loginPage;
		HomePage homePage;
		JobCardPage jobCardPage;
		VehicleDetailPage vehicleDetailPage;
		MileageTachoPage mileageTachoPage;
		Assertion aMob;
		String device;

		@BeforeMethod(alwaysRun = true)
		public void beforeMethod() throws IOException {
			getDevice = new AppDeviceFactory(driver);
			deviceConfiguration = new DeviceConfiguration();

			System.out.println(deviceConfiguration.getInstance());

			device = deviceConfiguration.getDevicePlatform().toString();

			driver = getDevice.createDriver(deviceConfiguration);
			genericPage = new GenericPage();
			loginPage = new LoginPage(driver, genericPage);
			homePage = new HomePage(driver, genericPage);
			jobCardPage = new JobCardPage(driver, genericPage);
			vehicleDetailPage = new VehicleDetailPage(driver, genericPage);
			mileageTachoPage = new MileageTachoPage(driver, genericPage);
			aMob = new Assertion();
			// driver.launchApp();

		}
		
		@Test(description = "Login to application Trying to fail this scenario for reporting purpose ")
		public void BreakdownVehicleReceptionClientsignature() throws Exception {
			loginPage.loginToApplication("W90041D", "Saize9046");
			homePage.clickOnJobCardOption();
			//String CustomerName ="12 - VALID Customer (64100)2022/04/08 17:56:34";
			jobCardPage.clickOnCreateButton();
			jobCardPage.clickOnBreakdownOrRemoteAppointmentCheckBox();
			String CustomerName = "12 - VALID Customer (64100)" + genericPage.getCurrentDate("yyyy/MM/dd HH:mm:ss");
			jobCardPage.enterCustomerNameOnCustomerNameTextBox(CustomerName, "Android");
			jobCardPage.enterEmailOnCustomerEmailTextBox("customer.valid@cnhi.com");
			jobCardPage.enterPhoneNoOnCustomerPhoneTextBox("0634353637");
			jobCardPage.enterContactNoOnContactPhoneTextBox("0745464748");
			// jobCardPage.enterFiscalOnFiscalInformationTextBox("987654321");
			jobCardPage.enterBrandOnBrandTextBox("IVECO");
			Thread.sleep(5000);
			jobCardPage.enterModelOnModelNameTextBox("50C15V",device);
			jobCardPage.enterNumberOnPlateNumberTextBox("ZE-983IW",device);
			// Thread.sleep(20000);
			jobCardPage.enterMileageOnMileageTextBox("40000", "Android");
			jobCardPage.enterSerialNumberOnSerialNumberTextBox("ZCFC150A705105307");
			Thread.sleep(3000);
			jobCardPage.enterComplainsOnCustomerComplainsTextBox("Alarm on");
			jobCardPage.enterAddressOnRepairAddressTextBox("Valid Office India");
			// jobCardPage.clickOnChecklistOption();
			jobCardPage.selectCheckListOption("Reception Checklist");
			//jobCardPage.clickOnOkButton();
			jobCardPage.navigatingToCustomerNameTextBox();
			jobCardPage.enterCustomerNameOnCustomerNameTextBox(CustomerName, "Android");
			jobCardPage.enterEmailOnCustomerEmailTextBox("customer.valid@cnhi.com");
			jobCardPage.enterPhoneNoOnCustomerPhoneTextBox("0634353637");
			jobCardPage.enterContactNoOnContactPhoneTextBox("0745464748");
			jobCardPage.clickOnNextStepButton();
			jobCardPage.enterActivityOnActivityTextBox("Remote Activity");
			jobCardPage.clickOnAddButton();
			aMob.AssertTrue(jobCardPage.isToExecuteStatusVisible(), "To Execute Status is Visible");
			jobCardPage.clickOnSaveButton();
			String appointmentData = jobCardPage.getCreatedAppointmentData(CustomerName, "Android");
			Thread.sleep(5000);
			aMob.AssertTrue(appointmentData.contains("12 - VALID Customer (64100)"),
					"Customer Name Visible In the List Of New Created Appointment");
			aMob.AssertTrue(appointmentData.contains("50C15V"),
					"Model Name Visible In the First Of New Created Appointment");
			aMob.AssertTrue(appointmentData.contains("50C15V"),
					"Model Name Visible In the First Of New Created Appointment");
			aMob.AssertTrue(appointmentData.contains("ZE-983IW"),
					"Plate Number Visible In the First Of New Created Appointment");
			 Thread.sleep(20000);
			jobCardPage.SelectCreatedAppointment(CustomerName,"Android");
			//jobCardPage.SelectCreatedAppointmentTest(CustomerName,"Android");
			aMob.AssertTrue(jobCardPage.isUnassignedActivitiesPopupVisible(),
					"Message Unassigned Activities For Breakdown is Visible");
			jobCardPage.clickOnYesButton();
			Thread.sleep(5000);
			aMob.AssertTrue(jobCardPage.isAppointmentInfoLabelVisible(), "Appointment Info Label is Visible");
			aMob.AssertTrue(CustomerName.contains(jobCardPage.getCustomerInfoFromAppointmentInfo(device)),
					"Customer Name from Appointment Screen i.e. " + jobCardPage.getCustomerInfoFromAppointmentInfo(device)
							+ " is same as Expected");

			aMob.AssertEquals(jobCardPage.getModelInfoFromAppointmentInfo(device).trim(), "50C15V",
					"Model Name from Appointment Screen i.e. " + jobCardPage.getModelInfoFromAppointmentInfo(device)
							+ " is same as Expected");

			aMob.AssertEquals(jobCardPage.getReceptionDateFromAppointmentInfo(device).trim(),
					genericPage.getCurrentDate("MMM dd, yyyy"),
					"Reception Date From Appointment Screen i.e. " + jobCardPage.getReceptionDateFromAppointmentInfo(device)
							+ " is same as Expected i.e. " + genericPage.getCurrentDate("MMM dd, yyyy"));

			aMob.AssertEquals(jobCardPage.getDeliveryDateFromAppointmentInfo(device).trim(),
					genericPage.getCurrentDate("MMM dd, yyyy"),
					"Delivery Date From Appointment Screen i.e. " + jobCardPage.getDeliveryDateFromAppointmentInfo(device)
							+ " is same as Expected i.e. " + genericPage.getCurrentDate("MMM dd, yyyy"));
			mileageTachoPage.clickOnCheckinIcon();
//			aMob.AssertTrue(mileageTachoPage.isMileagePhotoHasNotBeenFilledTextVisible(),
//					"'Mileage photo has not been filled in.' Text is visible if trying to click checklist icon without adding image.");

			Thread.sleep(10000);
			aMob.AssertTrue(mileageTachoPage.isMileageTachoCameraStarIconVisible() == 2,
					"Camera Mandatory Star Icon Is Visible");
			
			mileageTachoPage.clickOnMileageTachoCameraIcon();
			mileageTachoPage.clickPhotoCamera();
			Thread.sleep(10000);
			mileageTachoPage.captureCameraphoto();
			Thread.sleep(10000);
			mileageTachoPage.attachCameraphoto();
			Thread.sleep(5000);			
//			mileageTachoPage.clickOnMileageTachoCameraIcon();
//			mileageTachoPage.clickOnAddImageIcon();
//			mileageTachoPage.clickOnImage();
			aMob.AssertTrue(mileageTachoPage.isMileageTachoCameraStarIconVisible() == 1,
					"Camera Mandatory Star Icon Not Visible-- Green Dot Is Visible");
			
			mileageTachoPage.clickOnCheckinIcon();
			aMob.AssertTrue(mileageTachoPage.isCustomerNameTextBoxVisible(), "Customer Name Text Box Is Visible");
			aMob.AssertTrue(mileageTachoPage.isSignatureTextBoxVisible(), "Signature Text Box Is Visible");
			aMob.AssertTrue(mileageTachoPage.isCustomerNotPresentRadioButtonVisible(),
					"Customer Not Present Radio Button Is Visible");
			aMob.AssertTrue(mileageTachoPage.isTermConditionRadioButtonVisible(), "Term Condition Radio Button Is Visible");
			aMob.AssertTrue(mileageTachoPage.isPrivacyNoticeRadioButtonVisible(), "By Selecting Radio Button Is Visible");
			aMob.AssertTrue(mileageTachoPage.isSubmitBtnVisible("Android"), "Submit Button Visible Successfully");
			aMob.AssertTrue(mileageTachoPage.isCancelBtnVisible("Android"), "Cancel Button Visible Successfully");
			mileageTachoPage.enterCustomerNameTextBox("Customer VALID");
			mileageTachoPage.turnOffTermConditionRadioButton("Android");
			aMob.AssertEquals(mileageTachoPage.getSubmitBtnEnableStatus("Android"), "false",
					"The Submit Button Is Disabled After Uncheck Term And Condition");
			mileageTachoPage.enterSignatureTextBox();
			aMob.AssertEquals(mileageTachoPage.getSubmitBtnEnableStatus("Android"), "false",
					"The Submit Button Is Disabled After Uncheck Term And Condition And Enter Signature");
			mileageTachoPage.turnOnTermConditionRadioButton("Android");
			Thread.sleep(5000);
			aMob.AssertEquals(mileageTachoPage.getSubmitBtnEnableStatus("Android"), "true",
					"The Submit Button Is Enabled After Check Term And Condition And Entering Signature");
			mileageTachoPage.clickOnCancelBtn("Android");
			
			mileageTachoPage.clickOnCheckinIcon();
			aMob.AssertTrue(mileageTachoPage.getTermConditionRadioButtonStatus("Android").equalsIgnoreCase("1"),
					"Term Condition Radio Button Is Checked");
			mileageTachoPage.turnOnCustomerNotPresentRadioButton("Android");
			aMob.AssertEquals(mileageTachoPage.getSubmitBtnEnableStatus("Android"), "true",
					"The Submit Button Is Enabled After Check Customer Not Present Radio Button");
			mileageTachoPage.turnOffTermConditionRadioButton("Android");
			aMob.AssertEquals(mileageTachoPage.getSubmitBtnEnableStatus("Android"), "false",
					"The Submit Button Is Disabled After Uncheck Term And Condition radio Button");

			mileageTachoPage.enterCustomerNameTextBox("Customer VALID");
			mileageTachoPage.enterSignatureTextBox();
			mileageTachoPage.turnOnTermConditionRadioButton("Android");
			aMob.AssertEquals(mileageTachoPage.getSubmitBtnEnableStatus("Android"), "true",
					"The Submit Button Is Enabled After Entering Customer Name, Signature and Turn On Term Condition Radio Button");
			mileageTachoPage.turnOnPrivacyNoticeRadioButton("Android");
			mileageTachoPage.clickOnCancelBtn("Android");
			mileageTachoPage.clickOnCheckinIcon();
			aMob.AssertTrue(mileageTachoPage.getTermConditionRadioButtonStatus("Android").equalsIgnoreCase("1"),
					"Term Condition Radio Button Is Checked");
			aMob.AssertTrue(mileageTachoPage.getPrivacyNoticeRadioButtonStatus("Android").equalsIgnoreCase("1"),
					"Privacy Notice Radio Button Is Checked");
			mileageTachoPage.enterCustomerNameTextBox("Customer VALID");
			mileageTachoPage.enterSignatureTextBox();
			mileageTachoPage.clickOnSubmitBtn("Android");
			//mileageTachoPage.clickOnCloseReceptionButton();
			Thread.sleep(5000);
		}


		@AfterMethod(alwaysRun = true)
		public void afterMethod() {
			System.out.println("Test");
			// driver.quit();
		}
	}

}
