package com.Pyga.VtigerPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Pyga.Vtigergenericutlity.WebActionUtility;
/** 
 * Home_Page methods are helpful to locates and Navigate
 *  the individual modules present in Home_Page and Obtains Code Optimization 
 *  
 *  @author MadhusudhanaRao Dande
 */
public class HomePage {
	//Declaration
	@FindBy(linkText = "Calendar")private WebElement calendarLink;

	@FindBy(linkText = "Leads")private WebElement leadsLink;

	@FindBy(linkText = "Organizations")private WebElement organisationLink;

	@FindBy(linkText = "Contacts")private WebElement contactsLink;

	@FindBy(linkText = "Opportunities")private WebElement opportunitiesLink;

	@FindBy(linkText = "Products")private WebElement productsLink;

	@FindBy(linkText = "Documents")private WebElement documentsLink;

	@FindBy(linkText = "Email")private WebElement emailLink;

	@FindBy(linkText = "Trouble Tickets")private WebElement trouble_TicketsLink;

	@FindBy(linkText = "Dashboard")private WebElement dashboardLink;

	@FindBy(xpath = "//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement more;
	
	@FindBy(name = "Reports")private WebElement reportsLink;
	
	@FindBy(name = "Campaigns")private WebElement campaignsLink;
	
	@FindBy(name = "Vendors")private WebElement vendorsLink;
	
	@FindBy(name = "Services")private WebElement servicesLink;
	
	@FindBy(name = "Purchase Order")private WebElement purchase_OrderLink;
	
	@FindBy(name = "Price Books")private WebElement price_booksLink;
	
	@FindBy(name = "Invoice")private WebElement invoiceLink;
	
	@FindBy(name = "Sales Order")private WebElement sales_orderLink;
	
	@FindBy(name = "Quotes")private WebElement quotesLink;
	
	@FindBy(name = "Recycle Bin")private WebElement recycle_binLink;
	
	@FindBy(name = "Assets")private WebElement assetsLink;

	//@FindBy(id= "qccombo")private WebElement quickCreate;
	 
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstrator;

	@FindBy(xpath = "//a[.='Sign Out']")private WebElement signoutLink;

	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//utilization
	public WebElement getOrganisationLink() {
		return organisationLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getAdminstrator() {
		return adminstrator;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}


	public WebElement getCalendarLink() {
		return calendarLink;
	}

	public WebElement getLeadsLink() {
		return leadsLink;
	}

	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}

	public WebElement getDocumentsLink() {
		return documentsLink;
	}

	public WebElement getEmailLink() {
		return emailLink;
	}

	public WebElement getTrouble_TicketsLink() {
		return trouble_TicketsLink;
	}

	public WebElement getDashboardLink() {
		return dashboardLink;
	}

	public WebElement getMore() {
		return more;
	}

	public WebElement getReportsLink() {
		return reportsLink;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public WebElement getVendorsLink() {
		return vendorsLink;
	}

	public WebElement getServicesLink() {
		return servicesLink;
	}

	public WebElement getPurchase_OrderLink() {
		return purchase_OrderLink;
	}

	public WebElement getPrice_booksLink() {
		return price_booksLink;
	}

	public WebElement getInvoiceLink() {
		return invoiceLink;
	}

	public WebElement getSales_orderLink() {
		return sales_orderLink;
	}

	public WebElement getQuotesLink() {
		return quotesLink;
	}

	public WebElement getRecycle_binLink() {
		return recycle_binLink;
	}

	public WebElement getAssetsLink() {
		return assetsLink;
	}

	/*  ......Business libraries...............*/
	public void calenderLink()
	{
		calendarLink.click();
	}
	public void leadsLink()
	{
		leadsLink.click();
	}
	public void orgLink()
	{
		organisationLink.click();
	}
	public void contactLink()
	{
		contactsLink.click();
	}
	public void opportunityLink()
	{
		opportunitiesLink.click();
	}
	public void productLink()
	{
		productsLink.click();
	}
	public void documentLink()
	{
		documentsLink.click();
	}
	public void emailLink()
	{
		emailLink.click();
	}
	public void troubleShootLink()
	{
		trouble_TicketsLink.click();
	}
	public void dashboardLink()
	{
		dashboardLink.click();
	}
	public void reportsLink()
	{
		reportsLink.click();
	}
	public void campaignLink()
	{
		campaignsLink.click();
	}
	public void vendorsLink()
	{
		vendorsLink.click();
	}
	public void serviceLink()
	{
		servicesLink.click();
	}
	public void purchaseOrderLink()
	{
		purchase_OrderLink.click();
	}
	public void priceBookLink()
	{
		price_booksLink.click();
	}
	public void invoiceLink()
	{
		invoiceLink.click();
	}
	public void salesOrderLink()
	{
		sales_orderLink.click();
	}
	public void quotesLink()
	{
		quotesLink.click();
	}
	public void recycleBinLink()
	{
		recycle_binLink.click();
	}
	public void assetsLink()
	{
		assetsLink.click();
	}

	public void signOut(WebActionUtility wLib,WebDriver driver)
	{
		wLib.mouseOverOnElement(driver, adminstrator);
		signoutLink.click();
	}
	
}
