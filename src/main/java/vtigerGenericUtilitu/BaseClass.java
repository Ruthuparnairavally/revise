package vtigerGenericUtilitu;
/**
 * This class consists of all basic configuration annotations of testNG to perform common functionalities
 * @author RUTHUPARNA
 *
 */

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.LoginPage;

public class BaseClass {
	
	public DataBaseUtility du = new DataBaseUtility();
	public ExcelFileUtility eu = new ExcelFileUtility();
	public JavaUtility ju = new JavaUtility();
	public WebDriverUtilities wu = new WebDriverUtilities();
	public ProppertyFileUtility pu = new ProppertyFileUtility();
	public WebDriver driver ;
	
	@BeforeSuite
	public void bsConfig() throws SQLException
	{
		du.connectToDb();
		Reporter.log("-----db connection successful-----", true);
	}
	
	@BeforeClass
	public void bcConfig() throws IOException
	{
		String BROWSER = pu.readDataFromPropertyFile("browser");
		String URL = pu.readDataFromPropertyFile("url");
	
	
		if(BROWSER.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			Reporter.log(BROWSER+"----- successful-----",true);
		}
		else if(BROWSER.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			Reporter.log(BROWSER+"----- successful-----",true);
		}
		else
		{
			System.out.println("invalid browser name");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			Reporter.log(BROWSER+"----- successful-----",true);
		}

		wu.maximiseWindow(driver);
		wu.waitForDomLoad(driver);
		driver.get(URL);
	}
	
	@BeforeMethod
	public void bmConfig() throws IOException
	{
		String USERNAME = pu.readDataFromPropertyFile("username");
		String PASSWORD = pu.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("loggedIn");
	}
	
	
	@AfterClass
	public void acConfig() throws IOException
	{
		driver.quit();
		Reporter.log("----browser closed-----", true);
	}
	
	@AfterSuite
	public void asConfig() throws SQLException 
	{
		du.closeToDb();
		Reporter.log("-----db closed-----", true);
	}
}
