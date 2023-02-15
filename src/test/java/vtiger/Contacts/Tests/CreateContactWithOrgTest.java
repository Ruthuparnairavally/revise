package vtiger.Contacts.Tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtigerGenericUtilitu.BaseClass;
import vtigerGenericUtilitu.ExcelFileUtility;
import vtigerGenericUtilitu.JavaUtility;
import vtigerGenericUtilitu.ProppertyFileUtility;
import vtigerGenericUtilitu.WebDriverUtilities;

public class CreateContactWithOrgTest extends BaseClass {

	@Test
	public void CreateContactWithOrgTest() throws IOException {
		
		WebDriver driver;
		
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
	
	String ORGNAME = eu.readDataFromExcel("Organization", 4, 3)+ju.getRandomNumber();
	String LASTNAME = eu.readDataFromExcel("Contact", 4, 2);
	
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
	
	//login to app
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	//navigate to organization link
	driver.findElement(By.linkText("Organizations")).click();
	
	//create organization lookup image
	driver.findElement(By.xpath("//img[@title = 'Create Organization...']")).click();
	
	//Create organization with mandatory fields and save
	driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	System.out.println("organization created");
	
	//validate for organization
	String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(orgHeader.contains(ORGNAME))
	{
		System.out.println("Org Created");
	}
	
	else
	{
		System.out.println("Org not created");
	}
	 
	//navigate to contacts link
	driver.findElement(By.linkText("Contacts")).click();
	
	//click on create contact lookup image
	driver.findElement(By.xpath("//img[@alt = 'Create Contact...']")).click();
	
	//create contact with org and save
	driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
	
	driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title = 'Select']")).click();
	
	//switch from parent to child
	wu.switchToWindow(driver, "Accounts");
	driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
	driver.findElement(By.name("search")).click();
	driver.findElement(By.linkText(ORGNAME)).click();
	
	//switch from child to parent
	wu.switchToWindow(driver, "Contacts");
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	//validate for contacts
	String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	System.out.println(contactHeader);
	if(contactHeader.contains(LASTNAME))
	{
		System.out.println("Contact Created - PASS");
	}
	else
	{
		System.out.println("Contact not Created - FAIL");
	}
	
	//LOGOUT
	WebElement element =  driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	wu.mouseHover(driver, element);
	driver.findElement(By.linkText("Sign Out")).click();
	driver.close();
	}
}
