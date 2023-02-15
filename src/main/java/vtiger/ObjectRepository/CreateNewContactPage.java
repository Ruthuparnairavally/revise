package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtigerGenericUtilitu.WebDriverUtilities;

public class CreateNewContactPage extends WebDriverUtilities{


	@FindBy(name = "lastname")
	private WebElement lastNametext;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@title = 'Select']")
	private WebElement OrgImg;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="search")
	private WebElement searcBtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void createNewContact(String lastName, String OrgName, WebDriver driver)
	{
		lastNametext.sendKeys(lastName);
		OrgImg.click();
		switchToWindow(driver, "Accounts");
		searchEdt.sendKeys(OrgName);
		searcBtn.click();
		driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
//		driver.findElement(By.xpath("//a[.='"+OrgName+"']")).click();
		switchToWindow(driver, "Contacts");
		saveBtn.click();
	}
}
