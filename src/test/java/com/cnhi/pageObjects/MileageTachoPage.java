package com.cnhi.pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.auto.framework.base.Log;

import com.auto.framework.base.Log;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class MileageTachoPage {

	public AppiumDriver<?> driver;
	GenericPage gMob;

	public MileageTachoPage(AppiumDriver<?> driver, GenericPage ttMob) {
		this.driver = driver;
		this.gMob = ttMob;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='mileage']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Mileage + Tacho']")
	private MobileElement mileageTachoTab;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='engineHours']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Engine hours']")
	private MobileElement engineHoursTab;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='Group Test Reception Checklist']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Group Test Reception Checklist']")
	private MobileElement groupTestReceptionTab;

//	@AndroidFindBy(xpath = "//android.view.View[@text='Mileage + Tacho']/parent:: android.view.View/android.view.View[2]/android.view.View[@resource-id='jobcard-mandatoryfield-mileage-photo-phone']")
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='jobcard-mandatoryfield-mileage-photo-phone']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Mileage + Tacho']/parent:: XCUIElementTypeOther/following-sibling:: XCUIElementTypeButton)[1]")
	private MobileElement mileageTachoCameraIcon;

	//@AndroidFindBy(xpath = "//android.view.View[@text='Engine hours']/parent:: android.view.View/android.view.View[2]/android.view.View[@resource-id='jobcard-mandatoryfield-engineHours-photo-phone']")
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='jobcard-mandatoryfield-engineHours-photo-phone']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Engine hours']/parent:: XCUIElementTypeOther/following-sibling:: XCUIElementTypeButton)[1]")
	private MobileElement engineHoursCameraIcon;
	
	@AndroidFindBy(xpath = "(//android.view.View[@text='General Attachments']/parent:: android.view.View/android.view.View[2]/android.view.View/android.widget.Button)[1]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='General Attachments']/parent:: XCUIElementTypeOther/following-sibling:: XCUIElementTypeButton)[1]")
	private MobileElement generalAttachmentsCameraIcon;
	
	@AndroidFindBy(xpath = "(//android.view.View[@text='General Attachments']/parent:: android.view.View/android.view.View[2]/android.view.View/android.widget.Button)[2]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='General Attachments']/parent:: XCUIElementTypeOther/following-sibling:: XCUIElementTypeButton)[2]")
	private MobileElement generalAttachmentsMicroIcon;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='jobcard-mandatoryfield-engineHours-input']/android.widget.EditText")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Engine hours']/parent:: XCUIElementTypeOther/following-sibling:: XCUIElementTypeTextField)[1]")
	private MobileElement engineHoursTextField;

	//@AndroidFindBy(xpath = "//android.view.View[@text='Mileage + Tacho']/parent:: android.view.View/android.view.View[2]/android.view.View[@resource-id='jobcard-mandatoryfield-mileage-photo-phone']/android.view.View[@text='*']")
	@AndroidFindBy(xpath = "//android.view.View[@text='*']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='*']")
	private List<MobileElement> mileageTachoCameraStarIcon;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='OK']")
	private MobileElement okButtonFromPopup;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='gallery']/android.widget.Button")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Service App']//XCUIElementTypeButton)[last()]")
	private MobileElement addImageIcon;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.android.documentsui:id/icon_thumb']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[contains(@name,'Photo')])[1]")
	private MobileElement photoImage;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='show']/android.widget.Button")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Service App']//XCUIElementTypeButton)[1]")
	private MobileElement imageAddedEyeIcon;

	//@AndroidFindBy(xpath = "(//android.view.View)[4]")
	@AndroidFindBy(xpath = "//android.view.View [@resource-id='app']/android.view.View/android.view.View/android.view.View/android.view.View")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Service App']//XCUIElementTypeButton")
	private List<MobileElement> cameraAllIcons;

	@AndroidFindBy(xpath = "(//android.view.View/android.widget.Image[@text='#'])[1]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name='#'])[1]")
	private MobileElement photoAddedImage;

	@AndroidFindBy(xpath = "//android.view.View/android.widget.Button[@text='Delete']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Delete']")
	private MobileElement deleteImageBtn;

	@AndroidFindBy(xpath = "//android.view.View/android.widget.Image[@text='#']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='#']")
	private List<MobileElement> totalPhotoAddedImage;

	@AndroidFindBy(xpath = "//android.view.View/android.widget.Button[@text='Delete']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Delete']")
	private MobileElement imageDeleteBtn;

	//@AndroidFindBy(xpath = "(//android.view.View/android.widget.Button)[4]")
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='closeModal']/android.widget.Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='web dialog']//XCUIElementTypeButton")
	private MobileElement closeAddImageScreenIcon;

	@AndroidFindBy(xpath = "(//android.view.View[@text='Qiestion 01']/parent:: android.view.View/android.view.View[5])|(//android.view.View[@text='Test Checkbox']/parent:: android.view.View/android.view.View[5])")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Qiestion 01']/parent:: XCUIElementTypeOther/following-sibling:: XCUIElementTypeButton)[1]")
	private MobileElement question13DotsBtn;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='comment']/android.widget.Button")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Service App']//XCUIElementTypeButton)[5]")
	private MobileElement commentIcon;
	
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='addOperation']/android.widget.Button")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Service App']//XCUIElementTypeButton)[5]")
	private MobileElement plusIcon;
	
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='gallery']/android.widget.Button")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Service App']//XCUIElementTypeButton)[3]")
	private MobileElement addImageFromQuesionsIcon;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='recordvoice']/android.widget.Button")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Service App']//XCUIElementTypeButton)[4]")
	private MobileElement recorderIcon;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='serviceapp-audiorec-start']/android.widget.Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Voice Note']/parent:: XCUIElementTypeOther/following-sibling::XCUIElementTypeOther/XCUIElementTypeButton")
	private MobileElement recordedBtn;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='serviceapp-audiorec-stop']/android.widget.Button")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Voice Note']/parent:: XCUIElementTypeOther/following-sibling::XCUIElementTypeOther/XCUIElementTypeButton)[2]")
	private MobileElement recordedStopeBtn;

	@AndroidFindBy(xpath = "//android.view.View[starts-with(@text,'audio_')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'audio')]")
	private MobileElement recordedVoice;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='closeModal']/android.widget.Button")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Voice Note']/parent:: XCUIElementTypeOther/following-sibling:: XCUIElementTypeButton)[1]")
	private MobileElement closeRecordedScreenIcon;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='serviceapp-comment-textarea']/android.widget.EditText")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Comment']/parent:: XCUIElementTypeOther/following-sibling:: XCUIElementTypeTextView")
	private MobileElement commentTextbox;

	//@AndroidFindBy(xpath = "//android.widget.Button[@text='SUBMIT']")
	@AndroidFindBy(xpath = "(//android.widget.Button[@text='Submit'])|(//android.widget.Button[@text='SUBMIT'])")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Submit']")
	private MobileElement submitBtn;

	//@AndroidFindBy(xpath = "//android.widget.Button[@text='CANCEL']")
	@AndroidFindBy(xpath = "(//android.widget.Button[@text='Cancel'])|(//android.widget.Button[@text='CANCEL'])")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement cancelBtn;

	@AndroidFindBy(xpath = "(//android.view.View[@text='Question 02']/parent:: android.view.View/android.view.View[8])|(//android.view.View[@text='Test Status']/parent:: android.view.View/android.view.View[8])")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Question 02']/parent:: XCUIElementTypeOther/following-sibling:: XCUIElementTypeButton)[1]")
	private MobileElement question23DotsBtn;

	@AndroidFindBy(xpath = "(//android.view.View[@text='Question 03']/parent:: android.view.View/android.view.View[11])|(//android.view.View[@text='Test Slider']/parent:: android.view.View/android.view.View[11])")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Question 03']/parent:: XCUIElementTypeOther/following-sibling:: XCUIElementTypeButton)[1]")
	private MobileElement question33DotsBtn;

	@AndroidFindBy(xpath = "(//android.view.View[@text='Question 04']/parent:: android.view.View/android.view.View[14])|(//android.view.View[@text='Test Switch']/parent:: android.view.View/android.view.View[14])")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Question 04']/parent:: XCUIElementTypeOther/following-sibling:: XCUIElementTypeButton)[1]")
	private MobileElement question43DotsBtn;

	//@AndroidFindBy(xpath = "//android.view.View/android.widget.SeekBar[@text='8.0']")
	@AndroidFindBy(xpath = "//android.view.View/android.widget.SeekBar")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSlider")
	private MobileElement sliderQuestion3;

	//@AndroidFindBy(xpath = "//android.view.View/android.widget.SeekBar[@text='8.0']")
	@AndroidFindBy(xpath = "(//android.view.View[contains(@text,'/ 10')])[2]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'/ 10')]")
	private MobileElement sliderValueQuestion3;

	@AndroidFindBy(xpath = "//android.widget.RadioButton[contains(@resource-id,'success')]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Question 02']/parent:: XCUIElementTypeOther/following-sibling:: XCUIElementTypeOther/XCUIElementTypeOther)[1]")
	private MobileElement greenRadioBtnFromQuestion2;

	@AndroidFindBy(xpath = "//android.view.View/android.widget.RadioButton[@text='Yes']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Yes']")
	private MobileElement yesRadioBtn;

	@AndroidFindBy(xpath = "//android.widget.CheckBox[contains(@resource-id,'switch')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch")
	private MobileElement switcherFromQuestion4;

	//@AndroidFindBy(xpath = "(//android.view.View/android.widget.Button)[4]")
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='menuBackButton']/parent::android.view.View/following-sibling::android.view.View[2]/android.view.View[3]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[4]")
	private MobileElement checkinIcon;
	
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='menuBackButton']/parent::android.view.View/following-sibling::android.view.View[2]/android.view.View[4]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[4]")
	private MobileElement checkinActivity;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='jobcard-signatory-name']/android.widget.EditText")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Customer name']/parent:: XCUIElementTypeOther/following-sibling:: XCUIElementTypeTextField)[1]")
	private MobileElement customerNameTextBox;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='signatureCanvas']/android.widget.Image")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Signature']/parent:: XCUIElementTypeOther/following-sibling:: XCUIElementTypeTextField)[1]")
	private MobileElement signatureTextBox;

	@AndroidFindBy(xpath = "//android.widget.CheckBox[@resource-id='jobcard-signature-tcchecked']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Terms and Conditions']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther/XCUIElementTypeSwitch)[1]")
	private MobileElement termConditionRadioButton;

	@AndroidFindBy(xpath = "//android.widget.CheckBox[@resource-id='jobcard-signature-mrchecked']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='By selecting this check box you give consent for marketing activities as described in the Privacy Notice - MARKETING THIRD PARTIES']/parent::XCUIElementTypeOther/following:: XCUIElementTypeSwitch)[1]")
	private MobileElement privacyNoticeRadioButton;

	@AndroidFindBy(xpath = "//android.view.View/android.widget.CheckBox[@text='Customer not present']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name='Customer not present']")
	private MobileElement customerNotPresentRadioButton;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='Close reception']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Close reception']")
	private MobileElement closeReceptionButton;

	@AndroidFindBy(xpath = "//android.view.View[@text='Mileage text has not been filled in. Mileage photo has not been filled in']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Mileage text has not been filled in. Mileage photo has not been filled in']")
	private MobileElement mileageTextHasNotBeenFilledText;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='Mileage photo has not been filled in.']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Mileage photo has not been filled in.']")
	private MobileElement mileagePhotoHasNotBeenFilledText;
	
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='jobcard']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='You confirm that you had read and accepted the Terms and Conditions']")
	private MobileElement readTermConditionText;
	
	
	@FindBy(xpath = "//android.widget.Button[@text='OK']")
	private WebElement commentGreenDot;

	@FindBy(xpath = "//ion-button[@id='comment']//*[name()='svg']")
	private WebElement commentGreenColor;

	@FindBy(xpath = "//ion-button[@id='show']//*[name()='svg']")
	private WebElement eyeGreenColor;

	@FindBy(xpath = "//ion-button[@id='recordvoice']//*[name()='svg']")
	private WebElement microphoneGreenColor;
	
	@FindBy(xpath = "//ion-button[@id='addOperation'][@disabled]")
	private WebElement disabledPlusIcon;
	
	@FindBy(xpath = "//ion-button[@id='addOperation'][@enabled]")
	private WebElement enabledPlusIcon;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='OK']")
	private MobileElement OkBtn;
	
	
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_button']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='You confirm']")
	private MobileElement allowPermission;
	
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='photocamera']/android.widget.Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='You confirm that you had read and accepted the Terms and Conditions']")
	private MobileElement photoCamera;
	
	@AndroidFindBy(xpath = "(//android.view.View/android.widget.Button)[3]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='You confirm that you had read and accepted the Terms and Conditions']")
	private MobileElement captureCameraphoto;
	
	@AndroidFindBy(xpath = "(//android.view.View/android.widget.Button)[2]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='You confirm that you had read and accepted the Terms and Conditions']")
	private MobileElement attachCameraphoto;
	
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='show']/android.widget.Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='You confirm that you had read and accepted the Terms and Conditions']")
	private MobileElement showEyeIcon;
	
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='serviceapp-modal-submit']/android.widget.Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Submit']")
	private MobileElement submitClientSignatureBtn;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='serviceapp-modal-cancel']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement cancelClientSignatureBtn;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Add a media description']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement addMediaDescriptionLabel;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='description']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement enterMediaDescriptionTextField;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='SAVE']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement saveMediaDescriptionBtn;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='CANCEL']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement cancelMediaDescriptionBtn;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='This question has been added to the list of activities']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='This question has been added to the list of activities']")
	private MobileElement thisQuestionHasBeenAddedText;
	
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='videocamera']/android.widget.Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement videoCameraBtn;
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.android.camera2:id/shutter_button']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement startVideoRecordingBtn;
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.android.camera2:id/shutter_button']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement stopVideoRecordingBtn;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id='com.android.camera2:id/done_button']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement attachVideoRecordingBtn;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Activity to be clocked']/parent::android.view.View/android.view.View[1]/following::android.widget.Button[1]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Service App']//XCUIElementTypeButton)[last()-2]")
	private MobileElement addANewRunIcon;	
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement addANewActivity3DotsBtn;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Activity to be clocked']/parent::android.view.View/android.view.View[3]/android.widget.Spinner")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement newActivityDropdown;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Luci - Lato anteriore destro']/parent::android.view.View/android.view.View[3]/android.widget.Spinner")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement secondActivityDropdown;
	
	
	@AndroidFindBy(xpath = "(//android.view.View[contains(@text,'Activity to be clocked')])[1]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement activityClockIcon;

	@AndroidFindBy(xpath = "//android.view.View[@text='In progress']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement inProgressStatusBtn;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Activity to be clocked']/parent::android.view.View/android.view.View[6]/android.view.View[2]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement clockedTimeDuration;
	
	@AndroidFindBy(xpath = "(//android.view.View[contains(@text,'Clocked time :')]/preceding:: android.widget.Button)[last()-2]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Clocked time :']/preceding:: XCUIElementTypeButton)[last()-1]")
	private MobileElement addANewActivity3DotsAfterClickRunBtn;
	
	@AndroidFindBy(xpath = "(//android.view.View[contains(@text,'Off line Activity')])[2]/parent::android.view.View/android.view.View[2]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Clocked time :']/preceding:: XCUIElementTypeButton)[last()-1]")
	private MobileElement offlineActivity3DotsAfterClickRunBtn;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Luci - Lato anteriore destro']/parent::android.view.View/android.view.View[1]/following::android.widget.Button[1]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Clocked time :']/preceding:: XCUIElementTypeButton)[last()-1]")
	private MobileElement offlineSecondActivityRunBtn;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Luci - Lato anteriore destro']/parent::android.view.View/android.view.View[1]/following::android.widget.Button[1]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Clocked time :']/preceding:: XCUIElementTypeButton)[last()-1]")
	private MobileElement offlineSecondActivity3DotsAfterClickRunBtn;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Off line Activity']/parent::android.view.View/android.view.View[3]/android.widget.Spinner")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement OfflineActivityDropdown;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Luci - Lato anteriore destro']/parent::android.view.View/android.view.View[3]/android.widget.Spinner")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement luciLatoActivityDropdown;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Long Activity']/parent::android.view.View/android.view.View[3]/android.widget.Spinner")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement LongActivityDropdown;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Clutch Repair']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement newlyAddedClutchRepairActivity;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Oil Control']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement newlyAddedOilControlActivity;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Oil Control']/parent::android.view.View/android.view.View[3]/android.widget.Spinner")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement getStatusOfnewlyAddedOilControlActivity;
	
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Clutch Repair']/parent::android.view.View/android.view.View[3]/android.widget.Spinner")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement getStatusOfnewlyAddedClutchRepairActivity;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Long Activity']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement newlyAddedLongActivity;
	
	
	@AndroidFindBy(xpath = "//android.view.View[starts-with(@text,'Activity 1 - 00:00:0')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement activity1Clocking;
	
	@AndroidFindBy(xpath = "//android.view.View[starts-with(@text,'Activity 2 - 00:0')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement activity2Clocking;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Activity 1']/parent::android.view.View/android.view.View[6]/android.view.View[2]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement activity1ClockedTimeDuration;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Activity 2']/parent::android.view.View/android.view.View[6]/android.view.View[2]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement activity2ClockedTimeDuration;
	
	//*********************************Test Reception Check List Options Elements*******************************************************

		@AndroidFindBy(xpath = "(//android.widget.RadioButton[contains(@resource-id,'success')])[1]")
		
	    //@AndroidFindBy(xpath = "//android.view.View[@text='Interno anteriore sinistro']/following::android.view.View[3]/android.view.View/android.widget.RadioButton[contains(@resource-id,'success')]")
	    @iOSXCUITFindBy(xpath = "((//XCUIElementTypeStaticText[@name='Interno anteriore sinistro']/following:: XCUIElementTypeButton)[1]/following-sibling:: XCUIElementTypeOther/XCUIElementTypeOther)[1]")
		private MobileElement internoAnterioreSinistroGreenRdioBtn;
		
		@AndroidFindBy(xpath = "//android.view.View[@text='Interno anteriore sinistro']/following::android.view.View[1]")
		@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Interno anteriore sinistro']/following:: XCUIElementTypeButton)[1]")
		private MobileElement internoAnterioreSinistro3DotBtn;
		
		//@AndroidFindBy(xpath = "//android.view.View[@text='Esterno anteriore sinistro']/following::android.view.View[3]/android.view.View/android.widget.RadioButton[1][@resource-id='jobcard-checklist-result-79909-success']/android.view.View")
		@AndroidFindBy(xpath = "(//android.widget.RadioButton[contains(@resource-id,'success')])[2]")
		@iOSXCUITFindBy(xpath = "((//XCUIElementTypeStaticText[@name='Esterno anteriore sinistro']/following:: XCUIElementTypeButton)[1]/following-sibling:: XCUIElementTypeOther/XCUIElementTypeOther)[1]")
		private MobileElement esternoAnterioreSinistroGreenRdioBtn;
		
		@AndroidFindBy(xpath = "//android.view.View[@text='Esterno anteriore sinistro']/following::android.view.View[1]")
		@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Esterno anteriore sinistro']/following:: XCUIElementTypeButton)[1]")
		private MobileElement esternoAnterioreSinistro3DotBtn;
		
		@AndroidFindBy(xpath = "//android.view.View[@text='Spazzole tergicristallo anteriori']/following-sibling::android.view.View[2]/android.view.View/android.view.View[1]")
		@iOSXCUITFindBy(xpath = "((//XCUIElementTypeStaticText[@name='Spazzole tergicristallo anteriori']/following:: XCUIElementTypeButton)[1]/following-sibling:: XCUIElementTypeOther/XCUIElementTypeOther[@name='OK'])[1]")
		private MobileElement spazzoleTergicristalloAnterioriOkBtn;
		
		@AndroidFindBy(xpath = "//android.view.View[@text='Parabrezza anteriore']/following-sibling::android.view.View[2]/android.view.View/android.view.View[1]")
		//@AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id='ion-rb-8']")
		@iOSXCUITFindBy(xpath = "((//XCUIElementTypeStaticText[@name='Spazzole tergicristallo anteriori']/following:: XCUIElementTypeButton)[1]/following-sibling:: XCUIElementTypeOther/XCUIElementTypeOther[@name='OK'])[1]")
		private MobileElement parabrezzaAnterioreOkBtn;
		
		@AndroidFindBy(xpath = "//android.view.View[@text='Perdite esterne visibili']/following-sibling::android.view.View[2]/android.view.View/android.view.View[1]")
		//@AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id='ion-rb-10']")
		@iOSXCUITFindBy(xpath = "((//XCUIElementTypeStaticText[@name='Perdite esterne visibili']/following:: XCUIElementTypeButton)[1]/following-sibling:: XCUIElementTypeOther/XCUIElementTypeOther[@name='OK'])[1]")
		private MobileElement perditeEsterneVisibiliOkBtn;
		
		//@AndroidFindBy(xpath = "//android.view.View/android.widget.CheckBox[@resource-id='jobcard-checklist-result-79849-switch']")
		@AndroidFindBy(xpath = "(//android.widget.CheckBox[contains(@resource-id,'ion-tg')])[1]")
		@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Lato anteriore destro']/following:: XCUIElementTypeSwitch)[1]")
		private MobileElement latoAnterioreDestroToggleBtn;
		
		//@AndroidFindBy(xpath = "//android.view.View/android.widget.CheckBox[@resource-id='jobcard-checklist-result-79850-switch']")
		@AndroidFindBy(xpath = "(//android.widget.CheckBox[contains(@resource-id,'ion-tg')])[2]")
		@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Anteriore sinistro']/following:: XCUIElementTypeSwitch)[1]")
		private MobileElement anterioreSinistroToggleBtn;
		
		@AndroidFindBy(xpath = "(//android.view.View/android.widget.SeekBar[@text='0.0'])[1]")
		//@AndroidFindBy(xpath = "//android.view.View[@text='Olio motore']/following-sibling::android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.SeekBar")
		@iOSXCUITFindBy(xpath = "((//XCUIElementTypeStaticText[@name='Olio motore']/following:: XCUIElementTypeButton)[1]/following-sibling:: XCUIElementTypeOther/XCUIElementTypeSlider)[1]")
		private MobileElement olioMotoreSliderBtn;
		
		@AndroidFindBy(xpath = "(//android.view.View/android.widget.SeekBar)[2]")
		//@AndroidFindBy(xpath = "//android.view.View[@text='Liquido di raffreddamento']/following-sibling::android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.SeekBar")
		@iOSXCUITFindBy(xpath = "((//XCUIElementTypeStaticText[@name='Liquido di raffreddamento']/following:: XCUIElementTypeButton)[1]/following-sibling:: XCUIElementTypeOther/XCUIElementTypeSlider)[1]")
		private MobileElement liquidoDiRaffreddamentoSliderBtn;
		
		@AndroidFindBy(xpath = "(//android.view.View/android.widget.SeekBar)[3]")
		//@AndroidFindBy(xpath = "//android.view.View[@text='Liquido Lavavetri']/following-sibling::android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.SeekBar")
		@iOSXCUITFindBy(xpath = "((//XCUIElementTypeStaticText[@name='Liquido Lavavetri']/following:: XCUIElementTypeButton)[1]/following-sibling:: XCUIElementTypeOther/XCUIElementTypeSlider)[1]")
		private MobileElement liquidoLavavetriSliderBtn;
		
		//@AndroidFindBy(xpath = "(//android.view.View/android.widget.SeekBar)[4]")
		@AndroidFindBy(xpath = "//android.view.View[@text='Batteria']/following-sibling::android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.SeekBar")
		@iOSXCUITFindBy(xpath = "((//XCUIElementTypeStaticText[@name='Batteria']/following:: XCUIElementTypeButton)[1]/following-sibling:: XCUIElementTypeOther/XCUIElementTypeSlider)[1]")
		private MobileElement batteriaSliderBtn;
		
		//@AndroidFindBy(xpath = "(//android.view.View/android.widget.SeekBar)[5]")
		@AndroidFindBy(xpath = "//android.view.View[@text='Olio freni']/following-sibling::android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.SeekBar")
		@iOSXCUITFindBy(xpath = "((//XCUIElementTypeStaticText[@name='Olio freni']/following:: XCUIElementTypeButton)[1]/following-sibling:: XCUIElementTypeOther/XCUIElementTypeSlider)[1]")
		private MobileElement olioFreniSliderBtn;
	
		@AndroidFindBy(xpath = "//android.view.View[@resource-id='jobcard']")
		@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Service App']//XCUIElementTypeButton)[last()-4]")
		private MobileElement addANewImageIcon;
	
		@AndroidFindBy(xpath = "//android.view.View[@text='Off line Activity']/parent::android.view.View/android.view.View[1]/following::android.widget.Button[1]")
		@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Service App']//XCUIElementTypeButton)[last()-2]")
		private MobileElement addANewRunIconOfflineActivity;	
		
		
		@AndroidFindBy(xpath = "//android.view.View[@text='Remote Activity']/parent::android.view.View/android.view.View[1]/following::android.widget.Button[1]")
		@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Service App']//XCUIElementTypeButton)[last()-2]")
		private MobileElement addANewRunIconRemoteActivity;
		
		@AndroidFindBy(xpath = "//android.view.View[@text='Long Activity']/parent::android.view.View/android.view.View[1]/following::android.widget.Button[1]")
		@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Service App']//XCUIElementTypeButton)[last()-2]")
		private MobileElement runIconLongActivityBtn;	
		
		
		
//		@AndroidFindBy(xpath = "//android.view.View[@text='Luci - Lato anteriore destro']/parent::android.view.View/android.view.View[1]/following::android.widget.Button[2]")
//		@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Service App']//XCUIElementTypeButton)[last()-2]")
//		private MobileElement addANewRunIconOfflineActivity;
		

		@AndroidFindBy(xpath = "//android.widget.EditText[@text='Luci - Lato anteriore destro']/parent::android.view.View/following::android.view.View[3]")
		//@AndroidFindBy(xpath = "//android.view.View[@text='Luci - Lato anteriore destro']/parent::android.view.View/android.view.View[1]/following::android.widget.Button[1]")
		@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Service App']//XCUIElementTypeButton)[last()-2]")
		private MobileElement latoAnterioreRunActivityBtn;
		
		//@AndroidFindBy(xpath = "//android.widget.EditText[@text='Luci - Lato anteriore destro']/parent::android.view.View/following::android.view.View[4]")
		@AndroidFindBy(xpath = "//android.view.View[@text='Lato anteriore destro']/following::android.view.View[1]")
		@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Service App']//XCUIElementTypeButton)[last()-2]")
		private MobileElement latoAnterioreActivity3DotsBtn;
		
		//@AndroidFindBy(xpath = "//android.widget.EditText[@text='Luci - Lato anteriore destro']/parent::android.view.View/following::android.view.View[4]")
		@AndroidFindBy(xpath = "//android.view.View[@text='Luci - Lato anteriore destro']/parent::android.view.View/android.view.View[1]/following::android.widget.Button[1]")
		@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Service App']//XCUIElementTypeButton)[last()-2]")
		private MobileElement LucilatoAnterioreActivity3DotsBtn;
		
		@AndroidFindBy(xpath = "//android.view.View[@resource-id='addOperation']/android.widget.Button")
		@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Service App']//XCUIElementTypeButton)[last()-2]")
		private MobileElement latoAnterioreAddOperationBtn;
		
		@AndroidFindBy(xpath = "//android.view.View[@text='New activity added in offline']/parent::android.view.View/android.view.View[1]/following::android.widget.Button[1]")
		@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Clocked time :']/preceding:: XCUIElementTypeButton)[last()-1]")
		private MobileElement newOfflineActivityRunIcon;
		
		@AndroidFindBy(xpath = "//android.view.View[@text='New activity added in offline']/parent::android.view.View/android.view.View[1]/following::android.widget.Button[1]")
		@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Clocked time :']/preceding:: XCUIElementTypeButton)[last()-1]")
		private MobileElement newOfflineActivity3DotsAfterClickRunBtn;
		
		@AndroidFindBy(xpath = "//android.view.View[@text='New activity added in offline']/parent::android.view.View/android.view.View[3]/android.widget.Spinner")
		@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
		private MobileElement newOfflineActivityDropdown;
		
		@AndroidFindBy(xpath = "//android.view.View[@text='Spazzole tergicristallo anteriori']/following::android.view.View[1]")
		@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
		private MobileElement spazzoletegicristallo3DotBtn;
		
		@AndroidFindBy(xpath = "(//android.view.View/android.widget.Button)[2]")
		@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
		private MobileElement playRecordedVoiceBtn;
		
		@AndroidFindBy(xpath = "//android.view.View[@text='Long Activity']/parent::android.view.View/android.view.View[6]/android.view.View[2]")
		@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
		private MobileElement clockedTimeDurationLongActivity;
		
		@AndroidFindBy(xpath = "//android.view.View[@text='Activity 1']/parent::android.view.View/android.view.View[1]/following::android.widget.Button[1]")
		@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Service App']//XCUIElementTypeButton)[last()-2]")
		private MobileElement addANewRunIconActivity1;
		
		@AndroidFindBy(xpath = "//android.view.View[@text='Activity 2']/parent::android.view.View/android.view.View[1]/following::android.widget.Button[1]")
		@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Service App']//XCUIElementTypeButton)[last()-2]")
		private MobileElement addANewRunIconActivity2;
				
				
	public void clickOnMileageTachoTab() {
		gMob.waitForVisibility(mileageTachoTab, driver);
		gMob.clickElement(mileageTachoTab, "Click On Mileage Tacho Tab Option");
	}

	public void clickOnEngineHoursTab() {
		gMob.waitForVisibility(engineHoursTab, driver);
		gMob.clickElement(engineHoursTab, "Click On Mileage Tacho Tab Option");
	}

	public void clickOnMileageTachoCameraIcon() {
		gMob.waitForVisibility(mileageTachoCameraIcon, driver);
		gMob.clickElement(mileageTachoCameraIcon, "Click On Engine Hours Camera Icon Option");
	}

	public void clickOnEngineHoursCameraIcon() {
		gMob.waitForVisibility(engineHoursCameraIcon, driver);
		gMob.clickElement(engineHoursCameraIcon, "Click On Engine Hour Camera Icon Option");
	}

	public void clickOnGeneralAttachmentsCameraIcon() {
		gMob.waitForVisibility(generalAttachmentsCameraIcon, driver);
		gMob.clickElement(generalAttachmentsCameraIcon, "Click On General Attachments Camera Icon Option");
	}

	public void clickOnGeneralAttachmentsMicroPhoneIcon() {
		gMob.waitForVisibility(generalAttachmentsMicroIcon, driver);
		gMob.clickElement(generalAttachmentsMicroIcon, "Click On General Attachments MicroPhone Icon Option");
	}

	public void enterEngineHoursOnTextBox(String EngineHours) {
		gMob.waitForVisibility(engineHoursTextField, driver);
		gMob.clickElement(engineHoursTextField, "Click On Engine Hours Text Box");
		gMob.clearTextBox(engineHoursTextField, "Clear Engine Hours Text Box");
		gMob.sendKeysOnTextBox(engineHoursTextField, EngineHours, "Entering Engine Hours On Engine Hours Text Box");
	}

	public int isMileageTachoCameraStarIconVisible() {
		// gMob.waitForVisibility(mileageTachoCameraStarIcon.get(0), driver);
		return mileageTachoCameraStarIcon.size();
	}

	public void clickOnAddImageIcon() {
		gMob.waitForVisibility(addImageIcon, driver);
		gMob.clickElement(addImageIcon, "Click On Mileage Tacho Camera Icon Option");
	}

	public void clickOnImage() {
		gMob.waitForVisibility(photoImage, driver);
		gMob.clickElement(photoImage, "Select Photo Image ");
	}

	public void clickOnDeleteImageBtn() {
		gMob.waitForVisibility(deleteImageBtn, driver);
		gMob.clickElement(deleteImageBtn, "Select Photo Image ");
	}

	public int getTotalCameraIconCount() {
		gMob.waitForVisibility(addImageIcon, driver);
		return cameraAllIcons.size();
	}

	public boolean isAddedImageVisible() {
		gMob.waitForVisibility(photoAddedImage, driver);
		return gMob.isElementDisplay(photoAddedImage, "Image Visible Successfully");

	}

	public void clickOnAddedImage() {
		gMob.waitForVisibility(photoAddedImage, driver);
		gMob.clickElement(photoAddedImage, "Clcik On Image Added");
	}

	public int getTotalImageCount() {
		gMob.waitForVisibility(photoAddedImage, driver);
		return totalPhotoAddedImage.size();
	}

	public boolean isMentionedDeleteAttachmentReasonVisible(String option, String device) throws Exception {
		Thread.sleep(3000);
		String xPath = null;
		if (device.equalsIgnoreCase("Android")) {
			xPath = "//android.widget.RadioButton[@text='" + option + "']";
		} else {
			xPath = "(//XCUIElementTypeOther[@name='" + option + "'])[1]";
		}
		Thread.sleep(3000); 
		return gMob.WaitingAndReturningElementVisibilityUsingXpath(xPath, driver);
	}

	public void clickOnDeleteAttachmentReason(String option, String device) throws Exception {
		Thread.sleep(3000);
		String xPath = null;
		if (device.equalsIgnoreCase("Android")) {
			xPath = "//android.widget.RadioButton[@text='" + option + "']";
		} else {
			xPath = "(//XCUIElementTypeOther[@name='" + option + "'])[1]";
		}
		Thread.sleep(3000);
		gMob.WaitingAndReturningElementVisibilityUsingXpath(xPath, driver);
		driver.findElement(By.xpath(xPath)).click();
	}

	public void clickOnCloseBtnFromAddedImageScreen() {
		gMob.waitForVisibility(closeAddImageScreenIcon, driver);
		gMob.clickElement(closeAddImageScreenIcon, "Closes Added Image Icon");
	}

public void clickOnImageAddedEyeIcon(String device) throws InterruptedException {
		
		if (device.equalsIgnoreCase("Android")) {
			
			Thread.sleep(5000);
			gMob.clickElement(showEyeIcon, "Click On Image Added Eye Icon");
			Log.info("Image Added Eye Icon is Visible");
			
		}

		else {
			
			if (getTotalCameraIconCount() == 3) {
			gMob.clickElement(cameraAllIcons.get(0), "Click On Image Added Eye Icon");
		} else {
			Log.info("Image Added Eye Icon Not Visible");
		}
	  }
	}

	public void clickOnQuestion13DotsBtn() throws Exception {
		for (int i = 0; i <= 3; i++) {
			gMob.swipeUpDown("up", driver);
		}
		gMob.swipeToElement(question13DotsBtn, "up", driver);
		gMob.waitForVisibility(question13DotsBtn, driver);
		gMob.clickElement(question13DotsBtn, "Click On Quesion 1 three dot Button");
	}

	public void clickOnQuestion23DotsBtn() throws Exception {
		for (int i = 0; i <= 3; i++) {
			gMob.swipeUpDown("up", driver);
		}
		gMob.swipeToElement(question23DotsBtn, "up", driver);
		gMob.waitForVisibility(question23DotsBtn, driver);
		gMob.clickElement(question23DotsBtn, "Click On Quesion 2 three dot Button");
	}

	public void clickOnQuestion33DotsBtn() throws Exception {
		for (int i = 0; i <= 3; i++) {
			gMob.swipeUpDown("up", driver);
		}
		gMob.swipeToElement(question33DotsBtn, "up", driver);
		gMob.waitForVisibility(question33DotsBtn, driver);
		gMob.clickElement(question33DotsBtn, "Click On Quesion 3 three dot Button");
	}

	public void clickOnQuestion43DotsBtn() throws Exception {
		for (int i = 0; i <= 3; i++) {
			gMob.swipeUpDown("up", driver);
		}
		gMob.swipeToElement(question43DotsBtn, "up", driver);
		gMob.waitForVisibility(question43DotsBtn, driver);
		gMob.clickElement(question43DotsBtn, "Click On Quesion 4 three dot Button");
	}

	public String getGreenRadioButtonCheckStatus(String device) throws Exception {
		gMob.swipeToElement(greenRadioBtnFromQuestion2, "up", driver);
		gMob.waitForVisibility(greenRadioBtnFromQuestion2, driver);
				
		if (device.equalsIgnoreCase("Android")) {
					String status=	gMob.getElementText(greenRadioBtnFromQuestion2, "checked", "Getting Green Radio Button Check Status From Question 2");
					return status;	
		    } 
		
		else 
		
		return gMob.getElementText(greenRadioBtnFromQuestion2, "value",
				"Getting Green Radio Button Check Status From Question 2");
	   }

	public void clickOnGreenRadioBtnFromQuestion2() throws Exception {
		gMob.swipeToElement(greenRadioBtnFromQuestion2, "up", driver);
		gMob.waitForVisibility(greenRadioBtnFromQuestion2, driver);
		int xAxis = greenRadioBtnFromQuestion2.getLocation().x;
		int yAxis = greenRadioBtnFromQuestion2.getLocation().y;
		gMob.clickElement(greenRadioBtnFromQuestion2, "Click On Green Radio Button From Question 2");
		//gMob.tapByCoordinates(xAxis, yAxis, driver);
	}

	public void clickOnCommentIcon() throws Exception {
		gMob.waitForVisibility(commentIcon, driver);
		gMob.clickElement(commentIcon, "Click Comment Icon");
	}

	public void clickOnAddImageIconFromQuestions(String device) throws Exception {
		
		if (device.equalsIgnoreCase("Android")) {
			gMob.waitForVisibility(showEyeIcon, driver);
					gMob.clickElement(showEyeIcon, "Click On Add Image Icon from Questions");
		} else {
		gMob.waitForVisibility(addImageFromQuesionsIcon, driver);
		gMob.clickElement(addImageFromQuesionsIcon, "Click On Add Image Icon from Questions");
	}
}

	public void clickOnPlusFromQuestions(String device) throws Exception {
		
		if (device.equalsIgnoreCase("Android")) {
			gMob.waitForVisibility(plusIcon, driver);
			gMob.clickElement(plusIcon, "Click On Plus Icon from Questions");
		}
		else {
		gMob.waitForVisibility(commentIcon, driver);
		gMob.clickElement(commentIcon, "Click On Add Image Icon from Questions"); }
		}

	public void clickOnRecorderIcon() throws Exception {
		gMob.waitForVisibility(recorderIcon, driver);
		gMob.clickElement(recorderIcon, "Click Recorder Icon");
	}

	public void clickOnRecordedBtnIcon() throws Exception {
		gMob.waitForVisibility(recordedBtn, driver);
		int xAxis = recordedBtn.getLocation().getX();
		int yAxis = recordedBtn.getLocation().getY();	
		gMob.clickElement(recordedBtn, "Click Recorded Btn Icon");
		gMob.tapByCoordinates(xAxis, yAxis, driver);
	}

	public void clickOnRecorderStopBtnIcon() throws Exception {
		gMob.waitForVisibility(recordedStopeBtn, driver);
		gMob.clickElement(recordedStopeBtn, "Click Recorder Pause Button Icon");
	}

	public boolean isRecordedVoiceVisible() {
		gMob.waitForVisibility(recordedVoice, driver);
		return gMob.isElementDisplay(recordedVoice, "Recorded Voice Visible");
	}

	public void clickOnRecordeCloseBtnIcon() throws Exception {
		gMob.waitForVisibility(closeRecordedScreenIcon, driver);
		gMob.clickElement(closeRecordedScreenIcon, "Click On close Button From recorded Screen");
	}

	public void enterCommentTextBox(String Comments) {
		gMob.waitForVisibility(commentTextbox, driver);
		gMob.clickElement(commentTextbox, "Click On Comments Text Box");
		gMob.clearTextBox(commentTextbox, "Clear Comments Text Box");
		gMob.sendKeysOnTextBox(commentTextbox, Comments, "Entering Comments On Comment Text Box");
	}

	public String getCommentBoxText(String device) {
		gMob.waitForVisibility(commentTextbox, driver);
		
		if (device.equalsIgnoreCase("Android"))  {
		return gMob.getElementText(commentTextbox, "text", "Getting Comments Value");
	} else
	{
		return gMob.getElementText(commentTextbox, "value", "Getting Comments Value");
	}
	}
	public void clickOnSubmitBtn(String device) {
		
		if (device.equalsIgnoreCase("Android"))  {
			
			gMob.waitForVisibility(submitBtn, driver);
			gMob.clickElement(submitBtn, "Click On Submit Button On Commet Box Screen");
			
//			gMob.waitForVisibility(submitClientSignatureBtn, driver);
//			gMob.clickElement(submitClientSignatureBtn, "Click On Submit Button On Commet Box Screen");
//			int xAxis = submitClientSignatureBtn.getLocation().getX();
//			int yAxis = submitClientSignatureBtn.getLocation().getY();
//			gMob.tapByCoordinates(xAxis, yAxis, driver);
			//gMob.tapByCoordinates(900,1970,driver);
			
			
		} else 
		{
		gMob.waitForVisibility(submitBtn, driver);
		gMob.clickElement(submitBtn, "Click On Submit Button On Commet Box Screen");
	   }
	}

	public void clickOnCancelBtn(String device) {
		
		if (device.equalsIgnoreCase("Android"))  
		{
		gMob.waitForVisibility(cancelClientSignatureBtn, driver);
		 gMob.clickElement(cancelClientSignatureBtn, "Cancel Button Is Visible");
		} else {
		
		gMob.waitForVisibility(cancelBtn, driver);
		gMob.clickElement(cancelBtn, "Click On Cancel Button");
	    }
	}	

	public boolean isCancelBtnVisible(String device) {
		if (device.equalsIgnoreCase("Android"))  
		{
//			gMob.waitForVisibility(cancelClientSignatureBtn, driver);
//			return gMob.isElementDisplay(cancelClientSignatureBtn, "Cancel Button Is Visible");
			
			gMob.waitForVisibility(cancelBtn, driver);
			return gMob.isElementDisplay(cancelBtn, "Cancel Button Is Visible");
		}
		else {
		gMob.waitForVisibility(cancelBtn, driver);
		return gMob.isElementDisplay(cancelBtn, "Cancel Button Is Visible");
	   }
	}
	public boolean isSubmitBtnVisible(String device) {
		
		if (device.equalsIgnoreCase("Android"))  
		{
//			gMob.waitForVisibility(submitClientSignatureBtn, driver);
//			return gMob.isElementDisplay(submitClientSignatureBtn, "Cancel Button Is Visible");
			
			gMob.waitForVisibility(submitBtn, driver);
			return gMob.isElementDisplay(submitBtn, "SUBMIT Button Is Visible");
		}
		
		else {
		gMob.waitForVisibility(submitBtn, driver);
		return gMob.isElementDisplay(submitBtn, "SUBMIT Button Is Visible");
	      }
	}

	public String getSubmitBtnEnableStatus(String device) {
	
	if (device.equalsIgnoreCase("Android"))  
	{
		gMob.waitForVisibility(submitClientSignatureBtn, driver);
		return gMob.getElementText(submitClientSignatureBtn, "enabled", "Getting Submit Btn Enabled Status");
	} else
	
	{
		gMob.waitForVisibility(submitBtn, driver);
		return gMob.getElementText(submitBtn, "enabled", "Getting Submit Btn Enabled Status");
	} }

	public String getYesRadioButtonCheckStatus(String device) throws Exception {
		
		gMob.swipeToElement(yesRadioBtn, "up", driver);
		gMob.waitForVisibility(yesRadioBtn, driver);
		
		
		if (device.equalsIgnoreCase("Android")) {
			String status = gMob.getElementText(yesRadioBtn, "checked",
					"Question 1 Yes Option Selected Status");
			if(status.equals("true"))
			{
				String index="1"; status =index;
				Log.info("Question 1 Yes Option Selected");
			}
				return status;
		
//		if (device.equalsIgnoreCase("Android")) {
//		return gMob.getElementText(yesRadioBtn, "text", "Getting Yes Radio Button Check Status From Question 1");
    }
		
		else {
		return gMob.getElementText(yesRadioBtn, "value", "Getting Yes Radio Button Check Status From Question 1");
	    } 
	}

	public void clickOnYesRadioBtnFromQuestion1() throws Exception {
		gMob.swipeToElement(yesRadioBtn, "up", driver);
		gMob.waitForVisibility(yesRadioBtn, driver);
		gMob.clickElement(yesRadioBtn, "Click On Yes Radio Button");
	}

	public String getonOffSwitchButtonCheckStatus(String device) throws Exception {
		gMob.swipeToElement(switcherFromQuestion4, "up", driver);
		gMob.waitForVisibility(switcherFromQuestion4, driver);
		
		if (device.equalsIgnoreCase("Android")) {
			return gMob.getElementText(switcherFromQuestion4, "checked",
					"Getting On/Off Radio Button Check Status From Question 4");
		}
		return gMob.getElementText(switcherFromQuestion4, "value",
				"Getting On/Off Radio Button Check Status From Question 4");
	}

	public void clickOnSwitcherFromQuestion4FromQuestion4() throws Exception {
		gMob.swipeToElement(switcherFromQuestion4, "up", driver);
		gMob.waitForVisibility(switcherFromQuestion4, driver);
		gMob.clickElement(switcherFromQuestion4, "Click On Switcher Icon From Question 4");
	}

	public void clickOnCheckinIcon() throws Exception {
		//gMob.swipeToElement(checkinIcon, "up", driver);
		gMob.waitForVisibility(checkinIcon, driver);
		gMob.clickElement(checkinIcon, "Click On Check In Icon");
	}
	
	public void clickOnCheckinActivity() throws Exception {
		//gMob.swipeToElement(checkinIcon, "up", driver);
		gMob.waitForVisibility(checkinActivity, driver);
		gMob.clickElement(checkinActivity, "Click On Check In Icon");
	}

	public void enterCustomerNameTextBox(String CustomerName) throws InterruptedException {
		Thread.sleep(5000);
		gMob.waitForVisibility(customerNameTextBox, driver);
		gMob.clickElement(customerNameTextBox, "Click On Customer Name Text Box");
		gMob.clearTextBox(customerNameTextBox, "Clear Customer Name Text Box");
		gMob.sendKeysOnTextBox(customerNameTextBox, CustomerName, "Entering Customer Name On Customer Name Text Box");
		//gMob.tapByCoordinates(193, 51, driver);
		gMob.tapByCoordinates(500, 120, driver);
	}

	public void enterSignatureTextBox() {
		int xAxis = signatureTextBox.getLocation().getX()+30;
		int yAxis = signatureTextBox.getLocation().getY()+30;
		gMob.tapByCoordinates(xAxis, yAxis, driver);
	}

	public void turnOnCustomerNotPresentRadioButton(String device) throws Exception {
		gMob.swipeToElement(customerNotPresentRadioButton, "up", driver);
		gMob.waitForVisibility(customerNotPresentRadioButton, driver);
		
		if (device.equalsIgnoreCase("Android")) {
			String status = gMob.getElementText(customerNotPresentRadioButton, "checked",
					"Getting Terms and Condition Selected Status");
			if (status.equalsIgnoreCase("false")) {
				gMob.clickElement(customerNotPresentRadioButton, "Click On Customer Not Present Radio Button");
			}
		}	
		else {
		String status = gMob.getElementText(customerNotPresentRadioButton, "value",
				"Getting Customer Not Present Selected Status");
		if (status.equalsIgnoreCase("0")) {
			gMob.clickElement(customerNotPresentRadioButton, "Click On Customer Not Present Radio Button");
		}
		}
	}

	public void turnOnTermConditionRadioButton(String device) throws Exception {
		gMob.swipeToElement(termConditionRadioButton, "up", driver);
		
		if (device.equalsIgnoreCase("Android")) {
			String status = gMob.getElementText(termConditionRadioButton, "checked",
					"Getting Terms and Condition Selected Status");
			if (status.equalsIgnoreCase("false")) {
				gMob.clickElement(termConditionRadioButton, "Turn On Term Condition Radio Button");
			}
			
		} else {
		gMob.waitForVisibility(termConditionRadioButton, driver);
		String status = gMob.getElementText(termConditionRadioButton, "value",
				"Getting Terms and Condition Selected Status");
		if (status.equalsIgnoreCase("0")) {
			gMob.clickElement(termConditionRadioButton, "Turn On Term Condition Radio Button");
		}
	}
	}

	public void turnOffTermConditionRadioButton(String device) throws Exception {
		//gMob.swipeToElement(termConditionRadioButton, "up", driver);
		gMob.waitForVisibility(termConditionRadioButton, driver);
		if (device.equalsIgnoreCase("Android")) {
			String status = gMob.getElementText(termConditionRadioButton, "checked",
					"Getting Terms and Condition Selected Status");
			if (status.equalsIgnoreCase("true")) {
				gMob.clickElement(termConditionRadioButton, "Turn Off Term Condition Radio Button");
			}
			
		} else
		{
			String status = gMob.getElementText(termConditionRadioButton, "value",
					"Getting Terms and Condition Selected Status");
			if (status.equalsIgnoreCase("1")) {
				gMob.clickElement(termConditionRadioButton, "Turn Off Term Condition Radio Button");
			}
		}	
	}

	public void turnOnPrivacyNoticeRadioButton(String device) throws Exception {
		gMob.swipeToElement(privacyNoticeRadioButton, "up", driver);
		gMob.waitForVisibility(privacyNoticeRadioButton, driver);
		
		if (device.equalsIgnoreCase("Android")) {
			String status = gMob.getElementText(privacyNoticeRadioButton, "checked",
					"Getting Privacy Policy Selected Status");
			if (status.equalsIgnoreCase("false")) {
				gMob.clickElement(privacyNoticeRadioButton, "Turn On Privacy Policy Radio Button");
			}
			
		} else {
		
		String status = gMob.getElementText(privacyNoticeRadioButton, "value",
				"Getting Privacy Policy Selected Status");
		if (status.equalsIgnoreCase("0")) {
			gMob.clickElement(privacyNoticeRadioButton, "Turn On Privacy Policy Radio Button");
		}
	}
	}

	public boolean isCustomerNameTextBoxVisible() throws Exception {
		gMob.swipeToElement(customerNameTextBox, "up", driver);
		gMob.waitForVisibility(customerNameTextBox, driver);
		return gMob.isElementDisplay(customerNameTextBox, "Customer Name Text Box Is Visible");
	}

	public boolean isSignatureTextBoxVisible() throws Exception {
		gMob.swipeToElement(signatureTextBox, "up", driver);
		gMob.waitForVisibility(signatureTextBox, driver);
		return gMob.isElementDisplay(signatureTextBox, "Signature Text Box Is Visible");
	}

	public boolean isTermConditionRadioButtonVisible() throws Exception {
		gMob.swipeToElement(termConditionRadioButton, "up", driver);
		gMob.waitForVisibility(termConditionRadioButton, driver);
		return gMob.isElementDisplay(termConditionRadioButton, "Term Condition Is Visible");
	}

	public boolean isPrivacyNoticeRadioButtonVisible() throws Exception {
		gMob.swipeToElement(privacyNoticeRadioButton, "up", driver);
		gMob.waitForVisibility(privacyNoticeRadioButton, driver);
		return gMob.isElementDisplay(privacyNoticeRadioButton, "By Selecting The Radio Button Is Visible");
	}

	public boolean isCustomerNotPresentRadioButtonVisible() throws Exception {
		gMob.swipeToElement(customerNotPresentRadioButton, "up", driver);
		gMob.waitForVisibility(customerNotPresentRadioButton, driver);
		return gMob.isElementDisplay(customerNotPresentRadioButton, "Customer Not Present Radio Button Is Visible");
	}

	public String getTermConditionRadioButtonStatus(String device) throws Exception {
		gMob.swipeToElement(termConditionRadioButton, "up", driver);
		gMob.waitForVisibility(termConditionRadioButton, driver);
		if (device.equalsIgnoreCase("Android")) {
		String status = gMob.getElementText(termConditionRadioButton, "checked",
				"Getting Terms and Condition Selected Status");
		if(status.equals("true"))
		{
			String index="1"; status =index;
			Log.info("Terms and Condition Selected");
		}
			return status;
		} else {
		
		String status = gMob.getElementText(termConditionRadioButton, "value",
				"Getting Terms and Condition Selected Status");
		return status;
		
		}
		//return status;
	}

	public String getPrivacyNoticeRadioButtonStatus(String device) throws Exception {
		gMob.swipeToElement(privacyNoticeRadioButton, "up", driver);
		gMob.waitForVisibility(privacyNoticeRadioButton, driver);
		if (device.equalsIgnoreCase("Android")) {
		String status = gMob.getElementText(privacyNoticeRadioButton, "checked",
				"Getting Privacy Notice Selected Status");
		if(status.equals("true"))
		{
			String index="1"; status =index;
			Log.info("Privacy Notice Selected");
		}
			return status;
		} else {
		
		String status = gMob.getElementText(privacyNoticeRadioButton, "value",
				"Getting Privacy Notice Selected Status");
		return status;
	}
	}

	public void clickOnCloseReceptionButton() throws Exception {
		gMob.swipeToElement(closeReceptionButton, "up", driver);
		gMob.waitForVisibility(closeReceptionButton, driver);
		gMob.clickElement(closeReceptionButton, "Click On Close reception Button");
	}

	public void slideQuestion3Slider() {
		//int xAxis = sliderQuestion3.getLocation().x + 127;
		int xAxis = sliderQuestion3.getLocation().x + 508;
		int yAxis = sliderQuestion3.getLocation().y;
		gMob.tapByCoordinates(xAxis, yAxis, driver);
	}

	public String getSliderValue() throws Exception {
		for (int i = 0; i <= 3; i++) {
			gMob.swipeUpDown("up", driver);
		}
		gMob.swipeToElement(sliderValueQuestion3, "up", driver);
		gMob.waitForVisibility(sliderValueQuestion3, driver);
		return gMob.getElementText(sliderValueQuestion3, "name", "Getting Slider Value");
	}

	public boolean isMileageTextHasNotBeenFilledTextVisible() throws Exception {
		gMob.swipeToElement(mileageTextHasNotBeenFilledText, "up", driver);
		return gMob.isElementDisplay(mileageTextHasNotBeenFilledText, "Mileage Text Has Not Been Filled Text Visible");
	}

	public boolean isMileagePhotoHasNotBeenFilledTextVisible() throws Exception {
		gMob.swipeToElement(mileagePhotoHasNotBeenFilledText, "up", driver);
		return gMob.isElementDisplay(mileagePhotoHasNotBeenFilledText,
				"Mileage Photo Has Not Been Filled Text Visible");
	}

	public boolean isReadTermConditionTextTextVisible() throws Exception {
		gMob.swipeToElement(readTermConditionText, "up", driver);
		return gMob.isElementDisplay(readTermConditionText, "Read Term Condition Text Visible");
	}

	public void tapOnScreen() {
		gMob.tapByCoordinates(192, 166, driver);
	}
	
	public boolean isThisQuestionHasBeenAddedTextVisible() throws Exception {
		gMob.swipeToElement(thisQuestionHasBeenAddedText, "up", driver);
		return gMob.isElementDisplay(thisQuestionHasBeenAddedText,
				"This question has been added to the list of activities Text Visible");
	}

	public void clickOnOkButton() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println(gMob.WaitingAndReturningElementVisibility(OkBtn));
		if (gMob.WaitingAndReturningElementVisibility(OkBtn)) {
			int xAxis = OkBtn.getLocation().getX();
			int yAxis = OkBtn.getLocation().getY();
			gMob.tapByCoordinates(xAxis, yAxis, driver);
			// gMob.clickElement(checkListOkBtn, "Click On OK Button");
		}
	}
	
	public void clickPhotoCamera() {
		gMob.waitForVisibility(photoCamera, driver);
		gMob.clickElement(photoCamera, "Click On Camera Icon Option");
	}
	
	
	public void captureCameraphoto() {
		gMob.waitForVisibility(captureCameraphoto, driver);
		gMob.clickElement(captureCameraphoto, "Click On Camera Icon to Capture photo");
	}
	
	public void attachCameraphoto() {
		gMob.waitForVisibility(attachCameraphoto, driver);
		gMob.clickElement(attachCameraphoto, "Click tick mark to attach captured photo");
	}
	
	public void clickOnSubmitBtnOnClientSignature() {
		gMob.waitForVisibility(submitClientSignatureBtn, driver);
		gMob.clickElement(submitClientSignatureBtn, "Click On Submit Button On client signature Screen");
	}
	
	public boolean isSubmitBtnOnClientSignatureVisible() {
		gMob.waitForVisibility(submitClientSignatureBtn, driver);
		return gMob.isElementDisplay(submitClientSignatureBtn, "Submit Button Is Visible");
	}

	public boolean iscancelClientSignatureBtnVisible() {
		gMob.waitForVisibility(cancelClientSignatureBtn, driver);
		return gMob.isElementDisplay(cancelClientSignatureBtn, "Cancel Button Is Visible");
	}
	
	public boolean isAddMediaDescriptionVisible() {
		gMob.waitForVisibility(addMediaDescriptionLabel, driver);
		return gMob.isElementDisplay(addMediaDescriptionLabel, "Add Media Description Label Is Visible");
	}
	
	public void enterMediaDescriptionOnTextBox(String Description) {
		gMob.waitForVisibility(enterMediaDescriptionTextField, driver);
		gMob.clickElement(enterMediaDescriptionTextField, "Click On Add Media Description Text Box");
		gMob.sendKeysOnTextBox(enterMediaDescriptionTextField, Description, "Entering Media Description On Add Media Description Text Box");
	}
	
	public void clickOnSaveBtnOnAddMediaDescription() {
		gMob.waitForVisibility(saveMediaDescriptionBtn, driver);
		gMob.clickElement(saveMediaDescriptionBtn, "Click On Save Button On Add Media Description Screen");
	}
	
	public String getColorForCommentIcon() {
		return commentGreenColor.getCssValue("color");
	}

	public String getColorForEyeIcon() {
		return eyeGreenColor.getCssValue("color");
	}

	public String getColorForMicrophoneIcon() {
		return microphoneGreenColor.getCssValue("color");
	}
	public boolean isDisabledPlusIconVisible() throws Exception {
		Thread.sleep(2000);
		return disabledPlusIcon.isDisplayed();
	}
	
	public boolean isEnabledPlusIconVisible() throws Exception {
		Thread.sleep(2000);
		return enabledPlusIcon.isDisplayed();
	}
	
	public void clickOnVideoCameraBtn() {
		gMob.waitForVisibility(videoCameraBtn, driver);
		gMob.clickElement(videoCameraBtn, "Click On Video Camera Btn");
	}
	
	public void clickOnStartVideoRecordingBtn() {
		gMob.waitForVisibility(startVideoRecordingBtn, driver);
		gMob.clickElement(startVideoRecordingBtn, "Start Video Recording");
	}
	
	public void clickOnStopVideoRecordingBtn() {
		gMob.waitForVisibility(stopVideoRecordingBtn, driver);
		gMob.clickElement(stopVideoRecordingBtn, "Stop Video Recording");
	}
	
	public void attachVideoRecordingBtn() {
		gMob.waitForVisibility(attachVideoRecordingBtn, driver);
		gMob.clickElement(attachVideoRecordingBtn, "Attach Video Recording");
	}
	
	public void clickOnAddANewRunIcon() throws Exception {
		for (int i = 0; i <= 3; i++) {
			gMob.swipeUpDown("up", driver);
		}
		gMob.waitForVisibility(addANewRunIcon, driver);
		gMob.clickElement(addANewRunIcon, "Click On Add A New Activity Run Icon Option");
		//int xAxis = addANewRunIcon.getLocation().getX();
		//int yAxis = addANewRunIcon.getLocation().getY();
		//gMob.tapByCoordinates(xAxis, yAxis, driver);
		
	}
	
	public void clickOnAddANewRunIconRemoteActivity() throws Exception {
		for (int i = 0; i <= 3; i++) {
			gMob.swipeUpDown("up", driver);
		}
		gMob.waitForVisibility(addANewRunIconRemoteActivity, driver);
		gMob.clickElement(addANewRunIconRemoteActivity, "Click On Add A New Activity Run Icon Option");
		
	}
	
	
	
	   public void clickOnofflineSecondActivityRunBtn() throws Exception {

	        gMob.swipeToElement(offlineSecondActivityRunBtn, "up", driver);

	        gMob.waitForVisibility(offlineSecondActivityRunBtn, driver);

	        gMob.clickElement(offlineSecondActivityRunBtn, "Click On Add New Activity Button After Clcik On Run Icon");

	    }
	
	public void clickOnAddANewActivity3DotsBtn() throws Exception {
		gMob.swipeToElement(addANewActivity3DotsBtn, "up", driver);
		gMob.waitForVisibility(addANewActivity3DotsBtn, driver);
		gMob.clickElement(addANewActivity3DotsBtn, "Click On Add New Activity Button");
	}
	
	public void selectStatusOptionFromActivityDropDown(String option, String device)
			throws Exception {
		String xPath = null;
		if (device.equalsIgnoreCase("Android")) {
			xPath = "//android.widget.RadioButton[@text='" + option + "']";
		} else {
			xPath = "(//XCUIElementTypeOther[@name='" + option + "'])[1]";
		}
		gMob.swipeToElement(newActivityDropdown, "up", driver);
		gMob.clickElement(newActivityDropdown, "Click On Added Activity Drop up");
		gMob.WaitingAndReturningElementVisibilityUsingXpath(xPath, driver);
		gMob.clickElement((MobileElement) driver.findElement(By.xpath(xPath)), "Done Option Selected");
		clickOnOkButton();
	}
	public boolean isActivityClockVisible() throws Exception {
		gMob.swipeToElement(activityClockIcon, "up", driver);
		return gMob.isElementDisplay(activityClockIcon, "Activity Clock is Launched");
	}
	public boolean inProgressStatusBtnVisible() {

		gMob.waitForVisibility(inProgressStatusBtn, driver);
		return gMob.isElementDisplay(inProgressStatusBtn, "Verify Task Status In-progress");
	}
	
	
	public boolean GetClockedTimeDuration() throws Exception {
		gMob.waitForVisibility(clockedTimeDuration, driver);
		return gMob.getElementText(clockedTimeDuration, "text", "Clocked time duration").equals("00:01");
		
	}
	
	public void clickOnInternoAnterioreSinistroGreenRdioBtn() throws Exception {
		for (int i = 0; i <= 3; i++) {
			gMob.swipeUpDown("up", driver);
		}
		gMob.swipeToElement(internoAnterioreSinistroGreenRdioBtn, "up", driver);
		gMob.waitForVisibility(internoAnterioreSinistroGreenRdioBtn, driver);
		gMob.clickElement(internoAnterioreSinistroGreenRdioBtn, "Click On Interno Anteriore Sinistro Green Rdio Btn");
	}
	
	public void  swipeToInternoAnterioreSinistro3DotBtnBtn() throws Exception {
		gMob.swipeToElement(internoAnterioreSinistro3DotBtn, "down", driver);
	}
	
	public void clickOnInternoAnterioreSinistro3DotBtnBtn() throws Exception {
		for (int i = 0; i <= 3; i++) {
			gMob.swipeUpDown("up", driver);
		}
		gMob.swipeToElement(internoAnterioreSinistro3DotBtn, "up", driver);
		gMob.waitForVisibility(internoAnterioreSinistro3DotBtn, driver);
		gMob.clickElement(internoAnterioreSinistro3DotBtn, "Click On Interno Anteriore Sinistro Green Rdio Btn");
	}
	
	public void clickOnEsternoAnterioreSinistroGreenRdioBtn() throws Exception {
		gMob.swipeToElement(esternoAnterioreSinistroGreenRdioBtn, "up", driver);
		gMob.waitForVisibility(esternoAnterioreSinistroGreenRdioBtn, driver);
		gMob.clickElement(esternoAnterioreSinistroGreenRdioBtn, "Click On Esterno Anteriore Sinistro Green Rdio Btn");
	}
	
	public void clickOnEsternoAnterioreSinistro3DotBtn() throws Exception {
		gMob.swipeToElement(esternoAnterioreSinistro3DotBtn, "up", driver);
		gMob.waitForVisibility(esternoAnterioreSinistro3DotBtn, driver);
		gMob.clickElement(esternoAnterioreSinistro3DotBtn, "Click On Interno Anteriore Sinistro Green Rdio Btn");
	}
	
	public void clickOnSpazzoleTergicristalloAnterioriOkBtn() throws Exception {
		for (int i = 0; i <= 2; i++) {
			gMob.swipeUpDown("up", driver);
		}
		gMob.swipeToElement(spazzoleTergicristalloAnterioriOkBtn, "up", driver);
		gMob.waitForVisibility(spazzoleTergicristalloAnterioriOkBtn, driver);
		gMob.clickElement(spazzoleTergicristalloAnterioriOkBtn, "Click On Spazzole Tergicristallo Anteriori Ok Btn");
	}
	
	public void clickOnParabrezzaAnterioreOkBtn() throws Exception {
		gMob.swipeToElement(parabrezzaAnterioreOkBtn, "up", driver);
		gMob.waitForVisibility(parabrezzaAnterioreOkBtn, driver);
		gMob.clickElement(parabrezzaAnterioreOkBtn, "Click On Spazzole Parabrezza Anteriore Ok Btn");
	}
	
	public void clickOnPerditeEsterneVisibiliOkBtn() throws Exception {
		gMob.swipeToElement(perditeEsterneVisibiliOkBtn, "up", driver);
		gMob.waitForVisibility(perditeEsterneVisibiliOkBtn, driver);
		gMob.clickElement(perditeEsterneVisibiliOkBtn, "Click On Spazzole Perdite Esterne Visibili Ok Btn");
	}
	
	public void clickOnLatoAnterioreDestroToggleBtn() throws Exception {
		for (int i = 0; i <= 2; i++) {
			gMob.swipeUpDown("up", driver);
		}
		gMob.swipeToElement(latoAnterioreDestroToggleBtn, "up", driver);
		gMob.waitForVisibility(latoAnterioreDestroToggleBtn, driver);
		gMob.clickElement(latoAnterioreDestroToggleBtn, "Click On Lato Anteriore Destro Toggle Btn");
	}
	
	public void clickOnAnterioreSinistroToggleBtn() throws Exception {
		gMob.swipeToElement(anterioreSinistroToggleBtn, "up", driver);
		gMob.waitForVisibility(anterioreSinistroToggleBtn, driver);
		gMob.clickElement(anterioreSinistroToggleBtn, "Click On Anteriore Sinistro Toggle Btn");
	}
	
	public void slideOlioMotoreSliderBtn(String device) throws Exception {
		for (int i = 0; i <= 2; i++) {
			gMob.swipeUpDown("up", driver);
		}
		int xAxis;
		if (device.equalsIgnoreCase("Android")) {
		 xAxis = olioMotoreSliderBtn.getLocation().x + 350;
		}
		else {
			 xAxis = olioMotoreSliderBtn.getLocation().x + 83;
		}
		int yAxis = olioMotoreSliderBtn.getLocation().y;
		gMob.tapByCoordinates(xAxis, yAxis, driver);
	}
	
	public void slideLiquidoDiRaffreddamentoSliderBtn(String device) {
		int xAxis;
		if (device.equalsIgnoreCase("Android")) {
			
			 xAxis = liquidoDiRaffreddamentoSliderBtn.getLocation().x + 350;
		} 
		else
		{	
			 xAxis = liquidoDiRaffreddamentoSliderBtn.getLocation().x + 83;
		}
		int yAxis = liquidoDiRaffreddamentoSliderBtn.getLocation().y;
		gMob.tapByCoordinates(xAxis, yAxis, driver);
	}
	
	public void slideLiquidoLavavetriSliderBtn(String device) {
		
		int xAxis;
		if (device.equalsIgnoreCase("Android")) {
			 xAxis = liquidoLavavetriSliderBtn.getLocation().x + 350;
		} else
		{
		 xAxis = liquidoLavavetriSliderBtn.getLocation().x + 83;
		}
		int yAxis = liquidoLavavetriSliderBtn.getLocation().y;
		gMob.tapByCoordinates(xAxis, yAxis, driver);
	}
	
	public void slideBatteriaSliderBtn(String device) {
		int xAxis;
		if (device.equalsIgnoreCase("Android")) {
			 xAxis = batteriaSliderBtn.getLocation().x + 350;
			
		} else {
		 xAxis = batteriaSliderBtn.getLocation().x + 83;
		 }
		int yAxis = batteriaSliderBtn.getLocation().y;
		gMob.tapByCoordinates(xAxis, yAxis, driver);
	}
	
	public void slideOlioFreniSliderBtn(String device) throws Exception {
		
		for (int i = 0; i <= 2; i++) {
			gMob.swipeUpDown("up", driver);
		}
		int xAxis;
		if (device.equalsIgnoreCase("Android")) {
			 xAxis = olioFreniSliderBtn.getLocation().x + 350;
		}
		else {
		 xAxis = olioFreniSliderBtn.getLocation().x + 83;
		}
		
		int yAxis = olioFreniSliderBtn.getLocation().y;
		gMob.tapByCoordinates(xAxis, yAxis, driver);
	}
	
	public void clickOnAppointmentImageIcon() {
		gMob.waitForVisibility(addANewImageIcon, driver);
		gMob.clickElement(addANewImageIcon, "Click On Add A New ACtivity Image Icon Option");
	}
	
	public void clickOnaddANewRunIconOfflineActivity() throws Exception {
		for (int i = 0; i <= 3; i++) {
			gMob.swipeUpDown("up", driver);
		}
		gMob.waitForVisibility(addANewRunIconOfflineActivity, driver);
		gMob.clickElement(addANewRunIconOfflineActivity, "Click On Add A New Activity Run Icon Option");
		//int xAxis = addANewRunIcon.getLocation().getX();
		//int yAxis = addANewRunIcon.getLocation().getY();
		//gMob.tapByCoordinates(xAxis, yAxis, driver);
		
	}
	   public void clickOnofflineActivity3DotsAfterClickRunBtn() throws Exception {

	        gMob.swipeToElement(offlineActivity3DotsAfterClickRunBtn, "up", driver);

	        gMob.waitForVisibility(offlineActivity3DotsAfterClickRunBtn, driver);

	        gMob.clickElement(offlineActivity3DotsAfterClickRunBtn, "Click On Offline Activity 3 dots Button After Clcik On Run Icon");

	    }
	   
	   public void clickOnofflineSecondActivity3DotsAfterClickRunBtn() throws Exception {

	        gMob.swipeToElement(offlineSecondActivity3DotsAfterClickRunBtn, "up", driver);

	        gMob.waitForVisibility(offlineSecondActivity3DotsAfterClickRunBtn, driver);

	        gMob.clickElement(offlineSecondActivity3DotsAfterClickRunBtn, "Click On Second Activity Button After Clcik On Run Icon");

	    }
	   
		public void clickOnAddANewActivity3DotsAfterClickOnRunIconBtn() throws Exception {
			//gMob.swipeUpDown("up", driver);
			gMob.swipeToElement(addANewActivity3DotsAfterClickRunBtn, "up", driver);
			gMob.waitForVisibility(addANewActivity3DotsAfterClickRunBtn, driver);
			gMob.clickElement(addANewActivity3DotsAfterClickRunBtn, "Click On Add New Activity Button After Clcik On Run Icon");
		}

		public void selectStatusOptionFromSecondActivityDropDown(String option, String device)
				throws Exception {
			String xPath = null;
			if (device.equalsIgnoreCase("Android")) {
				xPath = "//android.widget.RadioButton[@text='" + option + "']";
			} else {
				xPath = "(//XCUIElementTypeOther[@name='" + option + "'])[1]";
			}
			gMob.swipeToElement(secondActivityDropdown, "up", driver);
			gMob.clickElement(secondActivityDropdown, "Click On Added Activity Drop up");
			gMob.WaitingAndReturningElementVisibilityUsingXpath(xPath, driver);
			gMob.clickElement((MobileElement) driver.findElement(By.xpath(xPath)), "Done Option Selected");
			clickOnOkButton();
		}
		
		public void clickOnNewOfflineActivityRunIcon() throws Exception {
			gMob.swipeToElement(newOfflineActivityRunIcon, "up", driver);
			gMob.waitForVisibility(newOfflineActivityRunIcon, driver);
			gMob.clickElement(newOfflineActivityRunIcon, "Click On New Activity Offline Run Icon");
		}
		
		public void clickOnNewOfflineActivity3DotsAfterClickRunBtn() throws Exception {
			gMob.swipeToElement(newOfflineActivity3DotsAfterClickRunBtn, "up", driver);
			gMob.waitForVisibility(newOfflineActivity3DotsAfterClickRunBtn, driver);
			gMob.clickElement(newOfflineActivity3DotsAfterClickRunBtn, "Click On New Offline Activity 3Dots Button");
		}
		
		public void selectStatusOptionFromNewOfflineActivityDropDown(String option, String device)
				throws Exception {
			String xPath = null;
			if (device.equalsIgnoreCase("Android")) {
				xPath = "//android.widget.RadioButton[@text='" + option + "']";
			} else {
				xPath = "(//XCUIElementTypeOther[@name='" + option + "'])[1]";
			}
			gMob.swipeToElement(newOfflineActivityDropdown, "up", driver);
			gMob.clickElement(newOfflineActivityDropdown, "Click On Added Activity Drop up");
			gMob.WaitingAndReturningElementVisibilityUsingXpath(xPath, driver);
			gMob.clickElement((MobileElement) driver.findElement(By.xpath(xPath)), "Done Option Selected");
			clickOnOkButton();
		}
		
		public void selectStatusOptionFromOfflineActivityDropDown(String option, String device)
				throws Exception {
			String xPath = null;
			if (device.equalsIgnoreCase("Android")) {
				xPath = "//android.widget.RadioButton[@text='" + option + "']";
			} else {
				xPath = "(//XCUIElementTypeOther[@name='" + option + "'])[1]";
			}
			gMob.swipeToElement(OfflineActivityDropdown, "up", driver);
			gMob.clickElement(OfflineActivityDropdown, "Click On Added Activity Drop up");
			gMob.WaitingAndReturningElementVisibilityUsingXpath(xPath, driver);
			gMob.clickElement((MobileElement) driver.findElement(By.xpath(xPath)), "Done Option Selected");
			clickOnOkButton();
		}
		
		public void clickOnLatoAnterioreDestro3DotBtn() throws Exception {
			for (int i = 0; i <= 5; i++) {
				gMob.swipeUpDown("up", driver);
			}
			gMob.swipeToElement(latoAnterioreActivity3DotsBtn, "up", driver);
			gMob.waitForVisibility(latoAnterioreActivity3DotsBtn, driver);
			gMob.clickElement(latoAnterioreActivity3DotsBtn, "Click On Lato anteriore destro 3 Dots Btn");
		}

		public void clickOnLatoAnteriorAddOperationBtn() throws Exception {
//			for (int i = 0; i <= 3; i++) {
//				gMob.swipeUpDown("up", driver);
//			}
			gMob.swipeToElement(latoAnterioreAddOperationBtn, "up", driver);
			gMob.waitForVisibility(latoAnterioreAddOperationBtn, driver);
			gMob.clickElement(latoAnterioreAddOperationBtn, "Click On Add Operation from Lato anteriore destro 3 Dots Btn");
		}
		
		public void clickOnLatoAnteriorRunActivityBtn() throws Exception {
			for (int i = 0; i <= 3; i++) {
				gMob.swipeUpDown("up", driver);
			}
			gMob.swipeToElement(latoAnterioreRunActivityBtn, "up", driver);
			gMob.waitForVisibility(latoAnterioreRunActivityBtn, driver);
			gMob.clickElement(latoAnterioreRunActivityBtn, "Click On Run Activity from Lato anteriore destro 3 Dots Btn");
		}
		
		public void selectStatusOptionFromLuciLatoActivityDropDown(String option, String device)
				throws Exception {
			String xPath = null;
			if (device.equalsIgnoreCase("Android")) {
				xPath = "//android.widget.RadioButton[@text='" + option + "']";
			} else {
				xPath = "(//XCUIElementTypeOther[@name='" + option + "'])[1]";
			}
			gMob.swipeToElement(luciLatoActivityDropdown, "up", driver);
			gMob.clickElement(luciLatoActivityDropdown, "Click On Added Activity Drop up");
			gMob.WaitingAndReturningElementVisibilityUsingXpath(xPath, driver);
			gMob.clickElement((MobileElement) driver.findElement(By.xpath(xPath)), "Done Option Selected");
			clickOnOkButton();
		}
		
		public void clickOnspazzoletegicristallo3DotBtn() throws Exception {
			for (int i = 0; i <= 3; i++) {
				gMob.swipeUpDown("up", driver);
			}
			gMob.swipeToElement(spazzoletegicristallo3DotBtn, "up", driver);
			gMob.waitForVisibility(spazzoletegicristallo3DotBtn, driver);
			gMob.clickElement(spazzoletegicristallo3DotBtn, "Click On Spazzole tergicristallo anteriori 3Dots Btn");
		}
		
		public void clickOnLucilatoAnterioreActivity3DotsBtn() throws Exception {
			for (int i = 0; i <= 3; i++) {
				gMob.swipeUpDown("up", driver);
			}
			gMob.swipeToElement(LucilatoAnterioreActivity3DotsBtn, "up", driver);
			gMob.waitForVisibility(LucilatoAnterioreActivity3DotsBtn, driver);
			gMob.clickElement(LucilatoAnterioreActivity3DotsBtn, "Click On Luci Lato anteriore destro 3 Dots Btn");
       }
		
		public void clickOnPlayRecordedVoiceBtn() {
			gMob.waitForVisibility(playRecordedVoiceBtn, driver);
			gMob.clickElement(playRecordedVoiceBtn, "Click On Luci Lato anteriore destro 3 Dots Btn");
		}
		
		public void clickOnRunIconLongActivityBtn() throws Exception {
			for (int i = 0; i <= 2; i++) {
				gMob.swipeUpDown("up", driver);
			}
			gMob.waitForVisibility(runIconLongActivityBtn, driver);
			gMob.clickElement(runIconLongActivityBtn, "Click On Run Icon Long Activity Btn");
		}
		
		public void selectStatusOptionFromLongActivityDropDown(String option, String device)
		
		
				throws Exception {
			String xPath = null;
			if (device.equalsIgnoreCase("Android")) {
				xPath = "//android.widget.RadioButton[@text='" + option + "']";
			} else {
				xPath = "(//XCUIElementTypeOther[@name='" + option + "'])[1]";
			}
			
			for (int i = 0; i <= 2; i++) {
				gMob.swipeUpDown("up", driver);
			}
			gMob.swipeToElement(LongActivityDropdown, "up", driver);
			gMob.clickElement(LongActivityDropdown, "Click On Long Activity Drop up");
			gMob.WaitingAndReturningElementVisibilityUsingXpath(xPath, driver);
			gMob.clickElement((MobileElement) driver.findElement(By.xpath(xPath)), "Done Option Selected");
			clickOnOkButton();
		}
		
		public boolean isClutchRepairActivityVisible() {
			return gMob.isElementVisibleWithinGivenTime(newlyAddedClutchRepairActivity, 100, driver);

		}
		
		public boolean isOilControlActivityVisible() {
			return gMob.isElementVisibleWithinGivenTime(newlyAddedOilControlActivity, 100, driver);

		}
		
		public boolean isLongActivityVisible() {
			return gMob.isElementVisibleWithinGivenTime(newlyAddedLongActivity, 100, driver);

		}
		
		public boolean GetClockedTimeDurationLongActivity() throws Exception {
			gMob.waitForVisibility(clockedTimeDurationLongActivity, driver);
			return gMob.getElementText(clockedTimeDurationLongActivity, "text", "Clocked time duration").equals("01:10");
			
		}
		

		
		
		
		public void clickOnAddANewRunIconActivity1() throws Exception {
			for (int i = 0; i <= 3; i++) {
				gMob.swipeUpDown("up", driver);
			}
			gMob.waitForVisibility(addANewRunIconActivity1, driver);
			gMob.clickElement(addANewRunIconActivity1, "Click On Add A New Activity 1 Run Icon Option");
			
		}
		
		public void clickOnAddANewRunIconActivity2() throws Exception {
			for (int i = 0; i <= 3; i++) {
				gMob.swipeUpDown("up", driver);
			}
			gMob.waitForVisibility(addANewRunIconActivity2, driver);
			gMob.clickElement(addANewRunIconActivity2, "Click On Add A New Activity 2 Run Icon Option");
			
		}
		
		public boolean isActivity1ClockVisible() throws Exception {
			gMob.swipeToElement(activity1Clocking, "up", driver);
			return gMob.isElementDisplay(activity1Clocking, "Activity 1 Clock is Launched");
		}
		
		public boolean isActivity2ClockVisible() throws Exception {
			gMob.swipeToElement(activity2Clocking, "up", driver);
			return gMob.isElementDisplay(activity2Clocking, "Activity 2 Clock is Launched");
		}
		
		public boolean GetActivity1ClockedTimeDuration() throws Exception {
			for (int i = 0; i <= 3; i++) {
				gMob.swipeUpDown("up", driver);
			}
			gMob.waitForVisibility(activity1ClockedTimeDuration, driver);
			return gMob.getElementText(activity1ClockedTimeDuration, "text", "Activity 1 Clocked time duration").equals("00:01");
			
		}
		
		public boolean GetActivity2ClockedTimeDuration() throws Exception {
			gMob.waitForVisibility(activity2ClockedTimeDuration, driver);
			return gMob.getElementText(activity2ClockedTimeDuration, "text", "Activity 2 Clocked time duration").equals("00:01");
			
		}
		
		public void clickOn3DotOfActivity(String activityName, String device) throws Exception {
			Log.info("Testing Checking");
			String xpath=null;
			if(activityName.contains("Android")) {
				xpath="";
			}else {
				xpath="(//XCUIElementTypeStaticText[@name='Engine hours']/following::XCUIElementTypeStaticText[@name='"+activityName+"']/following:: XCUIElementTypeButton)[1]";
			}
			for (int i = 0; i < 20; i++) {
			try {
				String status=gMob.getElementText((MobileElement) driver.findElement(By.xpath(xpath)), "visible", "Getting Activity Visibility Status");
				if(status.equals("true")){
					Log.info(status);
					Log.info("IF");
					gMob.clickElement((MobileElement) driver.findElement(By.xpath(xpath)), "Click the 3 dots of activity of "+activityName);
					break;
				}else {
					Log.info(status);
					gMob.swipeUpDown("up", driver);
					Log.info("Else");
				}
			}catch(Exception e){
				Log.info("Exception");
				gMob.swipeUpDown("up", driver);
				
				if (i >= 19) {
					Log.info("Exception IF");
					e.printStackTrace();
					throw new Exception();

				}
			}
			}
		}
		
		public void selectStatusOptionFromActivityDropDownAccToActivityName(String activityName,String option, String device)
				throws Exception {
			Thread.sleep(3000);
			String xPath = null;
			String drpDownBoxXpath=null;
			if (device.equalsIgnoreCase("Android")) {
				 drpDownBoxXpath="(//XCUIElementTypeStaticText[@name='Engine hours']/following::XCUIElementTypeStaticText[@name='"+activityName+"']/following:: XCUIElementTypeOther)[2]";
				xPath = "//android.widget.RadioButton[@text='" + option + "']";
			} else {
				 drpDownBoxXpath="(//XCUIElementTypeStaticText[@name='Engine hours']/following::XCUIElementTypeStaticText[@name='"+activityName+"']/following:: XCUIElementTypeOther)[2]";
				xPath = "(//XCUIElementTypeOther[@name='" + option + "'])[1]";
			}
			gMob.scrollToElementWithXpath(drpDownBoxXpath, device, driver);
			gMob.clickElement((MobileElement) driver.findElement(By.xpath(drpDownBoxXpath)), "Click On Added Activity Drop down");
			gMob.WaitingAndReturningElementVisibilityUsingXpath(xPath, driver);
			gMob.clickElement((MobileElement) driver.findElement(By.xpath(xPath)), option+" Option Selected");
			clickOnOkButtonFromDropDown();
		}
		
		public void clickOnOkButtonFromDropDown() throws InterruptedException {
			Thread.sleep(3000);
			System.out.println(gMob.WaitingAndReturningElementVisibility(OkBtn));
		    gMob.clickElement(OkBtn, "Click On OK Button");
		}
		
		public String getCommentBoxText() {
			gMob.waitForVisibility(commentTextbox, driver);
			return gMob.getElementText(commentTextbox, "value", "Getting Comments Value");
		}
}
