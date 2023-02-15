package vtiger.Organizations.Tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.CreateNewOrgPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrgInfoPage;
import vtiger.ObjectRepository.OrgPage;
import vtigerGenericUtilitu.ExcelFileUtility;
import vtigerGenericUtilitu.JavaUtility;
import vtigerGenericUtilitu.ProppertyFileUtility;
import vtigerGenericUtilitu.WebDriverUtilities;

public class CreateMultipleOrganizationTest {

	 ExcelFileUtility efu = new ExcelFileUtility();
	 JavaUtility ju = new JavaUtility();
	 ProppertyFileUtility pu = new ProppertyFileUtility();
	 WebDriverUtilities wu = new WebDriverUtilities();
	 WebDriver driver;
	 
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException 
	{
		Object[][] data = efu.readMultipleFromExcel("MultipleOrg");
//		readMultipleFromExcel("MultipleOrg");
		System.out.println(data);
		return data;
	}
	 
//	@Test(dataProvider = "readMultipleFromExcel")
	@Test(dataProvider = "getData")
	public void createMultiOrgTest(String org, String industry) throws IOException 
	{
		String BROWSER =pu.readDataFromPropertyFile("browser");
		String URL = pu.readDataFromPropertyFile("url");
		String USERNAME = pu.readDataFromPropertyFile("username");
		String PASSWORD = pu.readDataFromPropertyFile("password");
		
		String ORGNAME = org+ju.getRandomNumber();
				
		//launch the browser
		if(BROWSER.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser name");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		wu.maximiseWindow(driver);
		wu.waitForDomLoad(driver);
		driver.get(URL);
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("loggedIn");
		
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
		System.out.println();
		System.out.println("orgpage");
		
		OrgPage op = new OrgPage(driver);
		op.createorg();
		System.out.println("create orgPage");
		
		CreateNewOrgPage cno = new CreateNewOrgPage(driver);
		cno.createNewOrg(ORGNAME, industry);
		System.out.println("new org created");
		
		//validate
		OrgInfoPage oip = new OrgInfoPage(driver);
		String header = oip.getOrg();
		System.out.println(header);
		
		if(header.contains(ORGNAME))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		
		hp.signOut(driver);
		driver.quit();
	}
		
	
	
}
