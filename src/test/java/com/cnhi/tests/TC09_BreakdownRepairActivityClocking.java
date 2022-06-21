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


public class TC09_BreakdownRepairActivityClocking extends BaseTest {
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
		public void BreakdownRepairActivityClocking() throws Exception {
			loginPage.loginToApplication("W90041D", "Saize9046");
			homePage.clickOnJobCardOption();
			Thread.sleep(3000);
			Set<String> view = driver.getContextHandles();
			System.out.println(view);
			//String CustomerName = "HANS NAEF AG2022/05/06 12:00:04";
			jobCardPage.clickOnCreateButton();
			jobCardPage.clickOnBreakdownOrRemoteAppointmentCheckBox();
			String CustomerName = "HANS NAEF AG" + genericPage.getCurrentDate("yyyy/MM/dd HH:mm:ss");
			jobCardPage.enterCustomerNameOnCustomerNameTextBox(CustomerName, "Android");
			jobCardPage.enterEmailOnCustomerEmailTextBox("customer.valid@cnhi.com");
			jobCardPage.enterPhoneNoOnCustomerPhoneTextBox("0634353637");
			jobCardPage.enterContactNoOnContactPhoneTextBox("0745464748");
			jobCardPage.enterBrandOnBrandTextBox("IVECO");
			jobCardPage.enterModelOnModelNameTextBox("AD340T45", "Android");
			jobCardPage.enterNumberOnPlateNumberTextBox("TG30155", "Android");
			jobCardPage.enterMileageOnMileageTextBox("450", device);
			jobCardPage.enterSerialNumberOnSerialNumberTextBox("WJMJ3JTS40C186565");
			Thread.sleep(3000);
			jobCardPage.enterComplainsOnCustomerComplainsTextBox("Alarm on");
			jobCardPage.enterAddressOnRepairAddressTextBox("Amriswilerstrasse 18, 9315 Egnach, Switzerland ");
			jobCardPage.selectCheckListOption("Reception Checklist");
			jobCardPage.clickOnNextStepButton();
			jobCardPage.enterActivityOnActivityTextBox("Activity to be clocked");
			jobCardPage.clickOnAddButton();
			aMob.AssertTrue(jobCardPage.isToExecuteStatusVisible(), "To Execute Ststus is Visible");

			jobCardPage.clickOnArrowButton();
			jobCardPage.enterDefectCodeOnActivityTextBox("528940 SECOND FRONT AXLE STABILIZER");
			jobCardPage.selectFailureOptionFromFailureDropDown("004 - DEFORMED", device);
			jobCardPage.selectFailureSeverityRateFromFailureSeverityRateDropDown("1 - Medium", "Android");
			
			//Need To Change Payment Data
			jobCardPage.selectPaymentTypeFromPaymentTypeDropDown("TEST Payment Type", "Android");

			jobCardPage.clickOnAddNewOperationBtn("Android");
			jobCardPage.enterOperationNameTextBox("52 89 40 200 - OVERHAUL SECOND FRONT AXLE STABILIZER WITH UPPER ARTICULATED JOINT", "Android");
			jobCardPage.clickOnSaveButton();
//			aMob.AssertTrue(jobCardPage.isNewOperationCreated("R-I SAFETY BELTS DRIVER SEAT"),
//					"New Operation Added Successfully");
			jobCardPage.clickOnSaveButton();
			String appointmentData = jobCardPage.getCreatedAppointmentData(CustomerName, "Android");

			aMob.AssertTrue(appointmentData.contains(CustomerName),
					"Customer Name Visible In the List Of New Created Appointment");
			aMob.AssertTrue(appointmentData.contains("AD340T45"),
					"Model Name Visible In the First Of New Created Appointment");
			aMob.AssertTrue(appointmentData.contains("TG30155"),
					"Plate Number Visible In the First Of New Created Appointment");
			jobCardPage.SelectCreatedAppointment(CustomerName, "Android");

			aMob.AssertTrue(jobCardPage.isUnassignedActivitiesPopupVisible(),
					"Message Unassigned Activities For Breakdown is Visible");
			jobCardPage.clickOnYesButton();
			aMob.AssertTrue(jobCardPage.isAppointmentInfoLabelVisible(), "Appointment Info Label is Visible");
			aMob.AssertTrue(CustomerName.contains(jobCardPage.getCustomerInfoFromAppointmentInfo("Android")),
					"Customer Name from Appointment Screen i.e. " + jobCardPage.getCustomerInfoFromAppointmentInfo("Android")
							+ " is same as Expected");

			aMob.AssertEquals(jobCardPage.getModelInfoFromAppointmentInfo("Android"), "AD340T45",
					"Model Name from Appointment Screen i.e. " + jobCardPage.getModelInfoFromAppointmentInfo("Android")
							+ " is same as Expected");

			aMob.AssertEquals(jobCardPage.getReceptionDateFromAppointmentInfo("Android"),
					genericPage.getCurrentDate("MMM dd, yyyy"),
					"Reception Date From Appointment Screen i.e. " + jobCardPage.getReceptionDateFromAppointmentInfo("Android")
							+ " is same as Expected i.e. " + genericPage.getCurrentDate("MMM dd, yyyy"));

			aMob.AssertEquals(jobCardPage.getDeliveryDateFromAppointmentInfo("Android"),
					genericPage.getCurrentDate("MMM dd, yyyy"),
					"Delivery Date From Appointment Screen i.e. " + jobCardPage.getDeliveryDateFromAppointmentInfo("Android")
							+ " is same as Expected i.e. " + genericPage.getCurrentDate("MMM dd, yyyy"));

			//jobCardPage.selectCheckListOption("Test Reception Checklist");
			
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
			Thread.sleep(5000);
			mileageTachoPage.clickOnSubmitBtn("Android");
			
			//mileageTachoPage.clickOnCloseReceptionButton();
			jobCardPage.SelectReceivedAppointment(CustomerName, "Android");
			Thread.sleep(5000);
			
			
			
			//Thread.sleep(50000);
			jobCardPage.clickOnMenuButton();
			jobCardPage.clickOnTaskMenuOption();
			//mileageTachoPage.clickOnAddANewActivity3DotsBtn();
			//Need tO add One In Progress status Validation Point
			//mileageTachoPage.clickOnAddANewRunIcon();
			mileageTachoPage.clickOnAddANewRunIconRemoteActivity();
			 mileageTachoPage.isActivityClockVisible();
	        Thread.sleep(30000);
	        jobCardPage.clickOnMenuButton();
			jobCardPage.clickOnTaskMenuOption();
	        Thread.sleep(30000);
//	    	Set<String> view1 = driver.getContextHandles();
//			System.out.println(view1);
	        //Need tO add Clocking Point Validation Point
	        mileageTachoPage.clickOnAddANewActivity3DotsAfterClickOnRunIconBtn();
	       // mileageTachoPage.clickOnAddANewRunIcon();
	        //jobCardPage.switchToNativeView();
	        mileageTachoPage.inProgressStatusBtnVisible();
	        Thread.sleep(5000);
	        mileageTachoPage.GetClockedTimeDuration();
			//mileageTachoPage.clickOnAddANewActivity3DotsBtn();
			//mileageTachoPage.clickOnAddANewRunIcon();
			//Need tO add Clocking Point Validation Point
			//mileageTachoPage.clickOnAddANewActivity3DotsBtn();
	        //Need tO add Clocking Point Validation Point
			//mileageTachoPage.clickOnAddANewRunIcon();
			mileageTachoPage.clickOnAddANewRunIconRemoteActivity();
			Thread.sleep(30000);
			//Need tO add Stop Clocking Point Validation Point
			//mileageTachoPage.clickOnAddANewRunIcon();
			
			mileageTachoPage.clickOnAddANewActivity3DotsAfterClickOnRunIconBtn();
			
			mileageTachoPage.selectStatusOptionFromActivityDropDown("Done", "Android");		
			// mileageTachoPage.clickOnOkButton();
			//Need tO add Stop Done Status Validation Point
			
			mileageTachoPage.selectStatusOptionFromActivityDropDown("In progress", "Android");
			Thread.sleep(45000);
			//Need tO add Stop Clocking Point Validation Point
			mileageTachoPage.selectStatusOptionFromActivityDropDown("Done", "Android");
			//Need tO add Stop Done Status Validation Point
			
			//mileageTachoPage.clickOnCheckinIcon();
			mileageTachoPage.clickOnCheckinActivity();
			mileageTachoPage.enterCustomerNameTextBox("Customer VALID");
			mileageTachoPage.enterSignatureTextBox();
			mileageTachoPage.turnOnTermConditionRadioButton("Android");
			mileageTachoPage.clickOnSubmitBtn("Android");
			//mileageTachoPage.clickOnCloseReceptionButton();
			Thread.sleep(5000);
			
			//Need to add 3 more steps
		}
		@AfterMethod(alwaysRun = true)
		public void afterMethod() {
			System.out.println("Test");
			// driver.quit();
		}
	}

}
