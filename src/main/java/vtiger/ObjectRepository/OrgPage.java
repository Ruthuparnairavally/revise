package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgPage {


	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrganization;

	public OrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOrg() {
		return createOrganization;
	}

	public void createorg() {
		createOrganization.click();
	}
}
