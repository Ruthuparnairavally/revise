package vtiger.Contacts.Tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtigerGenericUtilitu.ExcelFileUtility;
import vtigerGenericUtilitu.JavaUtility;
import vtigerGenericUtilitu.ProppertyFileUtility;
import vtigerGenericUtilitu.WebDriverUtilities;

/**
 * 
 * @author RUTHUPARNA
 *
 */
public class CreateContactTest {
	
	@Test
	public void CreateContactTest() throws IOException
	{
		WebDriver driver;
		
		//Step 1: create object for all the utilities
		JavaUtility ju = new JavaUtility();
		ProppertyFileUtility pu = new ProppertyFileUtility();
		ExcelFileUtility eu = new ExcelFileUtility();
		WebDriverUtilities wu = new WebDriverUtilities();
		
		
		//Step 2: Read all the necessary data
		
		String BROWSER = pu.readDataFromPropertyFile("browser");
		String URL = pu.readDataFromPropertyFile("url");
		String USERNAME = pu.readDataFromPropertyFile("username");
		String PASSWORD = pu.readDataFromPropertyFile("password");
		
		String LASTNAME = eu.readDataFromExcel("Contact", 1, 2)+ju.getRandomNumber();
		String LEADSOURCE = eu.readDataFromExcel("Contact", 1, 3);
		
		System.out.println(LASTNAME+" "+LEADSOURCE);
		
		//Step 3: launch the browser
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
		
		//Step 4: login to app
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Step 5: navigate to contacts
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step 6: click on create contact
		driver.findElement(By.xpath("//img[@title = 'Create Contact...']")).click();
		
		//Step 7: create new contact with mandatory information and save
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		WebElement ele = driver.findElement(By.name("leadsource"));
		wu.handleDropDown(LEADSOURCE, ele);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 8: logout
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wu.waitForElementToVisible(driver, element);
		wu.mouseHover(driver, element);
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.quit();
	}
	
}
