package vtiger.Pratice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtigerGenericUtilitu.WebDriverUtilities;

public class POMpractice {

	public static void main(String[] args) {
		
		WebDriverUtilities wu = new WebDriverUtilities(); 
		
		WebDriverManager.chromedriver().setup();		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		LoginPage lp = new LoginPage(driver);
		//lp.getUserNameEdt().sendKeys("admin");
		//lp.getPassWordEdt().sendKeys("manager");
		//lp.getLoginBtn().click();
		
		lp.loginToApp("admin", "manager");
		System.out.println("HomePage Displayed");
		
		HomePage hp = new HomePage(driver);		
		//hp.getProductsLink();
		//wu.mouseHover(driver, hp.getAdminImage());
		//hp.getSignOut().click();
		
		hp.clickOnOrgLink();
		System.out.println("Organization Page Displayed");
		
		//hp.clickOnOppLink();
		//hp.signOut(driver);
		
		driver.quit();
		
	}
}
