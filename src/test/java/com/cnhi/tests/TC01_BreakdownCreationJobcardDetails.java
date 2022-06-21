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
import com.cnhi.pageObjects.VehicleDetailPage;

public class TC01_BreakdownCreationJobcardDetails extends BaseTest {
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
			aMob = new Assertion();
			// driver.launchApp();

		}

		@Test(description = "T90-02-04-08-01 CV - Breakdown - Creation - Jobcard details")
		public void BreakdownCreationJobcardDetails() throws Exception {
			loginPage.loginToApplication("W90041D", "Saize9046");
			homePage.clickOnJobCardOption();
			jobCardPage.clickOnCreateButton();
			jobCardPage.clickOnBreakdownOrRemoteAppointmentCheckBox();
//			//Making Random Customer Name
			String CustomerName="FELBERMATR TRANSPORT- UND"+genericPage.getCurrentDate("yyyy/MM/dd HH:mm:ss");
//			String CustomerName="FELBERMATR TRANSPORT- UND2022/04/06 11:13:41";
			jobCardPage.enterCustomerNameOnCustomerNameTextBox(CustomerName, device);
			jobCardPage.enterEmailOnCustomerEmailTextBox("valid@jobcard.com");
			jobCardPage.enterPhoneNoOnCustomerPhoneTextBox("123456789");
			jobCardPage.enterContactNoOnContactPhoneTextBox("123456789");
			//jobCardPage.enterFiscalOnFiscalInformationTextBox("987654321");
			jobCardPage.enterBrandOnBrandTextBox("IVECO");
			jobCardPage.enterModelOnModelNameTextBox("35S16V",device);
			jobCardPage.enterNumberOnPlateNumberTextBox("BL688CV",device);
			// Thread.sleep(20000);
			jobCardPage.enterMileageOnMileageTextBox("5000",device);
			jobCardPage.enterSerialNumberOnSerialNumberTextBox("ZCFC135B205130749");
			Thread.sleep(4000);
			jobCardPage.enterComplainsOnCustomerComplainsTextBox("Issue on");
			Thread.sleep(2000);
			jobCardPage.enterAddressOnRepairAddressTextBox("HEBETECHNIK GMBH & CO KG AUPOINT 45101 BERGHEIM");
			jobCardPage.navigatingToCustomerNameTextBox();
			jobCardPage.enterCustomerNameOnCustomerNameTextBox(CustomerName, device);
			jobCardPage.enterEmailOnCustomerEmailTextBox("valid@jobcard.com");
			jobCardPage.enterPhoneNoOnCustomerPhoneTextBox("123456789");
			jobCardPage.enterContactNoOnContactPhoneTextBox("123456789");
			jobCardPage.clickOnNextStepButton();
			jobCardPage.enterActivityOnActivityTextBox("Repair");
			jobCardPage.clickOnAddButton();
			aMob.AssertTrue(jobCardPage.isToExecuteStatusVisible(), "To Execute Ststus is Visible");
			jobCardPage.clickOnArrowButton();
			jobCardPage.enterDefectCodeOnActivityTextBox("542486 COMPRESSOR DRIVE BELT");
			jobCardPage.selectFailureOptionFromFailureDropDown("001 - DEFECT", device);
			jobCardPage.selectFailureSeverityRateFromFailureSeverityRateDropDown("2 - Severe", device);
			jobCardPage.selectPaymentTypeFromPaymentTypeDropDown("TEST Payment Type", device);
			jobCardPage.clickOnAddNewOperationBtn("Android");
			jobCardPage.enterOperationNameTextBox("55 59 10 100 - R-I SAFETY BELTS DRIVER SEAT", device);
			jobCardPage.clickOnPartsPlusIcon();
			jobCardPage.enterPartCodeOnPartCodeTextBox("54210956", device);
			jobCardPage.clickOnSaveButton();
//			aMob.AssertTrue(jobCardPage.isNewOperationCreated("R-I SAFETY BELTS DRIVER SEAT"),
//					"New Operation Added Successfully");
			jobCardPage.clickOnAddAnotherItemBtn();
			Thread.sleep(5000);
			jobCardPage.selectTypeFromTypeDropDown("Freight", device);
			jobCardPage.selectCodeFromCodeDropDown("C010 - SERVICE PROGRAM", device);
			jobCardPage.enterDescriptionOnDescriptionTextBox("SERVICE PROGRAM",device);
			jobCardPage.enterPriceOnPriceTextBox("135",device);
			jobCardPage.clickOnAddItemSaveBtn();
//			aMob.AssertTrue(jobCardPage.isNewTypeCreated("Freight"), "New Type Added Successfully");
			jobCardPage.clickOnSaveButton();
			Thread.sleep(10000);
			jobCardPage.SelectCreatedAppointment(CustomerName,device);
			aMob.AssertTrue(jobCardPage.isUnassignedActivitiesPopupVisible(),
					"Message Unassigned Activities For Breakdown is Visible");
			jobCardPage.clickOnYesButton();
			aMob.AssertTrue(jobCardPage.isAppointmentInfoLabelVisible(), "Appointment Info Label is Visible");
			aMob.AssertTrue(CustomerName.contains(jobCardPage.getCustomerInfoFromAppointmentInfo(device)),
					"Customer Name from Appointment Screen i.e. " + jobCardPage.getCustomerInfoFromAppointmentInfo(device)
							+ " is same as Expected");

			aMob.AssertEquals(jobCardPage.getModelInfoFromAppointmentInfo(device).trim(), "35S16V",
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
			jobCardPage.clickOnJobDetailMenuOption();

			aMob.AssertTrue(jobCardPage.isAppointmentInfoLabelVisible(), "Appointment Info Label is Visible");
			aMob.AssertTrue(CustomerName.contains(jobCardPage.getCustomerInfoFromAppointmentInfo(device)),
					"Customer Name from Appointment Screen i.e. " + jobCardPage.getCustomerInfoFromAppointmentInfo(device)
							+ " is same as Expected");

			aMob.AssertEquals(jobCardPage.getModelInfoFromAppointmentInfo(device).trim(), "35S16V",
					"Model Name From Appointment Screen i.e. " + jobCardPage.getModelInfoFromAppointmentInfo(device)
							+ " is same as Expected");

			aMob.AssertEquals(jobCardPage.getReceptionDateFromAppointmentInfo(device).trim(),
					genericPage.getCurrentDate("MMM dd, yyyy"),
					"Reception Date from Appointment Screen i.e. " + jobCardPage.getReceptionDateFromAppointmentInfo(device)
							+ " is same as Expected i.e. " + genericPage.getCurrentDate("MMM dd, yyyy"));

			aMob.AssertEquals(jobCardPage.getDeliveryDateFromAppointmentInfo(device).trim(),
					genericPage.getCurrentDate("MMM dd, yyyy"),
					"Delivery Date From Appointment Screen i.e. " + jobCardPage.getDeliveryDateFromAppointmentInfo(device)
							+ " is same as Expected i.e. " + genericPage.getCurrentDate("MMM dd, yyyy"));

			aMob.AssertTrue(jobCardPage.isContactDetailLabelVisible(), "Contact Detail Label is Visible");

			aMob.AssertEquals(jobCardPage.getCustomerEmailValueFromJobDetail(device).trim(), "valid@jobcard.com",
					"Customer Email From Job Detail Screen i.e. " + jobCardPage.getCustomerEmailValueFromJobDetail(device)
							+ " is same as Expected");

			aMob.AssertEquals(jobCardPage.getCustomerPhoneNoValueFromJobDetail(device).trim(), "123456789",
					"Customer Phone No From Job Detail Screen i.e. " + jobCardPage.getCustomerPhoneNoValueFromJobDetail(device)
							+ " is same as Expected");

			aMob.AssertEquals(jobCardPage.getContactPhoneNumberNoFromJobDetail(device).trim(), "123456789",
					"Contact Phone No From Job Detail Screen i.e. " + jobCardPage.getContactPhoneNumberNoFromJobDetail(device)
							+ " is same as Expected");

			aMob.AssertTrue(jobCardPage.isRepairAddressLabelVisible(), "Repair Address Label is Visible");

			aMob.AssertEquals(jobCardPage.getRepairAddressFromJobDetail(device).trim(),
					"HEBETECHNIK GMBH & CO KG AUPOINT 45101 BERGHEIM", "Repair Address From Job Detail Screen i.e. "
							+ jobCardPage.getRepairAddressFromJobDetail(device) + " is same as Expected");

/*			aMob.AssertTrue(jobCardPage.isCustomerComplainsLabelVisible(), "Customer Complain Label is Visible");

			aMob.AssertEquals(jobCardPage.getCustomerComplainEmailFromJobDetail(device).trim(), "Issue on",
					"Customer Complain From Job Detail Screen i.e. " + jobCardPage.getCustomerComplainEmailFromJobDetail(device)
							+ " is same as Expected");*/

		}


		@AfterMethod(alwaysRun = true)
		public void afterMethod() {
			System.out.println("Test");
			// driver.quit();
		}
	}

}
