package vtiger.Pratice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOrganizationTest {
	
	public static void main (String [] args)
	{
		
		//Step1: Launch The Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		
		//Step2: Login To app
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
		
		//Step3:Navigate To Organizations Link 
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step4: Click on create organization lookup image
		driver.findElement(By.xpath("//img[@title = 'Create Organization...']")).click();
		
		//Step5: Create orgnization with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys("QSP");
		
		//Step6: Save
		driver.findElement(By.name("button")).click();
		
		driver.close();
	}

}	
	