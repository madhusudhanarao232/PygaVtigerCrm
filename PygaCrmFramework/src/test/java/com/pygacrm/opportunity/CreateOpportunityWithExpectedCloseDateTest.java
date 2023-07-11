package com.pygacrm.opportunity;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Pyga.VtigerPOM.ChildWindowPageOrg;
import com.Pyga.VtigerPOM.CreateOpportunityPage;
import com.Pyga.VtigerPOM.HomePage;
import com.Pyga.VtigerPOM.OpportunityPage;
import com.Pyga.VtigerPOM.VerifyOpportunitiesPage;
import com.Pyga.Vtigergenericutlity.BaseClass;
@Listeners(com.Pyga.Vtigergenericutlity.ListenerImp.class)
public class CreateOpportunityWithExpectedCloseDateTest extends BaseClass{
  @Test(retryAnalyzer =com.Pyga.Vtigergenericutlity.RetryImp.class ,groups = {"smokeTest"})
	public void expectedCloseDate() throws Throwable {
	  /*get the FILE PATH*/
		String TEST_SCRIPT_EXCEL_FILE_PATH =fLib.getFilePathFromPropertiesFile("testScriptdatafilePath");
		String CHILD_BROWSER_LINKS = fLib.getFilePathFromPropertiesFile("chlilwindowbrowser");
		String BPATH=fLib.getFilePathFromPropertiesFile("projectConfigDataFilePath");
		String URL=fLib.getDataFromProperties(BPATH, "url");
		/* Set child browser links     */
		 String ORG_PARTIAL_URL=fLib.getDataFromProperties(CHILD_BROWSER_LINKS, "org_childbrowserlink");
		 String CONTACT_PARTIAL_URL=fLib.getDataFromProperties(CHILD_BROWSER_LINKS, "contacts_childbrowserlink");
		/*test script data*/
		int randomNum = jLib.getRandomNumber();

		String OPPORTUNITY_NAME = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "OpportunityTestScipt", "TC_ID_05", "OpportunityName")+"_"+randomNum;
      String ORGANIZATION_NAME = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "OpportunityTestScipt", "TC_ID_05", "OrganizationName");
      String DESCRIPTION = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "OpportunityTestScipt", "TC_ID_05", "TC_NAME");
      String EXP_CLOSE_DATE = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "OpportunityTestScipt", "TC_ID_05", "Date");
		
		/*step 2 : navigate to Opportunity page*/
		
		HomePage homepage=new HomePage(driver);
		homepage.opportunityLink();
		
		/*step 3 :  navigate to create Opportunity page*/
		OpportunityPage oppurPage=new OpportunityPage(driver);
		oppurPage.opportutiesLookUpImg();
		
		/*step 4 :  create Opportunity  With valid name*/
		CreateOpportunityPage cop= new CreateOpportunityPage(driver);
		//Enter OPPName
		cop.opportunityName(OPPORTUNITY_NAME);
		
		//Click on lookUp Image
		cop.relatedToLookUpImge();
	
		//Control Switch to Child browser/Partial browser
	    wLib.swithToWindowBasedOnURL(driver, ORG_PARTIAL_URL);
		ChildWindowPageOrg cwp= new ChildWindowPageOrg(driver);
		cwp.searchText(ORGANIZATION_NAME);
		cwp.clickOnOrgName(driver, ORGANIZATION_NAME);
		// Switch back to parent/main Browser
		wLib.swithToWindowBasedOnURL(driver, URL);
		//Date
		cop.ExpectedCloseDate(jLib,EXP_CLOSE_DATE);
		//description
		cop.descriptionTextBox(DESCRIPTION);
		//save button
		cop.savePage();
		VerifyOpportunitiesPage vop= new VerifyOpportunitiesPage(driver);
		vop.verfyOPPName(OPPORTUNITY_NAME);
		
	
	  
	}
}
