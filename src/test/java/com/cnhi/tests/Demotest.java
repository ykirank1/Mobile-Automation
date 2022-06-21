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
import com.cnhi.pageObjects.GenericPage;
import com.cnhi.pageObjects.HomePage;
import com.cnhi.pageObjects.JobCardPage;
import com.cnhi.pageObjects.LoginPage;
import com.cnhi.pageObjects.MileageTachoPage;
import com.cnhi.pageObjects.VehicleDetailPage;

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

//	@Test(description = "T90-02-04-08-01 CV - Breakdown - Creation - Jobcard details")
//	public void BreakdownCreationJobcardDetailsTest() throws Exception {
//		loginPage.loginToApplication("W90041D", "Saize9044");
//		homePage.clickOnJobCardOption();
//		jobCardPage.clickOnCreateButton();
//		jobCardPage.clickOnBreakdownOrRemoteAppointmentCheckBox();
//		jobCardPage.enterCustomerNameOnCustomerNameTextBox("FELBERMATR TRANSPORT- UND", device);
//		jobCardPage.enterEmailOnCustomerEmailTextBox("valid@jobcard.com");
//		jobCardPage.enterPhoneNoOnCustomerPhoneTextBox("123456789");
//		jobCardPage.enterContactNoOnContactPhoneTextBox("123456789");
//		// jobCardPage.enterFiscalOnFiscalInformationTextBox("987654321");
//		jobCardPage.enterBrandOnBrandTextBox("IVECO");
//		jobCardPage.enterModelOnModelNameTextBox("35S16V");
//		jobCardPage.enterNumberOnPlateNumberTextBox("BL688CV");
//		// Thread.sleep(20000);
//		jobCardPage.enterMileageOnMileageTextBox("5000", device);
//		jobCardPage.enterSerialNumberOnSerialNumberTextBox("ZCFC135B205130749");
//		Thread.sleep(3000);
//		jobCardPage.enterComplainsOnCustomerComplainsTextBox("Issue on");
//		jobCardPage.enterAddressOnRepairAddressTextBox("HEBETECHNIK GMBH & CO KG AUPOINT 45101 BERGHEIM");
//
//		jobCardPage.clickOnNextStepButton();
//		jobCardPage.enterActivityOnActivityTextBox("Repair");
//		jobCardPage.clickOnAddButton();
//		aMob.AssertTrue(jobCardPage.isToExecuteStatusVisible(), "To Execute Ststus is Visible");
//		jobCardPage.clickOnArrowButton();
//		jobCardPage.enterDefectCodeOnActivityTextBox("542486 COMPRESSOR DRIVE BELT");
//		jobCardPage.selectFailureOptionFromFailureDropDown("001 - DEFECT", device);
//		jobCardPage.selectFailureSeverityRateFromFailureSeverityRateDropDown("2 - Severe", device);
//		jobCardPage.selectPaymentTypeFromPaymentTypeDropDown("TEST Payment Type", device);
//		jobCardPage.clickOnAddNewOperationBtn();
//		jobCardPage.enterOperationNameTextBox("55 59 10 100 - R-I SAFETY BELTS DRIVER SEAT", device);
//		jobCardPage.clickOnPartsPlusIcon();
//		jobCardPage.enterPartCodeOnPartCodeTextBox("54210956", device);
//		jobCardPage.clickOnSaveButton();
//		aMob.AssertTrue(jobCardPage.isNewOperationCreated("R-I SAFETY BELTS DRIVER SEAT"),
//				"New Operation Added Successfully");
//		jobCardPage.clickOnAddAnotherItemBtn();
//		jobCardPage.selectTypeFromTypeDropDown("Freight", device);
//		jobCardPage.selectCodeFromCodeDropDown("C010 - SERVICE PROGRAM", device);
//		jobCardPage.enterDescriptionOnDescriptionTextBox("SERVICE PROGRAM",device);
//		jobCardPage.enterPriceOnPriceTextBox("135",device);
//		jobCardPage.clickOnAddItemSaveBtn();
//		aMob.AssertTrue(jobCardPage.isNewTypeCreated("Freight"), "New Type Added Successfully");
//		jobCardPage.clickOnSaveButton();
//		jobCardPage.SelectCreatedAppointment(device);
//		aMob.AssertTrue(jobCardPage.isUnassignedActivitiesPopupVisible(),
//				"Message Unassigned Activities For Breakdown is Visible");
//		jobCardPage.clickOnYesButton();
//		aMob.AssertTrue(jobCardPage.isAppointmentInfoLabelVisible(), "Appointment Info Label is Visible");
//		aMob.AssertEquals(jobCardPage.getCustomerInfoFromAppointmentInfo(device), "FELBERMATR TRANSPORT- UND",
//				"Customer Name from Appointment Screen i.e. " + jobCardPage.getCustomerInfoFromAppointmentInfo(device)
//						+ " is same as Expected");
//
//		aMob.AssertEquals(jobCardPage.getModelInfoFromAppointmentInfo(device), "35S16V",
//				"Model Name from Appointment Screen i.e. " + jobCardPage.getModelInfoFromAppointmentInfo(device)
//						+ " is same as Expected");
//
//		aMob.AssertEquals(jobCardPage.getReceptionDateFromAppointmentInfo(device),
//				genericPage.getCurrentDate("MMM dd, yyyy"),
//				"Reception Date From Appointment Screen i.e. " + jobCardPage.getReceptionDateFromAppointmentInfo(device)
//						+ " is same as Expected i.e. " + genericPage.getCurrentDate("MMM dd, yyyy"));
//
//		aMob.AssertEquals(jobCardPage.getDeliveryDateFromAppointmentInfo(device),
//				genericPage.getCurrentDate("MMM dd, yyyy"),
//				"Delivery Date From Appointment Screen i.e. " + jobCardPage.getDeliveryDateFromAppointmentInfo(device)
//						+ " is same as Expected i.e. " + genericPage.getCurrentDate("MMM dd, yyyy"));
//
//		jobCardPage.clickOnMenuButton();
//		jobCardPage.clickOnJobDetailMenuOption();
//
//		aMob.AssertTrue(jobCardPage.isAppointmentInfoLabelVisible(), "Appointment Info Label is Visible");
//		aMob.AssertEquals(jobCardPage.getCustomerInfoFromAppointmentInfo(device), "FELBERMATR TRANSPORT- UND",
//				"Customer Name From Appointment Screen i.e. " + jobCardPage.getCustomerInfoFromAppointmentInfo(device)
//						+ " is same as Expected");
//
//		aMob.AssertEquals(jobCardPage.getModelInfoFromAppointmentInfo(device), "35S16V",
//				"Model Name From Appointment Screen i.e. " + jobCardPage.getModelInfoFromAppointmentInfo(device)
//						+ " is same as Expected");
//
//		aMob.AssertEquals(jobCardPage.getReceptionDateFromAppointmentInfo(device),
//				genericPage.getCurrentDate("MMM dd, yyyy"),
//				"Reception Date from Appointment Screen i.e. " + jobCardPage.getReceptionDateFromAppointmentInfo(device)
//						+ " is same as Expected i.e. " + genericPage.getCurrentDate("MMM dd, yyyy"));
//
//		aMob.AssertEquals(jobCardPage.getDeliveryDateFromAppointmentInfo(device),
//				genericPage.getCurrentDate("MMM dd, yyyy"),
//				"Delivery Date From Appointment Screen i.e. " + jobCardPage.getDeliveryDateFromAppointmentInfo(device)
//						+ " is same as Expected i.e. " + genericPage.getCurrentDate("MMM dd, yyyy"));
//
//		aMob.AssertTrue(jobCardPage.isContactDetailLabelVisible(), "Contact Detail Label is Visible");
//
//		aMob.AssertEquals(jobCardPage.getCustomerEmailValueFromJobDetail(device), "valid@jobcard.com",
//				"Customer Email From Job Detail Screen i.e. " + jobCardPage.getCustomerEmailValueFromJobDetail(device)
//						+ " is same as Expected");
//
//		aMob.AssertEquals(jobCardPage.getCustomerPhoneNoValueFromJobDetail(device), "123456789",
//				"Customer Phone No From Job Detail Screen i.e. " + jobCardPage.getCustomerPhoneNoValueFromJobDetail(device)
//						+ " is same as Expected");
//
//		aMob.AssertEquals(jobCardPage.getContactPhoneNumberNoFromJobDetail(device), "123456789",
//				"Contact Phone No From Job Detail Screen i.e. " + jobCardPage.getContactPhoneNumberNoFromJobDetail(device)
//						+ " is same as Expected");
//
//		aMob.AssertTrue(jobCardPage.isRepairAddressLabelVisible(), "Repair Address Label is Visible");
//
//		aMob.AssertEquals(jobCardPage.getRepairAddressFromJobDetail(device),
//				"HEBETECHNIK GMBH & CO KG AUPOINT 45101 BERGHEIM", "Repair Address From Job Detail Screen i.e. "
//						+ jobCardPage.getRepairAddressFromJobDetail(device) + " is same as Expected");
//
//		aMob.AssertTrue(jobCardPage.isCustomerComplainsLabelVisible(), "Customer Complain Label is Visible");
//
//		aMob.AssertEquals(jobCardPage.getCustomerComplainEmailFromJobDetail(device), "Issue on",
//				"Customer Complain From Job Detail Screen i.e. " + jobCardPage.getCustomerComplainEmailFromJobDetail(device)
//						+ " is same as Expected");
//
//	}

	@Test(description = "T90-02-04-08-02 CV - Breakdown - Creation - Vehicle details")
	public void BreakdownCreationVehicleDetailsTest1() throws Exception {
		loginPage.loginToApplication("W90041D", "Saize9044");
		homePage.clickOnJobCardOption();
		jobCardPage.clickOnCreateButton();
		jobCardPage.clickOnBreakdownOrRemoteAppointmentCheckBox();
		String CustomerName = "12 - VALID Customer" + genericPage.getCurrentDate("yyyy/MM/dd HH:mm:ss");
		jobCardPage.enterCustomerNameOnCustomerNameTextBox(CustomerName, device);
		jobCardPage.enterEmailOnCustomerEmailTextBox("valid@jobcard.com");
		jobCardPage.enterPhoneNoOnCustomerPhoneTextBox("123456789");
		jobCardPage.enterContactNoOnContactPhoneTextBox("123456789");

		jobCardPage.enterBrandOnBrandTextBox("IVECO");
		jobCardPage.enterModelOnModelNameTextBox("35S16V",device);
		jobCardPage.enterNumberOnPlateNumberTextBox("HA 100FZ",device);
		jobCardPage.enterMileageOnMileageTextBox("5000", device);
		jobCardPage.enterSerialNumberOnSerialNumberTextBox("ZCFC135B205304268");
		jobCardPage.enterComplainsOnCustomerComplainsTextBox("no longer starts");
		jobCardPage.enterAddressOnRepairAddressTextBox("Rue des Arènes 64100 BAYONNE");
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
		jobCardPage.selectFailureOptionFromFailureDropDown("007 - BLOCKAGE", device);
		jobCardPage.selectFailureSeverityRateFromFailureSeverityRateDropDown("2 - Severe", device);
		jobCardPage.selectPaymentTypeFromPaymentTypeDropDown("TEST Payment Type", device);
		jobCardPage.clickOnAddNewOperationBtn("Android");
		jobCardPage.enterOperationNameTextBox("76 91 30 100 - RENEW STARTER CABLE CONNECTI ON", device);
		jobCardPage.clickOnSaveButton();
		aMob.AssertTrue(jobCardPage.isNewOperationCreated("RENEW STARTER CABLE CONNECTI ON"),
				"New Operation Added Successfully");
		jobCardPage.clickOnSaveButton();
		jobCardPage.SelectCreatedAppointment(CustomerName, device);
		aMob.AssertTrue(jobCardPage.isUnassignedActivitiesPopupVisible(),
				"Message Unassigned Activities For Breakdown is Visible");
		jobCardPage.clickOnYesButton();
		aMob.AssertTrue(jobCardPage.isAppointmentInfoLabelVisible(), "Appointment Info Label is Visible");
		aMob.AssertTrue(CustomerName.contains(jobCardPage.getCustomerInfoFromAppointmentInfo(device)),
				"Customer Name from Appointment Screen i.e. " + jobCardPage.getCustomerInfoFromAppointmentInfo(device)
						+ " is same as Expected");
		aMob.AssertEquals(jobCardPage.getModelInfoFromAppointmentInfo(device), "35S16V",
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

		jobCardPage.clickOnMenuButton();
		jobCardPage.clickOnVehicleDetailMenuOption();
		vehicleDetailPage.clickVehicleDetailTab();
		aMob.AssertTrue(vehicleDetailPage.isVehicleDetailLabelVisible(), "Vehicle Detail Label is Visible");
		aMob.AssertTrue(!vehicleDetailPage.getFDPDescriptionInDealerLanguageValueFromJobDetail().equals(":"),
				"FDP Description In Dealer Language From Vehicle Detail Screen is not empty i.e. "
						+ vehicleDetailPage.getFDPDescriptionInDealerLanguageValueFromJobDetail());
		aMob.AssertTrue(!vehicleDetailPage.getModelDescriptionValueFromJobDetail().equals(":"),
				"ModelDescription From Vehicle Detail Screen is not empty i.e. "
						+ vehicleDetailPage.getModelDescriptionValueFromJobDetail());
		aMob.AssertTrue(!vehicleDetailPage.getBMValueFromJobDetail().equals(":"),
				"BM Value from Vehicle Detail Screen is not empty i.e. " + vehicleDetailPage.getBMValueFromJobDetail());
		aMob.AssertTrue(!vehicleDetailPage.getBMValueFromJobDetail().equals(":"),
				"FDP English Description From Vehicle Detail Screen is not empty i.e. "
						+ vehicleDetailPage.getfDPEnglishDescriptionValueFromJobDetail());
		aMob.AssertTrue(!vehicleDetailPage.getBMValueFromJobDetail().equals(":"),
				"FDP Code From Vehicle Detail Screen is not empty i.e. " + vehicleDetailPage.getBMValueFromJobDetail());
		aMob.AssertTrue(!vehicleDetailPage.getBMValueFromJobDetail().equals(":"),
				"Sold To Dealer Market From Vehicle Detail Screen is not empty i.e. "
						+ vehicleDetailPage.getBMValueFromJobDetail());
		aMob.AssertTrue(!vehicleDetailPage.getBMValueFromJobDetail().equals(":"),
				"Build Date From Vehicle Detail Screen is not empty i.e. "
						+ vehicleDetailPage.getBMValueFromJobDetail());
		aMob.AssertTrue(!vehicleDetailPage.getBMValueFromJobDetail().equals(":"),
				"Model Group Value From Vehicle Detail Screen is not empty i.e.  "
						+ vehicleDetailPage.getBMValueFromJobDetail());
		aMob.AssertTrue(!vehicleDetailPage.getBMValueFromJobDetail().equals(":"),
				"Production Plant Description From Vehicle Detail Screen is not empty i.e. "
						+ vehicleDetailPage.getBMValueFromJobDetail());

		vehicleDetailPage.clickSapEndCustomerTab();
		aMob.AssertTrue(vehicleDetailPage.isSAPEndCustomerLabelVisible(), "SAP End Customer Label Visible");
		aMob.AssertTrue(vehicleDetailPage.isEndCustomerCountryTextVisibleEmpty(),
				"End Customer Country Value From SAP End Customer Screen is Empty");
		aMob.AssertTrue(vehicleDetailPage.isEndCustomerNameTextVisibleEmpty(),
				"End Customer Name Value From SAP End Customer Screen is Empty");
		aMob.AssertTrue(vehicleDetailPage.isEndCustomerCityTextVisibleEmpty(),
				"End Customer City Value From SAP End Customer Screen is Empty");

		vehicleDetailPage.clickGroupSerialNumberTab("Android");
		aMob.AssertTrue(vehicleDetailPage.isGroupSerialNumberLabelVisible(), "Group Serial Number Label Visible");
		aMob.AssertTrue(vehicleDetailPage.isDescriptionLabelVisible(), "Description Label Visible");
		aMob.AssertTrue(vehicleDetailPage.isSerialLabelVisible(), "Serial Label Visible");
		aMob.AssertTrue(vehicleDetailPage.isChassisLabelVisible(), "Chassis Label Visible");
		aMob.AssertTrue(vehicleDetailPage.isEngineLabelVisible(), "Engine Label Visible");
		aMob.AssertTrue(vehicleDetailPage.isGearLabelVisible(), "Gear Label Visible");
		aMob.AssertTrue(vehicleDetailPage.isFirstAxleLabelVisible(), "First Axle Label Visible");
		aMob.AssertTrue(vehicleDetailPage.isRearAxleLabelVisible(), "Rear Axle Label Visible");
		aMob.AssertTrue(vehicleDetailPage.isCabinaVerniciataLabelVisible(), "Cabina Verniciata Label Visible");

		vehicleDetailPage.clickSapRepairHistoryTab("Android");
		aMob.AssertTrue(vehicleDetailPage.isSapRepairHistoryLabelVisible(), "Repair History Label Visible");
		aMob.AssertTrue(vehicleDetailPage.isSapRepairHistorySearchTextBoxVisible(), "Repair History Text Box Visible");
		aMob.AssertTrue(vehicleDetailPage.isDefectDescriptionLabelVisible(), "Defect Description Label Visible");
		aMob.AssertTrue(vehicleDetailPage.isDefectDescriptionBlockageWithShowDetailsLabelVisible(),
				"Defect Description Blockage With Show Detail Label Visible");

		vehicleDetailPage.clickDefectDescriptionBlockageWithShowDetail();
		Log.info("123456");
		Log.info(vehicleDetailPage.getClaimRepairEndDateData());
		aMob.AssertTrue(!vehicleDetailPage.getClaimRepairEndDateData().equals(":"),
				"Claim Date Repair End Date Value From Vehicle Detail Screen is not empty i.e. "
						+ vehicleDetailPage.getClaimRepairEndDateData());
		aMob.AssertTrue(!vehicleDetailPage.getClaimRepairEndDateData().equals(":"),
				"Claim Date Repair End Date Value From Vehicle Detail Screen is not empty i.e. "
						+ vehicleDetailPage.getClaimRepairEndDateData());
		aMob.AssertTrue(!vehicleDetailPage.getadefectCodeData().equals(":"),
				"Defect Code Value From Vehicle Detail Screen is not empty i.e. "
						+ vehicleDetailPage.getadefectCodeData());
		aMob.AssertTrue(!vehicleDetailPage.getMileageKMtData().equals(":"),
				"Mileage Value From Vehicle Detail Screen is not empty i.e. " + vehicleDetailPage.getMileageKMtData());
		aMob.AssertTrue(!vehicleDetailPage.getWarrantyTypeData().equals(":"),
				"Warranty Type From Vehicle Detail Screen is not empty i.e. "
						+ vehicleDetailPage.getWarrantyTypeData());
		aMob.AssertTrue(!vehicleDetailPage.getWorkshopDescriptionData().equals(":"),
				"Work Shop Description From Vehicle Detail Screen is not empty  i.e. "
						+ vehicleDetailPage.getWorkshopDescriptionData());
		aMob.AssertTrue(!vehicleDetailPage.getStatusData().equals(":"),
				"Status From Vehicle Detail Screen is not empty i.e. " + vehicleDetailPage.getStatusData());

		vehicleDetailPage.clickWarrantyServicesTab("Android");
		aMob.AssertTrue(vehicleDetailPage.isActiveWarrantyServicesLabelVisible(), "Warranty Services Label Visible");
		aMob.AssertTrue(vehicleDetailPage.isPlannedWarrantyServicesLabelVisible(),
				"Planned Warranty Services Label Visible");
		aMob.AssertTrue(vehicleDetailPage.isExpiredWarrantyServicesLabelVisible(),
				"Expired Warranty Services Label Visible");
		aMob.AssertTrue(vehicleDetailPage.isNoDataLabelVisible(), "No Data Label Visible");
		aMob.AssertTrue(vehicleDetailPage.isExtraPDIShowVisible(), "Extra PDI Visible");
		vehicleDetailPage.clickExtraPDIShowDetail();
		aMob.AssertTrue(!vehicleDetailPage.getServiceNumberDetail().equals(":"),
				"Service Number Detail From Warranty Services Screen is not empty i.e. "
						+ vehicleDetailPage.getServiceNumberDetail());
		aMob.AssertTrue(!vehicleDetailPage.getwarrantyTypeDetail().equals(":"),
				"Warranty Type From Warranty Services Screen is not empty i.e. "
						+ vehicleDetailPage.getwarrantyTypeDetail());
		aMob.AssertTrue(!vehicleDetailPage.getDurationDetail().equals(":"),
				"Duration From Warranty Services Screen is not empty i.e. " + vehicleDetailPage.getDurationDetail());
		aMob.AssertTrue(!vehicleDetailPage.getStartDetail().equals(":"),
				"Start Detail From Warranty Services Screen is not empty i.e. " + vehicleDetailPage.getStartDetail());
		aMob.AssertTrue(!vehicleDetailPage.getEndDetail().equals(":"),
				"End Detail From Warranty Services Screen is not empty i.e. " + vehicleDetailPage.getEndDetail());
		aMob.AssertTrue(!vehicleDetailPage.getMileageDetail().equals(":"),
				"Mileage From Warranty Services Screen is not empty i.e. " + vehicleDetailPage.getMileageDetail());
		aMob.AssertTrue(vehicleDetailPage.getContractDetail().equals(":"),
				"Contract From Warranty Services Screen is not empty i.e. " + vehicleDetailPage.getContractDetail());
		aMob.AssertTrue(vehicleDetailPage.isPdiPreDeliveryInspectionLabelVisible(),
				"PDI Pre Delivery Inspection Visible");
		aMob.AssertTrue(vehicleDetailPage.isExtraDlLabelVisible(), "Extra DL Visible");
		aMob.AssertTrue(vehicleDetailPage.isTechnicalWarrantyLabelVisible(), "Technical Warranty Visible");
		aMob.AssertTrue(vehicleDetailPage.isDriveLineLabelVisible(), "Drive Line Visible");
		aMob.AssertTrue(vehicleDetailPage.isAns24HLabelVisible(), "Ans 24 H Visible");

		vehicleDetailPage.clickJobCardHistoryTab("Android");
		aMob.AssertTrue(vehicleDetailPage.isSummaryScreenTabVisible(), "Summary Screen Visible");
		aMob.AssertTrue(vehicleDetailPage.isDetailsScreenTabVisible(), "Detail Screen Visible");
		aMob.AssertTrue(vehicleDetailPage.isDeliveryDateLabelVisible(), "Delivery Date Visible");
		aMob.AssertTrue(vehicleDetailPage.isbookingIdLabelVisible(), "Booking ID Visible");
	}

//	@Test(description = "T90-02-04-08-02 CV - Breakdown - Creation - Vehicle details")
//	public void BreakdownCreationVehicleDetailsTest() throws Exception {
//		loginPage.loginToApplication("W90041D", "Saize9044");
//		homePage.clickOnJobCardOption();
//		jobCardPage.clickOnCreateButton();
//		jobCardPage.clickOnBreakdownOrRemoteAppointmentCheckBox();
//		jobCardPage.enterCustomerNameOnCustomerNameTextBox("12 - VALID Customer (64100)", device);
//		jobCardPage.enterBrandOnBrandTextBox("IVECO");
//		jobCardPage.enterModelOnModelNameTextBox("35S16V");
//		jobCardPage.enterNumberOnPlateNumberTextBox("HA 100FZ");
//		jobCardPage.enterMileageOnMileageTextBox("5000");
//		jobCardPage.enterSerialNumberOnSerialNumberTextBox("ZCFC135B205304268");
//		jobCardPage.enterComplainsOnCustomerComplainsTextBox("no longer starts");
//		jobCardPage.enterAddressOnRepairAddressTextBox("Rue des Arènes 64100 BAYONNE");
//		jobCardPage.clickOnNextStepButton();
//		jobCardPage.enterActivityOnActivityTextBox("Repair");
//		jobCardPage.clickOnAddButton();
//		aMob.AssertTrue(jobCardPage.isToExecuteStatusVisible(), "To Execute Ststus is Visible");
//		jobCardPage.clickOnArrowButton();
//		jobCardPage.enterDefectCodeOnActivityTextBox("542486 COMPRESSOR DRIVE BELT");
//		jobCardPage.selectFailureOptionFromFailureDropDown("007 - BLOCKAGE", device);
//		jobCardPage.selectFailureSeverityRateFromFailureSeverityRateDropDown("2 - Severe", device);
//		jobCardPage.selectPaymentTypeFromPaymentTypeDropDown("TEST Payment Type", device);
//		jobCardPage.clickOnAddNewOperationBtn();
//		jobCardPage.enterOperationNameTextBox("76 91 30 100 - RENEW STARTER CABLE CONNECTI ON", device);
//		jobCardPage.clickOnSaveButton();
//		aMob.AssertTrue(jobCardPage.isNewOperationCreated("RENEW STARTER CABLE CONNECTI ON"),
//				"New Operation Added Successfully");
//		jobCardPage.clickOnSaveButton();
//		jobCardPage.SelectCreatedAppointment(device);
//		aMob.AssertTrue(jobCardPage.isUnassignedActivitiesPopupVisible(),
//				"Message Unassigned Activities For Breakdown is Visible");
//		jobCardPage.clickOnYesButton();
//		aMob.AssertTrue(jobCardPage.isAppointmentInfoLabelVisible(), "Appointment Info Label is Visible");
//		aMob.AssertEquals(jobCardPage.getCustomerInfoFromAppointmentInfo(device), "12 - VALID Customer (64100)",
//				"Customer Name from Appointment Screen i.e. " + jobCardPage.getCustomerInfoFromAppointmentInfo(device)
//						+ " is same as Expected");
//		aMob.AssertEquals(jobCardPage.getModelInfoFromAppointmentInfo(device), "35S16V",
//				"Model Name from Appointment Screen i.e. " + jobCardPage.getModelInfoFromAppointmentInfo(device)
//						+ " is same as Expected");
//		aMob.AssertEquals(jobCardPage.getReceptionDateFromAppointmentInfo(device),
//				genericPage.getCurrentDate("MMM dd, yyyy"),
//				"Reception Date From Appointment Screen i.e. " + jobCardPage.getReceptionDateFromAppointmentInfo(device)
//						+ " is same as Expected i.e. " + genericPage.getCurrentDate("MMM dd, yyyy"));
//		aMob.AssertEquals(jobCardPage.getDeliveryDateFromAppointmentInfo(device),
//				genericPage.getCurrentDate("MMM dd, yyyy"),
//				"Delivery Date From Appointment Screen i.e. " + jobCardPage.getDeliveryDateFromAppointmentInfo(device)
//						+ " is same as Expected i.e. " + genericPage.getCurrentDate("MMM dd, yyyy"));
//
//		jobCardPage.clickOnMenuButton();
//		jobCardPage.clickOnVehicleDetailMenuOption();
//		vehicleDetailPage.clickVehicleDetailTab();
//		aMob.AssertTrue(vehicleDetailPage.isVehicleDetailLabelVisible(), "Vehicle Detail Label is Visible");
//		aMob.AssertTrue(!vehicleDetailPage.getFDPDescriptionInDealerLanguageValueFromJobDetail().equals(":"),
//				"FDP Description In Dealer Language From Vehicle Detail Screen is not empty i.e. "
//						+ vehicleDetailPage.getFDPDescriptionInDealerLanguageValueFromJobDetail());
//		aMob.AssertTrue(!vehicleDetailPage.getModelDescriptionValueFromJobDetail().equals(":"),
//				"ModelDescription From Vehicle Detail Screen is not empty i.e. "
//						+ vehicleDetailPage.getModelDescriptionValueFromJobDetail());
//		aMob.AssertTrue(!vehicleDetailPage.getBMValueFromJobDetail().equals(":"),
//				"BM Value from Vehicle Detail Screen is not empty i.e. " + vehicleDetailPage.getBMValueFromJobDetail());
//		aMob.AssertTrue(!vehicleDetailPage.getBMValueFromJobDetail().equals(":"),
//				"FDP English Description From Vehicle Detail Screen is not empty i.e. "
//						+ vehicleDetailPage.getfDPEnglishDescriptionValueFromJobDetail());
//		aMob.AssertTrue(!vehicleDetailPage.getBMValueFromJobDetail().equals(":"),
//				"FDP Code From Vehicle Detail Screen is not empty i.e. " + vehicleDetailPage.getBMValueFromJobDetail());
//		aMob.AssertTrue(!vehicleDetailPage.getBMValueFromJobDetail().equals(":"),
//				"Sold To Dealer Market From Vehicle Detail Screen is not empty i.e. "
//						+ vehicleDetailPage.getBMValueFromJobDetail());
//		aMob.AssertTrue(!vehicleDetailPage.getBMValueFromJobDetail().equals(":"),
//				"Build Date From Vehicle Detail Screen is not empty i.e. "
//						+ vehicleDetailPage.getBMValueFromJobDetail());
//		aMob.AssertTrue(!vehicleDetailPage.getBMValueFromJobDetail().equals(":"),
//				"Model Group Value From Vehicle Detail Screen is not empty i.e.  "
//						+ vehicleDetailPage.getBMValueFromJobDetail());
//		aMob.AssertTrue(!vehicleDetailPage.getBMValueFromJobDetail().equals(":"),
//				"Production Plant Description From Vehicle Detail Screen is not empty i.e. "
//						+ vehicleDetailPage.getBMValueFromJobDetail());
//
//		vehicleDetailPage.clickSapEndCustomerTab();
//		aMob.AssertTrue(vehicleDetailPage.isSAPEndCustomerLabelVisible(), "SAP End Customer Label Visible");
//		aMob.AssertTrue(vehicleDetailPage.isEndCustomerCountryTextVisibleEmpty(),
//				"End Customer Country Value From SAP End Customer Screen is Empty");
//		aMob.AssertTrue(vehicleDetailPage.isEndCustomerNameTextVisibleEmpty(),
//				"End Customer Name Value From SAP End Customer Screen is Empty");
//		aMob.AssertTrue(vehicleDetailPage.isEndCustomerCityTextVisibleEmpty(),
//				"End Customer City Value From SAP End Customer Screen is Empty");
//
//		vehicleDetailPage.clickGroupSerialNumberTab();
//		aMob.AssertTrue(vehicleDetailPage.isGroupSerialNumberLabelVisible(), "Group Serial Number Label Visible");
//		aMob.AssertTrue(vehicleDetailPage.isDescriptionLabelVisible(), "Description Label Visible");
//		aMob.AssertTrue(vehicleDetailPage.isSerialLabelVisible(), "Serial Label Visible");
//		aMob.AssertTrue(vehicleDetailPage.isChassisLabelVisible(), "Chassis Label Visible");
//		aMob.AssertTrue(vehicleDetailPage.isEngineLabelVisible(), "Engine Label Visible");
//		aMob.AssertTrue(vehicleDetailPage.isGearLabelVisible(), "Gear Label Visible");
//		aMob.AssertTrue(vehicleDetailPage.isFirstAxleLabelVisible(), "First Axle Label Visible");
//		aMob.AssertTrue(vehicleDetailPage.isRearAxleLabelVisible(), "Rear Axle Label Visible");
//		aMob.AssertTrue(vehicleDetailPage.isCabinaVerniciataLabelVisible(), "Cabina Verniciata Label Visible");
//
//		vehicleDetailPage.clickSapRepairHistoryTab();
//		aMob.AssertTrue(vehicleDetailPage.isSapRepairHistoryLabelVisible(), "Repair History Label Visible");
//		aMob.AssertTrue(vehicleDetailPage.isSapRepairHistorySearchTextBoxVisible(), "Repair History Text Box Visible");
//		aMob.AssertTrue(vehicleDetailPage.isDefectDescriptionLabelVisible(), "Defect Description Label Visible");
//		aMob.AssertTrue(vehicleDetailPage.isDefectDescriptionBlockageWithShowDetailsLabelVisible(),
//				"Defect Description Blockage With Show Detail Label Visible");
//
//		vehicleDetailPage.clickDefectDescriptionBlockageWithShowDetail();
//		Log.info("123456");
//		Log.info(vehicleDetailPage.getClaimRepairEndDateData());
//		aMob.AssertTrue(!vehicleDetailPage.getClaimRepairEndDateData().equals(":"),
//				"Claim Date Repair End Date Value From Vehicle Detail Screen is not empty i.e. "
//						+ vehicleDetailPage.getClaimRepairEndDateData());
//		aMob.AssertTrue(!vehicleDetailPage.getClaimRepairEndDateData().equals(":"),
//				"Claim Date Repair End Date Value From Vehicle Detail Screen is not empty i.e. "
//						+ vehicleDetailPage.getClaimRepairEndDateData());
//		aMob.AssertTrue(!vehicleDetailPage.getadefectCodeData().equals(":"),
//				"Defect Code Value From Vehicle Detail Screen is not empty i.e. "
//						+ vehicleDetailPage.getadefectCodeData());
//		aMob.AssertTrue(!vehicleDetailPage.getMileageKMtData().equals(":"),
//				"Mileage Value From Vehicle Detail Screen is not empty i.e. " + vehicleDetailPage.getMileageKMtData());
//		aMob.AssertTrue(!vehicleDetailPage.getWarrantyTypeData().equals(":"),
//				"Warranty Type From Vehicle Detail Screen is not empty i.e. "
//						+ vehicleDetailPage.getWarrantyTypeData());
//		aMob.AssertTrue(!vehicleDetailPage.getWorkshopDescriptionData().equals(":"),
//				"Work Shop Description From Vehicle Detail Screen is not empty  i.e. "
//						+ vehicleDetailPage.getWorkshopDescriptionData());
//		aMob.AssertTrue(!vehicleDetailPage.getStatusData().equals(":"),
//				"Status From Vehicle Detail Screen is not empty i.e. " + vehicleDetailPage.getStatusData());
//
//		vehicleDetailPage.clickWarrantyServicesTab();
//		aMob.AssertTrue(vehicleDetailPage.isActiveWarrantyServicesLabelVisible(), "Warranty Services Label Visible");
//		aMob.AssertTrue(vehicleDetailPage.isPlannedWarrantyServicesLabelVisible(),
//				"Planned Warranty Services Label Visible");
//		aMob.AssertTrue(vehicleDetailPage.isExpiredWarrantyServicesLabelVisible(),
//				"Expired Warranty Services Label Visible");
//		aMob.AssertTrue(vehicleDetailPage.isNoDataLabelVisible(), "No Data Label Visible");
//		aMob.AssertTrue(vehicleDetailPage.isExtraPDIShowVisible(), "Extra PDI Visible");
//		vehicleDetailPage.clickExtraPDIShowDetail();
//		aMob.AssertTrue(!vehicleDetailPage.getServiceNumberDetail().equals(":"),
//				"Service Number Detail From Warranty Services Screen is not empty i.e. "
//						+ vehicleDetailPage.getServiceNumberDetail());
//		aMob.AssertTrue(!vehicleDetailPage.getwarrantyTypeDetail().equals(":"),
//				"Warranty Type From Warranty Services Screen is not empty i.e. "
//						+ vehicleDetailPage.getwarrantyTypeDetail());
//		aMob.AssertTrue(!vehicleDetailPage.getDurationDetail().equals(":"),
//				"Duration From Warranty Services Screen is not empty i.e. " + vehicleDetailPage.getDurationDetail());
//		aMob.AssertTrue(!vehicleDetailPage.getStartDetail().equals(":"),
//				"Start Detail From Warranty Services Screen is not empty i.e. " + vehicleDetailPage.getStartDetail());
//		aMob.AssertTrue(!vehicleDetailPage.getEndDetail().equals(":"),
//				"End Detail From Warranty Services Screen is not empty i.e. " + vehicleDetailPage.getEndDetail());
//		aMob.AssertTrue(!vehicleDetailPage.getMileageDetail().equals(":"),
//				"Mileage From Warranty Services Screen is not empty i.e. " + vehicleDetailPage.getMileageDetail());
//		aMob.AssertTrue(vehicleDetailPage.getContractDetail().equals(":"),
//				"Contract From Warranty Services Screen is not empty i.e. " + vehicleDetailPage.getContractDetail());
//		aMob.AssertTrue(vehicleDetailPage.isPdiPreDeliveryInspectionLabelVisible(),
//				"PDI Pre Delivery Inspection Visible");
//		aMob.AssertTrue(vehicleDetailPage.isExtraDlLabelVisible(), "Extra DL Visible");
//		aMob.AssertTrue(vehicleDetailPage.isTechnicalWarrantyLabelVisible(), "Technical Warranty Visible");
//		aMob.AssertTrue(vehicleDetailPage.isDriveLineLabelVisible(), "Drive Line Visible");
//		aMob.AssertTrue(vehicleDetailPage.isAns24HLabelVisible(), "Ans 24 H Visible");
//
//		vehicleDetailPage.clickJobCardHistoryTab();
//		aMob.AssertTrue(vehicleDetailPage.isSummaryScreenTabVisible(), "Summary Screen Visible");
//		aMob.AssertTrue(vehicleDetailPage.isDetailsScreenTabVisible(), "Detail Screen Visible");
//		aMob.AssertTrue(vehicleDetailPage.isDeliveryDateLabelVisible(), "Delivery Date Visible");
//		aMob.AssertTrue(vehicleDetailPage.isbookingIdLabelVisible(), "Booking ID Visible");
//	}

	@Test(description = "Login to application Trying to fail this scenario for reprting purpose ")
	public void Test3() throws Exception {
		loginPage.loginToApplication("W90041D", "Saize9045");
		System.out.println(driver.getContextHandles());
		homePage.clickOnJobCardOption();
		Thread.sleep(3000);
		jobCardPage.clickOnCreateButton();
//		System.out.println(driver.getContextHandles());
//		Set<String> view = driver.getContextHandles();
//		 String[] Geeks = view.toArray(new String[view.size()]);
//		System.out.println(Geeks[1]);
//
		jobCardPage.clickOnBreakdownOrRemoteAppointmentCheckBox();
		String CustomerName = "03 - Customer VALID" + genericPage.getCurrentDate("yyyy/MM/dd HH:mm:ss");
		jobCardPage.enterCustomerNameOnCustomerNameTextBox(CustomerName, device);
		jobCardPage.enterEmailOnCustomerEmailTextBox("customer.valid@cnhi.com");
		jobCardPage.enterPhoneNoOnCustomerPhoneTextBox("0634353637");
		jobCardPage.enterContactNoOnContactPhoneTextBox("0745464748");
		// jobCardPage.enterFiscalOnFiscalInformationTextBox("987654321");
		jobCardPage.enterBrandOnBrandTextBox("IVECO");
		jobCardPage.enterModelOnModelNameTextBox("50C15V",device);
		jobCardPage.enterNumberOnPlateNumberTextBox("ZE-983IW",device);
		// Thread.sleep(20000);
		jobCardPage.enterMileageOnMileageTextBox("40000", device);
		jobCardPage.enterSerialNumberOnSerialNumberTextBox("ZCFC150A705105307");
		Thread.sleep(3000);
		jobCardPage.enterComplainsOnCustomerComplainsTextBox("Alarm on");
		jobCardPage.enterAddressOnRepairAddressTextBox("Valid Office India");
		// jobCardPage.clickOnChecklistOption();
		jobCardPage.selectCheckListOption("Test Reception Checklist");
		jobCardPage.navigatingToCustomerNameTextBox();
		jobCardPage.enterCustomerNameOnCustomerNameTextBox(CustomerName, device);
		jobCardPage.enterEmailOnCustomerEmailTextBox("customer.valid@cnhi.com");
		jobCardPage.enterPhoneNoOnCustomerPhoneTextBox("0634353637");
		jobCardPage.enterContactNoOnContactPhoneTextBox("0745464748");
		jobCardPage.clickOnNextStepButton();
		jobCardPage.enterActivityOnActivityTextBox("Remote Activity");
		jobCardPage.clickOnAddButton();
		aMob.AssertTrue(jobCardPage.isToExecuteStatusVisible(), "To Execute Ststus is Visible");
		jobCardPage.clickOnSaveButton();
		String appointmentData = jobCardPage.getCreatedAppointmentData(CustomerName, device);

		aMob.AssertTrue(CustomerName.contains(appointmentData),
				"Customer Name Visible In the Kist Of New Created Appointment");
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

		mileageTachoPage.clickOnMileageTachoTab();
		Log.info("gjhgjh" + mileageTachoPage.isMileageTachoCameraStarIconVisible());
		aMob.AssertTrue(mileageTachoPage.isMileageTachoCameraStarIconVisible() == 2,
				"Camera Mandatory Star Icon Is Visible");
		mileageTachoPage.clickOnMileageTachoCameraIcon();
		mileageTachoPage.clickOnAddImageIcon();
		mileageTachoPage.clickOnImage();
		Log.info("gjhgjh" + mileageTachoPage.isMileageTachoCameraStarIconVisible());

		Thread.sleep(8000);
		// driver.context(Geeks[1]);
		System.out.println(driver.getContext());

//		System.out.println(driver.findElement(By.xpath("(//ion-button[@id='jobcard-mandatoryfield-mileage-photo-phone'])[1]")).getCssValue("color"));
//		System.out.println(driver.findElement(By.xpath("(//ion-button[@id='jobcard-mandatoryfield-mileage-photo-phone'])[1]")).getCssValue("--ion-color-primary-rgb"));

		// driver.context(Geeks[0]);
		System.out.println(driver.getContext());
		Thread.sleep(5000);
		aMob.AssertTrue(mileageTachoPage.isMileageTachoCameraStarIconVisible() == 1,
				"Camera Mandatory Star Icon Not Visible-- Green Dot Is Visible");

		jobCardPage.selectCheckListOption("Test Reception Checklist");

		mileageTachoPage.clickOnQuestion13DotsBtn();
		mileageTachoPage.clickOnCommentIcon();
		mileageTachoPage.enterCommentTextBox("Technician Comment on Inspection checklist");
		mileageTachoPage.clickOnSubmitBtn("Android");
		String yesChkBeforeStatus = mileageTachoPage.getYesRadioButtonCheckStatus("Android");
		mileageTachoPage.clickOnYesRadioBtnFromQuestion1();

		mileageTachoPage.clickOnQuestion23DotsBtn();
		int beforeCount = mileageTachoPage.getTotalCameraIconCount();
		Log.info("jgjh" + beforeCount);
		mileageTachoPage.clickOnAddImageIconFromQuestions("Android");
		mileageTachoPage.clickOnImage();
		mileageTachoPage.clickOnQuestion23DotsBtn();
		int afterCount = mileageTachoPage.getTotalCameraIconCount();
		Log.info("jgjh" + afterCount);
		aMob.AssertTrue(beforeCount < afterCount, "Image Added Successfully");
		mileageTachoPage.tapOnScreen();
		String greenChkBeforeStatus = mileageTachoPage.getGreenRadioButtonCheckStatus("Android");
		mileageTachoPage.clickOnGreenRadioBtnFromQuestion2();

		mileageTachoPage.clickOnQuestion33DotsBtn();
		mileageTachoPage.clickOnRecorderIcon();
		mileageTachoPage.clickOnRecordedBtnIcon();
		mileageTachoPage.clickOnOkButton();
		mileageTachoPage.clickOnRecorderStopBtnIcon();
		aMob.AssertTrue(mileageTachoPage.isRecordedVoiceVisible(), "Recorded Voice Visible Successfully");
		mileageTachoPage.clickOnRecordeCloseBtnIcon();
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
		String OnOffChkBeforeStatus = mileageTachoPage.getGreenRadioButtonCheckStatus("Android");
		mileageTachoPage.clickOnSwitcherFromQuestion4FromQuestion4();

		mileageTachoPage.clickOnCheckinIcon();
		mileageTachoPage.enterCustomerNameTextBox("Customer VALID");
		mileageTachoPage.enterSignatureTextBox();
		mileageTachoPage.turnOnTermConditionRadioButton("Android");
		mileageTachoPage.clickOnSubmitBtn("Android");
		mileageTachoPage.clickOnCloseReceptionButton();

		jobCardPage.SelectReceivedAppointment(CustomerName,"Android");
		jobCardPage.clickOnMenuButton();
		jobCardPage.clickOnchecklistMenuOption();

		mileageTachoPage.clickOnCheckinIcon();

		String yesChkFinalStatus = mileageTachoPage.getYesRadioButtonCheckStatus("Android");
		aMob.AssertTrue(!yesChkFinalStatus.equalsIgnoreCase(yesChkBeforeStatus),
				"Yes Radio Chk Value Before Click i.e. " + yesChkBeforeStatus + " Changed After Clicking i.e. "
						+ yesChkFinalStatus);
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
		mileageTachoPage.clickOnRecordedBtnIcon();
		aMob.AssertTrue(mileageTachoPage.isRecordedVoiceVisible(), "Recorded Voice Visible Successfully");
		mileageTachoPage.clickOnRecordeCloseBtnIcon();

		String OnOffChkFinalStatus = mileageTachoPage.getGreenRadioButtonCheckStatus("Android");
		aMob.AssertTrue(!OnOffChkFinalStatus.equalsIgnoreCase(OnOffChkBeforeStatus),
				"Green Radio Chk Value Before Click i.e. " + OnOffChkBeforeStatus + " Changed After Clicking i.e. "
						+ OnOffChkFinalStatus);

	}

	@Test(description = "Login to application Trying to fail this scenario for reprting purpose ")
	public void Test4() throws Exception {
		loginPage.loginToApplication("W90041D", "Saize9045");
		homePage.clickOnJobCardOption();
		jobCardPage.clickOnCreateButton();
		jobCardPage.clickOnBreakdownOrRemoteAppointmentCheckBox();
		String CustomerName = "Customer VALID" + genericPage.getCurrentDate("yyyy/MM/dd HH:mm:ss");
		jobCardPage.enterCustomerNameOnCustomerNameTextBox(CustomerName, device);
		jobCardPage.enterEmailOnCustomerEmailTextBox("customer.valid@cnhi.com");
		jobCardPage.enterPhoneNoOnCustomerPhoneTextBox("0634353637");
		jobCardPage.enterContactNoOnContactPhoneTextBox("0745464748");
		// jobCardPage.enterFiscalOnFiscalInformationTextBox("987654321");
		jobCardPage.enterBrandOnBrandTextBox("IVECO");
		jobCardPage.enterModelOnModelNameTextBox("50C15V",device);
		jobCardPage.enterNumberOnPlateNumberTextBox("ZE-983IW",device);
		// Thread.sleep(20000);
		jobCardPage.enterMileageOnMileageTextBox("40000", device);
		jobCardPage.enterSerialNumberOnSerialNumberTextBox("ZCFC150A705105307");
		Thread.sleep(3000);
		jobCardPage.enterComplainsOnCustomerComplainsTextBox("Alarm on");
		jobCardPage.enterAddressOnRepairAddressTextBox("Valid Office India");
		// jobCardPage.clickOnChecklistOption();
		jobCardPage.selectCheckListOption("Reception Checklist");
		jobCardPage.clickOnOkButton();
		jobCardPage.navigatingToCustomerNameTextBox();
		jobCardPage.enterCustomerNameOnCustomerNameTextBox(CustomerName, device);
		jobCardPage.enterEmailOnCustomerEmailTextBox("customer.valid@cnhi.com");
		jobCardPage.enterPhoneNoOnCustomerPhoneTextBox("0634353637");
		jobCardPage.enterContactNoOnContactPhoneTextBox("0745464748");
		jobCardPage.clickOnNextStepButton();
		jobCardPage.enterActivityOnActivityTextBox("Remote Activity");
		jobCardPage.clickOnAddButton();
		aMob.AssertTrue(jobCardPage.isToExecuteStatusVisible(), "To Execute Ststus is Visible");
		jobCardPage.clickOnSaveButton();
		String appointmentData = jobCardPage.getCreatedAppointmentData(CustomerName, device);

		aMob.AssertTrue(CustomerName.contains(appointmentData),
				"Customer Name Visible In the Kist Of New Created Appointment");
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

		aMob.AssertEquals(jobCardPage.getModelInfoFromAppointmentInfo(device), "35S16V",
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
		aMob.AssertTrue(mileageTachoPage.isMileageTachoCameraStarIconVisible() == 1,
				"Camera Mandatory Star Icon Not Visible-- Green Dot Is Visible");
		mileageTachoPage.clickOnMileageTachoCameraIcon();
		mileageTachoPage.clickOnAddImageIcon();
		mileageTachoPage.clickOnImage();

		mileageTachoPage.clickOnMileageTachoCameraIcon();
		mileageTachoPage.clickOnImageAddedEyeIcon("Android");
		int totalImage = mileageTachoPage.getTotalImageCount();

		aMob.AssertTrue(totalImage == 2, "Two Images Are Visible");
		mileageTachoPage.clickOnAddedImage();
		mileageTachoPage.clickOnDeleteImageBtn();
		aMob.AssertTrue(mileageTachoPage.isMentionedDeleteAttachmentReasonVisible("Poor quality", device),
				"Validating Poor Quality Option Is Visible On Delete Image Attachment Reason Screen ");
		aMob.AssertTrue(mileageTachoPage.isMentionedDeleteAttachmentReasonVisible("Incorrect subject matter", device),
				"Validating Incorrect subject matter Option Is Visible On Delete Image Attachment Reason Screen ");
		aMob.AssertTrue(mileageTachoPage.isMentionedDeleteAttachmentReasonVisible("No longer relevant", device),
				"Validating No longer relevant Option Is Visible On Delete Image Attachment Reason Screen ");
		aMob.AssertTrue(mileageTachoPage.isMentionedDeleteAttachmentReasonVisible("Wrong machine photographed", device),
				"Validating Wrong machine photographed Option Is Visible On Delete Image Attachment Reason Screen ");
		aMob.AssertTrue(mileageTachoPage.isSubmitBtnVisible("Android"), "Submit Button Visible Successfully");
		aMob.AssertTrue(mileageTachoPage.isCancelBtnVisible("Android"), "Cancel Button Visible Successfully");
		mileageTachoPage.clickOnDeleteAttachmentReason("Incorrect subject matter", device);
		mileageTachoPage.clickOnSubmitBtn("Android");
		aMob.AssertTrue(mileageTachoPage.getTotalImageCount() < totalImage, "Image Deleted Successfully");
		mileageTachoPage.clickOnCloseBtnFromAddedImageScreen();

		mileageTachoPage.clickOnEngineHoursCameraIcon();
		int beforeImageAddAllIconsCount = mileageTachoPage.getTotalCameraIconCount();
		mileageTachoPage.clickOnAddImageIcon();
		mileageTachoPage.clickOnImage();
		mileageTachoPage.clickOnEngineHoursCameraIcon();
		int AfterImageAddAllIconsCount = mileageTachoPage.getTotalCameraIconCount();
		aMob.AssertTrue(beforeImageAddAllIconsCount < AfterImageAddAllIconsCount, "Image Added Successfully");
		mileageTachoPage.clickOnEngineHoursCameraIcon();
		mileageTachoPage.enterEngineHoursOnTextBox("40500");

		mileageTachoPage.clickOnCheckinIcon();
		mileageTachoPage.enterCustomerNameTextBox("Customer VALID");
		mileageTachoPage.enterSignatureTextBox();
		mileageTachoPage.turnOnTermConditionRadioButton("Android");
		mileageTachoPage.clickOnSubmitBtn("Android");
		mileageTachoPage.clickOnCloseReceptionButton();

		jobCardPage.SelectReceivedAppointment(CustomerName,"Android");

		mileageTachoPage.clickOnMileageTachoCameraIcon();
		mileageTachoPage.clickOnImageAddedEyeIcon("Android");
		int totalFinalImageFromMileageTacho = mileageTachoPage.getTotalImageCount();
		aMob.AssertTrue(totalFinalImageFromMileageTacho == totalImage,
				"Only One Image Is Visible On Mileage And Tacho Image Added Screen");
		mileageTachoPage.clickOnCloseBtnFromAddedImageScreen();

		mileageTachoPage.clickOnEngineHoursCameraIcon();

		mileageTachoPage.clickOnImageAddedEyeIcon("Android");
		int totalFinalImageFromEngineHour = mileageTachoPage.getTotalImageCount();
		aMob.AssertTrue(totalFinalImageFromEngineHour == 1,
				"Only One Image Is Visible On Engine Hour Image Added Screen");
		mileageTachoPage.clickOnCloseBtnFromAddedImageScreen();

	}

	@Test(description = "Login to application Trying to fail this scenario for reprting purpose ")
	public void Test5() throws Exception {
		loginPage.loginToApplication("W90041D", "Saize9045");
		homePage.clickOnJobCardOption();
		jobCardPage.clickOnCreateButton();
		jobCardPage.clickOnBreakdownOrRemoteAppointmentCheckBox();
		String CustomerName = "Customer VALID" + genericPage.getCurrentDate("yyyy/MM/dd HH:mm:ss");
		jobCardPage.enterCustomerNameOnCustomerNameTextBox(CustomerName, device);
		jobCardPage.enterEmailOnCustomerEmailTextBox("customer.valid@cnhi.com");
		jobCardPage.enterPhoneNoOnCustomerPhoneTextBox("0634353637");
		jobCardPage.enterContactNoOnContactPhoneTextBox("0745464748");
		// jobCardPage.enterFiscalOnFiscalInformationTextBox("987654321");
		jobCardPage.enterBrandOnBrandTextBox("IVECO");
		jobCardPage.enterModelOnModelNameTextBox("50C15V",device);
		jobCardPage.enterNumberOnPlateNumberTextBox("ZE-983IW",device);
		// Thread.sleep(20000);
		jobCardPage.enterMileageOnMileageTextBox("40000", device);
		jobCardPage.enterSerialNumberOnSerialNumberTextBox("ZCFC150A705105307");
		Thread.sleep(3000);
		jobCardPage.enterComplainsOnCustomerComplainsTextBox("Alarm on");
		jobCardPage.enterAddressOnRepairAddressTextBox("Valid Office India");
		// jobCardPage.clickOnChecklistOption();
		jobCardPage.selectCheckListOption("Reception Checklist");
		jobCardPage.clickOnOkButton();
		jobCardPage.navigatingToCustomerNameTextBox();
		jobCardPage.enterCustomerNameOnCustomerNameTextBox(CustomerName, device);
		jobCardPage.enterEmailOnCustomerEmailTextBox("customer.valid@cnhi.com");
		jobCardPage.enterPhoneNoOnCustomerPhoneTextBox("0634353637");
		jobCardPage.enterContactNoOnContactPhoneTextBox("0745464748");
		jobCardPage.clickOnNextStepButton();
		
		jobCardPage.enterActivityOnActivityTextBox("Remote Activity");
		jobCardPage.clickOnAddButton();
		aMob.AssertTrue(jobCardPage.isToExecuteStatusVisible(), "To Execute Ststus is Visible");
		jobCardPage.clickOnSaveButton();
		String appointmentData = jobCardPage.getCreatedAppointmentData(CustomerName, device);

		aMob.AssertTrue(CustomerName.contains(appointmentData),
				"Customer Name Visible In the Kist Of New Created Appointment");
		aMob.AssertTrue(appointmentData.contains("50C15V"),
				"Model Name Visible In the First Of New Created Appointment");
		aMob.AssertTrue(appointmentData.contains("50C15V"),
				"Model Name Visible In the First Of New Created Appointment");
		aMob.AssertTrue(appointmentData.contains("ZE-983IW"),
				"Plate Number Visible In the First Of New Created Appointment");
		jobCardPage.SelectCreatedAppointment(CustomerName,device);

		aMob.AssertTrue(jobCardPage.isUnassignedActivitiesPopupVisible(),
				"Message Unassigned Activities For Breakdown is Visible");
		jobCardPage.clickOnYesButton();
		aMob.AssertTrue(jobCardPage.isAppointmentInfoLabelVisible(), "Appointment Info Label is Visible");
		aMob.AssertTrue(CustomerName.contains(jobCardPage.getCustomerInfoFromAppointmentInfo(device)),
				"Customer Name from Appointment Screen i.e. " + jobCardPage.getCustomerInfoFromAppointmentInfo(device)
						+ " is same as Expected");

		aMob.AssertEquals(jobCardPage.getModelInfoFromAppointmentInfo(device), "35S16V",
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

		mileageTachoPage.clickOnCheckinIcon();
		aMob.AssertTrue(mileageTachoPage.isMileagePhotoHasNotBeenFilledTextVisible(),
				"'Mileage photo has not been filled in.' Text is visible if trying to click checklist icon without adding image.");

		aMob.AssertTrue(mileageTachoPage.isMileageTachoCameraStarIconVisible() == 2,
				"Camera Mandatory Star Icon Is Visible");
		mileageTachoPage.clickOnMileageTachoCameraIcon();
		mileageTachoPage.clickOnAddImageIcon();
		mileageTachoPage.clickOnImage();
		aMob.AssertTrue(mileageTachoPage.isMileageTachoCameraStarIconVisible() == 1,
				"Camera Mandatory Star Icon Not Visible-- Green Dot Is Visible");
		mileageTachoPage.clickOnCheckinIcon();
		aMob.AssertTrue(mileageTachoPage.isCustomerNameTextBoxVisible(), "Customer Name Text Box Is Visible");
		aMob.AssertTrue(mileageTachoPage.isSignatureTextBoxVisible(), "Signature Text Box Is Visible");
		aMob.AssertTrue(mileageTachoPage.isCustomerNotPresentRadioButtonVisible(),
				"Customer Not Present Radio Button Is Visible");
		aMob.AssertTrue(mileageTachoPage.isTermConditionRadioButtonVisible(), "Term Condition Radio Button Is Visible");
		aMob.AssertTrue(mileageTachoPage.isPrivacyNoticeRadioButtonVisible(), "By Selecting Radio Button Is Visible");
		aMob.AssertTrue(mileageTachoPage.isSubmitBtnVisible("Android"), "Submit Button Visible Successfully");
		aMob.AssertTrue(mileageTachoPage.isCancelBtnVisible("Android"), "Cancel Button Visible Successfully");
		mileageTachoPage.enterCustomerNameTextBox("Customer VALID");
		mileageTachoPage.turnOffTermConditionRadioButton("Android");
		aMob.AssertEquals(mileageTachoPage.getSubmitBtnEnableStatus("Android"), "false",
				"The Submit Button Is Disabled After Uncheck Term And Condition");
		mileageTachoPage.enterSignatureTextBox();
		aMob.AssertEquals(mileageTachoPage.getSubmitBtnEnableStatus("Android"), "false",
				"The Submit Button Is Disabled After Uncheck Term And Condition And Enter Signature");
		mileageTachoPage.turnOnTermConditionRadioButton("Android");
		aMob.AssertEquals(mileageTachoPage.getSubmitBtnEnableStatus("Android"), "true",
				"The Submit Button Is Enabled After Check Term And Condition And Entering Signature");
		mileageTachoPage.clickOnCancelBtn("Android");
		mileageTachoPage.clickOnCheckinIcon();
		aMob.AssertTrue(mileageTachoPage.getTermConditionRadioButtonStatus("Android").equalsIgnoreCase("1"),
				"Term Condition Radio Button Is Checked");
		mileageTachoPage.turnOnCustomerNotPresentRadioButton("Android");
		aMob.AssertEquals(mileageTachoPage.getSubmitBtnEnableStatus("Android"), "true",
				"The Submit Button Is Enabled After Check Customer Not Present Radio Button");
		mileageTachoPage.turnOffTermConditionRadioButton("Android");
		aMob.AssertEquals(mileageTachoPage.getSubmitBtnEnableStatus("Android"), "false",
				"The Submit Button Is Disabled After Uncheck Term And Condition radio Button");

		mileageTachoPage.enterCustomerNameTextBox("Customer VALID");
		mileageTachoPage.enterSignatureTextBox();
		mileageTachoPage.turnOnTermConditionRadioButton("Android");
		aMob.AssertEquals(mileageTachoPage.getSubmitBtnEnableStatus("Android"), "true",
				"The Submit Button Is Enabled After Entering Customer Name, Signature and Turn On Term Condition Radio Button");
		mileageTachoPage.turnOnPrivacyNoticeRadioButton("Android");
		mileageTachoPage.clickOnCancelBtn("Android");
		mileageTachoPage.clickOnCheckinIcon();
		aMob.AssertTrue(mileageTachoPage.getTermConditionRadioButtonStatus("Android").equalsIgnoreCase("1"),
				"Term Condition Radio Button Is Checked");
		aMob.AssertTrue(mileageTachoPage.getPrivacyNoticeRadioButtonStatus("Android").equalsIgnoreCase("1"),
				"Privacy Notice Radio Button Is Checked");
		mileageTachoPage.enterCustomerNameTextBox("Customer VALID");
		mileageTachoPage.enterSignatureTextBox();
		mileageTachoPage.clickOnSubmitBtn("Android");
		mileageTachoPage.clickOnCloseReceptionButton();
	}

	@Test(description = "Login to application Trying to fail this scenario for reprting purpose ")
	public void Test6() throws Exception {
		loginPage.loginToApplication("W90041D", "Saize9045");
		homePage.clickOnJobCardOption();
		jobCardPage.clickOnCreateButton();
		jobCardPage.clickOnBreakdownOrRemoteAppointmentCheckBox();
		String CustomerName = "Customer VALID" + genericPage.getCurrentDate("yyyy/MM/dd HH:mm:ss");
		jobCardPage.enterCustomerNameOnCustomerNameTextBox(CustomerName, device);
		jobCardPage.enterEmailOnCustomerEmailTextBox("customer.valid@cnhi.com");
		jobCardPage.enterPhoneNoOnCustomerPhoneTextBox("0634353637");
		jobCardPage.enterContactNoOnContactPhoneTextBox("0745464748");
		// jobCardPage.enterFiscalOnFiscalInformationTextBox("987654321");
		jobCardPage.enterBrandOnBrandTextBox("IVECO");
		jobCardPage.enterModelOnModelNameTextBox("50C15V",device);
		jobCardPage.enterNumberOnPlateNumberTextBox("ZE-983IW",device);
		// Thread.sleep(20000);
		jobCardPage.enterMileageOnMileageTextBox("1200", device);
		jobCardPage.enterSerialNumberOnSerialNumberTextBox("ZCFC150A705105307");
		Thread.sleep(3000);
		jobCardPage.enterComplainsOnCustomerComplainsTextBox("Alarm on");
		jobCardPage.enterAddressOnRepairAddressTextBox("Valid Office India");
		// jobCardPage.clickOnChecklistOption();
		jobCardPage.selectCheckListOption("Reception Checklist");
		jobCardPage.clickOnOkButton();
		jobCardPage.navigatingToCustomerNameTextBox();
		jobCardPage.enterCustomerNameOnCustomerNameTextBox(CustomerName, device);
		jobCardPage.enterEmailOnCustomerEmailTextBox("customer.valid@cnhi.com");
		jobCardPage.enterPhoneNoOnCustomerPhoneTextBox("0634353637");
		jobCardPage.enterContactNoOnContactPhoneTextBox("0745464748");

		jobCardPage.clickOnNextStepButton();
		jobCardPage.enterActivityOnActivityTextBox("Remote Activity");
		jobCardPage.clickOnAddButton();
		aMob.AssertTrue(jobCardPage.isToExecuteStatusVisible(), "To Execute Ststus is Visible");
		jobCardPage.clickOnSaveButton();
		String appointmentData = jobCardPage.getCreatedAppointmentData(CustomerName,device);

		aMob.AssertTrue(CustomerName.contains(appointmentData),
				"Customer Name Visible In the Kist Of New Created Appointment");
		aMob.AssertTrue(appointmentData.contains("50C15V"),
				"Model Name Visible In the First Of New Created Appointment");
		aMob.AssertTrue(appointmentData.contains("50C15V"),
				"Model Name Visible In the First Of New Created Appointment");
		aMob.AssertTrue(appointmentData.contains("ZE-983IW"),
				"Plate Number Visible In the First Of New Created Appointment");
		jobCardPage.SelectCreatedAppointment(CustomerName,device);

		aMob.AssertTrue(jobCardPage.isUnassignedActivitiesPopupVisible(),
				"Message Unassigned Activities For Breakdown is Visible");
		jobCardPage.clickOnYesButton();
		aMob.AssertTrue(jobCardPage.isAppointmentInfoLabelVisible(), "Appointment Info Label is Visible");
		aMob.AssertTrue(CustomerName.contains(jobCardPage.getCustomerInfoFromAppointmentInfo(device)),
				"Customer Name from Appointment Screen i.e. " + jobCardPage.getCustomerInfoFromAppointmentInfo(device)
						+ " is same as Expected");

		aMob.AssertEquals(jobCardPage.getModelInfoFromAppointmentInfo(device), "35S16V",
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
		aMob.AssertTrue(mileageTachoPage.isMileageTachoCameraStarIconVisible() == 1,
				"Camera Mandatory Star Icon Not Visible-- Green Dot Is Visible");
		mileageTachoPage.clickOnMileageTachoCameraIcon();
		mileageTachoPage.clickOnAddImageIcon();
		mileageTachoPage.clickOnImage();

		mileageTachoPage.clickOnCheckinIcon();
		mileageTachoPage.enterCustomerNameTextBox("Customer VALID");
		mileageTachoPage.enterSignatureTextBox();
		mileageTachoPage.turnOnTermConditionRadioButton("Android");
		mileageTachoPage.clickOnSubmitBtn("Android");
		mileageTachoPage.clickOnCloseReceptionButton();

		jobCardPage.SelectReceivedAppointment(CustomerName,"Android");

		mileageTachoPage.clickOnGeneralAttachmentsCameraIcon();
		int cameraCountBefore = mileageTachoPage.getTotalCameraIconCount();
		mileageTachoPage.clickOnAddImageIcon();
		mileageTachoPage.clickOnImage();
		mileageTachoPage.clickOnGeneralAttachmentsCameraIcon();
		int cameraCountAfter = mileageTachoPage.getTotalCameraIconCount();
		aMob.AssertTrue(cameraCountBefore < cameraCountAfter, "Image Added Successfully");

		mileageTachoPage.clickOnGeneralAttachmentsMicroPhoneIcon();
		mileageTachoPage.clickOnRecorderIcon();
		mileageTachoPage.clickOnRecorderStopBtnIcon();
		aMob.AssertTrue(mileageTachoPage.isRecordedVoiceVisible(), "Recorded Voice Visible Successfully");
		mileageTachoPage.clickOnRecordeCloseBtnIcon();

		// Need To Add 3 more Steps
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		System.out.println("Test");
		// driver.quit();
	}

}
