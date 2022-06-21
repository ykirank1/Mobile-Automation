package com.cnhi.pageObjects;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.auto.framework.base.Log;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class JobCardPage {

	public AppiumDriver<?> driver;
	GenericPage gMob;

	public JobCardPage(AppiumDriver<?> driver, GenericPage ttMob) {
		this.driver = driver;
		this.gMob = ttMob;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

// Creating New Job card Screen Elements

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='createButton']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='main']/following-sibling::XCUIElementTypeButton")
	private MobileElement createButton;

	@AndroidFindBy(xpath = "//android.widget.Image[@text='cv_djc_logo']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='JobCard']")
	private MobileElement jobCardLabel;

	@AndroidFindBy(xpath = "//android.widget.CheckBox/android.widget.Image")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch")
	private MobileElement breakupOrRemoteAppointmentChkBox;

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='customerName']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Customer name']/parent::XCUIElementTypeOther/following-sibling:: XCUIElementTypeOther)[1]")
	private MobileElement customerNameTxtBox;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='customerEmail']/android.widget.EditText")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Customer email']/parent::XCUIElementTypeOther/following-sibling:: XCUIElementTypeOther/XCUIElementTypeTextField)[1]	")
	private MobileElement customerEmailTxtBox;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='customerPhone']/android.widget.EditText")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Customer phone number']/parent::XCUIElementTypeOther/following-sibling:: XCUIElementTypeOther/XCUIElementTypeTextField)[1]")
	private MobileElement customerPhoneTxtBox;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='contactPhone']/android.widget.EditText")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Contact phone number']/parent::XCUIElementTypeOther/following-sibling:: XCUIElementTypeOther/XCUIElementTypeTextField)[1]")
	private MobileElement contactPhoneNumberTxtBox;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='fiscal']/android.widget.EditText")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Fiscal information']/parent::XCUIElementTypeOther/following-sibling:: XCUIElementTypeOther/XCUIElementTypeTextField)[1]")
	private MobileElement fiscalInformationTxtBox;

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='brandName']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Brand']/parent::XCUIElementTypeOther/following-sibling:: XCUIElementTypeOther)[1]")
	private MobileElement brandTxtBox;

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='modelName']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Model']/parent::XCUIElementTypeOther/following-sibling:: XCUIElementTypeOther)[1]")
	private MobileElement modelNameTxtBox;

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='plateNumber']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Plate number']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther)[1]")
	private MobileElement plateNumberTxtBox;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='mileage']/android.widget.EditText")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Mileage']/parent::XCUIElementTypeOther/following-sibling:: XCUIElementTypeOther/XCUIElementTypeTextField)[1]")
	private MobileElement mileageTxtBox;

	@FindBy(xpath = "//input[@name='mileage']")
	private WebElement mileageTxtBoxWeb;

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='pin']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Serial Number']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther)[1]")
	private MobileElement serialNumbertxtBox;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='customerNeed']/android.widget.EditText")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Customer complains']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTextView)[1]")
	private MobileElement customerComplainstxtBox;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='repairAddress']/android.widget.EditText")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Repair address']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTextView)[1]")
	private MobileElement repairAddresstxtBox;

	//@AndroidFindBy(xpath = "//android.widget.Spinner[@resource-id='checklistTemplateId']")
	@AndroidFindBy(xpath = "(//android.view.View/android.widget.Spinner[contains(@text,'checklist')])|(//android.view.View/android.widget.Spinner[contains(@text,'Checklist')])")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Checklist']/parent::XCUIElementTypeOther/following-sibling:: XCUIElementTypeOther)[1]")
	private MobileElement checklistOption;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Next step']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Next step']")
	private MobileElement nextStepButton;

	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='-- No checklist --']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='-- No checklist --']")
	private MobileElement noCheckListOption;

	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Reception Checklist']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Reception Checklist']")
	private MobileElement receptionCheckListOption;


	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Test Reception checklist']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Test Reception Checklist']")
	private MobileElement testReceptionCheckListOption;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='CANCEL']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement checkListCancelBtn;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='OK']")
	private MobileElement checkListOkBtn;

	// -------------------------------------------------------------------------------------------------------------------------------

	// Add new activity screen elements

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='newActivity']/android.widget.EditText")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Add a new activity']/parent::XCUIElementTypeOther/following-sibling:: XCUIElementTypeTextField)[1]")
	private MobileElement addNewActivityTxtBox;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Add']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Add']")
	private MobileElement addBtn;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Back']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	private MobileElement backBtn;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Save']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Save']")
	private MobileElement saveBtn;

	@AndroidFindBy(xpath = "(//android.view.View[@text='ToDo']/following::android.widget.Button)[1]|(//android.widget.TextView[@text='ToDo']/following::android.widget.Button)[1]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='To execute']/parent::XCUIElementTypeOther/parent:: XCUIElementTypeOther/following-sibling::XCUIElementTypeButton)[1]")
	private MobileElement arrowBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ToDo']|//android.view.View[@text='ToDo']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='To execute']")
	private MobileElement toExecuteLabel;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='menuHomeJobcardMainMenu']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	private MobileElement homeBtn;
	
	@AndroidFindBy(xpath = "(//android.view.View[@text='ToDo']/following::android.widget.Button)[5]|(//android.widget.TextView[@text='ToDo']/following::android.widget.Button)[5]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='To execute']/parent::XCUIElementTypeOther/parent:: XCUIElementTypeOther/following-sibling::XCUIElementTypeButton)[1]")
	private MobileElement activity2ArrowBtn;
	
	// -------------------------------------------------------------------------------------------------------------------------------

	// Job Other Information Fields

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='defectCode-0']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@value='Defect Code']/parent:: XCUIElementTypeOther/following-sibling:: XCUIElementTypeOther)[1]")
	private MobileElement defectCodeTxtField;

	@AndroidFindBy(xpath = "//android.widget.Spinner[@resource-id='failure-0']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@value='Failure Code']/parent:: XCUIElementTypeOther/following-sibling:: XCUIElementTypeOther)[1]")
	private MobileElement failureCodeDrpDwn;

	@AndroidFindBy(xpath = "(//android.widget.RadioButton[@text='-- No Failure Code --']/following-sibling::android.widget.RadioButton)[3]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='-- No Failure Code --']/following-sibling::XCUIElementTypeOther)[3]")
	private MobileElement failureCodeThirdOption;

	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='-- No Failure Code --']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='-- No Failure Code --']/following-sibling::XCUIElementTypeOther)[1]")
	private MobileElement failureCodeFirstOption;

	@AndroidFindBy(xpath = "//android.widget.Spinner[@resource-id='failureSeverity-0']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@value='Failure Severity Rate']/parent:: XCUIElementTypeOther/following-sibling:: XCUIElementTypeOther)[1]")
	private MobileElement failureSeverityRateDrpDwn;

	@AndroidFindBy(xpath = "//android.widget.Spinner[@resource-id='payment-0']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@value='Payment Type']/parent:: XCUIElementTypeOther/following-sibling:: XCUIElementTypeOther)[1]")
	private MobileElement paymentTypeDrpDwn;

	@AndroidFindBy(xpath = "//android.widget.Spinner[@resource-id='payment-subcode-0']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@value='Payment Sub Type']/parent:: XCUIElementTypeOther/following-sibling:: XCUIElementTypeOther)[1]")
	private MobileElement paymentSubTypeDrpDwn;
	
	
