package com.Pyga.VtigerPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	//Declaration
	@FindBy(xpath = "//img[@title='Create Contact...']")private WebElement createContactlookUpImg;
	//initialization
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//Utilization
	public WebElement getcreateContactlookUpImg() {
		return createContactlookUpImg;

	}
	//Business Library
	public void contactsLookUpImg() {
		createContactlookUpImg.click();
	}
}
