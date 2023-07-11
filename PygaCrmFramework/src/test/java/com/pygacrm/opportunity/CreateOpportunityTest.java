package com.pygacrm.opportunity;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Pyga.VtigerPOM.ChildWindowPageOrg;
import com.Pyga.VtigerPOM.CreateOpportunityPage;
import com.Pyga.VtigerPOM.HomePage;
import com.Pyga.VtigerPOM.OpportunityPage;
import com.Pyga.VtigerPOM.VerifyOpportunitiesPage;
import com.Pyga.Vtigergenericutlity.BaseClass;
@Listeners(com.Pyga.Vtigergenericutlity.ListenerImp.class)
public class CreateOpportunityTest extends BaseClass {
	
	@Test(retryAnalyzer =com.Pyga.Vtigergenericutlity.RetryImp.class ,groups = {"smokeTest"})
	public void CreateOpportunityWithName() throws Throwable {
		
		/*get the FILE PATH*/
		String TEST_SCRIPT_EXCEL_FILE_PATH =fLib.getFilePathFromPropertiesFile("testScriptdatafilePath");
		String CHILD_BROWSER_LINKS = fLib.getFilePathFromPropertiesFile("chlilwindowbrowser");
		/* Set child browser links     */
		 String ORG_PARTIAL_URL=fLib.getDataFromProperties(CHILD_BROWSER_LINKS, "org_childbrowserlink");
		 String CONTACT_PARTIAL_URL=fLib.getDataFromProperties(CHILD_BROWSER_LINKS, "contacts_childbrowserlink");
		 String BPATH=fLib.getFilePathFromPropertiesFile("projectConfigDataFilePath");
			String URL=fLib.getDataFromProperties(BPATH, "url");
		 /*test script data*/
		int randomNum = jLib.getRandomNumber();

		String OPPORTUNITY_NAME = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "OpportunityTestScipt", "TC_ID_01", "OpportunityName")+"_"+randomNum;
        String ORGANIZATION_NAME = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "OpportunityTestScipt", "TC_ID_01", "OrganizationName");
		String DESCRIPTION = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "OpportunityTestScipt", "TC_ID_01", "TC_NAME");
		
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
		cop.descriptionTextBox(DESCRIPTION);
		// save the current page After Entering Valid Credentials
		cop.savePage();
		//verifies Entered Credentials
		VerifyOpportunitiesPage vop=new VerifyOpportunitiesPage(driver);
		vop.verfyOPPName(OPPORTUNITY_NAME);
		vop.verifyOrgSourceName(driver, ORGANIZATION_NAME);	
	}
}