//	@AndroidFindBy(xpath = "//android.widget.Spinner[@resource-id='failure-0']")
//	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@value='Failure Code']/parent:: XCUIElementTypeOther/following-sibling:: XCUIElementTypeOther)[1]")
//	private MobileElement failureCodeDrpDwn;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Add a new operation']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Add a new operation']")
	private MobileElement addNewOperationBtn;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Add another item']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Add another item']")
	private MobileElement addAnotherItemBtn;

	// Add New Operation Screen Elements
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='operationName']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@value='Operation name']/parent:: XCUIElementTypeOther/following-sibling:: XCUIElementTypeOther)[1]")
	private MobileElement operationNametxtBox;

	@AndroidFindBy(xpath = "(//android.view.View/android.widget.Button)[2]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@value='Parts']/parent:: XCUIElementTypeOther/following-sibling:: XCUIElementTypeButton)[last()]")
	private MobileElement partsPlusIcon;

	@AndroidFindBy(xpath = "//android.view.View/android.widget.EditText[@resource-id='part-0']")
	@iOSXCUITFindBy(xpath = "((//XCUIElementTypeStaticText[@value='Parts']/parent:: XCUIElementTypeOther/following-sibling:: XCUIElementTypeTextField)[last()]/preceding-sibling:: XCUIElementTypeOther)[last()]")
	private MobileElement writePartCodeTxtBox;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Next step']")
	@iOSXCUITFindBy(xpath = "((//XCUIElementTypeStaticText[@name='Duration'])[last()]/parent:: XCUIElementTypeOther/following-sibling:: XCUIElementTypeOther/XCUIElementTypeStaticText)[1]")
	private MobileElement newOpertaionNameText;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='defectCode-1']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@value='Defect Code']/parent:: XCUIElementTypeOther/following-sibling:: XCUIElementTypeOther)[1]")
	private MobileElement defectCode2TxtField;
	
	@AndroidFindBy(xpath = "//android.widget.Spinner[@resource-id='failureSeverity-1']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@value='Failure Severity Rate']/parent:: XCUIElementTypeOther/following-sibling:: XCUIElementTypeOther)[1]")
	private MobileElement failureSeverityRate2DrpDwn;

	@AndroidFindBy(xpath = "//android.widget.Spinner[@resource-id='payment-1']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@value='Payment Type']/parent:: XCUIElementTypeOther/following-sibling:: XCUIElementTypeOther)[1]")
	private MobileElement paymentType2DrpDwn;

	@AndroidFindBy(xpath = "//android.widget.Spinner[@resource-id='payment-subcode-1']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@value='Payment Sub Type']/parent:: XCUIElementTypeOther/following-sibling:: XCUIElementTypeOther)[1]")
	private MobileElement paymentSubType2DrpDwn;
	
	
	@AndroidFindBy(xpath = "//android.widget.Spinner[@resource-id='failure-1']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@value='Failure Code']/parent:: XCUIElementTypeOther/following-sibling:: XCUIElementTypeOther)[1]")
	private MobileElement failureCode2DrpDwn;
	
	@AndroidFindBy(xpath = "(//android.widget.Button[@text='Add a new operation'])[2]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Add a new operation']")
	private MobileElement addNewOperation2Btn;

	// -------------------------------------------------------------------------------------------------------------------------------

	// Add New Item Screen Elements

	@AndroidFindBy(xpath = "//android.widget.Spinner[@resource-id='selectType']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@value='Type']/parent:: XCUIElementTypeOther/following-sibling:: XCUIElementTypeOther)[1]")
	private MobileElement typeDrpDwn;

	@AndroidFindBy(xpath = "//android.widget.Spinner[@resource-id='extraOpeCode']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@value='Code']/parent:: XCUIElementTypeOther/following-sibling::XCUIElementTypeOther)[1]")
	private MobileElement codeDrpDwn;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='description']/android.widget.EditText")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@value='Description']/parent:: XCUIElementTypeOther/following-sibling::XCUIElementTypeTextView)[1]")
	private MobileElement descriptionTxtBox;

	@FindBy(xpath = "//textarea[@class='native-textarea sc-ion-textarea-md']")
	private WebElement descriptionWebTxtBox;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='amount']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@value='Price']/parent:: XCUIElementTypeOther/following-sibling:: XCUIElementTypeTextField)[1]")
	private MobileElement priceTxtBox;

	@FindBy(xpath = "//input[@class='native-input sc-ion-input-md'][@name='amount']")
	private WebElement priceWebTxtBox;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Next step']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='web alert dialog']/XCUIElementTypeOther/XCUIElementTypeOther)[1]")
	private MobileElement firstCodeOption;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='serviceapp-modal-submit']/android.widget.Button[@text='Save']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']/following-sibling::XCUIElementTypeButton[@name='Save']")
	private MobileElement addItemSaveBtn;

	@AndroidFindBy(xpath = "//android.view.View[@text='Extra Operations']/parent::android.view.View")
	@iOSXCUITFindBy(xpath = "((//XCUIElementTypeStaticText[@name='Extra Operations']/parent:: XCUIElementTypeOther)[last()]/following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText)[1]")
	private MobileElement newItemNameText;

	// -------------------------------------------------------------------------------------------------------------------------------

	// Appointment Screen

	@AndroidFindBy(xpath = "//android.view.View[@text='Unassigned activities for breakdown']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Unassigned activities for breakdown']")
	private MobileElement unassignedActivitiesPopup;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='YES']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Yes']")
	private MobileElement yesBtn;

	@AndroidFindBy(xpath = "//android.view.View[@text='Appointment Info']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Appointment Info']")
	private MobileElement appointmentInfoLabel;

	@AndroidFindBy(xpath = "//android.view.View[contains(@text,'Customer : ')]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Customer']/following-sibling:: XCUIElementTypeStaticText)[last()]")
	private MobileElement customerNameInfoText;

	@AndroidFindBy(xpath = "//android.view.View[contains(@text,'Model : ')]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Model']/following-sibling:: XCUIElementTypeStaticText)[last()]")
	private MobileElement modelInfoText;

	@AndroidFindBy(xpath = "//android.view.View[contains(@text,'Reception Date : ')]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Reception Date']/following-sibling:: XCUIElementTypeStaticText)[last()]")
	private MobileElement receptionDateText;

	@AndroidFindBy(xpath = "//android.view.View[contains(@text,'Delivery Date : ')]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Delivery Date']/following-sibling:: XCUIElementTypeStaticText)[last()]")
	private MobileElement deliveryDateText;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='menu']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='menu']")
	private MobileElement menuBtn;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='Job details']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='menu'])[5]")
	private MobileElement jobDetailMenuoption;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='Vehicle details']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='menu'])[6]")
	private MobileElement vehicleDetailMenuoption;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='Checklist']/android.widget.Button")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='menu'])[2]")
	private MobileElement checklistMenuoption;
	
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='Tasks']/android.widget.Button")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='menu'])[3]")
	private MobileElement taskMenuoption;
	
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='Damages']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='menu'])[3]")
	private MobileElement damagesMenuoption;
	
	@AndroidFindBy(xpath = "(//android.view.View/android.widget.Button)[15]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='menu'])[3]")
	private MobileElement trashIconBtn;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Group Test Reception Checklist - Qiestion 01')]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='menu'])[3]")
	private MobileElement groupTestReceptionChecklistLabel;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Remote Activity']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='menu'])[3]")
	private MobileElement remoteActivityLabel;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Are you sure you want to delete the activity Group Test Reception Checklist - Qiestion 01?']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Unassigned activities for breakdown']")
	private MobileElement activityDeletionPopupText;
	
	@AndroidFindBy(xpath = "(//android.view.View/android.widget.Button)[14]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Unassigned activities for breakdown']")
	private MobileElement groupTestReceptionChecklist3DotsBtn;


	
	
	
	
	// -------------------------------------------------------------------------------------------------------------------------------

	// Job Detail Screen Elements

	@AndroidFindBy(xpath = "//android.view.View[@text='Contact Details']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Contact Details']")
	private MobileElement contactDetailLabel;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='customerEmail']/android.widget.EditText")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Customer email']/parent:: XCUIElementTypeOther/following-sibling:: XCUIElementTypeOther/XCUIElementTypeTextField)[1]")
	private MobileElement customerEmailJobDetailTxtBox;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='customerPhone']/android.widget.EditText")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Customer phone number']/parent:: XCUIElementTypeOther/following-sibling:: XCUIElementTypeOther/XCUIElementTypeTextField)[1]")
	private MobileElement customerPhoneNoJobDetailTxtBox;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='customerPhone']/android.widget.EditText")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Contact phone number']/parent:: XCUIElementTypeOther/following-sibling:: XCUIElementTypeOther/XCUIElementTypeTextField)[1]")
	private MobileElement contactPhoneNumberNoJobDetailTxtBox;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='customerMobilePhone']/android.widget.EditText")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Customer mobile phone number']/parent:: XCUIElementTypeOther/following-sibling:: XCUIElementTypeOther/XCUIElementTypeTextField)[1]")
	private MobileElement customerMobilePhoneNumberNoJobDetailTxtBox;

	@AndroidFindBy(xpath = "//android.view.View[@text='Repair address']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Repair address']")
	private MobileElement repairaddressLabel;

	@AndroidFindBy(xpath = "//android.view.View[@text='Repair address']/parent::android.view.View/following-sibling::android.view.View")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Repair address']/following-sibling:: XCUIElementTypeOther/XCUIElementTypeStaticText)[1]")
	private MobileElement repairAddressJobDetailTxtBox;

	@AndroidFindBy(xpath = "//android.view.View[@text='Customer complains']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Customer complains']")
	private MobileElement customerComplainsLabel;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Customer complains']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Customer complains']/following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText)[1]")
	private MobileElement customerComplainsJobDetailTxtBox;
	
    
	@AndroidFindBy(xpath = "//android.widget.Button[@text='NON PRODUCTIVE']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Customer complains']/following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText)[1]")
	private MobileElement nonPrductiveJobDetailsTab;
	
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Auto Test - Cleaning']/parent::android.view.View/following::android.view.View[2]/android.widget.Button")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Customer complains']/following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText)[1]")
	private MobileElement autoTestCleaningRunBtn;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Test - Washing']/parent::android.view.View/following::android.view.View[2]/android.widget.Button")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Customer complains']/following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText)[1]")
	private MobileElement testWashingRunBtn;

	@AndroidFindBy(xpath = "//android.view.View/android.widget.Button[@text='Clock-Out']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Customer complains']/following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText)[1]")
	private MobileElement clockOutActivityBtn;
	
	
	@AndroidFindBy(xpath = "//android.view.View[starts-with(@text,'Auto Test - Cleaning 00:')]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Customer complains']/following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText)[1]")
	private MobileElement autoTestCleaningActivityLabel;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='JOBS']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Customer complains']/following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText)[1]")
	private MobileElement JOBDetailsTab;
	
	// ---------------------------------------------------------------------------------------------------------------------------------

	// Vehicle Detail Screen Elements

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Next step']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Vehicle details']")
	private MobileElement vehicleDetailTab;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Next step']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Vehicle details']")
	private MobileElement vehicleDetailLabel;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Next step']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='FDP Description in dealer language']/following-sibling:: XCUIElementTypeStaticText)[last()]")
	private MobileElement fDPDescriptionInDealerLanguageValue;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Next step']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Model description']/following-sibling:: XCUIElementTypeStaticText)[last()]")
	private MobileElement modelDescriptionValue;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Next step']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='BM']/following-sibling:: XCUIElementTypeStaticText)[last()]")
	private MobileElement bMValue;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Next step']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='FDP English description']/following-sibling:: XCUIElementTypeStaticText)[last()]")
	private MobileElement fDPEnglishDescriptionValue;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Next step']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='FDP code']/following-sibling:: XCUIElementTypeStaticText)[last()]")
	private MobileElement fDPCodeValue;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Next step']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Sold-To Dealer Market']/following-sibling:: XCUIElementTypeStaticText)[last()]")
	private MobileElement soldToDealerMarketValue;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Next step']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Build date']/following-sibling:: XCUIElementTypeStaticText)[last()]")
	private MobileElement buildDateValue;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Next step']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Model Group']/following-sibling:: XCUIElementTypeStaticText)[last()]")
	private MobileElement modelGroupValue;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Next step']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Model Group']/following-sibling:: XCUIElementTypeStaticText)[last()]")
	private MobileElement productionPlantDescriptionValue;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Next step']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='SAP end customer']")
	private MobileElement sAPEndCustomerLabel;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Next step']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='End customer Country']/following-sibling:: XCUIElementTypeStaticText)[last()]")
	private MobileElement endCustomerCountryText;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Next step']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='End customer Name']/following-sibling:: XCUIElementTypeStaticText)[last()]")
	private MobileElement endCustomerNameText;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Next step']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='End customer City']/following-sibling:: XCUIElementTypeStaticText)[last()]")
	private MobileElement endCustomerCityText;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Next step']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='menu']/following-sibling::XCUIElementTypeButton")
	private List<MobileElement> vehicleMenuTabLists;

	// Below Are The Methods Related To Job card
