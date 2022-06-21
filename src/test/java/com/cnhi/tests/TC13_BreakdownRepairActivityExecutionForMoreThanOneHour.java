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

public class TC13_BreakdownRepairActivityExecutionForMoreThanOneHour extends BaseTest {
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
		public void BreakdownRepairActivityExecutionForMoreThanOneHour() throws Exception {
			loginPage.loginToApplication("W90041D", "Saize9046");
			homePage.clickOnJobCardOption();
			//String CustomerName="HANS NAEF AG2022/05/19 11:47:45";
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
			jobCardPage.enterActivityOnActivityTextBox("Long Activity");
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
			int beforeImageAddAllIconsCount = mileageTachoPage.getTotalCameraIconCount();
			mileageTachoPage.clickPhotoCamera();
			Thread.sleep(10000);
			mileageTachoPage.captureCameraphoto();
			Thread.sleep(5000);
			mileageTachoPage.attachCameraphoto();
			Thread.sleep(5000);	
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
			mileageTachoPage.clickOnRunIconLongActivityBtn();
			Thread.sleep(30000);
//			jobCardPage.clickOnMenuButton();
//			jobCardPage.clickOnchecklistMenuOption();
//			Thread.sleep(30000);
			jobCardPage.clickOnMenuButton();
			jobCardPage.clickOnTaskMenuOption();
			Thread.sleep(10000);
			mileageTachoPage.selectStatusOptionFromLongActivityDropDown("Done", "Android");
			Thread.sleep(5000);
			jobCardPage.clickOnMenuButton();
			jobCardPage.clickOnHomeButton();
			jobCardPage.SelectRepairingAppointment(CustomerName, "Android");
			aMob.AssertTrue(mileageTachoPage.isLongActivityVisible(), "Newly Created Long Activity is Visible");
			mileageTachoPage.GetClockedTimeDurationLongActivity();
			aMob.AssertEquals(taskPage.getStatusOfLongActivityText().trim(), "Done",
					"Long Activity text from Task Screen i.e. " + taskPage.getStatusOfLongActivityText()
							+ " is same as Expected");
		}
		@AfterMethod(alwaysRun = true)
		public void afterMethod() {
			System.out.println("Test");
			// driver.quit();
		}
	}

}


