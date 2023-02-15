package vtiger.Organizations.Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

public class CreatOrgWithInddustry {

	@Test
	public void CreatOrgWithIndustryTest() throws IOException {
		WebDriver driver = null;
		
		//Create objects for all the utilities
		JavaUtility ju = new JavaUtility();
		ProppertyFileUtility pu = new ProppertyFileUtility();
		ExcelFileUtility eu = new ExcelFileUtility();
		WebDriverUtilities wu = new WebDriverUtilities();
		
		//read all the  data required for test scripts
		
		String BROWSER =pu.readDataFromPropertyFile("browser");
		String URL = pu.readDataFromPropertyFile("url");
		String USERNAME = pu.readDataFromPropertyFile("username");
		String PASSWORD = pu.readDataFromPropertyFile("password");
		
		String ORGNAME = eu.readDataFromExcel("Contact", 4, 3)+ju.getRandomNumber();
		String INDUSTRY = eu.readDataFromExcel("Contact", 4, 4);
		//String TYPE = eu.readDataFromExcel("Contact", 4, 3)+ju.getRandomNumber();
		
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
		System.out.println("home");
		
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
		System.out.println("Orgpage");
		
		OrgPage op = new OrgPage(driver);
		op.createorg();
		System.out.println("create org");
		
		CreateNewOrgPage cno = new CreateNewOrgPage(driver);
		cno.createNewOrg(ORGNAME, INDUSTRY);
		System.out.println("create org");
		
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
		System.out.println("Signed out");
		
		driver.quit();
	}
}
