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
import com.cnhi.pageObjects.DamagesPage;
import com.cnhi.pageObjects.GenericPage;
import com.cnhi.pageObjects.HomePage;
import com.cnhi.pageObjects.JobCardPage;
import com.cnhi.pageObjects.LoginPage;
import com.cnhi.pageObjects.MileageTachoPage;
import com.cnhi.pageObjects.VehicleDetailPage;
import com.cnhi.pageObjects.TaskPage;

public class TC11_BreakdownJobcardValidationPendingAppointmentWorkflowInOnlineMode extends BaseTest {
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
			damagesPage = new DamagesPage(driver, genericPage);
			aMob = new Assertion();
			// driver.launchApp();

		}
		
		@Test(description = "Login to application Trying to fail this scenario for reprting purpose ")
		public void BreakdownJobcardValidationPendingAppointmentWorkflowInOnlineMode() throws Exception {
			loginPage.loginToApplication("W90041D", "Saize9046");
			homePage.clickOnJobCardOption();
			//String CustomerName="HANS NAEF AG2022/05/18 16:54:04";
			jobCardPage.clickOnCreateButton();
			jobCardPage.clickOnBreakdownOrRemoteAppointmentCheckBox();
			String CustomerName = "HANS NAEF AG" + genericPage.getCurrentDate("yyyy/MM/dd HH:mm:ss");
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
			jobCardPage.selectFailureOptionFromFailureDropDown("004 - DEFORMED", "Android");
			jobCardPage.selectFailureSeverityRateFromFailureSeverityRateDropDown("1 - Medium", "Android");
			jobCardPage.selectPaymentTypeFromPaymentTypeDropDown("Cliente", "Android");
			jobCardPage.selectPaymentSubTypeFromPaymentTypeDropDown("a carico cliente", "Android");
			jobCardPage.clickOnAddNewOperationBtn("Android");
			jobCardPage.enterOperationNameTextBox("52 89 40 200 - OVERHAUL SECOND FRONT AXLE STABILIZER WITH UPPER ARTICULATED JOINT", device);
			jobCardPage.clickOnSaveButton();
//			aMob.AssertTrue(jobCardPage.isNewOperationCreated("OVERHAUL SECOND FRONT AXLE STABILIZER WITH UPPER ARTICULATED JOINT"),
//					"New Operation Added Successfully");
			jobCardPage.clickOnSaveButton();
			Thread.sleep(5000);
			genericPage.turnOnWiFi("disable");
			Thread.sleep(5000);
			String appointmentData = jobCardPage.getCreatedAppointmentData(CustomerName, "Android");

			aMob.AssertTrue(appointmentData.contains(CustomerName),
					"Customer Name Visible In the List Of New Created Appointment");
			aMob.AssertTrue(appointmentData.contains("AD340T45"),
					"Model Name Visible In the First Of New Created Appointment");
			aMob.AssertTrue(appointmentData.contains("AD340T45"),
					"Model Name Visible In the First Of New Created Appointment");
			aMob.AssertTrue(appointmentData.contains("TG30155"),
					"Plate Number Visible In the First Of New Created Appointment");
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
			mileageTachoPage.clickPhotoCamera();
			Thread.sleep(10000);
			mileageTachoPage.captureCameraphoto();
			Thread.sleep(5000);
			mileageTachoPage.attachCameraphoto();
			Thread.sleep(10000);		
			jobCardPage.clickOnMenuButton();
			jobCardPage.clickOnchecklistMenuOption();
//			mileageTachoPage.clickOnAddImageIcon();
//			mileageTachoPage.clickOnImage();
			Thread.sleep(5000);
			aMob.AssertTrue(mileageTachoPage.isMileageTachoCameraStarIconVisible() == 1,
					"Camera Mandatory Star Icon Not Visible-- Green Dot Is Visible");
			mileageTachoPage.clickOnEngineHoursCameraIcon();
			int beforeImageAddAllIconsCount = mileageTachoPage.getTotalCameraIconCount();
			Log.info("jgajas" + beforeImageAddAllIconsCount);
//			mileageTachoPage.clickOnAddImageIcon();
//			mileageTachoPage.clickOnImage();
			mileageTachoPage.clickPhotoCamera();
			Thread.sleep(10000);
			mileageTachoPage.captureCameraphoto();
			Thread.sleep(5000);
			mileageTachoPage.attachCameraphoto();
			Thread.sleep(5000);		
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
			//mileageTachoPage.clickOnLatoAnterioreDestroToggleBtn();
			mileageTachoPage.clickOnAnterioreSinistroToggleBtn();
			mileageTachoPage.slideOlioMotoreSliderBtn("Android");
			mileageTachoPage.slideLiquidoDiRaffreddamentoSliderBtn("Android");
			mileageTachoPage.slideLiquidoLavavetriSliderBtn("Android");
			mileageTachoPage.slideBatteriaSliderBtn("Android");
			mileageTachoPage.slideOlioFreniSliderBtn("Android");
			jobCardPage.clickOnMenuButton();
			jobCardPage.clickOnTaskMenuOption();
			jobCardPage.clickOnMenuButton();
			jobCardPage.clickOnchecklistMenuOption();;
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
		
			
			mileageTachoPage.clickOnspazzoletegicristallo3DotBtn();
			mileageTachoPage.clickOnVideoCameraBtn();
			mileageTachoPage.clickOnStartVideoRecordingBtn();
			Thread.sleep(10000);
			mileageTachoPage.clickOnStopVideoRecordingBtn();
			mileageTachoPage.attachVideoRecordingBtn();
			Thread.sleep(5000);	
			//mileageTachoPage.swipeToInternoAnterioreSinistro3DotBtnBtn();
			mileageTachoPage.clickOnLatoAnterioreDestro3DotBtn();
			mileageTachoPage.clickOnLatoAnteriorAddOperationBtn();
			Thread.sleep(5000);
			jobCardPage.clickOnMenuButton();
			jobCardPage.clickOnDamagesMenuOption();	
			damagesPage.clickOnAddDamageVehicleBackIcon();
			mileageTachoPage.clickPhotoCamera();
			Thread.sleep(10000);
			mileageTachoPage.captureCameraphoto();
			Thread.sleep(5000);
			mileageTachoPage.attachCameraphoto();
			Thread.sleep(5000);		
		
			aMob.AssertTrue(damagesPage.isPhotoVehicleBackImageVisible(),
			"Image Added Successfully For Vehicle Back Section");
			
			mileageTachoPage.clickOnCheckinIcon();
			mileageTachoPage.enterCustomerNameTextBox("HANS NAE AG");
			mileageTachoPage.enterSignatureTextBox();
			mileageTachoPage.turnOnTermConditionRadioButton("Android");
			Thread.sleep(5000);
			mileageTachoPage.clickOnSubmitBtn("Android");
			Thread.sleep(6000);
			
			jobCardPage.SelectReceivedAppointment(CustomerName, "Android");
			mileageTachoPage.clickOnaddANewRunIconOfflineActivity();
			Thread.sleep(30000);
			mileageTachoPage.selectStatusOptionFromOfflineActivityDropDown("Done", "Android");
			
			mileageTachoPage.clickOnLatoAnteriorRunActivityBtn();
			mileageTachoPage.clickOnLucilatoAnterioreActivity3DotsBtn();
			mileageTachoPage.clickOnCommentIcon();
			taskPage.enterTextOnComplaintTextBox("Customer complaint");
			taskPage.enterTextOnCauseTextBox("Problem cause");
			taskPage.enterTextOnCorrectionTextBox("Correction to be done");
			taskPage.enterTextOnInternalNoteTextBox("Internal Note");
			mileageTachoPage.clickOnSubmitBtn("Android");
			mileageTachoPage.selectStatusOptionFromLuciLatoActivityDropDown("Done", "Android");
			//jobCardPage.SelectReceivedAppointment(CustomerName, "Android");
			jobCardPage.enterActivityOnActivityTextBox("New activity added in offline");
			Thread.sleep(5000);
			jobCardPage.clickOnAddButton();
			Thread.sleep(10000);	
			aMob.AssertTrue(jobCardPage.isToExecuteStatusVisible(), "To Execute Status is Visible");
			mileageTachoPage.clickOnNewOfflineActivityRunIcon();
			mileageTachoPage.clickOnNewOfflineActivity3DotsAfterClickRunBtn();
			int beforeCount = mileageTachoPage.getTotalCameraIconCount();
			Log.info("jgjh" + beforeCount);
			mileageTachoPage.clickPhotoCamera();
			Thread.sleep(10000);
			mileageTachoPage.captureCameraphoto();
			Thread.sleep(5000);
			mileageTachoPage.attachCameraphoto();
			Thread.sleep(5000);	
			mileageTachoPage.enterMediaDescriptionOnTextBox("New Activity photo description");
			mileageTachoPage.clickOnSaveBtnOnAddMediaDescription();
			Thread.sleep(5000);	
			mileageTachoPage.clickOnNewOfflineActivity3DotsAfterClickRunBtn();
			int afterCount = mileageTachoPage.getTotalCameraIconCount();
			Log.info("jgjh" + afterCount);
			aMob.AssertTrue(beforeCount < afterCount, "Image Added Successfully");
			mileageTachoPage.tapOnScreen();
			mileageTachoPage.selectStatusOptionFromNewOfflineActivityDropDown("Done", "Android");
			mileageTachoPage.clickOnCheckinActivity();
			mileageTachoPage.enterCustomerNameTextBox("HANS NAE AG");
			mileageTachoPage.enterSignatureTextBox();
			mileageTachoPage.turnOnTermConditionRadioButton("Android");
			Thread.sleep(5000);
			mileageTachoPage.clickOnSubmitBtn("Android");
			Thread.sleep(6000);
			
			genericPage.turnOnWiFi("enable");
			Thread.sleep(40000);
			
			jobCardPage.SelectJobCardValidationPendingAppointment(CustomerName, "Android");
			mileageTachoPage.clickOnMileageTachoCameraIcon();
			Thread.sleep(5000);
			//mileageTachoPage.clickOnImageAddedEyeIcon("Android");
			int totalImage = mileageTachoPage.getTotalImageCount();
			aMob.AssertTrue(totalImage == 1, "Image is Visible");
			mileageTachoPage.clickOnCloseBtnFromAddedImageScreen();
	
			mileageTachoPage.clickOnEngineHoursCameraIcon();
			//mileageTachoPage.clickOnImageAddedEyeIcon("Android");
			int totalFinalImageFromEngineHour = mileageTachoPage.getTotalImageCount();
			aMob.AssertTrue(totalFinalImageFromEngineHour == 1,
					"Only One Image Is Visible On Engine Hour Image Added Screen");
			mileageTachoPage.clickOnCloseBtnFromAddedImageScreen();
				
			mileageTachoPage.clickOnLucilatoAnterioreActivity3DotsBtn();
			mileageTachoPage.clickOnCommentIcon();
			aMob.AssertTrue(taskPage.isComplaintTextBoxDisabled(), "The Complaint Text Box Visible Disabled");
			aMob.AssertTrue(taskPage.isCauseTextBoxDisabled(), "The Cause Text Box Visible Disabled");
			aMob.AssertTrue(taskPage.isCorrectionTextBoxDisabled(), "The Correction Text Box Visible Disabled");
			aMob.AssertTrue(taskPage.isInternalNoteTextBoxDisabled(), "The Internal Note Text Box Visible Disabled");
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
			mileageTachoPage.clickOnNewOfflineActivity3DotsAfterClickRunBtn();
			mileageTachoPage.clickOnImageAddedEyeIcon("Android");
			Thread.sleep(5000);
			taskPage.getMediaDescriptionFromAttachmentScreen("Android");
			mileageTachoPage.clickOnCloseBtnFromAddedImageScreen();
			jobCardPage.clickOnMenuButton();
			jobCardPage.clickOnchecklistMenuOption();
			//Need to add validation point for Checklist Pneumatici
			mileageTachoPage.clickOnInternoAnterioreSinistro3DotBtnBtn();
			mileageTachoPage.clickOnCommentIcon();
			aMob.AssertEquals(taskPage.getCommentText().trim(), "Internal Note",
					"Comment text from Add a comment Screen i.e. " + taskPage.getCommentText()
							+ " is same as Expected");
			mileageTachoPage.clickOnCloseBtnFromAddedImageScreen();
			Thread.sleep(5000);
			mileageTachoPage.clickOnEsternoAnterioreSinistro3DotBtn();
			mileageTachoPage.clickOnRecorderIcon();
			mileageTachoPage.isRecordedVoiceVisible();
			taskPage.clickOnPlayRecordedVoiceBtn();
			Thread.sleep(5000);
			mileageTachoPage.clickOnRecordeCloseBtnIcon();
//			mileageTachoPage.clickOnspazzoletegicristallo3DotBtn();
//			mileageTachoPage.clickOnImageAddedEyeIcon("Android");
//			mileageTachoPage.clickOnCloseBtnFromAddedImageScreen();
			jobCardPage.clickOnMenuButton();
			jobCardPage.clickOnDamagesMenuOption();	
			Thread.sleep(5000);		
			aMob.AssertTrue(damagesPage.isPhotoVehicleBackImageVisible(),
			"Image Added Successfully For Vehicle Back Section");

		}
		@AfterMethod(alwaysRun = true)
		public void afterMethod() {
			System.out.println("Test");
			// driver.quit();
		}
	}

}

