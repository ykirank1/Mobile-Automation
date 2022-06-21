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

public class TC15_BreakdownRepairAddNewOperationDuringTheRepair extends BaseTest {
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
		public void TC15_BreakdownRepairAddNewOperationDuringTheRepair() throws Exception {
			loginPage.loginToApplication("W90041D", "Saize9046");
			homePage.clickOnJobCardOption();
			//String CustomerName="Customer VALID2022/05/23 11:39:51";
			jobCardPage.clickOnCreateButton();
			jobCardPage.clickOnBreakdownOrRemoteAppointmentCheckBox();
			String CustomerName = "Customer VALID" + genericPage.getCurrentDate("yyyy/MM/dd HH:mm:ss");
			jobCardPage.enterCustomerNameOnCustomerNameTextBox(CustomerName, device);
			jobCardPage.enterEmailOnCustomerEmailTextBox("customer.valid@cnhi.com");
			jobCardPage.enterPhoneNoOnCustomerPhoneTextBox("0634353637");
			jobCardPage.enterContactNoOnContactPhoneTextBox("06303711111");
			jobCardPage.enterBrandOnBrandTextBox("IVECO");
			jobCardPage.enterModelOnModelNameTextBox("40C15", device);
			jobCardPage.enterNumberOnPlateNumberTextBox("W 56923 D", device);
			jobCardPage.enterMileageOnMileageTextBox("300000", device);
			jobCardPage.enterSerialNumberOnSerialNumberTextBox("ZCFC140A705995964");
			Thread.sleep(3000);
			jobCardPage.enterComplainsOnCustomerComplainsTextBox("Oil");
			jobCardPage.enterAddressOnRepairAddressTextBox("Valid Office, Rue de Marhum, 64100 BAYONNE");
			//jobCardPage.selectCheckListOption("Reception Checklist");
			jobCardPage.selectCheckListOption("Reception");
			jobCardPage.clickOnNextStepButton();
			jobCardPage.enterActivityOnActivityTextBox("Brake Repair");
			jobCardPage.clickOnAddButton();
			aMob.AssertTrue(jobCardPage.isToExecuteStatusVisible(), "To Execute Status is Visible");
			jobCardPage.clickOnArrowButton();
			jobCardPage.enterDefectCodeOnActivityTextBox("535361 - CLUTCH BLOCKING PISTON");
			jobCardPage.selectFailureOptionFromFailureDropDown("001 - DEFECT", "Android");
			jobCardPage.selectFailureSeverityRateFromFailureSeverityRateDropDown("2 - Severe", "Android");
			jobCardPage.selectPaymentTypeFromPaymentTypeDropDown("Cliente", "Android");
			jobCardPage.selectPaymentSubTypeFromPaymentTypeDropDown("a carico cliente", "Android");
			jobCardPage.clickOnAddNewOperationBtn("Android");
			jobCardPage.enterOperationNameTextBox("78 47 13 102 - R-I 1 FITTING FOR REAR BRAKES HYDRAULIC PRESSURE CONTROL", device);
			jobCardPage.clickOnSaveButton();
//			aMob.AssertTrue(jobCardPage.isNewOperationCreated("OVERHAUL SECOND FRONT AXLE STABILIZER WITH UPPER ARTICULATED JOINT"),
//					"New Operation Added Successfully");
			jobCardPage.clickOnSaveButton();
			Thread.sleep(5000);
			String appointmentData = jobCardPage.getCreatedAppointmentData(CustomerName, "Android");

			aMob.AssertTrue(appointmentData.contains(CustomerName),
					"Customer Name Visible In the List Of New Created Appointment");
			aMob.AssertTrue(appointmentData.contains("40C15"),
					"Model Name Visible In the First Of New Created Appointment");
			aMob.AssertTrue(appointmentData.contains("40C15"),
					"Model Name Visible In the First Of New Created Appointment");
			aMob.AssertTrue(appointmentData.contains("W 56923 D"),
					"Plate Number Visible In the First Of New Created Appointment");
			jobCardPage.SelectCreatedAppointment(CustomerName, device);

			aMob.AssertTrue(jobCardPage.isUnassignedActivitiesPopupVisible(),
					"Message Unassigned Activities For Breakdown is Visible");
			jobCardPage.clickOnYesButton();
			aMob.AssertTrue(jobCardPage.isAppointmentInfoLabelVisible(), "Appointment Info Label is Visible");
	
			aMob.AssertTrue(CustomerName.contains(jobCardPage.getCustomerInfoFromAppointmentInfo(device)),
					"Customer Name from Appointment Screen i.e. " + jobCardPage.getCustomerInfoFromAppointmentInfo(device)
							+ " is same as Expected");

			aMob.AssertEquals(jobCardPage.getModelInfoFromAppointmentInfo(device), "40C15",
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
	;
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
		
			jobCardPage.SelectReceivedAppointment(CustomerName, "Android");	
			aMob.AssertTrue(jobCardPage.isToExecuteStatusVisible(), "To Execute Status is Visible");
			jobCardPage.clickOnArrowButton();
			jobCardPage.clickOnAddNewOperationBtn("Android");
			jobCardPage.enterOperationNameTextBox("79 41 01 100 - R-I POWER BRAKE", device);
			jobCardPage.clickOnSaveButton();
			jobCardPage.clickOnMenuButton();
			jobCardPage.clickOnchecklistMenuOption();
			
			
			jobCardPage.clickOnMenuButton();
			jobCardPage.clickOnTaskMenuOption();
			aMob.AssertTrue(taskPage.isbrakeRepairActivityOperation1LabelVisible(), "Newly Created Operation 1 is Visible");
			aMob.AssertTrue(taskPage.isbrakeRepairActivityOperation2LabelVisible(), "Newly Created Operation 2 is Visible");
		
//			aMob.AssertEquals(taskPage.getStatusOfClutchRepairActivityText().trim(), "ToDo",
//					"Clutch Repair text from Task Screen i.e. " + taskPage.getStatusOfClutchRepairActivityText()
//							+ " is same as Expected");
//			
//			aMob.AssertEquals(taskPage.getStatusOfOilControlActivityText().trim(), "ToDo",
//					"Oil Control Activity text from Task Screen i.e. " + taskPage.getStatusOfOilControlActivityText()
//							+ " is same as Expected");
			
		}
		@AfterMethod(alwaysRun = true)
		public void afterMethod() {
			System.out.println("Test");
			// driver.quit();
		}
	}

}


