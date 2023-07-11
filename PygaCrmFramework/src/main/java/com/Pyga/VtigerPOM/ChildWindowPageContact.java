package com.Pyga.VtigerPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Pyga.Vtigergenericutlity.WebActionUtility;

public class ChildWindowPageContact {
	//Declaration
	@FindBy(id = "search_txt")private WebElement searchtxtInChildWindow;

	@FindBy(name = "search")private WebElement search;
	
	@FindBy(name = "search_field")private WebElement dropdown;
	
	//Initialization
	public ChildWindowPageContact(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//Utilization
	public WebElement getSearchtxtInChildWindow() {
		return searchtxtInChildWindow;
	}
	public WebElement getSearch() {
		return search;
	}
	public WebElement getDropdown() {
		return dropdown;
	}
	
	//--------------------Business Library------------------
	
	
	public void searchText(String CONTACT_NAME) {
		searchtxtInChildWindow.sendKeys(CONTACT_NAME);
		search.click();
	}
	public void clickOnContactName(WebDriver driver,String CONTACT_NAME) {
		 driver.findElement(By.xpath("//a[.='"+CONTACT_NAME+"']")).click();		
		}
	public void dropDown(WebActionUtility w,String TEXT) {
	w.select(dropdown, TEXT);	
	}
}
