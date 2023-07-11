package com.Pyga.VtigerPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyOrganizationPage {

	//Declaration
	@FindBy(className = "dvHeaderText")private WebElement createdOrg;
	
	//Initialization
	public VerifyOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//utilization
	public WebElement getCreatedOrg() {
		return createdOrg;
	}
	
	//Business Libraries
	/**
	 * get the created Organization name and verify
	 */
	
	public String createdOrgName()
	{
		return createdOrg.getText();
	}
}