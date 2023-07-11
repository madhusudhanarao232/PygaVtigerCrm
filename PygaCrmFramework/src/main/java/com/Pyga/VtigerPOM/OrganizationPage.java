package com.Pyga.VtigerPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

	//Declaration
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createOrgLookupImg;
	
	//Initialization
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//Utilization
	public WebElement getCreateOrgLookupImg() {
		return createOrgLookupImg;
	}
	
	
	//business libraries
	public void orgLookUpImg()
	{
		createOrgLookupImg.click();
	}
}
