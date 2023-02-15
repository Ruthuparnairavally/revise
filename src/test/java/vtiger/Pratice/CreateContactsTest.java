package vtiger.Pratice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class CreateContactsTest {

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
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step4: Click on create organization lookup image
		driver.findElement(By.xpath("//img[@title = 'Create Contact...']")).click();
		
		//Step5: Create orgnization with mandatory fields
		driver.findElement(By.name("lastname")).sendKeys("ChennigRama");
		
		//Step6: Save
		driver.findElement(By.name("button")).click();
		
		WebElement ele1 = driver.findElement(By.xpath("//td[@class='genHeaderSmall']/following-sibling::td[1]"));
		
		Actions a = new Actions(driver);
		a.moveToElement(ele1).perform();
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		driver.close();
	}
}
