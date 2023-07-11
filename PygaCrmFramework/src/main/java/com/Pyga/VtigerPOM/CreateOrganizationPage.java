package com.Pyga.VtigerPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Pyga.Vtigergenericutlity.WebActionUtility;
/**
 * CreateOrganizationPage is Used to Create New Organization with valid Credentials
 *@author MadhusudhanaRao Dande
 *
 */
public class CreateOrganizationPage {
	//Declaration
	@FindBy(name = "accountname")private WebElement orgNameEditbx;

	@FindBy(name = "website")private WebElement  websiteEditbx;


	@FindBy(id = "tickersymbol")private WebElement tickersymbolEditbx ;

	@FindBy(xpath = "//img[@title='Select']")
	private WebElement  memberOfSelectLookimg;

	@FindBy(xpath = "//input[@title='Clear']")
	private WebElement  memberOfClearLookimg;

	@FindBy(id = "employees")private WebElement  employeesEditbx;

	@FindBy(id = "email2")private WebElement  otherMailEditbx;

	@FindBy(name = "industry")private WebElement  industrydropdown;

	@FindBy(name = "accounttype")private WebElement  typedropdown;

	@FindBy(name = "emailoptout")private WebElement  emailoptoutChechbx;

	@FindBy(xpath = "//input[@name='assigntype' and @value='T']")
	private WebElement  assignToGroupsRadiobtn;

	@FindBy(id = "phone")private WebElement  phoneEDitbx;

	@FindBy(id = "fax")private WebElement  faxEditbx;

	@FindBy(id = "otherphone")private WebElement  otherphoneEditbx;

	@FindBy(id = "email1")private WebElement  email1Editbx;

	@FindBy(id = "ownership")private WebElement  ownershipEditbx;

	@FindBy(name = "rating")private WebElement  ratingdropdown;

	@FindBy(id = "siccode")private WebElement  sicCodeEdibx;

	@FindBy(name = "annual_revenue")private WebElement  annual_RevenueEDitbx;

	@FindBy(name = "notify_owner")private WebElement  notify_ownerCheckbox;

	@FindBy(xpath = "//b[.='Copy Shipping address']")
	private WebElement  copyShippingRadiobtn;

	@FindBy(xpath = "//b[.='Copy Billing address']")
	private WebElement  copyBillingRadiobtn;

	@FindBy(xpath = "//textarea[@name='bill_street']")
	private WebElement  billingAddressTextbx;

	@FindBy(id = "bill_pobox")private WebElement  billPObxEditbtn;

	@FindBy(id = "bill_city")private WebElement  billCityEditbx;

	@FindBy(xpath = "bill_state")private WebElement  billStateEditbx;

	@FindBy(xpath = "bill_code")private WebElement  billCodeEditbx;

