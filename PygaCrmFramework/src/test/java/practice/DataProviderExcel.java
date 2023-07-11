package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderExcel {
	// Implementing the accepting data in Test method
@Test(dataProvider="data")
	public void login(String un,String pwd)
	{
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	try {
		driver.get("http://rmgtestingserver:8888/");
		System.out.println(pwd);
		System.out.println(un);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();
	} finally {
		driver.close();	
	}
		}
   // Providing data multiple data to dataprovider and it is accepting the multiple data
	@DataProvider
	public Object[][] data() throws EncryptedDocumentException, IOException
	{
	   FileInputStream fis = new FileInputStream("./testdata/Login.xlsx");
	   Workbook wb = WorkbookFactory.create(fis);
	  Sheet sheetName = wb.getSheet("Login");
	  int rowCount = sheetName.getLastRowNum();
	  int cellCount = sheetName.getRow(0).getLastCellNum();
	  Object[][] obj = new Object[rowCount][cellCount];
	  for(int i=0;i<rowCount;i++)
	  {
		  for(int j=0;j<cellCount;j++)
		  {
			  obj[i][j]=sheetName.getRow(i+1).getCell(j).getStringCellValue();
		  }
	  }
	  return obj;
	  
	}
}
