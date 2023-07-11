package com.pygacrm.opportunity;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Pyga.VtigerPOM.ChildWindowCampaignPage;
import com.Pyga.VtigerPOM.ChildWindowPageOrg;
import com.Pyga.VtigerPOM.CreateOpportunityPage;
import com.Pyga.VtigerPOM.HomePage;
import com.Pyga.VtigerPOM.OpportunityPage;
import com.Pyga.VtigerPOM.VerifyOpportunitiesPage;
import com.Pyga.Vtigergenericutlity.BaseClass;

  @Listeners(com.Pyga.Vtigergenericutlity.ListenerImp.class)
public class CreateOpportuninyAllFieldsTest extends BaseClass {
	  
      @Test(retryAnalyzer =com.Pyga.Vtigergenericutlity.RetryImp.class , groups = {"smokeTest","regressionTest"} )
	public void opportunityWithAllFields() throws Throwable {
		/* Step 1: Get the File paths  */
		String TEST_SCRIPT_FILEPATH = fLib.getFilePathFromPropertiesFile("testScriptdatafilePath");
		String PARTIAL_BROWSER_LINKS = fLib.getFilePathFromPropertiesFile("chlilwindowbrowser");
		String BPATH=fLib.getFilePathFromPropertiesFile("projectConfigDataFilePath");
		String URL=fLib.getDataFromProperties(BPATH, "url");
		/* Step 2: Get the DATA from Files */

		//child browser links
		
		String ORG_PARTIAL_LINKS = fLib.getDataFromProperties(PARTIAL_BROWSER_LINKS,"org_childbrowserlink");
		//String CONTACTS_PARTIAL_LINKS = fLib.getDataFromProperties(PARTIAL_BROWSER_LINKS,"contacts_childbrowserlink");
		String CAMPAIGN_PARTIAL_LINKS = fLib.getDataFromProperties(PARTIAL_BROWSER_LINKS, "campaigns_childbrowserlink");
		//Test Script data
		int randomNum = jLib.getRandomNumber();

		String OPPORTUNITY_NAME = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_FILEPATH, "OpportunityTestScipt", "TC_ID_09", "OpportunityName")+"_"+randomNum;
		String ORGANIZATION_NAME = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_FILEPATH, "OpportunityTestScipt", "TC_ID_09", "OrganizationName");
		String TYPE_DDV = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_FILEPATH, "OpportunityTestScipt", "TC_ID_09", "TypeDDValue");
		String LEAD_SOURCE_DDV = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_FILEPATH, "OpportunityTestScipt", "TC_ID_09", "LeadSourceDDValue");
		String ASSIGNED_TO_DDV = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_FILEPATH, "OpportunityTestScipt", "TC_ID_09", "AssignedToDDValue");
		String CAMPAIGN_NAME = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_FILEPATH, "OpportunityTestScipt", "TC_ID_09", "CampaignSourceName");
		String AMOUNT = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_FILEPATH, "OpportunityTestScipt", "TC_ID_09", "Amount");
		String EXP_CLOSE_DATE = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_FILEPATH, "OpportunityTestScipt", "TC_ID_09", "ExpCloseDate");
		String NEXT_STEP = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_FILEPATH, "OpportunityTestScipt", "TC_ID_09", "NextStep");
		String SALES_STAGE_DDV = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_FILEPATH, "OpportunityTestScipt", "TC_ID_09", "SalesStageDDValue");
		String DESCRIPTION = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_FILEPATH, "OpportunityTestScipt", "TC_ID_09", "Description");
		String PROBABILITY = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_FILEPATH, "OpportunityTestScipt", "TC_ID_09", "Probability");

		/* Step 3: navigate to Opportunity page */

		HomePage hp=new HomePage(driver);
		hp.opportunityLink();

		/* Step 4: navigate to create Opportunity page */

		OpportunityPage op=new OpportunityPage(driver);
		op.opportutiesLookUpImg();

		/* Step 5: Create Opportunity With All Fields */

		CreateOpportunityPage cop= new CreateOpportunityPage(driver);

		// *Opportunity Name
		cop.opportunityName(OPPORTUNITY_NAME);
		//-----< *Related To Organization or Contacts 
		cop.relatedToLookUpImge();
		//Control Switch to Child browser/Partial browser
		wLib.swithToWindowBasedOnURL(driver, ORG_PARTIAL_LINKS);
		ChildWindowPageOrg cworg= new ChildWindowPageOrg(driver);
		cworg.searchText(ORGANIZATION_NAME);
		cworg.clickOnOrgName(driver, ORGANIZATION_NAME);
		// Switch back to parent/main Browser
		wLib.swithToWindowBasedOnURL(driver, URL);
		//-----> Type DD
		cop.opportunityTypeDropdown(wLib, TYPE_DDV);
		//  Lead Source DD
		cop.leadSourceDropdown(wLib, LEAD_SOURCE_DDV);
		// *Assigned To
		cop.assignedToRadio();
		cop.assignedToDropdown(wLib, ASSIGNED_TO_DDV);
		//  ------------< Campaign Source
		cop.campaignSourceLookUpImg();
		//Control Switch to Child browser/Partial browser
		wLib.swithToWindowBasedOnURL(driver, CAMPAIGN_PARTIAL_LINKS);
		ChildWindowCampaignPage cwcam=new ChildWindowCampaignPage(driver);
		cwcam.searchText(CAMPAIGN_NAME);
		cwcam.clickOnCampaignName(driver, CAMPAIGN_NAME);
		// Switch back to parent/main Browser
		wLib.swithToWindowBasedOnURL(driver, URL);
		// -----> Amount: ($)
         cop.amountEditBox(AMOUNT);
		// *Expected Close Date
         cop.sendDate(EXP_CLOSE_DATE);
		//  Next Step
         cop.nextStepEditBox(NEXT_STEP);
		// *Sales Stage
         cop.salesStageDropdown(wLib, SALES_STAGE_DDV);
		//  Probability (%)
         cop.probablityRatio(PROBABILITY);
		//  Description
         cop.descriptionTextBox(DESCRIPTION);
		//--------save--------
         cop.savePage();
		/* Step 6: verification */
         VerifyOpportunitiesPage vop=new VerifyOpportunitiesPage(driver);
         vop.verfyOPPName(OPPORTUNITY_NAME);
         vop.verifyOrgSourceName(driver, LEAD_SOURCE_DDV);
		//--------------------SS
		

	}

}