//**************************************************************************************************************************************

	public void clickOnCreateButton() {
		gMob.waitForVisibility(createButton, driver);
		gMob.clickElement(createButton, "Click On Job Create Job Card Button");
	}

	// Create New Job Card Function
	public void clickOnBreakdownOrRemoteAppointmentCheckBox() {
		gMob.waitForVisibility(breakupOrRemoteAppointmentChkBox, driver);
		gMob.clickElement(breakupOrRemoteAppointmentChkBox, "Click On Job Breakup Or Remote Appointment Check Box");
	}

	public void enterCustomerNameOnCustomerNameTextBox(String CustomerName, String device) throws InterruptedException {
		gMob.waitForVisibility(customerNameTxtBox, driver);
		gMob.clickElement(customerNameTxtBox, "Click On Customer Name Text Box");
		gMob.sendKeysOnTextBox(customerNameTxtBox, CustomerName, "Entering Customer Name");
		int xAxis = jobCardLabel.getLocation().x;
		int yAxis = jobCardLabel.getLocation().y;
		System.out.println("xAxis: " + xAxis + " yAxis: " + yAxis);
		gMob.tapByCoordinates(xAxis, xAxis, driver);
	}
	
	public void navigatingToCustomerNameTextBox() throws Exception {
      gMob.swipeToElement(customerNameTxtBox, "down", driver);
      gMob.swipeUpDown("down", driver);
      gMob.waitForVisibility(customerNameTxtBox, driver);
	}

	public void enterEmailOnCustomerEmailTextBox(String Email) {
		gMob.waitForVisibility(customerEmailTxtBox, driver);
		gMob.clickElement(customerEmailTxtBox, "Click On Customer Email Text Box");
		gMob.clearTextBox(customerEmailTxtBox, "Clear Email Text Box");
		gMob.sendKeysOnTextBox(customerEmailTxtBox, Email, "Entering Customer Email");
		gMob.tapByCoordinates(jobCardLabel.getLocation().x, jobCardLabel.getLocation().y, driver);

	}

	public void enterPhoneNoOnCustomerPhoneTextBox(String PhoneNo) {
		gMob.waitForVisibility(customerPhoneTxtBox, driver);
		gMob.clickElement(customerPhoneTxtBox, "Click On Customer Phone Number Text Box");
		gMob.clearTextBox(customerPhoneTxtBox, "Clear Customer Phone Text Box");
		gMob.sendKeysOnTextBox(customerPhoneTxtBox, PhoneNo, "Entering Customer Phone No");
		gMob.tapByCoordinates(jobCardLabel.getLocation().x, jobCardLabel.getLocation().y, driver);

	}

	public void enterContactNoOnContactPhoneTextBox(String ContactNo) throws Exception {
		gMob.swipeToElement(contactPhoneNumberTxtBox, "up", driver);
		gMob.waitForVisibility(contactPhoneNumberTxtBox, driver);
		gMob.clearTextBox(contactPhoneNumberTxtBox, "Clear Contact Phone Number Text Box");
		gMob.clickElement(contactPhoneNumberTxtBox, "Click On Contact Phone Number Text Box");
		gMob.sendKeysOnTextBox(contactPhoneNumberTxtBox, ContactNo, "Entering Contact Phone No");
		gMob.tapByCoordinates(jobCardLabel.getLocation().x, jobCardLabel.getLocation().y, driver);
	}

	public void enterFiscalOnFiscalInformationTextBox(String Fiscal) throws Exception {
		gMob.swipeToElement(fiscalInformationTxtBox, "up", driver);
		gMob.waitForVisibility(fiscalInformationTxtBox, driver);
		gMob.clickElement(fiscalInformationTxtBox, "Click On Fiscal Information Text Box");
		gMob.sendKeysOnTextBox(fiscalInformationTxtBox, Fiscal, "Entering Fiscal Information");
		gMob.tapByCoordinates(jobCardLabel.getLocation().x, jobCardLabel.getLocation().y, driver);
	}

	public void enterBrandOnBrandTextBox(String Brand) throws Exception {
		for (int i = 0; i <= 3; i++) {
			gMob.swipeUpDown("up", driver);
		}
		gMob.swipeToElement(brandTxtBox, "up", driver);
		gMob.waitForVisibility(brandTxtBox, driver);
		gMob.clickElement(brandTxtBox, "Click On Brand Text Box");
		gMob.sendKeysOnTextBox(brandTxtBox, Brand, "Entering Brand");
		gMob.tapByCoordinates(jobCardLabel.getLocation().x, jobCardLabel.getLocation().y, driver);
	}

	public void enterModelOnModelNameTextBox(String ModelName, String device) throws Exception {
		Thread.sleep(3000);
		gMob.MoveDownScreenWithElementAccordingToDevice(modelNameTxtBox, device, driver);
		// gMob.swipeToElement(modelNameTxtBox, "up", driver);
		gMob.waitForVisibility(modelNameTxtBox, driver);
		gMob.clickElement(modelNameTxtBox, "Click On Model Name Text Box");
		gMob.sendKeysOnTextBox(modelNameTxtBox, ModelName, "Entering Model Name");
		gMob.tapByCoordinates(jobCardLabel.getLocation().x, jobCardLabel.getLocation().y, driver);
	}
	public void enterNumberOnPlateNumberTextBox(String PlateNo, String device) throws Exception {
		Thread.sleep(3000);
		// gMob.MoveDownScreenWithElementAccordingToDevice(plateNumberTxtBox, device,
		// driver);
		gMob.swipeToElement(plateNumberTxtBox, "up", driver);
		gMob.waitForVisibility(plateNumberTxtBox, driver);
		gMob.clickElement(plateNumberTxtBox, "Click On Plate Number Text Box");
		gMob.sendKeysOnTextBox(plateNumberTxtBox, PlateNo, "Entering Plate Number");
		Thread.sleep(3000);
		gMob.tapByCoordinates(jobCardLabel.getLocation().x, jobCardLabel.getLocation().y, driver);
	}

	public void enterMileageOnMileageTextBox(String Miles, String device) throws Exception {
		if (device.equals("Android")) {
			Thread.sleep(3000);
			System.out.println(driver.getContextHandles());
			Log.info(driver.getContext());
			Thread.sleep(3000);
			driver.context("WEBVIEW");
			Thread.sleep(3000);
			
			Log.info(driver.getContext());
			
			Thread.sleep(3000);
		    gMob.swipeToWebElement(mileageTxtBoxWeb, driver);
		    switchToWebView();
			//gMob.scrollDown(driver);
			mileageTxtBoxWeb.click();
			mileageTxtBoxWeb.sendKeys(Miles);
			driver.context("NATIVE_APP");
			Log.info(driver.getContext());
		} else {
			gMob.swipeToElement(mileageTxtBox, "up", driver);
			gMob.waitForVisibility(mileageTxtBox, driver);
			gMob.clickElement(mileageTxtBox, "Click On Mileage Text Box");
			Thread.sleep(3000);
			gMob.sendKeysOnTextBox(mileageTxtBox, Miles, "Entering Mileage");
		}
		gMob.tapByCoordinates(jobCardLabel.getLocation().x, jobCardLabel.getLocation().y, driver);
	}

	public void enterSerialNumberOnSerialNumberTextBox(String SerialNo) throws Exception {
		gMob.swipeToElement(serialNumbertxtBox, "up", driver);
		gMob.waitForVisibility(serialNumbertxtBox, driver);
		gMob.clickElement(serialNumbertxtBox, "Click On Serial Number Text Box");
		gMob.sendKeysOnTextBox(serialNumbertxtBox, SerialNo, "Entering Serial Number");
		Thread.sleep(2000);
		gMob.tapByCoordinates(jobCardLabel.getLocation().x, jobCardLabel.getLocation().y, driver);
	}

	public void enterComplainsOnCustomerComplainsTextBox(String Complain) throws Exception {
		gMob.swipeToElement(customerComplainstxtBox, "up", driver);
		gMob.waitForVisibility(customerComplainstxtBox, driver);
		gMob.clickElement(customerComplainstxtBox, "Click On Customer Complains Text Box");
		gMob.sendKeysOnTextBox(customerComplainstxtBox, Complain, "Entering Customer Complains");
		gMob.tapByCoordinates(jobCardLabel.getLocation().x, jobCardLabel.getLocation().y, driver);
	}

	public void enterAddressOnRepairAddressTextBox(String Address) throws Exception {
		gMob.swipeToElement(repairAddresstxtBox, "up", driver);
		gMob.waitForVisibility(repairAddresstxtBox, driver);
		gMob.clickElement(repairAddresstxtBox, "Click On Repair Address Text Box");
		gMob.sendKeysOnTextBox(repairAddresstxtBox, Address, "Entering Repair Address");
		Thread.sleep(2000);
		gMob.tapByCoordinates(jobCardLabel.getLocation().x, jobCardLabel.getLocation().y, driver);
	}

	public void clickOnChecklistOption() throws Exception {
		gMob.swipeToElement(checklistOption, "up", driver);
		gMob.waitForVisibility(checklistOption, driver);
		gMob.clickElement(checklistOption, "Click On Checklist Option");
	}

	public String getCheckListSelectedOption() throws Exception {
		gMob.swipeToElement(checklistOption, "up", driver);
		return checklistOption.getAttribute("name");
	}

	public void clickOnNextStepButton() throws Exception {
		for (int i = 0; i <= 3; i++) {
			gMob.swipeUpDown("up", driver);
		}
		gMob.swipeToElement(nextStepButton, "up", driver);
		gMob.waitForVisibility(nextStepButton, driver);
		gMob.clickElement(nextStepButton, "Click On Next Step Button");
	}

	public void clickOnNoCheckListOption() {
		gMob.waitForVisibility(noCheckListOption, driver);
		gMob.clickElement(noCheckListOption, "Click On No Check List Option");
	}

	public void clickOnReceptionCheckListOption() {
		gMob.waitForVisibility(receptionCheckListOption, driver);
		gMob.clickElement(receptionCheckListOption, "Click On Reception Check List Option");
	}

	public void clickOnTestReceptionCheckListOption() {
		gMob.waitForVisibility(testReceptionCheckListOption, driver);
		gMob.clickElement(testReceptionCheckListOption, "Click On Test Reception Checklist Option");
	}

	

	public void selectCheckListOption(String ChecklistOption) throws Exception {
		if (!getCheckListSelectedOption().contains(ChecklistOption)) {
			if (ChecklistOption.equalsIgnoreCase("Reception Checklist")) {
				clickOnChecklistOption();
				clickOnReceptionCheckListOption();
				clickOnOkButton();
			} else if (ChecklistOption.equalsIgnoreCase("Test Reception checklist")) {
				clickOnChecklistOption();
				clickOnTestReceptionCheckListOption();
				clickOnOkButton();
			} else if (ChecklistOption.contains("No checklist")) {
				clickOnChecklistOption();
				clickOnNoCheckListOption();
				clickOnOkButton();
			} else {
				Log.info("No Check List Selected");
			}
		} else {
			Log.info(ChecklistOption + " option already selected");
		}
	}

	public void clickOnCancelButton() {
		gMob.waitForVisibility(checkListCancelBtn, driver);
		gMob.clickElement(checkListCancelBtn, "Click On Cancel Button");
	}

	public void clickOnOkButton() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println(gMob.WaitingAndReturningElementVisibility(checkListOkBtn));
		gMob.clickElement(checkListOkBtn, "Click On OK Button");

	}

	// -------------------------------------------------------------------------------------------------------------------------------

	// Add new activity screen
	public void enterActivityOnActivityTextBox(String Activity) throws Exception {
		for (int i = 0; i <= 3; i++) {
			gMob.swipeUpDown("up", driver);
		}
		gMob.waitForVisibility(addNewActivityTxtBox, driver);
		gMob.clickElement(addNewActivityTxtBox, "Click On Add activity text box");
		gMob.sendKeysOnTextBox(addNewActivityTxtBox, Activity, "Entering activity");

	}

	public void clickOnAddButton() {
		gMob.waitForVisibility(addBtn, driver);
		gMob.clickElement(addBtn, "Click On Add Button");
	}

	public void clickOnBackButton() {
		gMob.waitForVisibility(backBtn, driver);
		gMob.clickElement(backBtn, "Click On Back Button");
	}

	public void clickOnSaveButton() throws Exception {
		// gMob.scrollToElemet(saveBtn, driver);
		for (int i = 0; i <= 4; i++) {
			gMob.swipeUpDown("up", driver);
		}
		gMob.swipeToElement(saveBtn, "up", driver);
		gMob.waitForVisibility(saveBtn, driver);
		gMob.clickElement(saveBtn, "Click On Save Button");
	}

	public void clickOnArrowButton() throws Exception {
		Thread.sleep(3000);
		for (int i = 0; i <= 3; i++) {
			gMob.swipeUpDown("up", driver);
		}
		gMob.clickElement(arrowBtn, "Click On Arrow Button");
		Thread.sleep(3000);
	}

	public void enterDefectCodeOnActivityTextBox(String Code) throws Exception {
		gMob.waitForVisibility(defectCodeTxtField, driver);
		gMob.clickElement(defectCodeTxtField, "Click On Defect Code text box");
		gMob.sendKeysOnTextBox(defectCodeTxtField, Code, "Entering Defect Code");
		gMob.tapByCoordinates(jobCardLabel.getLocation().x, jobCardLabel.getLocation().y, driver);
	}

	public void selectFailureOptionFromFailureDropDown(String option, String device) throws Exception {
		String xPath = null;
		if (device.equalsIgnoreCase("Android")) {
			xPath = "//android.widget.RadioButton[@text='" + option + "']";
		} else {
			xPath = "(//XCUIElementTypeOther[@name='" + option + "'])[1]";
		}
		gMob.swipeToElement(failureCodeDrpDwn, "up", driver);
		gMob.clickElement(failureCodeDrpDwn, "Click On Failure Code Drop up");
		gMob.waitForVisibility(failureCodeThirdOption, driver);
		int y;
		for (int i = 0; i <= 10; i++) {
			Log.info("Waiting For Element " + i);
			try {
				Thread.sleep(3000);
				MobileElement ele = (MobileElement) driver.findElement(By.xpath(xPath));
				y = ele.getLocation().getY();
				System.out.println("yAxis: " + y);

				if (device.equalsIgnoreCase("Android")) {
					if (y > 700 && y < 1280) {
						Log.info("Failure Code Options Screen Is Visible");
						gMob.clickElement((MobileElement) driver.findElement(By.xpath(xPath)),
								"Click On Failure Code Option");
						clickOnOkButton();
						break;

					} else {

						gMob.swipeUpDown("up", driver);

					}
				} else if (device.equalsIgnoreCase("iOS")) {

					if (y > 250 && y < 400) {
						Log.info("Failure Code Options Screen Is Visible");
						gMob.clickElement((MobileElement) driver.findElement(By.xpath(xPath)),
								"Click On Failure Code Option");
						clickOnOkButton();
						break;

					} else {

						gMob.swipeUpDown("up", driver);

					}
				}
			} catch (Exception e) {
				gMob.swipeUpDown("up", driver);
				if (i > 10) {
					Log.info(e.getMessage());
					e.printStackTrace();
				}

			}

		}

	}

	public void selectFailureSeverityRateFromFailureSeverityRateDropDown(String option, String device)
			throws Exception {
		String xPath = null;
		if (device.equalsIgnoreCase("Android")) {
			xPath = "//android.widget.RadioButton[@text='" + option + "']";
		} else {
			xPath = "(//XCUIElementTypeOther[@name='" + option + "'])[1]";
		}
		gMob.swipeToElement(failureSeverityRateDrpDwn, "up", driver);
		gMob.clickElement(failureSeverityRateDrpDwn, "Click On Failure Severity Rate Drop up");
		gMob.WaitingAndReturningElementVisibilityUsingXpath(xPath, driver);
		gMob.clickElement((MobileElement) driver.findElement(By.xpath(xPath)), "Failure Severity Selected");
		clickOnOkButton();
	}

	public void selectPaymentTypeFromPaymentTypeDropDown(String option, String device) throws Exception {
		String xPath = null;
		if (device.equalsIgnoreCase("Android")) {
			xPath = "//android.widget.RadioButton[@text='" + option + "']";
		} else {
			xPath = "(//XCUIElementTypeOther[@name='" + option + "'])[1]";
		}
		gMob.swipeToElement(paymentTypeDrpDwn, "up", driver);
		gMob.clickElement(paymentTypeDrpDwn, "Click On Payment Type Drop up");
		gMob.WaitingAndReturningElementVisibilityUsingXpath(xPath, driver);
		gMob.clickElement((MobileElement) driver.findElement(By.xpath(xPath)), "Payment Type Selected");
		clickOnOkButton();
		Thread.sleep(5000);
	}

	public void selectPaymentSubTypeFromPaymentTypeDropDown(String option, String device) throws Exception {
		String xPath = null;
		for (int i = 0; i <= 2; i++) {
			gMob.swipeUpDown("up", driver);
		}
		
		if (device.equalsIgnoreCase("Android")) {
			xPath = "//android.widget.RadioButton[@text='" + option + "']";
		} else {
			xPath = "(//XCUIElementTypeOther[@name='" + option + "'])[1]";
		}
		gMob.swipeToElement(paymentSubTypeDrpDwn, "up", driver);
		gMob.clickElement(paymentSubTypeDrpDwn, "Click On Payment Sub Type Drop up");
		gMob.WaitingAndReturningElementVisibilityUsingXpath(xPath, driver);
		gMob.clickElement((MobileElement) driver.findElement(By.xpath(xPath)), "Payment Sub Type Selected");
		clickOnOkButton();
	}
	public void clickOnAddNewOperationBtn(String device) throws Exception {
		Thread.sleep(6000);
		for (int i = 0; i <= 3; i++) {
			gMob.swipeUpDown("up", driver);
		}
		gMob.swipeToElement(addNewOperationBtn, "up", driver);
		// gMob.scrollToElemet(addNewOperationBtn, driver);
		Thread.sleep(5000);
		gMob.clickElement(addNewOperationBtn, "Click On Add A New Operation Button");
	}

	public void clickOnAddAnotherItemBtn() throws Exception {
		Thread.sleep(6000);
		// gMob.scrollToElemet(addAnotherItemBtn, driver);
		gMob.swipeToElement(addAnotherItemBtn, "up", driver);
		gMob.clickElement(addAnotherItemBtn, "Click On Add Another Item Button");
	}

	public boolean isToExecuteStatusVisible() {
		return gMob.isElementVisibleWithinGivenTime(toExecuteLabel, 100, driver);

	}

	// -------------------------------------------------------------------------------------------------------------------------------

	// Add New Operation Screen Functions
	public void enterOperationNameTextBox(String operatinName, String device) throws Exception {
		Thread.sleep(5000);
		gMob.waitForVisibility(operationNametxtBox, driver);
		gMob.clickElement(operationNametxtBox, "Click On Operaion Name Text Box");
		gMob.sendKeysOnTextBox(operationNametxtBox, operatinName, "Entering Operation Name");
		Thread.sleep(5000);
		if (device.equalsIgnoreCase("Android")) {
			gMob.tapByCoordinates(236, 147, driver);
		} else {
			gMob.tapByCoordinates(193, 51, driver);
		}

	}

	public void clickOnPartsPlusIcon() throws Exception {
		gMob.swipeToElement(partsPlusIcon, "up", driver);
		gMob.waitForVisibility(partsPlusIcon, driver);
		gMob.clickElement(partsPlusIcon, "Click On Parts Plus Icon");
	}

	public void enterPartCodeOnPartCodeTextBox(String PartCode, String device) throws Exception {
		String xPath = null;
		if (device.equalsIgnoreCase("Android")) {
			xPath = "//android.view.View[@text='" + PartCode + "']";
		} else {
			xPath = "(//XCUIElementTypeOther[@name='" + PartCode + "'])[1]";
		}
		gMob.swipeToElement(writePartCodeTxtBox, "up", driver);
		gMob.waitForVisibility(writePartCodeTxtBox, driver);
		gMob.clickElement(writePartCodeTxtBox, "Click On Part Code text box");
		gMob.clickElement(writePartCodeTxtBox, "Click On Part Code text box");
		gMob.sendKeysOnTextBox(writePartCodeTxtBox, PartCode, "Entering Part Code");
		if (device.equalsIgnoreCase("Android")) {
			// gMob.swipeUpDown("up", driver);
		} else {
			gMob.scrollDown(driver);
		}

		gMob.WaitingAndReturningElementVisibilityUsingXpath(xPath, driver);
		gMob.clickElement((MobileElement) driver.findElement(By.xpath(xPath)), "Part Code Selected");
		if (device.equalsIgnoreCase("Android")) {
			gMob.tapByCoordinates(236, 147, driver);
		} else {
			gMob.tapByCoordinates(193, 51, driver);
		}

	}

	public boolean isNewOperationCreated(String NewOperation) throws InterruptedException {
		gMob.waitForVisibility(newOpertaionNameText, driver);
		String newOperationText = gMob.getElementText(newOpertaionNameText, "value", "Getting New Operation Name");
		return newOperationText.contains(NewOperation);

	}

	// -------------------------------------------------------------------------------------------------------------------------------

	// Add New Item Screen Functions
	public void selectTypeFromTypeDropDown(String option, String device) throws Exception {
		String xPath = null;
		if (device.equalsIgnoreCase("Android")) {
			xPath = "//android.widget.RadioButton[@text='" + option + "']";
		} else {
			xPath = "(//XCUIElementTypeOther[@name='" + option + "'])[1]";
		}
		gMob.swipeToElement(typeDrpDwn, "up", driver);
		gMob.clickElement(typeDrpDwn, "Click On Type Drop up");
		gMob.WaitingAndReturningElementVisibilityUsingXpath(xPath, driver);
		Thread.sleep(5000);
		gMob.clickElement((MobileElement) driver.findElement(By.xpath(xPath)), "Type Selected");
//		int xAxis = typeDrpDwn.getLocation().x;
//		int yAxis = typeDrpDwn.getLocation().y;
//		System.out.println("xAxis: " + xAxis + " yAxis: " + yAxis);
//		gMob.tapByCoordinates(xAxis, xAxis, driver);
		clickOnOkButton();
	}

	public void selectCodeFromCodeDropDown(String option, String device) throws Exception {
		Thread.sleep(3000);
		String xPath = null;
		if (device.equalsIgnoreCase("Android")) {
			xPath = "//android.widget.RadioButton[@text='" + option + "']";
		} else {
			xPath = "(//XCUIElementTypeOther[@name='" + option + "'])[1]";
		}
		gMob.clickElement(codeDrpDwn, "Click On Code Drop up");
		Thread.sleep(3000);
		gMob.WaitingAndReturningElementVisibilityUsingXpath(xPath, driver);
		driver.findElement(By.xpath(xPath)).click();
		clickOnOkButton();
	}

	public void enterDescriptionOnDescriptionTextBox(String Description, String device) throws InterruptedException {
		gMob.waitForVisibility(descriptionTxtBox, driver);
		if (device.equalsIgnoreCase("Android")) {
			Thread.sleep(3000);
			System.out.println(driver.getContextHandles());
			Log.info(driver.getContext());
			driver.context("WEBVIEW");
			Thread.sleep(3000);
			Log.info(driver.getContext());
			descriptionWebTxtBox.click();
			descriptionWebTxtBox.sendKeys(Description);
			driver.context("NATIVE_APP");
			Log.info(driver.getContext());
		} else {
			gMob.clickElement(descriptionTxtBox, "Click On Description Text Box");
			Thread.sleep(5000);
			gMob.sendKeysOnTextBox(descriptionTxtBox, "SERVICE PROGRAM", "Entering Description");
		}

	}

	public void enterPriceOnPriceTextBox(String Price, String device) throws InterruptedException {
		gMob.waitForVisibility(priceTxtBox, driver);
		if (device.equalsIgnoreCase("Android")) {
			Thread.sleep(3000);
			System.out.println(driver.getContextHandles());
			Log.info(driver.getContext());
			driver.context("WEBVIEW");
			Thread.sleep(3000);
			Log.info(driver.getContext());
			priceWebTxtBox.click();
			priceWebTxtBox.sendKeys(Price);
			driver.context("NATIVE_APP");
			Log.info(driver.getContext());
		} else {
			gMob.clickElement(priceTxtBox, "Click On Price Text Box");
			gMob.sendKeysOnTextBox(priceTxtBox, Price, "Entering Price");
		}

	}

	public boolean isNewTypeCreated(String Type, String device) {
		gMob.waitForVisibility(newItemNameText, driver);
		if (device.equalsIgnoreCase("Android")) {
			String newTypeText = gMob.getElementText(newItemNameText, "text", "Getting New Operation Name");
			return newTypeText.contains(Type);
		} else {
		String newTypeText = gMob.getElementText(newItemNameText, "value", "Getting New Operation Name");
		return newTypeText.contains(Type);
	}

	}

	public void clickOnAddItemSaveBtn() {
		gMob.waitForVisibility(addItemSaveBtn, driver);
		gMob.clickElement(addItemSaveBtn, "Click On Add Item Save Btn");
	}

	// -------------------------------------------------------------------------------------------------------------------------------

