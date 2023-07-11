package com.Pyga.VtigerPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityPage {
	//Declaration
	@FindBy(xpath = "//img[@title='Create Opportunity...']")private WebElement createOpportunitieslookUpImg;
	//initialization
	public OpportunityPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//Utilization
	public WebElement getcreateOpportunitieslookUpImg() {
		return createOpportunitieslookUpImg;
	}
	//Business Library
	public void opportutiesLookUpImg() {
		createOpportunitieslookUpImg.click();
	}
}
