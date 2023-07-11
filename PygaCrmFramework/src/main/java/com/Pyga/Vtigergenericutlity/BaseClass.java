package com.Pyga.Vtigergenericutlity;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.Pyga.VtigerPOM.HomePage;
import com.Pyga.VtigerPOM.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver sdriver=null;
	public WebDriver driver=null;
	public FileUtlity fLib= new FileUtlity();
	public ExcelUtlity eLib = new ExcelUtlity();
	public JavaUtlity jLib = new JavaUtlity();
	public WebActionUtility wLib= new WebActionUtility();
	public DataBaseUtility dLib =new DataBaseUtility();
	public String ENV_FILE_PATH ;
	public String URL;

	@BeforeSuite(groups = {"smokeTest","regTest"})
	public void connectTODB() throws SQLException {
		dLib.connectDB();
		Reporter.log("DataBase is Connected ",true);
	}
	//@Parameters("BROWSER")    //--------> Un Comment While doing Cross BRowser Tesing
	@BeforeClass(groups = {"smokeTest","regTest"})
	public void launchTheBrowser() throws Throwable {
		ENV_FILE_PATH = fLib.getFilePathFromPropertiesFile("projectConfigDataFilePath");
		String BROWSER = fLib.getDataFromProperties(ENV_FILE_PATH, "browser");
		String URL = fLib.getDataFromProperties(ENV_FILE_PATH, "url");
		
		/* FOR PARAMETERS SEND BY USING COMMAND LINE for Normal Execution Comment these TWO lines */
//		String BROWSER=System.getProperty("browser");
//		String URL=System.getProperty("url");
		
		switch (BROWSER) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
	   	default:
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		}
		sdriver=driver;
		wLib.maximizeTheBrowser(driver); 
		driver.get(URL);
		wLib.waitForElementInDOM(driver);
		Reporter.log("BROWSER IS LAUNCHED ",true);
	}
	@BeforeMethod(groups = {"smokeTest","regTest"})
	public void loginToApp() throws Throwable {
		ENV_FILE_PATH=fLib.getFilePathFromPropertiesFile("projectConfigDataFilePath") ;
		String USERNAME = fLib.getDataFromProperties(ENV_FILE_PATH, "username");
		String PASSWORD = fLib.getDataFromProperties(ENV_FILE_PATH, "password");

		LoginPage loginpage=new LoginPage(driver);
		loginpage.logginToAppliction(USERNAME, PASSWORD);
		Reporter.log("Successfully Logged to Application",true);
	}

	@BeforeTest(groups = {"smokeTest","regTest"})
	public void bTest() {

		Reporter.log("BeforeTest",true);   
	}
	@AfterTest(groups = {"smokeTest","regTest"})
	public void aTest() {

		Reporter.log("AfterTest",true);   
	} 
	@AfterMethod(groups = {"smokeTest","regTest"})
	public void logouoFromApp() {
		HomePage homepage=new HomePage(driver);
		homepage.signOut(wLib, driver);
		Reporter.log("Log Out from Application");
	}

	@AfterClass(groups = {"smokeTest","regTest"})
	public void closeTheBrowser() {
		driver.quit();
		Reporter.log("Browser is Closed ",true);
	}
	@AfterSuite(groups = {"smokeTest","regTest"})
	public void closeDB() throws SQLException {
		dLib.closeDB();
		Reporter.log("DataBase connection  is Closed ",true);
	}
}
