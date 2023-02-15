package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoPage {

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrgHeader;
	
	public OrgInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	public WebElement getOrgHeader() {
		return OrgHeader;
	}
	
	public String getOrg()
	{
		return OrgHeader.getText();
	}
}
