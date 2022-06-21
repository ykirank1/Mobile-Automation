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
import com.cnhi.pageObjects.MileageTachoPage;
import com.cnhi.pageObjects.TaskPage;
import com.cnhi.pageObjects.VehicleDetailPage;

public class TC08_BreakdownRepairGeneralAttachments extends BaseTest {
	GenericPage genericPage;
	AppDeviceFactory getDevice;
	DeviceConfiguration deviceConfiguration;
	LoginPage loginPage;
	HomePage homePage;
	JobCardPage jobCardPage;
	Assertion aMob;
	String device;
	TaskPage taskPage;
	
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
		TaskPage taskPage;
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
			taskPage = new TaskPage(driver, genericPage);
			aMob = new Assertion();
			// driver.launchApp();

		}

		@Test(description = "T90-02-04-08-01 CV - Breakdown - Creation - Jobcard details")
		public void BreakdownRepairGeneralAttachments() throws Exception {
			Thread.sleep(8000);
			loginPage.loginToApplication("W90041D", "Saize9046");
			homePage.clickOnJobCardOption();
			//String CustomerName = "Customer VALID2022/04/22 08:36:39";
		    jobCardPage.clickOnCreateButton();
			jobCardPage.clickOnBreakdownOrRemoteAppointmentCheckBox();
			String CustomerName = "Customer VALID" + genericPage.getCurrentDate("yyyy/MM/dd HH:mm:ss");
		    jobCardPage.enterCustomerNameOnCustomerNameTextBox(CustomerName, device);
			jobCardPage.enterEmailOnCustomerEmailTextBox("customer.valid@cnhi.com");
			jobCardPage.enterPhoneNoOnCustomerPhoneTextBox("0634353637");
			jobCardPage.enterContactNoOnContactPhoneTextBox("0745464748");
			// jobCardPage.enterFiscalOnFiscalInformationTextBox("987654321");
			Thread.sleep(5000);
			jobCardPage.enterBrandOnBrandTextBox("IVECO");
			jobCardPage.enterModelOnModelNameTextBox("50C15V",device);
			Thread.sleep(5000);
			jobCardPage.enterNumberOnPlateNumberTextBox("ZE-983IW",device);
			// Thread.sleep(20000);
			jobCardPage.enterMileageOnMileageTextBox("1200", "Android");
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
			aMob.AssertTrue(jobCardPage.isToExecuteStatusVisible(), "To Execute Ststus is Visible");
			jobCardPage.clickOnSaveButton();
			String appointmentData = jobCardPage.getCreatedAppointmentData(CustomerName,"Android");

			aMob.AssertTrue(appointmentData.contains(CustomerName),
					"Customer Name Visible In the List Of New Created Appointment");
			aMob.AssertTrue(appointmentData.contains("50C15V"),
					"Model Name Visible In the First Of New Created Appointment");
			aMob.AssertTrue(appointmentData.contains("50C15V"),
					"Model Name Visible In the First Of New Created Appointment");
			aMob.AssertTrue(appointmentData.contains("ZE-983IW"),
					"Plate Number Visible In the First Of New Created Appointment");
			
			jobCardPage.SelectCreatedAppointment(CustomerName,"Android");

			aMob.AssertTrue(jobCardPage.isUnassignedActivitiesPopupVisible(),
					"Message Unassigned Activities For Breakdown is Visible");
			jobCardPage.clickOnYesButton();
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
			Thread.sleep(5000);
			aMob.AssertTrue(mileageTachoPage.isMileageTachoCameraStarIconVisible() == 2,
			"Camera Mandatory Star Icon Is Visible");
			mileageTachoPage.clickOnMileageTachoCameraIcon();
			mileageTachoPage.clickPhotoCamera();
			Thread.sleep(10000);
			mileageTachoPage.captureCameraphoto();
			Thread.sleep(10000);
			mileageTachoPage.attachCameraphoto();
			Thread.sleep(10000);			
//			mileageTachoPage.clickOnMileageTachoCameraIcon();
//			mileageTachoPage.clickOnAddImageIcon();
//			mileageTachoPage.clickOnImage();
			aMob.AssertTrue(mileageTachoPage.isMileageTachoCameraStarIconVisible() == 1,
			"Camera Mandatory Star Icon Not Visible-- Green Dot Is Visible");
//			mileageTachoPage.clickOnMileageTachoCameraIcon();
//			mileageTachoPage.clickOnAddImageIcon();
//			mileageTachoPage.clickOnImage();
			mileageTachoPage.clickOnCheckinIcon();
			mileageTachoPage.enterCustomerNameTextBox("Customer VALID");
			mileageTachoPage.enterSignatureTextBox();
			mileageTachoPage.turnOnTermConditionRadioButton("Android");
			Thread.sleep(5000);	
			mileageTachoPage.clickOnSubmitBtn("Android");
			//mileageTachoPage.clickOnCloseReceptionButton(); 
			jobCardPage.SelectReceivedAppointment(CustomerName,"Android");
			mileageTachoPage.clickOnGeneralAttachmentsCameraIcon();
			int cameraCountBefore = mileageTachoPage.getTotalCameraIconCount();
			mileageTachoPage.clickPhotoCamera();
			Thread.sleep(10000);
			mileageTachoPage.captureCameraphoto();
			Thread.sleep(10000);
			mileageTachoPage.attachCameraphoto();
			Thread.sleep(5000);	
			aMob.AssertTrue(mileageTachoPage.isAddMediaDescriptionVisible(), "Add Media Description Visible Successfully");
			mileageTachoPage.enterMediaDescriptionOnTextBox("General Attachment Photo");
			mileageTachoPage.clickOnSaveBtnOnAddMediaDescription();
			Thread.sleep(5000);	
//			mileageTachoPage.clickOnAddImageIcon();
//			mileageTachoPage.clickOnImage();
			mileageTachoPage.clickOnGeneralAttachmentsCameraIcon();
			int cameraCountAfter = mileageTachoPage.getTotalCameraIconCount();
			aMob.AssertTrue(cameraCountBefore < cameraCountAfter, "Image Added Successfully");
			mileageTachoPage.clickOnVideoCameraBtn();
			mileageTachoPage.clickOnStartVideoRecordingBtn();
			Thread.sleep(10000);
			mileageTachoPage.clickOnStopVideoRecordingBtn();
			mileageTachoPage.attachVideoRecordingBtn();
			Thread.sleep(5000);
		
			mileageTachoPage.clickOnGeneralAttachmentsCameraIcon();
			jobCardPage.switchToWebView();
			aMob.AssertTrue(mileageTachoPage.getColorForEyeIcon().equals("rgba(29, 193, 152, 1)"), "The Green Color is Visible For Eye Icon with RGB Value: "+mileageTachoPage.getColorForEyeIcon());
			jobCardPage.switchToNativeView();
			mileageTachoPage.clickOnAddImageIconFromQuestions("Android");
			mileageTachoPage.isAddedImageVisible();
		    aMob.AssertEquals(taskPage.getMediaDescriptionFromAttachmentScreen("Android"), "General Attachment Photo",
			"The expected Media description Value Is Same As Actual i.e. " + taskPage.getMediaDescriptionFromAttachmentScreen("Android"));
			mileageTachoPage.clickOnCloseBtnFromAddedImageScreen();
			Thread.sleep(5000);
			//mileageTachoPage.tapOnScreen();
		
			mileageTachoPage.clickOnGeneralAttachmentsMicroPhoneIcon();
			mileageTachoPage.clickOnRecordedBtnIcon();
			Thread.sleep(10000);
			//mileageTachoPage.clickOnOkButton();
			mileageTachoPage.clickOnRecorderStopBtnIcon();
			aMob.AssertTrue(mileageTachoPage.isRecordedVoiceVisible(), "Recorded Voice Visible Successfully");
			mileageTachoPage.isRecordedVoiceVisible();
			taskPage.isvoiceRecordMediaDescriptionTxtBoxVisible();
			taskPage.clickOnPlayRecordedVoiceBtn();
			mileageTachoPage.clickOnRecordeCloseBtnIcon();
			Thread.sleep(5000);
//			jobCardPage.switchToWebView();
//			aMob.AssertTrue(mileageTachoPage.getColorForMicrophoneIcon().equals("rgba(29, 193, 152, 1)"),
//		    "The Green Color is Visible For Microphone Icon with RGB Value: " + mileageTachoPage.getColorForMicrophoneIcon());
//			jobCardPage.switchToNativeView();
			Thread.sleep(5000);	
			mileageTachoPage.clickOnGeneralAttachmentsCameraIcon();
			mileageTachoPage.clickOnAddImageIconFromQuestions("Android");
			taskPage.enterVoiceRecordMediaDescriptionTxt("Record Description");
			mileageTachoPage.clickOnRecordeCloseBtnIcon();
			Thread.sleep(5000);	
			mileageTachoPage.clickOnGeneralAttachmentsMicroPhoneIcon();
			taskPage.isPlayRecordedVoiceBtnVisible();
			taskPage.isDeleteRecordedVoiceBtnVisible();
			mileageTachoPage.clickOnRecordeCloseBtnIcon();
			Thread.sleep(5000);
		}


		@AfterMethod(alwaysRun = true)
		public void afterMethod() {
			System.out.println("Test");
			// driver.quit();
		}
	}

}
