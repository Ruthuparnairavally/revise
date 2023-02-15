package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {


	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createContact;

	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateContact() {
		return createContact;
	}

	public void createCon() {
		createContact.click();
	}
}
