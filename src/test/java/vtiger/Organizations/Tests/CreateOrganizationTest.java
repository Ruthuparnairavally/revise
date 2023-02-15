package vtiger.Organizations.Tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest {
	
	@Test
	public void CreateOrgTest() throws IOException {
		
		WebDriver driver;
		
		Random r = new Random();
		int RANDOM = r.nextInt(500);
		
		
		//Step1: Read all the necessary data
		//read data from property file ----->Common data
		
		FileInputStream fis = new FileInputStream("./src/test/resources/commonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		//read data from excel sheet
		
		FileInputStream fist = new FileInputStream("./src/test/resources/TestData1.xlsx");
		Workbook wb = WorkbookFactory.create(fist);
		
		Sheet sh  = wb.getSheet("Organization");
		
		Row row = sh.getRow(1);
		
		Cell cel = row.getCell(2);
		
		String ORGNAME = cel.getStringCellValue();
		
		//Step2: Launch the browser -- runtime polymorphism		
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("---chrome browser launched---");
		}
		else if(BROWSER.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("---FirefoxDriver browser launched---");
		}
		else
		{
			System.out.println("---invalid browser---");
			driver = new ChromeDriver();
			System.out.println("---chrome browser launched---");
		}
		
		//Step3: login to app
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
	
		driver.findElement(By.linkText("Organizations")).click();
		
		driver.findElement(By.xpath("//img[@title = 'Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME+RANDOM);
		
		driver.findElement(By.name("button")).click();
		
		driver.quit();
	}
}
