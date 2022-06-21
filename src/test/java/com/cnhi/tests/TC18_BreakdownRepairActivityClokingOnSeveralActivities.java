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

public class TC18_BreakdownRepairActivityClokingOnSeveralActivities extends BaseTest {
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
		public void TC18_BreakdownRepairActivityClokingOnSeveralActivities() throws Exception {
			loginPage.loginToApplication("W90041D", "Saize9046");
			homePage.clickOnJobCardOption();
			//String CustomerName="Customer VALID2022/05/26 16:00:58";
			jobCardPage.clickOnCreateButton();
			jobCardPage.clickOnBreakdownOrRemoteAppointmentCheckBox();
			String CustomerName = "Customer VALID" + genericPage.getCurrentDate("yyyy/MM/dd HH:mm:ss");
			jobCardPage.enterCustomerNameOnCustomerNameTextBox(CustomerName, device);
			jobCardPage.enterEmailOnCustomerEmailTextBox("customer.valid@cnhi.com");
			jobCardPage.enterPhoneNoOnCustomerPhoneTextBox("0634353637");
			jobCardPage.enterContactNoOnContactPhoneTextBox("06303711111");
			jobCardPage.enterBrandOnBrandTextBox("IVECO");
			jobCardPage.enterModelOnModelNameTextBox("50C15V", device);
			jobCardPage.enterNumberOnPlateNumberTextBox("ZE 543IT", device);
			jobCardPage.enterMileageOnMileageTextBox("450", device);
			jobCardPage.enterSerialNumberOnSerialNumberTextBox("ZCFC150A405054736");
			Thread.sleep(3000);
			jobCardPage.enterComplainsOnCustomerComplainsTextBox("Oil");
			jobCardPage.enterAddressOnRepairAddressTextBox("Valid Office, Rue de Marhum, 64100 BAYONNE");
			jobCardPage.selectCheckListOption("Reception Checklist");
	
			jobCardPage.clickOnNextStepButton();
			
			//Enter Activity 1 Details
			jobCardPage.enterActivityOnActivityTextBox("Activity 1");
			jobCardPage.clickOnAddButton();
			aMob.AssertTrue(jobCardPage.isToExecuteStatusVisible(), "To Execute Status is Visible");
			jobCardPage.clickOnArrowButton();
			jobCardPage.enterDefectCodeOnActivityTextBox("528940 SECOND FRONT AXLE STABILIZER");
			jobCardPage.selectFailureOptionFromFailureDropDown("004 - DEFORMED", "Android");
			jobCardPage.selectFailureSeverityRateFromFailureSeverityRateDropDown("0 - Light", "Android");
			jobCardPage.selectPaymentTypeFromPaymentTypeDropDown("Cliente", "Android");
			jobCardPage.selectPaymentSubTypeFromPaymentTypeDropDown("a carico cliente", "Android");
			jobCardPage.clickOnAddNewOperationBtn("Android");
			jobCardPage.enterOperationNameTextBox("52 89 60 200 - OVERHAUL REAR AXLE STABILIZER WITH UPPER ARTICULATED JOINT", device);
			jobCardPage.clickOnSaveButton();
//			aMob.AssertTrue(jobCardPage.isNewOperationCreated("OVERHAUL SECOND FRONT AXLE STABILIZER WITH UPPER ARTICULATED JOINT"),
//					"New Operation Added Successfully");
			

			//Enter Activity 2 Details
			jobCardPage.enterActivityOnActivityTextBox("Activity 2");
			jobCardPage.clickOnAddButton();
			aMob.AssertTrue(jobCardPage.isToExecuteStatusVisible(), "To Execute Status is Visible");
			jobCardPage.clickOnActivity2ArrowButton();
			jobCardPage.enterDefectCodeOnActivity2TextBox("754519 BATTERY TRIM");
			jobCardPage.selectFailureOptionFromFailure2DropDown("017 - OVERHEATING", "Android");
			jobCardPage.selectFailureSeverityRateFromFailureSeverityRate2DropDown("2 - Severe", "Android");
			jobCardPage.selectPaymentTypeFromPaymentType2DropDown("Cliente", "Android");
			jobCardPage.selectPaymentSubTypeFromPaymentType2DropDown("a carico cliente", "Android");
			jobCardPage.clickOnAddNewOperation2Btn("Android");
			jobCardPage.enterOperationNameTextBox("76 20 10 100 - R-I 1 BATTERY", device);
			jobCardPage.clickOnSaveButton();
			
			
			jobCardPage.clickOnSaveButton();
			Thread.sleep(5000);
			String appointmentData = jobCardPage.getCreatedAppointmentData(CustomerName, "Android");

			aMob.AssertTrue(appointmentData.contains(CustomerName),
					"Customer Name Visible In the List Of New Created Appointment");
			aMob.AssertTrue(appointmentData.contains("50C15V"),
					"Model Name Visible In the First Of New Created Appointment");
			aMob.AssertTrue(appointmentData.contains("50C15V"),
					"Model Name Visible In the First Of New Created Appointment");
			aMob.AssertTrue(appointmentData.contains("ZE 543IT"),
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
	
	
			aMob.AssertTrue(mileageTachoPage.isMileageTachoCameraStarIconVisible() == 2,
					"Camera Mandatory Star Icon Is Visible");
			mileageTachoPage.clickOnMileageTachoCameraIcon();
			int beforeImageAddAllIconsCount = mileageTachoPage.getTotalCameraIconCount();
			mileageTachoPage.clickPhotoCamera();
			Thread.sleep(10000);
			mileageTachoPage.captureCameraphoto();
			Thread.sleep(5000);
			mileageTachoPage.attachCameraphoto();
			Thread.sleep(10000);	
			mileageTachoPage.clickOnMileageTachoCameraIcon();
			int AfterImageAddAllIconsCount = mileageTachoPage.getTotalCameraIconCount();
			aMob.AssertTrue(beforeImageAddAllIconsCount < AfterImageAddAllIconsCount, "Image Added Successfully");
			mileageTachoPage.tapOnScreen();
			mileageTachoPage.clickOnCheckinIcon();
			mileageTachoPage.enterCustomerNameTextBox("HANS NAE AG");
			mileageTachoPage.enterSignatureTextBox();
			mileageTachoPage.turnOnTermConditionRadioButton("Android");
			Thread.sleep(5000);
			mileageTachoPage.clickOnSubmitBtnOnClientSignature();
			Thread.sleep(5000); 
	
			jobCardPage.SelectReceivedAppointment(CustomerName, "Android");	
			aMob.AssertTrue(jobCardPage.isToExecuteStatusVisible(), "To Execute Status is Visible");
			
			mileageTachoPage.clickOnAddANewRunIconActivity1();
			Thread.sleep(30000);
			 mileageTachoPage.isActivity1ClockVisible();
			    mileageTachoPage.inProgressStatusBtnVisible();
			jobCardPage.clickOnMenuButton();
			jobCardPage.clickOnTaskMenuOption();
			Thread.sleep(30000);
			mileageTachoPage.clickOnAddANewRunIconActivity2();
			    mileageTachoPage.isActivity2ClockVisible();
				jobCardPage.clickOnMenuButton();
				jobCardPage.clickOnHomeButton();
				jobCardPage.clickOnNonPrductiveJobDetailsTabButton();
				jobCardPage.clickOnAutoTestCleaningRunButton();
				Thread.sleep(5000);
				jobCardPage.isautoTestCleaningActivityLabelVisible();
				jobCardPage.clickOnJOBDetailsTabButton();
				Thread.sleep(5000);
				jobCardPage.SelectRepairingAppointment(CustomerName, "Android");	
				jobCardPage.clickOnMenuButton();
				jobCardPage.clickOnTaskMenuOption();
				Thread.sleep(5000);
				mileageTachoPage.clickOnAddANewRunIconActivity2();
			    mileageTachoPage.isActivity2ClockVisible();
				jobCardPage.clickOnMenuButton();
				jobCardPage.clickOnHomeButton();
				jobCardPage.clickOnNonPrductiveJobDetailsTabButton();
				jobCardPage.clickOnclockOutActivityButton();
				jobCardPage.clickOnOkButton();
				Thread.sleep(5000);
				jobCardPage.clickOnJOBDetailsTabButton();
				Thread.sleep(5000);
				jobCardPage.SelectRepairingAppointment(CustomerName, "Android");	
			    //mileageTachoPage.GetActivity1ClockedTimeDuration();
			   // mileageTachoPage.GetActivity2ClockedTimeDuration();
				Thread.sleep(5000);
		}
		@AfterMethod(alwaysRun = true)
		public void afterMethod() {
			System.out.println("Test");
			// driver.quit();
		}
	}

}


