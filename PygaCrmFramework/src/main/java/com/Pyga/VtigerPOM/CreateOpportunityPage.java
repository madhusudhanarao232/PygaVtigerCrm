package com.Pyga.VtigerPOM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Pyga.Vtigergenericutlity.ExcelUtlity;
import com.Pyga.Vtigergenericutlity.JavaUtlity;
import com.Pyga.Vtigergenericutlity.WebActionUtility;

public class CreateOpportunityPage {
	//Declaration
	@FindBy(name = "potentialname")private WebElement  opportunityNameEditbx;

	@FindBy(id = "related_to_type")private WebElement  relatedTodropdown;

	@FindBy(xpath = "//input[@id='related_to_display']/following-sibling::img")
	private WebElement  relatedToLookupImg;

	@FindBy(xpath = "//input[@name='related_to_display']/following-sibling::input[@title='Clear']")
	private WebElement  relatedToErase;

	@FindBy(name = "opportunity_type")private WebElement  opportunityTypedropdown;

	@FindBy(name = "leadsource")private WebElement  leadsourcedrpdown;

	@FindBy(xpath = "//input[@name='campaignname']/following-sibling::img")
	private WebElement  campaignSourceSelect;

	@FindBy(xpath = "//input[@name='campaignname']/following::input[@title='Clear']")
	private WebElement campaignSourceErase;

	@FindBy(xpath= "//input[@name='assigntype'][2]")
	private WebElement assignedToRadiobtn;
	
	@FindBy(name="assigned_group_id")private WebElement assaignedToDD;
	
	@FindBy(name = "amount")private WebElement amountEditbx;

	@FindBy(name = "closingdate")private WebElement  date;

	@FindBy(id = "nextstep")private WebElement  nextstepEditbx;

	@FindBy(name = "sales_stage")private WebElement  salesStagedropdown;

	@FindBy(id = "probability")private WebElement  probabilityRatioEditbx;

	@FindBy(name = "description")private WebElement  descriptionTextbx;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement  savebtn;

	//Initialization
	public CreateOpportunityPage(WebDriver driver) {
		PageFactory.initElements(driver,this);	
	}
	//Utilization

	public WebElement getOpportunityNameEditbx() {
		return opportunityNameEditbx;
	}

	public WebElement getRalatedTodropdown() {
		return relatedTodropdown;
	}

	public WebElement getRelatedToLookupImg() {
		return relatedToLookupImg;
	}

	public WebElement getRelatedToErase() {
		return relatedToErase;
	}

	public WebElement getOpportunityTypedropdown() {
		return opportunityTypedropdown;
	}

	public WebElement getLeadsourcedrpdown() {
		return leadsourcedrpdown;
	}

	public WebElement getRelatedTodropdown() {
		return relatedTodropdown;
	}

	public WebElement getAssignedToRadiobtn() {
		return assignedToRadiobtn;
	}

	public WebElement getAssaignedToDD() {
		return assaignedToDD;
	}

	public WebElement getCampaignSourceSelect() {
		return campaignSourceSelect;
	}

	public WebElement getCampaignSourceErase() {
		return campaignSourceErase;
	}

	public WebElement getAmountEditbx() {
		return amountEditbx;
	}

	public WebElement getDate() {
		return date;
	}

	public WebElement getNextstepEditbx() {
		return nextstepEditbx;
	}

	public WebElement getSalesStagedropdown() {
		return salesStagedropdown;
	}

	public WebElement getProbabilityRatioEditbx() {
		return probabilityRatioEditbx;
	}

	public WebElement getDescriptionTextbx() {
		return descriptionTextbx;
	}


	public WebElement getSavebtn() {
		return savebtn;
	}
	/*  ......................Business libraries.................................*/
	public void opportunityName(String OPPORTUNITYNAME) {
		opportunityNameEditbx.sendKeys(OPPORTUNITYNAME);
	}
	public void relatedToDropdown(WebActionUtility wLib,String TEXT) {
		wLib.select(relatedTodropdown, TEXT);
	}
	public void relatedToLookUpImge( ) {
		relatedToLookupImg.click();
	}

	public void relatedToErase() {
		relatedToErase.click();
	}
	public void opportunityTypeDropdown(WebActionUtility wLib,String TEXT) {
		wLib.select(opportunityTypedropdown, TEXT);
	}
	public void leadSourceDropdown(WebActionUtility wLib,String TEXT) {
		wLib.select(leadsourcedrpdown, TEXT);
	}
	public void assignedToRadio() throws InterruptedException {
		assignedToRadiobtn.click();
	}
	public void assignedToDropdown(WebActionUtility wLib,String TEXT) {
		wLib.select(assaignedToDD, TEXT);
	}
	public void campaignSourceLookUpImg() {
		campaignSourceSelect.click();
	}
	public void campaignSourceErase() {
		campaignSourceErase.click();
	}
	public void amountEditBox(String AMOUNT) {
		amountEditbx.clear();
		amountEditbx.sendKeys(AMOUNT);
	}
	public void ExpectedCloseDate(JavaUtlity jLib,String DATE) throws IOException, Throwable {
		date.clear();
	    String REQ_DATE = jLib.getRequiredDate(Integer.parseInt(DATE));
	    date.sendKeys(REQ_DATE);
	   // Integer.parseInt(DATE) this Sentence is Convert the String to Int
	}
	public void sendDate(String DATE) {
		date.clear();
		date.sendKeys(DATE);
	}
	public void nextStepEditBox(String NEXTSTEP) {
		nextstepEditbx.sendKeys(NEXTSTEP);
	}
	public void salesStageDropdown(WebActionUtility wLib,String TEXT) {
		wLib.select(salesStagedropdown, TEXT);
	}
	public void probablityRatio(String RATIOINPERCENTAGE) {
		probabilityRatioEditbx.sendKeys(RATIOINPERCENTAGE);
	}
	public void descriptionTextBox(String DESCRIPTION) {
		descriptionTextbx.sendKeys(DESCRIPTION);
	}
	public void savePage() {
		savebtn.click();
	}
}
