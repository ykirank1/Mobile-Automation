package com.cnhi.tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.auto.framework.base.Assertion;
import com.auto.framework.base.BaseTest;
import com.auto.framework.base.Log;
import com.auto.framework.utils.AppDeviceFactory;
import com.auto.framework.utils.DeviceConfiguration;
import com.cnhi.pageObjects.DamagesPage;
import com.cnhi.pageObjects.GenericPage;
import com.cnhi.pageObjects.HomePage;
import com.cnhi.pageObjects.JobCardPage;
import com.cnhi.pageObjects.LoginPage;
import com.cnhi.pageObjects.MileageTachoPage;
import com.cnhi.pageObjects.TaskPage;
import com.cnhi.pageObjects.VehicleDetailPage;

public class Demotest2 extends BaseTest {
	GenericPage genericPage;
	AppDeviceFactory getDevice;
	DeviceConfiguration deviceConfiguration;
	LoginPage loginPage;
	HomePage homePage;
	JobCardPage jobCardPage;
	VehicleDetailPage vehicleDetailPage;
	MileageTachoPage mileageTachoPage;
	TaskPage taskPage;
	DamagesPage damagesPage;
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
		damagesPage = new DamagesPage(driver, genericPage);
		aMob = new Assertion();
		// driver.launchApp();

	}

	@Test(description = "Login to application Trying to fail this scenario for reprting purpose ")
	public void Test11() throws Exception {
		loginPage.loginToApplication("W90041D", "Saize9045");
		homePage.clickOnJobCardOption();
		jobCardPage.clickOnCreateButton();
		jobCardPage.clickOnBreakdownOrRemoteAppointmentCheckBox();
		String CustomerName = "HANS NAEF AG" + genericPage.getCurrentDate("yyyy/MM/dd HH:mm:ss");
	    CustomerName="HANS NAEF AG2022/05/11 21:56:56";
		jobCardPage.enterCustomerNameOnCustomerNameTextBox(CustomerName, device);
		jobCardPage.enterEmailOnCustomerEmailTextBox("customer.valid@cnhi.com");
		jobCardPage.enterPhoneNoOnCustomerPhoneTextBox("0634353637");
		jobCardPage.enterContactNoOnContactPhoneTextBox("0745464748");
		jobCardPage.enterBrandOnBrandTextBox("IVECO");
		jobCardPage.enterModelOnModelNameTextBox("AD340T45", device);
		jobCardPage.enterNumberOnPlateNumberTextBox("TG30155", device);
		jobCardPage.enterMileageOnMileageTextBox("450", device);
		jobCardPage.enterSerialNumberOnSerialNumberTextBox("WJMJ3JTS40C186565");
		Thread.sleep(3000);
		jobCardPage.enterComplainsOnCustomerComplainsTextBox("Alarm on");
		jobCardPage.enterAddressOnRepairAddressTextBox("Amriswilerstrasse 18,x9315 Egnach Switzerland");
		jobCardPage.selectCheckListOption("Reception Checklist");
		jobCardPage.clickOnNextStepButton();
		jobCardPage.enterActivityOnActivityTextBox("Off line Activity");
		jobCardPage.clickOnAddButton();
		aMob.AssertTrue(jobCardPage.isToExecuteStatusVisible(), "To Execute Status is Visible");
		jobCardPage.clickOnArrowButton();
		jobCardPage.enterDefectCodeOnActivityTextBox("528940 SECOND FRONT AXLE STABILIZER");
		jobCardPage.selectFailureOptionFromFailureDropDown("004 - DEFORMED", device);
		jobCardPage.selectFailureSeverityRateFromFailureSeverityRateDropDown("1 - Medium", device);
		jobCardPage.selectPaymentTypeFromPaymentTypeDropDown("Cliente", device);
		//jobCardPage.selectPaymentSubTypeFromPaymentTypeDropDown("a carico cliente", device);
		jobCardPage.clickOnAddNewOperationBtn(device);
		jobCardPage.enterOperationNameTextBox("52 89 40 200 - OVERHAUL SECOND FRONT AXLE STABILIZER WITH UPPER ARTICULATED JOINT", device);
		jobCardPage.clickOnSaveButton();
		aMob.AssertTrue(jobCardPage.isNewOperationCreated("OVERHAUL SECOND FRONT AXLE STABILIZER WITH UPPER ARTICULATED JOINT"),
				"New Operation Added Successfully");
		
//		//Adding Second Activity
//		jobCardPage.enterActivityOnActivityTextBox("Luci - Lato anteriore destro");
//		jobCardPage.clickOnAddButton();
//		aMob.AssertTrue(jobCardPage.countNumberOfActivity()==2, "To Execute Status is Visible For Second Activity");
		jobCardPage.clickOnSaveButton();
		String appointmentData = jobCardPage.getCreatedAppointmentData(CustomerName, device);

		aMob.AssertTrue(appointmentData.contains(CustomerName),
				"Customer Name Visible In the Kist Of New Created Appointment");
		aMob.AssertTrue(appointmentData.contains("AD340T45"),
				"Model Name Visible In the First Of New Created Appointment");
		aMob.AssertTrue(appointmentData.contains("AD340T45"),
				"Model Name Visible In the First Of New Created Appointment");
		aMob.AssertTrue(appointmentData.contains("TG30155"),
				"Plate Number Visible In the First Of New Created Appointment");
		
		// Need To Add Disabled wifi to go on offline mode
		
		jobCardPage.SelectCreatedAppointment(CustomerName, device);

		aMob.AssertTrue(jobCardPage.isUnassignedActivitiesPopupVisible(),
				"Message Unassigned Activities For Breakdown is Visible");
		jobCardPage.clickOnYesButton();
		aMob.AssertTrue(jobCardPage.isAppointmentInfoLabelVisible(), "Appointment Info Label is Visible");
		aMob.AssertTrue(CustomerName.contains(jobCardPage.getCustomerInfoFromAppointmentInfo(device)),
				"Customer Name from Appointment Screen i.e. " + jobCardPage.getCustomerInfoFromAppointmentInfo(device)
						+ " is same as Expected");

		aMob.AssertEquals(jobCardPage.getModelInfoFromAppointmentInfo(device), "AD340T45",
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
		
		
		
		
		
		
		

		aMob.AssertTrue(mileageTachoPage.isMileageTachoCameraStarIconVisible() == 2,
				"Camera Mandatory Star Icon Is Visible");
		mileageTachoPage.clickOnMileageTachoCameraIcon();
		mileageTachoPage.clickOnAddImageIcon();
		mileageTachoPage.clickOnImage();
		Thread.sleep(20000);
		aMob.AssertTrue(mileageTachoPage.isMileageTachoCameraStarIconVisible() == 1,
				"Camera Mandatory Star Icon Not Visible-- Green Dot Is Visible");


		mileageTachoPage.clickOnEngineHoursCameraIcon();
		int beforeImageAddAllIconsCount = mileageTachoPage.getTotalCameraIconCount();
		Log.info("jgajas" + beforeImageAddAllIconsCount);

		mileageTachoPage.clickOnAddImageIcon();
		mileageTachoPage.clickOnImage();
		mileageTachoPage.clickOnEngineHoursCameraIcon();
		int AfterImageAddAllIconsCount = mileageTachoPage.getTotalCameraIconCount();
		Log.info("jgajas" + AfterImageAddAllIconsCount);
		aMob.AssertTrue(beforeImageAddAllIconsCount < AfterImageAddAllIconsCount, "Image Added Successfully");
		mileageTachoPage.tapOnScreen();
		mileageTachoPage.clickOnInternoAnterioreSinistroGreenRdioBtn();
		mileageTachoPage.clickOnEsternoAnterioreSinistroGreenRdioBtn();
		mileageTachoPage.clickOnSpazzoleTergicristalloAnterioriOkBtn();
		mileageTachoPage.clickOnParabrezzaAnterioreOkBtn();
		mileageTachoPage.clickOnPerditeEsterneVisibiliOkBtn();
		mileageTachoPage.clickOnLatoAnterioreDestroToggleBtn();
		mileageTachoPage.clickOnAnterioreSinistroToggleBtn();
		mileageTachoPage.slideOlioMotoreSliderBtn("Android");
		mileageTachoPage.slideLiquidoDiRaffreddamentoSliderBtn("Android");
		mileageTachoPage.slideLiquidoLavavetriSliderBtn("Android");
		mileageTachoPage.slideBatteriaSliderBtn("Android");
		mileageTachoPage.slideOlioFreniSliderBtn("Android");
		mileageTachoPage.swipeToInternoAnterioreSinistro3DotBtnBtn();
		mileageTachoPage.clickOnInternoAnterioreSinistro3DotBtnBtn();
		mileageTachoPage.clickOnCommentIcon();
		mileageTachoPage.enterCommentTextBox("Technician Comment on Inspection checklist");
		mileageTachoPage.clickOnSubmitBtn("Android");
		mileageTachoPage.clickOnEsternoAnterioreSinistro3DotBtn();
		mileageTachoPage.clickOnRecorderIcon();
		mileageTachoPage.clickOnRecordedBtnIcon();
		mileageTachoPage.clickOnOkButton();
		mileageTachoPage.clickOnRecorderStopBtnIcon();
		aMob.AssertTrue(mileageTachoPage.isRecordedVoiceVisible(), "Recorded Voice Visible Successfully");
		mileageTachoPage.clickOnRecordeCloseBtnIcon();
		mileageTachoPage.clickOnEsternoAnterioreSinistro3DotBtn();
		mileageTachoPage.clickOnPlusFromQuestions("Android");
		aMob.AssertTrue(mileageTachoPage.isThisQuestionHasBeenAddedTextVisible(),
				"This question has been added to the list of activities Text Visible");
		jobCardPage.clickOnMenuButton();
		jobCardPage.clickOnDamagesMenuOption();	
		damagesPage.clickOnAddDamageVehicleFrontIcon();
		mileageTachoPage.clickOnAddImageIcon();
		mileageTachoPage.clickOnImage();
		Thread.sleep(6000);
		aMob.AssertTrue(damagesPage.isPhotoVehicleFrontImageVisible(),
				"Image Added Successfully For Vehicle Front Section");
		mileageTachoPage.clickOnCheckinIcon();
		mileageTachoPage.enterCustomerNameTextBox("HANS NAE AG");
		mileageTachoPage.enterSignatureTextBox();
		mileageTachoPage.turnOnTermConditionRadioButton("Android");
		mileageTachoPage.clickOnSubmitBtn("Android");
		mileageTachoPage.clickOnCloseReceptionButton();

		jobCardPage.SelectReceivedAppointment(CustomerName, device);
 		mileageTachoPage.clickOn3DotOfActivity("Off line Activity",device);

		// Need to add One In Progress status Validation Point
 		
		mileageTachoPage.clickOnAddANewRunIcon();
		Thread.sleep(10000);
		// Need tO add Clocking Point Validation Point
		//mileageTachoPage.clickOnAddANewActivity3DotsAfterClickOnRunIconBtn();
		genericPage.swipeUpDown("up", driver);
		Thread.sleep(5000);
		mileageTachoPage.clickOn3DotOfActivity("Off line Activity",device);
		mileageTachoPage.clickOnAddANewRunIcon();
		// Need tO add Clocking Point Validation Point
		mileageTachoPage.selectStatusOptionFromActivityDropDownAccToActivityName("Off line Activity","Done", device);
		// Need tO add Stop Clocking Point Validation Point
		// Need tO add Stop Done Status Validation Point
		mileageTachoPage.clickOn3DotOfActivity("Pneumatici - Esterno anteriore sinistro",device);
		mileageTachoPage.clickOnAddANewRunIcon();
		Thread.sleep(10000);
		mileageTachoPage.clickOn3DotOfActivity("Pneumatici - Esterno anteriore sinistro",device);
		mileageTachoPage.clickOnCommentIcon();
		taskPage.enterTextOnComplaintTextBox("Customer complaint");
		taskPage.enterTextOnCauseTextBox("Problem cause");
		taskPage.enterTextOnCorrectionTextBox("Correction to be done");
		taskPage.enterTextOnInternalNoteTextBox("Inetrnal Note");
		mileageTachoPage.clickOnSubmitBtn("Android");
		Thread.sleep(5000);
		mileageTachoPage.selectStatusOptionFromActivityDropDownAccToActivityName("Pneumatici - Esterno anteriore sinistro","Done", device);
		//Need Validation Point
		//Validation Clocking Automatically Stop
		
		//Adding Second Activity
		jobCardPage.enterActivityOnActivityTextBox("New activity added in off line");
		jobCardPage.clickOnAddButton();
		aMob.AssertTrue(jobCardPage.isToExecuteStatusVisible(), "To Execute Status is Visible");
		mileageTachoPage.clickOn3DotOfActivity("New activity added in off line",device);
		mileageTachoPage.clickOnAddANewRunIcon();
		Thread.sleep(10000);
		mileageTachoPage.clickOn3DotOfActivity("New activity added in off line",device);
		int beforeCount = mileageTachoPage.getTotalCameraIconCount();
		Log.info("jgjh" + beforeCount);
		mileageTachoPage.clickOnAppointmentImageIcon();
		mileageTachoPage.clickOnImage();
		Thread.sleep(6000);
		mileageTachoPage.clickOn3DotOfActivity("New activity added in off line",device);
		int afterCount = mileageTachoPage.getTotalCameraIconCount();
		Log.info("jgjh" + afterCount);
		aMob.AssertTrue(beforeCount < afterCount, "Image Added Successfully");
		mileageTachoPage.tapOnScreen();
		Thread.sleep(3000);
		mileageTachoPage.selectStatusOptionFromActivityDropDownAccToActivityName("New activity added in off line","Done", device);
		Thread.sleep(3000);
		mileageTachoPage.clickOnCheckinIcon();
		mileageTachoPage.enterCustomerNameTextBox("HANS NAE AG");
		mileageTachoPage.enterSignatureTextBox();
		mileageTachoPage.turnOnTermConditionRadioButton("Android");
		mileageTachoPage.clickOnSubmitBtn("Android");
		
		jobCardPage.SelectJobcardValidationPendingAppointment(CustomerName, device);
		
		// Need to put WIFI oN 
		//Step 22 nedd to add 
		mileageTachoPage.clickOnMileageTachoCameraIcon();
		aMob.AssertTrue(mileageTachoPage.isAddedImageVisible(), "Added Image Is Visible For Mileage + Tacho");
		mileageTachoPage.clickOnCloseBtnFromAddedImageScreen();
		
		mileageTachoPage.clickOnEngineHoursCameraIcon();
		aMob.AssertTrue(mileageTachoPage.isAddedImageVisible(), "Added Image Is Visible For Engine hours");
		mileageTachoPage.clickOnCloseBtnFromAddedImageScreen();
		
		aMob.AssertTrue(taskPage.getTotalDoneStatus()==3, "Done Status Visible For All Three Activities");
		aMob.AssertTrue(taskPage.isPlannedTimeValueVisibleDifferent(), "Planned Time Value Is Different From 00:00 ");
		mileageTachoPage.clickOn3DotOfActivity("Pneumatici - Esterno anteriore sinistro",device);
		mileageTachoPage.clickOnCommentIcon();
		aMob.AssertEquals(taskPage.getComplaintTextBoxValue(), "Customer complaint",
				"Complaint Text Value is same as Actual i.e. " + taskPage.getComplaintTextBoxValue());
		aMob.AssertEquals(taskPage.getCauseTextBoxValue(), "Problem cause",
				"Cause Text Value is same as Actual i.e. " + taskPage.getCauseTextBoxValue());
		aMob.AssertEquals(taskPage.getCorrectionTextBoxValue(), "Correction to be done",
				"Complaint Text Value is same as Actual i.e. " + taskPage.getCorrectionTextBoxValue());
		aMob.AssertEquals(taskPage.getInternalNoteTextBoxValue(), "Inetrnal Note",
				"Inetrnal Note Text Value is same as Actual i.e. " + taskPage.getInternalNoteTextBoxValue());
		taskPage.clickOnCloseButtonFromAddCommentScreen();
		mileageTachoPage.selectStatusOptionFromActivityDropDownAccToActivityName("New activity added in off line","Done", device);
		mileageTachoPage.clickOnImageAddedEyeIcon("Android");
		aMob.AssertTrue(mileageTachoPage.isAddedImageVisible(), "Added Image Is Visible For Engine hours");
		mileageTachoPage.clickOnCloseBtnFromAddedImageScreen();
		mileageTachoPage.swipeToInternoAnterioreSinistro3DotBtnBtn();
		mileageTachoPage.swipeToInternoAnterioreSinistro3DotBtnBtn();
		taskPage.clickOnNoteIcon();
		aMob.AssertEquals(mileageTachoPage.getCommentBoxText(), "Technician Comment on Inspection checklist", "The Expected Comment Is Same As Actual"+mileageTachoPage.getCommentBoxText());
		mileageTachoPage.clickOnCancelBtn("Android");
		//Need To Validation Point Of Check List
		// Need to add one validation point
	}


	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		 driver.quit();
	}

}
