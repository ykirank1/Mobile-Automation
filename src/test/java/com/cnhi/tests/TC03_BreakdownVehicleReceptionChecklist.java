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
import com.cnhi.pageObjects.VehicleDetailPage;

public class TC03_BreakdownVehicleReceptionChecklist extends BaseTest {
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
		
		@Test(description = "T90-02-04-08-03 CV - Breakdown - Vehicle reception - Reception checklist")
		public void BreakdownVehicleReceptionChecklistTest() throws Exception {
			loginPage.loginToApplication("W90041D", "Saize9046");
			System.out.println(driver.getContextHandles());
			homePage.clickOnJobCardOption();
			Thread.sleep(3000);
	        //String CustomerName="03 - Customer VALID2022/04/21 14:47:46";
			jobCardPage.clickOnCreateButton();
			jobCardPage.clickOnBreakdownOrRemoteAppointmentCheckBox();
			String CustomerName = "03 - Customer VALID" + genericPage.getCurrentDate("yyyy/MM/dd HH:mm:ss");
			jobCardPage.enterCustomerNameOnCustomerNameTextBox(CustomerName, device);
			jobCardPage.enterEmailOnCustomerEmailTextBox("customer.valid@cnhi.com");
			jobCardPage.enterPhoneNoOnCustomerPhoneTextBox("0634353637");
			jobCardPage.enterContactNoOnContactPhoneTextBox("0745464748");
			jobCardPage.enterBrandOnBrandTextBox("IVECO");
			jobCardPage.enterModelOnModelNameTextBox("50C15V",device);
			jobCardPage.enterNumberOnPlateNumberTextBox("ZE-983IW",device);
			jobCardPage.enterMileageOnMileageTextBox("40000", device);
			jobCardPage.enterSerialNumberOnSerialNumberTextBox("ZCFC150A705105307");
			Thread.sleep(3000);
			jobCardPage.enterComplainsOnCustomerComplainsTextBox("Alarm on");
			jobCardPage.enterAddressOnRepairAddressTextBox("Valid Office India");
			jobCardPage.selectCheckListOption("Test Reception checklist");
//			jobCardPage.navigatingToCustomerNameTextBox();
//			jobCardPage.enterCustomerNameOnCustomerNameTextBox(CustomerName, device);
//			jobCardPage.enterEmailOnCustomerEmailTextBox("customer.valid@cnhi.com");
//			jobCardPage.enterPhoneNoOnCustomerPhoneTextBox("0634353637");
//			jobCardPage.enterContactNoOnContactPhoneTextBox("0745464748");
				jobCardPage.clickOnNextStepButton();
			jobCardPage.enterActivityOnActivityTextBox("Remote Activity");
			jobCardPage.clickOnAddButton();
			aMob.AssertTrue(jobCardPage.isToExecuteStatusVisible(), "To Execute Ststus is Visible");
			jobCardPage.clickOnSaveButton();
			Thread.sleep(10000);
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
			Thread.sleep(5000);			
			aMob.AssertTrue(jobCardPage.isAppointmentInfoLabelVisible(), "Appointment Info Label is Visible");
//			aMob.AssertTrue(CustomerName.contains(jobCardPage.getCustomerInfoFromAppointmentInfo(device)),
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

			mileageTachoPage.clickOnMileageTachoTab();
			Log.info("gjhgjh" + mileageTachoPage.isMileageTachoCameraStarIconVisible());
			aMob.AssertTrue(mileageTachoPage.isMileageTachoCameraStarIconVisible() == 2,
					"Camera Mandatory Star Icon Is Visible");
//			mileageTachoPage.clickOnMileageTachoCameraIcon();
//			mileageTachoPage.clickOnAddImageIcon();
//			mileageTachoPage.clickOnImage();
			
			mileageTachoPage.clickOnMileageTachoCameraIcon();
			mileageTachoPage.clickPhotoCamera();
			Thread.sleep(10000);
			mileageTachoPage.captureCameraphoto();
			Thread.sleep(10000);
			mileageTachoPage.attachCameraphoto();
			Thread.sleep(5000);	
			Log.info("gjhgjh" + mileageTachoPage.isMileageTachoCameraStarIconVisible());

			Thread.sleep(8000);
			// driver.context(Geeks[1]);
			System.out.println(driver.getContext());

//			System.out.println(driver.findElement(By.xpath("(//ion-button[@id='jobcard-mandatoryfield-mileage-photo-phone'])[1]")).getCssValue("color"));
//			System.out.println(driver.findElement(By.xpath("(//ion-button[@id='jobcard-mandatoryfield-mileage-photo-phone'])[1]")).getCssValue("--ion-color-primary-rgb"));

			// driver.context(Geeks[0]);
			System.out.println(driver.getContext());
			Thread.sleep(5000);
			
			aMob.AssertTrue(mileageTachoPage.isMileageTachoCameraStarIconVisible() == 1,
					"Camera Mandatory Star Icon Not Visible-- Green Dot Is Visible");

			jobCardPage.selectCheckListOption("Test Reception Checklist");
			mileageTachoPage.clickOnQuestion13DotsBtn();
			mileageTachoPage.clickOnCommentIcon();
			mileageTachoPage.enterCommentTextBox("Technician Comment on Inspection checklist");
			Thread.sleep(5000);
			mileageTachoPage.clickOnSubmitBtn("Android");
			Thread.sleep(5000);

			//String yesChkBeforeStatus = mileageTachoPage.getYesRadioButtonCheckStatus("Android");
			
			String yesChkBeforeStatus = mileageTachoPage.getYesRadioButtonCheckStatus("Android");
			aMob.AssertEquals(mileageTachoPage.getYesRadioButtonCheckStatus("Android"), "false",
					"Question 1 Yes Radio button Before Status");
			mileageTachoPage.clickOnYesRadioBtnFromQuestion1();
		    Log.info(yesChkBeforeStatus);
			mileageTachoPage.clickOnQuestion23DotsBtn();
			int beforeCount = mileageTachoPage.getTotalCameraIconCount();
			Log.info("No.of Icons in Dots Menu Before " + beforeCount);
//			mileageTachoPage.clickOnAddImageIconFromQuestions();
//			mileageTachoPage.clickOnImage();
			mileageTachoPage.clickPhotoCamera();
			Thread.sleep(10000);
			mileageTachoPage.captureCameraphoto();
			Thread.sleep(10000);
			mileageTachoPage.attachCameraphoto();
			Thread.sleep(10000);	
			mileageTachoPage.clickOnQuestion23DotsBtn();
			int afterCount = mileageTachoPage.getTotalCameraIconCount();
			Log.info("No.of Icons in Dots Menu After" + afterCount);
			aMob.AssertTrue(beforeCount < afterCount, "Image Added Successfully");
			mileageTachoPage.tapOnScreen();
			String greenChkBeforeStatus = mileageTachoPage.getGreenRadioButtonCheckStatus("Android");
			mileageTachoPage.clickOnGreenRadioBtnFromQuestion2();
			mileageTachoPage.clickOnQuestion33DotsBtn();
			mileageTachoPage.clickOnRecorderIcon();
			mileageTachoPage.clickOnRecordedBtnIcon();
			Thread.sleep(5000);
			//mileageTachoPage.clickOnOkButton();
			mileageTachoPage.clickOnRecorderStopBtnIcon();
			aMob.AssertTrue(mileageTachoPage.isRecordedVoiceVisible(), "Recorded Voice Visible Successfully");
			mileageTachoPage.clickOnRecordeCloseBtnIcon();
			Thread.sleep(5000);
			
			String sliderBeforeValue = mileageTachoPage.getSliderValue();
			mileageTachoPage.slideQuestion3Slider();
			String sliderAfterValue = mileageTachoPage.getSliderValue();
			aMob.AssertTrue(!sliderBeforeValue.equalsIgnoreCase(sliderAfterValue),
					"Slider Value Before Click On Slider i.e. " + sliderBeforeValue
							+ " Changed After Clicking On Slider i.e. " + sliderAfterValue);

			mileageTachoPage.clickOnQuestion43DotsBtn();
			mileageTachoPage.clickOnCommentIcon();
			mileageTachoPage.enterCommentTextBox("Technician Comment on Inspection checklist");
			mileageTachoPage.clickOnSubmitBtn("Android");
			
			String OnOffChkBeforeStatus = mileageTachoPage.getonOffSwitchButtonCheckStatus("Android");
			mileageTachoPage.clickOnSwitcherFromQuestion4FromQuestion4();

			mileageTachoPage.clickOnCheckinIcon();
			mileageTachoPage.enterCustomerNameTextBox("Customer VALID");
			mileageTachoPage.enterSignatureTextBox();
			mileageTachoPage.turnOnTermConditionRadioButton("Android");
			Thread.sleep(5000);
			mileageTachoPage.clickOnSubmitBtn("Android");
			Thread.sleep(5000);
			//mileageTachoPage.clickOnCloseReceptionButton();
			
			jobCardPage.SelectReceivedAppointment(CustomerName,"Android");
			jobCardPage.clickOnMenuButton();
			jobCardPage.clickOnchecklistMenuOption();

			//mileageTachoPage.clickOnCheckinIcon();

//			String yesChkFinalStatus = mileageTachoPage.getYesRadioButtonCheckStatus("Android");
//			aMob.AssertTrue(!yesChkFinalStatus.equalsIgnoreCase(yesChkBeforeStatus),
//					"Yes Radio Chk Value Before Click i.e. " + yesChkBeforeStatus + " Changed After Clicking i.e. "
//							+ yesChkFinalStatus);
							
			
			String yesChkFinalStatus = mileageTachoPage.getYesRadioButtonCheckStatus("Android");
			aMob.AssertEquals(mileageTachoPage.getYesRadioButtonCheckStatus("Android"), "1",
					"Question 1 Yes Radio button After Status");
			
			mileageTachoPage.clickOnQuestion13DotsBtn();
			mileageTachoPage.clickOnCommentIcon();
			aMob.AssertEquals(mileageTachoPage.getCommentBoxText("Android"), "Technician Comment on Inspection checklist",
					"Comment Value i.e. " + mileageTachoPage.getCommentBoxText("Android") + "Is Matched With The Expected");
			mileageTachoPage.clickOnSubmitBtn("Android");

			String greenChkFinalStatus = mileageTachoPage.getGreenRadioButtonCheckStatus("Android");
			aMob.AssertTrue(!greenChkFinalStatus.equalsIgnoreCase(greenChkBeforeStatus),
					"Green Radio Chk Value Before Click i.e. " + greenChkBeforeStatus + " Changed After Clicking i.e. "
							+ greenChkFinalStatus);
			mileageTachoPage.clickOnQuestion23DotsBtn();
			mileageTachoPage.clickOnImageAddedEyeIcon("Android");
			aMob.AssertTrue(mileageTachoPage.isAddedImageVisible(), "Image Added Successfully");
			mileageTachoPage.clickOnCloseBtnFromAddedImageScreen();

			String sliderFinalValue = mileageTachoPage.getSliderValue();
			aMob.AssertTrue(!sliderBeforeValue.equalsIgnoreCase(sliderFinalValue),
					"Slider Value Before Click On Slider i.e. " + sliderBeforeValue
							+ " Changed After Clicking On Slider i.e. " + sliderFinalValue);
			mileageTachoPage.clickOnQuestion33DotsBtn();
			mileageTachoPage.clickOnRecorderIcon();
			aMob.AssertTrue(mileageTachoPage.isRecordedVoiceVisible(), "Recorded Voice Visible Successfully");
			mileageTachoPage.clickOnRecordeCloseBtnIcon();
            Thread.sleep(5000);
			String OnOffChkFinalStatus = mileageTachoPage.getonOffSwitchButtonCheckStatus("Android");
			aMob.AssertTrue(!OnOffChkFinalStatus.equalsIgnoreCase(OnOffChkBeforeStatus),
					"Green Radio Chk Value Before Click i.e. " + OnOffChkBeforeStatus + " Changed After Clicking i.e. "
							+ OnOffChkFinalStatus);

		}

		@AfterMethod(alwaysRun = true)
		public void afterMethod() {
			System.out.println("Test");
			// driver.quit();
		}
	}

}
