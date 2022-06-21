package com.cnhi.pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.auto.framework.base.Log;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class TaskPage {

	public AppiumDriver<?> driver;
	GenericPage gMob;

	public TaskPage(AppiumDriver<?> driver, GenericPage ttMob) {
		this.driver = driver;
		this.gMob = ttMob;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "(//android.widget.EditText[@text='Group Test Reception Checklist - Qiestion 01'])|(//android.widget.EditText[@text='Test Group - Test Checkbox'])")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Group Test Reception Checklist - Qiestion 01']")
	private MobileElement groupTestReceptionChkListQuestion1Label;

	@AndroidFindBy(xpath = "(//android.view.View/android.widget.Button)[14]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Group Test Reception Checklist - Qiestion 01']/parent::XCUIElementTypeOther/following-sibling:: XCUIElementTypeButton)[1]")
	private MobileElement groupTestReceptionChkListQuestion1DotBtn;

	@AndroidFindBy(xpath = "//android.view.View[@text='Complaint']/parent::android.view.View/android.view.View[2]/android.widget.EditText")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Complaint']/following:: XCUIElementTypeTextView)[1]")
	private MobileElement complaintTextBox;

	@AndroidFindBy(xpath = "//android.view.View[@text='Cause']/parent::android.view.View/android.view.View[4]/android.widget.EditText")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Cause']/following:: XCUIElementTypeTextView)[1]")
	private MobileElement causeTextBox;

	@AndroidFindBy(xpath = "//android.view.View[@text='Correction']/parent::android.view.View/android.view.View[6]/android.widget.EditText")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Correction']/following:: XCUIElementTypeTextView)[1]")
	private MobileElement correctionTextBox;

	@AndroidFindBy(xpath = "//android.view.View[@text='Internal note']/parent::android.view.View/android.view.View[8]/android.widget.EditText")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Internal note']/following:: XCUIElementTypeTextView)[1]")
	private MobileElement internalNoteTextBox;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='closeModal']/android.widget.Button")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Add a comment']/following:: XCUIElementTypeButton)[1]")
	private MobileElement commentCloseBtn;
	
	@AndroidFindBy(xpath = "(//android.view.View[@text='ToDo']/following::android.widget.Button)[1]|(//android.widget.TextView[@text='ToDo']/following::android.widget.Button)[1]")
	@iOSXCUITFindBy(xpath = "((//XCUIElementTypeStaticText[@name=\"To execute\"])[2]/following:: XCUIElementTypeButton)[1]")
	private MobileElement generalTestArrowBtn;
	
	//@AndroidFindBy(xpath = "//android.widget.Spinner[@resource-id='supplierCode-1']")
	
	@AndroidFindBy(xpath = "(//android.widget.Spinner[contains(@resource-id,'supplierCode')])[1]")
	@iOSXCUITFindBy(xpath = "((//XCUIElementTypeStaticText[@name='Supplier Code'])[2]/following:: XCUIElementTypeOther)[1]")
	private MobileElement supplierCodeTextBox;
	
	@AndroidFindBy(xpath = "(//android.widget.EditText[contains(@resource-id,'defectCode')])[1]")
	@iOSXCUITFindBy(xpath = "((//XCUIElementTypeStaticText[@name='Defect Code'])[2]/following:: XCUIElementTypeOther)[1]")
	private MobileElement defectCodeTextBox;
	
	@AndroidFindBy(xpath = "(//android.widget.Spinner[contains(@resource-id,'failure')])[1]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Failure Code']/following:: XCUIElementTypeButton)[1]")
	private MobileElement failureCodeTextBox;
	
	@AndroidFindBy(xpath = "(//android.widget.Spinner[contains(@resource-id,'failureSeverity')])[1]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Failure Severity Rate']/following:: XCUIElementTypeButton)[1]")
	private MobileElement failureSeverityRateTextBox;
	
	@AndroidFindBy(xpath = "(//android.widget.Spinner[contains(@resource-id,'payment')])[1]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Payment Type']/following:: XCUIElementTypeButton)[1]")
	private MobileElement paymentTypeTextBox;
	
	@AndroidFindBy(xpath = "(//android.widget.Button[@text='Add a new operation'])[1]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Add a new operation'])[2]")
	private MobileElement groupTestAddNewOperationBtn;
	
	@AndroidFindBy(xpath = "(//android.widget.Button[@text='Add another item'])[1]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Add another item'])[2]")
	private MobileElement groupTestaddAnotherItemBtn;
	
	
	//@AndroidFindBy(xpath = "(//android.view.View/android.widget.Button)[11]")
	@AndroidFindBy(xpath = "//android.view.View[@text='Activity with attachments']/parent::android.view.View/android.view.View[1]/following::android.widget.Button[1]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Add another item'])[2]")
	private MobileElement startTaskExecutionBtn;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Activity with attachments']/parent::android.view.View/android.view.View[1]/following::android.widget.Button[1]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Add another item'])[2]")
	private MobileElement stopTaskExecutionBtn;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Activity with attachments']/parent::android.view.View/android.view.View[1]/following::android.widget.Button[2]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Add another item'])[2]")
	private MobileElement activityWithAttachmentsQuestion3DotBtn;
	
	@AndroidFindBy(xpath = "//android.view.View[starts-with(@resource-id,'alert')]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Add another item'])[2]")
	private MobileElement addMediaDescriptionHeaderLabel;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='description']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Add another item'])[2]")
	private MobileElement addMediaDescriptionText;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='W90041D']/parent::android.view.View/android.view.View[3]/android.widget.EditText")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Add another item'])[2]")
	private MobileElement mediaDescriptionTxtBox;
	
	
	//@AndroidFindBy(xpath = "//android.view.View/android.widget.EditText")
	@AndroidFindBy(xpath = "//android.view.View/android.widget.EditText")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Add another item'])[2]")
	private MobileElement voiceRecordMediaDescriptionTxtBox;
	
	@AndroidFindBy(xpath = "(//android.view.View/android.widget.EditText)[2]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Add another item'])[2]")
	private MobileElement voiceRecordMediaDescriptionTxtBox1;
	
	@AndroidFindBy(xpath = "(//android.view.View/android.widget.Button)[2]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Add another item'])[2]")
	private MobileElement playRecordedVoiceButton;
	
	
	@AndroidFindBy(xpath = "(//android.view.View/android.widget.Button)[3]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Add another item'])[2]")
	private MobileElement deleteRecordedVoiceButton;
	
	
	@AndroidFindBy(xpath = "(//android.widget.Spinner[@text='In progress'])[2]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Add another item'])[2]")
	private MobileElement inProgressTaskStatusBtn;
	
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Done']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Add another item'])[2]")
	private MobileElement doneTaskStatusBtn;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='OK']")
	private MobileElement okButtonFromPopup;
	
	@AndroidFindBy(xpath = "(//android.view.View/android.widget.EditText)[1]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Complaint']/following:: XCUIElementTypeTextView)[1]")
	private MobileElement getComplaintText;
	
	@AndroidFindBy(xpath = "(//android.view.View/android.widget.EditText)[2]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Complaint']/following:: XCUIElementTypeTextView)[1]")
	private MobileElement getCauseText;
	
	@AndroidFindBy(xpath = "(//android.view.View/android.widget.EditText)[3]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Complaint']/following:: XCUIElementTypeTextView)[1]")
	private MobileElement getCorrectionText;
	
	@AndroidFindBy(xpath = "(//android.view.View/android.widget.EditText)[4]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Complaint']/following:: XCUIElementTypeTextView)[1]")
	private MobileElement getInternalNoteText;
	
	@AndroidFindBy(xpath = "//android.view.View/android.widget.EditText")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Complaint']/following:: XCUIElementTypeTextView)[1]")
	private MobileElement getCommentText;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Oil Control']/parent::android.view.View/android.view.View[3]/android.widget.Spinner")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement getStatusOfnewlyAddedOilControlActivity;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Long Activity']/parent::android.view.View/android.view.View[3]/android.widget.Spinner")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement getStatusOfnewlyAddedLongActivity;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Clutch Repair']/parent::android.view.View/android.view.View[3]/android.widget.Spinner")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement getStatusOfnewlyAddedClutchRepairActivity;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='78 47 13 102 - R-I 1 FITTING FOR REAR BRAKES HYDRAULIC PRESSURE CONTROL']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement brakeRepairActivityOperation1;
	
	
	@AndroidFindBy(xpath = "//android.view.View[@text='79 41 01 100 - R-I POWER BRAKE']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement brakeRepairActivityOperation2;
	

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='jobcard']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Done']")
	private List<MobileElement> totalDoneStatus;
	
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='jobcard']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Planned time :']/following-sibling:: XCUIElementTypeStaticText")
	private List<MobileElement> totalPlannedTimeText;
	
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='jobcard']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Service App']//XCUIElementTypeButton)[last()]")
	private MobileElement noteIcon;
	
	
	public void clickOnGroupTestReceptionChkListQuestion1DotBtn() throws Exception {
		for (int i = 0; i <= 4; i++) {
			gMob.swipeUpDown("up", driver);
		}
		gMob.swipeToElement(groupTestReceptionChkListQuestion1DotBtn, "up", driver);
		gMob.clickElement(groupTestReceptionChkListQuestion1DotBtn,
				"Click On Group Test Reception Check List Question1 Dot Button");
	}

	public void clickOnCloseButtonFromAddCommentScreen() throws Exception {
		gMob.swipeToElement(commentCloseBtn, "up", driver);
		gMob.clickElement(commentCloseBtn, "Click On Close Button From Add A Comment Screen");
	}
	
	public void clickOnGeneralTestArrowBtn() throws Exception {
		gMob.swipeToElement(generalTestArrowBtn, "up", driver);
		gMob.clickElement(generalTestArrowBtn, "Click On General test Arrow Button");
	}

	public void tapOnScreen() {
		gMob.tapByCoordinates(192, 166, driver);
	}

	public boolean isCreatedActivityVisible(String ActivityName, String device) throws Exception {
		String xpath = null;
		if (device.equalsIgnoreCase("Android")) {
			xpath = "//android.view.View[@text='" + ActivityName + "']";
		} else {
			xpath = "//XCUIElementTypeStaticText[@name='" + ActivityName + "']";
		}
		gMob.scrollToElementWithXpath(xpath, device, driver);

		return gMob.WaitingAndReturningElementVisibilityUsingXpath(xpath, driver);
	}

	public boolean isGroupTestReceptionChkListQuestion1Label() throws Exception {
		gMob.swipeToElement(groupTestReceptionChkListQuestion1Label, "up", driver);
		return gMob.isElementDisplay(groupTestReceptionChkListQuestion1Label,
				"Group Test Reception Checklist - Qiestion 01 is visible");
	}

	public boolean isComplaintTextBoxDisabled() {
		gMob.waitForVisibility(complaintTextBox, driver);
		return gMob.getElementText(complaintTextBox, "enabled", "Getting Complaint TextBox Enabled Stuatus")
				.equals("false");
	}

	public boolean isCauseTextBoxDisabled() {
		gMob.waitForVisibility(causeTextBox, driver);
		return gMob.getElementText(causeTextBox, "enabled", "Getting Cause TextBox Enabled Stuatus").equals("false");
	}

	public boolean isCorrectionTextBoxDisabled() {
		gMob.waitForVisibility(correctionTextBox, driver);
		return gMob.getElementText(correctionTextBox, "enabled", "Getting Correction TextBox Enabled Stuatus")
				.equals("false");
	}

	public boolean isInternalNoteTextBoxDisabled() {
		gMob.waitForVisibility(internalNoteTextBox, driver);
		return gMob.getElementText(internalNoteTextBox, "enabled", "Getting Internal Note TextBox Enabled Stuatus")
				.equals("false");
	}

	public String getInternalNoteTextBoxValue(String device) {
		gMob.waitForVisibility(internalNoteTextBox, driver);
		if (device.equalsIgnoreCase("Android")) {
		return gMob.getElementText(internalNoteTextBox, "text", "Getting Internal Note TextBox Value");
		}
		return gMob.getElementText(internalNoteTextBox, "value", "Getting Internal Note TextBox Value");
	}
	
	public String getSupplierCodeTextBoxValue(String device) {
		gMob.waitForVisibility(supplierCodeTextBox, driver);
		if (device.equalsIgnoreCase("Android")) {
			return gMob.getElementText(supplierCodeTextBox, "text", "Getting Supplier Code TextBox Value");
			}
		return gMob.getElementText(supplierCodeTextBox, "name", "Getting Supplier Code TextBox Value");
	}
	
	public boolean isSupplierCodeTextBoxDisabled() {
		gMob.waitForVisibility(supplierCodeTextBox, driver);
		return gMob.getElementText(supplierCodeTextBox, "enabled", "Getting Supplier Code TextBox Enabled Stuatus")
				.equals("false");
	}
	
	public boolean isDefectCodeTextBoxDisabled() {
		gMob.waitForVisibility(defectCodeTextBox, driver);
		return gMob.getElementText(defectCodeTextBox, "enabled", "Getting Defect Code  TextBox Enabled Stuatus")
				.equals("false");
	}
	
	public boolean isFailureCodeTextBoxDisabled() {
		gMob.waitForVisibility(failureCodeTextBox, driver);
		return gMob.getElementText(failureCodeTextBox, "enabled", "Getting Failure Code  TextBox Enabled Stuatus")
				.equals("false");
	}
	
	public boolean isFailureSeverityRateTextBoxDisabled() {
		gMob.waitForVisibility(failureSeverityRateTextBox, driver);
		return gMob.getElementText(failureSeverityRateTextBox, "enabled", "Getting Failure Severity Rate  TextBox Enabled Stuatus")
				.equals("false");
	}
	
	public boolean isPaymentTypeTextBoxDisabled() {
		gMob.waitForVisibility(paymentTypeTextBox, driver);
		return gMob.getElementText(paymentTypeTextBox, "enabled", "Getting Payment Type  TextBox Enabled Stuatus")
				.equals("false");
	}
	
	public void clickOnAddNewOperationBtnFromGroupTest(String device) throws Exception {
		Thread.sleep(6000);
		for (int i = 0; i <= 4; i++) {
			gMob.swipeUpDown("up", driver);
		}
		gMob.MoveDownScreenWithElementAccordingToDevice(groupTestAddNewOperationBtn, device, driver);
		// gMob.swipeToElement(addNewOperationBtn, "up", driver);
		// gMob.scrollToElemet(addNewOperationBtn, driver);
		Thread.sleep(5000);
		gMob.clickElement(groupTestAddNewOperationBtn, "Click On Add A New Operation Button From Group Test");
	}
	
	public void clickOnAddAnotherItemBtnFromGroupTest() throws Exception {
		Thread.sleep(6000);
		// gMob.scrollToElemet(addAnotherItemBtn, driver);
		gMob.swipeToElement(groupTestaddAnotherItemBtn, "up", driver);
		gMob.clickElement(groupTestaddAnotherItemBtn, "Click On Add Another Item Button");
	}
	
	public void clickOnPlayButtonToStartTaskExecution() throws Exception {
		for (int i = 0; i <= 4; i++) {
			gMob.swipeUpDown("up", driver);
		}
		gMob.swipeToElement(startTaskExecutionBtn, "up", driver);
		gMob.clickElement(startTaskExecutionBtn, "Click On Play Icon to Start the Task Execution");
	}
	
	public void clickOnStopButtonToStopTaskExecution() throws Exception {
		gMob.swipeToElement(stopTaskExecutionBtn, "up", driver);
		gMob.clickElement(stopTaskExecutionBtn, "Click On Stop Icon to Stop the Task Execution");
	}
	
	public void clickOnActivityWithAttachmentsQuestion3DotBtn() throws Exception {
		gMob.swipeToElement(activityWithAttachmentsQuestion3DotBtn, "up", driver);
		gMob.clickElement(activityWithAttachmentsQuestion3DotBtn, "Click On Activity With Attachments Question 3Dot Btn");
	}
	
