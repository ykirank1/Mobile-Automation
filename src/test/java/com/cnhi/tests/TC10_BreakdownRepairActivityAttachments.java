package com.cnhi.tests;

import java.io.IOException;
import java.util.Set;

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
import com.cnhi.pageObjects.VehicleDetailPage;
import com.cnhi.pageObjects.TaskPage;

public class TC10_BreakdownRepairActivityAttachments extends BaseTest {
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
		TaskPage taskPage;
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
			taskPage = new TaskPage(driver, genericPage);
			aMob = new Assertion();
			// driver.launchApp();

		}
		
		@Test(description = "Login to application Trying to fail this scenario for reprting purpose ")
		public void BreakdownRepairActivityAttachments() throws Exception {
			loginPage.loginToApplication("W90041D", "Saize9046");
			homePage.clickOnJobCardOption();
			Thread.sleep(3000);
			Set<String> view = driver.getContextHandles();
			System.out.println(view);
			//String CustomerName = "03 - Customer VALID2022/04/20 19:32:58";
			jobCardPage.clickOnCreateButton();
			jobCardPage.clickOnBreakdownOrRemoteAppointmentCheckBox();
			String CustomerName = "03 - Customer VALID" + genericPage.getCurrentDate("yyyy/MM/dd HH:mm:ss");
			jobCardPage.enterCustomerNameOnCustomerNameTextBox(CustomerName, device);
			jobCardPage.enterEmailOnCustomerEmailTextBox("customer.valid@cnhi.com");
			jobCardPage.enterPhoneNoOnCustomerPhoneTextBox("0634353637");
			jobCardPage.enterContactNoOnContactPhoneTextBox("0745464748");
			jobCardPage.enterBrandOnBrandTextBox("IVECO");
			jobCardPage.enterModelOnModelNameTextBox("50C15V", device);
			jobCardPage.enterNumberOnPlateNumberTextBox("ZE-983IW", device);
			jobCardPage.enterMileageOnMileageTextBox("40000", device);
			jobCardPage.enterSerialNumberOnSerialNumberTextBox("ZCFC150A705105307");
			Thread.sleep(3000);
			jobCardPage.enterComplainsOnCustomerComplainsTextBox("Alarm on");
			jobCardPage.enterAddressOnRepairAddressTextBox("Valid Office India");
			jobCardPage.selectCheckListOption("Test Reception Checklist");
			jobCardPage.clickOnNextStepButton();
			jobCardPage.enterActivityOnActivityTextBox("Activity with attachments");
			jobCardPage.clickOnAddButton();
			aMob.AssertTrue(jobCardPage.isToExecuteStatusVisible(), "To Execute Status is Visible");
			
			jobCardPage.clickOnArrowButton();
			jobCardPage.enterDefectCodeOnActivityTextBox("552333 EGINE BRAKE PEDAL BOOT");
			jobCardPage.selectFailureOptionFromFailureDropDown("003 - BREAK", device);
			jobCardPage.selectFailureSeverityRateFromFailureSeverityRateDropDown("1 - Medium", "Android");
			jobCardPage.selectPaymentTypeFromPaymentTypeDropDown("TEST Payment Type", "Android");
			
			jobCardPage.clickOnAddNewOperationBtn("Android");
			jobCardPage.enterOperationNameTextBox("76 42 78 100 - R-I PARKING BRAKE WARNING LIGHT SWITCH", device);
			jobCardPage.clickOnSaveButton();
//			aMob.AssertTrue(jobCardPage.isNewOperationCreated("R-I SAFETY BELTS DRIVER SEAT"),
//					"New Operation Added Successfully");
			jobCardPage.clickOnSaveButton();				
			String appointmentData = jobCardPage.getCreatedAppointmentData(CustomerName, "Android");

			aMob.AssertTrue(appointmentData.contains(CustomerName),
					"Customer Name Visible In the List Of New Created Appointment");
			aMob.AssertTrue(appointmentData.contains("50C15V"),
					"Model Name Visible In the First Of New Created Appointment");
			aMob.AssertTrue(appointmentData.contains("50C15V"),
					"Model Name Visible In the First Of New Created Appointment");
			aMob.AssertTrue(appointmentData.contains("ZE-983IW"),
					"Plate Number Visible In the First Of New Created Appointment");
			jobCardPage.SelectCreatedAppointment(CustomerName, device);

			aMob.AssertTrue(jobCardPage.isUnassignedActivitiesPopupVisible(),
					"Message Unassigned Activities For Breakdown is Visible");
			jobCardPage.clickOnYesButton();
			aMob.AssertTrue(jobCardPage.isAppointmentInfoLabelVisible(), "Appointment Info Label is Visible");
			aMob.AssertTrue(CustomerName.contains(jobCardPage.getCustomerInfoFromAppointmentInfo(device)),
					"Customer Name from Appointment Screen i.e. " + jobCardPage.getCustomerInfoFromAppointmentInfo(device)
							+ " is same as Expected");

			aMob.AssertEquals(jobCardPage.getModelInfoFromAppointmentInfo(device), "50C15V",
					"Model Name from Appointment Screen i.e. " + jobCardPage.getModelInfoFromAppointmentInfo(device)
							+ " is same as Expected");

			aMob.AssertEquals(jobCardPage.getReceptionDateFromAppointmentInfo(device),
					genericPage.getCurrentDate("MMM dd, yyyy"),
					"Reception Date From Appointment Screen i.e. " + jobCardPage.getReceptionDateFromAppointmentInfo(device)
							+ " is same as Expected i.e. " + genericPage.getCurrentDate("MMM dd, yyyy"));

			aMob.AssertEquals(jobCardPage.getDeliveryDateFromAppointmentInfo(device),
					genericPage.getCurrentDate("MMM dd, yyyy"),
					"Delivery Date From Appointment Screen i.e. " + jobCardPage.getDeliveryDateFromAppointmentInfo(device)
							+ " is same as Expected i.e. " + genericPage.getCurrentDate("MMM dd, yyyy"));

			jobCardPage.selectCheckListOption("Test Reception Checklist");
			
			Log.info("gjhgjh" + mileageTachoPage.isMileageTachoCameraStarIconVisible());
			aMob.AssertTrue(mileageTachoPage.isMileageTachoCameraStarIconVisible() == 2,
					"Camera Mandatory Star Icon Is Visible");
			mileageTachoPage.clickOnMileageTachoCameraIcon();
			mileageTachoPage.clickPhotoCamera();
			Thread.sleep(10000);
			mileageTachoPage.captureCameraphoto();
			Thread.sleep(10000);
			mileageTachoPage.attachCameraphoto();
			Thread.sleep(10000);
//			mileageTachoPage.clickOnAddImageIcon();
//			mileageTachoPage.clickOnImage();
			Log.info("gjhgjh" + mileageTachoPage.isMileageTachoCameraStarIconVisible());
			Thread.sleep(5000);
			aMob.AssertTrue(mileageTachoPage.isMileageTachoCameraStarIconVisible() == 1,
					"Camera Mandatory Star Icon Not Visible-- Green Dot Is Visible");		
			
            mileageTachoPage.clickOnCheckinIcon();
			mileageTachoPage.enterCustomerNameTextBox("Customer VALID");
			mileageTachoPage.enterSignatureTextBox();
			mileageTachoPage.turnOnTermConditionRadioButton("Android");
			Thread.sleep(10000);
			mileageTachoPage.clickOnSubmitBtn("Android");
			Thread.sleep(5000);
			//mileageTachoPage.clickOnCloseReceptionButton();
			jobCardPage.SelectReceivedAppointment(CustomerName, "Android");
			Thread.sleep(5000);
			jobCardPage.clickOnMenuButton();
			jobCardPage.clickOnTaskMenuOption();
			taskPage.clickOnPlayButtonToStartTaskExecution();
			taskPage.clickOnActivityWithAttachmentsQuestion3DotBtn();
			int cameraCountBefore = mileageTachoPage.getTotalCameraIconCount();
			Log.info("jgjh" + cameraCountBefore);	
			mileageTachoPage.clickPhotoCamera();
			Thread.sleep(10000);
			mileageTachoPage.captureCameraphoto();
			Thread.sleep(10000);
			mileageTachoPage.attachCameraphoto();
			Thread.sleep(5000);	
			aMob.AssertTrue(mileageTachoPage.isAddMediaDescriptionVisible(), "Add Media Description Visible Successfully");
			mileageTachoPage.enterMediaDescriptionOnTextBox("Activity Photo");
			mileageTachoPage.clickOnSaveBtnOnAddMediaDescription();
			Thread.sleep(5000);	
			taskPage.clickOnActivityWithAttachmentsQuestion3DotBtn();
			int afterCount = mileageTachoPage.getTotalCameraIconCount();
			Log.info("jgjh" + afterCount);
			mileageTachoPage.clickOnVideoCameraBtn();
			mileageTachoPage.clickOnStartVideoRecordingBtn();
			Thread.sleep(10000);
			mileageTachoPage.clickOnStopVideoRecordingBtn();
			mileageTachoPage.attachVideoRecordingBtn();
			Thread.sleep(5000);	
			taskPage.clickOnActivityWithAttachmentsQuestion3DotBtn();
			mileageTachoPage.clickOnRecorderIcon();
			mileageTachoPage.clickOnRecordedBtnIcon();
			Thread.sleep(5000);
			//mileageTachoPage.clickOnOkButton();
			mileageTachoPage.clickOnRecorderStopBtnIcon();
			aMob.AssertTrue(mileageTachoPage.isRecordedVoiceVisible(), "Recorded Voice Visible Successfully");
			mileageTachoPage.clickOnRecordeCloseBtnIcon();
			Thread.sleep(5000);
			taskPage.clickOnActivityWithAttachmentsQuestion3DotBtn();
			mileageTachoPage.clickOnCommentIcon();
			taskPage.enterComplaintText("Customer complaint");
			taskPage.enterCauseText("Problem cause");
			taskPage.enterCorrectionText("Correction to be done");
			taskPage.enterInternalNoteText("Internal Note");
			mileageTachoPage.clickOnSubmitBtn("Android");
			//taskPage.clickOnCloseButtonFromAddCommentScreen();
			taskPage.clickOnStopButtonToStopTaskExecution();
			Thread.sleep(5000);
		
			taskPage.clickOnInProgresStatusToDoneBtn();
			mileageTachoPage.clickOnCheckinIcon();
			mileageTachoPage.enterCustomerNameTextBox("Customer VALID");
			mileageTachoPage.enterSignatureTextBox();
			mileageTachoPage.turnOnTermConditionRadioButton("Android");
			mileageTachoPage.clickOnSubmitBtn("Android");
			//mileageTachoPage.clickOnCloseReceptionButton();
			Thread.sleep(5000);
			
			jobCardPage.SelectJobCardValidationPendingAppointment(CustomerName, "Android");
			taskPage.clickOnActivityWithAttachmentsQuestion3DotBtn();
			jobCardPage.switchToWebView();
			aMob.AssertTrue(mileageTachoPage.getColorForCommentIcon().equals("rgba(29, 193, 152, 1)"),
					"The Green Color is Visible For Comment Icon with RGB Value: "
							+ mileageTachoPage.getColorForCommentIcon());
			aMob.AssertTrue(mileageTachoPage.getColorForEyeIcon().equals("rgba(29, 193, 152, 1)"),
					"The Green Color is Visible For Eye Icon with RGB Value: " + mileageTachoPage.getColorForEyeIcon());
			aMob.AssertTrue(mileageTachoPage.getColorForMicrophoneIcon().equals("rgba(29, 193, 152, 1)"),
					"The Green Color is Visible For Eye Icon with RGB Value: " + mileageTachoPage.getColorForMicrophoneIcon());
			jobCardPage.switchToNativeView();
			mileageTachoPage.clickOnAddImageIconFromQuestions("Android");
			mileageTachoPage.isAddedImageVisible();
		    aMob.AssertEquals(taskPage.getMediaDescriptionFromAttachmentScreen("Android"), "Activity Photo",
					"The expected Media description Value Is Same As Actual i.e. " + taskPage.getMediaDescriptionFromAttachmentScreen("Android"));
			mileageTachoPage.clickOnCloseBtnFromAddedImageScreen();
			Thread.sleep(5000);
			taskPage.clickOnActivityWithAttachmentsQuestion3DotBtn();
			mileageTachoPage.clickOnRecorderIcon();
			mileageTachoPage.isRecordedVoiceVisible();
			taskPage.isvoiceRecordMediaDescriptionTxtBoxVisible();
			taskPage.clickOnPlayRecordedVoiceBtn();
			mileageTachoPage.clickOnCloseBtnFromAddedImageScreen();
			Thread.sleep(5000);
			taskPage.clickOnActivityWithAttachmentsQuestion3DotBtn();
			mileageTachoPage.clickOnCommentIcon();
			aMob.AssertEquals(taskPage.getComplaintText("Android").trim(), "Customer complaint",
					"Customer complaint from Add a comment Screen i.e. " + taskPage.getComplaintText(device)
							+ " is same as Expected");
			
			aMob.AssertEquals(taskPage.getCauseText().trim(), "Problem cause",
					"Cause text from Add a comment Screen i.e. " + taskPage.getCauseText()
							+ " is same as Expected");
			
			aMob.AssertEquals(taskPage.getCorrectionText().trim(), "Correction to be done",
					"Correction text from Add a comment Screen i.e. " + taskPage.getCorrectionText()
							+ " is same as Expected");
			
			aMob.AssertEquals(taskPage.getInternalNoteText().trim(), "Internal Note",
					"Internal Note text from Add a comment Screen i.e. " + taskPage.getInternalNoteText()
							+ " is same as Expected");
			mileageTachoPage.clickOnCloseBtnFromAddedImageScreen();
			Thread.sleep(5000);
			//Need to add More Steps
			

		}
		@AfterMethod(alwaysRun = true)
		public void afterMethod() {
			System.out.println("Test");
			// driver.quit();
		}
	}

}