//	// Appointment Screen
	public void SelectCreatedAppointment(String customerName,String device) throws Exception {

		String xPath = null;
		
		for (int i = 0; i <= 15; i++) {
			gMob.swipeUpDown("up", driver);
		}

		gMob.isElementDisplay(createButton, "Appointment List Screen Visible");
		for (int i = 0; i < 25; i++) {
			try {
				Log.info("Waiting for the appointment to visible: " + i);
				String currentDate = gMob.getCurrentDate("MM/dd/yyyy");
				if (device.equalsIgnoreCase("Android")) {
					xPath = "(//android.widget.Button[contains(@text,'Appointment Prepared')][contains(@text,'"+customerName+"')])[last()]";
				} else {
					xPath = "(//XCUIElementTypeLink[@name='Appointment Prepared']/following-sibling::XCUIElementTypeLink[contains(@name,'"
							+ customerName + "')])[last()]";
				}
				MobileElement ele = (MobileElement) driver.findElement(By.xpath(xPath));
				Log.info("dynamic xPath of the Appointment " + xPath);
				if (gMob.isElementVisibleWithinGivenTime(ele, 1, driver)) {
					gMob.clickElement(ele, "Select New Created Job");
					break;
				} else {
					// gMob.scrollDown(driver);
					//gMob.swipeUpDown("up", driver);
				gMob.swipeToMobileElement(ele, driver);
				}
			} catch (Exception e) {
				// gMob.scrollDown(driver);
				gMob.swipeUpDown("up", driver);
				MobileElement ele = (MobileElement) driver.findElement(By.xpath(xPath));
				gMob.swipeToMobileElement(ele, driver);
				Log.info(e.getMessage());
				Log.info("Element Not Visible");
				if (i >= 19) {
					e.printStackTrace();
					throw new Exception();

				}
			}
		}
	}
	
	public void SelectCreatedAppointmentTest(String customerName, String device) throws Exception {

        String xPath = null;

        gMob.isElementDisplay(createButton, "Appointment List Screen Visible");

        for (int i = 0; i < 25; i++) {

            try {

                Log.info("Waiting for the appointment to visible: " + i);

                if (device.equalsIgnoreCase("Android")) {

                    System.out.println(driver.getContextHandles());

                    Log.info(driver.getContext());

                    driver.context("WEBVIEW");

                    Thread.sleep(3000);

                    Log.info(driver.getContext());

                    xPath = "(//ion-label[text()='Appointment Prepared']/parent::ion-chip/parent::div/following-sibling::p[contains(text(),'"

                            + customerName + "')]";

                    WebElement webEle= driver.findElement(By.xpath(xPath));

                    gMob.swipeToWebElement(webEle, driver);

                    if(gMob.isWebElementVisibleWithXpath(xPath, driver)) {

                    webEle.click();    

                    driver.context("NATIVE_APP");

                    break;

                    }else {

                        gMob.swipeToWebElement(webEle, driver);
                    }

                } else {

                    xPath = "(//XCUIElementTypeLink[@name='Appointment Prepared']/following-sibling::XCUIElementTypeLink[contains(@name,'"

                            + customerName + "')])[last()]";

                    MobileElement ele = (MobileElement) driver.findElement(By.xpath(xPath));

                    if (gMob.isElementVisibleWithinGivenTime(ele, 1, driver)) {

                        gMob.clickElement(ele, "Select New Created Job");

                        break;

                    } else {

                        gMob.MoveDownScreenAccordingToDevice(device, driver);

                    }

                }

            } catch (Exception e) {

                gMob.MoveDownScreenAccordingToDevice(device, driver);

                Log.info(e.getMessage());

                Log.info("Element Not Visible");

                if (i >= 19) {

                    e.printStackTrace();

                    throw new Exception();

                }

            }

        }

    }	

	public String getCreatedAppointmentData(String customerName,String device) throws Exception {
		String xPath = null;
		String data = null;
		gMob.isElementDisplay(createButton, "Appointment List Screen Visible");
		for (int i = 0; i < 20; i++) {
			try {
				Log.info("Waiting for the appointment to visible: " + i);
				String currentDate = gMob.getCurrentDate("MM/dd/yyyy");
				if (device.equalsIgnoreCase("Android")) {
					xPath = "(//android.widget.Button[contains(@text,'Appointment Prepared')][contains(@text,'"+customerName+"')])[last()]";
				} else {
					xPath = "(//XCUIElementTypeLink[contains(@name,'Appointment Prepared')][contains(@name,'"+customerName+"')])[last()]";
				}
				MobileElement ele = (MobileElement) driver.findElement(By.xpath(xPath));
				Log.info("visibility" + ele.isDisplayed());
				if (gMob.isElementVisibleWithinGivenTime(ele, 1, driver)) {
					data = gMob.getElementText(ele, "name", "Getting New Created Appointment Data ");
					Log.info("1222112" + data);
					break;
				} else {
					// gMob.scrollDown(driver);
					gMob.swipeUpDown("up", driver);
				}
			} catch (Exception e) {
				// gMob.scrollDown(driver);
				gMob.swipeUpDown("up", driver);
				Log.info(e.getMessage());
				Log.info("Element Not Visible");
				if (i >= 19) {
					e.printStackTrace();
					throw new Exception();

				}
			}
		}
		return data;

	}

	
	public void SelectReceivedAppointment(String customerName, String device) throws Exception {

		for (int i = 0; i <= 15; i++) {
			gMob.swipeUpDown("up", driver);
		}

        String xPath = null;

        gMob.isElementDisplay(createButton, "Appointment List Screen Visible");

        for (int i = 0; i < 20; i++) {

            try {

                Log.info("Waiting for the appointment to visible: " + i);

                String currentDate = gMob.getCurrentDate("MM/dd/yyyy");

                if (device.equalsIgnoreCase("Android")) {

                    xPath = "(//android.widget.Button[contains(@text,'Received')][contains(@text,'" + customerName

                            + "')])[last()]";
                } else {

                    xPath = "(//XCUIElementTypeLink[contains(@name,'Received')][contains(@name,'" + customerName

                            + "')])[last()]";
                }

                MobileElement ele = (MobileElement) driver.findElement(By.xpath(xPath));

                if (gMob.isElementVisibleWithinGivenTime(ele, 1, driver)) {

                    gMob.clickElement(ele, "Select New Created Job");

                    break;

                } else {

                    gMob.MoveDownScreenAccordingToDevice(device, driver);

                }

            } catch (Exception e) {

                gMob.MoveDownScreenAccordingToDevice(device, driver);

                Log.info(e.getMessage());

                Log.info("Element Not Visible");

                if (i >= 19) {

                    e.printStackTrace();

                    throw new Exception();

                }

            }

        }

    }

	public boolean isUnassignedActivitiesPopupVisible() throws InterruptedException {
		return gMob.isElementVisibleWithinGivenTime(unassignedActivitiesPopup, 3000, driver);
	}

	public void clickOnYesButton() {
		gMob.waitForVisibility(yesBtn, driver);
		gMob.clickElement(yesBtn, "Click On Yes Button");
	}

	public boolean isAppointmentInfoLabelVisible() throws InterruptedException {
		return gMob.isElementVisibleWithinGivenTime(appointmentInfoLabel, 30, driver);
	}

	public String getCustomerInfoFromAppointmentInfo(String device) {
		gMob.waitForVisibility(customerNameInfoText, driver);
		String customerName;
		if (device.equalsIgnoreCase("Android")) {
			customerName = gMob.getElementText(customerNameInfoText, "text", "Getting Customer Name Text");
			customerName = customerName.split(":")[1].trim();

		} else {
			customerName = gMob.getElementText(customerNameInfoText, "name", "Getting Customer Name Text");
		}
		Log.info(customerName);
		return customerName;

	}

	public String getModelInfoFromAppointmentInfo(String device) {
		gMob.waitForVisibility(modelInfoText, driver);
		String modelName;
		if (device.equalsIgnoreCase("Android")) {
			modelName = gMob.getElementText(modelInfoText, "text", "Getting Model Name Text");
			modelName = modelName.split(":")[1].trim();

		} else {
			modelName = gMob.getElementText(modelInfoText, "name", "Getting Customer Name Text");
		}
		Log.info(modelName);
		return modelName;

	}

	public String getReceptionDateFromAppointmentInfo(String device) {
		gMob.waitForVisibility(receptionDateText, driver);
		String receptionDate;
		if (device.equalsIgnoreCase("Android")) {
			receptionDate = gMob.getElementText(receptionDateText, "text", "Getting Reception Date Text");
			receptionDate = receptionDate.split(":")[1].trim();

		} else {
			receptionDate = gMob.getElementText(receptionDateText, "name", "Getting Reception Date Text");
		}
		Log.info(receptionDate);
		return receptionDate;

	}

	public String getDeliveryDateFromAppointmentInfo(String device) {
		gMob.waitForVisibility(deliveryDateText, driver);
		String deliveryDate;
		if (device.equalsIgnoreCase("Android")) {
			deliveryDate = gMob.getElementText(deliveryDateText, "text", "Getting Delivery Date Text");
			deliveryDate = deliveryDate.split(":")[1].trim();

		} else {
			deliveryDate = gMob.getElementText(deliveryDateText, "name", "Getting Delivery Date Text");
		}
		Log.info(deliveryDate);
		return deliveryDate;

	}

	public void clickOnMenuButton() {
		gMob.waitForVisibility(menuBtn, driver);
		gMob.clickElement(menuBtn, "Click On Menu Button");
	}
	

	

	public void clickOnJobDetailMenuOption() {
		gMob.waitForVisibility(jobDetailMenuoption, driver);
		gMob.clickElement(jobDetailMenuoption, "Click On Job Detail Button");
	}

	public void clickOnVehicleDetailMenuOption() {
		gMob.waitForVisibility(vehicleDetailMenuoption, driver);
		gMob.clickElement(vehicleDetailMenuoption, "Click On Vehicle Detail Button");
	}

	public void clickOnchecklistMenuOption() {
		gMob.waitForVisibility(checklistMenuoption, driver);
		gMob.clickElement(checklistMenuoption, "Click On Check List Button");
	}

	public void clickOnTaskMenuOption() {
		gMob.waitForVisibility(taskMenuoption, driver);
		gMob.clickElement(taskMenuoption, "Click On Task Button");
		
	}
	
	public void clickOnDamagesMenuOption() {
		gMob.waitForVisibility(damagesMenuoption, driver);
		gMob.clickElement(damagesMenuoption, "Click On Damages Button");
	}
	
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='show']/android.widget.Button")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Service App']//XCUIElementTypeButton)[1]")
	private MobileElement imageAddedEyeIcon;
	// -------------------------------------------------------------------------------------------------------------------------------

	// Job Detail Screen

	public boolean isContactDetailLabelVisible() throws Exception {
		gMob.swipeToElement(contactDetailLabel, "up", driver);
		return gMob.isElementVisibleWithinGivenTime(contactDetailLabel, 100, driver);
	}

	public String getCustomerEmailValueFromJobDetail(String device) throws Exception {
		gMob.swipeToElement(customerEmailJobDetailTxtBox, "up", driver);
		gMob.waitForVisibility(customerEmailJobDetailTxtBox, driver);
		String customerEmailValue = null;
		if (device.equalsIgnoreCase("Android")) {
			customerEmailValue = gMob.getElementText(customerEmailJobDetailTxtBox, "text", "Getting Value Name Text");
		} else {
			customerEmailValue = gMob.getElementText(customerEmailJobDetailTxtBox, "value", "Getting Value Name Text");
		}
		Log.info(customerEmailValue);
		return customerEmailValue;
	}

	public String getCustomerPhoneNoValueFromJobDetail(String device) throws Exception {
		gMob.swipeToElement(customerPhoneNoJobDetailTxtBox, "up", driver);
		gMob.waitForVisibility(customerPhoneNoJobDetailTxtBox, driver);
		String PhoneNo = null;
		if (device.equalsIgnoreCase("Android")) {
			PhoneNo = gMob.getElementText(customerPhoneNoJobDetailTxtBox, "text", "Getting Value Customer Phone Text");
		} else {
			PhoneNo = gMob.getElementText(customerPhoneNoJobDetailTxtBox, "value", "Getting Value Customer Phone Text");
		}
		Log.info(PhoneNo);
		return PhoneNo;
	}

	public String getContactPhoneNumberNoFromJobDetail(String device) throws Exception {
		gMob.swipeToElement(contactPhoneNumberNoJobDetailTxtBox, "up", driver);
		gMob.waitForVisibility(contactPhoneNumberNoJobDetailTxtBox, driver);
		String contactPhoneNo = null;
		if (device.equalsIgnoreCase("Android")) {
			contactPhoneNo = gMob.getElementText(contactPhoneNumberNoJobDetailTxtBox, "text", "Getting Value Contact Phone Number Text");
		} else {
			contactPhoneNo = gMob.getElementText(contactPhoneNumberNoJobDetailTxtBox, "value", "Getting Value Contact Phone Number Text");
		}
		Log.info(contactPhoneNo);
		return contactPhoneNo;
	}

	public boolean isRepairAddressLabelVisible() throws Exception {
		gMob.swipeToElement(repairaddressLabel, "up", driver);
		return gMob.isElementVisibleWithinGivenTime(repairaddressLabel, 100, driver);
	}

	public String getRepairAddressFromJobDetail(String device) throws Exception {
		gMob.swipeToElement(repairAddressJobDetailTxtBox, "up", driver);
		gMob.waitForVisibility(repairAddressJobDetailTxtBox, driver);
		String repairAddress = null;
		if (device.equalsIgnoreCase("Android")) {
			repairAddress = gMob.getElementText(repairAddressJobDetailTxtBox, "text", "Getting Value Repair address Text");
		} else {
			repairAddress = gMob.getElementText(repairAddressJobDetailTxtBox, "value", "Getting Value Repair address Text");
		}
		Log.info(repairAddress);
		return repairAddress;
	}

	public boolean isCustomerComplainsLabelVisible() throws Exception {
		gMob.swipeToElement(repairAddressJobDetailTxtBox, "up", driver);
		gMob.waitForVisibility(repairAddressJobDetailTxtBox, driver);
		return gMob.isElementVisibleWithinGivenTime(customerComplainsLabel, 100, driver);
	}

	public String getCustomerComplainEmailFromJobDetail(String device) throws Exception {
		gMob.swipeToElement(customerComplainsJobDetailTxtBox, "up", driver);
		gMob.waitForVisibility(customerComplainsJobDetailTxtBox, driver);
		String customerComplain = null;
		if (device.equalsIgnoreCase("Android")) {
			customerComplain = gMob.getElementText(customerComplainsJobDetailTxtBox, "text", "Getting Value Customer Complain Text");
		} else {
			customerComplain = gMob.getElementText(customerComplainsJobDetailTxtBox, "value", "Getting Value Customer Complain Text");
		}

		Log.info(customerComplain);
		return customerComplain;
	}

	// ---------------------------------------------------------------------------------------------------------------------------------

	// Vehicle Detail Screen

	public void clickVehicleDetailTab() {
		gMob.waitForVisibility(vehicleDetailTab, driver);
		gMob.clickElement(vehicleDetailTab, "Click On Vehicle Tab");
	}

	public boolean isVehicleDetailLabelVisible() throws Exception {
		gMob.waitForVisibility(vehicleDetailLabel, driver);
		return gMob.isElementVisibleWithinGivenTime(vehicleDetailLabel, 100, driver);
	}

	public String getFDPDescriptionInDealerLanguageValueFromJobDetail() throws Exception {
		gMob.waitForVisibility(fDPDescriptionInDealerLanguageValue, driver);
		String value = gMob.getElementText(fDPDescriptionInDealerLanguageValue, "name",
				"Getting FDP Description In Dealer Language Value");
		Log.info(value);
		return value;
	}

	public String getModelDescriptionValueFromJobDetail() throws Exception {
		gMob.waitForVisibility(modelDescriptionValue, driver);
		String value = gMob.getElementText(modelDescriptionValue, "name", "Getting Model Description Value");
		Log.info(value);
		return value;
	}

	public String getBMValyeValueFromJobDetail() throws Exception {
		gMob.waitForVisibility(bMValue, driver);
		String value = gMob.getElementText(bMValue, "name", "Getting BM Value");
		Log.info(value);
		return value;
	}

	public String getfDPEnglishDescriptionValueFromJobDetail() throws Exception {
		gMob.waitForVisibility(fDPEnglishDescriptionValue, driver);
		String value = gMob.getElementText(fDPEnglishDescriptionValue, "name", "Getting FDP English Description Value");
		Log.info(value);
		return value;
	}

	public String getfDPCodeValueFromJobDetail() throws Exception {
		gMob.waitForVisibility(fDPCodeValue, driver);
		String value = gMob.getElementText(fDPCodeValue, "name", "Getting FDP Code Value");
		Log.info(value);
		return value;
	}

	public String getSoldToDealerMarketValueFromJobDetail() throws Exception {
		gMob.waitForVisibility(soldToDealerMarketValue, driver);
		String value = gMob.getElementText(soldToDealerMarketValue, "name", "Getting Sold To Dealer Market Value");
		Log.info(value);
		return value;
	}

	public String getbuildDateValuetFromJobDetail() throws Exception {
		gMob.waitForVisibility(buildDateValue, driver);
		String value = gMob.getElementText(buildDateValue, "name", "Getting Build Date Value");
		Log.info(value);
		return value;
	}

	public String getmodelGroupValueFromJobDetail() throws Exception {
		gMob.waitForVisibility(modelGroupValue, driver);
		String value = gMob.getElementText(modelGroupValue, "name", "Getting Model Group Value");
		Log.info(value);
		return value;
	}

	public String getProductionPlantDescriptionValueFromJobDetail() throws Exception {
		gMob.waitForVisibility(productionPlantDescriptionValue, driver);
		String value = gMob.getElementText(productionPlantDescriptionValue, "name",
				"Getting Production Plant Description Value");
		Log.info(value);
		return value;
	}

	public boolean isSAPEndCustomerLabelVisible() throws Exception {
		gMob.waitForVisibility(sAPEndCustomerLabel, driver);
		return gMob.isElementVisibleWithinGivenTime(sAPEndCustomerLabel, 100, driver);
	}

	public boolean isEndCustomerCountryTextVisibleEmpty() throws Exception {
		gMob.waitForVisibility(endCustomerCountryText, driver);
		return gMob.getElementText(endCustomerCountryText, "value", "Getting Last Value Of End Customer Country")
				.equals(":");
	}

	public boolean isEndCustomerNameTextVisibleEmpty() throws Exception {
		gMob.waitForVisibility(endCustomerNameText, driver);
		return gMob.getElementText(endCustomerNameText, "value", "Getting Last Value Of End Customer Name").equals(":");
	}

	public boolean isEndCustomerCityTextVisibleEmpty() throws Exception {
		gMob.waitForVisibility(endCustomerCityText, driver);
		return gMob.getElementText(endCustomerCityText, "value", "Getting Last Value Of End Customer City").equals(":");
	}
	public void switchToWebView() throws InterruptedException {
		Thread.sleep(3000);
		Set<String> view = driver.getContextHandles();
		System.out.println(view);
		Thread.sleep(3000);
		String str = driver.getContext();
		System.out.println(str);
		if (!str.contains("WEBVIEW")) {
			Thread.sleep(3000);
			Log.info("jhghvkjf");
			Log.info((String) view.toArray()[1]);
			driver.context((String) view.toArray()[1]);
			Thread.sleep(3000);
			String str1 = driver.getContext();
			System.out.println(str1);
		}

	}
	public boolean isTrashIconVisible() throws Exception {
		
		gMob.waitForVisibility(trashIconBtn, driver);
		return gMob.isElementDisplay(trashIconBtn, "Trash Icon Button Is Visible");
		//gMob.swipeToElement(trashIconBtn, "up", driver);
		//return gMob.isElementVisibleWithinGivenTime(trashIconBtn, 100, driver);
		
	}
	public boolean isgroupTestReceptionChecklistLabelVisible() throws Exception {
		
		gMob.waitForVisibility(groupTestReceptionChecklistLabel, driver);
		return gMob.isElementDisplay(groupTestReceptionChecklistLabel, "Group Test Reception Checklist Label Is Visible");
	}
	
	public boolean isremoteActivityLabelVisible() throws Exception {
		gMob.waitForVisibility(remoteActivityLabel, driver);
		return gMob.isElementDisplay(remoteActivityLabel, "Remote Activity Label Is Visible");
	}
	
	public boolean isactivityDeletionPopupTextVisible() throws Exception {
		gMob.waitForVisibility(activityDeletionPopupText, driver);
		return gMob.isElementDisplay(activityDeletionPopupText, "Activity Deletion PopUp Text Is Visible");
	}
	
	public void clickOnDeleteActivity() throws Exception {
		for (int i = 0; i <= 3; i++) {
			gMob.swipeUpDown("up", driver);
		}
		gMob.swipeToElement(trashIconBtn, "up", driver);
		gMob.waitForVisibility(trashIconBtn, driver);
		gMob.clickElement(trashIconBtn, "Click On Trash Button");
		isactivityDeletionPopupTextVisible();
		clickOnOkButton();
		Thread.sleep(5000);
	}
	
	public void clickOnGroupTestReceptionQuestion3DotsBtn() throws Exception {
		for (int i = 0; i <= 2; i++) {
			gMob.swipeUpDown("up", driver);
		}
		gMob.swipeToElement(groupTestReceptionChecklist3DotsBtn, "up", driver);
		gMob.waitForVisibility(groupTestReceptionChecklist3DotsBtn, driver);
		gMob.clickElement(groupTestReceptionChecklist3DotsBtn, "Click On Group Test Reception Checklist three dot Button");
		gMob.clickElement(imageAddedEyeIcon, "Click On Image Added Eye Icon Button");
	}

	public void switchToNativeView() {
		String str = driver.getContext();
		System.out.println(str);
		if (!str.contains("NATIVE_APP")) {
			driver.context("NATIVE_APP");
		}
	}

	public void SelectJobCardValidationPendingAppointment(String customerName, String device) throws Exception {

		for (int i = 0; i <= 15; i++) {
			gMob.swipeUpDown("up", driver);
		}

        String xPath = null;

        gMob.isElementDisplay(createButton, "Appointment List Screen Visible");

        for (int i = 0; i < 20; i++) {

            try {

                Log.info("Waiting for the appointment to visible: " + i);

                String currentDate = gMob.getCurrentDate("MM/dd/yyyy");

                if (device.equalsIgnoreCase("Android")) {

                    xPath = "(//android.widget.Button[contains(@text,'Jobcard Validation Pending')][contains(@text,'" + customerName

                            + "')])[last()]";
                } else {

                    xPath = "(//XCUIElementTypeLink[contains(@name,'Jobcard Validation Pending')][contains(@name,'" + customerName

                            + "')])[last()]";
                }

                MobileElement ele = (MobileElement) driver.findElement(By.xpath(xPath));

                if (gMob.isElementVisibleWithinGivenTime(ele, 1, driver)) {

                    gMob.clickElement(ele, "Select Newly Created JobCard Validation Pending");

                    break;

                } else {

                    gMob.MoveDownScreenAccordingToDevice(device, driver);

                }

            } catch (Exception e) {

                gMob.MoveDownScreenAccordingToDevice(device, driver);

                Log.info(e.getMessage());

                Log.info("Element Not Visible");

                if (i >= 19) {

                    e.printStackTrace();

                    throw new Exception();

                }

            }

        }

    }	
	
	
	
	public void SelectRepairingAppointment(String customerName, String device) throws Exception {

		for (int i = 0; i <= 15; i++) {
			gMob.swipeUpDown("up", driver);
		}

        String xPath = null;

        gMob.isElementDisplay(createButton, "Appointment List Screen Visible");

        for (int i = 0; i < 20; i++) {

            try {

                Log.info("Waiting for the appointment to visible: " + i);

                String currentDate = gMob.getCurrentDate("MM/dd/yyyy");

                if (device.equalsIgnoreCase("Android")) {

                    xPath = "(//android.widget.Button[contains(@text,'Repairing')][contains(@text,'" + customerName

                            + "')])[last()]";
                } else {

                    xPath = "(//XCUIElementTypeLink[contains(@name,'Repairing')][contains(@name,'" + customerName

                            + "')])[last()]";
                }

                MobileElement ele = (MobileElement) driver.findElement(By.xpath(xPath));

                if (gMob.isElementVisibleWithinGivenTime(ele, 1, driver)) {

                    gMob.clickElement(ele, "Select New Created Job");

                    break;

                } else {

                    gMob.MoveDownScreenAccordingToDevice(device, driver);

                }

            } catch (Exception e) {

                gMob.MoveDownScreenAccordingToDevice(device, driver);

                Log.info(e.getMessage());

                Log.info("Element Not Visible");

                if (i >= 19) {

                    e.printStackTrace();

                    throw new Exception();

                }

            }

        }

    }

	public void clickOnHomeButton() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println(gMob.WaitingAndReturningElementVisibility(homeBtn));
		gMob.clickElement(homeBtn, "Click On Home Button");

	}
	
	public void clickOnNonPrductiveJobDetailsTabButton() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println(gMob.WaitingAndReturningElementVisibility(nonPrductiveJobDetailsTab));
		gMob.clickElement(nonPrductiveJobDetailsTab, "Click On Non Prductive JobDetails Tab Button");

	}
	
	
	
	public void clickOnAutoTestCleaningRunButton() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println(gMob.WaitingAndReturningElementVisibility(autoTestCleaningRunBtn));
		gMob.clickElement(autoTestCleaningRunBtn, "Click On AutoTest Cleaning Button");

	}
	public void clickOnJOBDetailsTabButton() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println(gMob.WaitingAndReturningElementVisibility(JOBDetailsTab));
		gMob.clickElement(JOBDetailsTab, "Click On AutoTest Cleaning Button");

	}
	
	
	public void clickOnTestWashingRunButton() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println(gMob.WaitingAndReturningElementVisibility(testWashingRunBtn));
		gMob.clickElement(testWashingRunBtn, "Click On Test Washing Button");

	}

	public void clickOnclockOutActivityButton() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println(gMob.WaitingAndReturningElementVisibility(clockOutActivityBtn));
		gMob.clickElement(clockOutActivityBtn, "Click On Clock Out Activity Button");

	}
	
	public boolean isautoTestCleaningActivityLabelVisible() throws Exception {
		gMob.waitForVisibility(autoTestCleaningActivityLabel, driver);
		return gMob.isElementDisplay(autoTestCleaningActivityLabel, "AutoTest Cleaning Activity Label Is Visible");
	}
	
	public void clickOnActivity2ArrowButton() throws Exception {
		Thread.sleep(3000);
		for (int i = 0; i <= 3; i++) {
			gMob.swipeUpDown("up", driver);
		}
		gMob.clickElement(activity2ArrowBtn, "Click On Activity 2 Arrow Button");
		Thread.sleep(3000);
	}
	
	public void enterDefectCodeOnActivity2TextBox(String Code) throws Exception {
		gMob.waitForVisibility(defectCode2TxtField, driver);
		gMob.clickElement(defectCode2TxtField, "Click On Defect Code text box");
		gMob.sendKeysOnTextBox(defectCode2TxtField, Code, "Entering Defect Code");
		gMob.tapByCoordinates(jobCardLabel.getLocation().x, jobCardLabel.getLocation().y, driver);
	}
	

	public void selectFailureOptionFromFailure2DropDown(String option, String device) throws Exception {
		String xPath = null;
		if (device.equalsIgnoreCase("Android")) {
			xPath = "//android.widget.RadioButton[@text='" + option + "']";
		} else {
			xPath = "(//XCUIElementTypeOther[@name='" + option + "'])[1]";
		}
		gMob.swipeToElement(failureCode2DrpDwn, "up", driver);
		gMob.clickElement(failureCode2DrpDwn, "Click On Failure Code Drop up");
		gMob.waitForVisibility(failureCode2DrpDwn, driver);
		int y;
		for (int i = 0; i <= 10; i++) {
			Log.info("Waiting For Element " + i);
			try {
				Thread.sleep(3000);
				MobileElement ele = (MobileElement) driver.findElement(By.xpath(xPath));
				y = ele.getLocation().getY();
				System.out.println("yAxis: " + y);

				if (device.equalsIgnoreCase("Android")) {
					if (y > 700 && y < 1280) {
						Log.info("Failure Code Options Screen Is Visible");
						gMob.clickElement((MobileElement) driver.findElement(By.xpath(xPath)),
								"Click On Failure Code Option");
						clickOnOkButton();
						break;

					} else {

						gMob.swipeUpDown("up", driver);

					}
				} else if (device.equalsIgnoreCase("iOS")) {

					if (y > 250 && y < 400) {
						Log.info("Failure Code Options Screen Is Visible");
						gMob.clickElement((MobileElement) driver.findElement(By.xpath(xPath)),
								"Click On Failure Code Option");
						clickOnOkButton();
						break;

					} else {

						gMob.swipeUpDown("up", driver);

					}
				}
			} catch (Exception e) {
				gMob.swipeUpDown("up", driver);
				if (i > 10) {
					Log.info(e.getMessage());
					e.printStackTrace();
				}

			}

		}

	}

	public void selectFailureSeverityRateFromFailureSeverityRate2DropDown(String option, String device)
			throws Exception {
		String xPath = null;
		if (device.equalsIgnoreCase("Android")) {
			xPath = "//android.widget.RadioButton[@text='" + option + "']";
		} else {
			xPath = "(//XCUIElementTypeOther[@name='" + option + "'])[1]";
		}
		gMob.swipeToElement(failureSeverityRate2DrpDwn, "up", driver);
		gMob.clickElement(failureSeverityRate2DrpDwn, "Click On Failure Severity Rate Drop up");
		gMob.WaitingAndReturningElementVisibilityUsingXpath(xPath, driver);
		gMob.clickElement((MobileElement) driver.findElement(By.xpath(xPath)), "Failure Severity Selected");
		clickOnOkButton();
	}

	public void selectPaymentTypeFromPaymentType2DropDown(String option, String device) throws Exception {
		String xPath = null;
		for (int i = 0; i <= 3; i++) {
			gMob.swipeUpDown("up", driver);
		}
		if (device.equalsIgnoreCase("Android")) {
			xPath = "//android.widget.RadioButton[@text='" + option + "']";
		} else {
			xPath = "(//XCUIElementTypeOther[@name='" + option + "'])[1]";
		}
		gMob.swipeToElement(paymentType2DrpDwn, "up", driver);
		gMob.clickElement(paymentType2DrpDwn, "Click On Payment Type Drop up");
		gMob.WaitingAndReturningElementVisibilityUsingXpath(xPath, driver);
		gMob.clickElement((MobileElement) driver.findElement(By.xpath(xPath)), "Payment Type Selected");
		clickOnOkButton();
		Thread.sleep(5000);
	}

	public void selectPaymentSubTypeFromPaymentType2DropDown(String option, String device) throws Exception {
		String xPath = null;
//		for (int i = 0; i <= 2; i++) {
//			gMob.swipeUpDown("up", driver);
//		}
		
		if (device.equalsIgnoreCase("Android")) {
			xPath = "//android.widget.RadioButton[@text='" + option + "']";
		} else {
			xPath = "(//XCUIElementTypeOther[@name='" + option + "'])[1]";
		}
		gMob.swipeToElement(paymentSubType2DrpDwn, "up", driver);
		gMob.clickElement(paymentSubType2DrpDwn, "Click On Payment Sub Type Drop up");
		gMob.WaitingAndReturningElementVisibilityUsingXpath(xPath, driver);
		gMob.clickElement((MobileElement) driver.findElement(By.xpath(xPath)), "Payment Sub Type Selected");
		clickOnOkButton();
	}
	
	public void clickOnAddNewOperation2Btn(String device) throws Exception {
		Thread.sleep(6000);
		for (int i = 0; i <= 3; i++) {
			gMob.swipeUpDown("up", driver);
		}
		gMob.swipeToElement(addNewOperation2Btn, "up", driver);
		// gMob.scrollToElemet(addNewOperationBtn, driver);
		Thread.sleep(5000);
		gMob.clickElement(addNewOperation2Btn, "Click On Add A New Operation Button");
	}
	
	public void SelectJobcardValidationPendingAppointment(String customerName, String device) throws Exception {

		String xPath = null;

		gMob.isElementDisplay(createButton, "Appointment List Screen Visible");
		for (int i = 0; i < 20; i++) {
			try {
				Log.info("Waiting for the appointment to visible: " + i);
				String currentDate = gMob.getCurrentDate("MM/dd/yyyy");
				if (device.equalsIgnoreCase("Android")) {
					xPath = "(//android.widget.Button[contains(@text,'Jobcard Validation Pending')][contains(@text,'" + customerName
							+ "')])[last()]";
				} else {
					xPath = "(//XCUIElementTypeLink[contains(@name,'Jobcard Validation Pending')][contains(@name,'" + customerName
							+ "')])[last()]";
				}
				MobileElement ele = (MobileElement) driver.findElement(By.xpath(xPath));

				if (gMob.isElementVisibleWithinGivenTime(ele, 1, driver)) {
					gMob.clickElement(ele, "Select New Created Job");
					break;
				} else {
					gMob.MoveDownScreenAccordingToDevice(device, driver);
				}
			} catch (Exception e) {
				gMob.MoveDownScreenAccordingToDevice(device, driver);
				Log.info(e.getMessage());
				Log.info("Element Not Visible");
				if (i >= 19) {
					e.printStackTrace();
					throw new Exception();

				}
			}
		}
	}
}


