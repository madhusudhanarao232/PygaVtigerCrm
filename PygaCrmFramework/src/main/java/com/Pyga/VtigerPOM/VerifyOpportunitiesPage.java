package com.Pyga.VtigerPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class VerifyOpportunitiesPage {
	SoftAssert s=new SoftAssert();
	//Declaration
	@FindBy(id = "dtlview_Opportunity Name")private WebElement createdOppurtunity;

	@FindBy(xpath = "//a[@title='Organizations']")private WebElement createdOPPWithOrgSource;

	@FindBy(xpath = "//a[@title='Contacts']")private WebElement createdOPPWithContactSource;

	@FindBy(xpath="//span[@id='dtlview_Amount']/following::td[@class='dvtCellInfo'][2]")
	private WebElement expDate;

	//Initialization
	public VerifyOpportunitiesPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//utilization

	public WebElement getCreatedOPPWithContactSource() {
		return createdOPPWithContactSource;
	}

	public WebElement getCreatedOppurtunity() {
		return createdOppurtunity;
	}

	public WebElement getCreatedOPPWithOrgSource() {
		return createdOPPWithOrgSource;
	}


	public WebElement getExpDate() {
		return expDate;
	}

	//Business Libraries
	/**
	 * get the created Opportunity name and verify
	 */

	public String verfyOPPName(String OPPNAME)
	{   
		String actOPPName = createdOppurtunity.getText();
		s.assertEquals(actOPPName, OPPNAME,actOPPName+" != "+OPPNAME+" FAIL...");
		Reporter.log(actOPPName+" == "+OPPNAME+"  PASS...",true);
		return actOPPName;
	}
	public String verifyOrgSourceName(WebDriver driver,String sourceName) {
		String actSourceName =createdOPPWithOrgSource.getText() ;
		s.assertEquals(actSourceName, sourceName,actSourceName+" != "+sourceName+" FAIL...");
		Reporter.log(actSourceName+" == "+sourceName+"  PASS...",true);		
		return actSourceName;	
	}
	public String verifyContactsSourceName(WebDriver driver,String sourceName) {
		String actSourceName=createdOPPWithContactSource.getText();
		//SoftAssert s=new SoftAssert();  Declaring Globally
		s.assertEquals(actSourceName, sourceName,actSourceName+" != "+sourceName+" FAIL...");
		Reporter.log(actSourceName+" == "+sourceName+"  PASS...",true);
		return actSourceName;		
	}
	//	public void verifyExpDate(String DATE) {
	//		String actDate = expDate.getText();
	//		SoftAssert s=new SoftAssert();
	//		s.assertEquals(DATE, actDate);
	//		Reporter.log(actDate+" is == "+DATE+" Advance days from Current DATE",true);
	//	    s.assertAll();
	//	}
}