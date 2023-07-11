package com.Pyga.VtigerPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyContactsPage {

	//Declaration
	@FindBy(className = "dvHeaderText")private WebElement createdContact;

	//Initialization
	public VerifyContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//utilization
	public WebElement getCreatedContact() {
		return createdContact;
	}

	//Business Libraries
	/**
	 * get the created Contacts name and verify
	 */

	public String createdContactName()
	{
		return createdContact.getText();
	}
}