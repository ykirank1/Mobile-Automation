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

public class TC04_VehicleReceptionMileageTachoAndEngineHours extends BaseTest {
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
		
		@Test(description = "TC_04_T90-02-04-08-06 CV - Breakdown - Vehicle reception - Mileage + Tacho and Engine hour ")
		public void Test4() throws Exception {
			loginPage.loginToApplication("W90041D", "Saize9046");
			homePage.clickOnJobCardOption();
			jobCardPage.clickOnCreateButton();
			jobCardPage.clickOnBreakdownOrRemoteAppointmentCheckBox();
			String CustomerName="12 - VALID Customer (64100)"+genericPage.getCurrentDate("yyyy/MM/dd HH:mm:ss");	
			jobCardPage.enterCustomerNameOnCustomerNameTextBox(CustomerName, device);
			//jobCardPage.enterCustomerNameOnCustomerNameTextBox("03 - Customer VALID", device);
			jobCardPage.enterEmailOnCustomerEmailTextBox("customer.valid@cnhi.com");
			jobCardPage.enterPhoneNoOnCustomerPhoneTextBox("0634353637");
			jobCardPage.enterContactNoOnContactPhoneTextBox("0745464748");
			// jobCardPage.enterFiscalOnFiscalInformationTextBox("987654321");
			jobCardPage.enterBrandOnBrandTextBox("IVECO");
			jobCardPage.enterModelOnModelNameTextBox("50C15V",device);
			jobCardPage.enterNumberOnPlateNumberTextBox("ZE-983IW",device);
		     // Thread.sleep(20000);
			jobCardPage.enterMileageOnMileageTextBox("40000", "Android");
			jobCardPage.enterSerialNumberOnSerialNumberTextBox("ZCFC150A705105307");
			Thread.sleep(3000);
			jobCardPage.enterComplainsOnCustomerComplainsTextBox("Alarm on");
			jobCardPage.enterAddressOnRepairAddressTextBox("Valid Office India");
			//jobCardPage.clickOnChecklistOption();
			jobCardPage.selectCheckListOption("Reception Checklist");
			//jobCardPage.clickOnOkButton();
			jobCardPage.clickOnNextStepButton();
			jobCardPage.enterActivityOnActivityTextBox("Remote Activity");
			jobCardPage.clickOnAddButton();
			aMob.AssertTrue(jobCardPage.isToExecuteStatusVisible(), "To Execute Status is Visible");
			jobCardPage.clickOnSaveButton();
			String appointmentData = jobCardPage.getCreatedAppointmentData(CustomerName, "Android");
			aMob.AssertTrue(appointmentData.contains("12 - VALID Customer (64100)"),
					"Customer Name Visible In the List Of New Created Appointment");
			aMob.AssertTrue(appointmentData.contains("50C15V"),
					"Model Name Visible In the First Of New Created Appointment");
			aMob.AssertTrue(appointmentData.contains("50C15V"),
					"Model Name Visible In the First Of New Created Appointment");
			aMob.AssertTrue(appointmentData.contains("ZE-983IW"),
					"Plate Number Visible In the First Of New Created Appointment");
			Thread.sleep(10000);
			jobCardPage.SelectCreatedAppointment(CustomerName,device);
			Thread.sleep(10000);
			aMob.AssertTrue(jobCardPage.isUnassignedActivitiesPopupVisible(),
			"Message Unassigned Activities For Breakdown is Visible");
			jobCardPage.clickOnYesButton();
			Thread.sleep(10000);
			aMob.AssertTrue(jobCardPage.isAppointmentInfoLabelVisible(), "Appointment Info Label is Visible");
			

			aMob.AssertTrue(CustomerName.contains(jobCardPage.getCustomerInfoFromAppointmentInfo(device)),
					"Customer Name from Appointment Screen i.e. " + jobCardPage.getCustomerInfoFromAppointmentInfo(device)
							+ " is same as Expected");
			
			
//			aMob.AssertEquals(jobCardPage.getCustomerInfoFromAppointmentInfo(device).trim(), CustomerName,
//					"Customer Name from Appointment Screen i.e. " + jobCardPage.getCustomerInfoFromAppointmentInfo(device)
//							+ " is same as Expected");

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

			aMob.AssertTrue(mileageTachoPage.isMileageTachoCameraStarIconVisible() == 2,
					"Camera Mandatory Star Icon Is Visible");
			
			mileageTachoPage.clickOnMileageTachoCameraIcon();
			mileageTachoPage.clickPhotoCamera();
			Thread.sleep(10000);
			mileageTachoPage.captureCameraphoto();
			Thread.sleep(10000);
			mileageTachoPage.attachCameraphoto();
			Thread.sleep(5000);
////		mileageTachoPage.clickOnAddImageIcon();
////		mileageTachoPage.clickOnImage();
			Thread.sleep(10000);
////		aMob.AssertTrue(mileageTachoPage.isMileageTachoCameraStarIconVisible() == 1,
////		"Camera Mandatory Star Icon Not Visible-- Green Dot Is Visible");
		    mileageTachoPage.clickOnMileageTachoCameraIcon();			
////		mileageTachoPage.clickOnAddImageIcon();
////		mileageTachoPage.clickOnImage();
////		mileageTachoPage.isAllowPermission();			
			mileageTachoPage.clickPhotoCamera();
			Thread.sleep(10000);
			mileageTachoPage.captureCameraphoto();
			Thread.sleep(5000);
			mileageTachoPage.attachCameraphoto();
			Thread.sleep(5000);
			mileageTachoPage.clickOnMileageTachoCameraIcon();
			Thread.sleep(5000);
			mileageTachoPage.clickOnImageAddedEyeIcon("Android");
			int totalImage = mileageTachoPage.getTotalImageCount();
			aMob.AssertTrue(totalImage == 2, "Two Images Are Visible");
			mileageTachoPage.clickOnAddedImage();
			mileageTachoPage.clickOnDeleteImageBtn();
			Thread.sleep(5000);
			aMob.AssertTrue(mileageTachoPage.isMentionedDeleteAttachmentReasonVisible("Poor quality", device),
					"Validating Poor Quality Option Is Visible On Delete Image Attachment Reason Screen ");
			aMob.AssertTrue(mileageTachoPage.isMentionedDeleteAttachmentReasonVisible("Incorrect subject matter", device),
					"Validating Incorrect subject matter Option Is Visible On Delete Image Attachment Reason Screen ");
			aMob.AssertTrue(mileageTachoPage.isMentionedDeleteAttachmentReasonVisible("No longer relevant", device),
					"Validating No longer relevant Option Is Visible On Delete Image Attachment Reason Screen ");
			aMob.AssertTrue(mileageTachoPage.isMentionedDeleteAttachmentReasonVisible("Wrong machine photographed", device),
					"Validating Wrong machine photographed Option Is Visible On Delete Image Attachment Reason Screen ");
			aMob.AssertTrue(mileageTachoPage.isSubmitBtnVisible("Android"), "Submit Button Visible Successfully");
			aMob.AssertTrue(mileageTachoPage.isCancelBtnVisible("Android"), "Cancel Button Visible Successfully");
			mileageTachoPage.clickOnDeleteAttachmentReason("Incorrect subject matter", device);
			mileageTachoPage.clickOnSubmitBtn("iOS");
			Thread.sleep(5000);
		
			aMob.AssertTrue(mileageTachoPage.getTotalImageCount() < totalImage, "Image Deleted Successfully");
			mileageTachoPage.clickOnCloseBtnFromAddedImageScreen();
			mileageTachoPage.clickOnEngineHoursCameraIcon();
			int beforeImageAddAllIconsCount = mileageTachoPage.getTotalCameraIconCount();
			mileageTachoPage.clickPhotoCamera();
			Thread.sleep(10000);
			mileageTachoPage.captureCameraphoto();
			Thread.sleep(5000);
			mileageTachoPage.attachCameraphoto();
			Thread.sleep(5000);	
////		mileageTachoPage.clickOnAddImageIcon();
////		mileageTachoPage.clickOnImage();
   		   // mileageTachoPage.clickOnEngineHoursCameraIcon();
			//int AfterImageAddAllIconsCount = mileageTachoPage.getTotalCameraIconCount();
			//aMob.AssertTrue(beforeImageAddAllIconsCount < AfterImageAddAllIconsCount, "Image Added Successfully");
			//mileageTachoPage.clickOnEngineHoursCameraIcon();
			//mileageTachoPage.enterEngineHoursOnTextBox("40500");
			mileageTachoPage.clickOnCheckinIcon();
			mileageTachoPage.enterCustomerNameTextBox("Customer VALID");
			mileageTachoPage.enterSignatureTextBox();
			mileageTachoPage.turnOnTermConditionRadioButton("Android");
			//mileageTachoPage.clickOnSubmitBtn();
			Thread.sleep(5000);
			mileageTachoPage.clickOnSubmitBtnOnClientSignature();
//			Thread.sleep(5000);
//			mileageTachoPage.clickOnCloseReceptionButton();
//			Thread.sleep(30000);
			jobCardPage.SelectReceivedAppointment(CustomerName,"Android");
			mileageTachoPage.clickOnMileageTachoCameraIcon();
			Thread.sleep(5000);
			mileageTachoPage.clickOnImageAddedEyeIcon("Android");
		    /*int totalFinalImageFromMileageTacho = mileageTachoPage.getTotalImageCount();
		    aMob.AssertTrue(totalFinalImageFromMileageTacho == totalImage(),
		    "Only One Image Is Visible On Mileage And Tacho Image Added Screen");*/
			mileageTachoPage.clickOnCloseBtnFromAddedImageScreen();
			mileageTachoPage.clickOnEngineHoursCameraIcon();
			mileageTachoPage.clickOnImageAddedEyeIcon("Android");
			int totalFinalImageFromEngineHour = mileageTachoPage.getTotalImageCount();
			aMob.AssertTrue(totalFinalImageFromEngineHour == 1,
					"Only One Image Is Visible On Engine Hour Image Added Screen");
			mileageTachoPage.clickOnCloseBtnFromAddedImageScreen();

		}


		@AfterMethod(alwaysRun = true)
		public void afterMethod() {
			System.out.println("Test");
			// driver.quit();
		}
	}

}
