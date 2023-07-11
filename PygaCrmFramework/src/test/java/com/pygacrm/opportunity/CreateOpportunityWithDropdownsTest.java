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
public class CreateOpportunityWithDropdownsTest extends BaseClass{

	@Test(retryAnalyzer =com.Pyga.Vtigergenericutlity.RetryImp.class ,groups = {"regTest"})
	public void createOppWithDropdown() throws Throwable {
	/*get the FILE PATH*/
		
		String TEST_SCRIPT_EXCEL_FILE_PATH =fLib.getFilePathFromPropertiesFile("testScriptdatafilePath");
		String CHILD_BROWSER_LINKS = fLib.getFilePathFromPropertiesFile("chlilwindowbrowser");
		String BPATH=fLib.getFilePathFromPropertiesFile("projectConfigDataFilePath");
		String URL=fLib.getDataFromProperties(BPATH, "url");
		/* Set child browser links     */
		 String ORG_CHILDWINDOW_PARTIAL_URL=fLib.getDataFromProperties(CHILD_BROWSER_LINKS, "org_childbrowserlink");
		 //String CONTACT_CHILDWINDOW_PARTIAL_URL=fLib.getDataFromProperties(CHILD_BROWSER_LINKS, "contactchildbrowserlink");
		/*test script data*/
		int randomNum = jLib.getRandomNumber();
         //SalesStageDDValue
		String OPPORTUNITY_NAME = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "OpportunityTestScipt", "TC_ID_02", "OpportunityName")+"_"+randomNum;
        String ORGANIZATION_NAME = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "OpportunityTestScipt", "TC_ID_02", "OrganizationName");
		String DESCRIPTION = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "OpportunityTestScipt", "TC_ID_02", "TC_NAME");
		String LEAD_SOURCE_VALUE = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "OpportunityTestScipt", "TC_ID_02", "LeadSourceDDValue");
		String TYPE_VALUE = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "OpportunityTestScipt", "TC_ID_02", "TypeDDValue");
		String SALES_STAGE_VALUE = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "OpportunityTestScipt", "TC_ID_06", "SalesStageDDValue");
		
		/*step 2 : navigate to Opportunity page*/
		
		HomePage homepage=new HomePage(driver);
		homepage.opportunityLink();
		
		/*step 3 :  navigate to create Opportunity page*/
		OpportunityPage oppurPage=new OpportunityPage(driver);
		oppurPage.opportutiesLookUpImg();
		
		/*step 4 :  create Opportunity  With valid name*/
		CreateOpportunityPage cop= new CreateOpportunityPage(driver);
		//OPPName
		cop.opportunityName(OPPORTUNITY_NAME);
		//Click on lookUp Image
		cop.relatedToLookUpImge();
	
		//Control Switch to Child browser/Partial browser
	    wLib.swithToWindowBasedOnURL(driver, ORG_CHILDWINDOW_PARTIAL_URL);
		ChildWindowPageOrg cwp= new ChildWindowPageOrg(driver);
		cwp.searchText(ORGANIZATION_NAME);
		cwp.clickOnOrgName(driver, ORGANIZATION_NAME);
		// Switch back to parent/main Browser
		wLib.swithToWindowBasedOnURL(driver, URL);
		//Selecting Value from Lead Source Dropdown
		cop.leadSourceDropdown(wLib, LEAD_SOURCE_VALUE);
		//Selecting Value from TYPE Dropdown
		cop.opportunityTypeDropdown(wLib, TYPE_VALUE);
		//selecting value from Sales Stage Dropdown
		cop.salesStageDropdown(wLib, SALES_STAGE_VALUE);
		//Assert.fail();
		//Description
		cop.descriptionTextBox(DESCRIPTION);
		cop.savePage();
		VerifyOpportunitiesPage vop=new VerifyOpportunitiesPage(driver);
		vop.verfyOPPName(OPPORTUNITY_NAME);
		vop.verifyOrgSourceName(driver, ORGANIZATION_NAME);
		
	}
}