//	public void clickOnActivityWithAttachmentsQuestion3DotBtn1() throws Exception {
//		gMob.swipeToElement(activityWithAttachmentsQuestion3DotBtn1, "up", driver);
//		gMob.clickElement(activityWithAttachmentsQuestion3DotBtn1, "Click On Activity With Attachments Question 3Dot Btn");
//	}
	
	public void enterComplaintText(String Text) {
		gMob.waitForVisibility(complaintTextBox, driver);
		gMob.clickElement(complaintTextBox, "Click On Complaint Text Box");
		gMob.clearTextBox(complaintTextBox, "Clear Complaint Text Box");
		gMob.sendKeysOnTextBox(complaintTextBox, Text, "Entering Comment for Complaint Text");
	}

	public void enterCauseText(String Text) {
		gMob.waitForVisibility(causeTextBox, driver);
		gMob.clickElement(causeTextBox, "Click On Cause Text Box");
		gMob.clearTextBox(causeTextBox, "Clear Cause Text Box");
		gMob.sendKeysOnTextBox(causeTextBox, Text, "Entering Comment for Cause Text");
		
	}

	public void enterCorrectionText(String Text) {
		gMob.waitForVisibility(correctionTextBox, driver);
		gMob.clickElement(correctionTextBox, "Click On Correction Text Box");
		gMob.clearTextBox(correctionTextBox, "Clear Correction Text Box");
		gMob.sendKeysOnTextBox(correctionTextBox, Text, "Entering Comment for Correction Text");
	}

	public void enterInternalNoteText(String Text) {
		gMob.waitForVisibility(internalNoteTextBox, driver);
		gMob.clickElement(internalNoteTextBox, "Click On Internal Note TextBox");
		gMob.clearTextBox(internalNoteTextBox, "Clear Internal Note TextBox");
		gMob.sendKeysOnTextBox(internalNoteTextBox, Text, "Entering Comment for Internal Note TextBox");
	}
	
	public void enterVoiceRecordMediaDescriptionTxt(String Text) {
		gMob.waitForVisibility(voiceRecordMediaDescriptionTxtBox1, driver);
		gMob.clickElement(voiceRecordMediaDescriptionTxtBox1, "Click On Voice Media Description ");
		gMob.clearTextBox(voiceRecordMediaDescriptionTxtBox1, "Clear Voice Media Description TextBox");
		gMob.sendKeysOnTextBox(voiceRecordMediaDescriptionTxtBox1, Text, "Entering Description for Voice Media Description TextBox");
	}
	
	public String getMediaDescriptionFromAttachmentScreen(String device) throws Exception {
		gMob.swipeToElement(mediaDescriptionTxtBox, "up", driver);
		gMob.waitForVisibility(mediaDescriptionTxtBox, driver);
		String desc = null;
		if (device.equalsIgnoreCase("Android")) {
			desc = gMob.getElementText(mediaDescriptionTxtBox, "text", "Getting Value from Add Media Description");
		} else {
			desc = gMob.getElementText(mediaDescriptionTxtBox, "value", "Getting Value Repair address Text");
		}
		Log.info(desc);
		return desc;
	}

	public boolean isvoiceRecordMediaDescriptionTxtBoxVisible() {
		gMob.waitForVisibility(voiceRecordMediaDescriptionTxtBox, driver);
		return gMob.isElementDisplay(voiceRecordMediaDescriptionTxtBox, "Recorded Voice Media Description is Visible");
	}
	
	public void clickOnPlayRecordedVoiceBtn() throws Exception {
		gMob.swipeToElement(playRecordedVoiceButton, "up", driver);
		gMob.clickElement(playRecordedVoiceButton, "Click On Play Recorded Voice Button");
	}
	
	public boolean isPlayRecordedVoiceBtnVisible() {
		gMob.waitForVisibility(playRecordedVoiceButton, driver);
		return gMob.isElementDisplay(playRecordedVoiceButton, "Play Recorded Voice Button is Visible");
	}
	
	public boolean isDeleteRecordedVoiceBtnVisible() {
		gMob.waitForVisibility(deleteRecordedVoiceButton, driver);
		return gMob.isElementDisplay(deleteRecordedVoiceButton, "Delete Recorded Voice Button is Visible");
	}
	
	public void clickOnInProgresStatusToDoneBtn() throws Exception {
		gMob.swipeToElement(inProgressTaskStatusBtn, "up", driver);
		gMob.clickElement(inProgressTaskStatusBtn, "Click On In-Progress task status Button");
		Thread.sleep(5000);
		gMob.clickElement(doneTaskStatusBtn, "Click On Done Radio Button");
		
		gMob.clickElement(okButtonFromPopup, "Click On OK Button");
	}
	
	
	public String getComplaintText(String device) throws Exception {
		gMob.swipeToElement(getComplaintText, "up", driver);
		gMob.waitForVisibility(getComplaintText, driver);
		String textValue = null;
		if (device.equalsIgnoreCase("Android")) {
			textValue = gMob.getElementText(getComplaintText, "text", "Getting Value from Complaint Text Box");
		} else {
			textValue = gMob.getElementText(getComplaintText, "value", "Getting Value Repair address Text");
		}
		Log.info(textValue);
		return textValue;
	}
	public String getCauseText() throws Exception {
		gMob.swipeToElement(getCauseText, "up", driver);
		gMob.waitForVisibility(getCauseText, driver);
		String textValue = null;
		textValue = gMob.getElementText(getCauseText, "text", "Getting Value from Cause Text Box");
		Log.info(textValue);
		return textValue;
	}
	
	public String getCorrectionText() throws Exception {
		gMob.swipeToElement(getCorrectionText, "up", driver);
		gMob.waitForVisibility(getCorrectionText, driver);
		String text = null;
		text = gMob.getElementText(getCorrectionText, "text", "Getting Value from Correction Text Box");
		Log.info(text);
		return text;
	}
	
	public String getInternalNoteText() throws Exception {
		gMob.swipeToElement(getInternalNoteText, "up", driver);
		gMob.waitForVisibility(getInternalNoteText, driver);
		String textValue = null;
		textValue = gMob.getElementText(getInternalNoteText, "text", "Getting Value from Internal Note Text Box");
		Log.info(textValue);
		return textValue;
	}
	
	public void enterTextOnComplaintTextBox(String descriptionText) throws Exception {
		gMob.swipeToElement(complaintTextBox, "up", driver);
		gMob.clickElement(complaintTextBox, "Click On Complaint Text Box");
		gMob.clearTextBox(complaintTextBox, "Clear Complaint Text Box");
		gMob.sendKeysOnTextBox(complaintTextBox,descriptionText,"Enter Complaint On Complaint Text Box");			
	}
	
	public void enterTextOnCauseTextBox(String descriptionText) throws Exception {
		gMob.swipeToElement(causeTextBox, "up", driver);
		gMob.clickElement(causeTextBox, "Click On Cause Text Box");
		gMob.clearTextBox(causeTextBox, "Clear Cause Text Box");
		gMob.sendKeysOnTextBox(causeTextBox,descriptionText,"Enter Cause On Cause Text Box");			
	}
	public void enterTextOnCorrectionTextBox(String descriptionText) throws Exception {
		gMob.swipeToElement(correctionTextBox, "up", driver);
		gMob.clickElement(correctionTextBox, "Click On Correction Text Box");
		gMob.clearTextBox(correctionTextBox, "Clear Correction Text Box");
		gMob.sendKeysOnTextBox(correctionTextBox,descriptionText,"Enter Correction On Cause Text Box");			
	}
	
	public void enterTextOnInternalNoteTextBox(String descriptionText) throws Exception {
		gMob.swipeToElement(internalNoteTextBox, "up", driver);
		gMob.clickElement(internalNoteTextBox, "Click On Internal Note Text Box");
		gMob.clearTextBox(internalNoteTextBox, "Clear Internal Note Text Box");
		gMob.sendKeysOnTextBox(internalNoteTextBox,descriptionText,"Enter Internal Note On Cause Text Box");			
	}
	public String getCommentText() throws Exception {
		gMob.swipeToElement(getCommentText, "up", driver);
		gMob.waitForVisibility(getCommentText, driver);
		String textValue = null;
		textValue = gMob.getElementText(getCommentText, "text", "Getting Value from Comment Text Box");
		Log.info(textValue);
		return textValue;
	}

	public String getStatusOfClutchRepairActivityText() throws Exception {
		gMob.swipeToElement(getStatusOfnewlyAddedClutchRepairActivity, "up", driver);
		gMob.waitForVisibility(getStatusOfnewlyAddedClutchRepairActivity, driver);
		String textValue = null;
		textValue = gMob.getElementText(getStatusOfnewlyAddedClutchRepairActivity, "text", "Getting Status of Clutch Repair Activity");
		Log.info(textValue);
		return textValue;
	}
	
	public String getStatusOfOilControlActivityText() throws Exception {
		gMob.swipeToElement(getStatusOfnewlyAddedOilControlActivity, "up", driver);
		gMob.waitForVisibility(getStatusOfnewlyAddedOilControlActivity, driver);
		String textValue = null;
		textValue = gMob.getElementText(getStatusOfnewlyAddedOilControlActivity, "text", "Getting Status of Oil Control Activity");
		Log.info(textValue);
		return textValue;
	}
	
	public String getStatusOfLongActivityText() throws Exception {
		gMob.swipeToElement(getStatusOfnewlyAddedLongActivity, "up", driver);
		gMob.waitForVisibility(getStatusOfnewlyAddedLongActivity, driver);
		String textValue = null;
		textValue = gMob.getElementText(getStatusOfnewlyAddedLongActivity, "text", "Getting Status of Long Activity");
		Log.info(textValue);
		return textValue;
	}
	
	public boolean isbrakeRepairActivityOperation1LabelVisible() {
		gMob.waitForVisibility(brakeRepairActivityOperation1, driver);
		return gMob.isElementDisplay(brakeRepairActivityOperation1, "Brake Repair Activity Operation1 is Visible");
	}
	
	public boolean isbrakeRepairActivityOperation2LabelVisible() {
		gMob.waitForVisibility(brakeRepairActivityOperation2, driver);
		return gMob.isElementDisplay(brakeRepairActivityOperation2, "Brake Repair Activity Operation1 is Visible");
	}
	
	public int getTotalDoneStatus() {
		return totalDoneStatus.size();
	}
	
	public boolean isPlannedTimeValueVisibleDifferent() {
		boolean bool=false;
		for(MobileElement ele:totalPlannedTimeText) {
			String PlannedValue=gMob.getElementText(ele, "value", "Getting Value Of Planned Time");
			Log.info("Planned Time: " +PlannedValue);
			if(!gMob.getElementText(ele, "value", "Getting Value Of Planned Time").contains("00:00")) {
				bool=true;
			}else {
				break;
			}			
		}
		return bool;
	}
	
	
	public String getComplaintTextBoxValue() {
		gMob.waitForVisibility(complaintTextBox, driver);
		return gMob.getElementText(complaintTextBox, "value", "Getting Complaint TextBox Value");
	}
	
	public String getCauseTextBoxValue() {
		gMob.waitForVisibility(causeTextBox, driver);
		return gMob.getElementText(causeTextBox, "value", "Getting Cause TextBox Value");
	}
	
	public String getCorrectionTextBoxValue() {
		gMob.waitForVisibility(correctionTextBox, driver);
		return gMob.getElementText(correctionTextBox, "value", "Getting Correction TextBox Value");
	}
	
	public String getInternalNoteTextBoxValue() {
		gMob.waitForVisibility(internalNoteTextBox, driver);
		return gMob.getElementText(internalNoteTextBox, "value", "Getting Internal Note TextBox Value");
	}
	
	public void clickOnNoteIcon() throws Exception {
		gMob.waitForVisibility(noteIcon, driver);
		gMob.clickElement(noteIcon, "Click On Note Icon from Questions");
	}

}
