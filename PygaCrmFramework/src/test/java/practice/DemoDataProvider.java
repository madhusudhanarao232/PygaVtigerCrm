package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Pyga.Vtigergenericutlity.ExcelUtlity;
import com.Pyga.Vtigergenericutlity.FileUtlity;

public class DemoDataProvider {
	ExcelUtlity eLib=new ExcelUtlity();
	FileUtlity fLib=new FileUtlity();
    WebDriver driver;
	@Test(dataProvider = "loginToaApp")
	public void getLoginDetails(String USERNAME,String PASSWORD) throws Throwable {
		String FILE_PATH_CONFIG = fLib.getFilePathFromPropertiesFile("./config/projectEnvConfig.properties");
		String URL=fLib.getDataFromProperties(FILE_PATH_CONFIG,"url");
		driver.get(URL);
		WebElement UNT = driver.findElement(By.name("user_name"));
		WebElement PT = driver.findElement(By.name("user_password"));
		driver.findElement(By.id("submitButton"));
		Reporter.log(USERNAME+"\t"+PASSWORD);
	} 

@DataProvider
public Object[][] loginToaApp() throws Throwable{
	 
	String FILE_PATH = fLib.getFilePathFromPropertiesFile("./testdata/Login.xlsx");
	Object [][] obj=new Object[7][2];
	
	obj[0][0]=eLib.getDataFromExcelBasedTestId(FILE_PATH, "LoginPage", "TC_01", "USER_NAME");
	obj[0][1]=eLib.getDataFromExcelBasedTestId(FILE_PATH, "LoginPage", "TC_01", "PASSWORD");		
    
	obj[1][0]=eLib.getDataFromExcelBasedTestId(FILE_PATH, "LoginPage", "TC_02", "USER_NAME");
	obj[1][1]=eLib.getDataFromExcelBasedTestId(FILE_PATH, "LoginPage", "TC_02", "PASSWORD");	
	
	obj[2][0]=eLib.getDataFromExcelBasedTestId(FILE_PATH, "LoginPage", "TC_03", "USER_NAME");
	obj[2][1]=eLib.getDataFromExcelBasedTestId(FILE_PATH, "LoginPage", "TC_03", "PASSWORD");	
	
	obj[3][0]=eLib.getDataFromExcelBasedTestId(FILE_PATH, "LoginPage", "TC_04", "USER_NAME");
	obj[3][1]=eLib.getDataFromExcelBasedTestId(FILE_PATH, "LoginPage", "TC_04", "PASSWORD");	
	
	obj[4][0]=eLib.getDataFromExcelBasedTestId(FILE_PATH, "LoginPage", "TC_05", "USER_NAME");
	obj[4][1]=eLib.getDataFromExcelBasedTestId(FILE_PATH, "LoginPage", "TC_05", "PASSWORD");	
	
	obj[5][0]=eLib.getDataFromExcelBasedTestId(FILE_PATH, "LoginPage", "TC_06", "USER_NAME");
	obj[5][1]=eLib.getDataFromExcelBasedTestId(FILE_PATH, "LoginPage", "TC_06", "PASSWORD");	
	
	obj[6][0]=eLib.getDataFromExcelBasedTestId(FILE_PATH, "LoginPage", "TC_07", "USER_NAME");
	obj[6][1]=eLib.getDataFromExcelBasedTestId(FILE_PATH, "LoginPage", "TC_07", "PASSWORD");	
	
	return obj;
}
}
