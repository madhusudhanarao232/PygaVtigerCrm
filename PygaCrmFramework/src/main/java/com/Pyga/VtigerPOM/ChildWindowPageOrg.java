package com.Pyga.VtigerPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChildWindowPageOrg {
	// Declaration
	@FindBy(id = "search_txt")private WebElement searchtxtInChildWindow;

	@FindBy(name = "search")private WebElement search;
	
	//Initialization
	
	public ChildWindowPageOrg(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//Utilization

	public WebElement getSearchtxtInChildWindow() {
		return searchtxtInChildWindow;
	}

	public WebElement getSearch() {
		return search;
	}
	
	/*------------ Business library ------------*/
	public void searchText(String SEARCHTEXT) {
		searchtxtInChildWindow.sendKeys(SEARCHTEXT);
		search.click();
	}
	public void clickOnOrgName(WebDriver driver,String ORGNAME) {
	 driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();		
	}
	
	
	
}
