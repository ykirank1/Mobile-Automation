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
import com.cnhi.pageObjects.TravelPage;


public class TC17_BreakdownVehicleReceptionTravel extends BaseTest {
	GenericPage genericPage;
	AppDeviceFactory getDevice;
	DeviceConfiguration deviceConfiguration;
	MileageTachoPage mileageTachoPage;
	LoginPage loginPage;
	HomePage homePage;
	JobCardPage jobCardPage;
	Assertion aMob;
	String device;
	TaskPage taskPage;
	TravelPage travelPage;

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
		travelPage = new TravelPage(driver, genericPage);
		// driver.launchApp();

	}

	public class Demotest extends BaseTest {
		GenericPage genericPage;
		AppDeviceFactory getDevice;
		DeviceConfiguration deviceConfiguration;
		MileageTachoPage mileageTachoPage;
		LoginPage loginPage;
		HomePage homePage;
		JobCardPage jobCardPage;
		VehicleDetailPage vehicleDetailPage;
		Assertion aMob;
		String device;
		TravelPage travelPage;
		
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
			travelPage = new TravelPage(driver, genericPage);
			// driver.launchApp();

		}
		
		@Test(description = "1	T90-02-04-08-02 CV - Breakdown - Creation - Vehicle details")
		public void TC17_BreakdownVehicleReceptionTravel() throws Exception {
			Thread.sleep(10000);
			loginPage.loginToApplication("W90041D", "Saize9046");
			homePage.clickOnJobCardOption();
			//String CustomerName="Customer VALID2022/05/26 16:00:58";
			jobCardPage.clickOnCreateButton();
			jobCardPage.clickOnBreakdownOrRemoteAppointmentCheckBox();
			//Making Random Customer Name
			String CustomerName="Customer VALID"+genericPage.getCurrentDate("yyyy/MM/dd HH:mm:ss");
			jobCardPage.enterCustomerNameOnCustomerNameTextBox(CustomerName, device);
			//jobCardPage.enterCustomerNameOnCustomerNameTextBox("12 - VALID Customer (64100)", device);
			jobCardPage.enterEmailOnCustomerEmailTextBox("valid@jobcard.com");
			jobCardPage.enterPhoneNoOnCustomerPhoneTextBox("123456789");
			jobCardPage.enterContactNoOnContactPhoneTextBox("123456789");
			jobCardPage.enterBrandOnBrandTextBox("IVECO");
			jobCardPage.enterModelOnModelNameTextBox("50C15 V",device);
			jobCardPage.enterNumberOnPlateNumberTextBox("ZE 543IT",device);
			jobCardPage.enterMileageOnMileageTextBox("650",device);
			jobCardPage.enterSerialNumberOnSerialNumberTextBox("ZCFC150A405054736");
			jobCardPage.enterComplainsOnCustomerComplainsTextBox("Alarm On");
			jobCardPage.enterAddressOnRepairAddressTextBox("Customer VALID Office Testing street 34001 TEST ");
			jobCardPage.clickOnNextStepButton();
			jobCardPage.enterActivityOnActivityTextBox("Travel Activity");
			jobCardPage.clickOnAddButton();
			aMob.AssertTrue(jobCardPage.isToExecuteStatusVisible(), "To Execute Status is Visible");
		jobCardPage.clickOnSaveButton();
			Thread.sleep(10000);
		jobCardPage.SelectCreatedAppointment(CustomerName,device);
			aMob.AssertTrue(jobCardPage.isUnassignedActivitiesPopupVisible(),
					"Message Unassigned Activities For Breakdown is Visible");
			jobCardPage.clickOnYesButton();
			aMob.AssertTrue(jobCardPage.isAppointmentInfoLabelVisible(), "Appointment Info Label is Visible");
//			aMob.AssertEquals(jobCardPage.getCustomerInfoFromAppointmentInfo(device).trim(), CustomerName,
//					"Customer Name from Appointment Screen i.e. " + jobCardPage.getCustomerInfoFromAppointmentInfo(device)
//							+ " is same as Expected");
			aMob.AssertEquals(jobCardPage.getModelInfoFromAppointmentInfo(device).trim(), "50C15 V",
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

			jobCardPage.clickOnMenuButton();
			travelPage.clickOnTravelMenuButton();
			
			travelPage.clickOnNewTravelButton();
			travelPage.isAddTravelLabelVisible();
			travelPage.isAddTravelNameVisible();
			travelPage.isAddTravelCANCELBtnVisible();
			travelPage.isAddTravelCONTINUEBtnVisible();
			travelPage.enterTravelNameTextBox("Travel 01");
			travelPage.clickOnCONTINUEWButton();
			travelPage.isTravelDescriptionLabelVisible();
			travelPage.istravelUserLabelVisible();
			travelPage.istravelNameLabelVisible();
			travelPage.istravelTimeFieldDurationVisible();
			travelPage.istravelRunIconButtonVisible();
			travelPage.istravelDeleteButtonVisible();
			travelPage.GetTravelTimeDuration("00:00:00");
			travelPage.clickOnRunIconOnTravelDescriptionPage();
			Thread.sleep(15000);
			travelPage.clickOnStopIconOnTravelDescriptionPage();
			travelPage.GetTravelTimeDuration("00:00:15");
			travelPage.clickOnTravelDeleteButton();
			Thread.sleep(5000);
			travelPage.clickOnNewTravelButton();
			travelPage.enterTravelNameTextBox("Travel 01");
			travelPage.clickOnCONTINUEWButton();
			travelPage.enterTravelDistanceTextBox("20");
			travelPage.GetTravelTimeDuration("00:00:00");
			travelPage.clickOnRunIconOnTravelDescriptionPage();
			Thread.sleep(10000);
			travelPage.clickOnStopIconOnTravelDescriptionPage();
			travelPage.GetTravelTimeDuration("00:00:11");
			travelPage.clickOnRunIconOnTravelDescriptionPage();
			Thread.sleep(5000);
			travelPage.clickOnStopIconOnTravelDescriptionPage();
			travelPage.GetTravelTimeDuration("00:00:20");
			jobCardPage.clickOnMenuButton();
			jobCardPage.clickOnchecklistMenuOption();
			Thread.sleep(10000);
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
			mileageTachoPage.enterCustomerNameTextBox("Customer VALID");
			mileageTachoPage.enterSignatureTextBox();
			mileageTachoPage.turnOnTermConditionRadioButton("Android");
			Thread.sleep(5000);
			mileageTachoPage.clickOnSubmitBtnOnClientSignature();
			Thread.sleep(30000);	
			jobCardPage.SelectReceivedAppointment(CustomerName,"Android");
			jobCardPage.clickOnMenuButton();
			travelPage.clickOnTravelMenuButton();
			travelPage.clickOnNewTravelButton();
			travelPage.isTravelDescriptionLabelVisible();
			travelPage.istravelUserLabelVisible();
		    aMob.AssertEquals(travelPage.getTravelNameFromTravelDescriptionPage("Android"), "Travel 01",
					"The expected Media description Value Is Same As Actual i.e. " + travelPage.getTravelNameFromTravelDescriptionPage("Android"));
		    aMob.AssertEquals(travelPage.getTravelDistanceFromTravelDescriptionPage("Android"), "20",
					"The expected Media description Value Is Same As Actual i.e. " + travelPage.getTravelDistanceFromTravelDescriptionPage("Android"));
					Thread.sleep(5000);
		}


		@AfterMethod(alwaysRun = true)
		public void afterMethod() {
			System.out.println("Test");
			// driver.quit();
		}
	}

}