/*
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
import com.cnhi.pageObjects.DamagesPage;
import com.cnhi.pageObjects.GenericPage;
import com.cnhi.pageObjects.HomePage;
import com.cnhi.pageObjects.JobCardPage;
import com.cnhi.pageObjects.LoginPage;
import com.cnhi.pageObjects.MileageTachoPage;
import com.cnhi.pageObjects.VehicleDetailPage;
import com.cnhi.pageObjects.TaskPage;

public class BreakdownJobcardValidationPendingAppointmentWorkflowInOnlineMode extends BaseTest {
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
			damagesPage = new DamagesPage(driver, genericPage);
			aMob = new Assertion();
			// driver.launchApp();

		}
		
		@Test(description = "Login to application Trying to fail this scenario for reprting purpose ")
		public void BreakdownJobcardValidationPendingAppointmentWorkflowInOnlineMode() throws Exception {
			loginPage.loginToApplication("W90041D", "Saize9046");
			homePage.clickOnJobCardOption();
			//String CustomerName="HANS NAEF AG2022/05/17 14:23:11";
			jobCardPage.clickOnCreateButton();
			jobCardPage.clickOnBreakdownOrRemoteAppointmentCheckBox();
			String CustomerName = "HANS NAEF AG" + genericPage.getCurrentDate("yyyy/MM/dd HH:mm:ss");
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
			jobCardPage.selectFailureOptionFromFailureDropDown("004 - DEFORMED", "Android");
			jobCardPage.selectFailureSeverityRateFromFailureSeverityRateDropDown("1 - Medium", "Android");
			jobCardPage.selectPaymentTypeFromPaymentTypeDropDown("Cliente", "Android");
			jobCardPage.selectPaymentSubTypeFromPaymentTypeDropDown("a carico cliente", "Android");
			jobCardPage.clickOnAddNewOperationBtn("Android");
			jobCardPage.enterOperationNameTextBox("52 89 40 200 - OVERHAUL SECOND FRONT AXLE STABILIZER WITH UPPER ARTICULATED JOINT", device);
			jobCardPage.clickOnSaveButton();
//			aMob.AssertTrue(jobCardPage.isNewOperationCreated("OVERHAUL SECOND FRONT AXLE STABILIZER WITH UPPER ARTICULATED JOINT"),
//					"New Operation Added Successfully");
			jobCardPage.clickOnSaveButton();
			Thread.sleep(5000);
			
			//genericPage.turnOnWiFi("disable");
			Thread.sleep(5000);
			
			String appointmentData = jobCardPage.getCreatedAppointmentData(CustomerName, "Android");

			aMob.AssertTrue(appointmentData.contains(CustomerName),
					"Customer Name Visible In the List Of New Created Appointment");
			aMob.AssertTrue(appointmentData.contains("AD340T45"),
					"Model Name Visible In the First Of New Created Appointment");
			aMob.AssertTrue(appointmentData.contains("AD340T45"),
					"Model Name Visible In the First Of New Created Appointment");
			aMob.AssertTrue(appointmentData.contains("TG30155"),
					"Plate Number Visible In the First Of New Created Appointment");
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
				
			//Thread.sleep(50000);
			aMob.AssertTrue(mileageTachoPage.isMileageTachoCameraStarIconVisible() == 2,
					"Camera Mandatory Star Icon Is Visible");
			mileageTachoPage.clickOnMileageTachoCameraIcon();
			
			mileageTachoPage.clickPhotoCamera();
			Thread.sleep(10000);
			mileageTachoPage.captureCameraphoto();
			Thread.sleep(5000);
			mileageTachoPage.attachCameraphoto();
			Thread.sleep(5000);		
			jobCardPage.clickOnMenuButton();
			jobCardPage.clickOnchecklistMenuOption();
//			mileageTachoPage.clickOnAddImageIcon();
//			mileageTachoPage.clickOnImage();
			Thread.sleep(5000);
			aMob.AssertTrue(mileageTachoPage.isMileageTachoCameraStarIconVisible() == 1,
					"Camera Mandatory Star Icon Not Visible-- Green Dot Is Visible");

			mileageTachoPage.clickOnEngineHoursCameraIcon();
			int beforeImageAddAllIconsCount = mileageTachoPage.getTotalCameraIconCount();
			Log.info("jgajas" + beforeImageAddAllIconsCount);

//			mileageTachoPage.clickOnAddImageIcon();
//			mileageTachoPage.clickOnImage();
			
			mileageTachoPage.clickPhotoCamera();
			Thread.sleep(10000);
			mileageTachoPage.captureCameraphoto();
			Thread.sleep(5000);
			mileageTachoPage.attachCameraphoto();
			Thread.sleep(5000);		
			
			mileageTachoPage.clickOnEngineHoursCameraIcon();
			int AfterImageAddAllIconsCount = mileageTachoPage.getTotalCameraIconCount();
			Log.info("jgajas" + AfterImageAddAllIconsCount);
			aMob.AssertTrue(beforeImageAddAllIconsCount < AfterImageAddAllIconsCount, "Image Added Successfully");
			mileageTachoPage.tapOnScreen();
			
			
			//jobCardPage.switchToWebView();
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
			jobCardPage.clickOnMenuButton();
			jobCardPage.clickOnchecklistMenuOption();
			Thread.sleep(5000);
			jobCardPage.clickOnMenuButton();
			jobCardPage.clickOnTaskMenuOption();
			Thread.sleep(5000);
					
			jobCardPage.clickOnMenuButton();
			jobCardPage.clickOnchecklistMenuOption();
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
			//jobCardPage.switchToNativeView();
			mileageTachoPage.clickOnEsternoAnterioreSinistro3DotBtn();
			mileageTachoPage.clickOnPlusFromQuestions("Android");
			aMob.AssertTrue(mileageTachoPage.isThisQuestionHasBeenAddedTextVisible(),
					"This question has been added to the list of activities Text Visible");
			
			Thread.sleep(50000);
			jobCardPage.clickOnMenuButton();
			jobCardPage.clickOnDamagesMenuOption();	
			damagesPage.clickOnAddDamageVehicleFrontIcon();
			
			
//			mileageTachoPage.clickOnAddImageIcon();
//			mileageTachoPage.clickOnImage();
			
			mileageTachoPage.clickPhotoCamera();
			Thread.sleep(10000);
			mileageTachoPage.captureCameraphoto();
			Thread.sleep(5000);
			mileageTachoPage.attachCameraphoto();
			Thread.sleep(5000);		
			
			Thread.sleep(6000);
			aMob.AssertTrue(damagesPage.isPhotoVehicleFrontImageVisible(),
					"Image Added Successfully For Vehicle Front Section");
					
		    //Thread.sleep(50000);
			mileageTachoPage.clickOnCheckinIcon();
			mileageTachoPage.enterCustomerNameTextBox("HANS NAE AG");
			mileageTachoPage.enterSignatureTextBox();
			mileageTachoPage.turnOnTermConditionRadioButton("Android");
			Thread.sleep(5000);
			mileageTachoPage.clickOnSubmitBtn("Android");
			Thread.sleep(6000);
			//mileageTachoPage.clickOnCloseReceptionButton();

			jobCardPage.SelectReceivedAppointment(CustomerName, "Android");

	 		//mileageTachoPage.clickOnAddANewActivity3DotsBtn();
	
			// Need tO add One In Progress status Validation Point
	
	
	//mileageTachoPage.clickOnAddANewRunIcon();
	mileageTachoPage.clickOnaddANewRunIconOfflineActivity();
	 //mileageTachoPage.isActivityClockVisible();
   Thread.sleep(30000);
			// Need tO add Clocking Point Validation Point
			//mileageTachoPage.clickOnAddANewActivity3DotsAfterClickOnRunIconBtn();
			//mileageTachoPage.clickOnofflineActivity3DotsAfterClickRunBtn();
			//mileageTachoPage.clickOnaddANewRunIconOfflineActivity();
			// Need tO add Clocking Point Validation Point
   
   
			//mileageTachoPage.selectStatusOptionFromActivityDropDown("Done", "Android");
			
			mileageTachoPage.selectStatusOptionFromOfflineActivityDropDown("Done", "Android");
			// Need tO add Stop Clocking Point Validation Point
			// Need tO add Stop Done Status Validation Point
		
			//Adding Second Activity
			//jobCardPage.enterActivityOnActivityTextBox("Luci - Lato anteriore destro");
			
			jobCardPage.enterActivityOnActivityTextBox("Pneumatici - Esterno anteriore sinistro");
			jobCardPage.clickOnAddButton();
			Thread.sleep(10000);	
			aMob.AssertTrue(jobCardPage.isToExecuteStatusVisible(), "To Execute Status is Visible");
			//mileageTachoPage.clickOnAddANewActivity3DotsBtn();
			//mileageTachoPage.clickOnAddANewActivity3DotsAfterClickOnRunIconBtn();
			 
			//mileageTachoPage.clickOnAddANewRunIcon();
			mileageTachoPage.clickOnofflineSecondActivityRunBtn();
			//mileageTachoPage.clickOnAddANewActivity3DotsAfterClickOnRunIconBtn();
			
			mileageTachoPage.clickOnofflineSecondActivity3DotsAfterClickRunBtn();
			mileageTachoPage.clickOnCommentIcon();
			taskPage.enterTextOnComplaintTextBox("Customer complaint");
			taskPage.enterTextOnCauseTextBox("Problem cause");
			taskPage.enterTextOnCorrectionTextBox("Correction to be done");
			taskPage.enterTextOnInternalNoteTextBox("Internal Note");
			mileageTachoPage.clickOnSubmitBtn("Android");
					
			//mileageTachoPage.selectStatusOptionFromActivityDropDown("Done", "Android");
			mileageTachoPage.selectStatusOptionFromSecondActivityDropDown("Done", "Android");
			//Need Validation Point
			//Validation Clocking Automatically Stop
			//Adding Second Activity
			jobCardPage.enterActivityOnActivityTextBox("New activity added in off line");
			jobCardPage.clickOnAddButton();
			Thread.sleep(6000);
			mileageTachoPage.clickOnnewOfflineActivityRunIcon();
//			mileageTachoPage.clickOnnewOfflineActivity3DotsAfterClickRunBtn();
			//mileageTachoPage.clickOnAddANewActivity3DotsBtn();
//			mileageTachoPage.clickOnAddANewRunIcon();
			mileageTachoPage.clickOnnewOfflineActivity3DotsAfterClickRunBtn();
			int beforeCount = mileageTachoPage.getTotalCameraIconCount();
			Log.info("jgjh" + beforeCount);
			
			mileageTachoPage.clickPhotoCamera();
			Thread.sleep(10000);
			mileageTachoPage.captureCameraphoto();
			Thread.sleep(5000);
			mileageTachoPage.attachCameraphoto();
			Thread.sleep(5000);	
			mileageTachoPage.enterMediaDescriptionOnTextBox("New Activity photo description");
			mileageTachoPage.clickOnSaveBtnOnAddMediaDescription();
			Thread.sleep(5000);	
			
//			mileageTachoPage.clickOnAppointmentImageIcon();
//			// mileageTachoPage.clickOnAddImageIcon();
//			mileageTachoPage.clickOnImage();
			Thread.sleep(6000);
			//mileageTachoPage.clickOnAddANewActivity3DotsAfterClickOnRunIconBtn();
			mileageTachoPage.clickOnnewOfflineActivity3DotsAfterClickRunBtn();
			int afterCount = mileageTachoPage.getTotalCameraIconCount();
			Log.info("jgjh" + afterCount);
			aMob.AssertTrue(beforeCount < afterCount, "Image Added Successfully");
			mileageTachoPage.tapOnScreen();
			//mileageTachoPage.selectStatusOptionFromActivityDropDown("Done", device);
			mileageTachoPage.selectStatusOptionFromNewOfflineActivityDropDown("Done", "Android");
			//mileageTachoPage.clickOnCheckinIcon();
			
			mileageTachoPage.clickOnCheckinActivity();
			mileageTachoPage.enterCustomerNameTextBox("HANS NAE AG");
			mileageTachoPage.enterSignatureTextBox();
			mileageTachoPage.turnOnTermConditionRadioButton("Android");
			mileageTachoPage.clickOnSubmitBtn("Android");
			Thread.sleep(5000);	
			// Need to add one validation point
			genericPage.turnOnWiFi("enable");
			Thread.sleep(5000);

		}
		@AfterMethod(alwaysRun = true)
		public void afterMethod() {
			System.out.println("Test");
			// driver.quit();
		}
	}

}

 
 */
