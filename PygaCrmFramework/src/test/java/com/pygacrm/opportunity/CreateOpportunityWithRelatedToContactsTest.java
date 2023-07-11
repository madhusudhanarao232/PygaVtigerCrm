package com.pygacrm.opportunity;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Pyga.VtigerPOM.ChildWindowPageContact;
import com.Pyga.VtigerPOM.CreateOpportunityPage;
import com.Pyga.VtigerPOM.HomePage;
import com.Pyga.VtigerPOM.OpportunityPage;
import com.Pyga.VtigerPOM.VerifyOpportunitiesPage;
import com.Pyga.Vtigergenericutlity.BaseClass;
@Listeners(com.Pyga.Vtigergenericutlity.ListenerImp.class)
public class CreateOpportunityWithRelatedToContactsTest extends BaseClass {

	@Test(retryAnalyzer =com.Pyga.Vtigergenericutlity.RetryImp.class ,groups= {"smokeTest","regTest"})
	public void createOPPWithContact() throws Throwable {
		/* Get the File path */
		String TEST_SCRIPT_EXCEL_FILE_PATH = fLib.getFilePathFromPropertiesFile("testScriptdatafilePath");
		String CHILD_BROWSER_LINKS=fLib.getFilePathFromPropertiesFile("chlilwindowbrowser");
		String BPATH=fLib.getFilePathFromPropertiesFile("projectConfigDataFilePath");
		String URL=fLib.getDataFromProperties(BPATH, "url");
		/* Get the child browser link */
		String CONTACTS_CHILDWINDOW_BROWSER_LINK=fLib.getDataFromProperties(CHILD_BROWSER_LINKS, "contacts_childbrowserlink");
		 /* Get the data from TEST_SCRIPT */
		int randomNum = jLib.getRandomNumber();
		String OPPORTUNITY_NAME = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "OpportunityTestScipt", "TC_ID_04", "OpportunityName")+randomNum;
		String DROPDOWN_VALUE = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "OpportunityTestScipt", "TC_ID_04", "RelatedToDDValue");
		String SET_CONTACT_NAME = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "OpportunityTestScipt", "TC_ID_04", "ContactName");
	    String DESCRIPTION = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "OpportunityTestScipt", "TC_ID_04", "TC_NAME");
		/* Step 2 : Navigate to Opportunity page*/
	    HomePage hp=new HomePage(driver);
	    hp.opportunityLink();
	    /* Step 3: Navigate to Create Opportunity Page*/
	    OpportunityPage op=new OpportunityPage(driver);
	    op.opportutiesLookUpImg();
	    /* Step 4: Create new opportunity with valid information*/
	    CreateOpportunityPage cop=new CreateOpportunityPage(driver);
	    // Opportunity name
	    cop.opportunityName(OPPORTUNITY_NAME);
	    //select dropdown
	    cop.relatedToDropdown(wLib, DROPDOWN_VALUE);
	    // click on lookup image
	    cop.relatedToLookUpImge();
	    //Control Switch to Child browser/Partial browser
	    wLib.swithToWindowBasedOnURL(driver, CONTACTS_CHILDWINDOW_BROWSER_LINK);
	   ChildWindowPageContact cwp=new ChildWindowPageContact(driver);
	   cwp.searchText(SET_CONTACT_NAME);
	   cwp.clickOnContactName(driver, SET_CONTACT_NAME);
	   //Switch back to parent browser
	   wLib.swithToWindowBasedOnURL(driver, URL);
	   //Save 
	   cop.descriptionTextBox(DESCRIPTION);
	   cop.savePage();
	   //verify
	   VerifyOpportunitiesPage vop=new VerifyOpportunitiesPage(driver);
	   vop.verfyOPPName(OPPORTUNITY_NAME);
	   vop.verifyContactsSourceName(driver, SET_CONTACT_NAME);
	//Reporter.log(,true);
	}
}
 