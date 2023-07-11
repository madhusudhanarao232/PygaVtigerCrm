package com.Pyga.VtigerPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/** 
 * It is Used to Login to Application with Valid Credentials
 * 
 */
//Declaration
public class LoginPage {
@FindBy(name="user_name")private WebElement Untbox;
@FindBy(name="user_password")private WebElement pwdbx;
@FindBy(id="submitButton")private WebElement subtn;
//initialization
public LoginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
//Utilization
public WebElement getUntbox() {
	return Untbox;
}
public WebElement getPwdbx() {
	return pwdbx;
}
public WebElement getSubtn() {
	return subtn;
}
//Business Libraries
public void logginToAppliction(String USERNAME,String PASSWORD) {
	Untbox.sendKeys(USERNAME);
	pwdbx.sendKeys(PASSWORD);
	subtn.click();
}
}