	@FindBy(xpath = "bill_country")private WebElement  billCountryEditbx;

	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement  descriptionTextbx;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement  saveBtn;
	//Initialization 
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);  
	}
	//Utilization 
	public WebElement getOrgNameEditbx() {
		return orgNameEditbx;
	}
	public WebElement getWebsiteEditbx() {
		return websiteEditbx;
	}
	public WebElement getTickersymbolEditbx() {
		return tickersymbolEditbx;
	}
	public WebElement getMemberOfSelectLookimg() {
		return memberOfSelectLookimg;
	}
	public WebElement getMemberOfClearLookimg() {
		return memberOfClearLookimg;
	}
	public WebElement getEmployeesEditbx() {
		return employeesEditbx;
	}
	public WebElement getOtherMailEditbx() {
		return otherMailEditbx;
	}
	public WebElement getIndustrydropdown() {
		return industrydropdown;
	}
	public WebElement getTypedropdown() {
		return typedropdown;
	}
	public WebElement getEmailoptoutChechbx() {
		return emailoptoutChechbx;
	}
	public WebElement getAssignToGroupsRadiobtn() {
		return assignToGroupsRadiobtn;
	}
	public WebElement getPhoneEDitbx() {
		return phoneEDitbx;
	}
	public WebElement getFaxEditbx() {
		return faxEditbx;
	}
	public WebElement getOtherphoneEditbx() {
		return otherphoneEditbx;
	}
	public WebElement getEmail1Editbx() {
		return email1Editbx;
	}
	public WebElement getOwnershipEditbx() {
		return ownershipEditbx;
	}
	public WebElement getRatingdropdown() {
		return ratingdropdown;
	}
	public WebElement getSicCodeEdibx() {
		return sicCodeEdibx;
	}
	public WebElement getAnnual_RevenueEDitbx() {
		return annual_RevenueEDitbx;
	}
	public WebElement getNotify_ownerCheckbox() {
		return notify_ownerCheckbox;
	}
	public WebElement getCopyShippingRadiobtn() {
		return copyShippingRadiobtn;
	}
	public WebElement getCopyBillingRadiobtn() {
		return copyBillingRadiobtn;
	}
	public WebElement getBillingAddressTextbx() {
		return billingAddressTextbx;
	}
	public WebElement getBillPObxEditbtn() {
		return billPObxEditbtn;
	}
	public WebElement getBillCityEditbx() {
		return billCityEditbx;
	}
	public WebElement getBillStateEditbx() {
		return billStateEditbx;
	}
	public WebElement getBillCodeEditbx() {
		return billCodeEditbx;
	}
	public WebElement getBillCountryEditbx() {
		return billCountryEditbx;
	}
	public WebElement getDescriptionTextbx() {
		return descriptionTextbx;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	//----------------------Business Library----------------------
	public void OrgNameEdit(String ORGANIZATION_NAME) {
		orgNameEditbx.sendKeys(ORGANIZATION_NAME);
	}

	public void websiteEdit(String WEBSITE_NAME) {
		websiteEditbx.sendKeys(WEBSITE_NAME);
	}
	public void tickerSymbolEdit(String TICKER_SYMBOL_NAME) {
		tickersymbolEditbx.sendKeys(TICKER_SYMBOL_NAME);
	}
	public void memberOfSelectImg() {
		memberOfSelectLookimg.click();
	}
	public void memberOfClearImg() {
		memberOfClearLookimg.click();
	}
	public void employeesEdit(String EMPLOYEE_NAME) {
		employeesEditbx.sendKeys(EMPLOYEE_NAME);
	}
	public void otherMailEdit(String OTHER_EMAIL_NAME) {
		otherMailEditbx.sendKeys(OTHER_EMAIL_NAME);
	}
	public void emailoptoutChechbx() {
		emailoptoutChechbx.click();
	}
	public void industryDropDown(WebActionUtility wLib,String TEXT) {
	wLib.select(industrydropdown, TEXT);	
	}
	public void typeDropDown(WebActionUtility wLib,String TEXT) {
		wLib.select(typedropdown, TEXT);	
		}
	public void assignToGroupsRadio() {
		assignToGroupsRadiobtn.click();
	}
	public void phoneEdit(String PHONE_NUMBER) {
		phoneEDitbx.sendKeys(PHONE_NUMBER);
	}
	public void otherPhoneEdit(String OTHER_PHONE_NUMBER) {
		otherphoneEditbx.sendKeys(OTHER_PHONE_NUMBER);
	}
	public void faxEdit(String FAX_NUMBER) {
		faxEditbx.sendKeys(FAX_NUMBER);
	}
	public void mailEdit(String EMAIL_NAME) {
		email1Editbx.sendKeys(EMAIL_NAME);
	}
	public void ownerShipEdit(String OWNERSHIP_TYPENAME) {
		otherMailEditbx.sendKeys(OWNERSHIP_TYPENAME);
	}
	public void sicCodeEdit(String SIC_CODE_NAME) {
		sicCodeEdibx.sendKeys(SIC_CODE_NAME);
	}
	public void annualRevenueEdit(String ANNUAL_REVENUE) {
		annual_RevenueEDitbx.sendKeys(ANNUAL_REVENUE);
	}
	public void notifyOwner() {
		notify_ownerCheckbox.click();;
	}
	public void copyShippingRadio() {
		copyShippingRadiobtn.click();;
	}
	public void copyBillingRadio() {
		copyBillingRadiobtn.click();;
	}
	public void ratingDropDown(WebActionUtility w,String TEXT) {
		w.select(ratingdropdown, TEXT);
	}
	public void billingAddressEdit(String BILLING_ADDRESS) {
		billingAddressTextbx.sendKeys(BILLING_ADDRESS);
	}
	public void billPOBEdit(String BILL_POB) {
		billPObxEditbtn.sendKeys(BILL_POB);
	}
	public void billCityEdit(String BILL_CITY_NAME) {
		billCityEditbx.sendKeys(BILL_CITY_NAME);
	}
	public void billStateEdit(String BILL_STATE_NAME) {
		billStateEditbx.sendKeys(BILL_STATE_NAME);
	}
	public void billCodeEdit(String BILLCODE) {
		billCodeEditbx.sendKeys(BILLCODE);
	}
	public void billCountryEdit(String BILL_COUNTRY_NAME) {
		billCountryEditbx.sendKeys(BILL_COUNTRY_NAME);
	}
	public void descriptionEdit(String DESCRPTION) {
		descriptionTextbx.sendKeys(DESCRPTION);
	}
	public void saveButton() {
		saveBtn.click();
	}
	
} 	