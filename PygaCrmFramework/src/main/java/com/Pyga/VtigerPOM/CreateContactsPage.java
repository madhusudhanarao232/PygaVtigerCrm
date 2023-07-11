package com.Pyga.VtigerPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Pyga.Vtigergenericutlity.WebActionUtility;

public class CreateContactsPage {
	//Declaration
	@FindBy(name = "salutationtype")private WebElement firstNamedropdown;

	@FindBy(name = "firstname")private WebElement firstnameEditbx;

	@FindBy(name = "lastname")private WebElement lastnameEditbx;

	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement orgNameLoolUpImg;

	@FindBy(name = "leadsource")private WebElement leadSourcedropdown;

	@FindBy(xpath = "//input[@name='title' and @id='title']")
	private WebElement titleEditbx;

	@FindBy(id = "department")private WebElement departmentEditbx;

	@FindBy(id = "email")private WebElement emailEditbx;

	@FindBy(name = "assistant")private WebElement assistantEditbx;

	@FindBy(name = "assistantphone")private WebElement assistantphoneEditbx;

	@FindBy(name = "reference")private WebElement referenceCheckbx;

	@FindBy(name = "notify_owner")private WebElement notify_ownerCheckbx;

	@FindBy(name = "donotcall")private WebElement donotcallCheckbx;

	@FindBy(xpath = "//input[@id='contact_no']/following::input[@name='phone']")
	private WebElement officePhoneEditbx;

	@FindBy(xpath = "//input[@name='mobile']")private WebElement mobileEditbx;

	@FindBy(id = "homephone")private WebElement home_phoneEditbx;

	@FindBy(id = "fax")private WebElement faxEditbx;

	@FindBy(id = "jscal_field_birthday")private WebElement birthdayEditbx;

	@FindBy(name = "//input[@name='contact_name']/following::img[@title='Select']")
	private WebElement reportsToLookUpimg;

	@FindBy(id = "jscal_field_support_start_date")private WebElement startDate;

	@FindBy(id = "jscal_field_support_end_date")private WebElement endDate;

	@FindBy(name = "//input[@name='imagename']/preceding::textarea[@name='description']")
	private WebElement descriptonTxtbx;

	@FindBy(name = "imagename")private WebElement contactImgChooseFileBtn;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")private WebElement saveBtn;

	//Initialization
	public CreateContactsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//Utilization

	public WebElement getFirstNamedropdown() {
		return firstNamedropdown;
	}

	public WebElement getFirstnameEditbx() {
		return firstnameEditbx;
	}

	public WebElement getLastnameEditbx() {
		return lastnameEditbx;
	}

	public WebElement getOrgNameLoolUpImg() {
		return orgNameLoolUpImg;
	}

	public WebElement getLeadSourcedropdown() {
		return leadSourcedropdown;
	}

	public WebElement getTitleEditbx() {
		return titleEditbx;
	}

	public WebElement getDepartmentEditbx() {
		return departmentEditbx;
	}

	public WebElement getEmailEditbx() {
		return emailEditbx;
	}

	public WebElement getAssistantEditbx() {
		return assistantEditbx;
	}

	public WebElement getAssistantphoneEditbx() {
		return assistantphoneEditbx;
	}

	public WebElement getReferenceCheckbx() {
		return referenceCheckbx;
	}

	public WebElement getNotify_ownerCheckbx() {
		return notify_ownerCheckbx;
	}

	public WebElement getDonotcallCheckbx() {
		return donotcallCheckbx;
	}

	public WebElement getOfficePhoneEditbx() {
		return officePhoneEditbx;
	}

	public WebElement getMobileEditbx() {
		return mobileEditbx;
	}

	public WebElement getHome_phoneEditbx() {
		return home_phoneEditbx;
	}

	public WebElement getFaxEditbx() {
		return faxEditbx;
	}

	public WebElement getBirthdayEditbx() {
		return birthdayEditbx;
	}

	public WebElement getReportsToLookUpimg() {
		return reportsToLookUpimg;
	}

	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getEndDate() {
		return endDate;
	}

	public WebElement getDescriptonTxtbx() {
		return descriptonTxtbx;
	}

	public WebElement getContactImgChooseFileBtn() {
		return contactImgChooseFileBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	/* Business Library*/
	public void firstNameDropDown(WebActionUtility w,String TEXT) {
		w.select(firstNamedropdown, TEXT);
	}
	public void fisrtNameEdit(String FIRST_NAME) {
		firstNamedropdown.sendKeys(FIRST_NAME);
	}
	public void lastNameEdit(String LAST_NAME) {
		lastnameEditbx.sendKeys(LAST_NAME);
	}
	public void orgLookUpImg() {
		orgNameLoolUpImg.click();
	}
	public void leadSourceDropDown(WebActionUtility w,String TEXT) {
		w.select(leadSourcedropdown, TEXT);
	}
	public void titleEdit(String TITLE) {
		titleEditbx.sendKeys(TITLE);
	}
	public void departmentEdit(String DEPARTMENT) {
		departmentEditbx.sendKeys(DEPARTMENT);
	}
	public void emailEdit(String EMAIL) {
		emailEditbx.sendKeys(EMAIL);
	}
	public void assistantEdit(String ASSISTANT_NAME,String ASSISTANT_PHONE) {
		assistantEditbx.sendKeys(ASSISTANT_NAME);
		assistantphoneEditbx.sendKeys(ASSISTANT_PHONE);
	}
	public void doNotCallCheckBox() {
		donotcallCheckbx.click();
	}
	public void referenceCheckBox() {
		referenceCheckbx.click();
	}
	public void mobilePhoneEdit(String MOBILE_PHONE) {
		mobileEditbx.sendKeys(MOBILE_PHONE);
	}
	public void homePhoneEdit(String HOME_PHONE) {
		home_phoneEditbx.sendKeys(HOME_PHONE);
	}
	public void faxEdit(String FAXNAME) {
		faxEditbx.sendKeys(FAXNAME);
	}
	public void birthEdit(String BIRTHDAY_DATE) {
		birthdayEditbx.sendKeys(BIRTHDAY_DATE);
	}

	public void startDateEdit(String START_DATE) {
		startDate.sendKeys(START_DATE);
	}
	public void endDateEdit(String END_DATE) {
		endDate.sendKeys(END_DATE);
	}
	public void descriptionEdit(String DESCRIPTION) {
		descriptonTxtbx.sendKeys(DESCRIPTION);
	}
	public void officePhoneEdit(String OFFICE_PHONE) {
		officePhoneEditbx.sendKeys(OFFICE_PHONE);
	}
	//                PENDING CHOOSE FILE / FILE UPLOAD POPUP

	public void saveButton() {
		saveBtn.click();
	}
}
