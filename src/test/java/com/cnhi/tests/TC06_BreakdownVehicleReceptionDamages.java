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
public class TC06_BreakdownVehicleReceptionDamages extends BaseTest {
	GenericPage genericPage;
	AppDeviceFactory getDevice;
	DeviceConfiguration deviceConfiguration;
	LoginPage loginPage;
	HomePage homePage;
	JobCardPage jobCardPage;
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
		public void BreakdownVehicleReceptionDamages() throws Exception {
		loginPage.loginToApplication("W90041D", "Saize9046");
		homePage.clickOnJobCardOption();
		Thread.sleep(3000);
		Set<String> view = driver.getContextHandles();
		System.out.println(view);
		//String CustomerName = "Auto Test DJC2022/04/28 16:16:10";
		jobCardPage.clickOnCreateButton();
		jobCardPage.clickOnBreakdownOrRemoteAppointmentCheckBox();
		String CustomerName = "Auto Test DJC" + genericPage.getCurrentDate("yyyy/MM/dd HH:mm:ss");
		jobCardPage.enterCustomerNameOnCustomerNameTextBox(CustomerName, device);
		jobCardPage.enterEmailOnCustomerEmailTextBox("jobcard@test.com");
		jobCardPage.enterPhoneNoOnCustomerPhoneTextBox("0634353637");
		jobCardPage.enterContactNoOnContactPhoneTextBox("0745464748");
		jobCardPage.enterBrandOnBrandTextBox("IVECO");
		jobCardPage.enterModelOnModelNameTextBox("50C15V", device);
		jobCardPage.enterNumberOnPlateNumberTextBox("ZE-983IW", device);
		jobCardPage.enterMileageOnMileageTextBox("200000", device);
		jobCardPage.enterSerialNumberOnSerialNumberTextBox("ZCFC150A605019230");
		Thread.sleep(3000);
		jobCardPage.enterComplainsOnCustomerComplainsTextBox("INJECTION Issue");
		jobCardPage.enterAddressOnRepairAddressTextBox("Auto Test DJC Office Rue de la Validation 123000 JOBCARD");
		jobCardPage.selectCheckListOption("Test Reception Checklist");
		jobCardPage.clickOnNextStepButton();
		jobCardPage.enterActivityOnActivityTextBox("Damage Activity");
		jobCardPage.clickOnAddButton();
		jobCardPage.clickOnSaveButton();
		String appointmentData = jobCardPage.getCreatedAppointmentData(CustomerName, device);

		aMob.AssertTrue(appointmentData.contains(CustomerName),
				"Customer Name Visible In the List Of New Created Appointment");
		aMob.AssertTrue(appointmentData.contains("50C15V"),
				"Model Name Visible In the First Of New Created Appointment");
		aMob.AssertTrue(appointmentData.contains("50C15V"),
				"Model Name Visible In the First Of New Created Appointment");
		aMob.AssertTrue(appointmentData.contains("ZE-983IW"),
				"Plate Number Visible In the First Of New Created Appointment");
		jobCardPage.SelectCreatedAppointment(CustomerName, "Android");

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

		jobCardPage.clickOnMenuButton();
		jobCardPage.clickOnDamagesMenuOption();
		aMob.AssertTrue(damagesPage.isVehicleBackLabelVisible(), "Vehicle Back label Visible Successfully");
		aMob.AssertTrue(damagesPage.isVehicleRightSideLabelVisible(), "Vehicle Right Side label Visible Successfully");
		aMob.AssertTrue(damagesPage.isVehicleLeftSideLabelVisible(), "Vehicle Right Side label Visible Successfully");
		aMob.AssertTrue(damagesPage.isVehicleLeftSideLabelVisible(), "Vehicle Left Side label Visible Successfully");
		
	
		damagesPage.swipeUpTheScreen();
		damagesPage.clickOnAddDamageVehicleFrontIcon();
		aMob.AssertTrue(damagesPage.isPhotoCameraIconVisible(), "Photo Camera Icon Visible Successfully");
		aMob.AssertTrue(damagesPage.isVideoCameraIconVisible(), "Video Camera Icon Visible Successfully");
		aMob.AssertTrue(damagesPage.isGalleryIconVisible(), "Gallery Icon Visible Successfully");
		mileageTachoPage.clickPhotoCamera();
		Thread.sleep(10000);
		mileageTachoPage.captureCameraphoto();
		Thread.sleep(10000);
		mileageTachoPage.attachCameraphoto();
		Thread.sleep(5000);		
//		mileageTachoPage.clickOnAddImageIcon();
//		mileageTachoPage.clickOnImage();
		Thread.sleep(10000);
		aMob.AssertTrue(damagesPage.isPhotoVehicleFrontImageVisible(),
				"Image Added Successfully For Vehicle Front Section");
		damagesPage.clickOnAddedImageFromVehicleFront();
		mileageTachoPage.clickOnDeleteImageBtn();
		aMob.AssertTrue(mileageTachoPage.isMentionedDeleteAttachmentReasonVisible("Poor quality", "Android"),
				"Validating Poor Quality Option Is Visible On Delete Image Attachment Reason Screen ");
		aMob.AssertTrue(mileageTachoPage.isMentionedDeleteAttachmentReasonVisible("Incorrect subject matter", "Android"),
				"Validating Incorrect subject matter Option Is Visible On Delete Image Attachment Reason Screen ");
		aMob.AssertTrue(mileageTachoPage.isMentionedDeleteAttachmentReasonVisible("No longer relevant", "Android"),
				"Validating No longer relevant Option Is Visible On Delete Image Attachment Reason Screen ");
		aMob.AssertTrue(mileageTachoPage.isMentionedDeleteAttachmentReasonVisible("Wrong machine photographed", "Android"),
				"Validating Wrong machine photographed Option Is Visible On Delete Image Attachment Reason Screen ");
		
		aMob.AssertTrue(damagesPage.isSUBMITButtonVisible("Android"), "Submit Button Visible Successfully");
		aMob.AssertTrue(damagesPage.isCANCELButtonVisible("Android"), "Cancel Button Visible Successfully");
		
//		aMob.AssertTrue(mileageTachoPage.isSubmitBtnVisible("Android"), "Submit Button Visible Successfully");
//		aMob.AssertTrue(mileageTachoPage.isCancelBtnVisible("Android"), "Cancel Button Visible Successfully");
//		mileageTachoPage.clickOnCancelBtn("Android");
		damagesPage.clickOnCANCELButton("Android");
		
		aMob.AssertTrue(damagesPage.isPhotoVehicleFrontImageVisible(),
				"Image Visible Successfully For Vehicle Front Section After Clicking Cancel Button");
		damagesPage.clickOnAddedImageFromVehicleFront();
		mileageTachoPage.clickOnDeleteImageBtn();
		mileageTachoPage.clickOnDeleteAttachmentReason("Wrong machine photographed", device);
		damagesPage.clickOnSUBMITButton("Android");
		//mileageTachoPage.clickOnSubmitBtn("Android");
//		aMob.AssertFalse(damagesPage.isPhotoVehicleFrontImageVisible(),
//				"Image Deleted Successfully For Vehicle Front Section");
		damagesPage.clickOnAddDamageVehicleRightSideIcon();
		mileageTachoPage.clickPhotoCamera();
		Thread.sleep(10000);
		mileageTachoPage.captureCameraphoto();
		Thread.sleep(5000);
		mileageTachoPage.attachCameraphoto();
		Thread.sleep(10000);		
//		mileageTachoPage.clickOnAddImageIcon();
//		mileageTachoPage.clickOnImage();
//		Thread.sleep(6000);
        //Thread.sleep(50000);
		aMob.AssertTrue(damagesPage.isPhotoVehicleRightSideImageVisible(),
				"Image Added Successfully For Vehicle Right Side Section");
		damagesPage.swipeUpTheScreen();
		damagesPage.clickOnSwitchToggleButton();
		aMob.AssertTrue(damagesPage.isClickOnTruckToAddInFormationLabelVisible(),
				"Click On Truck To Add Information Label Is Visible");
		aMob.AssertTrue(damagesPage.getTruckImagesCount() == 2, "Two Truck Images Visible Successfully");
		damagesPage.selectValueFromTruckScreenDropDown("Eurocargo", "Android");
		damagesPage.clickOnOkButton();
		damagesPage.clickOnFirstTruckImage();
		int iconBeforeCount = mileageTachoPage.getTotalCameraIconCount();
		aMob.AssertTrue(damagesPage.isPhotoCameraIconVisible(), "Photo Camera Icon Visible Successfully");
		aMob.AssertTrue(damagesPage.isVideoCameraIconVisible(), "Video Camera Icon Visible Successfully");
		aMob.AssertTrue(damagesPage.isGalleryIconVisible(), "Gallery Icon Visible Successfully");
		aMob.AssertTrue(damagesPage.isNoteIconVisible(), "Note Icon Visible Successfully");
//		damagesPage.clickOnAddImageIconFromTruckScreen();
//		mileageTachoPage.clickOnImage();
		mileageTachoPage.clickPhotoCamera();
		Thread.sleep(10000);
		mileageTachoPage.captureCameraphoto();
		Thread.sleep(5000);
		mileageTachoPage.attachCameraphoto();
		Thread.sleep(5000);		
		damagesPage.clickOnAddedMediaIconFromTruckScreen();
		int iconAfterCount = mileageTachoPage.getTotalCameraIconCount();

		aMob.AssertTrue(iconBeforeCount < iconAfterCount, "Eye Media Added Icon Is Visible");

		mileageTachoPage.clickOnImageAddedEyeIcon("Android");
		
		int totalImage = mileageTachoPage.getTotalImageCount();

		aMob.AssertTrue(totalImage == 1, "One Image Is Visible");
		mileageTachoPage.clickOnCloseBtnFromAddedImageScreen();
		
		damagesPage.clickOnSecondTruckImage();

		/*mileageTachoPage.clickOnVideoCameraBtn();
		mileageTachoPage.clickOnStartVideoRecordingBtn();
		Thread.sleep(10000);
		mileageTachoPage.clickOnStopVideoRecordingBtn();
		mileageTachoPage.attachVideoRecordingBtn();
		Thread.sleep(5000);*/
		
		mileageTachoPage.clickPhotoCamera();
		Thread.sleep(10000);
		mileageTachoPage.captureCameraphoto();
		Thread.sleep(5000);
		mileageTachoPage.attachCameraphoto();
		Thread.sleep(5000);	
		
		damagesPage.clickOnaddedMediaSecondTruckIconFromTruckScreen();
		int cameraCountBefore = mileageTachoPage.getTotalCameraIconCount();
		
		damagesPage.clickOnCommentButton("Android");
		
		mileageTachoPage.enterCommentTextBox("Damage on the back truck");
		mileageTachoPage.clickOnSubmitBtn("Android");
		
		damagesPage.clickOnaddedMediaSecondTruckIconFromTruckScreen();
		int cameraCountAfter = mileageTachoPage.getTotalCameraIconCount();
		//aMob.AssertTrue(cameraCountBefore < cameraCountAfter, "Image Added Successfully");
		
		mileageTachoPage.clickOnImageAddedEyeIcon("Android");
		mileageTachoPage.clickOnCloseBtnFromAddedImageScreen();
		damagesPage.clickOnaddedSecondMediaSecondTruckIconFromTruckScreen();
		
		}
		@AfterMethod(alwaysRun = true)
		public void afterMethod() {
			System.out.println("Test");
			// driver.quit();
		}
	}

}
