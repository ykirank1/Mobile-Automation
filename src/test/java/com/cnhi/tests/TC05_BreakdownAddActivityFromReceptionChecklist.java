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

public class TC05_BreakdownAddActivityFromReceptionChecklist extends BaseTest {
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
		public void BreakdownAddActivityFromReceptionChecklist() throws Exception {
			loginPage.loginToApplication("W90041D", "Saize9046");
			homePage.clickOnJobCardOption();
			//String CustomerName="03 - Customer VALID2022/04/18 14:07:53";
			Thread.sleep(3000);
			Set<String> view = driver.getContextHandles();
			System.out.println(view);
			jobCardPage.clickOnCreateButton();
			jobCardPage.clickOnBreakdownOrRemoteAppointmentCheckBox();
			String CustomerName = "03 - Customer VALID" + genericPage.getCurrentDate("yyyy/MM/dd HH:mm:ss");
			jobCardPage.enterCustomerNameOnCustomerNameTextBox(CustomerName, "Android");
			jobCardPage.enterEmailOnCustomerEmailTextBox("customer.valid@cnhi.com");
			jobCardPage.enterPhoneNoOnCustomerPhoneTextBox("0634353637");
			jobCardPage.enterContactNoOnContactPhoneTextBox("0745464748");
			jobCardPage.enterBrandOnBrandTextBox("IVECO");
			jobCardPage.enterModelOnModelNameTextBox("50C15V","Android");
			jobCardPage.enterNumberOnPlateNumberTextBox("ZE-983IW","Android");
			jobCardPage.enterMileageOnMileageTextBox("40000", "Android");
			jobCardPage.enterSerialNumberOnSerialNumberTextBox("ZCFC150A705105307");
			Thread.sleep(3000);
			jobCardPage.enterComplainsOnCustomerComplainsTextBox("Alarm on");
			jobCardPage.enterAddressOnRepairAddressTextBox("Valid Office India");
			jobCardPage.selectCheckListOption("Test Reception Checklist");
			jobCardPage.clickOnNextStepButton();
			jobCardPage.enterActivityOnActivityTextBox("Remote Activity");
			jobCardPage.clickOnAddButton();
			aMob.AssertTrue(jobCardPage.isToExecuteStatusVisible(), "To Execute Status is Visible");
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
			
			
			mileageTachoPage.clickOnMileageTachoCameraIcon();
			mileageTachoPage.clickPhotoCamera();
			Thread.sleep(10000);
			mileageTachoPage.captureCameraphoto();
			Thread.sleep(10000);
			mileageTachoPage.attachCameraphoto();
			Thread.sleep(5000);

			jobCardPage.selectCheckListOption("Test Reception Checklist");
			mileageTachoPage.clickOnQuestion13DotsBtn();
			mileageTachoPage.clickOnCommentIcon();
			mileageTachoPage.enterCommentTextBox("Checklist activity");
			mileageTachoPage.clickOnSubmitBtn("Android");
			mileageTachoPage.clickOnQuestion13DotsBtn();
			int beforeCount = mileageTachoPage.getTotalCameraIconCount();
			Log.info("jgjh" + beforeCount);		
			mileageTachoPage.clickPhotoCamera();
			Thread.sleep(10000);
			mileageTachoPage.captureCameraphoto();
			Thread.sleep(10000);
			mileageTachoPage.attachCameraphoto();
			Thread.sleep(5000);
//			mileageTachoPage.clickOnAddImageIconFromQuestions();
//			mileageTachoPage.clickOnImage();
			mileageTachoPage.clickOnQuestion13DotsBtn();
			int afterCount = mileageTachoPage.getTotalCameraIconCount();
			Log.info("jgjh" + afterCount);
			//aMob.AssertTrue(beforeCount < afterCount, "Image Added Successfully");
			mileageTachoPage.clickOnPlusFromQuestions("Android");
			//aMob.AssertTrue(mileageTachoPage.isThisQuestionHasBeenAddedTextVisible(), "This question has been added to the list of activities Text Visible");		
			mileageTachoPage.tapOnScreen();
			mileageTachoPage.clickOnQuestion13DotsBtn();
			jobCardPage.switchToWebView();
			aMob.AssertTrue(mileageTachoPage.getColorForCommentIcon().equals("rgba(29, 193, 152, 1)"), "The Green Color is Visible For Comment Icon with RGB Value: "+mileageTachoPage.getColorForCommentIcon());
			aMob.AssertTrue(mileageTachoPage.getColorForEyeIcon().equals("rgba(29, 193, 152, 1)"), "The Green Color is Visible For Eye Icon with RGB Value: "+mileageTachoPage.getColorForEyeIcon());
			aMob.AssertTrue(mileageTachoPage.isDisabledPlusIconVisible(), "The Plus Icon Get Disabled Visible Successfully");		
			jobCardPage.switchToNativeView();
			mileageTachoPage.tapOnScreen();
			jobCardPage.clickOnMenuButton();
			jobCardPage.clickOnTaskMenuOption();
			aMob.AssertTrue(taskPage.isCreatedActivityVisible("Remote Activity", "Android"),
					"The created Activity is visible");
			aMob.AssertTrue(taskPage.isGroupTestReceptionChkListQuestion1Label(),
					"Group Test Reception Checklist - Qiestion 01 is visible");
	

			// Need to add 4 more steps -- the delete activity Part
			jobCardPage.clickOnDeleteActivity();

			
			jobCardPage.clickOnMenuButton();
			//jobCardPage.clickOnChecklistMenuOption();		
			jobCardPage.clickOnchecklistMenuOption();
			mileageTachoPage.clickOnQuestion13DotsBtn();
			jobCardPage.switchToWebView();
			aMob.AssertTrue(mileageTachoPage.getColorForCommentIcon().equals("rgba(29, 193, 152, 1)"),
					"The Green Color is Visible For Comment Icon with RGB Value: "
							+ mileageTachoPage.getColorForCommentIcon());
			aMob.AssertTrue(mileageTachoPage.getColorForEyeIcon().equals("rgba(29, 193, 152, 1)"),
					"The Green Color is Visible For Eye Icon with RGB Value: " + mileageTachoPage.getColorForEyeIcon());
//			aMob.AssertTrue(!mileageTachoPage.isDisabledPlusIconVisible(),
//					"The Plus Icon Get Disabled Visible Successfully");
			
//			aMob.AssertTrue(mileageTachoPage.isEnabledPlusIconVisible(),
//					"The Plus Icon Get Enabled Visible Successfully");
			
			jobCardPage.switchToNativeView();

//			mileageTachoPage.clickOnAddImageIconFromQuestions("Android");
//			Thread.sleep(5000);
//			mileageTachoPage.clickOnCloseBtnFromAddedImageScreen();
//			mileageTachoPage.clickOnQuestion13DotsBtn();
			
			mileageTachoPage.clickOnPlusFromQuestions("Android");
			//mileageTachoPage.tapOnScreen();
			//Thread.sleep(30000);
			jobCardPage.clickOnMenuButton();
			jobCardPage.clickOnTaskMenuOption();
			taskPage.clickOnGroupTestReceptionChkListQuestion1DotBtn();
			//mileageTachoPage.clickOnPlusFromQuestions("Android");
			jobCardPage.switchToWebView();
			aMob.AssertTrue(mileageTachoPage.getColorForCommentIcon().equals("rgba(29, 193, 152, 1)"),
					"The Green Color is Visible For Comment Icon with RGB Value: "
							+ mileageTachoPage.getColorForCommentIcon());
			aMob.AssertTrue(mileageTachoPage.getColorForEyeIcon().equals("rgba(29, 193, 152, 1)"),
					"The Green Color is Visible For Eye Icon with RGB Value: " + mileageTachoPage.getColorForEyeIcon());

			jobCardPage.switchToNativeView();

			mileageTachoPage.clickOnAddImageIconFromQuestions("Android");
			mileageTachoPage.clickOnCloseBtnFromAddedImageScreen();
			
//			mileageTachoPage.clickOnImageAddedEyeIcon("Android");
//			int totalFinalImageFromEngineHour = mileageTachoPage.getTotalImageCount();
//			aMob.AssertTrue(totalFinalImageFromEngineHour < 1,
//					"Image Is Visible On Group Test Reception Checklist - Qiestion 01 is visible Screen");
//			mileageTachoPage.clickOnCloseBtnFromAddedImageScreen();
			taskPage.clickOnGroupTestReceptionChkListQuestion1DotBtn();
			mileageTachoPage.clickOnCommentIcon();
			aMob.AssertTrue(taskPage.isComplaintTextBoxDisabled(), "The Complaint Text Box Visible Disabled");
			aMob.AssertTrue(taskPage.isCauseTextBoxDisabled(), "The Cause Text Box Visible Disabled");
			aMob.AssertTrue(taskPage.isCorrectionTextBoxDisabled(), "The Correction Text Box Visible Disabled");
			aMob.AssertTrue(taskPage.isInternalNoteTextBoxDisabled(), "The Internal Note Text Box Visible Disabled");
			aMob.AssertEquals(taskPage.getInternalNoteTextBoxValue("Android"), "Checklist activity",
					"The expected Internal Note Value Is Same As Actual i.e. " + taskPage.getInternalNoteTextBoxValue("Android"));
			taskPage.clickOnCloseButtonFromAddCommentScreen();
			taskPage.clickOnGeneralTestArrowBtn();
			aMob.AssertTrue(taskPage.isSupplierCodeTextBoxDisabled(), "The Supplier Code Text Box Visible Disabled");
			aMob.AssertTrue(taskPage.isDefectCodeTextBoxDisabled(), "The Defect Code Text Box Visible Disabled");
			aMob.AssertTrue(taskPage.isFailureCodeTextBoxDisabled(), "The Failure Code Text Box Visible Disabled");
			aMob.AssertTrue(taskPage.isFailureSeverityRateTextBoxDisabled(),
					"The Failure Severity Rate Text Box Visible Disabled");
			aMob.AssertTrue(taskPage.isPaymentTypeTextBoxDisabled(), "The Payment Type Text Box Visible Disabled");
			aMob.AssertEquals(taskPage.getSupplierCodeTextBoxValue("Android").trim(), "000 - IVECO",
					"The expected Supplier Code Value Is Same As Actual i.e. " + taskPage.getSupplierCodeTextBoxValue("Android"));
			taskPage.clickOnAddNewOperationBtnFromGroupTest(device);		
			jobCardPage.enterOperationNameTextBox("77 45 14 104 - R-I PRESSURE REGULATING SOLENOID VALVE", device);
			jobCardPage.clickOnSaveButton();
//			aMob.AssertTrue(jobCardPage.isNewOperationCreated("R-I PRESSURE REGULATING SOLENOID VALVE"),
//					"New Operation Added Successfully");
			
			taskPage.clickOnAddAnotherItemBtnFromGroupTest();
			jobCardPage.selectTypeFromTypeDropDown("Material", "Android");
			jobCardPage.selectCodeFromCodeDropDown("C004 - KOSTENBETEILIGUNG BEI TECHNISCHER KULANZ LI", device);
			jobCardPage.enterDescriptionOnDescriptionTextBox("Material for repair", device);
			jobCardPage.enterPriceOnPriceTextBox("56", device);
			jobCardPage.clickOnAddItemSaveBtn();
			//aMob.AssertTrue(jobCardPage.isNewTypeCreated("Material", "Android"), "New Type Added Successfully");
			mileageTachoPage.clickOnCheckinIcon();
			mileageTachoPage.enterCustomerNameTextBox("Customer VALID");
			mileageTachoPage.enterSignatureTextBox();
			mileageTachoPage.turnOnTermConditionRadioButton("Android");
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
